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
    <link href="${ctx}/assets/css/common.css" rel="stylesheet">
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

    <!-- 站点  -->
    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        服务器管理<small> Server Management</small>
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
                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">添加服务器</button>
                            <button  id="select"class="btn btn-primary btn-lg" ><i class="fa fa-search fa-large"></i>查询</button>
                            <button  id="reset" class="btn btn-primary btn-lg"><i class="fa fa-undo fa-large"></i>重置</button>
                            </div>
                        <table class="table table-bordered">
                            <tr>
                            <td>
                                <div class="form-group">
                                    IP:<input id="select_ip" class="form-control" name="svIp" placeholder="请输入ip...">
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    操作系统:<input id="select_os" class="form-control" name="svOs" placeholder="请输入操作系统...">
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    详细信息:<input id="select_detail" class="form-control" name="svDetail" placeholder="请输入详细信息...">
                                </div>
                            </td>
                            </tr>
                        </table>


                        <div class="panel-body">
                            <div class="table-responsive">

                                <!--模态框（Modal） -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">服务器信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="form1" action="" method="post">
                                                    <div class="form-group">
                                                        <label>IP外网地址</label>
                                                        <input id="ip" class="form-control" name="sv_ip">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IP内网地址</label>
                                                        <input id="ip_private" class="form-control" name="sv_ip_private">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>操作系统</label>
                                                        <input id="os" class="form-control" name="sv_os">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>CPU</label>
                                                        <input id="cpu" class="form-control" name="sv_cpu">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>内存</label>
                                                        <input id="memory" class="form-control" name="sv_memory">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>磁盘容量</label>
                                                        <input id="disk" class="form-control" name="sv_disk">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>带宽</label>
                                                        <input id="bandwidth" class="form-control" name="sv_bandwidth">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>详细信息</label>
                                                        <input id="detail" class="form-control" name="sv_detail">
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
                                                <h4 class="modal-title" id="updateModalLabel">修改服务器信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="update_form" action="" method="post">
                                                    <input id="update_id" type="hidden" name="sv_id" value=""/>
                                                    <div class="form-group">
                                                        <label>IP外网地址</label>
                                                        <input id="update_ip" class="form-control" name="sv_ip" value="" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IP内网地址</label>
                                                        <input id="update_ip_private" class="form-control" name="sv_ip_private" value="" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label>操作系统</label>
                                                        <input id="update_os" class="form-control" name="sv_os" value="" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label>CPU</label>
                                                        <input id="update_cpu" class="form-control" name="sv_cpu" value="" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label>内存</label>
                                                        <input id="update_memory" class="form-control" name="sv_memory" value="" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label>磁盘容量</label>
                                                        <input id="update_disk" class="form-control" name="sv_disk" value="" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label>带宽</label>
                                                        <input id="update_bandwidth" class="form-control" name="sv_bandwidth" value="" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label>详细信息</label>
                                                        <input id="update_detail" class="form-control" name="sv_detail" value="" >
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
                                                <button id="delete" type="button">确定</button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>

                                <!--查看详情模态框(modal) -->
                                <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="detailModalLabel">服务器信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="detail_form" action="" method="post">
                                                    <div class="form-group">
                                                        <label>IP外网地址</label>
                                                        <div id="detail_ip"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IP内网地址</label>
                                                        <div id="detail_ip_private"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>操作系统</label>
                                                        <div id="detail_os"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>CPU</label>
                                                        <div id="detail_cpu"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>内存</label>
                                                        <div id="detail_memory"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>磁盘</label>
                                                        <div id="detail_disk"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>带宽</label>
                                                        <div id="detail_bandwidth"></div>
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
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
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

    </div>
    <!-- /. PAGE INNER  -->

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
<!-- bootstrap table-->
<script src="${ctx}/assets/js/bootstrap-table.js"></script>
<script src="${ctx}/assets/js/bootstrap-table-zh-CN.js"></script>
<script>
    $(function () {
        initTable();
    });

    function initTable(){

        $('#table_server').bootstrapTable('destroy');
        $('#table_server').bootstrapTable({
            method: 'GET',
            // 若以post方式提交，需要补充contentType信息，否则分页参数无法传递到controller
            //contentType: "application/x-www-form-urlencoded",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            // 查询传入起始页码数，后台需要计算起始查询条数
            url : "getIPList",
            formatNoMatches : function() {
                return '无符合条件的记录';
            },
            formatLoadingMessage : function() {
                return "请稍等，正在加载中...";
            },
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
            queryParams:queryParamsByBegin,
            columns : [
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_id',
                    title : 'sv_id'
                },
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_ip_private',
                    title : 'sv_ip_private'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_cpu',
                    title : 'sv_cpu'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_memory',
                    title : 'sv_memory'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_disk',
                    title : 'sv_disk'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_bandwidth',
                    title : 'sv_bandwidth'
                },
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_ip',
                    title : '服务器'

                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_os',
                    title : '操作系统'
                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_detail',
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
                    field : 'sv_create_time',
                    title : '创建时间'
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'sv_update_time',
                    title : '更新时间'
                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : '',
                    title : '操作',
                    // 调用operateFormatter函数
                    formatter : operateFormatter
                } ],

        });
        // 隐藏主键显示
        $('#table_server').bootstrapTable('hideColumn', 'sv_id');
        $('#table_server').bootstrapTable('hideColumn', 'sv_ip_private');
        $('#table_server').bootstrapTable('hideColumn', 'sv_cpu');
        $('#table_server').bootstrapTable('hideColumn', 'sv_memory');
        $('#table_server').bootstrapTable('hideColumn', 'sv_disk');
        $('#table_server').bootstrapTable('hideColumn', 'sv_bandwidth');




    }
    // 以起始页码方式传入参数,params为table组装参数
    function queryParamsByBegin(params){
        return{
            pageSize: params.pageSize,
            pageNumber: params.pageNumber,
            svIp: $("#select_ip").val(),
            svOs: $("#select_os").val(),
            svDetail:$("#select_detail").val()
        }
    }

    $('#select').click(function () {
        $('#table_server').bootstrapTable('refresh');//url为后台action

    })

    $('#reset').click(function () {
        $("#select_ip").val("")
        $("#select_os").val("")
        $("#select_detail").val("")
        $('#table_server').bootstrapTable('refresh');//url为后台action
    })


    // 补充操作栏按钮信息（value：当前字段值，row：当前行信息，index：序列索引）
    function operateFormatter(value, row, index) {
        var update = '<button type="button"   class="btn btn-success btn-xs"  data-toggle="modal" data-target="#updateModal" onclick="show_update(\'' + row.sv_id  + '\',\'' + row.sv_ip  + '\',\'' + row.sv_ip_private  + '\',\'' + row.sv_os + '\',\''+row.sv_cpu+'\',\''+row.sv_memory+'\',\''+row.sv_disk+'\',\''+row.sv_bandwidth+'\',\''+row.sv_detail+'\')">修改</button>';
        var detail = '<button type="button" style="margin-left:10px;" class="btn btn-xs btn-green-yhr"  data-toggle="modal" data-target="#detailModal" onclick="show_detail(\'' + row.sv_ip  + '\',\'' + row.sv_ip_private  + '\',\'' + row.sv_os + '\',\''+row.sv_cpu+'\',\''+row.sv_memory+'\',\''+row.sv_disk+'\',\''+row.sv_bandwidth+'\',\''+row.sv_detail+'\',\''+row.sv_create_time+'\',\''+row.sv_update_time+'\')" >查看详情</button>';
        var del = '<button type="button" style="margin-left:10px;" class="btn btn-danger btn-xs"  data-toggle="modal" data-target="#deleteModal" onclick="show_delete('+  row.sv_id + ')">删除</button>';
        return update+del+detail;
    }
    //详情悬浮窗
    function paramsMatter(value, row, index) {
        var values = row.sv_detail;//获取当前字段的值
        //替换空格，因为字符串拼接的时候如果遇到空格，会自动将后面的部分截掉，所有这里用html的转义符
        // 代替
        values = values.replace(/\s+/g,' ')
        return "<span title="+values+">"+row.sv_detail+"</span>"
    }


    //新增
    function save(src) {
        $.post("saveIP",$("#form1").serializeArray(),
            function(result){
                if(result == "提交成功"){
                    alert('提交成功');
                    window.location.replace("${ctx}/main/ipList");
                }else{
                    alert('提交失败，请重试');
                }
                $("#ip").val("");
                $("#ip_private").val("");
                $("#os").val("");
                $("#cpu").val("");
                $("#memory").val("");
                $("#disk").val("");
                $("#bandwidth").val("");
                $("#detail").val("");
                $("#myModal").modal('hide');

            }
        );
    }

    //修改信息填充
    $("#updateModal").modal("hide");
    function show_update(sv_id,sv_ip,sv_ip_private,sv_os,sv_cpu,sv_memory,sv_disk,sv_bandwidth,sv_detail){

        $('#update_id').val(sv_id);
        $('#update_ip').val(sv_ip);
        $('#update_ip_private').val(sv_ip_private);
        $('#update_os').val(sv_os);
        $('#update_cpu').val(sv_cpu);
        $('#update_memory').val(sv_memory);
        $('#update_disk').val(sv_disk);
        $('#update_bandwidth').val(sv_bandwidth);
        $('#update_detail').val(sv_detail);


    }




    //更新
    function update(src){
        $.post("updateIP",$("#update_form").serializeArray(),
            function(result){
                if(result == "更新成功"){
                    alert('更新成功');
                    window.location.replace("${ctx}/main/ipList");
                }else{
                    alert('更新失败，请联系管理员');
                }
            });

    }

    //删除
    function show_delete(sv_id){
        var delet=document.getElementById("delete");
        delet.onclick=function(){
            $.post("deleteIP",{sv_id:sv_id},
                function(result){
                    if(result == "删除成功"){
                        alert("删除成功");
                        window.location.replace("${ctx}/main/ipList");
                    }else{
                        alert("删除失败，请联系管理员");
                    }
                });
        }

    }


    //详细信息显示
    function show_detail(sv_ip,sv_ip_private,sv_os,sv_cpu,sv_memory,sv_disk,sv_bandwidth,sv_detail,sv_create_time,sv_update_time){

        $('#detail_ip').html(sv_ip);
        $('#detail_ip_private').html(sv_ip_private);
        $('#detail_os').html(sv_os);
        $('#detail_cpu').html(sv_cpu);
        $('#detail_memory').html(sv_memory);
        $('#detail_disk').html(sv_disk);
        $('#detail_bandwidth').html(sv_bandwidth);
        $('#detail_detail').html(sv_detail);
        $('#detail_create_time').html(sv_create_time);
        $('#detail_update_time').html(sv_update_time);
    }

</script>
<!-- Custom Js -->
<script src="${ctx}/assets/js/custom-scripts.js"></script>
</body>
</html>
