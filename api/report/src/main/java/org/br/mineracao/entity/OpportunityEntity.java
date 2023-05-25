package org.br.mineracao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 17:41
 */

@Entity
@Table(name = "opportunity")
@Data
@NoArgsConstructor
public class OpportunityEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @Column(name = "proposal_id")
    private Long proposalId;

    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    @Column(name = "last_currency_quotation")
    private BigDecimal lastDollarQuotation;

}
