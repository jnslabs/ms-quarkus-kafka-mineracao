package org.br.mineracao.service;

import org.br.mineracao.dto.ProposalDetailsDTO;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @Autor Jairo Nascimento
 * @Created 12/06/2023 - 15:18
 */
public interface ProposalService {

    ProposalDetailsDTO getProposalDetailsById(@PathParam("id") Long proposalId);

    Response createProposal(ProposalDetailsDTO proposalDetailsDTO);

    Response removeProposal(Long id);
}
