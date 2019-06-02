<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/2
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="/error.jsp" buffer="0kb" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!--HTML注释-->

    <%--<%@ include file="error.jsp"%>--%>
    <%--ccccccccccccccccccccccccccc
    <%
        //单行注释
        /**
         * 块注释
         */
        out.print("aaaaaaaaaaaaaaa");
        response.getWriter().write("bbbbbbbbbbbbbbbbbbbbbbbbb");

    %>
    <%="ddddddddddddddddddddddddddddd"%>--%>
    <%--JSP注释--%>

    <%
        //request.setAttribute("name" , "lisi");
       // pageContext.setAttribute("name" , "zhangsan" , PageContext.REQUEST_SCOPE);
        //pageContext.setAttribute("name" , "wangwu" , PageContext.SESSION_SCOPE);
        pageContext.setAttribute("name" , "zhaoliu" , PageContext.APPLICATION_SCOPE);
        //pageContext.setAttribute("name" , "test");

        //大小关系 page域<request域<session域<servletContext域
    %>
    <%=pageContext.findAttribute("name")%>
    <%=pageContext.getAttribute("name" , PageContext.REQUEST_SCOPE)%>

    <% int i = 0 ; %>
    <%System.out.println(i);
        /*public void method(){
            System.out.println("test is called!!");
        }*/
        List<String> list = new ArrayList<>();
        //int m = 5/0;
    %>
    <%=i%>
    <%=6+10%>
    <%!String str = "ni hao";
    public void test(){
        System.out.println("test is called!!");
    }
    %>
    <%System.out.println(str);%>
    <%test();%>
</body>
</html>
