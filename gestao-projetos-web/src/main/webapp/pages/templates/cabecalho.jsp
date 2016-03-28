<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- JS -->
<script type="text/javascript"
	src="/gestao-projetos/bootstrap/jquery.min.js"></script>
<script type="text/javascript"
	src="/gestao-projetos/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src='<c:url value="/bootstrap/js/jquery.mask.min.js" />'></script>
<script type="text/javascript"
	src="/gestao-projetos/bootstrap/js/jquery-ui.min.js"></script>

<script type="text/javascript"
	src="/gestao-projetos/bootstrap/js/jquery.dataTables.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="/gestao-projetos/bootstrap/css/jquery-ui.min.css" />
<link
	href="/gestao-projetos/bootstrap/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/gestao-projetos/bootstrap/css/index.css" rel="stylesheet"
	type="text/css">
<link href="/gestao-projetos/bootstrap/css/style.css" rel="stylesheet"
	type="text/css">

<link href="/gestao-projetos/bootstrap/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">

<style type="text/css">
#menu li a {
	color: #fff;
}

#menu>.active>a {
	color: #000;
	background-color: #fff;
}

.paginate_button.current:hover {
	background: #4DC1FF !important;
}

.paginate_button.current {
	background: #4DC1FF !important;
}

.dataTables_wrapper .dataTables_paginate .paginate_button:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #fff),
		color-stop(100%, #dcdcdc));
	color: #000 !important;
}

.dropdown-menu {
	background-color: #4DC1FF !important;
	color: #fff;
}

.dropdown-menu>.active>a {
	color: #000 !important;
	background-color: #fff;
}

.dropdown-menu>li>a:hover, .dropdown-menu>li>a:focus {
	background-color: #4DC1FF !important;
	color: #fff;
}

.data {
	
}
</style>
<title>Sistema Gestão de Projetos</title>
</head>
<body>
	<div class="navbar navbar-default navbar-static-top"
		style="background-color: #4DC1FF; color: #fff;">
		<div class="container">
			<div class="navbar-header">
				<button
					style="background-color: #fff; border-color: #fff; color: #fff;"
					type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-ex-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand hidden-md hidden-lg" style="color: #fff;"
					href='<c:url value="/"></c:url>'><span>Projeto Semear</span></a> <a
					class="navbar-brand hidden-xs hidden-sm"
					style="color: #ffffff; height: 80px;"
					href="<c:url value="/"></c:url>"> <img
					src="/gestao-projetos/img/logo.jpg"
					class="center-block img-responsive img-rounded" height="120px"
					width="120px" style="margin-top: -8px;"></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse"
				style="margin-top: 10px">
				<ul id="menu" class="nav navbar-nav navbar-left">
					<li id="menu-projetos"><a
						href='<c:url value="/painel/projetos/" />'>Projetos</a></li>
					<li id="menu-acoes"><a
						href='<c:url value="/painel/acoes/" />'>Ações</a></li>
					<li id="menu-instituicoes"><a
						href='<c:url value="/painel/instituicoes/" />'>Instituições</a>
					</li>
					<li id="menu-reeducandos"><a
						href='<c:url value="/painel/reeducandos/" />'>Reeducandos</a>
					</li>
					<li id="menu-usuarios"><a
						href='<c:url value="/painel/usuarios/" />'>Usuários</a></li>
					<li id="menu-configuracoes" class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> Configurações<span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li id="menu-unidades"><a
								href='<c:url value="/painel/unidades-prisionais/" />'>Unidades
									Prisionais</a></li>
						</ul></li>
				</ul>
				<div class="hidden-xs hidden-sm"
					style="float: right; margin-top: 5px; margin-left: 150px">
					<c:out value="${usuario.nome}" />
					<a href='<c:url value="/logout/"></c:url>' class="btn btn-default">Logout</a>
				</div>
				<div class="hidden-md hidden-lg">
					<c:out value="${usuario.nome}" />
					<a href='<c:url value="/logout/"></c:url>' class="btn btn-default">Logout</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>