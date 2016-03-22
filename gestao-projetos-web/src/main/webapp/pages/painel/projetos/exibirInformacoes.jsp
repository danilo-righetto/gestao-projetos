<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="section">
		<div class="container info-projeto">
			<div class="row" style="padding-left: 100px; padding-right: 100px;">${info.informacoes}</div>
			<hr />
			<div>
				<a class="btn btn-default btn-return"
					href='<c:url value="/painel/projetos/"></c:url>'><span
					class="glyphicon glyphicon-arrow-left"></span></a> 
					
					<a
					class="btn btn-default btn-add"
					href='<c:url value="/painel/projetos/${idProjeto}/adicionarInformacoes"></c:url>'>EDITAR
				</a>
			</div>
		</div>
	</div>
</body>
</html>