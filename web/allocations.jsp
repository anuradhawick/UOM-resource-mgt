<%-- 
    Document   : test
    Created on : Jan 9, 2016, 1:43:11 AM
    Author     : Dulaj
--%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>UoM RMS</title>

        <link rel="stylesheet" type="text/css" media="screen"
              href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">

        <%@include file="common_imports.jsp" %>
    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <%@include file="header.jsp" %>
            <%@include file="side_naviagation.jsp" %>
            <!-- main content start-->
            <div id="page-wrapper">
                <div class="main-page compose">
                    <div class="col-md-12 widget-shadow" style="padding: 15px;">
                        <div class="col-md-3"><label>From</label><br><br></div>
                        <div class="col-md-3">
                            <div id="datetimepicker4" class="input-append">
                                <input class="form-control1 add-on" data-format="yyyy-MM-dd" type="text" placeholder="Date" name="from_date" required readonly>
                            </div></div>
                        <div class="col-md-3"><label>To</label><br><br></div>
                        <div class="col-md-3">
                            <div id="datetimepicker5" class="input-append">
                                <input class="form-control1 add-on" data-format="yyyy-MM-dd" type="text" placeholder="Date" name="from_date" required readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"> </div>	
                <div class="tables">
                    <div class="bs-example widget-shadow" data-example-id="contextual-table"> 
                        <table class="table">
                            <thead> <tr> <th>#</th> <th>Date</th> <th>Resource Name</th> <th>Reserved By</th> </tr> </thead>
                            <tbody id="allocation_table">
                                <tr> <th scope="row">1</th> <td>Column content</td> <td>Column content</td> <td>Column content</td> </tr>
                            </tbody> 
                        </table> 
                    </div>
                </div>
                <div class="clearfix col-md-1"> </div>
            </div>
        </div>
        <%@include file="footer.jsp" %> 

        <script type="text/javascript"
                src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
        </script> 
        <script type="text/javascript"
                src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
        </script>
        <script type="text/javascript"
                src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
        </script>
        <script type="text/javascript"
                src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
        </script>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker4').datetimepicker({
                    pickTime: false,
                    language: 'en',
                });
            });
        </script>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker5').datetimepicker({
                    pickTime: false,
                    language: 'en',
                });
            });
        </script>
        
        <script>
            $(document).ready(function (){
                
            });
        </script>
    </body>
</html>