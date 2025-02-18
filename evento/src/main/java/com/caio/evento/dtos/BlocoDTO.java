package com.caio.evento.dtos;

import java.time.Instant;

public class BlocoDTO {
	
	private Instant inicio;
	private Instant fim;
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
	public BlocoDTO(Instant inicio, Instant fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}
	public BlocoDTO() {
		super();
	}
	
	
}
