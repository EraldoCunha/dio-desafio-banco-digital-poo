package application;

import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Gerenciamento.criarConta();
		int numeroConta, numeroOperacao;
		double valorTransacao = 0;
		
		System.out.print("Ol�, digite o numero da sua conta: ");
		numeroConta = sc.nextInt();
		System.out.println();
		
		System.out.print("Digite 1 para fazer dep�sito;" + "\nDigite 2 para fazer saque;"
				+ "\nDigite 3 para consultar seu extrato;" + "\nDigite 9 para sair.");
		numeroOperacao = sc.nextInt();
		System.out.println();
		
		do {
			if (numeroOperacao == 1 || numeroOperacao == 2) {
				System.out.print("Digite o valor da sua transa��o: ");
				valorTransacao = sc.nextDouble();
				
			}
			Gerenciamento.operacao(numeroOperacao, numeroConta, valorTransacao);
			
			valorTransacao = 0;
			System.out.println("Se deseja fazer outra opera��o basta digirar o numero da op��o que foi informada anteriormente,"
					+ "caso deseje encerrar suas opera��es digite 9.");
			numeroOperacao = sc.nextInt();
		}while(numeroOperacao != 9);
		
		System.out.println("Opera��o encerrada, tenha um �timo dia!");

		sc.close();
	}
}
