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
<script type="text/javascript" src='<c:url value="/bootstrap/js/jquery.mask.min.js" />'></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/gestao-projetos/bootstrap/css/index.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
#menu li a{
	color:#fff;
}
#menu > .active > a{
    color: #000;
    background-color: #fff;
}
</style>
	
	
<title>Sistema Gestão de Projetos</title>
</head>
<body>
	<div class="navbar navbar-default navbar-static-top" style="background-color: #4DC1FF;color:#fff;">
      <div class="container">
        <div class="navbar-header">
          <button style="background-color:#fff;border-color:#fff;color:#fff;" type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-md hidden-lg" style="color:#fff;" href='<c:url value="/"></c:url>'><span>Projeto Semear</span></a>
		  <a class="navbar-brand hidden-xs hidden-sm" style="color:#ffffff; height: 80px;" href="<c:url value="/"></c:url>">
		  <img src="/gestao-projetos/img/logo.jpg" class="center-block img-responsive img-rounded" height="120px" width="120px" style="margin-top: -8px;"></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse" style="margin-top:10px">
        <div class="navbar-right nav" style="margin-top:10px">
          	<c:out value="${usuario.nome}" />
          	<a href='<c:url value="/logout/"></c:url>' class="btn btn-default">Sair do sistema</a>
         </div>
          <ul id="menu" class="nav navbar-nav navbar-right">
            <li id="menu-projetos">
              <a href='<c:url value="/painel/projetos/" />'>Projetos</a>
            </li>
            <li id="menu-acoes">
              <a href='<c:url value="/painel/acoes/cadastro" />'>Ações</a>
            </li>
            <li id="menu-instituicoes">
              <a href='<c:url value="/painel/instituicoes/cadastro" />'>Instituições</a>
            </li>
            <li id="menu-reeducandos">
              <a href='<c:url value="/painel/reeducandos/cadastro" />'>Reeducandos</a>
            </li>
			<li id="menu-usuarios">
              <a href='<c:url value="/painel/usuarios/" />'>Usuários</a>
            </li>
			<li id="menu-configuracoes">
              <a href='<c:url value="/painel/configuracoes/cadastro" />'>Configurações</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
</body>
</html>