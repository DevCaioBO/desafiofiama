package com.caio.evento.dtos;

public class CategoriaDTO {
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaDTO(String descricao) {
		super();
		this.descricao = descricao;
	}

	public CategoriaDTO() {
		super();
	}
	
	
}
