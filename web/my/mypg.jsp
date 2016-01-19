<%-- 
    Document   : index
    Created on : Jan 18, 2016, 6:55:02 PM
    Author     : Anuradha
--%>
<%
    String username_mypage = (String) request.getSession(false).getAttribute("username");
    DBPrivilegeUserHandler dbph_mypage = new DBPrivilegeUserHandler();
    AuthorizedPerson p_mypage = new AuthorizedPerson();
    p_mypage.setUsername(username_mypage);
    Person personp = dbph_mypage.getLoggedPerson(p_mypage);
    if(personp.getImage()==null){
        out.print("<script>alert('asdsad');</script>");
    }
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
                                            <h2 class="media-heading">Main Hall</h2>
                                            <p><b>Category: </b> Hall</p>
                                            <p><b>Capacity/Amount: </b> 1000</p>
                                            <p><b>Description: </b> This is the main hall</p>
                                        </div>
                                        <div>
                                            <button onclick="viewResource(['4', 'Hall'])" style="margin-top: 10px;" class="btn">View</button> 
                                            <button style="margin-top: 10px;" class="btn">Edit</button> </div> 
                                        <div class="clearfix"> </div>
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
                    <div class="col-md-9" style="padding-right: 25px; padding-top: 25px;">
                        <div class="widget-shadow">
                            <div id="parentmy">
                                <nav class="blockmy centermy">
                                    <ul id="pagination_div" class="pagination">
                                    </ul>
                                </nav>
                            </div>
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