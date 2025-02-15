package com.caio.evento.dtos;

public class ParticipanteDTO {
	private String nome;
	private String email;
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
	public ParticipanteDTO(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	public ParticipanteDTO() {
		super();
	}
	
	
	
}
