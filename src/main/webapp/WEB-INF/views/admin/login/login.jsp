<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<HTML>
<HEAD>
    <TITLE>登录</TITLE>
    <META NAME="Generator" CONTENT="7WX/AOP Framework">
    <META http-equiv="content-type" content="text/html; charset=utf-8">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</HEAD>
<body>
<form>
    请登录<br>
    用户：<input type="text" id="empname"/><br>
    密码：<input type="text" id="password" /><br>
    <input type="button" value="登录" onclick="loginAdmin()">
</form>
</body>
<script>
    function loginAdmin() {
        var empname = $("#empname").val();
        var password = $("#password").val();
        $.ajax({
            type: 'POST',
            url: "${pageContext.request.contextPath}/login/doLogin",
            data: {
                "empname":empname,
                "password":password
            },
            success: function (data) {
                alert(data.code);
                if(data.code==1){
                    window.location.href = "${pageContext.request.contextPath}/admin/index";
                }else{
                    $("#password").clear();
                    alert("账户或密码不正确");
                }
            },
            dataType: "json"
        });
    }
</script>
</html>