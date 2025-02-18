package com.caio.evento.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.caio.evento.dtos.BlocosDasAtividadesDTO;

@Repository
public class BlocoxAtividadeRepository {

	@Autowired
	private DataSource dataSource;
	
	
	
	public ResponseEntity<?> CreateRelationAtividadexBloco(Integer fk_id_bloco,Integer fk_id_atividade)throws Exception{
		String sqlInsert = """
				INSERT INTO tb_bloco_da_atividade(fk_id_bloco,fk_id_atividade) VALUES(?,?)
				""";
		try(Connection con = dataSource.getConnection()){
			con.setAutoCommit(false);
			try(PreparedStatement stmtInsert = con.prepareStatement(sqlInsert)){
				stmtInsert.setInt(1,fk_id_bloco);
				stmtInsert.setInt(2, fk_id_atividade);
				stmtInsert.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				
				throw new Exception("Erro mais especifico tentando parear atividade x bloco");

				
			}
			con.commit();
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			throw new Exception("Erro ao parear o bloco a atividade");

			
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("bloco pareado a atividade com sucesso!");
	}
	
	public List<BlocosDasAtividadesDTO> ReadBlocksHrs() throws Exception{
		
		List<BlocosDasAtividadesDTO> listBlocksForActivits = new ArrayList<>();
		
		String sqlRead = """
				SELECT tbap.id_atividade_x_participante id_atividade_vs_participante,tbap.fk_id_participante,tbap.fk_id_atividade,tbb.id_bloco, tbp.nome nome_participante , tbp.email ,  tba.nome nome_atividade,tba.descricao, tba.preco,tbb.inicio,tbb.fim FROM  tb_participante tbp
				INNER JOIN tb_atividade_do_participante tbap ON tbp.id_participante = tbap.fk_id_participante
				INNER JOIN  tb_atividade tba ON tba.id_atividade = tbap.fk_id_atividade
				INNER JOIN tb_bloco_da_atividade tbatv ON tbatv.fk_id_atividade = tba.id_atividade
				INNER JOIN tb_bloco tbb ON tbb.id_bloco = tbatv.fk_id_bloco;
				""";
		try(Connection con = dataSource.getConnection()){
			con.setAutoCommit(false);
			try(PreparedStatement stmtRead = con.prepareStatement(sqlRead)){
				try(ResultSet rs = stmtRead.executeQuery()){
					while(rs.next()) {
						BlocosDasAtividadesDTO blocoDaAtividade = new BlocosDasAtividadesDTO();
						
						blocoDaAtividade.setId_atividade_x_participante(rs.getInt("id_atividade_vs_participante"));
						blocoDaAtividade.setFk_id_participante(rs.getInt("fk_id_participante"));
						blocoDaAtividade.setFk_id_atividade(rs.getInt("fk_id_atividade"));
						blocoDaAtividade.setId_bloco(rs.getInt("id_bloco"));
						blocoDaAtividade.setNome_participante(rs.getString("nome_participante"));
						blocoDaAtividade.setEmail(rs.getString("email"));
						blocoDaAtividade.setNome_atividade(rs.getString("nome_atividade"));
						blocoDaAtividade.setDescricao(rs.getString("descricao"));
						blocoDaAtividade.setPreco(rs.getBigDecimal("preco"));
						blocoDaAtividade.setInicio(rs.getTimestamp("inicio").toInstant());
						blocoDaAtividade.setFim(rs.getTimestamp("fim").toInstant());
						
						listBlocksForActivits.add(blocoDaAtividade);
						
					}
				}
			}
			con.commit();
			return listBlocksForActivits;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Algo deu erro na pesquisa dos blocos blocos e suas relações");
		}catch(Exception e) {
			throw new Exception("Erro não necessáriamente na pesquisa mas ainda lá nos blocos");
		}
	}
}
