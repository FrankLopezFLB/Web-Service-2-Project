package proy.serpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proy.serpost.model.Destino;

public interface IRepositoryDestino extends JpaRepository<Destino, String> {
	Destino findByCodigo(String codigo);
	
	@Query(value = "SELECT max(codigo) FROM Destino")
	String getMaxCodigoDestino();
	
}
