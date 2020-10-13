package br.com.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

/**
 * Representa um usuário no sistema
 * 
 * A extensao do panacheEntityBase implementa o padrão activeRecords
 * 
 * @author jlv
 *
 */
@Entity
@UserDefinition // essa entidade é quem tem as informações de segurança de usuario
public class Usuario extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String cpf;

	@Username
	private String username;

	@Password
	private String password;

	@Roles
	private String role;

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Metodo responsavel por encriptar a senha do usuario
	 * 
	 * @param usuario
	 */
	public static void adicionar(Usuario usuario) {
		usuario.password = BcryptUtil.bcryptHash(usuario.password);
		usuario.role = validarUsername(usuario.username);
		usuario.persist();
	}

	private static String validarUsername(String username) {
		if (username.equals("teste")) {
			return "admin";
		}
		return "user";
	}
}
