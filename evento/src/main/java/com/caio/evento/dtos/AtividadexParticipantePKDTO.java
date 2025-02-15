package com.caio.evento.dtos;



public class AtividadexParticipantePKDTO {
	
	private String emailParticipante;
	
	private String nomeAtividade;

	public String getEmailParticipante() {
		return emailParticipante;
	}

	public void setEmailParticipante(String emailParticipante) {
		this.emailParticipante = emailParticipante;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public AtividadexParticipantePKDTO(String emailParticipante, String nomeAtividade) {
		super();
		this.emailParticipante = emailParticipante;
		this.nomeAtividade = nomeAtividade;
	}

	public AtividadexParticipantePKDTO() {
		super();
	}


	
	
}
