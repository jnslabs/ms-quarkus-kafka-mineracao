package org.br.mineracao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.br.mineracao.entity.QuotationEntity;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 13:22
 */
@ApplicationScoped
public class QuotationRepository implements PanacheRepository<QuotationEntity> {
}
