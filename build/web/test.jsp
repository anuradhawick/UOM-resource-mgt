<%-- 
    Document   : test
    Created on : Jan 9, 2016, 1:43:11 AM
    Author     : Dulaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <button onclick="viewResource(['One','Two'])">Test button</button>
        
        <script>
            var viewResource=function (para){
                alert(para[0]);
            };
        </script>
    </body>
</html>
