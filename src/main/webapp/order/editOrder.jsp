<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-11
  Time: 21:16
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


<div><a href="/orderList">Back</a></div>

<h3>EDIT ORDER</h3>
<form action="/editOrder?id=${order.id}" method="post">

    <div class="form-group">
        <label for="repairAcceptance">Repair acceptance date</label>
        <input type="date" class="form-control" name="repairAcceptanceDate" required value="${order.repairAcceptanceDate}" id="repairAcceptance"/>
    </div>

    <div class="form-group">
        <label for="plannedStart">Planned repair start</label>
        <input type="date" class="form-control" name="plannedRepairStart" required value="${order.plannedRepairStart}" id="plannedStart"/>
    </div>

    <div class="form-group">
        <label for="repairStart">Repair start</label>
        <input type="date" class="form-control" name="repairStart" value="${order.repairStart}" id="repairStart">
    </div>

    <div class="form-group">
        <label for="problemDescription">Problem description</label>
        <textarea class="form-control" name="problemDescription" rows="3" id="problemDescription"></textarea>
    </div>
    <div class="form-group">
        <label for="repairDescription">Repair description</label>
        <textarea class="form-control" name="repairDescription" rows="3" id="repairDescription"></textarea>
    </div>
    <%--    <div>--%>
    <%--        <label>Customer cost</label>--%>
    <%--        <div><input type="number" min="0.00" step="0.01" name="customerCost" placeholder="Customer cost"></div>--%>
    <%--    </div>--%>
    <div class="form-group">
        <label for="spareparts">Spareparts cost</label>
        <input type="number" class="form-control" min="0.00" step="0.01" name="sparepartsCost" value="${order.sparepartsCost}" id="spareparts">
    </div>
    <div class="form-group">
        <label for="manHourCost">Man hour cost</label>
        <input type="number" class="form-control" min="0.00" step="0.01" name="manHourCost" selected value="${order.manHourCost}" id="manHourCost">
    </div>
    <div class="form-group">
        <label for="manHours">Man hour amount</label>
        <input type="number" class="form-control" min="0" step="1" name="manHourAmount" value="${order.manHourAmount}" id="manHours">
    </div>

    <div class="form-group">
        <label for="customer">Customer</label>
        <select class="custom-select" id="customer" name="customerId">
            <c:forEach var="customer" items="${customers}">
                <option selected value="${customer.id}">${customer.firstName} ${customer.lastName}
                    ID: ${customer.id} </option>
            </c:forEach>
        </select>
    </div>
    <%--zrobić walidację, jeśli customer id=? to pokaż tylko vehicles z tym id--%>
    <div class="form-group">
        <label for="vehicle">Vehicle</label>
        <select class="custom-select" id="vehicle" name="vehicleId">
            <c:forEach var="vehicle" items="${vehicles}">

                <c:if test="${order.vehicleId == vehicle.id}">
                    <option selected value="${vehicle.id}">${vehicle.model} ${vehicle.brand} ${vehicle.registrationNumber}</option>
                </c:if>
                <c:if test="${order.vehicleId != vehicle.id}">
                    <option selected value="${vehicle.id}">${vehicle.model} ${vehicle.brand} ${vehicle.registrationNumber}</option>
                </c:if>

            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="employee">Employee responsible for repair</label>
        <select class="custom-select" id="employee" name="employeeId">
            <c:forEach var="employee" items="${employees}">
                <option selected value="${employee.id}">${employee.firstName} ${employee.lastName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="status">Repair status</label>
        <select class="custom-select" id="status" name="statusId">
            <c:forEach var="status" items="${statuses}">
                <option selected value="${status.id}">${status.name}</option>
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