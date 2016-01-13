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
                    <div class="col-md-8 forms">
                        <h3 class="title1">Add New Resource</h3>
                        <div class="form-three widget-shadow">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="focusedinput" class="col-sm-3 control-label">Resource Name</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control1" id="focusedinput" placeholder="Resource Name" name="resource_name">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
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
                            <!--//end-search-box-->
                        </div>
                    </div>
                    <!--Filter pane end-->
                </div>
            </div>
            <!-- main content end-->
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>