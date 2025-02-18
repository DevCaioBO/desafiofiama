package com.caio.evento.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name ="tb_bloco_da_atividade",uniqueConstraints = 
{@UniqueConstraint(columnNames = { "fk_id_atividade","fk_id_bloco"})})
public class BlocoDaAtividadeModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_atividade_x_bloco")
	private Integer idAtividadexBloco;
	
	@Column(name="fk_id_atividade")
	private Integer fkIdAtividade;
	
	@Column(name="fk_id_bloco")
	private Integer fkIdBloco;

	public Integer getIdAtividadexBloco() {
		return idAtividadexBloco;
	}

	public void setIdAtividadexBloco(Integer idAtividadexBloco) {
		this.idAtividadexBloco = idAtividadexBloco;
	}

	public Integer getFkIdAtividade() {
		return fkIdAtividade;
	}

	public void setFkIdAtividade(Integer fkIdAtividade) {
		this.fkIdAtividade = fkIdAtividade;
	}

	public Integer getFkIdBloco() {
		return fkIdBloco;
	}

	public void setFkIdBloco(Integer fkIdBloco) {
		this.fkIdBloco = fkIdBloco;
	}

	public BlocoDaAtividadeModel(Integer idAtividadexBloco, Integer fkIdAtividade, Integer fkIdBloco) {
		super();
		this.idAtividadexBloco = idAtividadexBloco;
		this.fkIdAtividade = fkIdAtividade;
		this.fkIdBloco = fkIdBloco;
	}

	public BlocoDaAtividadeModel() {
		super();
	}
	
	
}
