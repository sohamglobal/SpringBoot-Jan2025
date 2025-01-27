<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Funds Transfer Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #ffe6f0; /* Light pink background */
            color: #d63384; /* Dark pink text */
        }
        .form-container {
            border: 2px solid #d63384; /* Dark pink border */
            border-radius: 10px;
            padding: 20px;
            margin: 50px auto;
            background-color: #ffffff; /* White background for form */
            max-width: 600px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-heading {
            text-align: center;
            margin-bottom: 20px;
        }
        .btn-pink {
            background-color: #d63384;
            border: none;
            color: #fff;
        }
        .btn-pink:hover {
            background-color: #c7256a;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="form-container">
        <h1 class="form-heading">Funds Transfer Form</h1>
        <form action="transferamount" method="post">
            <div class="mb-3">
                <label for="fromAccount" class="form-label">From Account Number</label>
                <input type="text" class="form-control" id="fromAccount" name="fromaccount" placeholder="Enter your account number" required>
            </div>

            <div class="mb-3">
                <label for="toAccount" class="form-label">To Account Number</label>
                <input type="text" class="form-control" id="toAccount" name="toaccount" placeholder="Enter recipient's account number" required>
            </div>

            <div class="mb-3">
                <label for="amount" class="form-label">Amount</label>
                <input type="number" class="form-control" id="amount" name="amount" placeholder="Enter amount to transfer" required>
            </div>

            <div class="mb-3">
                <label for="purpose" class="form-label">Purpose</label>
                <textarea class="form-control" id="purpose" name="purpose" rows="3" placeholder="Enter purpose of transfer" required></textarea>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-pink">Submit</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
