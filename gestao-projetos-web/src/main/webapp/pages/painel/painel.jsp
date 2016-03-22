<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
</head>
  <body>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center text-success">Painel Administrador</h1>
			<h1 class="text-center text-success">Seja bem vindo <c:out value="${usuario.nome}" /></h1>
          </div>
        </div>
      </div>
    </div>
    <!-- BARRA DE STATUS -->
     <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
			<!-- INICIO - PROJETO 01 -->
	        <h4 style="font-family: arial; color: #4DC1FF">Status - Projeto: </h4>
	        <div class="progress">
			  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
			    60%
			  </div>
			</div>
	        <!-- FIM - PROJETO 01 -->
	        <!-- INICIO - PROJETO 02 -->
	        <h4 style="font-family: arial; color: #4DC1FF">Status - Projeto: </h4>
	        <div class="progress">
			  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
			    40%
			  </div>
			</div>
	        <!-- FIM - PROJETO 02 -->
          </div>
        </div>
      </div>
    </div>
    <!-- INICIO - Lista de Coordenadores sem Projeto e sem Ação -->
	<!-- FIM - Lista de Coordenadores sem Projeto e sem Ação -->
    <div class="section" style="margin-top:240px">
    </div>
</body>
</html>
