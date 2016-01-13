<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
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
                <div class="main-page login-page ">
                    <div class="widget-shadow">
                        <div class="login-top">
                            <h4>Welcome to UoM RMS ! <br> Not a Member? <a href="signup.jsp">  Sign Up</a> </h4>
                        </div>
                        <div class="login-body">
                            <form action="/uomrms/login_servelet" method="POST">
                                <input type="text" class="user" name="username" placeholder="Enter your NIC" required="">
                                <input type="password" name="password" class="lock" placeholder="password">
                                <% if(request.getParameter("fail")!=null){
                                    %>
                                    <pre style="color: red;">Username or password is incorrect.</pre>
                                            <%
                                
} %>
                                <input type="submit" name="Sign In" value="Sign In">
                                <div class="forgot-grid">
                                    <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Remember me</label>
                                    <div class="forgot">
                                        <a href="#">forgot password?</a>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>