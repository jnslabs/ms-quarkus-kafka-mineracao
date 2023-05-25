package org.br.mineracao.controller;

import org.br.mineracao.dto.OpportunityDTO;
import org.br.mineracao.service.OpportunityService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 25/05/2023 - 17:20
 */

@Path("/api/opportunity")
public class OpportunityController {

    @Inject
    OpportunityService opportunityService;

    @GET
    @Path("/data")
    public List<OpportunityDTO> generateReport(){

        return opportunityService.generateOpportunityData();

    }

}
