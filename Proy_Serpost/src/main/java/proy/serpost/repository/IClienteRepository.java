package proy.serpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proy.serpost.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
