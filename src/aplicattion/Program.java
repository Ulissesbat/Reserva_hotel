package aplicattion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Reserva;
import entities.enums.SituacaoReserva;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Iniciar uma reserva: ");
		System.out.println("Nome do responsavel: ");
		String nome = sc.nextLine();
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		System.out.println("Data e hora da reserva: " + fmt1.format(dataHoraAtual));
		
		// Obter a data de entrada
        LocalDate dataEntrada;
        do {
            System.out.println("Data de entrada dd/MM/yyyy (deve ser depois do dia atual): ");
            dataEntrada = LocalDate.parse(sc.next(), fmt);

            // Validar se a data de entrada é posterior ao dia atual
            if (dataEntrada.isBefore(LocalDate.now())) {
                System.out.println("A data de entrada deve ser posterior ao dia atual. Tente novamente.");
            }
        } while (dataEntrada.isBefore(LocalDate.now()));
		
		
		// Obter a data de saída
        LocalDate dataSaida;
        do {
            System.out.println("Data de saida dd/MM/yyyy:  ");
            dataSaida = LocalDate.parse(sc.next(), fmt);

            // Validar se a data de saída é posterior à data de entrada
            if (dataSaida.isBefore(dataEntrada)) {
                System.out.println("A data de saída deve ser posterior à data de entrada. Tente novamente.");
            }
        } while (dataSaida.isBefore(dataEntrada));
		
		
		System.out.println("Situacao da reserva (REALIZADA, CONFIRMADA, CANCELADA, EFETIVA): ");
        String situacaoInput = sc.next().toUpperCase();
        
        SituacaoReserva situacaoReserva = SituacaoReserva.valueOf(situacaoInput);
		
        Reserva reserva = new Reserva(nome, dataHoraAtual, dataEntrada, dataSaida, situacaoReserva);
        
        System.out.println(reserva);

		sc.close();
	}

}
