package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import entities.enums.SituacaoReserva;

public class Reserva {
	
	private String nomeResponsavel;
	private LocalDateTime dataReserva;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	
	private SituacaoReserva situcacaoReseva;

	public Reserva(String nomeResponsavel, LocalDateTime dataReserva, LocalDate dataEntrada, LocalDate dataSaida,
			SituacaoReserva situcacaoReseva) {
		super();
		this.nomeResponsavel = nomeResponsavel;
		this.dataReserva = dataReserva;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.situcacaoReseva = situcacaoReseva;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
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
		return "Reserva [Nome Responsavel=" + nomeResponsavel + ", data Reserva=" + dataReserva + ", data Entrada="
				+ dataEntrada + ", data Saida=" + dataSaida + ", situca caoReseva=" + situcacaoReseva + "]";
	}
	
}
