
<form id='add_hall_form' action='/uomrms/add_hall' class='form-horizontal panel-default'>
    <div class='form-group'>
        <label for='focusedinput' class='col-sm-3 control-label'>Resource name</label> 
        <div class='col-sm-9'>
            <input type='text' class='form-control1' id='focusedinput' placeholder='Resource Name' name='resource_name'>
        </div>
    </div>
    <div class='form-group'>
        <label class='control-label col-sm-3' for='mediuminput'>Capacity</label> 
        <div class='col-sm-9'> 
            <input class='form-control1' type='number' name='capacity' min='1' placeholder='Capacity'> 
        </div> 
    </div> 
    <div class='form-group'> 
        <label for='txtarea1' class='col-sm-3 control-label'>Description</label> 
        <div class='col-sm-9'>
            <textarea name='description' id='txtarea1' cols='50' rows='4' class='form-control1' placeholder='Add a short description here'></textarea>
        </div> 
    </div> 
    <div class='form-group'> 
        <label class='control-label col-sm-3'>Department</label>
        <div class='col-sm-9'> 
            <select name='department' class='form-control1'>
                <option value='ENTC'>ENTC</option> 
                <option value='CSE'>CSE</option> 
            </select> 
        </div> 
    </div>
    <div class='form-group'> 
        <label class='control-label col-sm-3'>Building</label>
        <div class='col-sm-9'> 
            <select name='building' class='form-control1'>
                <option value='sumanadasa'>Sumanadasa</option>
                <option value='entc_main'>ENTC Main</option> 
            </select> 
        </div> 
    </div> 
    <div class='form-group'> 
        <label class='control-label col-sm-3'>Air conditioned status</label> 
        <div class='col-sm-9'>
            <select name='ac' class='form-control1'> 
                <option value='Yes'>Yes</option> 
                <option value='No'>No</option> 
            </select> </div> </div> <div class='form-group'> 
        <label class='control-label col-sm-3'>Projector availability</label>
        <div class='col-sm-9'> 
            <select name='pro' class='form-control'> 
                <option value='Yes'>Yes</option> 
                <option value='No'>No</option>
            </select> 
        </div> 
    </div> 
    <div class='form-group'> 
        <label class='control-label col-sm-3'>Board type</label>
        <div class='col-sm-9'>
            <select name='boardtype' class='form-control'> 
                <option value='Black board'>Black board</option> 
                <option value='While Board'>While Board</option> 
                <option value='Both'>Both</option>
                <option value='N/A'>N/A</option> 
            </select>
        </div>
    </div> 
    <br> 
    <div class='form-group'> 
        <div class='col-sm-4 col-sm-offset-4'> 
            <button class='btn btn-default form-control1' type='submit'>Add Resource</button> 
        </div> 
    </div>
</form>