<%-- 
    Document   : update
    Created on : Jan 19, 2016, 5:49:19 PM
    Author     : Anuradha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AuthorizedPerson p_update = new AuthorizedPerson();
    p_update.setUsername((String) request.getSession(false).getAttribute("username"));
    Person person_update = (new DBPrivilegeUserHandler()).getLoggedPerson(p_update);
%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>UoM RMS</title>
        <jsp:include page="../common_imports.jsp" />      


    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <%@include file="../header.jsp" %>
            <%@include file="../side_naviagation.jsp" %>
            <!-- main content start-->
            <div id="page-wrapper">
                <div class="main-page compose">
                    <!--Resources start-->
                    <div class="col-md-9" style="padding-right: 25px;">  
                        <div id="resources">
                            <div class="media"> 
                                <div class="bs-example5"> 
                                    <div> 
                                        <div class="media-left"> 
                                            <!--<a href="#"> <img alt="64x64" src="data:image/svg+xml;base64,<% //out.print(Algorithm.ImageEncoder.getImageStringRaw(null));%>" data-holder-rendered="true" style="width: 128px; height: 128;"> </a>--> 
                                        </div> 
                                        <div class="media-body">
                                            <h2 class="media-heading">Personal Profile</h2>
                                            <hr>
                                            <img class="img-thumbnail" src="data:image/jpeg;base64,<% out.print(Algorithm.ImageEncoder.getImageStringRaw(person_update.getImage())); %>">
                                            <hr>
                                            <form class="form-horizontal" action="/uomrms/update_details">
                                                <fieldset>
                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="fname">First name</label>  
                                                        <div class="col-md-4">
                                                            <input id="fname" name="fname" type="text" placeholder="First name" class="form-control input-md" value="<% out.print(person_update.getFirstName()); %>">

                                                        </div>
                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="mname">Middle name</label>  
                                                        <div class="col-md-4">
                                                            <input id="mname" name="mname" type="text" placeholder="Middle name" class="form-control input-md" value="<% out.print(person_update.getMiddleName()); %>">

                                                        </div>
                                                    </div>

                                                    <!-- Text input-->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="lname">Last name</label>  
                                                        <div class="col-md-4">
                                                            <input id="lname" name="lname" type="text" placeholder="Last name" class="form-control input-md" value="<% out.print(person_update.getLastName()); %>">

                                                        </div>
                                                    </div>

<!--                                                     Password input
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="password">Password</label>
                                                        <div class="col-md-4">
                                                            <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">

                                                        </div>
                                                    </div>-->


                                                    <!-- Button -->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="submit">Update</label>
                                                        <div class="col-md-4">
                                                            <button id="submit" name="submit" class="btn btn-primary">Update</button>
                                                        </div>
                                                    </div>
                                                </fieldset>
                                            </form>
                                            <hr>
                                            <form class="form-horizontal" action="/uomrms/update_image" method="post" enctype="multipart/form-data">
                                                <fieldset>

                                                    <!-- File Button --> 
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="filebutton">File </label>
                                                        <div class="col-md-4">
                                                            <input id="filebutton" name="filebutton" class="input-file" type="file" accept="image/*" required>
                                                        </div>
                                                    </div>

                                                    <!-- Button -->
                                                    <div class="form-group">
                                                        <label class="col-md-4 control-label" for="submit">Update</label>
                                                        <div class="col-md-4">
                                                            <button id="submit" name="submit" class="btn btn-primary">Update</button>
                                                        </div>
                                                    </div>

                                                </fieldset>
                                            </form>
                                        </div>                                        
                                    </div> 
                                </div> 
                            </div>
                        </div>
                    </div>
                    <!--Resources end-->
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
                    <!--Filter pane end-->
                </div>
                <div class="clearfix"> </div>	
            </div>
        </div>
        <%@include file="../footer.jsp" %>
        <%@page import="model.foundation.ResourceView"%>
        <%@page import="com.google.gson.Gson" %>

    </body>
</html>