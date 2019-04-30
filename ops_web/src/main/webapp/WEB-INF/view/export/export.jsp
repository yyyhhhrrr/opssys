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
<!-- 上部导航栏 -->
<%@ include file="../common/top.jsp"%>
<!--  左侧导航栏 -->
<%@ include file="../common/left.jsp"%>
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

</head>
<body>
<div id="wrapper">

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
            <!-- /. ROW  -->



            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <!-- 模态框-->
                            <button class="btn btn-primary btn-lg" onclick="exportExcel();">宁夏数据导出</button>
                            <button class="btn btn-primary btn-lg" onclick="exportSelfExcel();">自营数据导出</button>
                            <button class="btn btn-primary btn-lg" onclick="exportReturnVisitExcel();">回访数据导出</button>

                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
            <!-- /. ROW  -->

        </div>
        <footer><p>Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p></footer>
    </div>
    <!-- /. PAGE INNER  -->
</div>
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
<script>
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
