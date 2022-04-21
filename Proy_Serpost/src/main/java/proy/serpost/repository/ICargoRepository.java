package proy.serpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proy.serpost.model.Cargo;

@Repository
public interface ICargoRepository extends JpaRepository<Cargo,Integer>{

}
