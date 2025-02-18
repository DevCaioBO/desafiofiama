package com.caio.evento.controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.evento.dtos.BlocoDTO;
import com.caio.evento.services.BlocoService;

@RestController
@RequestMapping("/bloco")
public class BlocoController {
	@Autowired
	private BlocoService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> CreateBlockHrs(@RequestBody BlocoDTO data) throws Exception {
		return service.CreateBlockHrsService(data.getInicio(), data.getFim());
	}
	

}
