package com.sistema.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.crud.dto.ProdutoDTO;
import com.sistema.crud.service.ProdutoService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ProdutoController {
	
	public ProdutoService service;
	
	public ProdutoController(ProdutoService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastro")
	public String formulario(Model model) {
		model.addAttribute("produtoDTO", new ProdutoDTO());
		return "index";
	}
	
	@PostMapping("/cadastro")
	public String salvarProduto(@ModelAttribute("produtoDTO") @Valid ProdutoDTO produtoDTO, BindingResult result) {
		if(result.hasErrors()){
			return "index";
		}
		service.salvarProduto(produtoDTO);
		return "redirect:/cadastro";
	}
	
	@GetMapping("/produtos")
	public String listarProdutos(Model model) {
		model.addAttribute("produtos", service.listarProdutos());
		return "listagem";
	}

	@GetMapping("/produtos/editar/{id}")
	public String editarProduto(@PathVariable Long id, Model model) {
		ProdutoDTO dto = service.buscarPorId(id);
		model.addAttribute("produtoDTO", dto);
		return "index";
	}
	
	@PostMapping("/produtos/deletar/{id}")
	public String deletarProduto(@PathVariable Long id) {
		service.deletarProduto(id);
		return "redirect:/produtos";
	}
}