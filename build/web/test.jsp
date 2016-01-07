<%-- 
    Document   : test.jsp
    Created on : 16-Dec-2015, 08:53:49
    Author     : Anuradha Sanjeewa
--%>

<%@page import="java.util.List"%>
<%@page import="data.DBSearchHandler"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="data.DBAuthenticatorHandler"%>
<%@page import="Authenticator.Authenticator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <p>
            <%
//                Authenticator a = new Authenticator("admin", "admin");
//                DBAuthenticatorHandler db = new DBAuthenticatorHandler();
//                out.print(db.login(a));
//                
//                MessageDigest md = MessageDigest.getInstance("SHA-256");
//                md.update(("admin").getBytes());
//                byte[] mdbytes = md.digest();
//
//                //convert the byte to hex format method 1
//                StringBuffer sb = new StringBuffer();
//                for (int i = 0; i < mdbytes.length; i++) {
//                    sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
//                }
//
//                out.println("Hex format : " + sb.toString());

                DBSearchHandler dsh = new DBSearchHandler();
                List<Object> result = dsh.SearchKeyword("Lab");
                out.print(result.get(0));

            %>
        </p>
    </body>
</html>
