<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="static/bootstrap3/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
 <link rel="stylesheet" type="text/css"
	href="${staticPath }/static/jquery-easyui-1.4.4/themes/default/easyui.css">
<script type="text/javascript"
	src="${staticPath }/static/jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="${staticPath }/static/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${staticPath }/static/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
 
 <script type="text/javascript">
 $(function() {
	$('#loginform').form({
		url:'${path}/login',
		onSubmit : function(){
			var isValid = $(this).form('validate');
			if(!isValid){
				alert("!isvalid");
			}
			return isValid
		},
		success:function(result){
			result = $.parseJSON(result);
			if(result.success){
				window.location.href='${path}/index';
			} 
		}
	});
	 
 });
function submitForm(){
	$('#loginform').submit();
}

 </script>
 
<title>登录</title>
</head>
<body style="padding: 50px; background-color: #ccc;">
	<div id="loginModal" class="modal show">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="text-center text-primary">登录</h1>
      </div>
      <div class="modal-body" >
        <form action="" id="loginform" method="post" class="form col-md-12 center-block">
          <div class="form-group">
            <input type="text" id="account" name="account" class="form-control input-lg" placeholder="请输入账号">
          </div>
          <div class="form-group">
            <input type="password" id="password" name="password" class="form-control input-lg" placeholder="请输入密码">
          </div>
          <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block">登录</button>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>

</body>
</html>