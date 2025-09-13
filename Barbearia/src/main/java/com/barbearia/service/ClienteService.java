package com.barbearia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.domain.Cliente;
import com.barbearia.dto.ClienteDTO;
import com.barbearia.exceptions.ObjectNotFoundException;
import com.barbearia.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: " + id));
	}
	
	
	public List<ClienteDTO> findAll() {
		List<Cliente> list = repository.findAll();
		return list.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}
	
	public Cliente create(ClienteDTO obj) {
		obj.setId(null);
		Cliente newObj = new Cliente(obj);
		return repository.save(newObj);
	}
	
	public Cliente update(Integer id, ClienteDTO obj) {
        Cliente existing = findById(id);
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
