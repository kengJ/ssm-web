<%--
  Created by IntelliJ IDEA.
  User: heyanzhu
  Date: 2018/10/13
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>访客门设置}</title>
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/main.css">
</head>
<body>
<div class="container">
<table class="table table-bordered">
    <thead>
    <tr>
        <td>id</td>
        <td>账号</td>
        <td>电脑名</td>
        <td>区域</td>
        <td>门名称</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td>${room.tablerecid}</td>
                <td>${room.userno}</td>
                <td>${room.computername}</td>
                <td>${room.doorbillno}</td>
                <td>${room.doorname}</td>
                <td>
                    <button class="btn btn-default" type="button" onclick="edit(${room.tablerecid})">修改</button>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script>
    function edit(id){
        window.location.href="${APP_PATH}/fk/edit";
    }
</script>
</body>
</html>
