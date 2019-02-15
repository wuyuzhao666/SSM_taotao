<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/28/028
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="../js/jquery-1.10.1.js"></script>
<script type="text/javascript">
    $.ajax({
        url : "/list",
        type : "POST",
        contentType : "application/json",
        dataType : "json",
        data :　JSON.stringify({
            page : 847276
        }),
        success : function (data) {

        }

    })
</script>
</body>
</html>
