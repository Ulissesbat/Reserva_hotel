package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import entities.enums.SituacaoReserva;

public class CheckInOut extends Reserva {

	private LocalDateTime entrada;
	private LocalDateTime saida;
	private String placaCarro;
	private Integer numeroNFS;
	private Integer numeroCupomFiscal;
	private Despesas despesas;
	private double valorDiaria;
	

	public CheckInOut(String nomeResponsavel, LocalDateTime dataReserva, LocalDate dataEntrada, LocalDate dataSaida,
			SituacaoReserva situcacaoReseva, LocalDateTime entrada, LocalDateTime saida, String placaCarro,
			Integer numeroNFS, Integer numeroCupomFiscal, Despesas despesas, double valorDiaria) {
		super(nomeResponsavel, dataReserva, dataEntrada, dataSaida, situcacaoReseva);
		this.entrada = entrada;
		this.saida = saida;
		this.placaCarro = placaCarro;
		this.numeroNFS = numeroNFS;
		this.numeroCupomFiscal = numeroCupomFiscal;
		this.despesas = despesas;
		this.valorDiaria = valorDiaria;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
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

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	// Método para calcular o valor base da estadia com base no valor da diária
    private double calcularValorBaseEstadia(Duration duracaoEstadia) {
        long diasEstadia = duracaoEstadia.toDays();

        return valorDiaria * diasEstadia;
    }

    // Método para calcular o valor total da estadia
    public double calcularValorTotalEstadia() {
        Duration duracaoEstadia = Duration.between(entrada, saida);
        double valorTotal = calcularValorBaseEstadia(duracaoEstadia);

        // Adicionar despesas adicionais, se houver
        valorTotal += (despesas != null ? despesas.calcularTotalDespesas() : 0.0);

        return valorTotal;
    }
}
