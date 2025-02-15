package com.caio.evento.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.evento.repositories.AtividadeRepository;

@Service
public class AtividadeService {
	@Autowired
	private AtividadeRepository repo;
	
	public ResponseEntity<?> CreateAtividadeService(String nome,String descricao,BigDecimal preco) throws Exception{
		return repo.CreateAtividade(nome, descricao, preco);
	}
	public Integer GetIdForOneEvent(String nome) throws Exception {
		return repo.GetIdForOneEvent(nome);
	}
}
