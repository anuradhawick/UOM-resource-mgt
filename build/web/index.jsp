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
                            <select class="form-control1">
                                <option>Hall</option>
                                <option>Car</option>
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
                    <!--Filter pane end-->
                </div>
                <div class="clearfix"> </div>	
            </div>
        </div>
        <%@include file="footer.jsp" %>

        <script>
            $(document).ready(function () {
            //$.get("",data);
            $.get("", function (data) {
            for (var i = 0; i < 10; i++){
            $("#resources").append("<div class=\"media\"> <div class=\"bs-example5\"> <div> <div class=\"media-left\"> <a href=\"#\"> <img alt=\"64x64\" src=\"data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNGUwMDNiM2U3NSB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE0ZTAwM2IzZTc1Ij48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxNC41IiB5PSIzNi41Ij42NHg2NDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==\" data-holder-rendered=\"true\" style=\"width: 128px; height: 128;\"> </a> </div> <div class=\"media-body\"> <h2 class=\"media-heading\">Resource Name 1</h2> <p><b>Resource ID: </b> 100001</p> <p><b>Category: </b> Hall</p> <p><b>Capacity/Amount: </b> 125</p> <p><b>Description: </b> Seminal room is the biggest hall of COmputer Science and Engineering Department. It is full air conditioned. One projector and a white board is available.</p> </div> <div> <button class=\"btn\">Request</button> <button class=\"btn\">Edit</button> </div> <div class=\"clearfix\"> </div> </div> </div> </div>");
            }
            });
            });
        </script>
    </body>
</html>