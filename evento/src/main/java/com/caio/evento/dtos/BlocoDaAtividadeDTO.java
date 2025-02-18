package com.caio.evento.dtos;

import java.time.Instant;

public class BlocoDaAtividadeDTO {
	
	private Instant inicio;
	
	private Instant fim;
	
	private String nomeAtividade;

	public Instant getInicio() {
		return inicio;
	}

	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}

	public Instant getFim() {
		return fim;
	}

	public void setFim(Instant fim) {
		this.fim = fim;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public BlocoDaAtividadeDTO(Instant inicio, Instant fim, String nomeAtividade) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.nomeAtividade = nomeAtividade;
	}

	public BlocoDaAtividadeDTO() {
		super();
	}
	
	
	
	
}
