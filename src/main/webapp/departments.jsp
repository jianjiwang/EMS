<%@ page import="java.util.Date" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							&nbsp;<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">

						<tr class="table_header">
							<td>
								部门ID
							</td>
							<td>
								部门编号
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach items="${requestScope.departments}" var="department">
						<tr class="row1">						   
							<td>
								${department.id}
							</td>
		
							<td>
								${department.number}
							</td>
							<td>
								${department.name}
							</td>				
							<td>
								<a href="${pageContext.request.contextPath}/department/selectOne.do?id=${department.id}">更新</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/employees/selectAll.do?id=${department.id}">员工列表</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/> <input type="button" class="button" value="添加部门" onclick="location='${pageContext.request.contextPath}/addDepartment.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
