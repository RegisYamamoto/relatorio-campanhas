package com.muffato.relatoriomari.service;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.muffato.relatoriomari.dao.RelatorioMariDao;
import com.muffato.relatoriomari.model.RelatorioMari;
import com.muffato.relatoriomari.util.SendEmail;
import com.muffato.relatoriomari.util.Util;

public class RelatorioMariService {

	public static final String ENTER = "\r\n";
	public static final String SEPARADOR = ",";
	public static final String ASPAS = "\"";

	public void gerar(){
		System.out.println("---------- Gerando relatório da Mari ----------");
		RelatorioMariDao rd = new RelatorioMariDao();
		String sqlRelatorioCampanha = Util.lerArquivo("relatorio-mari");
		try {
			List<RelatorioMari> relatorio = new ArrayList<RelatorioMari>();
			relatorio.addAll(rd.getRelatorioMari(sqlRelatorioCampanha.toString()));
			if(relatorio != null && relatorio.size()>0){
				gerarArquivo(relatorio);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------- Relatório da Mari gerado com sucesso ----------");
	}

	private void gerarArquivo(List<RelatorioMari> relatorio) {
		File file=null;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -0);
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		SendEmail sendEmail = new SendEmail();
		String[] emails = {"desenvolvimento6@muffato.com.br", "coordena.software@muffato.com.br"}; 
		
		int tamanho = relatorio.size();
		if(tamanho > 999999){
			int cont = 1;
			int fim = 999999;
			for(int i = 0; i< tamanho; i++){		
				try {
					String path = "/home/desenv/relatorio_acelerador_retroativo/temp/RelatorioMari_"+cont+"_"+sdf.format(c.getTime())+".csv";
				 	String pathzip = "/home/desenv/relatorio_acelerador_retroativo/temp/RelatorioMari_"+cont+"_"+sdf.format(c.getTime())+".zip";
					file = new File(path);
					String cabecalho= "data_mes, primeiro_login, acesso";
					FileWriter writer = new FileWriter(file);
					writer.write(cabecalho);
					writer.write(ENTER);
					StringBuilder builder = new StringBuilder(); 
					for(int j = i;j<fim;j++){
						builder.append(relatorio.get(j).getDataMes()).append(SEPARADOR)
						.append(relatorio.get(j).getPrimeiroLogin()).append(SEPARADOR)
						.append(relatorio.get(j).getAcesso()).append(SEPARADOR)
						.append("").append(ENTER);				
					}
					writer.write(builder.toString());
					writer.flush();
					writer.close();
					
					if(file != null){
						Util.compactarParaZip(pathzip, path);
						File fileZip = new File(pathzip);
						sendEmail.enviarArquivo("Relatorio Mari", "Relatorio anexo.", fileZip, emails);
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
				String path = "/home/desenv/relatorio_acelerador_retroativo/temp/RelatorioMari_"+sdf.format(c.getTime())+".csv";
			 	String pathzip = "/home/desenv/relatorio_acelerador_retroativo/temp/RelatorioMari_"+sdf.format(c.getTime())+".zip";
				file = new File(path);
				String cabecalho= "data_mes, primeiro_login, acesso";
				FileWriter writer = new FileWriter(file);
				writer.write(cabecalho);
				writer.write(ENTER);
				StringBuilder builder = new StringBuilder(); 
				for (RelatorioMari r: relatorio) {
					builder.append(r.getDataMes()).append(SEPARADOR)
					.append(r.getPrimeiroLogin()).append(SEPARADOR)
					.append(r.getAcesso()).append(SEPARADOR)
					.append("").append(ENTER);					
				}
				writer.write(builder.toString());
				writer.flush();
				writer.close();
				
				if(file != null){
					Util.compactarParaZip(pathzip, path);
					File fileZip = new File(pathzip);
					sendEmail.enviarArquivo("Relatorio Mari", "Relatorio anexo.", fileZip, emails);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}