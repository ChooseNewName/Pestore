<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <form action="/aaa" method="post">
        <div><input type="text"></div>
        <div><input type="text"></div>
        <div><input type="submit" value="提交"></div>
    </form>
</div>
<br/>
我是分割线------------------------------------------------
<br/>
<div>
    <table>
        <tr>
            <th>省份</th>
            <th>生日</th>
            <th>性别</th>
            <th>。。</th>
        </tr>
        <tr>
            <td>${Province}</td>
            <td>${birthday}</td>
            <td>${sex}</td>
            <td></td>
        </tr>


    </table>
</div>


</body>
</html>
