package com.barbearia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.domain.Barbeiro;
import com.barbearia.dto.BarbeiroDTO;
import com.barbearia.exceptions.ObjectNotFoundException;
import com.barbearia.repositories.BarbeiroRepository;

@Service
public class BarbeiroService {

	@Autowired
	private BarbeiroRepository repository;
	
	public Barbeiro findById(Integer id) {
		Optional<Barbeiro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Barbeiro não encontrado! ID: " + id));
	}
	
	public List<BarbeiroDTO> findAll() {
		List<Barbeiro> list = repository.findAll();
		return list.stream().map(BarbeiroDTO::new).collect(Collectors.toList());
	}
	
	public Barbeiro create(BarbeiroDTO obj) {
		obj.setId(null);
		Barbeiro newObj = new Barbeiro(obj);
		return repository.save(newObj);
	}

	public Barbeiro update(Integer id, BarbeiroDTO obj) {
		Barbeiro existing = findById(id);
        existing.setNome(obj.getNome());
        existing.setCpf(obj.getCpf());
        existing.setEmail(obj.getEmail());
        return repository.save(existing);
	}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
