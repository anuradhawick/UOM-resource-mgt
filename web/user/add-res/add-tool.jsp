<%-- 
    Document   : details
    Created on : 16-Dec-2015, 10:55:02
    Author     : Anuradha Sanjeewa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

%>
<html>
    <head>
        <%@include file="/common_components/header.jsp" %>
    </head>
    <body>
        <%@include file="/common_components/nav_bar.jsp" %>
        <div class="well" style="overflow: hidden; margin: 10px;">
            <div class="well col-sm-8 col-sm-offset-2">
                <%                    if (request.getParameter("success") != null) {
                %>
                <div class="well" style="background-color: #94F28A;">
                    <p class="text-center">Resource, Maintenance tool added successfully.</p>
                </div>
                <%
                    }
                %>
                <h4>Add resource: </h4>
                <hr>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-4">Resource name: </label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-4">
                            <button class="btn btn-default">Add</button>
                        </div>
                    </div>
                </form>
                <hr>
            </div>
        </div>
    </div>
</body>
</html>
