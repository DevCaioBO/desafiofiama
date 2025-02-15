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
	@Column(name = "id_atividade")
	private Long idAtividade;
	
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	private Double preco;
	//participante
	
	




	


	
	
	
	
}
