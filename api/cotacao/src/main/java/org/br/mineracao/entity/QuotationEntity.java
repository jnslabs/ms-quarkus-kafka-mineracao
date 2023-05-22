package org.br.mineracao.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 12:56
 */

@Entity
@Table(name = "quotation")
@Data
@NoArgsConstructor
public class QuotationEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @Column(name = "currency_price")
    private BigDecimal currencyPrice;

    @Column(name = "pct_change")
    private String pctChange;

    private String pair;
}
