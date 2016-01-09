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
                                <div class="alert alert-info">
                                    Please fill details to send a new message
                                </div>
                                <form class="com-mail">
                                    <input type="text" class="form-control1 control3" placeholder="To :">
                                    <input type="text" class="form-control1 control3" placeholder="Subject :">
                                    <textarea rows="6" class="form-control1 control2" placeholder="Message :" ></textarea>
                                    <input type="submit" value="Send Message"> 
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>	
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>