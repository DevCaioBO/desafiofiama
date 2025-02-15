package com.caio.evento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.evento.dtos.AtividadeDTO;
import com.caio.evento.services.AtividadeService;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired
	private AtividadeService service;
	@PostMapping("/create")
	public ResponseEntity<?> PostAtividade(@RequestBody AtividadeDTO data) throws Exception{
		return service.CreateAtividadeService(data.getNome(), data.getDescricao(), data.getPreco());
	}
}
