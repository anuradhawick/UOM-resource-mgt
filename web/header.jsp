<%-- 
    Document   : header
    Created on : Jan 9, 2016, 1:47:53 AM
    Author     : Dulaj
--%>

<%@page import="model.foundation.Person"%>
<%@page import="data.DBPrivilegeUserHandler"%>
<%@page import="model.foundation.AuthorizedPerson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- header-starts -->
<div class="sticky-header header-section">
    <div class="header-left">
        <!--toggle button start-->
        <button id="showLeftPush"><i class="fa fa-bars"></i></button>
        <!--toggle button end-->
        <!--logo -->
        <div class="logo">
            <a href="index.html">
                <h1>UoMRMS</h1>
                <span>AdminPanel</span>
            </a>
        </div>
        <!--//logo-->
        <div class="center">
            <%
                String __jspName = this.getClass().getSimpleName().replaceAll("005f", "");
                __jspName = __jspName.replaceAll("_", "");      %>
            <h3 class="title1"><% if (__jspName.equals("indexjsp")) {
                    out.print("All Resources");
                } else if (__jspName.equals("allocationsjsp")) {
                    out.print("Allocations");
                } else if (__jspName.equals("addnewresourcejsp")) {
                    out.print("Add New Resource");
                } else if (__jspName.equals("addnewmanagerjsp")) {
                    out.print("Add New Manager");
                } else if (__jspName.equals("contactusjsp")) {
                    out.print("Contact Us");
                } else if (__jspName.equals("aboutjsp")) {
                    out.print("About");
                }%></h3>
        </div>
        <div class="clearfix"></div>
    </div>
    <script>
        $(document).ready(function () {
            var update_noti = function () {
                $("#not_area").empty();
                $.get("/uomrms/notification_generator", function (data, success) {
                    var arr = $.parseJSON(data);
                    var num_of_notifications = arr.length;
                    $(".not_count").text(num_of_notifications);
                    $("#not_area").append("<li><div class=\"notification_header\"><h3>You have <span class=\"" + num_of_notifications + "\"></span> new notification</h3></div></li>");
                    $.each(arr, function (i, item) {
//                        alert(item["notification"]);
                        $("#not_area").append("<li><a href=\"#\"><div class=\"user_img\"><img src=\"images/avatar.png\" alt=\"\"></div><div class=\"notification_desc\"><p>" + item["notification"] + "</p></div><div class=\"clearfix\"></div></a></li>");
                    });
                    $("#not_area").append("<li><div class=\"notification_bottom\"><a href=\"#\">See all notifications</a></div></li>");
                });
            }
            update_noti();
            setInterval(function(){
                update_noti();
            },5000);
//            update_noti();
        });
    </script>
    <div class="header-right">
        <div class="profile_details_left"><!--notifications of menu start -->
            <ul class="nofitications-dropdown">
                <!--                <li class="dropdown head-dpdn">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <div class="notification_header">
                                                <h3>You have 3 new messages</h3>
                                            </div>
                                        </li>
                                        <li><a href="#">
                                                <div class="user_img"><img src="images/1.png" alt=""></div>
                                                <div class="notification_desc">
                                                    <p>Lorem ipsum dolor amet</p>
                                                    <p><span>1 hour ago</span></p>
                                                </div>
                                                <div class="clearfix"></div>	
                                            </a></li>
                                        <li class="odd"><a href="#">
                                                <div class="user_img"><img src="images/2.png" alt=""></div>
                                                <div class="notification_desc">
                                                    <p>Lorem ipsum dolor amet </p>
                                                    <p><span>1 hour ago</span></p>
                                                </div>
                                                <div class="clearfix"></div>	
                                            </a></li>
                                        <li><a href="#">
                                                <div class="user_img"><img src="images/3.png" alt=""></div>
                                                <div class="notification_desc">
                                                    <p>Lorem ipsum dolor amet </p>
                                                    <p><span>1 hour ago</span></p>
                                                </div>
                                                <div class="clearfix"></div>	
                                            </a></li>
                                        <li>
                                            <div class="notification_bottom">
                                                <a href="#">See all messages</a>
                                            </div> 
                                        </li>
                                    </ul>
                                </li>-->
                <li class="dropdown head-dpdn">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue"><span class="not_count"></span></span></a>
                    <ul id="not_area" class="dropdown-menu">                        
                        <!--To be loaded from jquery-->
                    </ul>
                </li>		
            </ul>
            <div class="clearfix"> </div>
        </div>
        <!--notification menu end -->
        <div class="profile_details">		
            <ul>
                <li class="dropdown profile_details_drop">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <div class="profile_img">	
                            <span class="prfil-img"><img src="images/avatar.png" alt=""> </span> 
                            <div class="user-name">
                                <%
                                    if (request.getSession(false).getAttribute("logged") == null) {
                                %>
                                <p>Please sign in</p>
                                <% } else {
                                    AuthorizedPerson p = new AuthorizedPerson();
                                    p.setUsername((String) request.getSession(false).getAttribute("username"));
                                    DBPrivilegeUserHandler dbh = new DBPrivilegeUserHandler();
                                    Person person = dbh.getLoggedPerson(p);
                                    out.print("<p>" + person.getFirstName() + " " + person.getLastName() + "</p>");

                                %>

                                <%                                    }%>

                                <!--<span>Administrator</span>-->
                            </div>
                            <i class="fa fa-angle-down lnr"></i>
                            <i class="fa fa-angle-up lnr"></i>
                            <div class="clearfix"></div>	
                        </div>	
                    </a>
                    <ul class="dropdown-menu drp-mnu"> 
                        <%
                            if (request.getSession(false).getAttribute("logged") == null) {
                        %>
                        <li> <a href=login.jsp><i class="fa fa-sign-out"></i> Login</a> </li>
                            <% } else {
                            %>
                        <li> <a href="#"><i class="fa fa-user"></i> Profile</a> </li> 
                        <li><a href="/uomrms/logout_servlet"><i class="fa fa-sign-out"></i> Logout</a> </li>
                            <%
                                }%>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="clearfix"> </div>				
    </div>
    <div class="clearfix"> </div>	
</div>
<!-- //header-ends -->