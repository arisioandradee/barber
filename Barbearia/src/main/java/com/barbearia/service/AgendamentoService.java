package com.barbearia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.domain.Agendamento;
import com.barbearia.dto.AgendamentoDTO;
import com.barbearia.exceptions.ObjectNotFoundException;
import com.barbearia.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;
	
	public Agendamento findById(Integer id) {
		Optional<Agendamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " + id));
	}
	
	public List<AgendamentoDTO> findAll() {
		List<Agendamento> list = repository.findAll();
		return list.stream().map(AgendamentoDTO::new).collect(Collectors.toList());
	}
	
	public Agendamento create(AgendamentoDTO obj) {
		obj.setId(null);
		Agendamento newObj = new Agendamento(obj);
		return repository.save(newObj);
	}

	//public Agendamento update(Integer id, AgendamentoDTO obj) {}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
