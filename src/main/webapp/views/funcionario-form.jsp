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
</head>
<body>

	<div class = "container">
	
		<h1>Diretório de Funcionários</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/FuncionarioController" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "nome" placeholder = "Digita Nome" value = "${funcionario.nome}"/>
					</div>
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "email" placeholder = "Digita Email" value = "${funcionario.email}"/>
					</div>
				
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "cpf" placeholder = "Digita Cpf" value = "${funcionario.cpf}"/>
					</div>
					
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "cargo" placeholder = "Digita Cargo" value = "${funcionario.cargo}"/>
					</div>
				
					<input type = "hidden" name = "id" value = "${funcionario.id}"/>
				
					<button type = "submit" class = "btn btn-primary">Salvar Funcionario</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/FuncionarioController?action=LIST">Voltar para Lista</a>
	</div>
	
</body>
</html>