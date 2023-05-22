package org.br.mineracao.client;

import org.br.mineracao.dto.CurrencyPriceDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @Autor Jairo Nascimento
 * @Created 21/05/2023 - 13:37
 */

@Path("/last")
@RegisterRestClient
@ApplicationScoped
public interface CurrencyPriceClient {

    @GET
    @Path("/{pair}")
    CurrencyPriceDTO getPricePair(@PathParam("pair") String pair);
}
