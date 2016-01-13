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
                    <div class="col-md-8 widget-shadow">
                        <div class="forms">
                            <div id="form_holder" class="form-three">
                            </div>
                        </div>
                    </div>
                    <div class="clearfix col-md-1"> </div>	
                    <!--Filter pane start-->
                    <div class="col-md-3 widget-shadow" >
                        <div class="panel-body filter-pane">
                            <div class="alert alert-info">
                                Resource Category
                            </div>
                            <select id="filter_add" class="form-control1">
                                <option value="hall">Hall</option>
                                <option value="lab" selected>Lab</option>
                                <option value="car">Car</option>
                            </select>
                            <!--//end-search-box-->
                        </div>
                    </div>
                    <!--Filter pane end-->
                </div>
                <div class="clearfix"> </div>
            </div>
            <!-- main content end-->
        </div>
        <%@include file="footer.jsp" %>

        <script>
            $(document).load(function () {
                // var selected_val=$("#filter_add").val();
                $("#form_holder").append("<form id='add_hall_form' class='form-horizontal panel-default'> <div class='form-group'> <label for='focusedinput' class='col-sm-3 control-label'>Resource name</label> <div class='col-sm-9'> <input type='text' class='form-control1' id='focusedinput' placeholder='Resource Name' name='resource_name'> </div> </div> <div class='form-group'> <label class='control-label col-sm-3' for='mediuminput'>Capacity/Count</label> <div class='col-sm-9'> <input class='form-control1' type='number' name='capacity' min='1' placeholder='Capacity/Count'> </div> </div> <div class='form-group'> <label for='txtarea1' class='col-sm-3 control-label'>Description</label> <div class='col-sm-9'><textarea name='description' id='txtarea1' cols='50' rows='4' class='form-control1' placeholder='Add a short description here'></textarea></div> </div> <div class='form-group'> <label class='control-label col-sm-3'>Department</label> <div class='col-sm-9'> <select name='building' class='form-control1'> <option value='cse_sumanadasa'>ENTC</option> <option value='cse_sumanadasa'>CSE</option> </select> </div> </div> <div class='form-group'> <label class='control-label col-sm-3'>Building</label> <div class='col-sm-9'> <select name='building' class='form-control1'> <option value='cse_sumanadasa'>Sumanadasa</option> <option value='entc'>ENTC Main</option> </select> </div> </div> <div class='form-group'> <label class='control-label col-sm-3'>Air conditioned status</label> <div class='col-sm-9'> <select name='ac' class='form-control1'> <option value='Yes'>Yes</option> <option value='No'>No</option> </select> </div> </div> <div class='form-group'> <label class='control-label col-sm-3'>Projector availability</label> <div class='col-sm-9'> <select name='pro' class='form-control'> <option value='Yes'>Yes</option> <option value='No'>No</option> </select> </div> </div> <div class='form-group'> <label class='control-label col-sm-3'>Board type</label> <div class='col-sm-9'> <select name='boardtype' class='form-control'> <option value='Black board'>Black board</option> <option value='While Board'>While Board</option> <option value='Both'>Both</option> <option value='N/A'>N/A</option> </select> </div> </div> <br> <div class='form-group'> <div class='col-sm-4 col-sm-offset-4'> <button class='btn btn-default form-control1' type='submit'>Add Resource</button> </div> </div></form>");
            })
        </script>
    </body>
</html>