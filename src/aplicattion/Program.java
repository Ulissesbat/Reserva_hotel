package aplicattion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Apartamento;
import entities.CheckInOut;
import entities.Despesas;
import entities.Reserva;
import entities.enums.SituacaoApartamento;
import entities.enums.SituacaoReserva;

public class Program {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Iniciar uma reserva: ");
		System.out.println("-----------------------------------");
		System.out.println();
		System.out.println("Nome do responsavel: ");
		String nome = sc.nextLine();
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		System.out.println("Data e hora da reserva: " + fmt1.format(dataHoraAtual));

		LocalDate dataEntrada = null;
		LocalDate dataSaida = null;
		try {
			// Obter a data de entrada

			do {
				try {
					System.out.println("Data de entrada dd/MM/yyyy: ");
					dataEntrada = LocalDate.parse(sc.next(), fmt);

					// Validar se a data de entrada é posterior ao dia atual
					if (dataEntrada.isBefore(LocalDate.now())) {
						System.out.println("A data de entrada deve ser posterior ao dia atual. Tente novamente. ");
					}
				} catch (DateTimeParseException e) {
					System.out.println("Erro ao analisar a data. Formato incorreto. Tente novamente.");
					sc.nextLine(); // Limpar o buffer do scanner
					dataEntrada = null; // Definir a data como nula para repetir o loop
				}
			} while (dataEntrada == null || dataEntrada.isBefore(LocalDate.now()));

			// Obter a data de saída

			do {
				try {
					System.out.println("Data de saida dd/MM/yyyy: ");
					dataSaida = LocalDate.parse(sc.next(), fmt);

					// Validar se a data de saída é posterior à data de entrada
					if (dataSaida.isBefore(dataEntrada)) {
						System.out.println("A data de saída deve ser posterior à data de entrada. Tente novamente. ");
					}
				} catch (DateTimeParseException e) {
					System.out.println("Erro ao analisar a data. Formato incorreto. Tente novamente.");
					sc.nextLine(); // Limpar o buffer do scanner
					dataSaida = null; // Definir a data como nula para repetir o loop
				}
			} while (dataSaida == null || dataSaida.isBefore(dataEntrada));
		} catch (InputMismatchException e) {
			System.out.println("Erro de digitação " + e.toString());
			e.printStackTrace();
		}
		System.out.println("Situacao da reserva (REALIZADA, CONFIRMADA, CANCELADA, EFETIVA): ");
		String situacaoInput = sc.next().toUpperCase();

		SituacaoReserva situacaoReserva = SituacaoReserva.valueOf(situacaoInput);

		Reserva reserva = new Reserva(nome, dataHoraAtual, dataEntrada, dataSaida, situacaoReserva);

		System.out.println(reserva);

		System.out.println("--------------------------------------------------");
		System.out.println();

		System.out.println("Incluir um Check In para a reserva? SIM / NAO ");
		char resp = sc.next().toLowerCase().charAt(0);
		sc.nextLine();
		Apartamento apartamento = null;
		String placa = null;
		if (resp == 's') {
			System.out.println("Tipo do apartamento: ");
			String tipo = sc.nextLine();
			System.out.println("Numero do apartamento: ");
			int numero = sc.nextInt();
			System.out.println("Valor da diaria: ");
			double diaria = sc.nextDouble();

			apartamento = new Apartamento(tipo, numero, diaria);

			if (apartamento != null) {
				apartamento.setSituacaoApartamento(SituacaoApartamento.OCUPADO);
			}
			System.out.println("Placa do carro: ");
			placa = sc.next();

			System.out.println();
			CheckInOut in = new CheckInOut(reserva, apartamento, reserva.getDataEntrada(), reserva.getDataSaida(),
					placa);

			System.out.println("-------------CheckIn Realizado com sucesso!------------");
			System.out.println(in.toString());

			System.out.println("-------------------------------------------------------");
			System.out.println();
		} else {
			System.out.println("Programa encerrado.");
			System.exit(0);
		}
		System.out.println("Deseja incluir um Check Out? SIM / NAO");
		resp = sc.next().toLowerCase().charAt(0);
		sc.nextLine();

		if (resp == 's') {
			apartamento.setSituacaoApartamento(SituacaoApartamento.DISPONIVEL);
			System.out.println("Numero do apartamento: ");
			int numeroApartamentoCheckOut = sc.nextInt();

			// Enquanto o número do apartamento for diferente, continue pedindo o número
			// correto
			while (numeroApartamentoCheckOut != apartamento.getNumero()) {
				System.out.println("O número do apartamento não corresponde ao check-in.");
				System.out.println("Por favor, insira o número correto do apartamento: ");
				numeroApartamentoCheckOut = sc.nextInt(); // Solicita novamente o número
			}
			try {
				System.out.println("Numero Nota Fiscal: ");
				int notaFiscal = sc.nextInt();
				System.out.println("Numero Cupom Fiscal: ");
				int cupomFiscal = sc.nextInt();
				System.out.println("Existe Despesas adicionais? (sim / nao): ");
				char resposta = sc.next().toLowerCase().charAt(0);
				sc.nextLine();

				Despesas despesas = new Despesas(); // Inicializa despesas com valor zero

				if (resposta == 's') {
				   do {
				        System.out.println("Nome do produto: ");
				        String nomeProd = sc.nextLine();
				        System.out.println("Valor do produto: ");
				        Double valorProd = sc.nextDouble();

				        // Adiciona o produto à lista de despesas
				        despesas.adicionarProduto(nomeProd, valorProd);

				        System.out.println("Deseja adicionar mais produtos? (sim / nao): ");
				        resposta = sc.next().toLowerCase().charAt(0);
				        sc.nextLine();
				    }while(resposta == 's');
				}

				CheckInOut out = new CheckInOut(reserva.getDataEntrada(), reserva.getDataSaida(), apartamento,
						notaFiscal, cupomFiscal, despesas, placa);

				System.out.println("-------------CheckOut Realizado com sucesso!------------");
				System.out.println(out.toString());
				System.out.println("-------------------------------------------------------");
				// ... Restante do código do check-out ...
			} catch (InputMismatchException e) {
				System.out.println("Erro de digitação " + e.toString());
				e.printStackTrace();
				;
			}

		}

		sc.close();
	}

}
