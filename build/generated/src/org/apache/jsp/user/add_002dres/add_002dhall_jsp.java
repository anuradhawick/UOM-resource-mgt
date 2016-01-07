package org.apache.jsp.user.add_002dres;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.foundation.Department;
import model.foundation.Hall;
import data.DBInsertDeleteHandler;
import model.foundation.Vehicle;

public final class add_002dhall_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/common_components/header.jsp");
    _jspx_dependants.add("/common_components/nav_bar.jsp");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");



      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
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
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession sessionVar = request.getSession();

      out.write("\n");
      out.write("<div class=\"well\" style=\"margin: 10px;\">\n");
      out.write("    <h1 class=\"text-center\">UOM - RMS</h1>           \n");
      out.write("    <div class=\"\">\n");
      out.write("        <ul class=\"nav nav-tabs\">\n");
      out.write("            <li class=\"\"><a href=\"/uomrms/user\">Resource Lookup</a></li>\n");
      out.write("            <li><a href=\"#\">View resources</a></li>\n");
      out.write("                ");

                    if (sessionVar.getAttribute("logged") == "admin") {
                
      out.write("\n");
      out.write("            <li><a href=\"/uomrms/user/res_mod.jsp\">Add/Remove or Update resource</a></li>\n");
      out.write("            <li><a href=\"/uomrms/user/sche_mgr_mod.jsp\">Add/Remove manager</a></li>\n");
      out.write("                ");

                    }
                    if (sessionVar.getAttribute("logged") == "mgr") {
                
      out.write("\n");
      out.write("            <li><a href=\"/uomrms/user/req_handle.jsp\">Accept/reject requests</a></li>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            <li class=\"dropdown ");

      out.write("\">\n");
      out.write("                <a class=\"dropdown-toggle ");

      out.write("\" data-toggle=\"dropdown\" href=\"#\">My Account\n");
      out.write("                    <span class=\"caret\"></span></a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    ");

                        if (sessionVar.getAttribute("logged") != null) {
                    
      out.write("\n");
      out.write("                    <li><a href=\"#\">Update Details</a></li>\n");
      out.write("                    <li><a href=\"/uomrms/user/logout.jsp\">Sign out</a></li>\n");
      out.write("                        ");

                        } else {
                        
      out.write("\n");
      out.write("                    <li><a href=\"/uomrms/?login\">Sign in</a></li>   \n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        <div class=\"well\" style=\"overflow: hidden; margin: 10px;\">\n");
      out.write("            <div class=\"well col-sm-8 col-sm-offset-2\">\n");
      out.write("                ");
                    if (request.getParameter("success") != null) {
                
      out.write("\n");
      out.write("                <div class=\"well\" style=\"background-color: #94F28A;\">\n");
      out.write("                    <p class=\"text-center\">Resource, Hall added successfully.</p>\n");
      out.write("                </div>\n");
      out.write("                ");
        
                    }
                    if (request.getParameter("submit") != null) {
                        Hall v = new Hall();
                        v.setCapacityAmount(Integer.parseInt(request.getParameter("cap")));
                        v.setDescription(request.getParameter("desc"));
                        v.setCategory("Hall");
                        v.setResourceName(request.getParameter("name"));
                        v.setResourceid(String.valueOf(System.currentTimeMillis()%100000000));
                        Department d=new Department();
                        d.setDeptName(request.getParameter("building").split("[,]")[0]);
                        d.setBuilding(request.getParameter("building").split("[,]")[1]);
                        v.setDepartment(d);
                        DBInsertDeleteHandler dbh = new DBInsertDeleteHandler();
                        dbh.insertHall(v);
                        response.sendRedirect("add-hall.jsp?success");
                    }
                
      out.write("\n");
      out.write("                <h4>Add resource: </h4>\n");
      out.write("                <hr>\n");
      out.write("                <form class=\"form-horizontal\">\n");
      out.write("                    <input type=\"hidden\" name=\"submit\" value=\"submit\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label col-sm-4\">Name: </label>\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <input class=\"form-control\" type=\"text\" name=\"name\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label col-sm-4\">Capacity: </label>\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <input class=\"form-control\" type=\"number\" name=\"cap\" min=\"1\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label col-sm-4\">Description: </label>\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <input class=\"form-control\" type=\"text\" name=\"desc\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label col-sm-4\">Building: </label>\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <select name=\"building\" class=\"form-control\">\n");
      out.write("                                <option value=\"CSE,Sumanadasa\">CSE | Sumanadasa</option>\n");
      out.write("                                <option value=\"Tronic,ENTC\">ENTC</option>\n");
      out.write("                                <option value=\"Mechanical,New Building\">New Building</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"col-sm-4 col-sm-offset-4\">\n");
      out.write("                            <button class=\"btn btn-default\">Add</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <hr>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
