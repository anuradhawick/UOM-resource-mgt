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
                                <form id='add_manager_form' action='/uomrms/add_manager' class='form-horizontal panel-default'>
                                    <%
                                        if (request.getParameter("success") != null && request.getParameter("success").equals("true")) { %>
                                    <div class="alert alert-success" role="alert">
                                        Manager added successfully. 
                                    </div>
                                    <% } else if (request.getParameter("success") != null && request.getParameter("success").equals("false")) { %>
                                    <div class="alert alert-danger" role="alert">
                                        Invalid username.
                                    </div>
                                    <% }%>
                                    <div class='form-group'>
                                        <label for='focusedinput' class='col-sm-3 control-label'>User name</label> 
                                        <div class='col-sm-9'>
                                            <input type='text' class='form-control1' id='focusedinput' placeholder='Type an existing user name' name='username'>
                                        </div>
                                    </div>
                                    <br> 
                                    <div class='form-group'> 
                                        <div class='col-sm-4 col-sm-offset-4'> 
                                            <button class='btn btn-default form-control1' type='submit'>Add manager</button> 
                                        </div> 
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
    </body>
</html>