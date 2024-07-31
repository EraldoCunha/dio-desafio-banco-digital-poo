package entities;

import java.util.Date;

import services.Transacao;

public class ContaCorrente extends ContaBase {

	public ContaCorrente(int numeroConta, String nomeCorrentista, Double saldoConta) {
		super(numeroConta, nomeCorrentista, saldoConta);
	}

	@Override
	public void saque(double valorSaque) {

		double novoValor = getSaldoConta() - valorSaque;

		if (novoValor < 0) {
			System.out.println("\n-------------------------------------");
			System.out.println("\nSaldo insuficiente");
			System.out.println("\n-------------------------------------\n");
		} else {
			Date dataTransacao = new Date(System.currentTimeMillis());
			sdf.format(dataTransacao);
			setSaldoConta(novoValor);
			System.out.println("\n-------------------------------------\n");
			System.out.println("Saque realizado com sucesso!");
			System.out.println("\n-------------------------------------\n");
			listaTransacao.add(new Transacao(sdf.format(dataTransacao), valorSaque, "Debito"));
		}
	}

	@Override
	public void imprimirExtrato() {
		super.imprimirExtratoComum();

		System.out.printf("\nSaldo atual= R$%.2f", getSaldoConta());
		System.out.println("\n-------------------------------------\n");
	}
}
