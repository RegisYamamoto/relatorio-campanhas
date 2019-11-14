package com.muffato.relatoriomari.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//producao
			return DriverManager.getConnection(
					"jdbc:mysql://10.251.22.11:3306/clubefato",
					"clubefato","devmaster");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}