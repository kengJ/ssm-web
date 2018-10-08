<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>身份证校验</title>
<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/main.css">
</head>
<body style="padding: 50px 200px 0 200px;">
<div class="panel panel-default" id="IdCardByNo">
  <div class="panel-heading">检测身份证</div>
  <div class="panel-body">
    <div class="input-group">
	  <input type="text" class="form-control" placeholder="请输入身份证">
	  <span class="input-group-btn">
	    <button class="btn btn-default" type="button">检测</button>
	  </span>
	</div>
	<br />
	<ul class="list-group" id="idcard_msg">
    
  </ul>
  </div>
</div>

<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/script/docs.min.js"></script>
<script src="${APP_PATH}/layer/layer.js"></script>
<script type="text/javascript">
function Check(){
	var idcardno = $('#IdCardByNo input').val();
	var reg = /^[1-9]+[0-9]*]*$/;
	console.log();
	if(!reg.test(idcardno)){//检测是否为数据
		alert('请输入数字');
		return;
	}
	if(idcardno.length!=18){
		alert('请输入18位身份证号码');
		return;
	}
	$.ajax({
		url:'${APP_PATH}/IdCard/CheckByNo',
		type:'POST',
		data:{IdCard:idcardno},
		success:function(data){
			$('#idcard_msg > li').removeClass('active');
			if($('#idcard_msg > li').length > 5){
                $('#idcard_msg > li:last').remove();
            }
			if(data.success){
				var result = data.data;
				$('#idcard_msg').prepend('<li class="list-group-item active">身份证号码['+idcardno+']检测成功,此号码为有效号码。<br/>一下是身份证的信息:<br/>1.出生省份:'+result.city+'<br/>2.出生日期:'+result.date+'<br/>3.性别:'+result.sex+'</li>');
			}else{
				$('#idcard_msg').prepend('<li class="list-group-item active">身份证号码['+idcardno+']检测不通过,此号码为无效号码。</li>');
			}
		}
	});
}
$(document).keyup(function(event){
	  if(event.keyCode ==13){
		  Check();
	  }
});
$('#IdCardByNo button').click(function(){
	Check();
});
</script>
</body>
</html>