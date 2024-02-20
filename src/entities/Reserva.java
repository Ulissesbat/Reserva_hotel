package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.enums.SituacaoReserva;

public class Reserva implements Serializable {
	
	private static final long serialVersionUID = 1L;

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	private String nomeResponsavel;
	private String email;
	private String documento;
	private LocalDateTime dataReserva;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	
	private SituacaoReserva situcacaoReseva;

	public Reserva(String nomeResponsavel, String email, String documento, LocalDateTime dataReserva, LocalDate dataEntrada, LocalDate dataSaida,
			SituacaoReserva situcacaoReseva) {
		super();
		this.nomeResponsavel = nomeResponsavel;
		this.email = email;
		this.documento = documento;
		this.dataReserva = dataReserva;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.situcacaoReseva = situcacaoReseva;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
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

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public LocalDateTime getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDateTime dataReserva) {
		this.dataReserva = dataReserva;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public SituacaoReserva getSitucacaoReseva() {
		return situcacaoReseva;
	}

	public void setSitucacaoReseva(SituacaoReserva situcacaoReseva) {
		this.situcacaoReseva = situcacaoReseva;
	}

	@Override
	public String toString() {
	    return "\n-----------------Reserva Criada:----------------------" +
	    		
	    		"\nNome Responsavel = " + nomeResponsavel + 
	           "\nData Reserva = " + dataReserva.format(fmt) + 
	           "\nData Entrada = " + dataEntrada + 
	           "\nData Saida = " + dataSaida + 
	           "\nSituação Reserva = " + situcacaoReseva +
	    		"\nEmail = " + email + 
	    		"\nDocumento = " + documento;
	}

	
}
