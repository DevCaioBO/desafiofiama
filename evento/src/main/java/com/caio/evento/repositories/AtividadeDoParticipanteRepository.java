package com.caio.evento.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.caio.evento.dtos.AtividadeDoParticipanteDTO;

@Repository
public class AtividadeDoParticipanteRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public ResponseEntity<?> pkActivityXParticipante(Integer id_participante,Integer id_atividade)throws Exception{
		
		String SqlInsert = """
				INSERT INTO tb_atividade_do_participante(fk_id_participante,fk_id_atividade) VALUES(?,?);
				""";
		try(Connection con = dataSource.getConnection();){
			con.setAutoCommit(false);
			try(PreparedStatement stmtInsert = con.prepareStatement(SqlInsert)){
				stmtInsert.setInt(1, id_participante);
				stmtInsert.setInt(2,id_atividade);
				stmtInsert.executeUpdate();
				
			}
			catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("vocÊ já está nessa");
			}
			con.commit();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Erro ao gerar chave composta");
		}
		
		return ResponseEntity.ok("chave composta gerada corretamente");
	
		
		
		
	}
	public List<AtividadeDoParticipanteDTO> ReadAtividadexParticipante() throws Exception{
		
		String sql = """
				SELECT tbp.nome nome_participante ,tbp.email ,tba.nome nome_atividade,tba.descricao,tba.preco FROM tb_participante tbp
				INNER JOIN tb_atividade_do_participante tbap ON tbp.id_participante = tbap.fk_id_participante
				INNER JOIN tb_atividade tba ON tba.id_atividade = tbap.fk_id_atividade    
				""";
		List<AtividadeDoParticipanteDTO> listAtividadeDoParticipante = new ArrayList<>();
		try (Connection connection = dataSource.getConnection()){
			
			connection.setAutoCommit(false);
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
				try (ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						AtividadeDoParticipanteDTO atividadeDoParticipante = new AtividadeDoParticipanteDTO();
						
						atividadeDoParticipante.setNome_participante(rs.getString("nome_participante"));
						atividadeDoParticipante.setEmail(rs.getString("email"));
						atividadeDoParticipante.setNome_atividade(rs.getString("nome_atividade"));
						atividadeDoParticipante.setDescricao(rs.getString("descricao"));
						atividadeDoParticipante.setPreco(rs.getBigDecimal("preco"));
						
						listAtividadeDoParticipante.add(atividadeDoParticipante);
					}
				}
				
			}
			connection.commit();
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Erro ao obter os participantes dessa atividade");
		}
		
		return listAtividadeDoParticipante;
		
	}
}
