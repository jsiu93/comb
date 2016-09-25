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
		url="${path }/list/downloadsInfoList" fit="true"  >
		<thead>
		<tr>
   			<th field="id" width="50" align="center" hidden="true">编号</th>
   			<th field="session" width="20" align="center" >session</th>
   			<th field="ip" width="30" align="center" formatter="ipFormat">IP</th>
   			<th field="shasum" width="30" align="center" hidden="true">shasum</th>
   			<th field="url" width="50" >URL</th>
   			<th field="outfile" width="50" hidden="true">OUTFILE</th>
   			<th field="timestamp" width="50" align="center" sortable="true">时间</th>
		</tr>
		</thead>
	</table>

<script type="text/javascript">
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