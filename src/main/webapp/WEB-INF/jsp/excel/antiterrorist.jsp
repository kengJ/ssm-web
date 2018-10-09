<%--
  Created by IntelliJ IDEA.
  User: heyanzhu
  Date: 2018/10/9
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>反恐附件导出</title>
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <style>
        .container{
            padding: 30px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">反恐附件导出</div>
        <div class="panel-body">
            <form class="form-inline">
                <div class="form-group">
                    <label for="startDate">开始日期</label>
                    <input type="date" class="form-control" id="startDate" placeholder="请输入开始日期" name="startDate">
                </div>
                <div class="form-group">
                    <label for="endDate">结束日期</label>
                    <input type="date" class="form-control" id="endDate" placeholder="请输入结束日期" name="endDate">
                </div>
                <button type="button" class="btn btn-default" id="btn-smt">导出</button>
            </form>
        </div>
    </div>
</div>

<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $('#btn-smt').click(function(){
            //var ajaxdata = $('form').serialize();
            $.ajax({
                type:"POST",
                url:"${APP_PATH}/Excel/antiterrorist",
                data:{
                    startDate:$('#startDate').val(),
                    endDate:$('#endDate').val()
                },
                success:function (result) {
                    alert(result);
                }
            });
        });
    });
</script>
</body>
</html>
