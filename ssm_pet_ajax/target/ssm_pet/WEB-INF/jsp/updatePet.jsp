<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宠物店</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

<div id="div1">
    <form method="post" action="/update">
        <input type="hidden" name="pId" value="${pet.pId}" class="form-control" aria-label="..."/>
        <input type="text" name="pName" value="${pet.pName}" placeholder="宠物名称" class="form-control" aria-label="..."/>
        <input type="number" name="pPrice" value="${pet.pPrice}" placeholder="价格" class="form-control"
               aria-label="..."/>
        <select name="categoryId" class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <option value="${pet.category.cId}">${pet.category.type}</option>
            <c:forEach items="${categoryList}" var="c">
                <option value="${c.cId}">${c.type}</option>
            </c:forEach>
        </select>
        <select name="tId" class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <option value="${pet.tag.tId}">${pet.tag.tag}</option>
            <c:forEach items="${tagList}" var="t">
                <option value="${t.tId}">${t.tag}</option>
            </c:forEach>
        </select>
        <select name="pStatus" class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <option value="${pet.pStatus}">${pet.pStatus}</option>
            <option value="缺货">缺货</option>
            <option value="出售">出售</option>
            <option value="待定">待定</option>
        </select>
        <button class="btn btn-primary">修改</button>
    </form>
</div>


</body>
</html>
