<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Cadastrar Pessoa</h3>
	
	<form action="CadastrarPessoa" method="post">
	
		Nome: <input type="text" name="nome" />
		<br /><br />
		E-mail: <input type="text" name="email" />
		<br /><br />
		Idade: <input type="text" name="idade" />
		<br /><br />
		Cidade: <input type="text" name="cidade" />
		<br /><br />
		Estado: 
		<select name="estado">
			<option value="RJ">RJ</option>
			<option value="SP">SP</option>
			<option value="MG">MG</option>
			<option value="ES">ES</option>
		</select>
		<br /><br />
		<input type="submit" value="Cadastrar Pessoa" />
		<!-- Pela variavel q, que o Servlet vai saber qual operação executar -->
		<input type="hidden" name="q" value="cadastrar" />
	</form>
	<br /><br />
	<!-- 
	EL -> Expression Language
	Se existir um atributo ou sessao chamada msg, vai ser impresso
	 -->
	${msg }
	<%
	//if(request.getAttribute("msg") != null)
	//	out.print((String) request.getAttribute("msg"));
	%>
	<a href="ListarPessoa?q=listar">Listar Pessoas</a>

</body>
</html>