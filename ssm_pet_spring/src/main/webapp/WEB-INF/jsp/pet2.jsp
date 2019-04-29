<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宠物店</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

<p>
    <input id="strings" type="text" placeholder="搜一搜"/>
    <button class="btn btn-primary" onclick="danji()">搜索</button>
</p>


<div id="div1">
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
    <button id="insertButton" onclick="insert()" class="btn btn-info">新增</button>
</div>

<div id="msg">
    <p id="p"></p>
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
    <c:forEach var="pet" items="${petList}">
        <tr>
            <td>${pet.pId}</td>
            <td>${pet.pName}</td>
            <td>${pet.pPrice}</td>
            <td>${pet.category.type}</td>
            <td>${pet.tag.tag}</td>
            <td>${pet.pStatus}</td>
            <td>
                <button onclick="update(${pet.pId})" class="btn btn-warning">修改</button>
            </td>
            <td>
                <button onclick="drop(${pet.pId})" class="btn btn-danger">删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script type="text/javascript" src="/js/jquery.js"></script>
<script>

    // 搜索单击事件
    function danji() {
        var InputValue = $("p>input").val();
        alert(InputValue);
        var modal = "<tr>" +
            "    <td>" + obj.pId + "</td>" +
            "    <td>" + obj.pName + "</td>" +
            "    <td>" + obj.pPrice + "</td>" +
            "    <td>" + obj.category.type + "</td>" +
            "    <td>" + obj.tag.tag + "</td>" +
            "    <td>" + obj.pStatus + "</td>" +
            "    <td><a id=\"update\" href=\"/select/" + obj.pId + "\">更新</a></td>\n" +
            "    <td><a href=\"/del/" + obj.pId + "\">删除</a></td>\n" +
            "</tr>";

        $.get({
            url: "/Vague",
            contentType: "application/json;charset=utf-8",
            data: {
                InputValue:InputValue
        }
        }).done(function (data) {
            var pets = $("#pets");

            $.each(function (index, obj) {
                pets.append(modal);
            }).fail(function (xhr, code, ex) {
                console.error(ex);
            });
        });
    }

    //删除
    function drop(pId) {
        alert("你点击了我");
        //发送ajax请求到后台
        $.post({
            url: "/del",
            data: {
                pId: pId
            }
        }).done(function (data) {
            alert(data.msg);
            if (data.msg === "删除成功") {
                window.location.reload();
            }
            $("#p").text(data.msg);
        });
    }

    //    新增宠物
    function insert() {
        var pName = $("[name='pName']").val();
        var pPrice = $("[name='pPrice']").val();
        var tId = $("[name='tId'] option:selected").val();
        var categoryId = $("[name='categoryId'] option:selected").val();
        var pStatus = $("[name='pStatus'] option:selected").val();
        alert(pName + pPrice + tId + categoryId + pStatus);

        $.post({
            type: "post",
            url: "/insert",
            data: {
                pName: pName,
                pPrice: pPrice,
                tId: tId,
                categoryId: categoryId,
                pStatus: pStatus
            }
        }).done(function (data) {
            alert(data.msg);
            data.for
            if (data.msg === "新增成功") {
                window.location.reload();
            }
            $("#p").text(data.msg);
        });
    }
</script>


</body>

<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
<%--integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
<%--crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"--%>
<%--integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"--%>
<%--crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"--%>
<%--integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"--%>
<%--crossorigin="anonymous"></script>--%>
</html>