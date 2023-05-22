package org.br.mineracao.service;

import org.br.mineracao.dto.ProposalDetailsDTO;

import javax.enterprise.context.ApplicationScoped;

/**
 * @Autor Jairo Nascimento
 * @Created 22/05/2023 - 18:05
 */
@ApplicationScoped
public interface ProposalService {

    ProposalDetailsDTO findFullProposal(Long id);

    void createNewProposal(ProposalDetailsDTO proposalDetailsDTO);

    void removeProposal(Long id);

}
