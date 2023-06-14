package org.br.mineracao.controller;

import org.br.mineracao.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
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
 * @Created 14/06/2023 - 10:04
 */
@Path("/api/opportunity")
public class ReportController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    ReportService reportService;

    @GET
    @Path("/report")
    @RolesAllowed({"user", "manager"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateReport() {

        try {
            return Response.ok(reportService.generateCSVOpportunityReport(),
                    MediaType.APPLICATION_OCTET_STREAM)
                    .header("content-disposition",
                            "attachment; filename = " + new Date() + "--oprtunidades-venda.csv")
                    .build();
        } catch (ServerErrorException errorException) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/data")
    @RolesAllowed({"user", "manager"})
    public Response generateOpportunityesData() {

        try {
            return Response.ok(reportService.getOpportunitiesData(),
                    MediaType.APPLICATION_JSON)
                    .build();
        } catch (ServerErrorException errorException) {
            return Response.serverError().build();
        }
    }

}
