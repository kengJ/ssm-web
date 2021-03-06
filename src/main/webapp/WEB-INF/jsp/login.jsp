<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
      <%@include file="/WEB-INF/jsp/common/head.jsp"%>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#" style="font-size: 18pt">管理平台</a>
        </div>
      </div>
    </nav>

    <div class="container">
      <h1 style="color:red">${param.errorMsg}</h1>
      <div class="panel panel-default" style="width:400px;margin:0 auto;margin-top: 200px;">
		  <div class="panel-heading">用户登录</div>
		  <div class="panel-body">
		    <form id="loginForm" action="doLogin" method="post" class="form-signin" role="form">
        <!-- <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2> -->
		  <div class="form-group has-feedback">
			<input type="text" class="form-control input-sm" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-feedback">
			<input type="password" class="form-control input-sm" id="userpswd" name="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <!--<div class="form-group has-success has-feedback">
			<select class="form-control input-sm" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
		  </div>-->
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
        </div>
        <a class="btn btn-sm btn-primary btn-block" onclick="dologin()" > 登录</a>
      </form>
		  </div>
	  </div>
      
    </div>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="layer/layer.js"></script>
    <script>
    function dologin() {
        // 非空校验
        var loginacct = $("#loginacct").val();
        // 表单元素的value取值不会为null, 取值是空字符串
        if ( loginacct == "" ) {
        	//alert("用户登录账号不能为空，请输入");
            layer.msg("用户登录账号不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
            	
            });
        	return;
        }
        
        var userpswd = $("#userpswd").val();
        if ( userpswd == "" ) {
        	//alert("用户登录密码不能为空，请输入");
            layer.msg("用户登录密码不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
            	
            });
        	return;
        }
        
        // 提交表单
        //alert("提交表单");
        //$("#loginForm").submit();
        // 使用AJAX提交数据
        var loadingIndex = null;
        $.ajax({
        	type : "POST",
        	url  : "doAJAXLogin",
        	data : {
        		"loginacct" : loginacct,
        		"userpswd"  : userpswd
        	},
        	beforeSend : function(){
        		loadingIndex = layer.msg('处理中', {icon: 16});
        	},
        	success : function(result) {
        		layer.close(loadingIndex);
        		if (result.success) {
        			window.location.href = "main";
        		} else {
                    layer.msg("用户登录账号或密码不正确，请重新输入", {time:2000, icon:5, shift:6}, function(){
                    	
                    });
        		}
        	}
        });
    }
    $(document).keyup(function(event){
        if(event.keyCode ==13){
            dologin();
        }
    });
    </script>
  </body>
</html>