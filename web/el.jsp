<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/16
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("name" , "pageName");
        request.setAttribute("name" , "requestName");
        User user = new User();
        user.setUname("lisi");
        user.setEmail("lisi@126.com");
        session.setAttribute("user"  , user);

        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setUname("wangwu");
        user1.setEmail("wangwu@126.com");
        list.add(user);
        list.add(user1);
        application.setAttribute("list" , list);
    %>
    <%=request.getAttribute("name")%>
    ${requestScope.name}
    ${sessionScope.user.uname}
    ${applicationScope.list[1].uname}

    ${header["User-Agent"]}

    ${name}  <%--//相当于findAttribute()--%>
    ${pageContext.request.contextPath}

    <c:forEach begin="0" end="5" var="i">
        <c:if test="${i!=3}">
            ${i}
        </c:if>
        <c:if test="${i==3}">
            ${i+20}
        </c:if>
    </c:forEach>

    <br>

    <c:forEach items="${list}" var="user" >
        ${user.uname}
    </c:forEach>
</body>
</html>
