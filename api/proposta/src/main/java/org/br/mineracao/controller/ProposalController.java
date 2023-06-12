package org.br.mineracao.controller;

import io.quarkus.security.Authenticated;
import org.br.mineracao.dto.ProposalDetailsDTO;
import org.br.mineracao.service.ProposalService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 14:54
 */

@Path("/api/proposal")
@Authenticated
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"user", "manager"})
    public ProposalDetailsDTO findDetailsProposal(@PathParam("id") Long id) {
        return proposalService.findFullProposal(id);
    }

    @POST
    @RolesAllowed("proposal-customer")
    public Response createProposal(ProposalDetailsDTO proposalDetails) {
        LOG.info(" --- Recebendo Proposta de Compra --");

        try {
            proposalService.createNewProposal(proposalDetails);
            return Response.created(null).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    public Response removeProposal(@PathParam("id") Long id) {
        try {
            proposalService.removeProposal(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
