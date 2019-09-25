<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@ page import="java.util.Date" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/style.css" />
		<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="application/javascript">
			$(function () {
				$.ajax({
					url:"${pageContext.request.contextPath}/department/ajaxSelectAll.do",
					type:"GET",
					dataType:"JSON",
					success:function (list) {
						for(var i=0;i<list.length;i++){
							if(list[i].id==${requestScope.employees.department.id}){
                                //创建option标签
                                var option = $("<option selected='selected' value=" + list[i].id + ">" + list[i].name + "</option>")
                                $("#department").append(option);
							}else {
                                var option1 = $("<option value=" + list[i].id + ">" + list[i].name + "</option>")
                                $("#department").append(option1);
							}
                        }
                    }
				});
            });
		</script>
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
								<a href="${pageContext.request.contextPath}/department/selectAll.do">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
                    <form action="${pageContext.request.contextPath}/employees/update.do" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="picture" value="${requestScope.employees.picture}"/>
                        <table cellpadding="0" cellspacing="0" border="0"
                               class="form_table">
                            <tr>
                                <td valign="middle" align="right">
                                    id:
                                </td>
                                <td valign="middle" align="left">
                                    ${requestScope.employees.id}
                                    <input type="hidden" name="id" value="${requestScope.employees.id}"/>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">
                                    头像:
                                </td>
                                <td valign="middle" align="left">
                                    <img width="40px" height="40px" src="${pageContext.request.contextPath}/upload/${requestScope.employees.picture}" />
                                    <input type="file" name="upload" />
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">
                                    用户名:
                                </td>
                                <td valign="middle" align="left">
                                    <input type="text" class="inputgri" name="name" value="${requestScope.employees.name}"/>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">
                                    工资:
                                </td>
                                <td valign="middle" align="left">
                                    <input type="text" class="inputgri" name="salary" value="${requestScope.employees.salary}"/>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">
                                    年龄:
                                </td>
                                <td valign="middle" align="left">
                                    <input type="text" class="inputgri" name="age" value="${requestScope.employees.age}"/>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">
                                    部门:
                                </td>
                                <td valign="middle" align="left">
                                    <select id="department" name="did">
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <p>
                            <input type="submit" class="button" value="修改" />
                        </p>
                    </form>
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
