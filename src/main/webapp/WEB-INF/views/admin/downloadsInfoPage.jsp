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
   			<th field="ip" width="30" align="center">IP</th>
   			<th field="shasum" width="30" align="center" hidden="true">shasum</th>
   			<th field="url" width="50" >URL</th>
   			<th field="outfile" width="50" hidden="true">OUTFILE</th>
   			<th field="timestamp" width="50" align="center" sortable="true">时间</th>
		</tr>
		</thead>
	</table>
</body>
</html>