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
            <%
                AuthorizedPerson authorizedPerson = new AuthorizedPerson();
                try {
                    authorizedPerson.setUsername(session.getAttribute("username").toString());
                    String personID = new DBPrivilegeUserHandler().getLoggedPerson(authorizedPerson).getId();
                } catch (Exception e) {
                }
            %>
                    var category = localStorage.getItem("cat").toLowerCase();
                    if (category === "vehicle") {
                        $("#add_resravation_vehicle").show();
                        $('#add_resravation').hide();
                        $('#add_resravation_button').hide();
                    }
                    else {
                        $("#add_resravation_vehicle").hide();
                        $('#add_resravation').show();
                        $('#add_resravation_button').hide();
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
                    <div class="col-md-8">
                        <div class="widget-shadow" style="padding-right: 25px;">
                            <div class="bs-example5" data-example-id="default-media">
                                <div class="media">
                                    <div class="media-left col-md-3">
                                        <a href="#">
                                            <img class="media-object" data-src="holder.js/64x64" alt="128x128" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNGUwMDNiM2U3NSB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE0ZTAwM2IzZTc1Ij48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxNC41IiB5PSIzNi41Ij42NHg2NDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 128px; height: 128px;">
                                        </a>
                                    </div>
                                    <div class="media-right col-md-9" style="padding-left: 20px;">
                                        <div id="resource_heading" class="media-heading"></div><br>
                                        <button id="add_resravation_button" class="btn btn-primary">Reserve</button>
                                    </div>   
                                    <div class="clearfix"></div>
                                    <div class="media-body">
                                        <div class="tables">
                                            <div class="panel-body widget-shadow">
                                                <table class="table">
                                                    <tbody  id="resource_details">
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>	
                        </div>
                    </div>
                    <!--Add reservation start-->
                    <div id="add_resravation" class="col-md-4 widget-shadow">
                        <div class="forms">
                            <div class="form-three">
                                <form class='form-horizontal panel-default'>
                                    <div class='form-group'>
                                        <label class='col-sm-12' for='mediuminput'>Capacity/No of items</label><br><br>
                                        <div class='col-sm-12'> 
                                            <input class='form-control1' type='number' name='capacity' min='1' placeholder='Capacity' required> 
                                        </div> 
                                    </div> 
                                    <div class='form-group'>
                                        <label class='col-sm-12' for='mediuminput'>From</label><br><br>
                                        <div id="datetimepicker4" class="col-sm-6 input-append">
                                            <input class="form-control1 add-on" data-format="yyyy-MM-dd" type="text" placeholder="Date" name="from_date" required readonly>
                                        </div>
                                        <div id="datetimepicker3" class="col-sm-6 input-append">
                                            <input class="form-control1 add-on" data-format="hh:mm:ss" type="text" placeholder="Time" name="from_time" required readonly>
                                        </div>
                                    </div> 
                                    <div class='form-group'>
                                        <label class='col-sm-12' for='mediuminput'>To</label><br><br>
                                        <div id="datetimepicker6" class="col-sm-6 input-append">
                                            <input class="form-control1 add-on" data-format="yyyy-MM-dd" type="text" placeholder="Date" name="to_date" required readonly>
                                        </div>
                                        <div id="datetimepicker5" class="col-sm-6 input-append">
                                            <input class="form-control1 add-on" data-format="hh:mm:ss" type="text" placeholder="Time" name="to_time" required readonly>
                                        </div>
                                    </div> 
                                    <div class="form-group">
                                        <label class='col-sm-12' for='mediuminput'>Purpose</label><br><br> 
                                        <div class='col-sm-12'>
                                            <textarea  name='purpose' id='txtarea1' cols="50" rows='3' class='form-control1-freeheight col-sm-8' placeholder='Metion the purpose of the reservation here' required=""></textarea>
                                        </div>
                                    </div>
                                    <div class='form-group'> 
                                        <div class='col-sm-6 col-sm-offset-3'> 
                                            <button class='btn btn-primary' type='submit'>Reserve</button> 
                                        </div> 
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!--Add reservation end-->
                    <!--Add vehicle reservation start-->
                    <div id="add_resravation" class="col-md-4 widget-shadow">
                        <div class="forms">
                            <div class="form-three">
                                <form class='form-horizontal panel-default'>
                                    <div class='form-group'>
                                        <label class='col-sm-12' for='mediuminput'>Capacity/No of items</label><br><br>
                                        <div class='col-sm-12'> 
                                            <input class='form-control1' type='number' name='capacity' min='1' placeholder='Capacity' required> 
                                        </div> 
                                    </div> 
                                    <div class='form-group'>
                                        <label class='col-sm-12' for='mediuminput'>From</label><br><br>
                                        <div id="datetimepicker4" class="col-sm-6 input-append">
                                            <input class="form-control1 add-on" data-format="yyyy-MM-dd" type="text" placeholder="Date" name="from_date" required readonly>
                                        </div>
                                        <div id="datetimepicker3" class="col-sm-6 input-append">
                                            <input class="form-control1 add-on" data-format="hh:mm:ss" type="text" placeholder="Time" name="from_time" required readonly>
                                        </div>
                                    </div> 
                                    <div class='form-group'>
                                        <label class='col-sm-12' for='mediuminput'>To</label><br><br>
                                        <div id="datetimepicker6" class="col-sm-6 input-append">
                                            <input class="form-control1 add-on" data-format="yyyy-MM-dd" type="text" placeholder="Date" name="to_date" required readonly>
                                        </div>
                                        <div id="datetimepicker5" class="col-sm-6 input-append">
                                            <input class="form-control1 add-on" data-format="hh:mm:ss" type="text" placeholder="Time" name="to_time" required readonly>
                                        </div>
                                    </div> 
                                    <div class='form-group'>
                                        <label class='col-sm-12' for='mediuminput'>Starting location</label><br><br>
                                        <div class='col-sm-12'> 
                                            <input class='form-control1'  name='start' placeholder='Start' required> 
                                        </div> 
                                    </div> 
                                    <div class='form-group'>
                                        <label class='col-sm-12' for='mediuminput'>Destination</label><br><br>
                                        <div class='col-sm-12'> 
                                            <input class='form-control1' name='end' min='1' placeholder='End' required> 
                                        </div> 
                                    </div> 
                                    <div class="form-group">
                                        <label class='col-sm-12' for='mediuminput'>Purpose</label><br><br> 
                                        <div class='col-sm-12'>
                                            <textarea  name='purpose' id='txtarea1' cols="50" rows='3' class='form-control1-freeheight col-sm-8' placeholder='Metion the purpose of the reservation here' required=""></textarea>
                                        </div>
                                    </div>
                                    <div class='form-group'> 
                                        <div class='col-sm-6 col-sm-offset-3'> 
                                            <button class='btn btn-primary' type='submit'>Reserve</button> 
                                        </div> 
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!--Add vehicle reservation end-->
                </div>
                <div class="clearfix"> </div>	
            </div>
            <!-- main content end-->
        </div>
        <%@include file="footer.jsp" %>      

        <script type="text/javascript"
                src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
        </script> 
        <script type="text/javascript"
                src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
        </script>
        <script type="text/javascript"
                src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
        </script>
        <script type="text/javascript"
                src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
        </script>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker4').datetimepicker({
                    pickTime: false,
                    language: 'en',
                });
            });
        </script>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker3').datetimepicker({
                    pickDate: false,
                    language: 'en',
                    pick12HourFormat: true
                });
            });
        </script>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker6').datetimepicker({
                    pickTime: false,
                    language: 'en',
                });
            });
        </script>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker5').datetimepicker({
                    pickDate: false,
                    language: 'en',
                    pick12HourFormat: true
                });
            });
        </script>

        <script>
            $(document).ready(function () {
                $.get("get_resource?resourceid=" + localStorage.getItem("id") + "&category=" + localStorage.getItem("cat"), function (data) {
                    var cat = localStorage.getItem("cat").toLowerCase();
                    var jsonObject = $.parseJSON(data);
                    $("#resource_heading").append("<h1>" + jsonObject['resourceName'] + "</h1>");
                    if (cat === "hall") {
                        var airConditioned;
                        var projectorAvailable;
                        if (jsonObject['airConditioned']) {
                            airConditioned = "Yes";
                        }
                        else {
                            airConditioned = "No";
                        }
                        if (jsonObject['projectorAvailable']) {
                            projectorAvailable = "Yes";
                        }
                        else {
                            projectorAvailable = "No";
                        }
                        $("#resource_details").append("<tr><td>Resource Category</td><td>" + jsonObject['category'] + "</td></tr><tr><td>Capacity</td><td>" + jsonObject['capacityAmount'] + "</td></tr><tr><td>Department</td><td>" + jsonObject['department']['deptName'] + "</td></tr><tr><td>Building</td><td>" + jsonObject['department']['building'] + "</td></tr><tr><td>Air conditioned</td><td>" + airConditioned + "</td></tr><tr><td>Board Type</td><td>" + jsonObject['boardType'] + "</td></tr><tr><td>Projector availability</td><td>" + projectorAvailable + "</td></tr><tr><td>Description</td><td>" + jsonObject['description'] + "</td></tr>");
                    }
                    else if (cat === "lab") {
                        var airConditioned;
                        if (jsonObject['airConditioned']) {
                            airConditioned = "Yes";
                        }
                        else {
                            airConditioned = "No";
                        }
                        $("#resource_details").append("<tr><td>Resource Category</td><td>" + jsonObject['category'] + "</td></tr><tr><td>Capacity</td><td>" + jsonObject['capacityAmount'] + "</td></tr><tr><td>Department</td><td>" + jsonObject['department']['deptName'] + "</td></tr><tr><td>Building</td><td>" + jsonObject['department']['building'] + "</td></tr><tr><td>Air conditioned</td><td>" + airConditioned + "</td></tr><tr><td>Description</td><td>" + jsonObject['description'] + "</td></tr>");
                    }
                    else if (cat === "vehicle") {
                        var airConditioned;
                        if (jsonObject['airConditioned']) {
                            airConditioned = "Yes";
                        }
                        else {
                            airConditioned = "No";
                        }
                        $("#resource_details").append("<tr><td>Resource Category</td><td>" + jsonObject['category'] + "</td></tr><tr><td>Vehicle Type</td><td>" + jsonObject['type'] + "</td></tr><tr><td>Brand</td><td>" + jsonObject['vehicleName'] + "</td></tr><tr><td>Vehicle Number</td><td>" + jsonObject['vehicleNumber'] + "</td></tr><tr><td>Capacity</td><td>" + jsonObject['capacityAmount'] + "</td></tr><tr><td>Air conditioned</td><td>" + airConditioned + "</td></tr><tr><td>Extra facilities</td><td>" + jsonObject['facility'] + "</td></tr><tr><td>Usage</td><td>" + jsonObject['usage'] + "</td></tr><tr><td>Description</td><td>" + jsonObject['description'] + "</td></tr>");
                    }
                    else if (cat === "maintenance tool") {
                        $("#resource_details").append("<tr><td>Resource Category</td><td>" + jsonObject['category'] + "</td></tr><tr><td>Amount</td><td>" + jsonObject['capacityAmount'] + "</td></tr><tr><td>Description</td><td>" + jsonObject['description'] + "</td></tr>");
                    }
                    else if (cat === "sports item") {
                        $("#resource_details").append("<tr><td>Resource Category</td><td>" + jsonObject['category'] + "</td></tr><tr><td>Related sport</td><td>" + jsonObject['sport'] + "</td></tr><tr><td>Item code   </td><td>" + jsonObject['itemNumber'] + "</td></tr><tr><td>Amount</td><td>" + jsonObject['capacityAmount'] + "</td></tr><tr><td>Description</td><td>" + jsonObject['description'] + "</td></tr>");
                    }
                    else if (cat === "sports place") {
                        $("#resource_details").append("<tr><td>Resource Category</td><td>" + jsonObject['category'] + "</td></tr><tr><td>Location</td><td>" + jsonObject['location'] + "</td></tr><tr><td>Capacity</td><td>" + jsonObject['capacityAmount'] + "</td></tr><tr><td>Description</td><td>" + jsonObject['description'] + "</td></tr>");
                    }
                })

                //                if (cat === "hall") {
                //                    $("#requestmodal").append();
                //                }
                //                else if (cat === "lab") {
                //
                //                }
                //                else if (cat === "vehicle") {
                //
                //                }
                //                else if (cat === "maintenance tool") {
                //
                //                }
                //                else if (cat === "sports item") {
                //
                //                }
                //                else if (cat === "sports place") {
                //
                //                }
            });
        </script>

        <script>
            $(document).ready(function () {
                loadReservationPane();
            });

            $('#add_resravation_button').click(function () {
                window.location.href = "login.jsp";
            });
        </script>

    </body>
</html>