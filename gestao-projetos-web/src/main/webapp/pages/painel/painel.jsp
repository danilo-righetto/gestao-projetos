<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="section" style="margin-top:240px">
    </div>
</body>
</html>
