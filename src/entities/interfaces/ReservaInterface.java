package entities.interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;

import entities.enums.SituacaoReserva;

public interface ReservaInterface {
	String getNomeResponsavel();
    LocalDateTime getDataReserva();
    LocalDate getDataEntrada();
    LocalDate getDataSaida();
    SituacaoReserva getSitucacaoReseva();

}
