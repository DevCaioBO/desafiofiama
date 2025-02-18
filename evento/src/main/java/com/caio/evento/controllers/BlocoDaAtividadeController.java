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

import com.caio.evento.dtos.BlocoDaAtividadeDTO;
import com.caio.evento.dtos.BlocosDasAtividadesDTO;
import com.caio.evento.services.AtividadeService;
import com.caio.evento.services.BlocoService;
import com.caio.evento.services.BlocoxAtividadeService;

@RestController
@RequestMapping("/blocoxatividade")
public class BlocoDaAtividadeController {
	@Autowired
	private BlocoxAtividadeService service;
	
	@Autowired
	private BlocoService blocoService;
	
	@Autowired
	private AtividadeService atividadeService;
	
	@PostMapping("/create")
	public ResponseEntity<?> CreateRelationAtividadexBloco(@RequestBody BlocoDaAtividadeDTO data)throws Exception{
		if(blocoService.ReadIdForBlockService(data.getInicio(), data.getFim()) ==0 ||atividadeService.GetIdForOneEvent(data.getNomeAtividade()) == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("relação atividade x bloco não realizada com sucesso");
		}
		return service.CreateRelationAtividadexBlocoService(blocoService.ReadIdForBlockService(data.getInicio(), data.getFim()),
				atividadeService.GetIdForOneEvent(data.getNomeAtividade()));
	}
	
	@GetMapping("/read")
	public List<BlocosDasAtividadesDTO> ReadBlocksHrs() throws Exception{
		return service.ReadBlocksHrsService();
	}
	
	
}
