package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;



public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtém conexão com o banco de dados
	public static Connection obterConexao() throws SQLException {
		return (Connection) DriverManager
				/*.getConnection("jdbc:mysql://localhost/vendas?user=alunos&password=alunos");*/
				.getConnection("jdbc:sqlserver://localhost;"   +
						"databaseName=ivs;" +
						"user=goflash"+
						"password=goflash");
	}
}
