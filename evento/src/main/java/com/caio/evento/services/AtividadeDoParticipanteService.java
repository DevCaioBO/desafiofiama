package com.caio.evento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.evento.dtos.AtividadeDoParticipanteDTO;
import com.caio.evento.repositories.AtividadeDoParticipanteRepository;

@Service
public class AtividadeDoParticipanteService {
	@Autowired
	private AtividadeDoParticipanteRepository repo;
	
	public ResponseEntity<?> pkActivityXParticipanteService(Integer id_participante,Integer id_atividade)throws Exception{
		return repo.pkActivityXParticipante(id_participante, id_atividade);
	}
	public List<AtividadeDoParticipanteDTO> ReadAtividadexParticipanteService() throws Exception{
		return repo.ReadAtividadexParticipante();
	}
}
	
