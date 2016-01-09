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
                    <div class="tables">
                        <div class="bs-example widget-shadow" data-example-id="contextual-table"> 
                            <h4 align="center">Recent Allocations</h4>
                            <table class="table"> <thead> <tr> <th>#</th> <th>Date</th> <th>Resource Name</th> <th>Reserved By</th> </tr> </thead> <tbody> <tr> <th scope="row">1</th> <td>Column content</td> <td>Column content</td> <td>Column content</td> </tr> <tr> <th scope="row">2</th> <td>Column content</td> <td>Column content</td> <td>Column content</td> </tr> </tbody> </table> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %> 
    </body>
</html>