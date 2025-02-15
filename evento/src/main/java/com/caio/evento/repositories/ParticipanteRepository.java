package com.caio.evento.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipanteRepository {
	
	@Autowired
	private DataSource dataSource;
	
	
	public Integer GetIdForOneParticipant(String email) throws Exception {
		String sqlSelect = """
				SELECT id_participante FROM tb_participante WHERE email = ?
				""";
		Integer idForParticipante = 0;
		
		try (Connection con = dataSource.getConnection()){
			con.setAutoCommit(false);
			try (PreparedStatement stmtSelect = con.prepareStatement(sqlSelect);){
				stmtSelect.setString(1, email);
				try (ResultSet rs = stmtSelect.executeQuery()){
					if(rs.next()) {
						idForParticipante = rs.getInt("id_participante");
					}
					
				}
			}
			con.commit();
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ocorreu um erro ao obter o id dessa atividade/evento");
		}
		return idForParticipante;
	}
	
	public ResponseEntity<?> CreateParticipante(String nome,String email) throws Exception {
		
		

		Boolean userExists = false;
	
		String sqlSourceUser = """
			SELECT * FROM tb_participante WHERE email = ?
				""";
		String sqlInsertUser = """
				INSERT INTO tb_participante(nome,email) VALUES(?,?)
				""";
		try (Connection con =dataSource.getConnection();
				){
		
			con.setAutoCommit(false);
			try (PreparedStatement stmtSelect =con.prepareStatement(sqlSourceUser);	){
				

			stmtSelect.setString(1, email);
			try (ResultSet rs = stmtSelect.executeQuery();){
				if(rs.next()) {
					userExists = true;
				}
			}
	
			
			
				
			
			if(userExists) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existente tente atribui-lo a uma atividade");
			}else {
				try(PreparedStatement stmtInsert =con.prepareStatement(sqlInsertUser);){
					
					stmtInsert.setString(1, nome);
					stmtInsert.setString(2, email);
					
					stmtInsert.executeUpdate();
				}
			}
			}
			
			
			
			con.commit();
		}
		return ResponseEntity.ok("usuário cadastrado");
	}

}
