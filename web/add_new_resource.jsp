<%-- 
    Document   : test
    Created on : Jan 9, 2016, 1:43:11 AM
    Author     : Dulaj
--%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>UoM RMS</title>
        <%@include file="common_imports.jsp" %>
    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <%@include file="header.jsp" %>
            <%@include file="side_naviagation.jsp" %>
            <!-- main content start-->
            <div id="page-wrapper">
                <div class="main-page compose">
                    <div class="col-md-8 widget-shadow">
                        <div class="forms">
                            <div id="form_holder" class="form-three">
                            </div>
                        </div>
                    </div>
                    <div class="clearfix col-md-1"> </div>	
                    <!--Filter pane start-->
                    <div class="col-md-3 widget-shadow" >
                        <div class="panel-body filter-pane">
                            <div class="alert alert-info">
                                Resource Category
                            </div>
                            <select id="filter_add" class="form-control1" >
                                <option value="hall" selected>Hall</option>
                                <option value="lab">Lab</option>
                                <option value="vehicle">Vehicle</option>
                                <option value="maintenance_tool">Maintenance Tool</option>
                                <option value="sports_item">Sports Item</option>
                                <option value="sports_place">Sports Place</option>
                            </select>
                            <!--//end-search-box-->
                        </div>
                    </div>
                    <!--Filter pane end-->
                </div>
                <div class="clearfix"> </div>
            </div>
            <!-- main content end-->
        </div>
        <%@include file="footer.jsp" %>

        <script>
            $(document).ready(function ( ) {
                $("#form_holder").append("<%@include file='add_resource/add_new_hall.jsp' %>");

                $("#filter_add").change(function () {

                    var selected_val = $('#filter_add').find(":selected").val();
                    if (selected_val === "hall") {
                        $("#form_holder").empty();
                        $("#form_holder").append("<%@include file='add_resource/add_new_hall.jsp' %>");
                    }
                    else if (selected_val === "lab") {
                        $("#form_holder").empty();
                        $("#form_holder").append("<%@include file='add_resource/add_new_lab.jsp' %>");
                    }
                    else if (selected_val === "vehicle") {
                        $("#form_holder").empty();
                        $("#form_holder").append("<%@include file='add_resource/add_new_vehicle.jsp' %>");
                    }
                    else if (selected_val === "maintenance_tool") {
                        $("#form_holder").empty();
                        $("#form_holder").append("<%@include file='add_resource/add_new_maintainence_tool.jsp' %>");
                    }
                    else if (selected_val === "sports_item") {
                        $("#form_holder").empty();
                        $("#form_holder").append("<%@include file='add_resource/add_new_sports_item.jsp' %>");
                    }
                    else if (selected_val === "sports_place") {
                        $("#form_holder").empty();
                        $("#form_holder").append("<%@include file='add_resource/add_new_sports_place.jsp' %>");
                    }
                });
            });
        </script>
    </body>
</html>