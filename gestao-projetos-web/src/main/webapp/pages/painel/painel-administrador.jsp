<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
</head>
<body>
	<!-- INICIO DA BARRA DE PROGRESSO DOS PROJETOS -->
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading"><b>Status dos Projetos</b></div>
					<div class="panel-body">
						<c:forEach items="${projetos}" var="projeto" varStatus="p">
							<div class="col-md-12 thumbnail" style="padding:10px">
								<c:if test="${progressos[p.index] eq 100}">
									<div class="alert alert-info" style="color: #000;">
										<a href="#" class="close" data-dismiss="alert"
											aria-label="close">&times;</a> <strong>Informativo!</strong>
										Todas as tarefas estão concluídas.Para
										finalizar o projeto clique <a style="color: #000;" href="#">aqui</a>
									</div>
								</c:if>
								<h5 style="font-family: arial; color: #555; font-weight: bold">
									PROJETO:${projeto.nome} - Período:
									<fmt:formatDate value="${projeto.dataInicio.time}"
										pattern="dd/MM/yyyy"></fmt:formatDate>
									à
									<fmt:formatDate value="${projeto.dataTermino.time}"
										pattern="dd/MM/yyyy"></fmt:formatDate>
								</h5>
								<div class="progress">
									<div
										class="progress-bar progress-bar-info progress-bar-striped active"
										role="progressbar" aria-valuenow="${progressos[p.index]}"
										aria-valuemin="0" aria-valuemax="100"
										style="width:${progressos[p.index]}%;">${progressos[p.index]}%</div>
								</div>
								<a class="btn btn-default" style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF" href='<c:url value="/painel/projetos/${projeto.id}/detalhar" />'>Detalhar <span class="glyphicon glyphicon-search"></span></a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- FIM DA BARRA DE PROGRESSO DOS PROJETOS  -->
</body>
</html>
