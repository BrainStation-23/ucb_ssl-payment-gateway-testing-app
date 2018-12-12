<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: nasir
  Date: 12/22/16
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <title>SSL Test APP</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/css/lib/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/ssl.app.css" />">
    <script src="<c:url value="/resources/js/lib/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/ssl.app.js" />"></script>
</head>
<body class="full-page-background">

<div class="container page-header header">
    <h1>SSL Test APP - Error</h1>
</div>
<div class="container" style="margin-top: 10px">
    <p style="text-align: center; color: red">Something went wrong please try again later</p>

    <p style="text-align: center">
        ...<br>
        ...<br>
    </p>

    <p style="margin: 10px;">
        <c:out value="${exceptionMsg}"></c:out>
    </p>

</div>


<a href="#" class="scrollToTop"></a>

<c:if test="${view}">
    <script type="text/javascript">
        $(document).ready(function(){
            $('#paymentModal').modal('show');
        });
    </script>
</c:if>
</body>
</html>