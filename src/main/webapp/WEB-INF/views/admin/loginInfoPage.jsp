<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/basejs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body style="margin: 1px">
	<table id="dg"  class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
		url="${path }/list/loginInfoList" fit="true" toolbar="#tb" >
		<thead>
		<tr>
   			<th field="id" width="50" align="center" hidden="true">编号</th>
   			<th field="session" width="20" align="center" >session</th>
   			<th field="success" width="20" align="center">是否成功</th>
   			<th field="username" width="30" align="center">登录名</th>
   			<th field="password" width="30" align="center">登录密码</th>
   			<th field="timestamp" width="50" align="center" sortable="true">时间</th>
		</tr>
		</thead>
	</table>
	<div id="tb">
		<div>
			&nbsp;session：&nbsp;<input type="text" id="s_session" placeholder="session" size="20" onkeydown="if(event.keyCode==13) searchLoginInfo()" />
	  		&nbsp;登录名：&nbsp;<input type="text" id="s_username" placeholder="登录名" size="20" onkeydown="if(event.keyCode==13) searchLoginInfo()" />
	  		&nbsp;密码：&nbsp;<input type="text" id="s_password" placeholder="密码" size="20" onkeydown="if(event.keyCode==13) searchLoginInfo()" />
	  		&nbsp;是否成功：&nbsp;
	  		<select class="easyui-combobox" id="s_success" editable="false" panelHeight="auto" >
  			<option  value="">请选择</option>
  			<option  value="0">false</option>
  			<option  value="1">true</option>
  			</select>
  			<br/>
  			&nbsp;时间段：&nbsp;
  			<input class="easyui-datetimebox" style="width: 180px" id="startTime" />&nbsp; ~&nbsp;
  			<input class="easyui-datetimebox" style="width: 180px" id="endTime" />
  		<a href="javascript:;" onclick="searchLoginInfo()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
<script type="text/javascript">
function searchLoginInfo(){
	$('#dg').datagrid('load',{
		'session':$('#s_session').val(),
		'username':$('#s_username').val(),
		'password':$('#s_password').val(),
		'success':$('#s_success').combobox('getValue'),
		'startTime':$('#startTime').datetimebox('getValue'),
		'endTime':$('#endTime').datetimebox('getValue')
	});
}
</script>
</body>
</html>