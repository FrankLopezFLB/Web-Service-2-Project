package proy.serpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proy.serpost.model.Vehiculo;

public interface IRepositoryVehiculo extends JpaRepository<Vehiculo, String>{
	@Query(value = "SELECT max(codigo) FROM Vehiculo")
	String getMaxCodigoVehiculo();
}