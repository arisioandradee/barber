package com.barbearia.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.barbearia.domain.Barbeiro;
import com.barbearia.dto.BarbeiroDTO;
import com.barbearia.service.BarbeiroService;

@RestController
@RequestMapping(value = "/barbeiros")
public class BarbeiroResource {

	@Autowired
	private BarbeiroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BarbeiroDTO> findById(@PathVariable Integer id) {
		Barbeiro obj = service.findById(id);
		return ResponseEntity.ok().body(new BarbeiroDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<BarbeiroDTO>> findAll(){
		List<BarbeiroDTO> listDTO = service.findAll();
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<BarbeiroDTO> create(@RequestBody BarbeiroDTO obj){
		Barbeiro newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(new BarbeiroDTO(newObj));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<BarbeiroDTO> update(@PathVariable Integer id, @RequestBody BarbeiroDTO obj){
		Barbeiro updateObj = service.update(id, obj);
		return ResponseEntity.ok().body(new BarbeiroDTO(updateObj));
	}
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
