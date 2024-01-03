package entities;

import java.time.LocalDateTime;

public class Despesas {
	private Integer numeroComanda;
	private LocalDateTime lancamento;
	private Double valor;
	
	public Despesas(Integer numeroComanda, LocalDateTime lancamento, Double valor) {
		this.numeroComanda = numeroComanda;
		this.lancamento = lancamento;
		this.valor = valor;
	}

	public Integer getNumeroComanda() {
		return numeroComanda;
	}

	public void setNumeroComanda(Integer numeroComanda) {
		this.numeroComanda = numeroComanda;
	}

	public LocalDateTime getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDateTime lancamento) {
		this.lancamento = lancamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public double totalDespesas() {
		
		return valor;
	}

}


