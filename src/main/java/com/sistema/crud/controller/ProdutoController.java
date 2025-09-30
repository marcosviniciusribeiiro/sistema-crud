package com.sistema.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
	@GetMapping("/pagina")
	public String pagina() {
		return "index";
	}
}
