package com.caio.evento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.evento.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {
	@Autowired
	private ParticipanteRepository repo;
	public ResponseEntity<?> CreateParticipanteService(String nome,String email) throws Exception {
		
		return repo.CreateParticipante(nome, email);
}
	public Integer GetIdForOneParticipant(String email) throws Exception {
		return repo.GetIdForOneParticipant(email);
	}

	
}
