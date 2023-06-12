package org.br.mineracao.service;

import org.br.mineracao.dto.OpportunityDTO;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 12/06/2023 - 15:27
 */
public interface ReportService {

    ByteArrayInputStream generateCSVOpportunityReport();

    List<OpportunityDTO> getOpportunitiesData();
}
