package br.com.transacao.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.transacao.model.Transacao;
import br.com.transacao.service.TransacaoService;

/**
 * Classe responsável por representar um endpoint de Transacoes
 * 
 * @author jlv
 *
 */
@Path("/transacoes")
@Tag(name = "transacoes")
public class TransacaoResource {

	@Inject
	TransacaoService transacaoService;

	/**
	 * Metodo responsável por inserir uma transacao
	 * 
	 * @param ordem
	 */
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Operation(description = "Recebe uma transação e processa o seu pagamento", summary = "Processa uma transaçao")
	@APIResponse(responseCode = "201", description = "Caso a transacao seja processada com sucesso")
	public Response inserir(Transacao transacao) {

		transacaoService.save(transacao);
		return Response.status(Status.CREATED).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Exibe as transações processadas", summary = "Lista as transações")
	@Counted(name = "Quantidade de listagem de transacoes") //conta quantas vezes o método foi chamado
	@SimplyTimed(name = "Tempo simples da busca de listagem de transacaoes") //o tempo que demorou a média de requisições
	@Timed(name = "Tempo completo de listagem de transacoes") // disponibiliza vários agrupamentos
	public List<Transacao> listar() {

		return transacaoService.listar();
	}

}
