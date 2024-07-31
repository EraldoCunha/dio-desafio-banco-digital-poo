package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.ContaBase;
import entities.ContaCorrente;
import entities.ContaCorrenteComLimite;
import entities.ContaPoupanca;

public class Gerenciamento {

	static List<ContaBase> listaContas = new ArrayList<>();

	public static void criarConta() {

		listaContas.add(new ContaCorrente(listaContas.size() + 1, "Eraldo Cunha", 0.0));

		listaContas.add(new ContaCorrenteComLimite(listaContas.size() + 1, "Eraldo Cunha", 0.0));

		listaContas.add(new ContaPoupanca(listaContas.size() + 1, "Eraldo Cunha", 0.0, new Date(System.currentTimeMillis())));

	}

	public static void operacao(int operacao, int numeroConta, double valor) {

		switch (operacao) {
		case 1:
			for (ContaBase c : listaContas) {
				if (c.getNumeroConta() == numeroConta) {
					c.deposito(valor);
				}
			}
			break;
		case 2:
			for (ContaBase c : listaContas) {
				if (c.getNumeroConta() == numeroConta) {
					c.saque(valor);
				}
			}
			break;
		case 3:
			for (ContaBase c : listaContas) {
				if (c.getNumeroConta() == numeroConta) {
					c.imprimirExtrato();
				}
			}
			break;
		case 9:
			//Digito responsável por encerrar as operaçãoes
			break;
		default:
			System.out.println("Numero inválido!");
			break;

		}
	}
}
