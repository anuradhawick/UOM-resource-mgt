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
                    <div class="col-md-8 compose-right widget-shadow">
                        <div class="panel-default">
                            <div class="panel-heading">
                                Compose New Message 
                            </div>
                            <div class="panel-body">
                                <% if (request.getParameter("success") != null && request.getParameter("success").equals("true")) {
                                %>
                                <pre style="color: red">Successfully sent.</pre>
                                <%
                                } else if (request.getParameter("success") != null) {
                                %>
                                <pre style="color: red">Failed please contact the administrator.</pre>
                                <%
                                    }
                                    if (request.getParameter("success") == null) {
                                %>

                                <div class="alert alert-info">
                                    Please fill details to send a new message
                                </div>
                                <%
                                    }
                                %>

                                <form class="com-mail" action="/uomrms/contact_us">
                                    <input name="name" type="text" class="form-control1 control3" placeholder="Name :" required>
                                    <input name="email" type="text" class="form-control1 control3" placeholder="Email :" required>
                                    <input name="sub" type="text" class="form-control1 control3" placeholder="Subject :" required>
                                    <textarea name="msg" rows="6" class="form-control1 control2" placeholder="Message :" required></textarea>
                                    <input type="submit" value="Send Message"> 
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>	
                </div>
            </div>
            <!-- main content end-->
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>