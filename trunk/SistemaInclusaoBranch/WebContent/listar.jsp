<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java WebDeveloper 07</title>
</head>
<body>
	<h3>Lista de Pessoas:</h3>
	<c:if test="${fn:length(lista) > 0 }">
		<table width="50%">
			<tr>
				<th>Nome:</th>
				<th>E-mail:</th>
				<th>Idade:</th>
				<th>Cidade:</th>
				<th>Estado:</th>
			</tr>
			<c:forEach items="${lista}" var="p">
				<tr>
					<td align="center">${fn:toUpperCase(p.nome) }</td>
					<td align="center">${p.email }</td>
					<td align="center">${p.idade }</td>
					<td align="center">${p.endereco.cidade }</td>
					<td align="center">${p.endereco.estado }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br/>
	<a href="index.jsp">Voltar</a>
</body>
</html>