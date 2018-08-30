<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<HTML>
<HEAD>
    <TITLE>XSSTEST</TITLE>
    <META NAME="Generator" CONTENT="7WX/AOP Framework">
    <META http-equiv="content-type" content="text/html; charset=utf-8">
</HEAD>
<body>
<form  id="form" method="POST" action="${pageContext.request.contextPath}/xssLogin">
    <input type="text" name="username" value="${username}"/><br>
    <input type="text" name="password" />
    <input type="submit">
</form>
</body>

</html>