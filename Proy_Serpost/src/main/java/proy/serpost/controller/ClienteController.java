package proy.serpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proy.serpost.model.Cliente;
import proy.serpost.repository.IClienteRepository;

@Controller
@RequestMapping(path = "/cliente")
public class ClienteController {
	@Autowired
	private IClienteRepository repoc;

	@GetMapping("/cargar")
	public String cargarCli(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstClientes", repoc.findAll());
		return "mantenimientoCliente";
	}

	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Cliente cliente, Model model) {
		try {
		System.out.println("Listo para grabar");
		System.out.println(cliente);
		repoc.save(cliente);
		model.addAttribute("mensaje", "Registrado correctamente");
		model.addAttribute("lstClientes", repoc.findAll());
		}catch(Exception c) {
			model.addAttribute("mensaje", "Error al registrar");
		}
		return cargarCli(model);
	}
}
