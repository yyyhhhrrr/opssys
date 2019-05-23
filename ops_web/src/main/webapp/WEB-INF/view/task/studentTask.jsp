<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/13
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>OpsManage</title>
    <!-- Bootstrap Styles-->
    <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet" />
    <link href="${ctx}/assets/css/common.css" rel="stylesheet">
    <!-- FontAwesome Styles-->
    <link href="${ctx}/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${ctx}/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${ctx}/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.2/css/bootstrap3/bootstrap-switch.min.css" rel="stylesheet">
    <!-- bootstrap table -->
    <link href="${ctx}/assets/css/bootstrap-table.min.css" rel="stylesheet" />

</head>
<body>


<div id="page-wrapper" >
    <div id="page-inner">
        <!-- 站点  -->
        <div class="row">
            <div class="col-md-12">
                <h1 class="page-header">
                    助力任务管理<small> Task Management</small>
                </h1>
            </div>
        </div>
        <!-- /. ROW  -->
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <!-- 模态框-->
                        <button id="start" class="btn btn-primary btn-lg">开启</button>
                        <button id="stop" class="btn btn-primary btn-lg" >关闭</button>
                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
        <!-- /. ROW  -->

    </div>
</div>

<!-- /. PAGE INNER  -->
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="${ctx}/assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="${ctx}/assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="${ctx}/assets/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${ctx}/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/assets/js/dataTables/dataTables.bootstrap.js"></script>
<!-- TIME FORMAT Js-->
<script type="text/javascript" src="${ctx}/assets/js/jquery.utils.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/assets/js/bootstrap-switch.js"></script>
<!-- bootstrap table-->
<script src="${ctx}/assets/js/bootstrap-table.js"></script>
<script src="${ctx}/assets/js/bootstrap-table-zh-CN.js"></script>

<script>

    $('#start').click(function(){
        $.ajax({
            url:'start',
            type:'POST',
            success:function (result) {
                alert(result);
            }

        })

    })

    $('#stop').click(function(){
        $.ajax({
            url:'stop',
            type:'POST',
            success:function (result) {
                alert(result);
            }

        })

    })



</script>



<!-- Custom Js -->
<script src="${ctx}/assets/js/custom-scripts.js"></script>
<script src="${ctx}/assets/js/bootstrap-treeview.min.js"></script>


</body>
</html>