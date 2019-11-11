<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-04
  Time: 21:27
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


<%--    <script>--%>
<%--        var datefield = document.createElement("input");--%>
<%--        datefield.setAttribute("type", "date");--%>
<%--        if (datefield.type != "date") { // if browser doesn't support input type="date", load files for jQuery UI Date Picker--%>
<%--            document.write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')--%>
<%--            document.write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')--%>
<%--            document.write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')--%>
<%--        }--%>
<%--    </script>--%>

<%--    <script>--%>
<%--        if (datefield.type != "date") { // if browser doesn't support input type="date", initialize date picker widget:--%>
<%--            jQuery(function($) { // on document.ready--%>
<%--                $('#start_date').datepicker({--%>
<%--                    dateFormat: 'yy-mm-dd'--%>
<%--                });--%>
<%--                $('#end_date').datepicker({--%>
<%--                    dateFormat: 'yy-mm-dd'--%>
<%--                });--%>
<%--            })--%>
<%--        }--%>
<%--    </script>--%>


</head>
<body>
<jsp:include page="header.jsp"/>


<form action="/addCustomer" method="post">
    <div>
        <div>
            <h3 >NEW CUSTOMER</h3>
        </div>
        <div>
            <button type="submit">SAVE</button>
        </div>
    </div>


    <label>
        First name: <input type = "text" name="firstName" required placeholder="First name" />
    </label>
    <label>
        Last name: <input type = "text" name="lastName" required placeholder="Last name"/>
    </label>

    <label>Date of birth
        <input type="date" name="dateOfBirth" placeholder="Date of birth yyyy-MM-dd">
    </label>

</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
