package org.br.mineracao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Autor Jairo Nascimento
 * @Created 23/05/2023 - 18:21
 */

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class QuotationDTO {

    private Date date;

    private BigDecimal currencyPrice;

}
