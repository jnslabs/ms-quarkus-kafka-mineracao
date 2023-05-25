package org.br.mineracao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.br.mineracao.entity.OpportunityEntity;

import javax.enterprise.context.ApplicationScoped;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 18:28
 */
@ApplicationScoped
public class OpportunityRepository implements PanacheRepository<OpportunityEntity> {
}
