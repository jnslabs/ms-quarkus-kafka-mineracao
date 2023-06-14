package org.br.mineracao.service.impl;

import org.br.mineracao.client.ProposalRestClient;
import org.br.mineracao.dto.ProposalDetailsDTO;
import org.br.mineracao.service.ProposalService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * @Autor Jairo Nascimento
 * @Created 14/06/2023 - 09:19
 */
@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    @RestClient
    ProposalRestClient proposalRestClient;

    @Override
    public ProposalDetailsDTO getProposalDetailsById(Long proposalId) {
        return proposalRestClient.getProposalDetailsById(proposalId);
    }

    @Override
    public Response createProposal(ProposalDetailsDTO proposalDetailsDTO) {
        return proposalRestClient.createProposal(proposalDetailsDTO);
    }

    @Override
    public Response removeProposal(Long id) {
        return proposalRestClient.removeProposal(id);
    }
}
