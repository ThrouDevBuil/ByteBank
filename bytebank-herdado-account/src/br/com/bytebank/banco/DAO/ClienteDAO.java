package br.com.bytebank.banco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Connect;

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO(Connection con) {
		connection = con;
	}

	public int insert(Cliente titular) {
		String sql = "insert into Cliente (nome, cpf, profissao) values (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, titular.getNome());
			stmt.setString(2, titular.getCpf());
			stmt.setString(3, titular.getProfissao());
			stmt.execute();
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next())
					return Integer.parseInt(generatedKeys.getString("GENERATED_KEY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	public List<Cliente> listar() {
		String sql = "select * from Cliente";
		List<Cliente> clientes = new LinkedList<>();
		try (Connection con = Connect.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				clientes.add(new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("profissao"),
						rs.getInt("id")));
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new NoSuchElementException();
	}

	public boolean update(Cliente c) {
		String sql = "update Cliente set nome=?, cpf=?, profissao=?;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf());
			stmt.setString(3, c.getProfissao());
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		String sql = "delete from Cliente where id=?";
		try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException();
	}
}
