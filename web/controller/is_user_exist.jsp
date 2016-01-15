<%-- 
    Document   : is_user_exist
    Created on : Jan 15, 2016, 11:27:21 AM
    Author     : Anuradha
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="model.foundation.AuthorizedPerson"%>
<%@page import="data.DBPrivilegeUserHandler"%>
<%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String username = request.getParameter("username");
    DBPrivilegeUserHandler dbh = new DBPrivilegeUserHandler();
    AuthorizedPerson p = new AuthorizedPerson();
    p.setUsername(username);
    Gson gson = new Gson();
    if(dbh.checkUsername(p)){
        out.print(gson.toJson(true));
    }else{
        out.print(gson.toJson(false));
    }
    
%>
