<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>
<hr>
<table>
<c:forEach items="${list}" var="e">
          <tr>
            <td>${e.empNumber}</td>
            <td>${e.empName}</td>
            <td>${e.department}</td>
            <td>${e.baseLocation}</td>
            <td>₹ ${e.salary}</td>
          </tr>
          </c:forEach>
</table>
</body>
</html>