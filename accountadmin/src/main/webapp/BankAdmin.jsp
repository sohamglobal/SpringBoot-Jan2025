<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bankadmin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<br><br>
<h2 class="display-5">Admin Home</h2>
Logged in as : ${user}
<hr>
<a href="newacc">Open New Account</a>
<br><br>

<form action="searchaccno" method="post">
    Account number <input type="number" name="accno" required autocomplete="off">
    <input type="submit" value="Search" class="btn btn-info">
</form>
<br>
                        <a href="report">Accounts Report</a>
                        <br>
                        <a href="deposit">Deposit amount</a>
                        <br>
                        <a href="withdraw">Withdraw amount</a>
                        <br>
                        <a href="transfer">Transfer Money</a>
                        <br>
                        <a href="delete">Close Account</a>
                        <br>
                        <a href="acctypes">Report on type</a>

</div>
</body>
</html>