<%-- 
    Document   : test
    Created on : Jan 9, 2016, 1:43:11 AM
    Author     : Dulaj
--%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.util.Collection"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.util.List"%>
<%@page import="model.foundation.AuthorizedPerson"%>
<%@page import="model.foundation.Person"%>
<%@page import="data.DBPrivilegeUserHandler"%>
<%@page import="model.logic.ReservationHandler"%>
<%@page import="model.foundation.Reservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>UoM RMS</title>

        <link rel="stylesheet" type="text/css" media="screen"
              href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
        <%@include file="common_imports.jsp" %>     
        <!--<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">-->

        <script>
            var loadReservationPane = function () {
                if (<%=session.getAttribute("logged")%>) {

                    var category = localStorage.getItem("cat").toLowerCase();
                    if (category === "vehicle") {
                        $("#add_resravation_vehicle").show();
                        $('#add_resravation').hide();
                        $('#add_resravation_button').hide();
                        $('#resource_id').append("<input name='resourceid value=" + localStorage.getItem('id') + "  >");
                        $('#resource_id_vehicle').append("<input name='resourceid' value=" + localStorage.getItem('id') + " hidden>");
                    }
                    else {
                        $("#add_resravation_vehicle").hide();
                        $('#add_resravation').show();
                        $('#add_resravation_button').hide();
                        $('#resource_id').append("<input name='resourceid' value=" + localStorage.getItem('id') + " hidden>");
                    }
                }
                else {
                    $("#add_resravation_vehicle").hide();
                    $('#add_resravation').hide();
                    $('#add_resravation_button').show();
                }
            };
        </script>

    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <%@include file="header.jsp" %>
            <%@include file="side_naviagation.jsp" %>
            <div id="page-wrapper">
                <div class="main-page compose">
                    <!-- main content start-->
                    <div class="col-md-9">
                        <div class="widget-shadow" style="padding-right: 25px;">
                            <div class="bs-example5" data-example-id="default-media">
                                <div class="media">
                                    <div class="media-body">
                                        <div class="tables">
                                            <div class="panel-body widget-shadow">
                                                <table class="table">
                                                    <tbody id="reservation_details"> 
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="right-align">
                                    <a id="reject" class="btn btn-danger">Reject</a>
                                    <a id="accept" class="btn btn-primary">Approve</a>
                                </div>
                            </div>	
                        </div>
                    </div>
                </div>
                <div class="clearfix"> </div>	
            </div>
            <!-- main content end-->
        </div>
        <%@include file="footer.jsp" %>      

        <script>
            $(document).ready(function () {
                $.get("get_reservationformanager?id=" + localStorage.getItem('reservation_id'), function (data) {
                    var jsonObject = $.parseJSON(data);
                    $('#reservation_details').append("<tr><td>Resource name</td><td>" + jsonObject['PersonId'] + "</td></tr>");
                    $('#reservation_details').append("<tr><td>Reserved by</td><td>" + jsonObject['person']['firstName'] + " " + jsonObject['person']['lastName'] + "</td></tr>");
                    $('#reservation_details').append("<tr><td>From</td><td>" + jsonObject['startTime'] + "</td></tr>");
                    $('#reservation_details').append("<tr><td>To</td><td>" + jsonObject['endTime'] + "</td></tr>");
                    $('#reservation_details').append("<tr><td>Capacity/No. of items</td><td>" + jsonObject['capacity'] + "</td></tr>");
                    $('#reservation_details').append("<tr><td>Purpose</td><td>" + jsonObject['purpose'] + "</td></tr>");
                    $('#accept').attr("href", "accept_reservation?id=" + jsonObject['reserveId']);
                    $('#reject').attr("href", "reject_reservation?id=" + jsonObject['reserveId']);
                });
            });
        </script>
    </body>
</html>