package com.caio.evento.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_participante")
public class ParticipanteModels {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_participante;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name ="email")
	private String email;
	//atividades
	@ManyToOne
	@JoinColumn(name="id_atividade")
	private AtividadeModels atividades;
	
	@OneToMany(mappedBy = "participantes")
	List<AtividadeModels> atividadesList = new ArrayList<>();

	public Long getId_participante() {
		return id_participante;
	}

	public void setId_participante(Long id_participante) {
		this.id_participante = id_participante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




	public AtividadeModels getAtividades() {
		return atividades;
	}

	public void setAtividades(AtividadeModels atividades) {
		this.atividades = atividades;
	}

	public List<AtividadeModels> getAtividadesList() {
		return atividadesList;
	}

	public void setAtividadesList(List<AtividadeModels> atividadesList) {
		this.atividadesList = atividadesList;
	}

	public ParticipanteModels(Long id_participante, String nome, String email, AtividadeModels atividades,
			List<AtividadeModels> atividadesList) {
		super();
		this.id_participante = id_participante;
		this.nome = nome;
		this.email = email;
		this.atividades = atividades;
		this.atividadesList = atividadesList;
	}
	
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	

	
	
	
	
}
