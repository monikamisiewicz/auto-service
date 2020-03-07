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



<h3>NEW VEHICLE</h3>
<form action="/addVehicle" method="post">


    <div class="form-group">
        <label for="model">Model</label>
        <input type="text" class="form-control" name="model" required placeholder="Model" id="model"/>
    </div>
    <div class="form-group">
        <label for="brand">Brand:</label>
        <input type="text" class="form-control" name="brand" required placeholder="Brand" id="brand"/>
    </div>

    <div class="form-group">
        <label for="productionYear">Year of production</label>
        <input type="number" class="form-control" min="1900" step="1" name="yearOfProduction" placeholder="Year of production" id="productionYear">
    </div>

    <div class="form-group">
        <label for="registrationNo">Registration number</label>
            <input type="text" class="form-control" name="registrationNumber" placeholder="Registration number" id="registrationNo">
    </div>

    <div class="form-group">
        <label for="nextService">Next service</label>
            <input type="date" class="form-control" name="nextService" placeholder="Next service yyyy-mm-dd" id="nextService">
    </div>

    <div class="form-group">
        <label for="customer">Customer</label>
            <select class="custom-select" id="customer" name="customerId">
                <c:forEach var="customer" items="${customers}">
                    <option selected value="${customer.id}">${customer.firstName} ${customer.lastName} ID ${customer.id}</option>
                </c:forEach>
            </select>
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
