package org.br.mineracao.service;

import org.br.mineracao.client.CurrencyPriceClient;
import org.br.mineracao.dto.CurrencyPriceDTO;
import org.br.mineracao.dto.QuotationDTO;
import org.br.mineracao.entity.QuotationEntity;
import org.br.mineracao.message.KafkaEvents;
import org.br.mineracao.repository.QuotationRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 15:47
 */

@ApplicationScoped
public class QuotationService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    @RestClient
    CurrencyPriceClient currencyPriceClient;

    @Inject
    QuotationRepository quotationRepository;

    @Inject
    KafkaEvents kafkaEvents;

    public void getCurrencyPrice() {

        LOG.info("--- Executando chamada currencyPrice --");

        CurrencyPriceDTO currencyPriceInfo = currencyPriceClient.getPricePair("USD-BRL");

        LOG.info("--- Finalizacao chamada currencyPrice // COTACAO DOLLAR: {} --", currencyPriceInfo.getUSDBRL().bid);

        if (updateCurrentInfoPrice(currencyPriceInfo)) {
            kafkaEvents.sendNewKafkaEvent(QuotationDTO
                    .builder()
                    .currencyPrice(new BigDecimal(currencyPriceInfo.getUSDBRL().bid))
                    .date(new Date())
                    .build());
        }
    }

    private boolean updateCurrentInfoPrice(CurrencyPriceDTO currencyPriceInfo) {

        BigDecimal currentPrice = new BigDecimal(currencyPriceInfo.getUSDBRL().getBid());
        AtomicBoolean updatePrice = new AtomicBoolean(false); // é recomendado em utilizar lambda

        List<QuotationEntity> quotationList = quotationRepository.findAll().list();

        if (quotationList.isEmpty()) {
            saveQuotation(currencyPriceInfo);
            updatePrice.set(true);
        } else {
            QuotationEntity lastDollarPrice = quotationList
                    .get(quotationList.size() - 1);

            if (currentPrice.floatValue() > lastDollarPrice.getCurrencyPrice().floatValue()) {
                updatePrice.set(true);
                saveQuotation(currencyPriceInfo);
            }
        }
        return updatePrice.get();
    }

    private void saveQuotation(CurrencyPriceDTO currencyPriceInfo) {
        QuotationEntity quotation = new QuotationEntity();
        quotation.setDate(new Date());
        quotation.setCurrencyPrice(new BigDecimal(currencyPriceInfo.getUSDBRL().bid));
        quotation.setPctChange(currencyPriceInfo.getUSDBRL().getPctChange());
        quotation.setPair("USD-BRL");

        quotationRepository.persist(quotation);
    }

}
