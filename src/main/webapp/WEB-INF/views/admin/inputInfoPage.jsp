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
		url="${path }/list/inputInfoList" fit="true" toolbar="#tb" >
		<thead>
		<tr>
   			<th field="id" width="50" align="center" hidden="true" hidden="true">编号</th>
   			<th field="session" width="20" align="center" sortable="true">session</th>
   			<th field="ip" width="30" align="center" formatter="ipFormat">IP</th>
   			<th field="success" width="20" align="center" sortable="true">是否成功</th>
   			<th field="input" width="80" align="center">操作</th>
   			<th field="timestamp" width="30" align="center" sortable="true">时间</th>
		</tr>
		</thead>
	</table>
	<div id="tb">
		<div>
			&nbsp;session：&nbsp;<input type="text" id="s_session" class="easyui-textbox" placeholder="session" size="20" onkeydown="if(event.keyCode==13) searchInputInfo()" />
			&nbsp;IP：&nbsp;<input type="text" id="s_ip" class="easyui-textbox" placeholder="IP" size="20" onkeydown="if(event.keyCode==13) searchInputInfo()" />
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
  		<a href="javascript:;" onclick="searchInputInfo()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
<script type="text/javascript">
function searchInputInfo(){
	$('#dg').datagrid('load',{
		'session':$('#s_session').val(),
		'ip':$('#s_ip').val(),
		'success':$('#s_success').combobox('getValue'),
		'startTime':$('#startTime').datetimebox('getValue'),
		'endTime':$('#endTime').datetimebox('getValue')
	});
}

function ipFormat(val, row){
	return "<a  href='javascript:;' onclick='checkIp(\""+row.ip+"\")'>"+val+"</a>"
}

function checkIp(ip){
	$.post('${path}/ip/getAddress', {ip:ip}, function(result){
		result = $.parseJSON(result);
		if(result.success){
			var content = result.data.country + result.data.region + result.data.county + " " + result.data.isp;
			$.messager.alert("IP查询", content);
		}
	});
}


</script>
</body>
</html>