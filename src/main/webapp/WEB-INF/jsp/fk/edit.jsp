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
    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">访客门名称</label>
            <div class="col-sm-10">
                <p class="form-control-static">${room.doorname}</p>
            </div>
        </div>
        <div class="form-group">
            <label for="computer" class="col-sm-2 control-label">电脑名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="computer" placeholder="电脑名" value="${room.computername}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-default" onclick="update()">更新</button>
                <button type="button" class="btn btn-default" onclick="gotoindex()">取消</button>
            </div>
        </div>
    </form>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script>
function gotoindex(){
    window.location.href="${APP_PATH}/fk/index";
}
function update(){
    var computer = $('#computer').val();
    $.ajax({
        url:"${APP_PATH}/fk/update",
        type:'POST',
        data:{id:${room.tablerecid},computer:computer},
        success:function(result){
            if(result == "success"){
                window.location.href="${APP_PATH}/fk/index";
            }else{
                alert("更新失败")
            }
        }
    });
}
</script>
</body>
</html>
