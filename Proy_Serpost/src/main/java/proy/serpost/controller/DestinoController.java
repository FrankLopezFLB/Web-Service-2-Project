package proy.serpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proy.serpost.model.Destino;
import proy.serpost.repository.IRepositoryDestino;
import proy.serpost.repository.IRepositoryRegion;

@Controller
@RequestMapping(path = "/destino")
public class DestinoController {
	
	@Autowired
	private IRepositoryDestino repod;
	
	@Autowired
	private IRepositoryRegion repor;
	
	@GetMapping("/cargar")
	public String cargarPag(Model model) {
		Destino des = new Destino();
		des.setCodregion(-1);
		model.addAttribute("destino", des);
		model.addAttribute("lstRegiones", repor.findAll());
		model.addAttribute("lstDestinos", repod.findAll());
		
		return "mantenimientoDestino";
	}
	
	
	/*String ultimoCodigo = repod.getMaxCodigoDestino();
		ultimoCodigo = incrementaCodigo(ultimoCodigo);*/
	
	@PostMapping("/guardar")
	public String actualizarReg(@ModelAttribute Destino d, Model model) {
		System.out.println(d);
		if(validaDestino(d)) {
			d.setCodigo(generaCodigo(d.getCodigo()));
			model.addAttribute("mensaje", "Registrado correctamente");
			repod.save(d);
		}
		else {
			model.addAttribute("mensaje", "Error al registrar");
			return cargarPag(model);
		}	
		return cargarPag(model);
	}
	
	@PostMapping("/eliminar")
	public String eliminarReg(@ModelAttribute Destino d, Model model) {
		
		repod.deleteById(d.getCodigo());
		return cargarPag(model);
	}
	
	/*  M E T O D O S  */
	public boolean validaDestino(Destino des) {
		String ciudad = des.getCiudad();
		String cod_postal = des.getCodpostal();
		int cod_region = des.getCodregion();
		String pais = des.getPais();
		
		if(ciudad == null || cod_postal == null || cod_region == -1 || pais == null) {
			System.out.println("valida false");
			return false;
		}
		else {
			System.out.println("valida true");
			return true;
		}
	}
	
	public String generaCodigo(String Codigo) {
		if(Codigo != "") {
			System.out.println("Codigo dif null: " + Codigo);
			return Codigo;
		}
		else {
			Codigo = repod.getMaxCodigoDestino();
			System.out.println("max codigo: " + Codigo);
			if(Codigo == null)
				return "D0001";
			else{
				Codigo = Codigo.substring(1, Codigo.length());
				int num = Integer.parseInt(Codigo)+1;
				int largo = (num+"").length();
				int repetir = 0;
				if(largo < 4)
					repetir = 4-largo;
				Codigo = "D" + "0".repeat(repetir) + num;
				System.out.println("Else: " + Codigo);
				return Codigo;
			}
		}
	}
}
