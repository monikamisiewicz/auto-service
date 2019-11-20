<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-05
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>AUTO SERVICE</title>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/> ">
</head>
<body>
<jsp:include page="header.jsp"/>


<div>
    <h3>CUSTOMER VEHICLES</h3>
        <h3>Owner: ${customer.firstName} ${customer.lastName}</h3>
</div>
<div>
    <div><a href="/customerDetails?id=${customer.id}">Back</a></div>
</div>
<div><a href="/addVehicle">Add vehicle</a></div>


<div>
    <table>
        <thead>
        <tr>
            <th> </th>
            <th>MODEL</th>
            <th>BRAND</th>
            <th colspan="3">MORE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vehicle" items="${vehicles}" varStatus="loopCount">
            <tr>
                <th>${loopCount.count}</th>
                <td>${vehicle.model}</td>
                <td>${vehicle.brand}</td>
                <td><a href="/vehicleDetails?id=${vehicle.id}">Details</a></td>
                <td><a href="/editVehicle?id=${vehicle.id}">Edit</a></td>
                <td><a href="/deleteVehicle?id=${vehicle.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
