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


<form action="/addOrder" method="post">
    <div>
        <div>
            <h3>NEW ORDER</h3>
        </div>
        <div>
            <button type="submit">SAVE</button>
        </div>
    </div>

    <div>
        <label>
            Repair acceptance date:
        </label>
        <div>
            <input type="date" name="repairAcceptanceDate" required placeholder="yyyy-mm-dd"/>
        </div>
    </div>

    <div>
        <label>Planned repair start</label>
        <div><input type="date" name="plannedRepairStart" required placeholder="yyyy-mm-dd"/></div>
    </div>
    <div>
        <label>Repair start</label>
        <div><input type="date" name="repairStart" placeholder="yyyy-mm-dd"></div>
    </div>
    <div>
        <label>Problem description</label>
        <div><textarea name="problemDescription" cols="30" rows="5"></textarea></div>
    </div>
    <div>
        <label>Repair description</label>
        <div><textarea name="repairDescription" cols="30" rows="5"></textarea></div>
    </div>
    <%--    <div>--%>
    <%--        <label>Customer cost</label>--%>
    <%--        <div><input type="number" min="0.00" step="0.01" name="customerCost" placeholder="Customer cost"></div>--%>
    <%--    </div>--%>
    <div>
        <label>Spareparts cost</label>
        <div><input type="number" min="0.00" step="0.01" name="sparepartsCost" placeholder="Spareparts cost"></div>
    </div>
    <div>
        <label>Man hour cost</label>
        <div><input type="number" min="0.00" step="0.01" name="manHourCost" placeholder="Man hour cost"></div>
    </div>
    <div>
        <label>Man hour amount</label>
        <div><input type="number" min="0" step="1" name="manHourAmount" placeholder="Man hour amount"></div>
    </div>

    <div>
        <label for="customer">Customer</label>
        <div>
            <select id="customer" name="customerId">
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}">${customer.firstName} ${customer.lastName}
                        ID: ${customer.id} </option>
                </c:forEach>
            </select>
        </div>
    </div>
    <%--zrobić walidację, jeśli customer id=? to pokaż tylko vehicles z tym id--%>
    <div>
        <label for="vehicle">Vehicle</label>
        <div>
            <select id="vehicle" name="vehicleId">
                <c:forEach var="vehicle" items="${vehicles}">

                    <c:if test="${order.vehicleId == vehicle.id}">
                        <option selected value="${vehicle.id}">${vehicle.model} ${vehicle.brand} ${vehicle.registrationNumber}</option>
                    </c:if>
                    <c:if test="${order.vehicleId != vehicle.id}">
                        <option value="${vehicle.id}">${vehicle.model} ${vehicle.brand} ${vehicle.registrationNumber}</option>
                    </c:if>

                </c:forEach>
            </select>
        </div>
    </div>
    <div>
        <label for="employee">Employee responsible for repair</label>
        <div>
            <select id="employee" name="employeeId">
                <c:forEach var="employee" items="${employees}">
                    <option value="${employee.id}">${employee.firstName} ${employee.lastName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div>
        <label for="status">Repair status</label>
        <div>
            <select id="status" name="statusId">
                <c:forEach var="status" items="${statuses}">
                    <option value="${status.id}">${status.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>


</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
