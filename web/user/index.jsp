<%-- 
    Document   : indec
    Created on : 13-Dec-2015, 22:59:38
    Author     : Anuradha Sanjeewa
--%>

<%@page import="model.foundation.Lab"%>
<%@page import="model.foundation.Vehicle"%>
<%@page import="model.foundation.MaintenanceTool"%>
<%@page import="model.foundation.SportItem"%>
<%@page import="model.foundation.SportPlace"%>
<%@page import="model.foundation.Hall"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.DBSearchHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/common_components/header.jsp" %>
    <body>
        <%@include file="/common_components/nav_bar.jsp" %>
        <div style="margin: 10px;">
            <div class="well" style="overflow: hidden;">
                <div class="well col-sm-8 col-sm-offset-2">
                    <form class="form-horizontal">
                        <input type="hidden" name="type" value="cat">
                        <div class="form-group">
                            <label class="control-label col-lg-4">Please select the resource type: </label>
                            <div class="col-sm-8">
                                <select name="cat" class="form-control">
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
                            <div class="col-sm-8 col-sm-offset-4">
                                <button class="btn btn-default">Search</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="well col-sm-8 col-sm-offset-2">
                    <form class="form-horizontal">
                        <input type="hidden" name="type" value="key">
                        <div class="form-group">
                            <label class="control-label col-lg-4">Please type a keyword: </label>
                            <div class="col-sm-8">
                                <input class="form-control" name="key" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-4">
                                <button class="btn btn-default">Search</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="well col-sm-8 col-sm-offset-2">
                    <h4>Search results: </h4>
                    <hr>
                    <div class="well">
                        <%                            String cat, key;
                            if (request.getParameter("type") != null) {
                                switch (request.getParameter("type")) {
                                    case "key":
                                        key = request.getParameter("key");
                                        break;
                                    case "cat":
                                        cat = request.getParameter("cat");
                                        DBSearchHandler dsh = new DBSearchHandler();
                                        List<Object> result = dsh.SearchKeyword(cat);
                                        if (result == null) {
                                            return;
                                        }
                                        for (Object o : result) {
                                            if (o instanceof SportPlace) {
                                                SportPlace sp = (SportPlace) o;
                        %>
                        <blockquote>
                            <p>Resource Name: <% out.print(sp.getResourceName()); %></p>
                            <p>Capacity: <% out.print(sp.getCapacityAmount()); %></p>
                            <p>Location: <% out.print(sp.getLocation()); %></p>
                            <p>Description: <% out.print(sp.getDescription()); %></p>
                        </blockquote>
                        <%
                        } else if (o instanceof SportItem) {
                            SportItem spi = (SportItem) o;
                        %>
                        <blockquote>
                            <p>Resource Name: <% out.print(spi.getResourceName()); %></p>
                            <p>Capacity: <% out.print(spi.getCapacityAmount()); %></p>
                            <p>Sport: <% out.print(spi.getSport()); %></p>
                            <p>Item Number: <% out.print(spi.getItemNumber()); %></p>
                            <p>Description: <% out.print(spi.getDescription()); %></p>
                        </blockquote>
                        <%
                        } else if (o instanceof MaintenanceTool) {
                            MaintenanceTool mt = (MaintenanceTool) o;
                        %>
                        <blockquote>
                            <p>Resource Name: <% out.print(mt.getResourceName()); %></p>
                            <p>Capacity: <% out.print(mt.getCapacityAmount()); %></p>
                            <p>Usage: <% out.print(mt.getUsage()); %></p>
                            <p>Description: <% out.print(mt.getDescription()); %></p>
                        </blockquote>
                        <%
                        } else if (o instanceof Vehicle) {
                            Vehicle v = (Vehicle) o;
                        %>
                        <blockquote>
                            <p>Vehicle Type: <% out.print(v.getType()); %></p>
                            <p>Resource Name: <% out.print(v.getResourceName()); %></p>
                            <p>Capacity: <% out.print(v.getCapacityAmount()); %></p>
                            <p>Vehicle Number: <% out.print(v.getVehicleNumber()); %></p>
                            <p>Vehicle Name: <% out.print(v.getVehicleName()); %></p>
                            <p>Facility: <% out.print(v.getFacility()); %></p>
                            <p>Description: <% out.print(v.getDescription()); %></p>
                        </blockquote>
                        <%
                        } else if (o instanceof Hall) {
                            Hall h = (Hall) o;
                        %>
                        <blockquote>
                            <p>Resource Name: <% out.print(h.getResourceName()); %></p>
                            <p>Capacity: <% out.print(h.getCapacityAmount()); %></p>
                            <p>Department: <% out.print(h.getDepartment().getDeptName()); %></p>
                            <p>Building: <% out.print(h.getDepartment().getBuilding()); %></p>
                            <p>Projetor Availability: <% out.print(h.isProjectorAvailable() ? "yes" : "No"); %></p>
                            <p>AC Availability: <% out.print(h.isAirConditioned() ? "yes" : "No"); %></p>
                            <p>Board type: <% out.print(h.getBoardType()); %></p>
                            <p>Description: <% out.print(h.getDescription()); %></p>
                        </blockquote>
                        <%
                        } else {
                            Lab lb = (Lab) o;
                        %>
                        <blockquote>
                            <p>Resource Name: <% out.print(lb.getResourceName()); %></p>
                            <p>Capacity: <% out.print(lb.getCapacityAmount()); %></p>
                            <p>Department: <% out.print(lb.getDepartment().getDeptName()); %></p>
                            <p>Building: <% out.print(lb.getDepartment().getBuilding()); %></p>
                            <p>AC Availability: <% out.print(lb.isAirConditioned() ? "Yes" : "No"); %></p>
                            <p>Description: <% out.print(lb.getDescription()); %></p>
                        </blockquote>
                        <%
                                            }
                                        }
                                        break;
                                }
                            }
                        %>
                    </div>
                    <hr>
                </div>
                <footer class="text-center col-sm-12"><a  href="http://www.quarksis.com" style="color: gray">&copy; Quarks Industrial Solutions</a></footer>
            </div>
        </div>
    </body>
</html>
