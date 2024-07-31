package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import services.Conta;
import services.Transacao;

public abstract class ContaBase implements Conta{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private int numeroConta;
	private String nomeCorrentista;
	private Double saldoConta;
	
	List<Transacao> listaTransacao = new ArrayList<Transacao>();

	public ContaBase(int numeroConta, String nomeCorrentista, Double saldoConta) {
		this.numeroConta = numeroConta;
		this.nomeCorrentista = nomeCorrentista;
		this.saldoConta = saldoConta;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeCorrentista() {
		return nomeCorrentista;
	}

	public void setNomeCorrentista(String nomeCorrentista) {
		this.nomeCorrentista = nomeCorrentista;
	}

	public Double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(Double saldoConta) {
		this.saldoConta = saldoConta;
	}
	

	public void deposito(double valorDeposito) {
		
		Date dataTransacao = new Date(System.currentTimeMillis());
		sdf.format(dataTransacao);
		setSaldoConta(getSaldoConta() + valorDeposito);
		
		listaTransacao.add(new Transacao(sdf.format(dataTransacao), valorDeposito, "Credito"));
		
		System.out.println("\n-------------------------------------\n");
		System.out.println("Valor depositado com sucesso!");
		System.out.println("\n-------------------------------------\n");
	}

	public void imprimirExtratoComum() {
		System.out.println("\n-------------------------------------\n");
		System.out.println("Extrato do Cliente: \n");

		System.out.println("Numero da conta: " + getNumeroConta());
		System.out.println("Nome do Cliente: " + getNomeCorrentista());

		for (Transacao e : listaTransacao) {
			System.out.print(e.toString());
			System.out.println("\n-------------------------------------\n");
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBase other = (ContaBase) obj;
		return numeroConta == other.numeroConta;
	}
}
