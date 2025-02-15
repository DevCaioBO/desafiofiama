package com.caio.evento.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name="tb_atividade_do_participante")
@Table(name = "tb_atividade_do_participante",
uniqueConstraints = { @UniqueConstraint(columnNames = { "fk_id_atividade", "fk_id_participante" }) })
public class AtividadeDoParticipante {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_atividade_x_participante")
	private Integer idAtividadeXparticipante;
	
	@Column(name = "fk_id_atividade")
	private Integer fkIdAtividade;
	@Column(name = "fk_id_participante")
	private Integer fkIdParticipante;
	public AtividadeDoParticipante() {
		super();
	}
	public AtividadeDoParticipante(Integer idAtividadeXparticipante, Integer fkIdAtividade, Integer fkIdParticipante) {
		super();
		this.idAtividadeXparticipante = idAtividadeXparticipante;
		this.fkIdAtividade = fkIdAtividade;
		this.fkIdParticipante = fkIdParticipante;
	}
	public Integer getIdAtividadeXparticipante() {
		return idAtividadeXparticipante;
	}
	public void setIdAtividadeXparticipante(Integer idAtividadeXparticipante) {
		this.idAtividadeXparticipante = idAtividadeXparticipante;
	}
	public Integer getFkIdAtividade() {
		return fkIdAtividade;
	}
	public void setFkIdAtividade(Integer fkIdAtividade) {
		this.fkIdAtividade = fkIdAtividade;
	}
	public Integer getFkIdParticipante() {
		return fkIdParticipante;
	}
	public void setFkIdParticipante(Integer fkIdParticipante) {
		this.fkIdParticipante = fkIdParticipante;
	}
	
	
}
