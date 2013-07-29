<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Lista de Pessoa</h3>
	
	<c:if test="${fn:length(lista) > 0 }">
		<table width="100%">
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Idade</th>
				<th>Cidade</th>
				<th>Estado</th>
			</tr>
			<c:forEach items="${lista }" var="p">
				<tr>
					<td>${fn:toUpperCase(p.nome) }</td>
					<td>${p.email }</td>
					<td>${p.idade }</td>
					<td>${p.endereco.cidade }</td>
					<td>${p.endereco.estado }</td>
				</tr>
			</c:forEach>
	</table>
	</c:if>
	<br />
	<a href="index.jsp">Voltar</a>
</body>
</html>