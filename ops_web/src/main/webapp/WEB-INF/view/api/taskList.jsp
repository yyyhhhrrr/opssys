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
<div id="wrapper">
    <!-- 站点  -->

    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        接口检测任务管理<small> Task Management</small>
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
                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">添加检测任务</button>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">

                                <!--模态框（Modal） -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">检测任务信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="form1" action="" method="post">
                                                    <div class="form-group">
                                                        <label>服务器</label>
                                                        <select id="serverIpList" class="form-control" name="tsk_ip_id">
                                                            <option value="" disabled selected hidden>请选择</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>接口</label>
                                                        <select id="interfaceList" class="form-control" name="tsk_it_id">
                                                            <option value="" disabled selected hidden>请选择</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>提交方法</label>
                                                        <select id="method" class="form-control" name="tsk_pm_method">
                                                            <option value="POST">POST</option>
                                                            <option value="GET">GET</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>header</label>
                                                        <input id="header" class="form-control" name="tsk_pm_header">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>json</label>
                                                        <input id="json" class="form-control" name="tsk_pm_json">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>结果</label>
                                                        <input id="result" class="form-control" name="tsk_pm_result">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>检测时间(ms)</label>
                                                        <input id="time" class="form-control" name="tsk_time">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>详细信息</label>
                                                        <input id="detail" class="form-control" name="tsk_detail">
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary" onclick="save(this);">提交</button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>

                                <!--修改接口地址模态框(modal) -->
                                <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="updateModalLabel">修改接口检测任务信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="update_form" action="" method="post">
                                                    <input  id="update_id" type="hidden" name="tsk_id" value=""/>
                                                    <div class="form-group">
                                                        <label>服务器</label>
                                                        <select id="update_serverIpList" class="form-control" name="tsk_ip_id">
                                                            <option value="" ></option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>接口</label>
                                                        <select id="update_interfaceList" class="form-control" name="tsk_it_id">
                                                            <option value=""></option>

                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>提交方法</label>
                                                        <select id="update_method" class="form-control" name="tsk_pm_method">
                                                            <option value=""></option>
                                                            <option value=""></option>

                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>header</label>
                                                        <input id="update_header" class="form-control" name="tsk_pm_header" value="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>json</label>
                                                        <input id="update_json" class="form-control" name="tsk_pm_json" value="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>结果</label>
                                                        <input id="update_result" class="form-control" name="tsk_pm_result" value="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>检测时间(ms)</label>
                                                        <input id="update_time" class="form-control" name="tsk_time" value="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>详细信息</label>
                                                        <input id="update_detail" class="form-control" name="tsk_detail" value="">
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary" onclick="update(this);">提交</button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>

                                <!-- 删除模态框（Modal） -->
                                <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="deleteModalLabel">警告!</h4>
                                            </div>
                                            <div class="modal-body">确定要删除吗?</div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                <button id="delete" type="button" >确定</button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>


                                <!--查看接口地址详情模态框(modal) -->
                                <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="detailModalLabel">接口检测任务信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="detail_form" action="" method="post">
                                                    <div class="form-group">
                                                        <label>服务器</label>
                                                        <div id="detail_serverIp"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>接口</label>
                                                        <div id="detail_interface"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>提交方法</label>
                                                        <div id="detail_method"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>header</label>
                                                        <div id="detail_header"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>json</label>
                                                        <div id="detail_json"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>结果</label>
                                                        <div id="detail_result"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>检测时间(ms)</label>
                                                        <div id="detail_time"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>详细信息</label>
                                                        <div id="detail_detail"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>创建时间</label>
                                                        <div id="detail_create_time"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>更新时间</label>
                                                        <div id="detail_update_time"></div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary" onclick="update(this);">提交</button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>

                                <div class="modal fade bd-example-modal-sm"  id="alertmyModal" role="dialog" data-backdrop="false"  aria-hidden="true">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">
                                            <p id="alert-p" class="text-center mb-0">
                                            </p>
                                        </div>
                                    </div>
                                </div>


                                <table class="table table-striped table-bordered table-hover" style="table-layout: fixed;" id="table_server">
                                </table>
                            </div>

                        </div>
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
<script src="${ctx}/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/assets/js/dataTables/dataTables.bootstrap.js"></script>
<!-- TIME FORMAT Js-->
<script type="text/javascript" src="${ctx}/assets/js/jquery.utils.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/assets/js/bootstrap-switch.js"></script>
<!-- bootstrap table-->
<script src="${ctx}/assets/js/bootstrap-table.js"></script>
<script src="${ctx}/assets/js/bootstrap-table-zh-CN.js"></script>

