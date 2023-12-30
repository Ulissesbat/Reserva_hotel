package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import entities.enums.SituacaoApartamento;
import entities.enums.SituacaoReserva;
import entities.interfaces.ApartamentoInterface;
import entities.interfaces.ReservaInterface;

public class CheckInOut implements ReservaInterface, ApartamentoInterface {

	private Reserva reserva;
    private Apartamento apartamento;
	private LocalDate entrada;
	private LocalDateTime saida;
	private String placaCarro;
	private Integer numeroNFS;
	private Integer numeroCupomFiscal;
	private Despesas despesas;
	

	public CheckInOut(Reserva reserva, Apartamento apartamento, LocalDate entrada,String placaCarro) {
		super();
		this.reserva = reserva;
		this.apartamento = apartamento;
		this.entrada = entrada;
		this.placaCarro = placaCarro;
	}
	
	public CheckInOut(Apartamento apartamento, LocalDateTime saida,
            Integer numeroNFS, Integer numeroCupomFiscal, Despesas despesas) {
        this.apartamento = apartamento;
        this.saida = saida;
        this.numeroNFS = numeroNFS;
        this.numeroCupomFiscal = numeroCupomFiscal;
        this.despesas = despesas;
        
    }

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public Integer getNumeroNFS() {
		return numeroNFS;
	}

	public void setNumeroNFS(Integer numeroNFS) {
		this.numeroNFS = numeroNFS;
	}

	public Integer getNumeroCupomFiscal() {
		return numeroCupomFiscal;
	}

	public void setNumeroCupomFiscal(Integer numeroCupomFiscal) {
		this.numeroCupomFiscal = numeroCupomFiscal;
	}

	public Despesas getDespesas() {
		return despesas;
	}

	public void setDespesas(Despesas despesas) {
		this.despesas = despesas;
	}


	// Método para calcular o valor base da estadia com base no valor da diária
    private double calcularValorBaseEstadia(Duration duracaoEstadia) {
        long diasEstadia = duracaoEstadia.toDays();

        return apartamento.getValorDiaria() * diasEstadia;
    }

    // Método para calcular o valor total da estadia
    public double calcularValorTotalEstadia() {
        Duration duracaoEstadia = Duration.between(entrada, saida);
        double valorTotal = calcularValorBaseEstadia(duracaoEstadia);

        // Adicionar despesas adicionais, se houver
        valorTotal += (despesas != null ? despesas.calcularTotalDespesas() : 0.0);

        return valorTotal;
    }

	@Override
	public String getTipo() {
		
		return apartamento.getTipo();
	}

	@Override
	public Integer getNumero() {
		
		return apartamento.getNumero();
	}

	@Override
	public SituacaoApartamento getSituacaoApartamento() {
		
		return apartamento.getSituacaoApartamento();
	}

	@Override
	public String getNomeResponsavel() {
	
		return reserva.getNomeResponsavel();
	}

	@Override
	public LocalDateTime getDataReserva() {
		
		return reserva.getDataReserva();
	}

	@Override
	public LocalDate getDataEntrada() {
		
		return reserva.getDataEntrada();
	}

	@Override
	public LocalDate getDataSaida() {
		
		return reserva.getDataSaida();
	}

	@Override
	public SituacaoReserva getSitucacaoReseva() {
		
		return reserva.getSitucacaoReseva();
	}

	@Override
	public Double getValorDiaria() {
		
		return apartamento.getValorDiaria();
	}

	@Override
	public String toString() {
	    return "CheckIn [\n" +
	           "  reserva=" + reserva + 
	           ",\n  apartamento=" + apartamento + 
	           ",\n  entrada=" + entrada + 
	           ",\n  saida=" + saida + 
	           ",\n  placaCarro=" + placaCarro + 
	           ",\n  numeroNFS=" + numeroNFS + 
	           ",\n  numeroCupomFiscal=" + numeroCupomFiscal + 
	           ",\n  despesas=" + despesas + 
	           "\n]";
	}

	
}
