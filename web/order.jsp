<%@page import="model.MenuItem"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	List<MenuItem> menuList = (List<MenuItem>) request.getAttribute("menuList");
	List<MenuItem> orderList = (List<MenuItem>) request.getAttribute("orderList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--
    This page collaborates with the OrderController servlet to dynamically
    load and mainipulate the menu list and order list. Note the Java 
    Scriptlet code below, which produces the scrollable lists.
-->
<html>
	<head>
		<title>My JSP 'order.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<h2><font face="Arial"> 
			Place your order... 
		</font></h2><font face="Arial" size="2"> 
		(or click <a href="index.jsp">here</a> to return to home page)</font><br><br>
		<form method="POST" action="order?action=selectList">
		<table width="550" border="0" bgcolor="white">
			<tbody>
				<tr>
					<td style="background-color: rgb(255, 255, 128);">
						<strong>&nbsp;Menu</strong>
					</td>
					<td align="center" style="background-color: rgb(255, 255, 128);">
						&nbsp;
						<strong>Action</strong>
					</td>
					<td style="background-color: rgb(255, 255, 128);">
						<strong>&nbsp;Ordered</strong>
					</td>
				</tr>
				<tr>
					<td style="background-color: rgb(255, 128, 0);">
						&nbsp;
						<select size="4" name="menuList">
						<%
							for(MenuItem item : menuList) {
                                                            out.println("<option value='" + item.getItemName() + "'>" + item.getItemName() + "</option>");
							}
						 %>
						</select>
					</td>
					<td align="center" style="background-color: rgb(255, 128, 0);">
						<br>
						&nbsp;
						<input type="submit" value="Order &gt;&gt;" name="submit">
						<br>
						<br>
						<input type="submit" value="&lt;&lt; Remove" name="submit">
						<br>
					</td>
					<td style="background-color: rgb(255, 128, 0);">
						&nbsp;
						<select size="4" name="orderList">
						<%
							for(MenuItem item : orderList) {
                                                            out.println("<option value='" + item.getItemName() + "'>" + item.getItemName() + "</option>");
							}
						 %>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td align="center">&nbsp;<br><br>  
						<input type="submit" value="Place Order" name="submit"> 
					</td>
					<td>&nbsp; 
						<br> 
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		<br>
	</body>
</html>
