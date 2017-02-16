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
            <h1>SSL Test APP</h1>
        </div>
        <div class="container" style="margin-top: 10px">
            <div class="navigation-bar">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/true">Reset SSL for New Transaction</a>
                <c:if test="${not empty responseBody}"><a class="btn btn-primary"  href="#responseBody">Response Body</a></c:if>
                <c:if test="${not empty requestBody}"><a class="btn btn-primary" href="#requestBody">Request Body</a></c:if>
            </div>
            <div class="row col-lg-8">
                <div class="span 12" style="display: table; margin: 0 auto;">
                    <form:form action="${pageContext.request.contextPath}/gateway/token" modelAttribute="gatewayDto" class="form-inline" method="post">
                        <div class="form-group">
                            <form:input type="text" cssClass="form-control" path="userName" placeholder="User name"></form:input>
                        </div>
                        <div class="form-group">
                            <form:password cssClass="form-control" path="password" placeholder="Password"></form:password>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form:form>

                </div>

            <br>
            <c:if test="${not empty paymentGatewayModelRequest}">
                <br><p class="row  col-lg-12 ssl-text center"><b>Merchant Key:</b><br>${merchantKey}</p>
                <div class="row col-lg-12">
                    <%--<div class="col-lg-2"></div>--%>
                        <h4>Payment Gateway Form</h4>
                        <form:form action="${weburl}/merchant/login" modelAttribute="paymentGatewayModelRequest" method="post" target="_blank">
                            <div class="form-group">
                                <label for="merchantKey">Merchant Key:<span style="color: #F00;">*</span></label>
                                <form:input type="text" cssClass="form-control" path="merchantKey" readonly="true"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="productName">Product Name:<span style="color: #F00;">*</span></label>
                                <form:input cssClass="form-control" path="productName" placeholder="Product Name"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="productPrice">Product Price:<span style="color: #F00;">*</span></label>
                                <form:input cssClass="form-control" path="productPrice" placeholder="Product Price"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="SSLRefId">SSL Reference ID:<span style="color: #F00;">*</span></label>
                                <form:input cssClass="form-control" path="SSLRefId" placeholder="SSL Ref. ID"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="returnURL">Return Url:<span style="color: #F00;">*</span></label>
                                <form:input cssClass="form-control" path="returnURL" placeholder="Return Url"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="merchantName">Merchant Name:</label>
                                <form:input cssClass="form-control" path="merchantName" placeholder="Merchant Name"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="merchantIMG_url">Merchant Image Url:</label>
                                <form:input cssClass="form-control" path="merchantIMG_url" placeholder="Merchant Imgae Url"></form:input>
                            </div>
                            <button type="submit" class="btn btn-default" style="float: right">Submit</button>
                        </form:form>
                    </div>
                <hr>
                    <%--<div class="col-lg-2"></div>--%>
            </c:if>

                <c:if test="${not empty gatewayPaymentVerifyRequest}">
                    <div class="row col-lg-12">
                            <%--<div class="col-lg-2"></div>--%>
                        <h4>Payment Gateway Verify Form</h4>
                        <form:form action="${pageContext.request.contextPath}/return/payment/gateway" modelAttribute="gatewayPaymentVerifyRequest" method="post">
                            <div class="form-group">
                                <label for="merchantKey">Merchant Key:</label>
                                <form:input type="text" cssClass="form-control" path="merchantKey" readonly="true"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="productName">Transaction Reference:</label>
                                <form:input cssClass="form-control" path="transactionReference" readonly="true"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="productPrice">Merchant Password:</label>
                                <form:password cssClass="form-control" path="password" placeholder="Merchant Password"></form:password>
                            </div>

                            <button type="submit" class="btn btn-default">Submit</button>
                        </form:form>
                    </div>
                    <hr>
                    <%--<div class="col-lg-2"></div>--%>
                </c:if>

            </div>
            <div class="col-lg-4">
                <h4>Status Box</h4>
                <div class="status-panel">
                    <c:forEach items="${statusListRight}" var="status">
                        <div class="panel panel-body status-box">
                            <c:choose>
                                <c:when test="${status.contains('Failed')}">
                                    <span style="color: red">${status}</span>
                                </c:when>
                                <c:otherwise>
                                    ${status}
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </c:forEach>
                </div>
            </div>
            <c:if test="${not empty requestBody}">
                <div class="row col-lg-12 actionBody" id="requestBody">
                    <h5>Request Body</h5>
                    <div class="row col-lg-12 ssl-text">
                            ${requestBody}
                    </div>
                </div>
            </c:if>
            <br>
            <c:if test="${not empty responseBody}">
                <div class="row col-lg-12 actionBody" id="responseBody">
                    <h5>Response Body</h5>
                    <div class="row col-lg-12 ssl-text">
                            ${responseBody}
                    </div>
                </div>
            </c:if>
        </div>

        <br>
        <br>
        <br>
        <br>
        <div class="panel-footer center footer">SSL Test APP | Brain Station 23</div>

        <c:if test="${not empty status}">
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header" style="background-color: #8c8c8c; color: white">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 class="modal-title center">Status</h3>
                        </div>
                        <div class="modal-body">
                            <p class="center">${status}</p>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                $(document).ready(function(){
                    $('#myModal').modal('show');
                });
            </script>
        </c:if>
        <a href="#" class="scrollToTop"></a>
    </body>
</html>