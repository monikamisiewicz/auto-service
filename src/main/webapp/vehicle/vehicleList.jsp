<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-10
  Time: 19:33
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

<div><h3>Vehicle List</h3></div>
<div><a href="/addVehicle">Add vehicle</a></div>


<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>MODEL</th>
            <th>BRAND</th>
            <th>YEAR OF PRODUCTION</th>
            <th>REGISTRATION NUMBER</th>
            <th>NOTE</th>
            <th>NEXT SERVICE</th>
            <th>CUSTOMER ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vehicle" items="${vehicles}">
            <tr>
                <td>${vehicle.id}</td>
                <td>${vehicle.model}</td>
                <td>${vehicle.brand}</td>
                <td>${vehicle.yearOfProduction}</td>
                <td>${vehicle.registrationNumber}</td>
                <td>${vehicle.note}</td>
                <td>${vehicle.nextService}</td>
                <td>${vehicle.customerId}</td>
<%--                <td><a href="/customerVehicles?id=${customer.id}">Customer vehicles</a></td>--%>
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
