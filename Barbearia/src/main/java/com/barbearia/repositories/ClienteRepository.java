package com.barbearia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
