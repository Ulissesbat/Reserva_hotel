package entities;

import entities.enums.SituacaoApartamento;

public class Apartamento {
	
	private String tipo;
	private Integer numero;
	private SituacaoApartamento situacaoApartamento;
	private Double valorDiaria;
	
	public Apartamento(String tipo, Integer numero, SituacaoApartamento situacaoApartamento, Double valorDiaria) {
		this.tipo = tipo;
		this.numero = numero;
		this.situacaoApartamento = situacaoApartamento;
		this.valorDiaria = valorDiaria;
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

	public SituacaoApartamento getSituacaoApartamento() {
		return situacaoApartamento;
	}

	public void setSituacaoApartamento(SituacaoApartamento situacaoApartamento) {
		this.situacaoApartamento = situacaoApartamento;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@Override
	public String toString() {
	    return "-----------------Apartamento----------------\n" +
	            "  Tipo = " + tipo + "\n" +
	            "  Numero = " + numero + "\n" +
	            "  Situacao Apartamento = " + situacaoApartamento + "\n" +
	            "  Valor Diaria = " +String.format("%2f", valorDiaria);
	}

	
	
}
