package br.com.transacao.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.transacao.model.Bitcoin;

/**
 * Class de servico responsável por acessar uma URL externa
 * @author jlv
 *
 */
@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api") // habilita o serviço a ser injetado
public interface BitcoinService {

	/**
	 * Lista os bitcoins acessando uma api externa.
	 * Url configurada no application.properties
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar();
}
