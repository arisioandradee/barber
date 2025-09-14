package com.barbearia.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.barbearia.domain.Agendamento;
import com.barbearia.dto.AgendamentoDTO;
import com.barbearia.service.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {
	
	@Autowired
    private AgendamentoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendamentoDTO> findById(@PathVariable Integer id) {
        Agendamento obj = service.findById(id);
        return ResponseEntity.ok().body(new AgendamentoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> findAll() {
        List<AgendamentoDTO> listDTO = service.findAll();
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> create(@RequestBody AgendamentoDTO obj) {
        Agendamento newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(new AgendamentoDTO(newObj));
    }

    //@PutMapping(value = "/{id}")
    //public ResponseEntity<AgendamentoDTO> update(@PathVariable Integer id, @RequestBody ClienteDTO obj) {}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
