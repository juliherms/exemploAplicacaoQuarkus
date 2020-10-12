package br.com.transacao.resource;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.transacao.model.Usuario;

/**
 * Implementa o endpoint de usuarios
 * 
 * @author jlv
 *
 */
@Path("/usuarios")
public class UsuarioResource {

	/**
	 * Insere um usuario no banco de dados
	 * 
	 * @param usuario
	 */
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		Usuario.persist(usuario);
	}

}
