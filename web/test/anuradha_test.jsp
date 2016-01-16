
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Impl.DBConnectorDash"%>
<%@page import="data.DBConnector"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>

<%
    String UPLOAD_DIRECTORY = "C:/res_mgt/";
    if (ServletFileUpload.isMultipartContent(request)) {
        try {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : multiparts) {
                if (!item.isFormField()) {
                    InputStream img = item.getInputStream();
                    Connection connection = null;
                    connection = DBConnectorDash.connect();
                    PreparedStatement stmt = connection.prepareStatement("INSERT INTO `file` (`filecol`) values(?)");
                    stmt.setBinaryStream(1, img);
                    stmt.execute();
                    out.println("asdasdad");
                    stmt = connection.prepareStatement("SELECT `filecol` FROM `file`");
                    ResultSet ss = stmt.executeQuery();
                    while (ss.next()) {

                        InputStream d = ss.getBinaryStream("filecol");
                        byte[] barr = IOUtils.toByteArray(d);
                        Base64.Encoder en = Base64.getEncoder();
                        String theString = en.encodeToString(barr);
                        //item.write(f);

                        out.println("<img alt=\"64x64\" src=\"data:image/jpeg;base64," + theString + "\" data-holder-rendered=\"true\" style=\"width: 128px; height: 128;\">");
                    }
                    
                    stmt.execute();
                    stmt.close();
                    connection.close();
                }
            }
            //File uploaded successfully
        } catch (Exception ex) {
            out.println("Fail<br>" + ex.getMessage());
            ex.printStackTrace();
        }
    } else {

    }

%>