<%-- 
    Document   : side_naviagation
    Created on : Jan 9, 2016, 1:44:16 AM
    Author     : Dulaj
--%>

<%@page import="java.util.HashMap"%>
<%@page import="model.foundation.AuthorizedPerson"%>
<%@page import="model.foundation.Person"%>
<%@page import="data.DBPrivilegeUserHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--left-fixed -navigation-->
<div class="sidebar" role="navigation">
    <div class="navbar-collapse">
        <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
            <ul class="nav" id="side-menu">
                <%
                    String __jspName = this.getClass().getSimpleName().replaceAll("005f", "");
                    __jspName = __jspName.replaceAll("_", "");      
                    HashMap<String, Integer> priv = new HashMap();
                    if (request.getSession(false).getAttribute("username") != null) {
                        String username = (String) request.getSession(false).getAttribute("username");
                        DBPrivilegeUserHandler dbph = new DBPrivilegeUserHandler();
                        AuthorizedPerson auth = new AuthorizedPerson();
                        auth.setUsername(username);
                        priv = dbph.getPrivilegesHash(dbph.getLoggedPerson(auth));
                    }
                %>

                <li>
                    <a href="index.jsp" class="<% if (__jspName.equals("indexjsp")) {
                            out.print("active");
                        }%>"><i class="fa fa-home nav_icon"></i>All Resources</a>
                </li>
                <!--                <li>
                                    <a class="<% if (__jspName.equals("indexjsp")) {
                                            out.print("active");
                                        }%>" href="index.jsp"><i class="fa fa-check-circle nav_icon"></i>Available Resources</a>
                                </li>-->
                <li>
                    <a class="<% if (__jspName.equals("allocationsjsp")) {
                            out.print("active");
                        }%>" href="allocations.jsp"><i class="fa fa-th nav_icon"></i>Allocations</a>
                </li>
                <% if (priv.containsKey("admin")) { %>
                <li>
                    <a class="<% if (__jspName.equals("addnewresourcejsp")) {
                            out.print("active");
                        }%>" href="add_new_resource.jsp"><i class="fa fa-plus-square nav_icon"></i>Add New Resource</a>
                </li>
                <li>
                    <a class="<% if (__jspName.equals("addnewmanagerjsp")) {
                            out.print("active");
                        }%>" href="add_new_manager.jsp"><i class="fa fa-male nav_icon"></i>Add New Manager</a>
                </li>
                <% } %>
                <li>
                    <a class="<% if (__jspName.equals("contactusjsp")) {
                            out.print("active");
                        }%>" href="contact_us.jsp"><i class="fa fa-envelope nav_icon"></i>Contact Us</a>
                </li>
                <li>
                    <a class="<% if (__jspName.equals("aboutjsp")) {
                            out.print("active");
                        }%>" href=about.jsp><i class="fa fa-info-circle nav_icon"></i>About</a>
                </li>
            </ul>
            <!-- //sidebar-collapse -->
        </nav>
    </div>
</div>
<!--left-fixed -navigation-->

<!-- Classie -->
<script src="js/classie.js"></script>
<script>
    var menuLeft = document.getElementById('cbp-spmenu-s1'),
            showLeftPush = document.getElementById('showLeftPush'),
            body = document.body;

    showLeftPush.onclick = function () {
        classie.toggle(this, 'active');
        classie.toggle(body, 'cbp-spmenu-push-toright');
        classie.toggle(menuLeft, 'cbp-spmenu-open');
        disableOther('showLeftPush');
    };

    function disableOther(button) {
        if (button !== 'showLeftPush') {
            classie.toggle(showLeftPush, 'disabled');
        }
    }
</script>