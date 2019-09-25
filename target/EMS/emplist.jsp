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
							<a href="${pageContext.request.contextPath}/department/selectAll.do">main</a>
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
								ID
							</td>
							<td>
							    头像
							</td>
							<td>
								姓名
							</td>
							<td>
								工资
							</td>
							<td>
								年龄
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach var="employee" items="${requestScope.employees}">
						<tr class="row1">						   
							<td>
								${employee.id}
							</td>
							 <td>
							  <img width="40px" height="40px" src="${pageContext.request.contextPath}/upload/${employee.picture}" />
							</td>
							
							<td>
								${employee.name}
							</td>
							<td>
								${employee.salary}
							</td>
							<td>
								${employee.age}
							</td>
							<td>
								${employee.department.name}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/employees/delete.do?id=${employee.id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/employees/selectOne.do?id=${employee.id}">update emp</a>
							</td>
						</tr>
						</c:forEach>

					</table>
					
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
