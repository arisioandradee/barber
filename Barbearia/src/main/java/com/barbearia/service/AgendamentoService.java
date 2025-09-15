package com.barbearia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.domain.Agendamento;
import com.barbearia.domain.Barbeiro;
import com.barbearia.domain.Cliente;
import com.barbearia.dto.AgendamentoDTO;
import com.barbearia.exceptions.ObjectNotFoundException;
import com.barbearia.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;
	@Autowired
	private BarbeiroService barbeiroService;
	@Autowired
	private ClienteService clienteService;
	
	public Agendamento findById(Integer id) {
		Optional<Agendamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " + id));
	}
	
	public List<AgendamentoDTO> findAll() {
		List<Agendamento> list = repository.findAll();
		return list.stream().map(AgendamentoDTO::new).collect(Collectors.toList());
	}
	
	public Agendamento create(AgendamentoDTO objDto) {
		Agendamento newObj = new Agendamento(objDto);
		Cliente cliente = clienteService.findById(objDto.getCliente());
		Barbeiro barbeiro = barbeiroService.findById(objDto.getBarbeiro());
		newObj.setCliente(cliente);
		newObj.setBarbeiro(barbeiro);
		return repository.save(newObj);
	}

	public Agendamento update(Integer id, AgendamentoDTO objDto) {
		Agendamento oldObj = findById(id);
		Cliente cliente = clienteService.findById(objDto.getCliente());
		Barbeiro barbeiro = barbeiroService.findById(objDto.getBarbeiro());
		
	    oldObj.setDataAgendamento(objDto.getDataAgendamento());
	    oldObj.setObservacoes(objDto.getObservacoes());
	    oldObj.setServico(objDto.getServico());
	    oldObj.setStatus(objDto.getStatus());
		oldObj.setCliente(cliente);
		oldObj.setBarbeiro(barbeiro);
	    
	    return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
