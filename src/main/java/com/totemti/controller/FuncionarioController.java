package com.totemti.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.totemti.dao.FuncionarioDao;
import com.totemti.dao.IFuncionarioDao;
import com.totemti.model.Funcionario;


/**
 * Servlet implementation class FuncionarioController
 */
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
	IFuncionarioDao funcionarioDao = null;

	public FuncionarioController() {
		funcionarioDao = new FuncionarioDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			action = "LIST";
		}

		switch (action) {

		case "LIST":
			getFuncionarios(request, response);
			break;

		case "EDIT":
			getFuncionarioById(request, response);
			break;

		case "DELETE":
			deleteFuncionario(request, response);
			break;

		default:
			getFuncionarios(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		String id = request.getParameter("id");
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setEmail(request.getParameter("email"));
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setCargo(request.getParameter("cargo"));
		
		if (id.isEmpty() || id == null) {
			
			if (funcionarioDao.saveFuncionario(funcionario)) {
				request.setAttribute("NOTIFICATION", "Funcionario Salvo Com Sucesso!");
			}
		} else {
			funcionario.setId(Integer.parseInt(id));
			if (funcionarioDao.updateFuncionario(funcionario)) {
				request.setAttribute("NOTIFICATION", "Funcionario Atualizado Com Successo!");
			}
		}
		
		getFuncionarios(request, response);

	}

	private void getFuncionarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Funcionario> list = funcionarioDao.getFuncionarios();

		request.setAttribute("list", list);

		dispatcher = request.getRequestDispatcher("/views/funcionario-list.jsp");

		dispatcher.forward(request, response);

	}

	private void getFuncionarioById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		Funcionario funcionario1 = funcionarioDao.getFuncionarioById(Integer.parseInt(id));

		request.setAttribute("funcionario", funcionario1);

		dispatcher = request.getRequestDispatcher("/views/funcionario-form.jsp");

		dispatcher.forward(request, response);

	}

	private void deleteFuncionario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		if (funcionarioDao.deleteFuncionario(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Funcionario Deletado Com Successo!");
		}

		getFuncionarios(request, response);

	}

}
