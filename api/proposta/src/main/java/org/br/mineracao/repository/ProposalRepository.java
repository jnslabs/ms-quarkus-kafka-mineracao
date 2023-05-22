package org.br.mineracao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.br.mineracao.entity.ProposalEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

/**
 * @Autor Jairo Nascimento
 * @Created 22/05/2023 - 17:37
 */

@ApplicationScoped
public class ProposalRepository implements PanacheRepository<ProposalEntity> {

    public Optional<ProposalEntity> findByCustomer(String customer) {
        return find("customer", customer).firstResultOptional();
    }
}
