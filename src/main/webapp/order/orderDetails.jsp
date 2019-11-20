<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-12
  Time: 11:30
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


<div>
    <div><a href="/orderList">Back to order list</a></div>
    <%--    <div><a href="/customerOrders?id=${customer.id}">Back to customer orders</a></div>--%>
</div>


<div>
    <h3>ORDER DETAILS</h3>
</div>

<div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">REPAIR ACCEPTANCE DATE</th>
            <th scope="col">PLANNED REPAIR START</th>
            <th scope="col">REPAIR START</th>
            <th scope="col">PROBLEM DESCRIPTION</th>
            <th scope="col">REPAIR DESCRIPTION</th>
            <th scope="col">SPARE PARTS COST</th>
            <th scope="col">MAN HOUR COST</th>
            <th scope="col">MAN HOUR AMOUNT</th>
            <th scope="col">CUSTOMER COST</th>
            <th scope="col">CUSTOMER ID</th>
            <th scope="col">VEHICLE ID</th>
            <th scope="col">EMPLOYEE ID</th>
            <th scope="col">STATUS ID</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${order.repairAcceptanceDate}</td>
            <td>${order.plannedRepairStart}</td>
            <td>${order.repairStart}</td>
            <td>${order.problemDescription}</td>
            <td>${order.repairDescription}</td>
            <td>${order.sparepartsCost}</td>
            <td>${order.manHourCost}</td>
            <td>${order.manHourAmount}</td>
<%--            <td>${order.customerCost}</td>--%>
            <td>${order.sparepartsCost + order.manHourAmount * order.manHourCost}</td>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${vehicle.brand} ${vehicle.model} ${vehicle.registrationNumber}</td>
            <td>${employee.firstName} ${employee.lastName}</td>
            <td>${status.name}</td>
            <%--            <td>${order.customerId}</td>--%>
            <%--            <td>${order.vehicleId}</td>--%>
            <%--            <td>${order.employeeId}</td>--%>
            <%--            <td>${order.statusId}</td>--%>
        </tr>
        </tbody>
    </table>
</div>

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
