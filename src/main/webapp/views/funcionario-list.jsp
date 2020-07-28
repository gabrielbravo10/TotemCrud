<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 

</head>
<body>

	<div class="container">
		<hr/>
		<div class="row justify-content-md-center">
			<div class="col-md-4">
				<button type="button" class="btn btn-primary btn-lg" onclick="window.location.href = 'views/funcionario-form.jsp'">Adiciona Funcionario</button>
			</div>
			<div class="col-md">
				<h1>Diretório de Funcionários</h1>
			</div>
		</div>
		<hr/>	
		<div class="row">
			<div class="col-12">
		
			<p>${NOTIFICATION}</p>
				<table class="table" id="datatable">
				  <thead class="thead-dark">
				    <tr>
				      <th>Id</th>
				      <th>Nome</th>
				      <th>Email</th>
				      <th>Cpf</th>
				      <th>Cargo</th>
				      <th>Actions</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${list}" var="funcionario">
				  	<tr>
				      <th>${funcionario.id}</th>
				      <td>${funcionario.nome}</td>
				      <td>${funcionario.email}</td>
				      <td>${funcionario.cpf}</td>
				      <td>${funcionario.cargo}</td>
				      <td>
				      	<a href="${pageContext.request.contextPath}/FuncionarioController?action=EDIT&id=${funcionario.id}">Editar</a>
				      	|
				      	<a href="${pageContext.request.contextPath}/FuncionarioController?action=DELETE&id=${funcionario.id}">Deletar</a>
				      </td>
				    </tr>  
				  </c:forEach>
				    
				  </tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
	<script>
	$(document).ready(function(){
		$('#datatable').DataTable();
		
	})
	</script>
</body>
</html>