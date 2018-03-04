package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Chamado;

public class ChamadoDAO {
	
	public int criar(Chamado chamado) {
		String sqlInsert = "INSERT INTO cliente(nome, fone, email) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, chamado.getIdChamado());
			stm.setString(2, chamado.getDescricao());
			stm.setString(3, chamado.getStatus());
			stm.setDate(4, chamado.getDataAbertura());
			stm.setDate(5, chamado.getDataFechamento());
			stm.setInt(6, chamado.getIdFila());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					chamado.setIdChamado(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chamado.getIdChamado();
	}
	
	public void atualizar(Chamado chamado) {
		String sqlUpdate = "UPDATE cliente SET nome=?, fone=?, email=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, chamado.getIdChamado());
			stm.setString(2, chamado.getDescricao());
			stm.setString(3, chamado.getStatus());
			stm.setDate(4, chamado.getDataAbertura());
			stm.setDate(5, chamado.getDataFechamento());
			stm.setInt(6, chamado.getIdFila());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Chamado carregar(int id) {
		Chamado chamado = new Chamado();
		chamado.setIdChamado(id);
		String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, chamado.getIdChamado());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					chamado.setIdChamado(rs.getInt("idChamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setStatus(rs.getString("status"));
					chamado.setDataAbertura(rs.getDate("dataAbertura"));
					chamado.setDataFechamento(rs.getDate("dataFechamento"));
					chamado.setIdFila(rs.getInt("idFila"));
				} else {
					chamado.setIdChamado(-1);
					chamado.setDescricao(null);
					chamado.setStatus(null);
					chamado.setDataAbertura(null);
					chamado.setDataFechamento(null);
					chamado.setIdFila(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return chamado;
	}
	public ArrayList<Chamado> listarChamado() {
		Chamado chamado;
		ArrayList<Chamado> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, fone, email FROM cliente";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					chamado = new Chamado();
					chamado.setIdChamado(rs.getInt("idChamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setStatus(rs.getString("status"));
					chamado.setDataAbertura(rs.getDate("dataAbertura"));
					chamado.setDataFechamento(rs.getDate("dataFechamento"));
					chamado.setIdFila(rs.getInt("idFila"));
					lista.add(chamado);
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
