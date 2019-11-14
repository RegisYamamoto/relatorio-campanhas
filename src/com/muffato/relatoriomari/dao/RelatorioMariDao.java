package com.muffato.relatoriomari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.muffato.relatoriomari.model.RelatorioMari;

public class RelatorioMariDao {

	public List<RelatorioMari> getRelatorioMari(String sql){
		List<RelatorioMari> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = new ConnectionFactory().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				RelatorioMari rel = new RelatorioMari(rs.getString("data_mes"), rs.getLong("primeiro_login"), rs.getLong("acesso"));
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