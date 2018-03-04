package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Fila;

public class FilaDAO {
	public ArrayList<Fila> listarFila() {
		Fila fila;
		ArrayList<Fila> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, fone, email FROM cliente";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					fila = new Fila();
					fila.setIdFila(rs.getInt("idFila"));
					fila.setNumFila(rs.getString("numFila"));
					lista.add(fila);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
