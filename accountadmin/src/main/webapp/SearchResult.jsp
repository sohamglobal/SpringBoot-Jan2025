<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2 class="display-5">Search Result</h2>
<hr>
<table class="table table-bordered">
        <tr>
            <td>Account Number</td>
            <td>${acc.accno}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${acc.accnm}</td>
        </tr>
        <tr>
            <td>Type</td>
            <td>${acc.acctype}</td>
        </tr>
        <tr>
            <td>Balance</td>
            <td><b>${acc.balance}</b></td>
        </tr>

    </table>


</div>
</body>
</html>