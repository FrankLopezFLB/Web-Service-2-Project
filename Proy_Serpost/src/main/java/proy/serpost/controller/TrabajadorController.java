package proy.serpost.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proy.serpost.model.Menu;
import proy.serpost.model.Trabajador;

import proy.serpost.repository.ICargoRepository;
import proy.serpost.repository.IMenuRepository;
import proy.serpost.repository.ITrabajadorRepository;



@Controller
@RequestMapping(path = "/trabajador")
public class TrabajadorController {
	
	@Autowired
	private ITrabajadorRepository repo;
	
	@Autowired
	private ICargoRepository repoCargo;
	
	@Autowired
	private IMenuRepository	repoMenu;
	
	
	@GetMapping("/cargarLogin")
	public String cargarLog(Model model) {
		model.addAttribute("trabajador", new Trabajador());
		return "login";
	}
	@GetMapping("/cargar")
	public String cargarPag(@ModelAttribute Trabajador trabajador, Model model) {		

		model.addAttribute("trabajador", new Trabajador());	
		model.addAttribute("lstCargo",repoCargo.findAll());
		model.addAttribute("lstTrabajador",repo.findAll());
		//model.addAttribute("mensaje", "asdasdsa");
		System.out.println("Listado abierto");
		return "mantenimiento-trabajador";
	}
	
	@PostMapping("/guardar")
	public String guardarTrabajador(@ModelAttribute Trabajador t,Model model){
		try {
		model.addAttribute("trabajador", new Trabajador());
		model.addAttribute("lstTrabajador",repo.findAll());
		model.addAttribute("lstCargo",repoCargo.findAll());
		model.addAttribute("mensaje", "Trabajador registrado correctamente");
		repo.save(t);
		} catch(Exception e) {
			model.addAttribute("mensaje", "Error al registrar trabajador");
		}
		return cargarPag(new Trabajador(), model);
		//return "redirect:/trabajador/cargar";
	}
	
	@PostMapping("/eliminar")
	public String eliminarTrabajador(@ModelAttribute Trabajador t, Model model ) {
		repo.deleteById(t.getCodigoTra());
		model.addAttribute("lstTrabajador",repo.findAll());
		return "redirect:/trabajador/cargar";
	}

	@PostMapping("/validar")
	public String validarPag(HttpSession session,@ModelAttribute Trabajador trabajador, Model model) {
		
		Trabajador t=repo.findByCorreoTraAndContrasena(trabajador.getCorreoTra(), trabajador.getContrasena());
		if(t==null) {
			model.addAttribute("mensaje","Usuario o clave incorrecto");
			return "login";
		}else {
			session.setAttribute("auxtrabajador", t);
			System.out.println("Listado de menu abierto");
			session.setAttribute("DATOS",t.getNombreTra()+" "+t.getApellidoTra());
			//session.setAttribute("acces", t.getCodigoTra());
			List<Menu> menuaux=repoMenu.spMenu(t.getCodigoTra());
			session.setAttribute("lstMenu",menuaux);	
			System.out.println("--------------");
			System.out.println(menuaux);
			System.out.println(t.getCodigoTra());
			model.addAttribute("trabajador",t);
			return "menu";
		}
		}
	
	
	}
