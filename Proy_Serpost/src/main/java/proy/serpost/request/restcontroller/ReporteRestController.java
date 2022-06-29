package proy.serpost.request.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proy.serpost.model.Reporte;
import proy.serpost.response.http.HttpResponseObject;
import proy.serpost.services.ReporteServiceImpl;

@RestController
@RequestMapping("/api")
public class ReporteRestController {

	@Autowired
	private ReporteServiceImpl reporteService;
	
	@RequestMapping(path="reportefecha/{fec1}/{fec2}", method = RequestMethod.GET)
	public HttpResponseObject reportexfecha(@PathVariable(name="fec1") String fec1,@PathVariable(name="fec2") String fec2) {
		List<Reporte> report = this.reporteService.spReportexFecha(fec1, fec2);
		if(report.size()==0)
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND,null);
		return new HttpResponseObject("success", HttpStatus.OK,report);
	}
		
	
	@GetMapping("reportetipo/{tipo}")
	public HttpResponseObject reportexTipo(@PathVariable(name="tipo") int tipo) {
		List<Reporte> repor = this.reporteService.spReportexTipo(tipo);
		if(repor.size()==0)
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND,null);
		return new HttpResponseObject("success", HttpStatus.OK,repor);
		
	}
}
