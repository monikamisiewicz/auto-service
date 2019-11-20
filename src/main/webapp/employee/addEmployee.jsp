<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-04
  Time: 14:21
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
    <link rel="stylesheet" href="<c:url value="../css/style.css"/> ">
</head>
<body>
<jsp:include page="../header.jsp"/>

<h3>NEW EMPLOYEE</h3>
<form action="/addEmployee" method="post">

    <div class="form-group">
        <label for="firstName">First name</label>
        <input type="text" class="form-control" name="firstName" required placeholder="Enter first name" id="firstName"/>
    </div>

    <div class="form-group">
        <label for="lastName">Last name</label>
        <input type="text" class="form-control" name="lastName" required placeholder="Last name" id="lastName"/>
    </div>

    <div class="form-group purple-border">
        <label for="address">Address</label>
        <textarea class="form-control" name="address" rows="3" placeholder="Address" id="address"></textarea>
    </div>

    <div class="form-group">
        <label for="telephone">Telephone number</label>
        <input type="text" class="form-control" name="telephone" required placeholder="Telephone number" id="telephone"/>
    </div>


    <div class="form-group purple-border">
        <label for="note">Note</label>
        <textarea class="form-control" name="note" rows="3" placeholder="Note" id="note"></textarea>
    </div>

    <div class="form-group">
        <label for="manHourCost">Man hour cost</label>
            <input type="number" class="form-control" name="manHourCost" id="manHourCost" min="0.00" step="0.01" placeholder="Man hour cost">
    </div>

    <button type="submit" class="btn btn-primary">SAVE</button>
</form>

<jsp:include page="../footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
