<%-- 
    Document   : nav_bar
    Created on : 13-Dec-2015, 21:30:57
    Author     : Anuradha Sanjeewa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessionVar = request.getSession();
%>
<div class="well" style="margin: 10px;">
    <h1 class="text-center">UOM - RMS</h1>           
    <div class="">
        <ul class="nav nav-tabs">
            <li class=""><a href="/uomrms/user">Resource Lookup</a></li>
            <li><a href="#">View resources</a></li>
                <%
                    if (sessionVar.getAttribute("logged") == "admin") {
                %>
            <li><a href="/uomrms/user/res_mod.jsp">Add/Remove or Update resource</a></li>
            <li><a href="/uomrms/user/sche_mgr_mod.jsp">Add/Remove manager</a></li>
                <%
                    }
                    if (sessionVar.getAttribute("logged") == "mgr") {
                %>
            <li><a href="/uomrms/user/req_handle.jsp">Accept/reject requests</a></li>
                <%
                    }
                %>
            <li class="dropdown <%%>">
                <a class="dropdown-toggle <%%>" data-toggle="dropdown" href="#">My Account
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <%
                        if (sessionVar.getAttribute("logged") != null) {
                    %>
                    <li><a href="#">Update Details</a></li>
                    <li><a href="/uomrms/user/logout.jsp">Sign out</a></li>
                        <%
                        } else {
                        %>
                    <li><a href="/uomrms/?login">Sign in</a></li>   
                        <%
                            }
                        %>
                </ul>
            </li>
        </ul>
    </div>
</div>
