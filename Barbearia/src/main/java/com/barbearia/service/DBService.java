package com.barbearia.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.domain.Agendamento;
import com.barbearia.domain.Barbeiro;
import com.barbearia.domain.Cliente;
import com.barbearia.enums.Perfil;
import com.barbearia.enums.Servicos;
import com.barbearia.enums.Status;
import com.barbearia.repositories.AgendamentoRepository;
import com.barbearia.repositories.BarbeiroRepository;
import com.barbearia.repositories.ClienteRepository;

@Service
public class DBService {

	@Autowired
	private BarbeiroRepository barbeiroRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public void instanciaDB() {
		Barbeiro barbeiro1 = new Barbeiro("Arisio Andrade", "099.999.999.-92", "arisio@email.com", "123");
		barbeiro1.addPerfil(Perfil.BARBEIRO);
		
		Cliente cliente1 = new Cliente("Cliente 1", "099.999.999-93", "cliente1@email.com", "123");
		//cliente1.addPerfil(Perfil.CLIENTE);
		
		LocalDateTime dataAgendamento = LocalDateTime.of(2025, 9, 16, 14, 30); 
		Agendamento agendamento1 = new Agendamento(dataAgendamento, "Posso atrasar 10 minutos", cliente1, barbeiro1, Servicos.CORTE_DEGRADE, Status.PENDENTE);
		
        barbeiroRepository.saveAll(Arrays.asList(barbeiro1));
        clienteRepository.saveAll(Arrays.asList(cliente1));
        agendamentoRepository.saveAll(Arrays.asList(agendamento1));
	}
}
 