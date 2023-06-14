package org.br.mineracao.service.impl;

import org.br.mineracao.client.ReportRestClient;
import org.br.mineracao.dto.OpportunityDTO;
import org.br.mineracao.service.ReportService;
import org.br.mineracao.util.CSVHelper;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 14/06/2023 - 09:20
 */
@ApplicationScoped
public class ReportServiceImpl implements ReportService {

    @Inject
    @RestClient
    ReportRestClient reportRestClient;

    @Override
    public ByteArrayInputStream generateCSVOpportunityReport() {
        List<OpportunityDTO> opportunityData = reportRestClient.requestOpportunitiesData();
        return CSVHelper.OpportunitiesToCSV(opportunityData);
    }

    @Override
    public List<OpportunityDTO> getOpportunitiesData() {
        return reportRestClient.requestOpportunitiesData();
    }
}
