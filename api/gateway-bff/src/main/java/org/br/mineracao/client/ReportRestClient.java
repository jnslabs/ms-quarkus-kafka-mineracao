package org.br.mineracao.client;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import org.br.mineracao.dto.OpportunityDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 12/06/2023 - 15:38
 */

@Path("/api/opportunity")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@ApplicationScoped
public interface ReportRestClient {

    @GET
    @Path("/data")
    List<OpportunityDTO> requestOpportunitiesData();
}
