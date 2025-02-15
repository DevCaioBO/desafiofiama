package com.caio.evento.repositories;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AtividadeRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public Integer GetIdForOneEvent(String nome) throws Exception {
		String sqlSelect = """
				SELECT id_atividade FROM tb_atividade WHERE nome = ?
				""";
		Integer idForEvent = 0;
		
		try (Connection con = dataSource.getConnection()){
			con.setAutoCommit(false);
			try (PreparedStatement stmtSelect = con.prepareStatement(sqlSelect);){
				stmtSelect.setString(1, nome);
				try (ResultSet rs = stmtSelect.executeQuery()){
					if(rs.next()) {
						idForEvent = rs.getInt("id_atividade");
					}
					
				}
			}
			con.commit();
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ocorreu um erro ao obter o id dessa atividade/evento");
		}
		return idForEvent;
	}
	
	public ResponseEntity<?> CreateAtividade(String nome,String descricao,BigDecimal preco) throws Exception{
		String sqlSelect = """
				SELECT nome FROM tb_atividade WHERE nome = ?
				""";
		String sqlInsert = """
				INSERT INTO tb_atividade(nome,descricao,preco) VALUES(?,?,?)
				""";
		Boolean isExistentEvent = false;
		try(Connection con = dataSource.getConnection();){
			con.setAutoCommit(false);
			try(PreparedStatement stmtSelect = con.prepareStatement(sqlSelect);){
				stmtSelect.setString(1, nome);
				try(ResultSet rs = stmtSelect.executeQuery();){
					if(rs.next()) {
						isExistentEvent = true;
					}
				}
				if(isExistentEvent) {
					return ResponseEntity.badRequest().body("Esse evento/atividade já está registrada");
				}
				else {
					try(PreparedStatement stmtInsert = con.prepareStatement(sqlInsert);){
						stmtInsert.setString(1, nome);
						stmtInsert.setString(2, descricao);
						stmtInsert.setBigDecimal(3, preco);
						stmtInsert.executeUpdate();
						
					}
				}
				
				
				
			}
			con.commit();
			return ResponseEntity.ok("Evento/Atividade criada com sucesso");
			
		}
	}
}
