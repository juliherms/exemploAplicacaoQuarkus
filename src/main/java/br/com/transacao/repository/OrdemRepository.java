package br.com.transacao.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.transacao.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * Representa um repositorio de Ordem
 * ApplicationScoped -> apenas uma alocação de memória.
 * @author jlv
 *
 */
@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {

}
