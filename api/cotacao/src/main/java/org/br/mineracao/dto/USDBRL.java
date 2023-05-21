package org.br.mineracao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 13:26
 */

@Jacksonized
@Data
@Builder
@AllArgsConstructor
public class USDBRL {

    public String code;
    public String codein;
    public String name;
    public String high;
    public String low;
    public String varBid;
    public String pctChange;
    public String bid;
    public String ask;
    public String timestamp;
    public String create_date;
}
