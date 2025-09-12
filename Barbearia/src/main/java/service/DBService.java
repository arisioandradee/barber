package service;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Agendamento;
import domain.Barbeiro;
import domain.Cliente;
import enums.Perfil;
import enums.Servico;
import enums.Status;
import repository.AgendamentoRepository;
import repository.BarbeiroRepository;
import repository.ClienteRepository;

@Service
public class DBService {

	@Autowired
	private BarbeiroRepository barbeiroRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public void instanciaDB() {
		Barbeiro barbeiro1 = new Barbeiro("Arisio Andrade", "099.999.999.-92", 22, "arisio@email.com", "123");
		barbeiro1.addPerfil(Perfil.BARBEIRO);
		
		Cliente cliente1 = new Cliente("Cliente 1", "099.999.999-93", 19, "cliente1@email.com", "123");
		//cliente1.addPerfil(Perfil.CLIENTE);
		
		LocalDateTime dataAgendamento = LocalDateTime.of(2025, 9, 16, 14, 30); 
		Agendamento agendamento1 = new Agendamento("Posso atrasar 10 minutos", dataAgendamento, Servico.CABELO_DEGRADE, barbeiro1, cliente1, Status.PENDENTE);
		
        barbeiroRepository.saveAll(Arrays.asList(barbeiro1));
        clienteRepository.saveAll(Arrays.asList(cliente1));
        agendamentoRepository.saveAll(Arrays.asList(agendamento1));
	}
}
 