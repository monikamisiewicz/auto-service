<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-13
  Time: 21:55
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

<%--<a href="/customerVehicles?id=${customer.id}">Back</a>--%>


<h3>VEHICLE DETAILS</h3>
<a href="/addVehicle">Add vehicle</a>


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">MODEL</th>
        <th scope="col">BRAND</th>
        <th scope="col">YEAR OF PRODUCTION</th>
        <th scope="col">REGISTRATION NUMBER</th>
        <th scope="col">NEXT SERVICE</th>
        <th scope="col">CUSTOMER</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${vehicle.model}</td>
        <td>${vehicle.brand}</td>
        <td>${vehicle.yearOfProduction}</td>
        <td>${vehicle.registrationNumber}</td>
        <td>${vehicle.nextService}</td>
        <td>${customer.firstName} ${customer.lastName}</td>
    </tr>
    </tbody>
</table>


<div><h3>REPAIR HISTORY</h3></div>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">REPAIR START</th>
        <th scope="col">REPAIR DESCRIPTION</th>
        <th scope="col">MORE</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="order" items="${orders}" varStatus="loopCount">
        <tr>
            <th scope="row">${loopCount.count} </th>
            <td>${order.repairStart}</td>
            <td>${order.repairDescription}</td>
            <td><a href="/orderDetails?id=${order.id}">Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

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