<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<body>

	<tiles:insertAttribute name="cabecalho" />
	
	<tiles:insertAttribute name="conteudo"/>

	<tiles:insertAttribute name="rodape"/>
</body>