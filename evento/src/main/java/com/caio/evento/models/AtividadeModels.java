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
@Table(name="tb_atividade")
public class AtividadeModels {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_atividade;
	
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	private Double preco;
	//participante
	
	// caio <- boraaaaa entendi que um participante é um cara que quer participar não que já está participando!
	@ManyToOne
	@JoinColumn(name="id_participante")
	private ParticipanteModels participantes;
	
	@OneToMany(mappedBy = "atividades")
	List<ParticipanteModels> participantesList = new ArrayList<>();

	public Long getId_atividade() {
		return id_atividade;
	}

	public void setId_atividade(Long id_atividade) {
		this.id_atividade = id_atividade;
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


	

	public ParticipanteModels getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ParticipanteModels participantes) {
		this.participantes = participantes;
	}

	public List<ParticipanteModels> getParticipantesList() {
		return participantesList;
	}

	public void setParticipantesList(List<ParticipanteModels> participantesList) {
		this.participantesList = participantesList;
	}





	


	
	
	
	
}
