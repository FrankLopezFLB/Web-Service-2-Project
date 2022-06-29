package proy.serpost.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import proy.serpost.model.Reporte;


public interface IReporteService {
	@Query(value = "call REPORTEXFECHA(?1,?2)", nativeQuery = true)
	List<Reporte> spReportexFecha(String fec1, String fec2);
	
	@Query(value = "call REPORTEXTIPO(?1)", nativeQuery = true)
	List<Reporte> spReportexTipo(int tipo);
}
