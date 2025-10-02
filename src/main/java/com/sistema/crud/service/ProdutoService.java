package com.sistema.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.crud.dto.ProdutoDTO;
import com.sistema.crud.mapper.ProdutoMapper;
import com.sistema.crud.model.Produto;
import com.sistema.crud.repository.ProdutoRepository;

@Service
public class ProdutoService {
	public ProdutoRepository repository;
	
	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}
	
	public void salvarProduto(ProdutoDTO produtoDTO) {
		repository.save(ProdutoMapper.toEntity(produtoDTO));
	}
	
	public List<ProdutoDTO> listarProdutos(){
		return repository
				.findAll()
				.stream()
				.map(ProdutoMapper::toDTO)
				.toList();
	}
	
	public ProdutoDTO buscarPorId(Long id){
		Produto p = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
		return ProdutoMapper.toDTO(p);
	}
	
	public void deletarProduto(Long id) {
		repository.deleteById(id);
	}
}
