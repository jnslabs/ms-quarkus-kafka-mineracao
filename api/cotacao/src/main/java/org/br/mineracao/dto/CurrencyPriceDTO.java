package org.br.mineracao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 13:34
 */

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPriceDTO {

    public USDBRL USDBRL;
}
