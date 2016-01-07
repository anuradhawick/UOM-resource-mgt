<%-- 
    Document   : details
    Created on : 16-Dec-2015, 10:55:02
    Author     : Anuradha Sanjeewa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String resId = request.getParameter("resId");
%>
<html>
    <head>
        <%@include file="/common_components/header.jsp" %>
    </head>
    <body>
        <%@include file="/common_components/nav_bar.jsp" %>
        <div class="well" style="overflow: hidden; margin: 10px;">
            <div class="well col-sm-8 col-sm-offset-2">
                <h4>Resource details: </h4>
                <hr>
                <hr>
            </div>
            <div class="well col-sm-8 col-sm-offset-2">
                <h4>Request details: </h4>
                <hr>
                <hr>
            </div>
        </div>
    </div>
</body>
</html>
