package br.com.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe responsável por representar um bitcoin
 * @author jlv
 *
 */
public class Bitcoin {

	private Long id;
	
	private BigDecimal preco;
	
	private String tipo;
	
	private LocalDate data;
	
	public Bitcoin() {}

	public Bitcoin(Long id, BigDecimal preco, String tipo, LocalDate data) {
		
		super();
		this.id = id;
		this.preco = preco;
		this.tipo = tipo;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
