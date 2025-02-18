package com.caio.evento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.evento.dtos.AtividadeDTO;
import com.caio.evento.services.AtividadeService;
import com.caio.evento.services.CategoriaService;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired
	private AtividadeService service;
	
	@Autowired
	private CategoriaService categoriaService;
	@PostMapping("/create")
	public ResponseEntity<?> PostAtividade(@RequestBody AtividadeDTO data) throws Exception{
		Integer idCategory = 0;
		idCategory = categoriaService.GetIdForCategoryByDescriptionService(data.getDescricaoCategoria());
		if( idCategory >0) {
			return service.CreateAtividadeService(idCategory,data.getNome(), data.getDescricao(), data.getPreco());
		}
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A Categoria fornecida não existe");		}
	
}
