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
		url="${path }/list/sessionsInfoList" fit="true" toolbar="#tb" >
		<thead>
		<tr>
   			<th field="id" width="30" align="center" sortable="true">ID</th>
   			<th field="ip" width="40" align="center">IP</th>
   			<th field="client" width="50" align="center" formatter="clientFormat">客户端</th>
   			<th field="termsize" width="30" align="center" >客户端大小</th>
   			<th field="starttime" width="50" align="center" sortable="true">开始时间</th>
   			<th field="endtime" width="50" align="center" sortable="true">结束时间</th>
		</tr>
		</thead>
	</table>
	<div id="tb">
		<div>
			&nbsp;ID：&nbsp;<input type="text" id="s_id" placeholder="ID" size="20" onkeydown="if(event.keyCode==13) searchSessionsInfo()" />
	  		&nbsp;IP：&nbsp;<input type="text" id="s_ip" placeholder="IP" size="20" onkeydown="if(event.keyCode==13) searchSessionsInfo()" />
  			<br/>
  			&nbsp;开始时间段：&nbsp;
  			<input class="easyui-datetimebox" style="width: 180px" id="startTime" />&nbsp; ~&nbsp;
  			<input class="easyui-datetimebox" style="width: 180px" id="endTime" />
  		<a href="javascript:;" onclick="searchSessionsInfo()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
<script type="text/javascript">
function searchSessionsInfo(){
	$('#dg').datagrid('load',{
		'id':$('#s_id').val(),
		'ip':$('#s_ip').val(),
		'startTime':$('#startTime').datetimebox('getValue'),
		'endTime':$('#endTime').datetimebox('getValue')
	});
}

function clientFormat(val, row){
	if(val == null) return "";
	return row.client.version;
}
</script>
</body>
</html>