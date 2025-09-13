package com.barbearia.dto;

import java.time.LocalDateTime;

import com.barbearia.domain.Agendamento;
import com.barbearia.enums.Servicos;
import com.barbearia.enums.Status;

public class AgendamentoDTO {

	private Integer id;
	private LocalDateTime dataAgendamento;
	private String observacoes;
	private Integer cliente;
    private Integer barbeiro;
	private Servicos servico;
	private Status status;
	
	public AgendamentoDTO() {
		super();
	}
	
	public AgendamentoDTO(Agendamento obj) {
		super();
		this.id = obj.getId();
		this.dataAgendamento = obj.getDataAgendamento();
		this.observacoes = obj.getObservacoes();
		this.servico = obj.getServico();
		this.status =obj.getStatus();
		
		if (obj.getBarbeiro() != null) {
            this.barbeiro = obj.getBarbeiro().getId();
        }
        if (obj.getCliente() != null) {
            this.cliente = obj.getCliente().getId();
        }
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Integer barbeiro) {
		this.barbeiro = barbeiro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Servicos getServico() {
		return servico;
	}

	public void setServico(Servicos servico) {
		this.servico = servico;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}