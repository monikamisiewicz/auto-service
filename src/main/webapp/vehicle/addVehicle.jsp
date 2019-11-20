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
    <link rel="stylesheet" href="<c:url value="/css/style.css"/> ">
</head>
<body>
<jsp:include page="header.jsp"/>

<div>
    <div><a href="/customerVehicles?id=${customer.id}">Back</a></div>
</div>

<form action="/addVehicle" method="post">
    <div>
        <div>
            <h3 >NEW VEHICLE</h3>
        </div>
        <div>
            <button type="submit">SAVE</button>
        </div>
    </div>

<div>

</div>
    <div>
        <label>Model:</label>
        <div>
            <input type = "text" name="model" required placeholder="Model" />
        </div>
    </div>
    <div>
        <label>Brand:</label>
        <div>
            <input type = "text" name="brand" required placeholder="Brand"/>
        </div>
    </div>

    <div>
        <label>Year of production</label>
        <div>
            <input type="number" name="yearOfProduction" placeholder="Year of production">
        </div>
    </div>

    <div>
        <label>Registration number</label>
        <div>
            <input type="text" name="registrationNumber" placeholder="Registration number">
        </div>
    </div>

    <div>
        <label>Next service</label>
        <div>
            <input type="date"  name="nextService" placeholder="Next service yyyy-mm-dd">
        </div>
    </div>

    <div>
        <label for="customer">Customer</label>
        <div>
            <select id="customer" name="customerId">
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}">${customer.firstName} ${customer.lastName} ID ${customer.id}</option>
                </c:forEach>
            </select>
        </div>
    </div>
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
