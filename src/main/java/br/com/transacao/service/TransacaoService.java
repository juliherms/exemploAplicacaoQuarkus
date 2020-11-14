package br.com.transacao.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import br.com.transacao.model.Transacao;
import br.com.transacao.repository.TransacaoRepository;

/**
 * Classe de service responsável por regras de negócio e acesso a banco de dados
 * 
 * @author jlv
 *
 */
@ApplicationScoped
public class TransacaoService {

	@Inject
	TransacaoRepository transacaoRepository;

	@Inject
	@Channel("transacoes")
	Emitter<String> emitter;

	public void save(Transacao t) {

		this.enviarTransacao(t);
		transacaoRepository.persist(t);
	}

	public List<Transacao> listar() {
		return transacaoRepository.listAll();
	}

	/**
	 * Método responsável por enviar uma transacao em formato json via fila
	 * @param t
	 */
	private void enviarTransacao(Transacao t) {

		Jsonb create = JsonbBuilder.create();
		String json = create.toJson(t);
		emitter.send(json);
	}

}
