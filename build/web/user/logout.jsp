<%-- 
    Document   : logout
    Created on : 16-Dec-2015, 13:21:09
    Author     : Anuradha Sanjeewa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession s = request.getSession();
    s.removeAttribute("logged");
    response.sendRedirect("/uomrms/user/");
%>

