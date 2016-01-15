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
            var loadResourcePage = function (args) {
                $.get("SearchAll?start=" + args[0] + "&end=" + args[1], function (data) {
                    var jsonArray = $.parseJSON(data);
                    $("#resources").empty();
                    for (var i = 0; i < jsonArray.length; i++) {
                        var jsonObject = jsonArray[i];
                        var resource_id = jsonObject['resourceid'];
                        var resource_name = jsonObject['resourceName'];
                        var category = jsonObject['category'];
                        var capacityAmount = jsonObject['capacityAmount'];
                        var description = jsonObject['description'];
                        $("#resources").append("<div class=\"media\"> <div class=\"bs-example5\"> <div> <div class=\"media-left\"> <a href=\"#\"> <img alt=\"64x64\" src=\"data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNGUwMDNiM2U3NSB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE0ZTAwM2IzZTc1Ij48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxNC41IiB5PSIzNi41Ij42NHg2NDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==\" data-holder-rendered=\"true\" style=\"width: 128px; height: 128;\"> </a> </div> <div class=\"media-body\"> <h2 class=\"media-heading\">" + resource_name + "</h2><p><b>Category: </b> " + category + "</p> <p><b>Capacity/Amount: </b> " + capacityAmount + "</p> <p><b>Description: </b> " + description + "</p> </div> <div> <button onclick=\"viewResource(['" + resource_id + "','" + category + "'])\" style=\"margin-top: 10px;\" class=\"btn\">View</button> <button style=\"margin-top: 10px;\" class=\"btn\">Edit</button> </div> <div class=\"clearfix\"> </div> </div> </div> </div>");
                        setPagination(args[0] / 5 + 1);
                    }
                })
            };

            var setPagination = function (currentPageNo) {
            <%@page import="model.logic.ResourceHandler"%>
            <% ResourceHandler resourceHandler = new ResourceHandler();
                int noPages = resourceHandler.getResourceCount();
                if(noPages%5==0){ noPages/=5; }
                else{noPages=noPages/5+1;} %>

                $("#pagination_div").empty();
                for(var i=0;i<<%=noPages %>;i++){
                    if(currentPageNo==(i+1)){
                        $("#pagination_div").append("<li class='active'><a onClick=\"loadResourcePage(["+ i*5 + ',' + 5 +"])\">"+(i+1)+"</a></li>");
                    }
                    else{
                        $("#pagination_div").append("<li><a onClick=\"loadResourcePage(["+ i*5 + ',' + 5 +"])\">"+(i+1)+"</a></li>");
                    }
                }
            };

            $(document).ready(function () {
                loadResourcePage([0, 5]);
                
                $("#filer_resource").change(function () {
                    var selected_val = $('#filer_resource').find(":selected").val();
                    alert(selected_val);
                });
            });
        </script>
    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <%@include file="header.jsp" %>
            <%@include file="side_naviagation.jsp" %>
            <!-- main content start-->
            <div id="page-wrapper">
                <div class="main-page compose">
                    <!--Resources start-->
                    <div id="resources" class="col-md-8">
                    </div>
                    <!--Resources end-->
                    <div class="col-md-1 clearfix"></div>
                    <!--Filter pane start-->
                    <div class="col-md-3 widget-shadow" >
                        <div class="panel-body filter-pane">
                            <div class="alert alert-info">
                                Resource Category
                            </div>
                            <select id="filer_resource" class="form-control1">
                                <option value="">-- Select a category</option>
                                <option value="hall">Hall</option>
                                <option value="lab">Lab</option>
                                <option value="vehicle">Vehicle</option>
                                <option value="maintenance_tool">Maintenance Tool</option>
                                <option value="sports_item">Sports Item</option>
                                <option value="sports_place">Sport Place</option>
                            </select>
                            <br><br>
                            <div class="alert alert-info">
                                Search Resource
                            </div>
                            <!--search-box-->
                            <div>
                                <input class="sb-search-input input__field--madoka" placeholder="Search..." type="search" id="input-31" />
                            </div>
                            <!--//end-search-box-->
                        </div>
                    </div>
                    <div class="grid_3 grid_5 widget-shadow col-md-8">
                        <div id="parentmy" class="col-md-6">
                            <nav class="blockmy centermy">
                                <ul id="pagination_div" class="pagination">
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <!--Filter pane end-->
                </div>
                <div class="clearfix"> </div>	
            </div>
        </div>
        <%@include file="footer.jsp" %>
        <%@page import="model.foundation.ResourceView"%>
        <%@page import="com.google.gson.Gson" %>
        <script>
            var viewResource = function (args) {
                localStorage.setItem("id", args[0]);
                localStorage.setItem("cat", args[1]);
                location.href = "view_resource.jsp";
            };
        </script>
    </body>
</html>