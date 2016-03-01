<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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

<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src='<c:url value="/bootstrap/js/jquery.mask.min.js" />'></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/gestao-projetos/bootstrap/css/index.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
#menu li a {
	color: #fff;
}

#menu>.active>a {
	color: #000;
	background-color: #fff;
}
</style>


<title>Sistema Gestão de Projetos</title>
</head>
<body>
	<div class="navbar navbar-default navbar-static-top"
		style="background-color: #4DC1FF; color: #fff;">
		<div class="container">
			<div class="navbar-header">
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
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<c:if test="${mensagem != null && mensagem ne ''}">
				<c:if test="${mensagem eq 'OK'}">
					<div class="alert alert-success">
						<span style="color: #000000"><strong>Sucesso!</strong> Sua
							senha foi alterada com sucesso.</span>
					</div>
				</c:if>
				<c:if test="${mensagem eq 'ERRO_NOVA_SENHA'}">
					<div class="alert alert-warning">
						<span style="color: #000000"><strong>Alerta!</strong> Campo
							nova senha não corresponde com o campo confirmação de senha.</span>
					</div>
				</c:if>
				<c:if test="${mensagem eq 'ERRO'}">
					<div class="alert alert-danger">
						<span style="color: #000000"><strong>Erro!</strong>Erro ao
							alterar a senha, tente novamente mais tarde!</span>
					</div>
				</c:if>
				<c:if test="${mensagem eq 'ERRO_SENHA_ATUAL'}">
					<div class="alert alert-warning">
						<span style="color: #000000"><strong>Alerta!</strong>Campo
							senha atual não confere.</span>
					</div>
				</c:if>
			</c:if>
			<c:if test="${(mensagem == null || mensagem ne 'OK')}">
				<div class="row">
					<div class="col-md-12">
						<h4>Redefinir Senha</h4>
						<p>Olá ${user.nome}, preencha abaixo os
							campos para redefinir a sua senha.</p>
						<form role="form" action='<c:url value="/salvar-nova-senha" />' method="post">
							<div class="form-group">
								<label class="control-label" for="novaSenha">Nova Senha</label>
								<input required="required" name="novaSenha" class="form-control"
									id="novaSenha" placeholder="Digite  a nova senha"
									type="password">
							</div>
							<div class="form-group">
								<label class="control-label" for="confirmaNovaSenha">Confirme
									a Nova Senha</label> <input required="required"
									name="confirmaNovaSenha" class="form-control"
									id="confirmaNovaSenha" placeholder="Confirme a nova senha"
									type="password">
							</div>
							<input required="required" name="email" class="form-control"
								id="email" value="${user.usuario}" type="hidden">
							<input required="required" name="hash" class="form-control"
								id="hash" value="${hash}" type="hidden">
							<div class="form-group">
								<button type="submit" class="btn btn-default" style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF">Salvar</button>
							</div>
						</form>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	<footer>
		<div
			class="navbar navbar-default navbar-static-top hidden-xs hidden-sm"
			style="background-color: #4DC1FF; color: #fff; padding: 5px;margin-top: 175px">
			<div class="text-center" style="margin-top: 10px">
				<p>
					Gestão de Projetos | Desenvolvido por <b><a target="_blank"
						style="color: #fff; text-decoration: none"
						href="http://www.fornax.com.br">FORNAX TECNOLOGIA</a></b> | 2016
				</p>
			</div>
		</div>
		<div
			class="navbar navbar-default navbar-static-top hidden-md hidden-lg"
			style="background-color: #4DC1FF; color: #fff; padding: 5px;">
			<div class="text-center" style="margin-top: 10px">
				<p>
					Gestão de Projetos | Desenvolvido por <b><a target="_blank"
						style="color: #fff; text-decoration: none"
						href="http://www.fornax.com.br">FORNAX TECNOLOGIA</a></b> | 2016
				</p>
			</div>
		</div>
	</footer>
</body>