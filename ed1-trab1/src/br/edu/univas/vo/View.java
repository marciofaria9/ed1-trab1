package br.edu.univas.vo;

public class View {

	public void Start() {
		
		System.out.println("___________________________________________________");
		System.out.println("Domin?");
		System.out.println("___________________________________________________");

	}

	public void Playing() {

		System.out.println("\nSua vez **********************\n");
		System.out.println("Sua m?o:");
		System.out.println("Digite o num?ro da pe?a que deseja jogar ou 15 para passar a vez ou 20 para comprar uma Pe?a ");
		System.out.println("");
	}

	public void msgErro() {

		System.out.println("Numero de Pe?a inv?lida, digite um numero v?lido");

	}

	public void msgVezDoComputador() {
		System.out.println("Vez do Computador\n");
	}

	public void msgPecasJogadas() {
		System.out.println("Pe?as na mesa:\n ");

	}
	public void msgGanhou() {
		
		System.out.println("Voc? venceu!!!");
	}
	public void msgPerdeu() {
		System.out.println("Voc? perdeu");
		
	}
	
	public void msgComputadorPassouAVez() {
		
		System.out.println("Computador passou a vez *******************");	
		
	}
	public void msgComputadorComprouPeca() {
		
		System.out.println("Computador comprou uma pe?a **********************\n");
		
		
	}
}
