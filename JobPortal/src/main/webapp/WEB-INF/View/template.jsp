<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies.
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma"        content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<style>
.body {
	padding-top: 250px;
	padding-right: 30px;
	padding-bottom: 250px;
	padding-left: 260px;
	border-color: #0000ff;
	background-image: url("resources/bgrd.png");
	background-color: lightblue;
}

.menu {
	background-color: lightgreen;
	padding-top: 10px;
	height: auto;
	border-color: #0000ff;
}

.header {
	background-color: lightgreen;
	align: center;
	padding-top: 10px;
	padding-bottom: 10px;
	background-repeat: no-repeat;
	border-color: #0000ff;
}

.footer {
	background-color: lightgreen;
	padding-top: 10px;
	padding-bottom: 50px;
	height: 10px;
	border-color: #0000ff;
}
</style>


<body>
	<table border="1" cellspacing="2" align="center">
		<tr>
			<td height="50" align="center"><div class="header">
					<tiles:insertAttribute name="header" />
				</div></td>
		</tr>
		<tr>
			<td><div class="menu">
					<tiles:insertAttribute name="menu" />
				</div></td>
		</tr>
		<tr>

			<td width="1000"><div class="body">
					<tiles:insertAttribute name="body" />
				</div></td>
		</tr>
		<tr>
			<td height="10" align="center"><div class="footer">
					<tiles:insertAttribute name="footer" />
				</div></td>
		</tr>
	</table>
</body>
</html>
