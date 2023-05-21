package org.br.mineracao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 13:32
 */
@Jacksonized
@Data
@Builder
@AllArgsConstructor
public class QuotationDTO {

    private Date date;

    private BigDecimal currencyPrice;
}
