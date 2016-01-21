/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
//    var notification_modal = function (item) {
//        alert(item);

//    }
});

function notification_modal(id) {
//    var i = id;
    $(function () {
        $.get("/uomrms/modals/notification_modal.jsp?id=" + id, function (data, success) {
            $("#modal_region").empty();
            $("#modal_region").append(data);
            $("#notification_modal").modal('show');
        });
    });
}

function notification_rdr_mgr(id) {
    localStorage.setItem('not_id', id);
    window.location.href = "/uomrms/view_reservation.jsp";
}


