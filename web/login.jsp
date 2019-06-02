<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆界面</title>
</head>
<body>
<div style="height: 20px ; width: 200px"><%=request.getAttribute("info") == null ? "" : request.getAttribute("info")%></div>
<form action="loginServlet" method="post">
用户名:<input name="username" type="text" placeholder="请输入用户名"/><br/>
密码: <input name="password" type="password" placeholder="请输入密码" /><br/>
<input type="submit" value="登陆"/>
</form>
</body>
</html>