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
    <div><a href="/employeeList">Back</a>
    </div>
</div>

<form action="/editEmployee?id=${employee.id}" method="post">
    <div>
        <h3>EDIT EMPLOYEE</h3>
        <button type="submit">Save</button>
    </div>

    <div>
        <div>
            <label for="employeeId">
                Customer Id
            </label>
            <input type="number" name="id" value="${employee.id}" required id="employeeId">
        </div>
        <div>
            <label for="firstName">
                First Name
            </label>
            <input type="text" name="firstName" placeholder="${employee.firstName}" required id="firstName">
        </div>
        <div>
            <label for="lastName">
                Last Name
            </label>
            <input type="text" name="lastName" placeholder="${employee.lastName}" required id="lastName">
        </div>
        <div>
            <label for="address" >
                Address
            </label>
            <input type="text" name="address" placeholder="${employee.address}" id="address">
        </div>
        <div>
            <label for="telephone" >
                Telephone
            </label>
            <input type="text" name="telephone" placeholder="${employee.telephone}" id="telephone">
        </div>
        <div>
            <label for="note" >
                Note
            </label>
            <textarea name="note" cols="10" rows="10" id="note"></textarea>
        </div>
        <div>
            <label for="manHourCost" >
                Man hour cost
            </label>
            <input type="number" min="0.00" step="0.01" name="manHourCost" placeholder="${employee.manHourCost}" id="manHourCost">
        </div>


    </div>

</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
