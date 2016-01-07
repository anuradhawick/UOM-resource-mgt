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
                <h4>Add scheduling manager: </h4>
                <hr>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-4">Name: </label>
                        <div class="col-sm-6">
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">Username: </label>
                        <div class="col-sm-6">
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6 col-sm-offset-4">
                            <button class="btn btn-default">Add</button>
                        </div>
                    </div>
                </form>
                <hr>
            </div>
            <div class="well col-sm-8 col-sm-offset-2">
                <h4>Remove existing manager: </h4>
                <hr>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-4">Manager username: </label>
                        <div class="col-sm-6">
                            <select class="form-control">
                                <option>1</option>
                                <option>1</option>
                                <option>1</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6 col-sm-offset-4">
                            <button class="btn btn-default">Remove</button>
                        </div>
                    </div>
                </form>
                <hr>
            </div>
        <footer class="text-center col-sm-12"><a  href="http://www.quarksis.com" style="color: gray">&copy; Quarks Industrial Solutions</a></footer>
        </div>
</body>
</html>
