package com.caio.evento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.evento.dtos.CategoriaDTO;
import com.caio.evento.dtos.CategoriaDaAtividadeDaPessoaDTO;
import com.caio.evento.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService service;
	@PostMapping("/create")
	public ResponseEntity<?> CreateOneCategory(@RequestBody CategoriaDTO data) throws Exception{
		if(service.GetIdForCategoryByDescriptionService(data.getDescricao()) >0) {
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Essa categoria já está registrada!");
		}
		return service.CreateOneCategoryService(data.getDescricao());
	}
	@GetMapping("/read")
	public List<CategoriaDaAtividadeDaPessoaDTO> ReadFullDataOfProject() throws Exception{
		return service.ReadFullDataOfProjectService();
		
	}
}
