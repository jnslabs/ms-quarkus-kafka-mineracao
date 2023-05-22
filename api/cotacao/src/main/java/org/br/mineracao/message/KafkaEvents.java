package org.br.mineracao.message;

import javax.enterprise.context.ApplicationScoped;
import org.br.mineracao.dto.QuotationDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 15:29
 */
@ApplicationScoped
public class KafkaEvents {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Channel("quotation-channel")
    Emitter<QuotationDTO> quotationRequestEmitter;

    public void sendNewKafkaEvent(QuotationDTO quotation) {
        LOG.info("--- Enviando Cotação para Tópico Kafka --");
        quotationRequestEmitter.send(quotation).toCompletableFuture().join();
    }
}
