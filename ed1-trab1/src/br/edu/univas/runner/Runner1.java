package br.edu.univas.runner;

import java.util.Scanner;

import br.edu.univas.vo.Peca;
import br.edu.univas.vo.PecaList;
import br.edu.univas.vo.PecaNode;
import br.edu.univas.vo.View;

public class Runner1 {

	public static Scanner scanner = new Scanner(System.in);
	static View view = new View();

	public static void main(String[] args) throws InterruptedException {

		PecaList pecas = new PecaList();
		PecaList pecasComputador = new PecaList();
		PecaList pecasPlayer1 = new PecaList();
		PecaList pecasJogadas = new PecaList();

		pecas.criaPecas();
		
		
		pecas.distribuiPecas(pecasPlayer1, pecas);
		pecas.distribuiPecas(pecasComputador, pecas);
		view.Start();
		int escolha = 0;

		boolean fim = false;

		do {

			fim = jogoPlayer1(pecasPlayer1, pecasJogadas, pecas);
			if (fim == true) {
				view.msgGanhou();
				break;
			}

			fim = jogoComputador(pecasComputador, pecasJogadas);
			if (fim == true) {
				view.msgPerdeu();
				break;
			}

		} while (fim == false);

	}

	private static boolean jogoComputador(PecaList pecasComputador, PecaList pecasJogadas) throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(1000);

		String valida = "Suas pe�as acabaram!!!!";

		view.msgVezDoComputador();

		boolean jogoAcabou = false;
		boolean aux = false;

		Peca peca;

		int number = 0;

		while (true) {

			int isValid = pecasComputador.listaAmount(pecasComputador);

			if (number <= isValid) {

				peca = pecasComputador.getElementAt(number);

				aux = pecasJogadas.move(pecasJogadas, peca);

				if (aux == true) {

					peca = pecasComputador.remove(peca.toString());

					break;

				} else {

					number += 1;
				}
			} else {
				view.msgComputadorPassouAVez();
				
				break;

			}

		}
		view.msgPecasJogadas();
		System.out.println(pecasJogadas.getAsString());
		if (valida.equals(pecasComputador.getAsString())) {

			jogoAcabou = true;

		}

		return jogoAcabou;
	}

	public static int readInt() {

		int leitura = scanner.nextInt();
		scanner.nextLine();
		return leitura;
	}

	public static boolean jogoPlayer1(PecaList pecasPlayer1, PecaList pecasJogadas, PecaList pecas) {

		String valida = "Suas pe�as acabaram!!!!";

		Peca peca;

		view.Playing();

		boolean gameFinished = false;
		int number;
		while (true) {

			System.out.println(pecasPlayer1.getAsString());
			number = readInt();

			if (number == 8) {
				break;
			}
			
			else if (number == 10 ) {
				
				comprarPecas(pecasPlayer1, pecas);
				continue;
			}
			number -= 1;

			int isValid = pecasPlayer1.listaAmount(pecasPlayer1);

			if (number <= isValid && number >= 0) {
				break;
			}

			view.msgErro();

		}

		peca = pecasPlayer1.getElementAt(number);
		boolean aux = pecasJogadas.move(pecasJogadas, peca);
		if (aux == true) {
			peca = pecasPlayer1.remove(peca.toString());
		}

		if (valida.equals(pecasPlayer1.getAsString())) {

			gameFinished = true;

		}

		return gameFinished;
	}
	
	public static void comprarPecas(PecaList pecasPlayer1, PecaList pecas) {
		
		Peca peca;
		peca = pecas.getElementAt(0);
		peca = pecas.remove(peca.toString());
		pecasPlayer1.insert(peca);
		
	}

}
