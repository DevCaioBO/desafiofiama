package com.caio.evento.models;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="tb_bloco")
@Table(name="tb_bloco")
public class BlocoModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bloco")
	private Integer idBloco;
	
	@Column(name="inicio",unique = true)
  
    private Instant inicio;
    

	

	@Column(name="fim",unique = true)
   
    private Instant fim;

	public Integer getIdBloco() {
		return idBloco;
	}

	public void setIdBloco(Integer idBloco) {
		this.idBloco = idBloco;
	}

	

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

	public BlocoModel(Integer idBloco, Instant inicio, Instant fim) {
		super();
		this.idBloco = idBloco;
		this.inicio = inicio;
		this.fim = fim;
	}

	public BlocoModel() {
		super();
	}
	
	
}
