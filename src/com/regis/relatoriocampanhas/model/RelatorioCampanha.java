package com.regis.relatoriocampanhas.model;

import java.util.Date;

public class RelatorioCampanha {

	private long id;
	private String descricaoproduto;
	private int idprodutogatilho;
	private int tipocampanha;
	private String descricaocampanha;
	private String precode;
	private String precopor;
	private Date datainicial;
	private Date datafinal;
	private int genericoespecifico;
	private int voucher;
	private double porcentualdesconto;
	private double quantidade;
	private double quantidadegatilho;
	private double quantidademaxima;
	private int tipodesconto;
	private int statusfilial;
	private int geo;
	private int bicon;
	private int peso;
	private long idcategoria;
	private int statusintegra;
	private int voucappx;
	private long voucnumb;

	public RelatorioCampanha() {
		super();
	}

	public RelatorioCampanha(long id, String descricaoproduto, int idprodutogatilho, int tipocampanha,
			String descricaocampanha, String precode, String precopor, Date datainicial, Date datafinal,
			int genericoespecifico, int voucher, double porcentualdesconto, double quantidade, double quantidadegatilho,
			double quantidademaxima, int tipodesconto, int statusfilial, int geo, int bicon, int peso, long idcategoria,
			int statusintegra, int voucappx, long voucnumb) {
		super();
		this.id = id;
		this.descricaoproduto = descricaoproduto;
		this.idprodutogatilho = idprodutogatilho;
		this.tipocampanha = tipocampanha;
		this.descricaocampanha = descricaocampanha;
		this.precode = precode;
		this.precopor = precopor;
		this.datainicial = datainicial;
		this.datafinal = datafinal;
		this.genericoespecifico = genericoespecifico;
		this.voucher = voucher;
		this.porcentualdesconto = porcentualdesconto;
		this.quantidade = quantidade;
		this.quantidadegatilho = quantidadegatilho;
		this.quantidademaxima = quantidademaxima;
		this.tipodesconto = tipodesconto;
		this.statusfilial = statusfilial;
		this.geo = geo;
		this.bicon = bicon;
		this.peso = peso;
		this.idcategoria = idcategoria;
		this.statusintegra = statusintegra;
		this.voucappx = voucappx;
		this.voucnumb = voucnumb;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricaoproduto() {
		return descricaoproduto;
	}

	public void setDescricaoproduto(String descricaoproduto) {
		this.descricaoproduto = descricaoproduto;
	}

	public int getIdprodutogatilho() {
		return idprodutogatilho;
	}

	public void setIdprodutogatilho(int idprodutogatilho) {
		this.idprodutogatilho = idprodutogatilho;
	}

	public int getTipocampanha() {
		return tipocampanha;
	}

	public void setTipocampanha(int tipocampanha) {
		this.tipocampanha = tipocampanha;
	}

	public String getDescricaocampanha() {
		return descricaocampanha;
	}

	public void setDescricaocampanha(String descricaocampanha) {
		this.descricaocampanha = descricaocampanha;
	}

	public String getPrecode() {
		return precode;
	}

	public void setPrecode(String precode) {
		this.precode = precode;
	}

	public String getPrecopor() {
		return precopor;
	}

	public void setPrecopor(String precopor) {
		this.precopor = precopor;
	}

	public Date getDatainicial() {
		return datainicial;
	}

	public void setDatainicial(Date datainicial) {
		this.datainicial = datainicial;
	}

	public Date getDatafinal() {
		return datafinal;
	}

	public void setDatafinal(Date datafinal) {
		this.datafinal = datafinal;
	}

	public int getGenericoespecifico() {
		return genericoespecifico;
	}

	public void setGenericoespecifico(int genericoespecifico) {
		this.genericoespecifico = genericoespecifico;
	}

	public int getVoucher() {
		return voucher;
	}

	public void setVoucher(int voucher) {
		this.voucher = voucher;
	}

	public double getPorcentualdesconto() {
		return porcentualdesconto;
	}

	public void setPorcentualdesconto(double porcentualdesconto) {
		this.porcentualdesconto = porcentualdesconto;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getQuantidadegatilho() {
		return quantidadegatilho;
	}

	public void setQuantidadegatilho(double quantidadegatilho) {
		this.quantidadegatilho = quantidadegatilho;
	}

	public double getQuantidademaxima() {
		return quantidademaxima;
	}

	public void setQuantidademaxima(double quantidademaxima) {
		this.quantidademaxima = quantidademaxima;
	}

	public int getTipodesconto() {
		return tipodesconto;
	}

	public void setTipodesconto(int tipodesconto) {
		this.tipodesconto = tipodesconto;
	}

	public int getStatusfilial() {
		return statusfilial;
	}

	public void setStatusfilial(int statusfilial) {
		this.statusfilial = statusfilial;
	}

	public int getGeo() {
		return geo;
	}

	public void setGeo(int geo) {
		this.geo = geo;
	}

	public int getBicon() {
		return bicon;
	}

	public void setBicon(int bicon) {
		this.bicon = bicon;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public long getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(long idcategoria) {
		this.idcategoria = idcategoria;
	}

	public int getStatusintegra() {
		return statusintegra;
	}

	public void setStatusintegra(int statusintegra) {
		this.statusintegra = statusintegra;
	}

	public int getVoucappx() {
		return voucappx;
	}

	public void setVoucappx(int voucappx) {
		this.voucappx = voucappx;
	}

	public long getVoucnumb() {
		return voucnumb;
	}

	public void setVoucnumb(long voucnumb) {
		this.voucnumb = voucnumb;
	}

	@Override
	public String toString() {
		return "RelatorioCampanha [id=" + id + ", descricaoproduto=" + descricaoproduto + ", idprodutogatilho="
				+ idprodutogatilho + ", tipocampanha=" + tipocampanha + ", descricaocampanha=" + descricaocampanha
				+ ", precode=" + precode + ", precopor=" + precopor + ", datainicial=" + datainicial + ", datafinal="
				+ datafinal + ", genericoespecifico=" + genericoespecifico + ", voucher=" + voucher
				+ ", porcentualdesconto=" + porcentualdesconto + ", quantidade=" + quantidade + ", quantidadegatilho="
				+ quantidadegatilho + ", quantidademaxima=" + quantidademaxima + ", tipodesconto=" + tipodesconto
				+ ", statusfilial=" + statusfilial + ", geo=" + geo + ", bicon=" + bicon + ", peso=" + peso
				+ ", idcategoria=" + idcategoria + ", statusintegra=" + statusintegra + ", voucappx=" + voucappx
				+ ", voucnumb=" + voucnumb + "]";
	}

}