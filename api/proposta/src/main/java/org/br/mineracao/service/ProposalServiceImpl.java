package org.br.mineracao.service;

import org.br.mineracao.dto.ProposalDTO;
import org.br.mineracao.dto.ProposalDetailsDTO;
import org.br.mineracao.entity.ProposalEntity;
import org.br.mineracao.message.KafkaEvent;
import org.br.mineracao.repository.ProposalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * @Autor Jairo Nascimento
 * @Created 22/05/2023 - 18:12
 */

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    ProposalRepository proposalRepository;

    @Inject
    KafkaEvent kafkaMessage;

    @Override
    public ProposalDetailsDTO findFullProposal(Long id) {
        ProposalEntity proposal = proposalRepository.findById(id);

        return ProposalDetailsDTO.builder()
                .proposalId(proposal.getId())
                .country(proposal.getCountry())
                .priceTonne(proposal.getPriceTonne())
                .tonnes(proposal.getTonnes())
                .proposalValidityDays(proposal.getProposalValidityDays())
                .build();
    }

    @Override
    @Transactional
    public void createNewProposal(ProposalDetailsDTO proposalDetailsDTO) {
        ProposalDTO proposalDTO = buildAndSaveNewProposal(proposalDetailsDTO);
        kafkaMessage.sendNewKafkaEvent(proposalDTO);
    }

    @Override
    @Transactional
    public void removeProposal(Long id) {
        proposalRepository.deleteById(id);
    }

    private ProposalDTO buildAndSaveNewProposal(ProposalDetailsDTO proposalDetailsDTO) {

        try {

            ProposalEntity proposalEntity = new ProposalEntity();
            proposalEntity.setCreated(new Date());
            proposalEntity.setProposalValidityDays(proposalDetailsDTO.getProposalValidityDays());
            proposalEntity.setCountry(proposalDetailsDTO.getCountry());
            proposalEntity.setCustomer(proposalDetailsDTO.getCustomer());
            proposalEntity.setPriceTonne(proposalDetailsDTO.getPriceTonne());
            proposalEntity.setTonnes(proposalDetailsDTO.getTonnes());

            proposalRepository.persist(proposalEntity);

            return ProposalDTO.builder()
                    .proposalId(proposalRepository.findByCustomer(proposalEntity.getCustomer()).get().getId())
                    .priceTonne(proposalEntity.getPriceTonne())
                    .customer(proposalEntity.getCustomer())
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
