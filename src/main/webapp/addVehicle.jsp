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


<form action="/addVehicle" method="post">
    <div>
        <div>
            <h3 >NEW VEHICLE</h3>
        </div>
        <div>
            <button type="submit">SAVE</button>
        </div>
    </div>


    <label>
        Model: <input type = "text" name="model" required placeholder="Model" />
    </label>
    <label>
        Brand: <input type = "text" name="brand" required placeholder="Brand"/>
    </label>
    <label>Year of production
        <input type="number" name="yearOfProduction" placeholder="Year of production">
    </label>
    <label>Registration number
        <input type="text" name="registrationNumber" placeholder="Registration number">
    </label>
    <label>Note
        <input type="text" name="note" placeholder="Note">
    </label>
    <label>Next service
        <input type="date"  name="nextService" placeholder="Next service">
    </label>
    <label>Customer id - przekazać w polu???
        <input type="number"  name="customerId" placeholder="customerId">
    </label>


</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
