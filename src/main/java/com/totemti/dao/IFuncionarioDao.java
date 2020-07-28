package com.totemti.dao;

import java.util.List;


import com.totemti.model.Funcionario;

public interface IFuncionarioDao {
	
	boolean saveFuncionario(Funcionario funcionario);

	List<Funcionario> getFuncionarios();

	Funcionario getFuncionarioById(int id);

	boolean updateFuncionario(Funcionario funcionario);

	boolean deleteFuncionario(int id);

}
