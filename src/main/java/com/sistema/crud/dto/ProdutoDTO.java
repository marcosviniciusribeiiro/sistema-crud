package com.sistema.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoDTO {
	
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "A descrição é obrigatória")
	private String descricao;
	
	@Positive(message = "O preço deve ser maior que zero")
	private double preco;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}