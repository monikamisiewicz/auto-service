<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-05
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>AUTO SERVICE</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300&display=swap" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/style.css"/> ">
</head>
<body>
<jsp:include page="../header.jsp"/>

<h4>Delete customer?</h4>
<form action="/deleteCustomer?id=${customer.id}" method="post">

    <div class="form-check">
        <input class="form-check-input" type="radio" name="delete" id="firstRadio" value="Cancel" checked>
        <label class="form-check-label" for="firstRadio">
            Return
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="delete" id="secondRadio" value="Ok">
        <label class="form-check-label" for="secondRadio">
            Delete
        </label>
    </div>

    <button type="submit" class="btn btn-warning">Submit</button>

</form>

<jsp:include page="../footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
