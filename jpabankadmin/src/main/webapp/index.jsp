<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPA Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<br><br>
<h1 class="display-4">JPA Bank Admin</h1>
<hr>

<a href="newacc">Open New Account</a>
<br>
<a href="accrepo">Account Report</a>
<br><br>

<form action="searchaccno" method="post">
    Account number <input type="number" name="accno" required autocomplete="off">
    <input type="submit" value="Search" class="btn btn-info">
</form>
<br>

<br>
<a href="deposit">Deposit</a>
<br>
<a href="withdraw">Withdraw</a>
<br>
<a href="deduct">Deduct charges from accounts</a>
<br>
<a href="transfer">Amount Transfer</a>
<br>
<a href="close">Close Account</a>
</div>

</body>
</html>