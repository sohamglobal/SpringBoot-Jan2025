<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<br><br>
<h1 class="display-4">Account Report</h1>
<hr>

<table class="table table-bordered table-hover">
<tr>
<th>Account Number
<th>Name
<th>Type
<th>Balance
</tr>

<c:forEach items="${list}" var="ac">

<tr>
<td>${ac.accno}
<td>${ac.accnm}
<td>${ac.acctype}
<td>${ac.balance}
</tr>


</c:forEach>


</table>


</div>
</body>
</html>