package com.regis.relatoriocampanhas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.regis.relatoriocampanhas.model.RelatorioCampanha;

public class RelatorioDao {

	public List<RelatorioCampanha> getRelatorioCampanha(String sql){
		List<RelatorioCampanha> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = new ConnectionFactory().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				RelatorioCampanha rel = new RelatorioCampanha(rs.getLong("id"), rs.getString("descricaoproduto"), rs.getInt("idprodutogatilho"), rs.getInt("tipocampanha"),
						rs.getString("descricaocampanha"), rs.getString("precode"), rs.getString("precopor"), rs.getDate("datainicial"), rs.getDate("datafinal"), rs.getInt("genericoespecifico"),
						rs.getInt("voucher"), rs.getDouble("porcentualdesconto"), rs.getDouble("quantidade"), rs.getDouble("quantidadegatilho"), rs.getDouble("quantidademaxima"),
						rs.getInt("tipodesconto"), rs.getInt("statusfilial"), rs.getInt("geo"), rs.getInt("bicon"), rs.getInt("peso"), rs.getLong("idcategoria"), rs.getInt("statusintegra"),
						rs.getInt("voucappx"), rs.getLong("voucnumb"));
				lista.add(rel);
			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}

}