<%-- 
    Document   : details
    Created on : 16-Dec-2015, 10:55:02
    Author     : Anuradha Sanjeewa
--%>

<%@page import="model.foundation.Department"%>
<%@page import="model.foundation.Hall"%>
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
                    <p class="text-center">Resource, Hall added successfully.</p>
                </div>
                <%
                    }
                    if (request.getParameter("submit") != null) {
                        Hall v = new Hall();
                        v.setCapacityAmount(Integer.parseInt(request.getParameter("cap")));
                        v.setDescription(request.getParameter("desc"));
                        v.setCategory("Hall");
                        v.setResourceName(request.getParameter("name"));
                        v.setResourceid(String.valueOf(System.currentTimeMillis() % 100000000));
                        v.setAirConditioned(request.getParameter("fac").equals("Yes") ? true : false);
                        v.setProjectorAvailable(request.getParameter("pro").equals("Yes") ? true : false);
                        v.setBoardType(request.getParameter("boardtype"));
                        Department d = new Department();
                        d.setDeptName(request.getParameter("building").split("[,]")[0]);
                        d.setBuilding(request.getParameter("building").split("[,]")[1]);
                        v.setDepartment(d);
                        DBInsertDeleteHandler dbh = new DBInsertDeleteHandler();
                        dbh.insertHall(v);
                        response.sendRedirect("add-hall.jsp?success");
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
                        <label class="control-label col-sm-4">Building: </label>
                        <div class="col-sm-4">
                            <select name="building" class="form-control">
                                <option value="CSE,Sumanadasa">CSE | Sumanadasa</option>
                                <option value="Tronic,ENTC">ENTC</option>
                                <option value="Mechanical,New Building">New Building</option>
                            </select>
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
                        <label class="control-label col-sm-4">Projector availablity: </label>
                        <div class="col-sm-4">
                            <select name="pro" class="form-control">
                                <option value="Yes">Yes</option>
                                <option value="No">No</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">Board type: </label>
                        <div class="col-sm-4">
                            <select name="boardtype" class="form-control">
                                <option value="Black board">Black board</option>
                                <option value="While Board">While Board</option>
                                <option value="Both">Both</option>
                                <option value="N/A">N/A</option>
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
