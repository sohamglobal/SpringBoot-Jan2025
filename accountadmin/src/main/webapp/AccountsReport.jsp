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
<h2 class="display-5">Accounts Report</h2>
<a href="/adminhome">Admin Home</a>
<hr>

<table class="table table-bordered table-hover">
        <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Type</th>
            <th>Balance</th>
        </tr>
        
        <c:forEach items="${acclist}" var="ac">
        <tr>
            <td>${ac.accno}</td>
            <td>${ac.accnm}</td>
            <td>${ac.acctype}</td>
            <td>${ac.balance}</td>
        </tr>
        </c:forEach>

    </table>



</div>

</body>
</html>