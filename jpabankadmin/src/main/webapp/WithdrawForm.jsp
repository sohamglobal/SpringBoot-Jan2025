<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .purple-theme {
            background-color: #6f42c1;
            color: white;
        }
        .purple-border {
            border: 2px solid #6f42c1;
        }
        .purple-margin {
            margin: 20px;
        }
        .purple-btn {
            background-color: #6f42c1;
            border-color: #6f42c1;
            color: white;
        }
        .purple-btn:hover {
            background-color: #5a379d;
            border-color: #5a379d;
        }
    </style>
</head>
<body>
    <div class="container purple-margin">
        <div class="row">
            <div class="col-md-6 offset-md-3 purple-border p-4">
                <h2 class="text-center purple-theme p-2 display-5">Deposit Form</h2>
                <form action="acctransact" method="post">
                    <div class="form-group">
                        <label for="accno">Account Number</label>
                        <input type="text" class="form-control" id="accno" name="accno" placeholder="Enter account number" required>
                    </div>
                    <div class="form-group">
                        <label for="amount">Amount</label>
                        <input type="number" class="form-control" id="amount" name="amount" placeholder="Enter amount" required>
                    </div>
                    <input type="hidden" name="trtype" value="withdraw">
                    <button type="submit" class="btn purple-btn btn-block">Submit</button>
                </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
