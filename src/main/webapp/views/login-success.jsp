<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.nuttle.model.LoginBean" %>
<%@page import="net.nuttle.model.ModelConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
</head>
<body>
<h2>Logged In As:</h2>
<%LoginBean bean = (LoginBean) request.getAttribute(ModelConstants.LOGIN_MODEL); %>
<%=bean.getUserName() %>
</body>
</html>