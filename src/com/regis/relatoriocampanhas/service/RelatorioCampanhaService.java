package com.regis.relatoriocampanhas.service;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.regis.relatoriocampanhas.dao.RelatorioDao;
import com.regis.relatoriocampanhas.model.RelatorioCampanha;
import com.regis.relatoriocampanhas.util.SendEmail;
import com.regis.relatoriocampanhas.util.Util;

public class RelatorioCampanhaService {

	public static final String ENTER = "\r\n";
	public static final String SEPARADOR = ",";
	public static final String ASPAS = "\"";

	public void gerar(){
		System.out.println("---------- Gerando relatório de campanhas ----------");
		RelatorioDao rd = new RelatorioDao();
		String sqlRelatorioCampanha = Util.lerArquivo("relatorio-campanhas");
		try {
			List<RelatorioCampanha> relatorio = new ArrayList<RelatorioCampanha>();
			relatorio.addAll(rd.getRelatorioCampanha(sqlRelatorioCampanha.toString()));
			if(relatorio != null && relatorio.size()>0){
				gerarArquivo(relatorio);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------- Relatório de campanhas gerado com sucesso ----------");
	}

	private void gerarArquivo(List<RelatorioCampanha> relatorio) {
		File file=null;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -0);
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		SendEmail sendEmail = new SendEmail();
		String[] emails = {"desenvolvimento6@muffato.com.br"}; 
		
		int tamanho = relatorio.size();
		if(tamanho > 999999){
			int cont = 1;
			int fim = 999999;
			for(int i = 0; i< tamanho; i++){			
				try {
					String path = "/opt/relatorios_selos/temp/RelatorioCampanha_"+cont+"_"+sdf.format(c.getTime())+".csv";
				 	String pathzip = "/opt/relatorios_selos/temp/RelatorioCampanha_"+cont+"_"+sdf.format(c.getTime())+".zip";
					file = new File(path);
					String cabecalho= "id, descricaoproduto, idprodutogatilho, tipocampanha, descricaocampanha, precode, precopor, datainicial, datafinal, genericoespecifico, voucher, "
							+ "porcentualdesconto, quantidade, quantidadegatilho, quantidademaxima,	tipodesconto, statusfilial, geo, bicon, peso, idcategoria, statusintegra, "
							+ "voucappx, voucnumb";
					FileWriter writer = new FileWriter(file);
					writer.write(cabecalho);
					writer.write(ENTER);
					StringBuilder builder = new StringBuilder(); 
					for(int j = i;j<fim;j++){
						builder.append(relatorio.get(j).getId()).append(SEPARADOR)
						.append(relatorio.get(j).getDescricaoproduto()).append(SEPARADOR)
						.append(relatorio.get(j).getIdprodutogatilho()).append(SEPARADOR)
						.append(relatorio.get(j).getTipocampanha()).append(SEPARADOR)
						.append(relatorio.get(j).getDescricaoproduto()).append(SEPARADOR)
						.append(relatorio.get(j).getPrecode()).append(SEPARADOR)
						.append(relatorio.get(j).getPrecopor()).append(SEPARADOR)
						.append(relatorio.get(j).getDatainicial()).append(SEPARADOR)
						.append(relatorio.get(j).getDatafinal()).append(SEPARADOR)
						.append(relatorio.get(j).getGenericoespecifico()).append(SEPARADOR)
						.append(relatorio.get(j).getVoucher()).append(SEPARADOR)
						.append(relatorio.get(j).getPorcentualdesconto()).append(SEPARADOR)
						.append(relatorio.get(j).getQuantidade()).append(SEPARADOR)
						.append(relatorio.get(j).getQuantidadegatilho()).append(SEPARADOR)
						.append(relatorio.get(j).getQuantidademaxima()).append(SEPARADOR)
						.append(relatorio.get(j).getTipodesconto()).append(SEPARADOR)
						.append(relatorio.get(j).getStatusfilial()).append(SEPARADOR)
						.append(relatorio.get(j).getGeo()).append(SEPARADOR)
						.append(relatorio.get(j).getBicon()).append(SEPARADOR)
						.append(relatorio.get(j).getPeso()).append(SEPARADOR)
						.append(relatorio.get(j).getIdcategoria()).append(SEPARADOR)
						.append(relatorio.get(j).getStatusintegra()).append(SEPARADOR)
						.append(relatorio.get(j).getVoucappx()).append(SEPARADOR)
						.append(relatorio.get(j).getVoucnumb()).append(SEPARADOR)
						.append("").append(ENTER);				
					}
					writer.write(builder.toString());
					writer.flush();
					writer.close();
					
					if(file != null){
						Util.compactarParaZip(pathzip, path);
						File fileZip = new File(pathzip);
						sendEmail.enviarArquivo("Relatorio Transacional", "Relatorio anexo.", fileZip, emails);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	
				if((tamanho-i) < 999999){
					i = i+(tamanho-i);
				}else{
					i = i+999999;
				}		
				if((tamanho-fim) < 999999){
					fim = fim+(tamanho-fim);
				}else{
					fim = fim+999999;
				}		
			
				cont++;
			}
		}
		else{
			try{
				String path = "/opt/relatorios_selos/temp/RelatorioCampanha_"+sdf.format(c.getTime())+".csv";
			 	String pathzip = "/opt/relatorios_selos/temp/RelatorioCampanha_"+sdf.format(c.getTime())+".zip";
				file = new File(path);
				String cabecalho= "id, descricaoproduto, idprodutogatilho, tipocampanha, descricaocampanha, precode, precopor, datainicial, datafinal, genericoespecifico, voucher, "
						+ "porcentualdesconto, quantidade, quantidadegatilho, quantidademaxima,	tipodesconto, statusfilial, geo, bicon, peso, idcategoria, statusintegra, "
						+ "voucappx, voucnumb";
				FileWriter writer = new FileWriter(file);
				writer.write(cabecalho);
				writer.write(ENTER);
				StringBuilder builder = new StringBuilder(); 
				for (RelatorioCampanha r: relatorio) {
					builder.append(r.getId()).append(SEPARADOR)
					.append(r.getDescricaoproduto()).append(SEPARADOR)
					.append(r.getIdprodutogatilho()).append(SEPARADOR)
					.append(r.getTipocampanha()).append(SEPARADOR)
					.append(r.getDescricaoproduto()).append(SEPARADOR)
					.append(r.getPrecode()).append(SEPARADOR)
					.append(r.getPrecopor()).append(SEPARADOR)
					.append(r.getDatainicial()).append(SEPARADOR)
					.append(r.getDatafinal()).append(SEPARADOR)
					.append(r.getGenericoespecifico()).append(SEPARADOR)
					.append(r.getVoucher()).append(SEPARADOR)
					.append(r.getPorcentualdesconto()).append(SEPARADOR)
					.append(r.getQuantidade()).append(SEPARADOR)
					.append(r.getQuantidadegatilho()).append(SEPARADOR)
					.append(r.getQuantidademaxima()).append(SEPARADOR)
					.append(r.getTipodesconto()).append(SEPARADOR)
					.append(r.getStatusfilial()).append(SEPARADOR)
					.append(r.getGeo()).append(SEPARADOR)
					.append(r.getBicon()).append(SEPARADOR)
					.append(r.getPeso()).append(SEPARADOR)
					.append(r.getIdcategoria()).append(SEPARADOR)
					.append(r.getStatusintegra()).append(SEPARADOR)
					.append(r.getVoucappx()).append(SEPARADOR)
					.append(r.getVoucnumb()).append(SEPARADOR)
					.append("").append(ENTER);					
				}
				writer.write(builder.toString());
				writer.flush();
				writer.close();
				
				if(file != null){
					Util.compactarParaZip(pathzip, path);
					File fileZip = new File(pathzip);
					sendEmail.enviarArquivo("Relatorio Transacional", "Relatorio anexo.", fileZip, emails);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}