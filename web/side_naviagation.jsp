<%-- 
    Document   : side_naviagation
    Created on : Jan 9, 2016, 1:44:16 AM
    Author     : Dulaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--left-fixed -navigation-->
<div class="sidebar" role="navigation">
    <div class="navbar-collapse">
        <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
            <ul class="nav" id="side-menu">
                <li>
                    <a href="index.jsp" class="active"><i class="fa fa-home nav_icon"></i>All Resources</a>
                </li>
                <li>
                    <a href="index.jsp"><i class="fa fa-check-circle nav_icon"></i>Available Resources</a>
                </li>
                <li>
                    <a href="allocations.jsp"><i class="fa fa-th nav_icon"></i>Allocations</a>
                </li>
                <li>
                    <a href="add_new_resource.jsp"><i class="fa fa-plus-square nav_icon"></i>Add New Resource</a>
                </li>
                <li>
                    <a href="add_new_manager.jsp"><i class="fa fa-male nav_icon"></i>Add New Manager</a>
                </li>
                <li>
                    <a href="contact_us.jsp"><i class="fa fa-envelope nav_icon"></i>Contact Us</a>
                </li>
                <li>
                    <a href=about.jsp><i class="fa fa-info-circle nav_icon"></i>About</a>
                </li>
            </ul>
            <!-- //sidebar-collapse -->
        </nav>
    </div>
</div>
<!--left-fixed -navigation-->

<!-- Classie -->
<script src="js/classie.js"></script>
<script>
    var menuLeft = document.getElementById('cbp-spmenu-s1'),
            showLeftPush = document.getElementById('showLeftPush'),
            body = document.body;

    showLeftPush.onclick = function () {
        classie.toggle(this, 'active');
        classie.toggle(body, 'cbp-spmenu-push-toright');
        classie.toggle(menuLeft, 'cbp-spmenu-open');
        disableOther('showLeftPush');
    };

    function disableOther(button) {
        if (button !== 'showLeftPush') {
            classie.toggle(showLeftPush, 'disabled');
        }
    }
</script>