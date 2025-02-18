package com.caio.evento.dtos;

import java.math.BigDecimal;

public class AtividadeDTO {
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private String descricaoCategoria;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}
	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	
	public AtividadeDTO(String nome, String descricao, BigDecimal preco, String descricaoCategoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.descricaoCategoria = descricaoCategoria;
	}
	public AtividadeDTO() {
		super();
	}
	
	
}
