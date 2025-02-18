package com.caio.evento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.evento.dtos.CategoriaDaAtividadeDaPessoaDTO;
import com.caio.evento.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repos;
	
	
	public ResponseEntity<?> CreateOneCategoryService(String descricao) throws Exception{
		return repos.CreateOneCategory(descricao);
	}
	
	public Integer GetIdForCategoryByDescriptionService(String descricao) throws Exception{
		return repos.getIdForCategoryByDescription(descricao);
	}
	public List<CategoriaDaAtividadeDaPessoaDTO> ReadFullDataOfProjectService() throws Exception{
		return repos.ReadFullDataOfProject();
		
	}
}
