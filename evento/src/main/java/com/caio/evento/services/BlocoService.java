package com.caio.evento.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.evento.repositories.BlocoRepository;

@Service
public class BlocoService {
	@Autowired
	private BlocoRepository repo;
	
	public ResponseEntity<?> CreateBlockHrsService(Instant inicio,Instant fim) throws Exception {
		return repo.CreateBlockHrs(inicio, fim);
	}
	public Integer ReadIdForBlockService(Instant inicio,Instant fim) throws Exception {
		return repo.ReadIdForBlock(inicio, fim);
	}
}
