package com.caio.evento.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class BlocoRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public Integer ReadIdForBlock(Instant inicio,Instant fim) throws Exception {
		
		String sqlRead = """
				SELECT id_bloco FROM tb_bloco WHERE inicio =? AND fim =?
				""";
		Integer idBloco = 0;
		
		try (Connection con = dataSource.getConnection();){
			con.setAutoCommit(false);
			try(PreparedStatement stmtRead = con.prepareStatement(sqlRead);){
				stmtRead.setTimestamp(1, Timestamp.from(inicio));
				stmtRead.setTimestamp(2, Timestamp.from(fim));
				try(ResultSet rs = stmtRead.executeQuery()){
					if(rs.next()) {
						idBloco = rs.getInt("id_bloco");
					}
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("Erro ao obter id do bloco");
			}
			con.commit();
			
		}
		return idBloco;
	}
	
	public ResponseEntity<?> CreateBlockHrs(Instant inicio,Instant fim) throws Exception {
		
		String sqlCreate = """
				INSERT INTO tb_bloco(inicio,fim) VALUES(?,?)
				""";
		String sqlRead = """
				SELECT inicio,fim FROM tb_bloco WHERE inicio = ? AND fim = ?
				""";
		try (Connection conection = dataSource.getConnection()){
			conection.setAutoCommit(false);
			try(PreparedStatement stmtRead = conection.prepareStatement(sqlRead)){
				stmtRead.setTimestamp(1, Timestamp.from(inicio));
				stmtRead.setTimestamp(2, Timestamp.from(fim));
				
				try (ResultSet rs = stmtRead.executeQuery();){
					
					if(rs.next()) {
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse bloco de horário já existe");
					}else {
						try (PreparedStatement stmtCreate = conection.prepareStatement(sqlCreate)){
							stmtCreate.setTimestamp(1, Timestamp.from(inicio));
							stmtCreate.setTimestamp(2, Timestamp.from(fim));
							stmtCreate.executeUpdate();
						}
						catch(SQLException e) {
							e.printStackTrace();
							throw new Exception("Erro ao adicionar um novo bloco");
						}
						
					}
					
					
					
				}catch(SQLException e) {
					e.printStackTrace();
					throw new Exception("Erro ao procurar algum bloco");
				}
				
			}
			conection.commit();
		
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Bloco adicionado com sucesso!");
		
		
	}
}
