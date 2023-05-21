package org.br.mineracao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 13:34
 */

@Jacksonized
@Data
@Builder
@AllArgsConstructor
public class CurrencyPriceDTO {

    public USDBRL USDBRL;
}
