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
                        <input id="page" name="page" value="allocations.jsp" hidden>
                        <div class="col-md-2"><label>From</label><br><br></div>
                        <div class="col-md-3">
                            <div id="datetimepicker4" class="input-append">
                                <input id="from" class="form-control1 add-on" data-format="yyyy-MM-dd" type="text" placeholder="Date" name="from" required readonly>
                            </div></div>
                        <div class="col-md-2"><label>To</label><br><br></div>
                        <div class="col-md-3">
                            <div id="datetimepicker5" class="input-append">
                                <input id="to" class="form-control1 add-on" data-format="yyyy-MM-dd" type="text" placeholder="Date" name="to" required readonly>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <button onclick="loadAllocations()" class="btn btn-primary">Go</button>
                            <!--<button onclick="loadAllocations([\'' + $('#from').val() + ',' + $('#to').val())'\'])">Go</button>-->
                        </div>
                    </div>
                </div>
                <div class="clearfix"> </div>	
                <div class="tables">
                    <div class="bs-example widget-shadow" data-example-id="contextual-table"> 
                        <table class="table">
                            <thead> <tr> <th>#</th> <th>From</th><th>To</th> <th>Resource Name</th> <th>Reserved By</th> </tr> </thead>
                            <tbody id="allocation_table">
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
            var loadAllocations = function () {
                $.get("get_approvedreservation?from=" + $('#from').val() + "&to=" + $('#to').val() + "&page=" + $('#page').val(), function (data) {
                    $("#allocation_table").empty();
                    var jsonArray = $.parseJSON(data);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var item = jsonArray[i];
                        $("#allocation_table").append("<tr><th scope='row'>" + (i + 1) + "</th><td>" + item['startTime'] + "</td><td>" + item['endTime'] + "</td><td>" + item['resourceId'] + "</td><td>" + item['PersonId'] + "</td><td><button onclick=\"viewReservation(this)\" id=" + item['reserveId'] + " class='btn btn-primary'>View</button></td></tr>");
                    }
                });
            };
        </script>
        
        <script>
            var viewReservation=function (arg){
                localStorage.setItem("reservation_id", arg.id);
                window.location.href="view_reservation.jsp";
            };
        </script>

        <script>
            $(document).ready(function () {
                var pickerFrom = $('#datetimepicker4').data('datetimepicker');
                var pickerTo = $('#datetimepicker5').data('datetimepicker');
                var now = new Date(Date.now());
                pickerTo.setLocalDate(now);
                if (now.getMonth() == 0) {
                    now.setMonth(11);
                    now.setYear(now.getYear() - 1 + 1900);
                }
                else {
                    now.setMonth(now.getMonth() - 1);
                }
                pickerFrom.setLocalDate(now);
                loadAllocations();
            });
        </script>
    </body>
</html>