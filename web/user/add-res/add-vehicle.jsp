<%-- 
    Document   : details
    Created on : 16-Dec-2015, 10:55:02
    Author     : Anuradha Sanjeewa
--%>

<%@page import="data.DBInsertDeleteHandler"%>
<%@page import="model.foundation.Vehicle"%>
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
                    <p class="text-center">Resource, Vehicle added successfully.</p>
                </div>
                <%        
                    }
                    if (request.getParameter("submit") != null) {
                        Vehicle v = new Vehicle();
                        v.setCapacityAmount(Integer.parseInt(request.getParameter("cap")));
                        v.setDescription(request.getParameter("desc"));
                        v.setCategory("Vehicle");
                        v.setFacility(request.getParameter("fac"));
                        v.setResourceName(request.getParameter("desc"));
                        v.setResourceid(String.valueOf(System.currentTimeMillis()%100000000));
                        v.setType(request.getParameter("type"));
                        v.setVehicleName(request.getParameter("name"));
                        v.setVehicleNumber(request.getParameter("numb"));
                        DBInsertDeleteHandler dbh = new DBInsertDeleteHandler();
                        dbh.insertVehicle(v);
                        response.sendRedirect("add-vehicle.jsp?success");
                    }
                %>
                <h4>Add resource: </h4>
                <hr>
                <form class="form-horizontal">
                    <input type="hidden" name="submit" value="submit">
                    <div class="form-group">
                        <label class="control-label col-sm-4">Name: </label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">Capacity: </label>
                        <div class="col-sm-4">
                            <input class="form-control" type="number" name="cap" min="1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">Description: </label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" name="desc">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">Reg number: </label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" name="numb">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">Type: </label>
                        <div class="col-sm-4">
                            <select name="type" class="form-control">
                                <option value="Car">Car</option>
                                <option value="Bus">Bus</option>
                                <option value="Van">Van</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">Model: </label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">AC/ non AC: </label>
                        <div class="col-sm-4">
                            <select name="fac" class="form-control">
                                <option value="Yes">Yes</option>
                                <option value="No">No</option>
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
        </div>
    </div>
</body>
</html>
