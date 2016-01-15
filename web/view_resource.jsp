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
<!DOCTYPE HTML>
<html>
    <head>
        <title>UoM RMS</title>
        <%@include file="common_imports.jsp" %>        

        <script>
            var onReserveClick = function () {
                
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
                    <div class="media col-md-12">
                        <div class="bs-example5 widget-shadow" data-example-id="default-media">
                            <div class="media">
                                <div class="media-left col-md-2">
                                    <a href="#">
                                        <img class="media-object" data-src="holder.js/64x64" alt="128x128" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNGUwMDNiM2U3NSB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE0ZTAwM2IzZTc1Ij48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxNC41IiB5PSIzNi41Ij42NHg2NDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 128px; height: 128px;">
                                    </a>
                                </div>
                                <div class="media-right col-md-10">
                                    <div id="resource_heading" class="media-heading"></div><br>
                                    <div id="resource_heading" class="media-heading"><button type="button" class="btn btn-info" data-toggle="modal" data-whatever="@mdo" onclick="onReserveClick()">Reserve</button></div>
                                    <div class="modal fade" id="requestmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title" id="exampleModalLabel">New message</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form>
                                                        <div class="form-group">
                                                            <label for="recipient-name" class="control-label">Recipient:</label>
                                                            <input type="text" class="form-control" id="recipient-name">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="message-text" class="control-label">Message:</label>
                                                            <textarea class="form-control" id="message-text"></textarea>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary">Send message</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
                                <div class="clearfix"> </div>
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
                $.get("get_resource?resourceid=" + localStorage.getItem("id") + "&category=" + localStorage.getItem("cat"), function (data) {
                    var cat = localStorage.getItem("cat").toLowerCase();
                    var jsonObject = $.parseJSON(data);

                    $("#resource_heading").append("<h1>" + jsonObject['resourceName'] + "</h1>");

                    if (cat === "hall") {
                        var airConditioned;
                        var projectorAvailable;
                        if(jsonObject['airConditioned']){ airConditioned="Yes"; }
                        else{ airConditioned="No"; }
                        if(jsonObject['projectorAvailable']){ projectorAvailable="Yes"; }
                        else{ projectorAvailable="No"; }
                        $("#resource_details").append("<tr><td>Resource Category</td><td>" + jsonObject['category'] + "</td></tr><tr><td>Capacity</td><td>" + jsonObject['capacityAmount'] + "</td></tr><tr><td>Department</td><td>" + jsonObject['department']['deptName'] + "</td></tr><tr><td>Building</td><td>" + jsonObject['department']['building'] + "</td></tr><tr><td>Air conditioned</td><td>" + airConditioned + "</td></tr><tr><td>Board Type</td><td>" + jsonObject['boardType'] + "</td></tr><tr><td>Projector availability</td><td>" + projectorAvailable + "</td></tr><tr><td>Description</td><td>" + jsonObject['description'] + "</td></tr>");
                    }
                    else if (cat === "lab") {
                        var airConditioned;
                        if(jsonObject['airConditioned']){ airConditioned="Yes"; }
                        else{ airConditioned="No"; }
                        $("#resource_details").append("<tr><td>Resource Category</td><td>" + jsonObject['category'] + "</td></tr><tr><td>Capacity</td><td>" + jsonObject['capacityAmount'] + "</td></tr><tr><td>Department</td><td>" + jsonObject['department']['deptName'] + "</td></tr><tr><td>Building</td><td>" + jsonObject['department']['building'] + "</td></tr><tr><td>Air conditioned</td><td>" + airConditioned + "</td></tr><tr><td>Description</td><td>" + jsonObject['description'] + "</td></tr>");
                    }
                    else if (cat === "vehicle") {
                        var airConditioned;
                        if(jsonObject['airConditioned']){ airConditioned="Yes"; }
                        else{ airConditioned="No"; }
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
    </body>
</html>