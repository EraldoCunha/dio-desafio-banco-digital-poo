package entities;

import java.util.Date;

import services.Transacao;

public class ContaPoupanca extends ContaBase {

	private Date diaAniversario;

	public ContaPoupanca(int numeroConta, String nomeCorrentista, Double saldoConta, Date diaAniversario) {
		super(numeroConta, nomeCorrentista, saldoConta);
		this.diaAniversario = diaAniversario;
	}

	public Date getDiaAniversario() {
		return diaAniversario;
	}

	public void setDiaAniversario(Date diaAniversario) {
		this.diaAniversario = diaAniversario;
	}

	@Override
	public void saque(double valorSaque) {
		double novoValor = getSaldoConta() - valorSaque;

		if (novoValor <= 0) {
			System.out.println("\n-------------------------------------\n");
			System.out.println("\nSaldo insuficiente");
			System.out.println("\n-------------------------------------\n");
		} else {
			Date dataTransacao = new Date(System.currentTimeMillis());
			sdf.format(dataTransacao);
			setSaldoConta(getSaldoConta() - valorSaque);
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
		System.out.println("Data conta aniversário= " + sdf.format(diaAniversario));
		System.out.printf("Saldo atual= R$%.2f", getSaldoConta());
		System.out.println("\n-------------------------------------\n");
	}
}
