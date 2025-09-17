package com.barbearia.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.barbearia.enums.Servicos;
import com.barbearia.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	protected LocalDateTime dataAgendamento;
	protected String observacoes;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	protected Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "barbeiro_id")
	protected Barbeiro barbeiro;
	@NotNull
	protected Servicos servico;
	@Enumerated(EnumType.STRING)
	protected Status status;
	
	public Agendamento(LocalDateTime dataAgendamento, String observacoes, Cliente cliente, Barbeiro barbeiro, Servicos servico, Status status) {
		this.dataAgendamento = dataAgendamento;
		this.observacoes = observacoes;
		this.cliente = cliente;
		this.barbeiro = barbeiro;
		this.servico = servico;
		this.status = Status.PENDENTE;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
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
