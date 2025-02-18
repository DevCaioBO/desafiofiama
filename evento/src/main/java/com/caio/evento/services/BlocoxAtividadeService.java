package com.caio.evento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.evento.dtos.BlocosDasAtividadesDTO;
import com.caio.evento.repositories.BlocoxAtividadeRepository;
@Service
public class BlocoxAtividadeService {
	
	@Autowired
	private BlocoxAtividadeRepository repo;
	
	public ResponseEntity<?> CreateRelationAtividadexBlocoService(Integer fk_id_bloco,Integer fk_id_atividade)throws Exception{
		return repo.CreateRelationAtividadexBloco(fk_id_bloco, fk_id_atividade);
	}
	public List<BlocosDasAtividadesDTO> ReadBlocksHrsService() throws Exception{
		return repo.ReadBlocksHrs();
	}
}
