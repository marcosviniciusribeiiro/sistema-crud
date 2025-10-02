package com.sistema.crud.mapper;

import com.sistema.crud.dto.ProdutoDTO;
import com.sistema.crud.model.Produto;

public class ProdutoMapper {
	public static Produto toEntity(ProdutoDTO dto) {
		Produto produto = new Produto();
		produto.setId(dto.getId());
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		return produto;
	}
	public static ProdutoDTO toDTO(Produto p) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setId(p.getId());
		dto.setNome(p.getNome());
		dto.setDescricao(p.getDescricao());
		dto.setPreco(p.getPreco());
		return dto;
	}
}
