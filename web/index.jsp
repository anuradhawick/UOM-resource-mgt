<%-- 
    Document   : index
    Created on : 13-Dec-2015, 19:05:38
    Author     : Anuradha Sanjeewa
--%>
<%@page import="data.DBAuthenticatorHandler"%>
<%@page import="Authenticator.Authenticator"%>
<%@page import="java.util.Map"%>
<%@page import="java.lang.String"%>
<%
    if (request.getParameter("login") == null) {
        //response.sendRedirect("user/");
    }


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/common_components/header.jsp" %>
    </head>
    <body>
        <div class="well" style="margin: 10px;">
            <h1 class="text-center">UOM - RMS</h1>           
        </div>
        <div class="" style="margin: 10px;">
            <div class="well">
                <hr>
                <!-- Login Logo -->
                <div>
                    <img class="img-responsive" src="images/login_logo.gif" style="margin: 0 auto;" width="500" height="500">
                </div>
                <!-- Login form for the first time user-->
                <form class="form-horizontal" role="form" action="" method="POST">
                    <hr>
                    <div class="form-group">                 
                        <label class="control-label col-sm-4" for="username">Username: </label>
                        <div class="col-sm-4">
                            <input type="text" id="username" name="username" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">                 
                        <label class="control-label col-sm-4" for="password">Password: </label>
                        <div class="col-sm-4">
                            <input type="text" id="password" name="password" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-4">
                            <%                                if (request.getParameter("login-err") != null) {
                            %>
                            <div class="well" style="background-color: #F2DEDE;">
                                <p class="text-center">Wrong username or password, please retry again.</p>
                            </div>
                            <%
                                }
                            %>
                            <button class="btn btn-default">Login</button>
                        </div>
                    </div>
                    <hr>
                </form>
                <%
                    if (request.getParameter("username") != null && request.getParameter("password") != null) {
                        Authenticator a = new Authenticator(request.getParameter("username"), request.getParameter("password"));
                        DBAuthenticatorHandler db = new DBAuthenticatorHandler();
                        boolean success = db.login(a);
                        if (!success) {
                            response.sendRedirect("?login-err");
                        } else {
                            response.sendRedirect("user/");
                            HttpSession s = request.getSession(true);
                            s.setAttribute("logged", "true");
                        }
                    }
                %>
                <footer class="text-center"><a  href="http://www.quarksis.com" style="color: gray">&copy; Quarks Industrial Solutions</a></footer>
            </div>
        </div>
    </body>
</html>