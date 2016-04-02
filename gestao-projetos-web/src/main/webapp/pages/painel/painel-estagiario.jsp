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
				<h4 class="title-screen">ESTAGIARIO:</h4>
				<div class="col-md-12">
					<!-- INICIO - PROJETO 01 -->
					<h4 class="title-screen">Status - Projeto:</h4>
					<div class="progress">
						<div class="progress-bar progress-bar-success" role="progressbar"
							aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
							style="width: 60%;">60%</div>
					</div>
					<!-- FIM - PROJETO 01 -->
					<!-- INICIO - PROJETO 02 -->
					<h4 class="title-screen">Status - Projeto:</h4>
					<div class="progress">
						<div class="progress-bar progress-bar-info" role="progressbar"
							aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
							style="width: 40%;">40%</div>
					</div>
					<!-- FIM - PROJETO 02 -->
				</div>
			</div>
		</div>
	</div>
	<!-- FIM DA BARRA DE PROGRESSO DOS PROJETOS  -->
	</div>
</body>
</html>
