
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
      href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">

<div class="modal fade form-horizontal panel-default" id="requestmodalCapacity" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">Make a reservation</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class='form-group'>
                        <label class='control-label col-sm-3' for='mediuminput'>Capacity</label> 
                        <div class='col-sm-9'> 
                            <input class='form-control1' type='number' name='capacity' min='1' placeholder='Capacity'> 
                        </div> 
                    </div> 
                    <div class='form-group'>
                        <label class='control-label col-sm-3' for='mediuminput'>From</label> 
                        <div id="datetimepicker" class="col-sm-9 input-append date">
                            <input type="text">
                            <span class="add-on">
                                <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                            </span>
                        </div>
                    </div> 
                    <div class='form-group'>
                        <label class='control-label col-sm-3' for='mediuminput'>To</label> 
                        <div class='col-sm-9'> 
                            <input class='form-control1' name='to' placeholder='To'> 
                        </div> 
                    </div> 
                    <div class="form-group">
                        <label class='control-label col-sm-3' for='mediuminput'>Purpose</label> 
                        <div class='col-sm-9'>
                            <textarea name='purpose' id='txtarea1' cols="50" rows='10' class='form-control1 col-sm-8' placeholder='Metion the purpose of the reservation here'></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">Reserve</button>
            </div>
        </div>
    </div>
</div>

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
    $('#datetimepicker').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language: 'pt-BR'
    });
</script>
