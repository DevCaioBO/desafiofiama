package com.caio.evento.dtos;

import java.math.BigDecimal;

public class AtividadeDoParticipanteDTO {
	
	private String nome_participante;
	
	private String email;
	
	private String descricao;
	
	private String nome_atividade;
	
	private BigDecimal preco;

	public String getNome_participante() {
		return nome_participante;
	}

	public void setNome_participante(String nome_participante) {
		this.nome_participante = nome_participante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome_atividade() {
		return nome_atividade;
	}

	public void setNome_atividade(String nome_atividade) {
		this.nome_atividade = nome_atividade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public AtividadeDoParticipanteDTO(String nome_participante, String email, String descricao, String nome_atividade,
			BigDecimal preco) {
		super();
		this.nome_participante = nome_participante;
		this.email = email;
		this.descricao = descricao;
		this.nome_atividade = nome_atividade;
		this.preco = preco;
	}

	public AtividadeDoParticipanteDTO() {
		super();
	}
	
	
}
