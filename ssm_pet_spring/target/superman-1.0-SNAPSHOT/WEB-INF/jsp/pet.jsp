<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>宠物店</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>

<body>

<form action="/Vague" method="post">
    <p>
        <input name="strings" type="text" placeholder="搜一搜"/>
        <button class="btn btn-primary">搜索</button>
    </p>
</form>

<div id="div1">
    <form method="post" action="/add">
        <input type="text" name="pName" placeholder="宠物名称"/>
        <input type="number" name="pPrice" placeholder="价格"/>
        <select name="categoryId" class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <c:forEach items="${categoryList}" var="c">
                <option value="${c.cId}">${c.type}</option>
            </c:forEach>
        </select>
        <select name="tId" class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <c:forEach items="${tagList}" var="t">
                <option value="${t.tId}">${t.tag}</option>
            </c:forEach>
        </select>
        <select name="pStatus" class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <option value="缺货">缺货</option>
            <option value="出售">出售</option>
            <option value="待定">待定</option>
        </select>
        <button class="btn btn-primary">新增</button>
    </form>
</div>

<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col">宠物编号</th>
        <th scope="col">宠物名称</th>
        <th scope="col">价格</th>
        <th scope="col">类型</th>
        <th scope="col">标签</th>
        <th scope="col">状态</th>
        <th scope="col">修改</th>
        <th scope="col">删除</th>
    </tr>
    </thead>
    <tbody id="pets">
    <c:forEach items="${petList}" var="pet">
        <tr>
            <td>${pet.pId}</td>
            <td>${pet.pName}</td>
            <td>${pet.pPrice}</td>
            <td>${pet.category.type}</td>
            <td>${pet.tag.tag}</td>
            <td>${pet.pStatus}</td>
            <td><a id="update" href="/select/${pet.pId}">修改</a></td>
            <td><a href="/del/${pet.pId}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
