package org.br.mineracao.service;

import org.br.mineracao.dto.OpportunityDTO;
import org.br.mineracao.dto.ProposalDTO;
import org.br.mineracao.dto.QuotationDTO;
import org.br.mineracao.entity.OpportunityEntity;
import org.br.mineracao.entity.QuotationEntity;
import org.br.mineracao.repository.OpportunityRepository;
import org.br.mineracao.repository.QuotationRepository;
import org.br.mineracao.util.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 18:26
 */

@ApplicationScoped
//@Traced
public class OpportunityServiceImpl implements OpportunityService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    QuotationRepository quotationRepository;

    @Inject
    OpportunityRepository opportunityRepository;

    @Override
    @Transactional
    public void buildOpportunity(ProposalDTO proposal) {

        LOG.info("Salvando uma Oportunidade no Banco de Dados");

        List<QuotationEntity> quotationEntities = quotationRepository.findAll().list();
        Collections.reverse(quotationEntities);

        OpportunityEntity opportunity = new OpportunityEntity();
        opportunity.setDate(new Date());
        opportunity.setProposalId(proposal.getProposalId());
        opportunity.setCustomer(proposal.getCustomer());
        opportunity.setPriceTonne(proposal.getPriceTonne());
        opportunity.setLastDollarQuotation(quotationEntities.get(0).getCurrencyPrice());

        opportunityRepository.persist(opportunity);

    }

    @Override
    @Transactional
    public void saveQuotation(QuotationDTO quotation) {

        LOG.info("Salvando quotação no banco de dados.");

        QuotationEntity createQuotation = new QuotationEntity();
        createQuotation.setDate(new Date());
        createQuotation.setCurrencyPrice(quotation.getCurrencyPrice());

        quotationRepository.persist(createQuotation);

    }

    @Override
    public List<OpportunityDTO> generateOpportunityData() {
        List<OpportunityDTO> opportunities = new ArrayList<>();

        opportunityRepository
                .findAll()
                .stream()
                .forEach(item -> {
                    opportunities.add(OpportunityDTO.builder()
                            .proposalId(item.getProposalId())
                            .customer(item.getCustomer())
                            .priceTonne(item.getPriceTonne())
                            .lastDollarQuotation(item.getLastDollarQuotation())
                            .build());
                });

        return opportunities;

    }

//    @Override
//    public ByteArrayInputStream generateCSVOpportunityReport() {
//
//        List<OpportunityDTO> opportunityList = new ArrayList<>();
//
//        opportunityRepository.findAll().list()
//                .forEach(item -> {
//                    opportunityList.add(OpportunityDTO.builder()
//                            .proposalId(item.getProposalId())
//                            .customer(item.getCustomer())
//                            .priceTonne(item.getPriceTonne())
//                            .lastDollarQuotation(item.getLastDollarQuotation())
//                            .build());
//                });
//
//        return CSVHelper.OpportunitiesToCSV(opportunityList);
//    }
}
