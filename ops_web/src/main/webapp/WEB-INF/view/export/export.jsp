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
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/moment.js/2.22.0/moment-with-locales.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

</head>
<body>
    <!-- 站点  -->

    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        成长报告导出管理<small> Export Management</small>
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class='col-sm-6'>
                    <div class="form-group">
                        <label>选择开始时间：</label>
                        <!--指定 date标记-->
                        <div class='input-group date' id='datetimepicker1'>
                            <input id="startDate" type='text' class="form-control" />
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
                            <input id="endDate" type='text' class="form-control" />
                            <span class="input-group-addon">
                                  <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label>导出类型选择:   </label>
                        <div id="checkbox">
                            <label class="radio-inline">
                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1">省份导出
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">自营园导出
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline3" value="option3">回访园导出
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label>省份选择:   (省份导出需选择)</label>
                            <select id="provinceList" class="form-control" name="provinceId">
                                <option value="" disabled selected hidden>请选择</option>
                            </select>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">

                            <button class="btn btn-primary btn-lg" onclick="postExport(this);">成长报告导出</button>
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
<%--<script src="${ctx}/assets/js/jquery-1.10.2.js"></script>--%>
<%--<!-- Bootstrap Js -->--%>
<%--<script src="${ctx}/assets/js/bootstrap.min.js"></script>--%>
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
<%--<script src="https://cdn.bootcss.com/moment.js/2.22.0/moment-with-locales.js"></script>--%>
<%--<script src="${ctx}/assets/js/bootstrap-datetimepicker.js"></script>--%>
<%--<script src="${ctx}/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>--%>


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
        // //动态设置最小值
        // picker1.on('dp.change', function (e) {
        //     picker2.data('DateTimePicker').minDate(e.date);
        // });
        // //动态设置最大值
        // picker2.on('dp.change', function (e) {
        //     picker1.data('DateTimePicker').maxDate(e.date);
        // });
    });


    $(document).ready(function(){
        $.ajax({
            contentType : "application/json;charset=utf-8",
            type : "GET",
            url : "${ctx}/export/selectProvince",
            dataType : "json",
            success : function(data) {
                var list=data.list;
                $.each(list, function(i, province) {
                        $('#provinceList').append(
                            $('<option>').text(province.name).attr('value',
                                province.provinceId));
                });
            }
        });
    });

    function postExport(){
        var id=$('#provinceList option:selected').val();
        var name=$('#provinceList option:selected').text();
        var type=$('#checkbox input:radio:checked').val();
        var startDate=$('#startDate').val();
        var endDate=$('#endDate').val();
        if(type=="option1"){
            if((id==null&&name==null)||name=="请选择"){
               alert("请选择所要导出的省份!");
            }
            else if(startDate!=endDate){
                alert("目前省份数据只能导出当天！");
            }
            else {
                exportProvinceExcel(id,name,startDate);
            }
        }
        else if(type=="option2"){
            if(startDate!=endDate){
                alert("目前自营数据只能导出当天!");
            }
            else{
            exportSelfExcel(startDate);
            }
        }else{
            exportReturnVisitExcel(startDate,endDate);
        }


    }

    function exportProvinceExcel(id,name,startDate){
        var province_id=id;
        var province_name=name;
        location.href="${ctx}/export/province?province_id="+province_id+"&province_name="+province_name+"&date="+startDate;
    }

    function exportSelfExcel(startDate){
        var company_name="自营";
        location.href="${ctx}/export/selfExport?company_name="+company_name+"&date="+startDate;
    }

    function exportReturnVisitExcel(start_date,end_date){
        var company_name="河南、湖北、宁夏三省区15所回访";
        location.href="${ctx}/export/returnVisitExport?company_name="+company_name+"&start_date="+start_date+"&end_date="+end_date;
    }

</script>



</body>
</html>
