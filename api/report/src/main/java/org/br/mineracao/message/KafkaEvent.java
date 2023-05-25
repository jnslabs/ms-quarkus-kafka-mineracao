package org.br.mineracao.message;

import io.smallrye.reactive.messaging.annotations.Blocking;
import org.br.mineracao.dto.ProposalDTO;
import org.br.mineracao.dto.QuotationDTO;
import org.br.mineracao.service.OpportunityService;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 18:23
 */
public class KafkaEvent {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    OpportunityService opportunityService;

    @Incoming("proposal")
    @Transactional
    public void receiveProposal(ProposalDTO proposal){
        LOG.info("-- Recebendo Nova Proposta do Tópico Kafka --");
        opportunityService.buildOpportunity(proposal);
    }

    @Incoming("quotation")
    @Blocking
    public void receiveQuotation(QuotationDTO quotation){
        LOG.info("-- Recebendo Nova Cotação de Moeda do Tópico Kafka --");
        opportunityService.saveQuotation(quotation);
    }

}
