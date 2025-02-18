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
	@Column(name = "id_participante")
	private Long idParticipante;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name ="email",unique = true)
	private String email;

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
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

	public ParticipanteModels(Long idParticipante, String nome, String email) {
		super();
		this.idParticipante = idParticipante;
		this.nome = nome;
		this.email = email;
	}

	public ParticipanteModels() {
		super();
	}

	//caio <- bom, vou ir pela ideia de uma tabela relacional porém sem ManyToMany :)
	
	
	
	
	
	
	

	
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	

	
	
	
	
}
