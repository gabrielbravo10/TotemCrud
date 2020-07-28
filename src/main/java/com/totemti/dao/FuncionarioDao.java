package com.totemti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.totemti.model.Funcionario;
import com.totemti.util.DBConnectionUtil;

public class FuncionarioDao implements IFuncionarioDao {

	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public boolean saveFuncionario(Funcionario funcionario) {
		boolean flag = false;

		try {
			String sql = "INSERT INTO Funcionario (nome, email, cpf, cargo) VALUES (?, ?, ?, ?)";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getCpf());
			preparedStatement.setString(4, funcionario.getCargo());
			preparedStatement.executeUpdate();
			flag = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public List<Funcionario> getFuncionarios() {

		List<Funcionario> list = null;
		Funcionario funcionario = null;

		try {

			list = new ArrayList<Funcionario>();
			String sql = "SELECT * FROM Funcionario";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				funcionario = new Funcionario();
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setCargo(resultSet.getString("cargo"));
				list.add(funcionario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Funcionario getFuncionarioById(int id) {
		Funcionario funcionario = null;

		try {
			funcionario = new Funcionario();
			String sql = "SELECT * FROM Funcionario WHERE ID=" + id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setCargo(resultSet.getString("cargo"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return funcionario;
	}

	public boolean updateFuncionario(Funcionario funcionario) {
		boolean flag = false;
		try {
			String sql = "UPDATE Funcionario SET nome=?, email=?, cpf=?, cargo=? where id=?";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getCpf());
			preparedStatement.setString(4, funcionario.getCargo());
			preparedStatement.setInt(5, funcionario.getId());
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteFuncionario(int id) {
		boolean flag = false;

		try {
			String sql = "DELETE FROM Funcionario WHERE id=" + id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;

	}

}
