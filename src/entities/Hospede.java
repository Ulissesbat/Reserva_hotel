package entities;

import java.time.LocalDate;

import entities.enums.SituacaoReserva;

public class Hospede {
	
	private Integer id;
	private String Nome;
	private LocalDate entrada;
	private LocalDate saida;
	private String tipo;
	private Integer numero;
	
	private SituacaoReserva situacaoReserva;
	
	private String email;
	private String documento;
	private Double valorDiaria;
	private Double valorTotal;
	
	public Hospede() {
		
	}

	public Hospede(Integer id, String nome, LocalDate entrada, LocalDate saida, String tipo, Integer numero,
			SituacaoReserva situacaoReserva, String email, String documento, Double valorDiaria, Double valorTotal) {
		
		this.Nome = nome;
		this.id = id;
		this.entrada = entrada;
		this.saida = saida;
		this.tipo = tipo;
		this.numero = numero;
		this.situacaoReserva = situacaoReserva;
		this.email = email;
		this.documento = documento;
		this.valorDiaria = valorDiaria;
		this.valorTotal = valorTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public LocalDate getSaida() {
		return saida;
	}

	public void setSaida(LocalDate saida) {
		this.saida = saida;
	}

	public SituacaoReserva getSituacaoReserva() {
		return situacaoReserva;
	}

	public void setSituacaoReserva(SituacaoReserva situacaoReserva) {
		this.situacaoReserva = situacaoReserva;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "\nHospede "
				+ "\nNome = " + Nome +
				"\n, entrada = " + entrada + 
				"\n, saida = " + saida + 
				"\n, situacaoReserva = " + situacaoReserva + 
				"\n, email = " + email + 
				"\n, documento = " + documento+ 
				"\n, valor Diaria = " + valorTotal+ 
				"\n, Tipo do Apartamento = " + tipo +
				"\n, Numero do Apartamento = " + numero +
				"\n, Valor Total  = " + valorTotal;
	}

}
