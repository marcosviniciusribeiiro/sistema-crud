package com.sistema.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.crud.dto.ProdutoDTO;
import com.sistema.crud.mapper.ProdutoMapper;
import com.sistema.crud.repository.ProdutoRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ProdutoController {
	@Autowired
	public ProdutoRepository repository;
	
	@GetMapping("/cadastro")
	public String formulario(Model model) {
		model.addAttribute("produtoDTO", new ProdutoDTO());
		return "index";
	}
	
	@PostMapping("/cadastro")
	public String salvarProduto(@ModelAttribute("produtoDTO") @Valid ProdutoDTO produtoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "index";
		}
		repository.save(ProdutoMapper.toEntity(produtoDTO));
		return "redirect:/cadastro";
	}
}