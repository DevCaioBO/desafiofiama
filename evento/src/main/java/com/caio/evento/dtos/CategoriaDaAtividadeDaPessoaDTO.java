package com.caio.evento.dtos;

import java.math.BigDecimal;
import java.time.Instant;

public class CategoriaDaAtividadeDaPessoaDTO {
	private Integer id_atividade_x_participante;
	private Integer fk_id_participante;
	private Integer fk_id_atividade;
	private Integer id_bloco;
	private Integer id_categoria;
	private String nome_participante;
	private String email;
	private String nome_atividade;
	private String descricao;
	private BigDecimal preco;
	
	private Instant inicio;
	
	public Integer getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	private Instant fim;
	private String categoria_descricao;
	
	public Integer getId_atividade_x_participante() {
		return id_atividade_x_participante;
	}
	public void setId_atividade_x_participante(Integer id_atividade_x_participante) {
		this.id_atividade_x_participante = id_atividade_x_participante;
	}
	public Integer getFk_id_participante() {
		return fk_id_participante;
	}
	public void setFk_id_participante(Integer fk_id_participante) {
		this.fk_id_participante = fk_id_participante;
	}
	public Integer getFk_id_atividade() {
		return fk_id_atividade;
	}
	public void setFk_id_atividade(Integer fk_id_atividade) {
		this.fk_id_atividade = fk_id_atividade;
	}
	public Integer getId_bloco() {
		return id_bloco;
	}
	public void setId_bloco(Integer id_bloco) {
		this.id_bloco = id_bloco;
	}
	public String getNome_participante() {
		return nome_participante;
	}
	public void setNome_participante(String nome_participante) {
		this.nome_participante = nome_participante;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome_atividade() {
		return nome_atividade;
	}
	public void setNome_atividade(String nome_atividade) {
		this.nome_atividade = nome_atividade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Instant getInicio() {
		return inicio;
	}
	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}
	public Instant getFim() {
		return fim;
	}
	public void setFim(Instant fim) {
		this.fim = fim;
	}
	public String getCategoria_descricao() {
		return categoria_descricao;
	}
	public void setCategoria_descricao(String categoria_descricao) {
		this.categoria_descricao = categoria_descricao;
	}
	public CategoriaDaAtividadeDaPessoaDTO(Integer id_atividade_x_participante, Integer fk_id_participante,
			Integer fk_id_atividade, Integer id_bloco, Integer id_categoria, String nome_participante, String email,
			String nome_atividade, String descricao, BigDecimal preco, Instant inicio, Instant fim,
			String categoria_descricao) {
		super();
		this.id_atividade_x_participante = id_atividade_x_participante;
		this.fk_id_participante = fk_id_participante;
		this.fk_id_atividade = fk_id_atividade;
		this.id_bloco = id_bloco;
		this.id_categoria = id_categoria;
		this.nome_participante = nome_participante;
		this.email = email;
		this.nome_atividade = nome_atividade;
		this.descricao = descricao;
		this.preco = preco;
		this.inicio = inicio;
		this.fim = fim;
		this.categoria_descricao = categoria_descricao;
	}
	public CategoriaDaAtividadeDaPessoaDTO() {
		super();
	}
	
	
	
	
	
}
