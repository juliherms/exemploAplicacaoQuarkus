package br.com.transacao.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.transacao.model.Transacao;
import br.com.transacao.repository.TransacaoRepository;

/**
 * Classe de service responsável por regras de negócio e acesso a banco de dados
 * @author jlv
 *
 */
@ApplicationScoped
public class TransacaoService {

	@Inject
	TransacaoRepository transacaoRepository;

	public void save(Transacao t) {

		transacaoRepository.persist(t);
	}
	
	public List<Transacao> listar() {
		return transacaoRepository.listAll();
	}
	
	
}
