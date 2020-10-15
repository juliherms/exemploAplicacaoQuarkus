package br.com.transacao.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.transacao.model.Transacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * Representa um repositorio de Ordem
 * @author jlv
 *
 */
@ApplicationScoped
public class TransacaoRepository implements PanacheRepository<Transacao> {

}
