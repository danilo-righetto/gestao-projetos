<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/gestao-projetos/bootstrap/css/bootstrap.min.css" />
<title>Cadastro de Ações</title>
<style type="text/css">
#main{margin-top: 60px;}
</style>
</head>
<body>
	<!-- Formulario de Cadastro - INICIO -->
	<div id="main" class="container-fluid">

		<h3 class="page-header">Cadastro de Ações</h3>

		<form action="salvarAcao" method="POST">
			<div class="row">
				<div class="form-group col-md-4">
					<label for="descricao">Descrição</label> <input type="text"
						class="form-control" id="descricao"
						placeholder="Digite uma Descrição" name="descricao" required autofocus>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-4">
					<label for="dataInicio">Data Inicio:</label> <input type="text"
						class="form-control" id="dataInicio" name="dataInicio"
						placeholder="Selecione a Data" required autofocus>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-4">
					<label for="dataTermino">Data Termino:</label> <input type="text"
						class="form-control" id="dataTermino" name="dataTermino"
						placeholder="Selecione a Data" required autofocus>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-4">
					<label for="status">Status</label> <select class="form-control"
						name="status" required>
						<option value="0">Selecione ...</option>
						<option value="aberto">Aberto</option>
						<option value="andamento">Em andamento</option>
						<option value="encerrado">Encerrado</option>
						<option value="concluido">Concluido</option>
					</select>
				</div>
			</div>
			
			<hr />

			<div class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="#" class="btn btn-default">Cancelar</a>
				</div>
			</div>

		</form>
	</div>

	<!-- Formulario de Cadastro - FIM -->

</body>
</html>