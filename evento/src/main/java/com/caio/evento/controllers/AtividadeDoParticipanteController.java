package com.caio.evento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.evento.dtos.AtividadeDoParticipanteDTO;
import com.caio.evento.dtos.AtividadexParticipantePKDTO;
import com.caio.evento.services.AtividadeDoParticipanteService;
import com.caio.evento.services.AtividadeService;
import com.caio.evento.services.ParticipanteService;

@RestController
@RequestMapping("/atividadexparticipante")
public class AtividadeDoParticipanteController {
	@Autowired
	private AtividadeDoParticipanteService service;
	
	@Autowired
	private ParticipanteService serviceUtilsParticipant;
	@Autowired
	private AtividadeService serviceUtilsAtividade;
	
	@PostMapping("create")
	public ResponseEntity<?> createPkActivityXParticipante(@RequestBody AtividadexParticipantePKDTO data)throws Exception{
		return service.pkActivityXParticipanteService(serviceUtilsParticipant.GetIdForOneParticipant(data.getEmailParticipante()),
serviceUtilsAtividade.GetIdForOneEvent(data.getNomeAtividade()));
	}
	
	@GetMapping("read")
	public List<AtividadeDoParticipanteDTO> ReadAtividadexParticipante() throws Exception{
		return service.ReadAtividadexParticipanteService();
	}
}

