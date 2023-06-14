package org.br.mineracao.service.impl;

import org.br.mineracao.dto.OpportunityDTO;
import org.br.mineracao.service.ReportService;

import javax.enterprise.context.ApplicationScoped;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 14/06/2023 - 09:20
 */
@ApplicationScoped
public class ReportServiceImpl implements ReportService {
    @Override
    public ByteArrayInputStream generateCSVOpportunityReport() {
        return null;
    }

    @Override
    public List<OpportunityDTO> getOpportunitiesData() {
        return null;
    }
}
