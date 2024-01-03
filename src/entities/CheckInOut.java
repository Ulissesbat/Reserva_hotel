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
	private LocalDate saida;
	private String placaCarro;
	private Integer numeroNFS;
	private Integer numeroCupomFiscal;
	private Despesas despesas;
	

	public CheckInOut(Reserva reserva, Apartamento apartamento, LocalDate entrada, LocalDate saida,String placaCarro) {
		super();
		this.reserva = reserva;
		this.apartamento = apartamento;
		this.entrada = entrada;
		this.saida = saida;
		this.placaCarro = placaCarro;
	}
	
	public CheckInOut(Apartamento apartamento,Integer numeroNFS, Integer numeroCupomFiscal) {
        this.apartamento = apartamento;        
        this.numeroNFS = numeroNFS;
        this.numeroCupomFiscal = numeroCupomFiscal;
        
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

	public LocalDate getSaida() {
		return saida;
	}

	public void setSaida(LocalDate saida) {
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
    private double ValorBaseEstadia(Duration duracaoEstadia) {
        long diasEstadia = duracaoEstadia.toDays();

        return apartamento.getValorDiaria() * diasEstadia;
    }

    // Método para calcular o valor total da estadia
    public double TotalEstadia() {
        Duration duracaoEstadia = Duration.between(entrada, saida);
        double valorTotal = ValorBaseEstadia(duracaoEstadia);

        // Adicionar despesas adicionais, se houver
        valorTotal += (despesas != null ? despesas.totalDespesas() : 0.0);

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
	    StringBuilder sb = new StringBuilder("");

	    sb.append("").append(apartamento).append(",\n");
	    sb.append("  Entrada = ").append(entrada).append(",\n");
	    sb.append("  Saida = ").append(saida).append(",\n");
	    sb.append("  Placa Carro = ").append(placaCarro).append("\n");
	    sb.append("--------------------------------------------");
	    // Adiciona informações específicas do segundo construtor, se existirem
	    if (numeroNFS != null && numeroCupomFiscal != null && despesas != null) {
	        sb.append("  Numero NFS = ").append(numeroNFS).append(",\n");
	        sb.append("  Numero Cupom Fiscal = ").append(numeroCupomFiscal).append(",\n");
	        sb.append("  Despesas = ").append(String.format("%2f",despesas)).append("\n");
	    }

	    sb.append("");

	    return sb.toString();
	}


	
}
