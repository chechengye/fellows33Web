<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/22
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        function fn1() {
            $.get(${pageContext.request.contextPath}"/jQueryAjax" ,{"name":"zhangsan"}, function (data) {
                alert(data.name);
            } , "json");
        }
        function fn2() {
            $.post(${pageContext.request.contextPath}"/jQueryAjax" ,{"name":"zhangsan"}, function (data) {
                alert(data.name);
            } , "json");
        }

        function fn3() {
            $.ajax({
                url:${pageContext.request.contextPath}"/jQueryAjax",
                data:{"name":"wangwu"},
                type:"POST",
                success:function (data) {
                    alert(data.name);
                },
                dataType:"json",
                async:true
            });
        }
    </script>
</head>
<body>
<input value="get异步请求方式" onclick="fn1()" type="button"/>
<input value="post异步请求方式" onclick="fn2()" type="button"/>
<input value="ajax异步请求方式" onclick="fn3()" type="button"/>
</body>
</html>
