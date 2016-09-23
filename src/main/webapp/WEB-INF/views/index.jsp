<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/basejs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #D9EEF5">
		<table style="padding:5px" width="100%">
			<tr>
				<td width="50%">
					<img alt="logo" src="">
				</td>
				<td valign="bottom" align="right" width="50%">
					<font size="3">&nbsp;&nbsp;
						${currentUser.account }
						&nbsp;&nbsp;
						<a href="javascript:void(0)" onclick="logout()" class="easyui-linkbutton" plain="true" icon="icon-clear">登出</a>
					</font>
				</td>
			</tr>
		</table>
	</div>

<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div title="首页">
			<div></div>
		</div>
	</div>
</div>

<div region="west" style="width: 200px" title="菜单" split="true">
	<div class="easyui-accordion" data-options="fit:true, border:false">
		<div title="基本信息" data-options="selected:true" style="padding: 10px">
			<a href="javascript:openTab('登录信息', 'loginInfoPage')" class="easyui-linkbutton" data-options="plain:true" style="width: 150px">登录信息</a>
		</div>
</div>

<div region="south" style="height: 25px; padding: 5px" align="center">
版本所有
</div>

<script type="text/javascript">
	function openTab(text, url, iconCls){
		if($('#tabs').tabs('exists',text)){
			$('#tabs').tabs('select', text)
		}else{
			var content = "<iframe frameborder=0 scrolling='auto' style='width:100%; height:100%' src='${path}/page/"+url+"'> </iframe>";
			$('#tabs').tabs('add',{
				title:text,
				iconCls:iconCls,
				closable:true,
				content:content
			});
		}
	}
	
	function logout(){
		$.messager.confirm('提示','确定要退出？',function(r){
			if(r){
				$.post('${path}/logout',function(result){
					if(result.success){
						window.location.href='${path}';
					}
				},'json');
			}
		})
	}
</script>
</html>