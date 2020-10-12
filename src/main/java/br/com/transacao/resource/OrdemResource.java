package br.com.transacao.resource;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.transacao.model.Ordem;
import br.com.transacao.repository.OrdemRepository;

/**
 * Classe responsável por representar um endpoint de Ordens
 * 
 * @author jlv
 *
 */
@Path("/ordens")
public class OrdemResource {

	@Inject
	OrdemRepository ordemRepository;

	/**
	 * Metodo responsável por inserir uma ordem
	 * @param ordem
	 */
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Ordem ordem) {

		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");

		ordemRepository.persist(ordem);
	}
}
