<%-- 
    Document   : add_new_hall
    Created on : Jan 13, 2016, 6:29:15 PM
    Author     : Dulaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form id="add_hall_form" class="form-horizontal panel-default">
    <div class="form-group">
        <label for="focusedinput" class="col-sm-3 control-label">Resource name</label>
        <div class="col-sm-9">
            <input type="text" class="form-control1" id="focusedinput" placeholder="Resource Name" name="resource_name">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-3" for="mediuminput">Capacity/Count</label>
        <div class="col-sm-9">
            <input class="form-control1" type="number" name="capacity" min="1" placeholder="Capacity/Count">
        </div>
    </div>
    <div class="form-group">
        <label for="txtarea1" class="col-sm-3 control-label">Description</label>
        <div class="col-sm-9"><textarea name="description" id="txtarea1" cols="50" rows="4" class="form-control1" placeholder="Add a short description here"></textarea></div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-3">Department</label>
        <div class="col-sm-9">
            <select name="building" class="form-control1">
                <option value="cse_sumanadasa">ENTC</option>
                <option value="cse_sumanadasa">CSE</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-3">Building</label>
        <div class="col-sm-9">
            <select name="building" class="form-control1">
                <option value="cse_sumanadasa">Sumanadasa</option>
                <option value="entc">ENTC Main</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-3">Air conditioned status</label>
        <div class="col-sm-9">
            <select name="ac" class="form-control1">
                <option value="Yes">Yes</option>
                <option value="No">No</option>
            </select>
        </div>
    </div>
    <br>
    <div class="form-group">
        <div class="col-sm-4 col-sm-offset-4">
            <button class="btn btn-default form-control1" type="submit">Add Resource</button>
        </div>
    </div>
</form>