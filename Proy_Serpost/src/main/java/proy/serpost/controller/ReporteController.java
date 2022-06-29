package proy.serpost.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

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
private RestTemplate restTemplate;

/*  T I P O  */

@GetMapping("/cargarReporteTipo")
public String cargarReporteTipo(Model model) {
	Map<String, Object> lstReporteTipo = new HashMap<>();
	lstReporteTipo.put("data", new Reporte());
	
	model.addAttribute("lstTipoObjetos", repoto.findAll());
	model.addAttribute("tipoobjeto", new TipoObjeto(-1, null));
	model.addAttribute("lstReporteTipo", lstReporteTipo);
	
	return "reportetipo";
}	

@PostMapping("/filtrarReporteTipo")
public String filtrarReporteTipo(@ModelAttribute TipoObjeto tipoobjeto, Model model) {
	String url = "http://localhost:8081/api/reportetipo/"+ tipoobjeto.getCodigo();
	try {
	Object listaReporte = restTemplate.getForObject(url, Object.class);
		
	model.addAttribute("tipoobjeto", tipoobjeto);
	
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
	Map<String, Object> lstReporteTipo = new HashMap<>();
	lstReporteTipo.put("data", new Reporte());
	
	model.addAttribute("auxfecha", new AuxiliarFecha());
	model.addAttribute("lstReporteFecha", lstReporteTipo);
	return "reportefecha";
}

@PostMapping("/filtrarReporteFecha")
public String filtrarReporteFecha(@ModelAttribute AuxiliarFecha auxfecha, Model model) {
	String url = "http://localhost:8081/api/reportefecha/"+ auxfecha.getFec1() + "/" + auxfecha.getFec2();
	
	try {
	Object listaReporte = restTemplate.getForObject(url, Object.class);
	model.addAttribute("auxfecha", auxfecha);
	
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

