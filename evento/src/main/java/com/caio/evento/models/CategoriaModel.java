package com.caio.evento.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="tb_categoria")
public class CategoriaModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@OneToMany(mappedBy="categoria",cascade = CascadeType.ALL)
	private List<AtividadeModels> atividades;

	public CategoriaModel(Integer id_categoria, String descricao, List<AtividadeModels> atividades) {
		super();
		this.id_categoria = id_categoria;
		this.descricao = descricao;
		this.atividades = atividades;
	}

	public CategoriaModel() {
		super();
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AtividadeModels> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<AtividadeModels> atividades) {
		this.atividades = atividades;
	}
	
	
	
}