<script>
    $(function () {
        initTable();

    })

    function initTable(){

        $('#table_server').bootstrapTable('destroy');
        $('#table_server').bootstrapTable({
            method: 'GET',
            // 若以post方式提交，需要补充contentType信息，否则分页参数无法传递到controller
            //contentType: "application/x-www-form-urlencoded",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            // 查询传入起始页码数，后台需要计算起始查询条数
            url : "getTaskList",
            formatNoMatches : function() {
                return '无符合条件的记录';
            },
            formatLoadingMessage : function() {
                return "请稍等，正在加载中...";
            },
            onLoadSuccess:initBtn,
            cache : false,
            striped: true, //是否显示行间隔色
            dataField: "rows",//controller返回json数据对应key
            pageNumber: 1, //初始化加载第一页，默认第一页
            pagination:true,//是否分页
            pageSize : 10,
            pageList : [ 10, 25, 50 ],
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            queryParamsType:'', // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber

            // 直接把pageSize,pageNumber，调用queryParamsByBegin函数
            queryParames:queryParamsByBegin,
            columns : [
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_id',
                    title : 'tsk_id'
                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'serverIp.sv_id',
                    title : 'serverIp.sv_id'
                },
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'anInterface.it_id',
                    title : 'anInterface.it_id'
                },
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'anInterface.it_port',
                    title : 'anInterface.it_port'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'anInterface.it_address',
                    title : 'anInterface.it_address'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_pm_method',
                    title : 'tsk_pm_method'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_pm_header',
                    title : 'tsk_pm_header'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_pm_json',
                    title : 'tsk_pm_json'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_pm_result',
                    title : 'tsk_pm_result'
                },

                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'serverIp.sv_ip',
                    title : '服务器'

                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : '',
                    title : '接口地址',
                    formatter:function(value,row,index){
                        return row.anInterface.it_port+row.anInterface.it_address;
                    }
                },  {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_time',
                    title : '检测时间'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_detail',
                    title : '详细信息',
                    cellStyle:{
                        css:{
                            "overflow": "hidden",
                            "text-overflow": "ellipsis",
                            "white-space": "nowrap"
                        }
                    },
                    formatter:paramsMatter
                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_create_time',
                    title : '创建时间'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_update_time',
                    title : '更新时间'
                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : '',
                    title : '操作',
                    // 调用operateFormatter函数
                    formatter : operateFormatter
                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : '',
                    title : '状态',
                    // 调用operateFormatter函数
                    formatter : statusFormatter
                }],


        });
        // 隐藏主键显示
        $('#table_server').bootstrapTable('hideColumn', 'tsk_id');
        $('#table_server').bootstrapTable('hideColumn', 'serverIp.sv_id');
        $('#table_server').bootstrapTable('hideColumn', 'anInterface.it_id');
        $('#table_server').bootstrapTable('hideColumn', 'anInterface.it_port');
        $('#table_server').bootstrapTable('hideColumn', 'anInterface.it_address');
        $('#table_server').bootstrapTable('hideColumn', 'tsk_pm_method');
        $('#table_server').bootstrapTable('hideColumn', 'tsk_pm_header');
        $('#table_server').bootstrapTable('hideColumn', 'tsk_pm_json');
        $('#table_server').bootstrapTable('hideColumn', 'tsk_pm_result');


    }
    // 以起始页码方式传入参数,params为table组装参数
    function queryParamsByBegin(params){
        return{
            pageSize: params.pageSize,
            pageNumber: params.pageNumber
        }
    }

    // 补充操作栏按钮信息（value：当前字段值，row：当前行信息，index：序列索引）
    function operateFormatter(value, row, index) {
        var update = '<button type="button"   class="btn btn-success btn-xs"  data-toggle="modal" data-target="#updateModal" onclick="show_update(\'' + row.tsk_id  + '\',\'' + row.serverIp.sv_id  + '\',\'' + row.anInterface.it_id  + '\',\'' + row.serverIp.sv_ip + '\',\''+row.anInterface.it_port+'\',\''+row.anInterface.it_address+'\',\''+row.tsk_pm_method+'\',\''+row.tsk_pm_header+'\',\''+row.tsk_pm_json+'\',\''+row.tsk_pm_result+'\',\''+row.tsk_time+'\',\''+row.tsk_detail+'\')">修改</button>';
        var detail = '<button type="button" style="margin-left:10px;" class="btn btn-xs btn-green-yhr"  data-toggle="modal" data-target="#detailModal" onclick="show_detail(\''+row.tsk_id+'\',\''+row.serverIp.sv_id+'\',\''+row.anInterface.it_id+'\',\'' + row.serverIp.sv_ip + '\',\''+row.anInterface.it_port+'\',\''+row.anInterface.it_address+'\',\''+row.tsk_pm_method+'\',\''+row.tsk_pm_header+'\',\''+row.tsk_pm_json+'\',\''+row.tsk_pm_result+'\',\''+row.tsk_time+'\',\''+row.tsk_detail+'\',\''+row.tsk_create_time+'\',\''+row.tsk_update_time+'\')" >查看详情</button>';
        var del = '<button type="button" style="margin-left:10px;" class="btn btn-danger btn-xs"  data-toggle="modal" data-target="#deleteModal" onclick="show_delete('+  row.tsk_id + ')">删除</button>';
        return update+del+detail;
    }

    function statusFormatter(value,row,index){
        if(row.status==false){
            var on='<input id="c1" checked="checked" type="checkbox"  class="checkbox" value="'+  row.tsk_id + '"/>'
             return on;
        }
        else if(row.status==true){
            var off=' <input id="c1" type="checkbox"  class="checkbox" value="'+  row.tsk_id + '"/>'
            return off;
        }

    }
    //详情悬浮窗
    function paramsMatter(value, row, index) {
        var values = row.tsk_detail;//获取当前字段的值
        //替换空格，因为字符串拼接的时候如果遇到空格，会自动将后面的部分截掉，所有这里用html的转义符
        // 代替
        values = values.replace(/\s+/g,' ')
        return "<span title="+values+">"+row.tsk_detail+"</span>"
    }



    var isFirst = true;
    //修改信息时 下拉菜单
    function selectExcept(sv_id,it_id){
        var data1={"sv_id":sv_id};
        var data2={"it_id":it_id};
        if(isFirst) {
            $.ajax({
                contentType: "application/json;charset=utf-8",
                type: "GET",
                url: "getIPList",
                success: function (data) {
                    var list=data.list;
                    $.each(list, function (i, serverIp) {
                        if($('#update_serverIpList option:selected').text()!=serverIp.sv_ip) {
                            $('#update_serverIpList').append(
                                $('<option>').text(serverIp.sv_ip).attr('value',
                                    serverIp.sv_id));
                        }});
                }
            });

            $.ajax({
                contentType: "application/json;charset=utf-8",
                type: "GET",
                url: "getInterfaceList",
                success: function (data) {
                    var list=data.list;
                    $.each(list, function (i, itc) {
                        var it_message=itc.it_port+itc.it_address;
                        if($('#update_interfaceList option:selected').text()!=it_message) {
                            $('#update_interfaceList').append(
                                $('<option>').text(itc.it_port + itc.it_address).attr('value',
                                    itc.it_id));
                        }});
                }
            });

            isFirst = false;
        }
    }


    // 服务器选择 下拉菜单
    $(document).ready(function(){
        $.ajax({
            contentType : "application/json;charset=utf-8",
            type : "GET",
            url : "getIPList",
            dataType : "json",
            success : function(data) {
                var list=data.list;
                $.each(list, function(i, serverIp) {
                    $('#serverIpList').append(
                        $('<option>').text(serverIp.sv_ip).attr('value',
                            serverIp.sv_id));
                });
            }
        });
    });



    // 接口地址选择 下拉菜单
    $(document).ready(function(){
        $.ajax({
            contentType : "application/json;charset=utf-8",
            type : "GET",
            url : "getInterfaceList",
            dataType : "json",
            success : function(data) {
                var list=data.list;
                $.each(list, function(i, itc) {
                    $('#interfaceList').append(
                        $('<option>').text(itc.it_port+itc.it_address).attr('value',
                            itc.it_id));
                });
            }
        });
    });


    //新增
    function save(src) {
        $.post("saveTask",$("#form1").serializeArray(),
            function(result){
                if(result == "提交成功"){
                    alert('提交成功');
                    window.location.replace("${ctx}/main/taskList");
                }else{
                    alert('提交失败，请联系管理员');
                }
                $("#serverIpList").val("");
                $("#interfaceList").val("");
                $("#method").val("");
                $("#header").val("");
                $("#json").val("");
                $("#result").val("");
                $("#time").val("");
                $("#detail").val("");
                $("#myModal").modal('hide');

            }
        );
    }


    //修改信息填充
    function show_update(tsk_id,sv_id,it_id,sv_ip,it_port,it_address,tsk_pm_method,tsk_pm_header,tsk_pm_json,tsk_pm_result,tsk_time,tsk_detail){

        var ipl=$('#update_serverIpList');
        var itl=$('#update_interfaceList');

        $('#update_id').val(tsk_id);
        ipl.children().eq(0).text(sv_ip).val(sv_id);
        itl.children().eq(0).text(it_port+it_address).val(it_id);
        var method= $('#update_method');
        if(tsk_pm_method =="POST") {
            method.children().eq(0).text(tsk_pm_method).val(tsk_pm_method);
            method.children().eq(1).text("GET").val("GET");
        }
        else{
            method.children().eq(0).text(tsk_pm_method).val(tsk_pm_method);
            method.children().eq(1).text("POST").val("POST");
        }
        $('#update_header').val(tsk_pm_header);
        // var tsk_pm_json_ = tsk_pm_json.replaceAll("","&quot;");
        // var tsk_pm_result_ = tsk_pm_result;


        $('#update_json').val(tsk_pm_json);
        $('#update_result').val(tsk_pm_result);
        $('#update_time').val(tsk_time);
        $('#update_detail').val(tsk_detail);
        selectExcept(sv_id,it_id);

        }



    //更新
    function update(src){
        $.post("updateTask",$("#update_form").serializeArray(),
            function(result){
                if(result == "更新成功"){
                    alert('更新成功');
                    window.location.replace("${ctx}/main/taskList");
                }else{
                    alert('更新失败，请联系管理员');
                }
            });

    }


    //删除
    function show_delete(tsk_id){
        var delet=document.getElementById("delete");
        delet.onclick=function(){
            $.post("deleteTask",{tsk_id:tsk_id},
                function(result){
                    if(result == "删除成功"){
                        alert("删除成功");
                        window.location.replace("${ctx}/main/taskList");
                    }else{
                        alert("删除失败，请联系管理员");
                    }
                });
        }

    }


    //详细信息显示
    function show_detail(tsk_id,sv_id,it_id,sv_ip,it_port,it_address,tsk_pm_method,tsk_pm_header,tsk_pm_json,tsk_pm_result,tsk_time,tsk_detail,tsk_create_time,tsk_update_time){
        $('#detail_serverIp').html(sv_ip);
        $('#detail_interface').html(it_port+it_address);
        $('#detail_method').html(tsk_pm_method);
        $('#detail_header').html(tsk_pm_header);
        $('#detail_json').html(tsk_pm_json);
        $('#detail_result').html(tsk_pm_result);
        $('#detail_time').html(tsk_time);
        $('#detail_detail').html(tsk_detail);
        $('#detail_create_time').html(tsk_create_time);
        $('#detail_update_time').html(tsk_update_time);

    }

    //自关闭模态提示框
    function myalert(src){
        var success='<i class="fa fa-check-circle text-success mr-1" aria-hidden="true"></i>\n' +'操作成功';
        var danger='<i class="fa fa-check-circle text-danger mr-1" aria-hidden="true"></i>\n' +'操作失败';
        var alertmyModal=$('#alertmyModal');
        var alert_p=$('#alert-p');
        if(src=="操作成功"){
            alert_p.append(success);
            alertmyModal.modal('show');

        }
        else{
            alert_p.append(danger);
            alertmyModal.modal('show');

        }
        setTimeout(function(){
            alertmyModal.modal("hide");
            alert_p.empty();
        },1200);
    }


    //开关任务控件
    /* bootstrap开关控件，初始化 */
    function initBtn(){
        /* 初始化控件 */
        $(".checkbox").bootstrapSwitch({
            onText : "开启",      // 设置ON文本  
            offText : "关闭",    // 设置OFF文本  
            onColor : "success",// 设置ON文本颜色     (info/success/warning/danger/primary)  
            offColor : "danger",  // 设置OFF文本颜色        (info/success/warning/danger/primary)  
            size : "mini",    // 设置控件大小,从小到大  (mini/small/normal/large)  
            handleWidth:"35",//设置控件宽度
            // 当开关状态改变时触发 
            onSwitchChange : function(event, state) {
                var tsk_id = event.target.defaultValue;
                    $.post("task",{tsk_id:tsk_id,state:state},function(result) {
                        if(result=="操作成功"){
                           myalert(result);
                        }
                        else{
                            myalert("操作失败");
                        }
                    })
            }
        });
    }



</script>



<!-- Custom Js -->
<script src="${ctx}/assets/js/custom-scripts.js"></script>



</body>
</html>