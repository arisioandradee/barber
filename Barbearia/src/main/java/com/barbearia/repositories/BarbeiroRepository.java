package com.barbearia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.domain.Barbeiro;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Integer>{

}
