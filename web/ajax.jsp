<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/22
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function fn1() {
            //创建引擎对象
            var xmlHttpRequest = new XMLHttpRequest();
            //绑定监听事件
            xmlHttpRequest.onreadystatechange = function (data) {
                //获取响应返回数据
                if(xmlHttpRequest.status == 200 && xmlHttpRequest.readyState == 4){
                    var responseText = xmlHttpRequest.responseText;
                    alert(responseText);
                }

                //alert(data);
            }
            //建立服务请求
            xmlHttpRequest.open("GET" , ${pageContext.request.contextPath}"/ajaxServlet?name=zhangsan" , true);
            //发送请求
            xmlHttpRequest.send();
        }

        function fn2() {
            //创建引擎对象
            var xmlHttpRequest = new XMLHttpRequest();
            //绑定监听事件
            xmlHttpRequest.onreadystatechange = function (data) {
                //获取响应返回数据
                if(xmlHttpRequest.status == 200 && xmlHttpRequest.readyState == 4){
                    var responseText = xmlHttpRequest.responseText;
                    alert(responseText);
                }

                //alert(data);
            }
            //建立服务请求
            xmlHttpRequest.open("POST" , ${pageContext.request.contextPath}"/ajaxServlet" , false);
            //post请求想要传递参数，必须添加此头
            xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");

            //发送请求
            xmlHttpRequest.send("name=lisi");
        }
    </script>

</head>
<body>
<input type="button" onclick="fn1();" value="异步访问!"/><br>
<input type="button" onclick="fn2();" value="同步访问!"/><br>
<input type="button" onclick="alert()" value="测试!"/>
</body>
</html>
