package org.br.mineracao.controller;

import io.quarkus.security.Authenticated;
import org.br.mineracao.dto.OpportunityDTO;
import org.br.mineracao.service.OpportunityService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 25/05/2023 - 17:20
 */

@Path("/api/opportunity")
@Authenticated
public class OpportunityController {

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    OpportunityService opportunityService;

//    @GET
//    @Path("/report")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    public Response generateReport() {
//
//        try {
//            return Response.ok(opportunityService.generateCSVOpportunityReport(),
//                    MediaType.APPLICATION_OCTET_STREAM)
//                    .header("content-disposition",
//                            "attachment; filename = " + new Date() + "--oportunidades-venda.csv")
//                    .build();
//        } catch (ServerErrorException errorException) {
//            return Response.serverError().build();
//        }
//
//
//    }

    @GET
    @Path("/data")
    @RolesAllowed({"user", "manager"})
    public List<OpportunityDTO> generateReport() {
        return opportunityService.generateOpportunityData();
    }

}
