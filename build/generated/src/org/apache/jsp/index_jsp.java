package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import data.DBAuthenticatorHandler;
import Authenticator.Authenticator;
import java.util.Map;
import java.lang.String;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/common_components/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    if (request.getParameter("login") == null) {
        //response.sendRedirect("user/");
    }



      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<script src=\"/uomrms/js/jquery-1.11.3.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/uomrms/css/bootstrap-3.3.6-dist/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/uomrms/css/commons.css\">\n");
      out.write("<script src=\"/uomrms/css/bootstrap-3.3.6-dist/js/bootstrap.min.js\"></script>\n");
      out.write("<title>UOM-RMS</title>");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"well\" style=\"margin: 10px;\">\r\n");
      out.write("            <h1 class=\"text-center\">UOM - RMS</h1>           \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"\" style=\"margin: 10px;\">\r\n");
      out.write("            <div class=\"well\">\r\n");
      out.write("                <hr>\r\n");
      out.write("                <!-- Login Logo -->\r\n");
      out.write("                <div>\r\n");
      out.write("                    <img class=\"img-responsive\" src=\"images/login_logo.gif\" style=\"margin: 0 auto;\" width=\"500\" height=\"500\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Login form for the first time user-->\r\n");
      out.write("                <form class=\"form-horizontal\" role=\"form\" action=\"\" method=\"POST\">\r\n");
      out.write("                    <hr>\r\n");
      out.write("                    <div class=\"form-group\">                 \r\n");
      out.write("                        <label class=\"control-label col-sm-4\" for=\"username\">Username: </label>\r\n");
      out.write("                        <div class=\"col-sm-4\">\r\n");
      out.write("                            <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">                 \r\n");
      out.write("                        <label class=\"control-label col-sm-4\" for=\"password\">Password: </label>\r\n");
      out.write("                        <div class=\"col-sm-4\">\r\n");
      out.write("                            <input type=\"text\" id=\"password\" name=\"password\" class=\"form-control\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"col-sm-4 col-sm-offset-4\">\r\n");
      out.write("                            ");
                                if (request.getParameter("login-err") != null) {
                            
      out.write("\r\n");
      out.write("                            <div class=\"well\" style=\"background-color: #F2DEDE;\">\r\n");
      out.write("                                <p class=\"text-center\">Wrong username or password, please retry again.</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");

                                }
                            
      out.write("\r\n");
      out.write("                            <button class=\"btn btn-default\">Login</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <hr>\r\n");
      out.write("                </form>\r\n");
      out.write("                ");

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
                
      out.write("\r\n");
      out.write("                <footer class=\"text-center\"><a  href=\"http://www.quarksis.com\" style=\"color: gray\">&copy; Quarks Industrial Solutions</a></footer>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
