package com.regis.relatoriocampanhas.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Util {

	// Constantes
	static final int TAMANHO_BUFFER = 4096; // 4kb

	// méttodo para compactar arquivo
	public static void compactarParaZip(String arqSaida, String arqEntrada) throws IOException {
		int cont;
		byte[] dados = new byte[TAMANHO_BUFFER];

		BufferedInputStream origem = null;
		FileInputStream streamDeEntrada = null;
		FileOutputStream destino = null;
		ZipOutputStream saida = null;
		ZipEntry entry = null;

		try {
			destino = new FileOutputStream(new File(arqSaida));
			saida = new ZipOutputStream(new BufferedOutputStream(destino));
			File file = new File(arqEntrada);
			streamDeEntrada = new FileInputStream(file);
			origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
			entry = new ZipEntry(file.getName());
			saida.putNextEntry(entry);

			while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
				saida.write(dados, 0, cont);
			}
			origem.close();
			saida.close();
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
	}

	public static String lerArquivo(String nomeSql) {
		String str = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader("sql/" + nomeSql + ".sql"));
			while (in.ready()) {
				str += in.readLine() + "\n";
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

}