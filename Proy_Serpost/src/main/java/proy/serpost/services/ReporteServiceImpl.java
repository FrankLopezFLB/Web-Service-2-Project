package proy.serpost.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proy.serpost.model.Reporte;
import proy.serpost.repository.IRepositoryReporte;
@Service
public class ReporteServiceImpl implements IReporteService {
	@Autowired
	private IRepositoryReporte reporteRepository;

	@Override
	public List<Reporte> spReportexFecha(String fec1, String fec2) {
		List<Reporte> repor = this.reporteRepository.spReportexFecha(fec1, fec2);
		return repor;
	}

	@Override
	public List<Reporte> spReportexTipo(int tipo) {
		List<Reporte> repor = this.reporteRepository.spReportexTipo(tipo);
		return repor;
	}

}
