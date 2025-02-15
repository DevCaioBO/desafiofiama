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

	//caio <- bom, vou ir pela ideia de uma tabela relacional porém sem ManyToMany :)
	
	
	
	

	
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	

	
	
	
	
}
