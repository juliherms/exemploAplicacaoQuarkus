package br.com.transacao.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		Usuario.adicionar(usuario);
	}

	/**
	 * Lista todos os usuarios do sistema.
	 * @return
	 */
	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() {
		return Usuario.listAll();
	}

}
