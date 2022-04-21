package proy.serpost.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proy.serpost.model.Reporte;

public interface IRepositoryReporte extends JpaRepository<Reporte, String> {
	
	@Query(value = "call REPORTEXFECHA(?1,?2)", nativeQuery = true)
	List<Reporte> spReportexFecha(String fec1, String fec2);
	
	@Query(value = "call REPORTEXTIPO(?1)", nativeQuery = true)
	List<Reporte> spReportexTipo(int tipo);

}
