package br.com.bytebank.banco.modelo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
	private static Properties props;

	public static Connection getConnection() {
		try {
			props = new Properties();
			props.load(Files.newBufferedReader(Paths.get("config.properties"), StandardCharsets.UTF_8));
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return (Connection) DriverManager.getConnection(props.getProperty("configJDBC"),
						props.getProperty("user"), props.getProperty("password"));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		throw new RuntimeException();
	}
}
