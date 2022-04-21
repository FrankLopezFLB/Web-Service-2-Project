package proy.serpost.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import proy.serpost.model.AuxiliarFecha;
import proy.serpost.model.Reporte;
import proy.serpost.model.TipoObjeto;
import proy.serpost.repository.IRepositoryReporte;
import proy.serpost.repository.IRepositoryTipoObjeto;

@Controller
public class ReporteController {

	/*  R E P O S I T O R I O S  */
	
	@Autowired
	private IRepositoryTipoObjeto repoto;
	
	@Autowired
	private IRepositoryReporte repor;
	
	/*  T I P O  */
	
	@GetMapping("/cargarReporteTipo")
	public String cargarReporteTipo(Model model) {
		model.addAttribute("lstTipoObjetos", repoto.findAll());
		model.addAttribute("tipoobjeto", new TipoObjeto(-1, null));
		model.addAttribute("lstReporteTipo", new Reporte());
		
		return "reportetipo";
	}	

	@PostMapping("/filtrarReporteTipo")
	public String filtrarReporteTipo(@ModelAttribute TipoObjeto tipoobjeto, Model model) {
		try {
		model.addAttribute("tipoobjeto", tipoobjeto);
		
		List<Reporte> listaReporte = repor.spReportexTipo(tipoobjeto.getCodigo());
		model.addAttribute("lstReporteTipo", listaReporte);
		
		System.out.println(listaReporte);
				
		
		model.addAttribute("lstTipoObjetos", repoto.findAll());
		return "reportetipo";
		}
		catch(Exception e) {
			System.out.println("Combo inválido");
			return "reportetipo";
		}
	}
	
	/*  F E C H A  */
	
	@GetMapping("/cargarReporteFecha")
	public String cargarReporteFecha(Model model) {
		model.addAttribute("auxfecha", new AuxiliarFecha());
		model.addAttribute("lstReporteFecha", new Reporte());
		return "reportefecha";
	}
	
	@PostMapping("/filtrarReporteFecha")
	public String filtrarReporteFecha(@ModelAttribute AuxiliarFecha auxfecha, Model model) {
		try {
		model.addAttribute("auxfecha", auxfecha);
		
		List<Reporte> listaReporte = repor.spReportexFecha(auxfecha.getFec1(), auxfecha.getFec2());
		model.addAttribute("lstReporteFecha", listaReporte);
		
		System.out.println(listaReporte);
			return "reportefecha";
		}
		catch(Exception e) {
			System.out.println("Fechas vacías");
			return "reportefecha";
		}
	}
}

