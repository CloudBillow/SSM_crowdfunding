<%--
  Created by IntelliJ IDEA.
  User: Miracle
  Date: 2021/3/26
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn1").click(function () {
                // $.get();
                // $.post();
                let array = [2,4,6,5,3,1];
                let J_array = JSON.stringify(array);
                $.ajax({
                    url: "send/array.json",
                    type: "post",
                    data: J_array,
                    contentType: "application/json;charset=UTF-8",
                    dataType: "json",
                    success: function (response) {
                        console.log(response);
                    },
                    error: function (response) {
                        console.log(response);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="test/ssm.html">测试</a>
    <br/>
    <button id="btn1">Test @RequestBody [2,4,6,5,3,1]</button>
</body>
</html>
