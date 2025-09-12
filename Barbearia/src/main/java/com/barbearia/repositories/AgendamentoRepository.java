package com.barbearia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.domain.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{

}