package com.muffato.relatoriomari.model;

public class RelatorioMari {

	private String dataMes;
	private long primeiroLogin;
	private long acesso;

	public RelatorioMari(String dataMes, long primeiroLogin, long acesso) {
		this.dataMes = dataMes;
		this.primeiroLogin = primeiroLogin;
		this.acesso = acesso;
	}

	public String getDataMes() {
		return dataMes;
	}

	public void setDataMes(String dataMes) {
		this.dataMes = dataMes;
	}

	public long getPrimeiroLogin() {
		return primeiroLogin;
	}

	public void setPrimeiroLogin(long primeiroLogin) {
		this.primeiroLogin = primeiroLogin;
	}

	public long getAcesso() {
		return acesso;
	}

	public void setAcesso(long acesso) {
		this.acesso = acesso;
	}

	@Override
	public String toString() {
		return "RelatorioMari [dataMes=" + dataMes + ", primeiroLogin=" + primeiroLogin + ", acesso=" + acesso + "]";
	}

}