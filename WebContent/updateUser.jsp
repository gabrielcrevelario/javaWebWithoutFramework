<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/css/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="formUser">
<form  method="post">
<h2>Cadastro de Usuario</h2>
<label>Nome</label>
	<input type="text"  name="nome" id="nome" value="${user.nome}"/>
<label>Sobrenome</label>
	<input type="text"  name="sobrenome"  id="sobrenome"value="${user.sobrenome}"/>
<label>Email</label>
	<input type="text"  name="email"  id="email" value="${user.email}"/>
<label>Senha</label>
	<input type="password" name="senha" id="senha"  value="${user.senha}"/>
	<input class="buttonSubmit" type="submit" value="atualizar">
</form>

</div>


</body>
</html>