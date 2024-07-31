package entities;

import java.util.Date;

import services.Transacao;

public class ContaCorrenteComLimite extends ContaBase {

	private Double valorLimite;

	public ContaCorrenteComLimite(int numeroConta, String nomeCorrentista, Double saldoConta) {
		super(numeroConta, nomeCorrentista, saldoConta);
		this.valorLimite = 1200d;
	}

	public Double getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(Double valorLimite) {
		this.valorLimite = valorLimite;
	}

	@Override
	public void deposito(double valorDeposito) {

		Date dataTransacao = new Date(System.currentTimeMillis());
		sdf.format(dataTransacao);
		setSaldoConta(getSaldoConta() + valorDeposito);

		ajustarLimite();

		listaTransacao.add(new Transacao(sdf.format(dataTransacao), valorDeposito, "Credito"));

		System.out.println("\n-------------------------------------\n");
		System.out.println("Valor depositado com sucesso!");
		System.out.println("\n-------------------------------------\n");
	}

	@Override
	public void saque(double valorSaque) {
		double valorSomado = (getSaldoConta() + getValorLimite());

		if (valorSomado < valorSaque) {
			System.out.println("\n-------------------------------------\n");
			System.out.println("\nSaldo insuficiente");
			System.out.println("\n-------------------------------------\n");
		} else {
			Date dataTransacao = new Date(System.currentTimeMillis());
			sdf.format(dataTransacao);
			if (getSaldoConta() >= valorSaque) {
				setSaldoConta(getSaldoConta() - valorSaque);
			} else {
				valorSomado -= valorSaque;
				setValorLimite(valorSomado);
				setSaldoConta(0d);
			}
			// ajustarLimite();

			System.out.println("\n-------------------------------------\n");
			System.out.println("Saque realizado com sucesso!");
			System.out.println("\n-------------------------------------\n");
			listaTransacao.add(new Transacao(sdf.format(dataTransacao), valorSaque, "Debito"));
		}
	}

	@Override
	public void imprimirExtrato() {
		super.imprimirExtratoComum();

		System.out.println();
		System.out.println("Limite da Conta= " + valorLimite);
		System.out.printf("Saldo atual= R$%.2f", getSaldoConta());
		System.out.println("\n-------------------------------------\n");
	}

	public void ajustarLimite() {
		if (valorLimite < 1200d) {
			double diferenca = 1200d - valorLimite;

			if (getSaldoConta() >= diferenca) {
				setSaldoConta(getSaldoConta() - diferenca);
				valorLimite += diferenca;
			}
		}
	}
}
