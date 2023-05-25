package org.br.mineracao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 17:45
 */
@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class OpportunityDTO {

    private Long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    private BigDecimal lastDollarQuotation;

}
