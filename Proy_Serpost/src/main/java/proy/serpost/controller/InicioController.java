package proy.serpost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import proy.serpost.model.Trabajador;

@Controller
public class InicioController {
	@GetMapping("/")
	public String cargarLog(Model model) {
		model.addAttribute("trabajador", new Trabajador());
		return "login";
	}
}
