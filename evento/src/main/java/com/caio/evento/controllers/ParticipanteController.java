package com.caio.evento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.evento.dtos.ParticipanteDTO;
import com.caio.evento.services.ParticipanteService;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {
	
	@Autowired
	private ParticipanteService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> PostParticipante(@RequestBody ParticipanteDTO data) throws Exception {
		return service.CreateParticipanteService(data.getNome(), data.getEmail());
	}
	
}
