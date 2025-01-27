<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Account Form</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 50px;
        }
        .form-container {
            border: 1px solid #dee2e6;
            padding: 30px;
            border-radius: 10px;
            background-color: #f8f9fa;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
            border: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="form-container">
                    <h2 class="text-center">New Account Form</h2>
                    <form action="addacc" method="post">
                        <div class="form-group">
                            <label for="accno">Account Number</label>
                            <input type="text" class="form-control" id="accno" name="accno" required>
                        </div>
                        <div class="form-group">
                            <label for="accnm">Account Name</label>
                            <input type="text" class="form-control" id="accnm" name="accnm" required>
                        </div>
                        <div class="form-group">
                            <label for="acctype">Account Type</label>
                            <select class="form-control" id="acctype" name="acctype" required>
                                <option value="saving">Saving</option>
                                <option value="current">Current</option>
                                <option value="fixed">Fixed</option>
                                <option value="ppf">PPF</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="balance">Balance</label>
                            <input type="number" class="form-control" id="balance" name="balance" required>
                        </div>
                        <button type="submit" class="btn btn-custom btn-block">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
