package com.caio.evento.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_atividade")
public class AtividadeModels {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private Long idAtividade;
	@Column(unique = true)
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private CategoriaModel categoria;


	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public Long getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}



	public AtividadeModels(Long idAtividade, String nome, String descricao, Double preco, CategoriaModel categoria) {
		super();
		this.idAtividade = idAtividade;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public AtividadeModels() {
		super();
	}
	
	
	
	
	




	


	
	
	
	
}
