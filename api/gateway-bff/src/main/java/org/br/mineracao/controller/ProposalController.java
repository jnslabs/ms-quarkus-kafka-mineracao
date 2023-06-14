package org.br.mineracao.controller;

import org.br.mineracao.dto.ProposalDetailsDTO;
import org.br.mineracao.service.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 14:54
 */


@Path("/api/trade")
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"user", "manager"})
    public Response getProposalDetailsById(@PathParam("id") Long id) {

        LOG.info(" --- Buscando Proposta de Compra pelo ID: %s --", id);

        try {
            return Response.ok(proposalService.getProposalDetailsById(id),
                    MediaType.APPLICATION_JSON).build();

        } catch (ServerErrorException errorException) {
            return Response.serverError().build();
        }
    }

    @POST
    @RolesAllowed("proposal-customer")
    public Response createNewProposal(ProposalDetailsDTO proposalDetails) {
        LOG.info(" --- Recebendo Proposta de Compra --");

        int proposalRequestStatus = proposalService.createProposal(proposalDetails).getStatus();

        if (proposalRequestStatus > 199 || proposalRequestStatus < 205) {
            return Response.ok().build();
        } else {
            return Response.status(proposalRequestStatus).build();
        }

    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    public Response removeProposal(@PathParam("id") Long id) {
        LOG.info(" --- Excluido Proposta de Compra --");

        int proposalRequestStatus = proposalService.removeProposal(id).getStatus();

        if (proposalRequestStatus > 199 || proposalRequestStatus < 205) {
            return Response.ok().build();
        } else {
            return Response.status(proposalRequestStatus).build();
        }
    }
}
