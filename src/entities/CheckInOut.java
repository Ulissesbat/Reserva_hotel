package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import entities.enums.SituacaoApartamento;
import entities.enums.SituacaoReserva;
import entities.interfaces.ApartamentoInterface;
import entities.interfaces.ReservaInterface;

public class CheckInOut implements ReservaInterface, ApartamentoInterface, Serializable{

	private static final long serialVersionUID = 1L;
	
	private Reserva reserva;
	private Apartamento apartamento;
	private LocalDate entrada;
	private LocalDate saida;
	private String placaCarro;
	private Integer numeroNFS;
	private Integer numeroCupomFiscal;
	private Despesas despesas;

	public CheckInOut(Reserva reserva, Apartamento apartamento, LocalDate entrada, LocalDate saida, String placaCarro) {
		super();
		this.reserva = reserva;
		this.apartamento = apartamento;
		this.entrada = entrada;
		this.saida = saida;
		this.placaCarro = placaCarro;
	}

	public CheckInOut(LocalDate entrada, LocalDate saida, Apartamento apartamento, Integer numeroNFS,
			Integer numeroCupomFiscal, Despesas despesas, String placaCarro) {
		this.entrada = entrada;
		this.saida = saida;
		this.apartamento = apartamento;
		this.numeroNFS = numeroNFS;
		this.numeroCupomFiscal = numeroCupomFiscal;
		this.despesas = despesas;
		this.placaCarro = placaCarro;

	}

	public CheckInOut() {
		
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
	private double ValorBaseEstadia(LocalDate entrada, LocalDate saida) {
		long diasEstadia = ChronoUnit.DAYS.between(entrada, saida);
		return apartamento.getValorDiaria() * diasEstadia;
	}

	// Método para calcular o valor total da estadia

	public double TotalEstadia() {
	
		// Adicionar despesas adicionais, se houver
		double valorTotal = ValorBaseEstadia(entrada, saida) + (despesas != null ? despesas.totalDespesas() : 0.0);

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

		sb.append("  Tipo = ").append(apartamento.getTipo()).append("\n");
		sb.append("  Numero = ").append(apartamento.getNumero()).append("\n");
		sb.append("  Situacao = ").append(apartamento.getSituacaoApartamento()).append("\n");
		sb.append("  Valor diaria = ").append(String.format("%.2f", getValorDiaria())).append("\n");
		sb.append("  Entrada = ").append(entrada).append("\n");
		sb.append("  Saida = ").append(saida).append("\n");
		sb.append("  Placa Carro = ").append(placaCarro).append("\n");

		// Adiciona informações específicas do segundo construtor, se existirem
		if (numeroNFS != null && numeroCupomFiscal != null && despesas != null) {
			sb.append("\n");
			sb.append("  Numero NFS = ").append(numeroNFS).append("\n");
			sb.append("  Numero cupom fiscal = ").append(numeroCupomFiscal).append("\n");
			double estadiaSemDespesas = ValorBaseEstadia(entrada, saida);
			sb.append("\n");
			sb.append("  Estadia = ").append(String.format("%.2f", estadiaSemDespesas)).append("\n");
			sb.append("  Valor total com despesas = ").append(String.format("%.2f", TotalEstadia())).append("\n");
			sb.append("  Despesas adicionais = ").append(String.format("%.2f", despesas.totalDespesas())).append("\n");
			sb.append("\n");
			sb.append("Produtos consumidos:\n");
			sb.append("");
			if (despesas != null) {
				despesas.produtos.forEach((nomeProduto, valorProduto) -> {
					sb.append("Item: ").append(nomeProduto).append(", Valor: ").append(String.format("%.2f", valorProduto)).append("\n");
				});
			}
		}

		sb.append("\n");

		return sb.toString();
	}

}
