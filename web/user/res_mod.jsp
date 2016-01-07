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
                <h4>Add resource: </h4>
                <hr>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-4">Resource type: </label>
                        <div class="col-sm-4">
                            <select class="form-control">
                                <option value="Lab">Lab</option>
                                <option value="Hall" >Hall</option>
                                <option value="Vehicle" >Vehicle</option>
                                <option value="Maintenance Tool" >Maintenance Tool</option>
                                <option value="Sport Item" >Sport Item</option>
                                <option value="Sport Place" >Sport Place</option>       
                            </select>
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
            <div class="well col-sm-8 col-sm-offset-2">
                <h4>Update details: </h4>
                <hr>
                <p>To be implemented</p>
                <hr>
            </div>
        </div>
    </div>
</body>
</html>
