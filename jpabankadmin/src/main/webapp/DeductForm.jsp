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
        <h2 class="display-4">Deduct Form</h2>
        <hr>
        <form action="dedamt" method="post">
            <table>
                <tr>
                    <td>Account Type</td>
                    <td>
                        <select name="type" class="form-control">
                            <option value="saving">Saving</option>
                            <option value="current">Current</option>
                            <option value="fixed">Fixed</option>
                        </select>
                    </td>
                   
                </tr>
                <tr>
                    <td>Amount</td>
                    <td><input type="number" name="amount" class="form-control"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" class="btn btn-primary">
                    </td>
                </tr>
            </table>
        </form>

    </div>

</body>
</html>