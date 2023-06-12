package org.br.mineracao.service;

import org.br.mineracao.dto.OpportunityDTO;
import org.br.mineracao.dto.ProposalDTO;
import org.br.mineracao.dto.QuotationDTO;

import javax.enterprise.context.ApplicationScoped;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 18:24
 */

public interface OpportunityService {

    void buildOpportunity(ProposalDTO proposal);

    void saveQuotation(QuotationDTO quotation);

    List<OpportunityDTO> generateOpportunityData();

//    ByteArrayInputStream generateCSVOpportunityReport();

}
