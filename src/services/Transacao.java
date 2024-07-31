package services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String dataTransacao;
	private Double valorTransacao;
	private String descricaoTransacao;
	
	public Transacao(String string, Double valorTransacao, String descricaoTransacao) {
		this.dataTransacao = string;
		this.valorTransacao = valorTransacao;
		this.descricaoTransacao = descricaoTransacao;
	}

	public String getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public Double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(Double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}

	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
	}

	@Override
	public String toString() {
		return "\nData da transacao = " + dataTransacao +
				"\nValor da transacao = " + valorTransacao +
				"\nTipo de transacao =" + descricaoTransacao + ".\n";
	}
	
}
