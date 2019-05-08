<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/30
  Time: 14:17
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
    <link href="${ctx}/assets/css/common.css" rel="stylesheet"/>
    <!-- FontAwesome Styles-->
    <link href="${ctx}/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${ctx}/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${ctx}/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- bootstrap table -->
    <link href="${ctx}/assets/css/bootstrap-table.min.css" rel="stylesheet" />
    <!-- datetime组件-->
    <link href="${ctx}/assets/css/bootstrap-datetimepicker.css" rel="stylesheet" />

</head>
<body>
    <!-- 站点  -->

    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        数据导出管理<small> Export Management</small>
                    </h1>
                </div>
            </div>


            <div class="row">
                <div class='col-sm-6'>
                    <div class="form-group">
                        <label>选择开始时间：</label>
                        <!--指定 date标记-->
                        <div class='input-group date' id='datetimepicker1'>
                            <input type='text' class="form-control" />
                            <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                        </div>
                    </div>
                </div>
                <div class='col-sm-6'>
                    <div class="form-group">
                        <label>选择结束时间：</label>
                        <!--指定 date标记-->
                        <div class='input-group date' id='datetimepicker2'>
                            <input type='text' class="form-control" />
                            <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                        </div>
                    </div>
                </div>
            </div>




            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <!-- 模态框-->
                            <button class="btn btn-primary btn-lg" onclick="post(this);">数据导出</button>
                            <%--<button class="btn btn-primary btn-lg" onclick="exportSelfExcel();">自营数据导出</button>--%>
                            <%--<button class="btn btn-primary btn-lg" onclick="exportReturnVisitExcel();">回访数据导出</button>--%>

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
<%--<script src="${ctx}/assets/js/dataTables/jquery.dataTables.js"></script>--%>
<%--<script src="${ctx}/assets/js/dataTables/dataTables.bootstrap.js"></script>--%>
<!-- TIME FORMAT Js-->
<script type="text/javascript" src="${ctx}/assets/js/jquery.utils.js" charset="utf-8"></script>
<!-- bootstrap table-->
<script src="${ctx}/assets/js/bootstrap-table.js"></script>
<script src="${ctx}/assets/js/bootstrap-table-zh-CN.js"></script>
<!-- Custom Js -->
<script src="${ctx}/assets/js/custom-scripts.js"></script>
        <script src="${ctx}/assets/js/moment-with-locales.min.js"></script>
        <script src="${ctx}/assets/js/bootstrap-datetimepicker.js"></script>
        <script src="${ctx}/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>


<script>
    $(function () {
        var picker1 = $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn'),
            //minDate: '2016-7-1'
        });
        var picker2 = $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn')
        });
        //动态设置最小值
        picker1.on('dp.change', function (e) {
            picker2.data('DateTimePicker').minDate(e.date);
        });
        //动态设置最大值
        picker2.on('dp.change', function (e) {
            picker1.data('DateTimePicker').maxDate(e.date);
        });
    });



    function exportExcel(){
        var province_id=3354;
        var province_name="宁夏";
        location.href="${ctx}/export/province?province_id="+province_id+"&province_name="+province_name;
    }

    function exportSelfExcel(){
        var company_name="自营";
        location.href="${ctx}/export/selfExport?company_name="+company_name;
    }

    function exportReturnVisitExcel(){
        var company_name="河南、湖北、宁夏三省区15所回访";
        var start_date="2019-04-15";
        var end_date="2019-04-17";
        location.href="${ctx}/export/returnVisitExport?company_name="+company_name+"&start_date="+start_date+"&end_date="+end_date;
    }

</script>



</body>
</html>
