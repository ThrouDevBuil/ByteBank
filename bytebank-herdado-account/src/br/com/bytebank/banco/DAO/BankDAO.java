package br.com.bytebank.banco.DAO;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;

public class BankDAO {
	private Connection connection;

	public BankDAO(Connection connection) {
		this.connection = connection;
	}

	public boolean insert(List<Conta> cc) {
		try {
			connection.setAutoCommit(false);
			for (Conta c : cc) {
				try (ResultSet rs = configure(c)) {
					connection.commit();
					return true;
				} catch (Exception e) {
					try {
						connection.rollback();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet configure(Conta c) throws Exception {
		String sql = "insert into Conta (agencia, numero, saldo, tipo_conta, cod_cli) values (?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, c.getAgencia());
			stmt.setInt(2, c.getNumero());
			stmt.setBigDecimal(3, BigDecimal.valueOf(c.getSaldo()));
			stmt.setString(4, c.typeAccount());
			stmt.setInt(5, c.getTitular().getId());
			stmt.executeUpdate();
			return stmt.getGeneratedKeys();
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		throw new Exception();
	}

	public int insert(Conta c) {
		try (ResultSet rs = configure(c)) {
			return Integer.parseInt(rs.getString("GENERATED_KEY"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<Conta> listar() {
		String sql = "select c.*, cli.* from Conta c inner join Cliente cli on c.cod_cli = cli.id;";
		List<Conta> contas = new ArrayList<>();
		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next())
				contas.add(pesquisa(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}

	public Conta pesquisa(ResultSet rs) throws SQLException {
		String typeAccount = rs.getString("tipo_conta");
		Conta c = instanceOfAccount(typeAccount, rs.getInt("agencia"), rs.getInt("numero"), rs.getBigDecimal("saldo"));
		c.setId(rs.getInt("id"));
		c.setTitular(
				new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("profissao"), rs.getInt("id")));
		return c;
	}

	public Conta buscar(int agencia, int numero) {
		String sql = "select c.*, cli.* from Conta c inner join Cliente cli on c.cod_cli = cli.id "
				+ "and c.agencia = ? and c.numero = ?;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, agencia);
			stmt.setInt(2, numero);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					Conta c = pesquisa(rs);
					if (c != null)
						return c;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException();
	}

	public List<Conta> buscaAgencia(int agencia) {
		String sql = "select c.*, cli.* from Conta c inner join Cliente cli on c.cod_cli = cli.id where agencia = ?";
		List<Conta> contas = new LinkedList<>();
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, agencia);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					contas.add(pesquisa(rs));
				}
				return contas;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new NoSuchElementException();
	}

	public boolean update(int id, Conta cc) {
		String sql = "update Conta set agencia=?, numero=? where id=?;";
		try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, cc.getAgencia());
			stmt.setInt(2, cc.getNumero());
			stmt.setInt(3, id);
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		String sql = "delete from Conta where id=?;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private Conta instanceOfAccount(String typeAccount, int agencia, int numero, BigDecimal saldo) {
		return new Instanciador().instaciar(typeAccount, agencia, numero, saldo);
	}
}