package org.br.mineracao.controller;

import org.br.mineracao.service.OpportunityService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * @Autor Jairo Nascimento
 * @Created 25/05/2023 - 17:20
 */

@Path("/api/opportunity")
public class OpportunityController {

    @Inject
    OpportunityService opportunityService;

    @GET
    @Path("/report")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateReport() {

        try {
            return Response.ok(opportunityService.generateCSVOpportunityReport(),
                    MediaType.APPLICATION_OCTET_STREAM)
                    .header("content-disposition",
                            "attachment; filename = " + new Date() + "--oportunidades-venda.csv")
                    .build();
        } catch (ServerErrorException errorException) {
            return Response.serverError().build();
        }


    }

}
