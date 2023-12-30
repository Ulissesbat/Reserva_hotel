package entities.interfaces;

import entities.enums.SituacaoApartamento;

public interface ApartamentoInterface {
	String getTipo();
    Integer getNumero();
    SituacaoApartamento getSituacaoApartamento();
    Double getValorDiaria();

}
