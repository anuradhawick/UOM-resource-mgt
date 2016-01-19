<%-- 
    Document   : notification_modal
    Created on : Jan 18, 2016, 3:05:29 PM
    Author     : Anuradha
--%>

<%@page import="model.foundation.Resource"%>
<%@page import="data.DBSearchHandler"%>
<%@page import="model.foundation.Reservation"%>
<%@page import="data.DBReservationHandler"%>
<%@page import="model.foundation.Notification"%>
<%@page import="data.DBNotificationHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Modal -->
<%
    int not_id = Integer.parseInt(request.getParameter("id"));
    DBNotificationHandler dbh = new DBNotificationHandler();
    Notification n = dbh.getNotificationById(not_id);
    DBReservationHandler dbrh = new DBReservationHandler();
    Reservation r = dbrh.getReservstionByID(n.getReservationid());
    DBSearchHandler s = new DBSearchHandler();
    Resource res = s.getResourceById(r.getResourceId());
    dbh.markNotifRead(n);
%>
<div id="notification_modal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Notification <% out.print(n.getNotification());%></h4>
            </div>
            <div class="modal-body">
                <p>Reservation details</p>
                <hr>
                <div class="table-responsive">
                    <table  class="table table-striped col-sm-12">                    
                        <tr>
                            <td>Resource id</td>
                            <td><% out.print(r.getResourceId()); %></td>
                        </tr>
                        <tr>
                            <td>Resource name</td>
                            <td><% out.print(res.getResourceName()); %></td>
                        </tr>
                        <tr>
                            <td>Resource category</td>
                            <td><% out.print(res.getCategory()); %></td>
                        </tr>
                        <tr>
                            <td>Resource description</td>
                            <td><% out.print(res.getDescription()); %></td>
                        </tr>
                        <tr>
                            <td>Purpose</td>
                            <td><% out.print(r.getPurpose());%></td>
                        </tr>
                        <tr>
                            <td>Purpose</td>
                            <td><%
                                switch (r.getApproval()) {
                                    case 0:
                                        out.print("Pending");
                                        break;
                                    case 1:
                                        out.print("Accepted");
                                        break;
                                    case 2:
                                        out.print("Rejected");
                                        break;
                                }
                                %></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
