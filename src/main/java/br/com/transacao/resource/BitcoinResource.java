package br.com.transacao.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.transacao.model.Bitcoin;
import br.com.transacao.service.BitcoinService;

/**
 * Resource responsável por disponibilizar os endpoints de bitcoins
 * @author jlv
 *
 */
@Path("/bitcoins")
public class BitcoinResource {
	
	@Inject
	@RestClient
	BitcoinService bitcoinService;

	/**
	 * Metodo responsavel por listar todos os bitcoins
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar(){
		return bitcoinService.listar();
	}
}
