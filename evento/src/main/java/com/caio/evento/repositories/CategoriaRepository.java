package com.caio.evento.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.caio.evento.dtos.CategoriaDaAtividadeDaPessoaDTO;

@Repository
public class CategoriaRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public Integer getIdForCategoryByDescription(String descricao) throws Exception{
		String sqlRead= """
					SELECT id_categoria FROM tb_categoria WHERE descricao =?
				""";
		Integer idForCategory = 0;
		try (Connection con = dataSource.getConnection()){
			con.setAutoCommit(false);
			try(PreparedStatement stmtRead = con.prepareStatement(sqlRead)){
				stmtRead.setString(1, descricao);
				try(ResultSet rs = stmtRead.executeQuery()){
					if(rs.next()) {
						idForCategory = rs.getInt("id_categoria");
					}
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("Erro ao obter id da categoria");
			}
			con.commit();
			
		}
		return idForCategory;
	}
	
	public ResponseEntity<?> CreateOneCategory(String descricao) throws Exception{
		String sqlCreate= """
					INSERT INTO tb_categoria(descricao) VALUES(?)
				""";
	
		try (Connection con = dataSource.getConnection()){
			con.setAutoCommit(false);
			try(PreparedStatement stmtCreate = con.prepareStatement(sqlCreate)){
				stmtCreate.setString(1, descricao);
				stmtCreate.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("Erro ao obter id da categoria");
			}
			con.commit();
			
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("categoria criada com sucesso!");
	}
	/*		
	*/
	
	//caio <- SÓ PEGUEI OS QUATRO IDS, POR QUE AQUI ACHEI NECESSARIO :), 
	//Para eu mesmo entender o fluxo das chave compostas
	public List<CategoriaDaAtividadeDaPessoaDTO> ReadFullDataOfProject() throws Exception{
		
		String sqlRead = """
				SELECT tbp.nome nome_participante ,tbap.id_atividade_x_participante,tbap.fk_id_participante,tbap.fk_id_atividade,tbb.id_bloco,tbcat.id_categoria, tbp.email ,tbcat.descricao categoria_descricao,tba.nome nome_atividade, tba.descricao,  tba.preco,tbb.inicio,tbb.fim FROM  tb_participante tbp
				INNER JOIN tb_atividade_do_participante tbap ON tbp.id_participante = tbap.fk_id_participante
				INNER JOIN  tb_atividade tba ON tba.id_atividade = tbap.fk_id_atividade
				INNER JOIN tb_bloco_da_atividade tbatv ON tbatv.fk_id_atividade = tba.id_atividade
				INNER JOIN tb_categoria tbcat ON tbcat.id_categoria = tba.id_categoria
				INNER JOIN tb_bloco tbb ON tbb.id_bloco = tbatv.fk_id_bloco;
				""";
		List<CategoriaDaAtividadeDaPessoaDTO> listCategoriesAndActivitys = new ArrayList<>();
		try (Connection con = dataSource.getConnection()){
			con.setAutoCommit(false);
			try(PreparedStatement stmtRead = con.prepareStatement(sqlRead)){
				try(ResultSet rs = stmtRead.executeQuery()){
					while(rs.next()) {
						CategoriaDaAtividadeDaPessoaDTO Category = new CategoriaDaAtividadeDaPessoaDTO();
						Category.setId_atividade_x_participante(rs.getInt("id_atividade_x_participante"));
						Category.setFk_id_participante(rs.getInt("fk_id_participante"));
						Category.setFk_id_atividade(rs.getInt("fk_id_atividade"));
						Category.setId_bloco(rs.getInt("id_bloco"));
						Category.setId_categoria(rs.getInt("id_categoria"));
						Category.setNome_participante(rs.getString("nome_participante"));
						Category.setCategoria_descricao(rs.getString("categoria_descricao"));
						Category.setNome_atividade(rs.getString("nome_atividade"));
						Category.setEmail(rs.getString("email"));
						
						Category.setDescricao(rs.getString("descricao"));
						Category.setPreco(rs.getBigDecimal("preco"));
						Category.setInicio(rs.getTimestamp("inicio").toInstant());
						Category.setFim(rs.getTimestamp("fim").toInstant());
						
						listCategoriesAndActivitys.add(Category);
						
					}
					
				}
				
			}
			con.commit();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Erro ao obter a categoria e o conteúdo dela");
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Erro bem diferente não esperado ainda aver com o conteúdo da categoria");
		}
		return listCategoriesAndActivitys;

	}
}
