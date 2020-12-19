<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>DEMO</title>
	<link rel="stylesheet" type="text/css" href="js/bootstrap.min.css"/>
    <style type="text/css">
        td{
            width: 120px;
            height: 30px;
            text-align: center;
        }
        td:hover{
            box-shadow: 3px 3px 5px yellowgreen;
        }
        tr:nth-child(even){
            background-color: lightblue;
        }
    </style>
</head>
<body>
<table id="empsInfo" class="table table-bordered table-striped table-hover">
   <thead>
        <th class="success">empno</th>
        <th class="success">ename</th>
        <th class="success">hiredate</th>
        <th class="success">sal</th>
        <th class="warning">operation</th>
	</thead>
	<tbody>
    <c:forEach items="${empsFromServer}" var="emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
            <td>
                <a href="${pageContext.request.contextPath}/empbyid?empno=${emp.empno}">修改</a> <a href="${pageContext.request.contextPath}/empdelete?empno=${emp.empno}" onclick="return confirm('确定删除吗？')">删除</a> 
			</td>
        </tr>
		</tbody>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/newemp.jsp">新增</a>
<hr>
<form action="${pageContext.request.contextPath}/empbyid" method="post">
    EMPNO:<input type="text" name="empno" placeholder="输入员工编号">
    <input type="submit" value="精确查询">
</form>
<hr>
<form action="${pageContext.request.contextPath}/empbyname" method="post">
    ENAME:<input type="text" name="ename" placeholder="输入员工姓名">
    <input type="submit" value="模糊查询">
</form>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
