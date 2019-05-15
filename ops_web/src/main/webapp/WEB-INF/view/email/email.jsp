<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 17:13
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

</head>
<body>




<!-- 站点  -->

<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h1 class="page-header">
                    报警管理<small> Email Management</small>
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
                        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">添加报警人</button>

                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">

                            <!-- 添加报警人模态框（Modal） -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">添加报警人信息</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form id="form1" action="" method="post">
                                                <div class="form-group">
                                                    <label>邮箱</label>
                                                    <input id="email_address" class="form-control" name="email_address">
                                                </div>
                                                <div class="form-group">
                                                    <label>姓名</label>
                                                    <input id="email_username" class="form-control" name="email_username">
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

                            <!--修改报警人模态框(modal) -->
                            <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="updateModalLabel">修改报警人信息</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form id="update_form" action="" method="post">
                                                <input  id="update_id" type="hidden" name="email_id" value=""/>
                                                <div class="form-group">
                                                    <label>邮箱</label>
                                                    <input id="update_address" class="form-control" name="email_address" value="" >
                                                </div>
                                                <div class="form-group">
                                                    <label>姓名</label>
                                                    <input id="update_name" class="form-control" name="email_username" value="">
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button id="update_submit" type="button" class="btn btn-primary" onclick="update(this);">提交</button>
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

                            <!--报警人设置模态框(modal) -->
                            <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="detailModalLabel">报警人设置</h4>
                                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addModal" >添加检测地址</button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table" style="table-layout: fixed;" id="task_server">
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal -->
                            </div>

                            <!--报警人添加模态框(modal) -->
                            <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" >添加地址</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table" style="table-layout: fixed;" id="task_table">
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button id="update_task" type="button" class="btn btn-primary" >提交</button>
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
            url : "getEmailList",
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
            queryParames:queryParamsByBegin,
            columns : [
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'email_id',
                    title : 'email_id'
                },
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'email_address',
                    title : '邮箱'

                }, {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'email_username',
                    title : '姓名'
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
        $('#table_server').bootstrapTable('hideColumn', 'email_id');
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
        var update = '<button type="button"   class="btn btn-success btn-xs"  data-toggle="modal" data-target="#updateModal" onclick="show_update(\'' + row.email_id  + '\',\'' + row.email_address  + '\',\'' + row.email_username + '\')">修改</button>';
        var del = '<button type="button" style="margin-left:10px;" class="btn btn-danger btn-xs"  data-toggle="modal" data-target="#deleteModal" onclick="show_delete('+  row.email_id + ')">删除</button>';
        var detail = '<button type="button" style="margin-left:10px;" class="btn btn-xs btn-green-yhr"  data-toggle="modal" data-target="#detailModal" onclick="show_detail(\'' + row.email_id  + '\')" >报警人设置</button>';
        return update+del+detail;
    }




    //新增
    function save(src) {
        $.post("saveEmail",$("#form1").serializeArray(),
            function(result){
                if(result == "提交成功"){
                    alert('提交成功');
                    window.location.replace("${ctx}/email/emailList");
                }else{
                    alert('提交失败，请联系管理员');
                }
                $("#email_addreess").val("");
                $("#email_username").val("");
                $("#myModal").modal('hide');

            }
        );
    }

    //修改信息填充
    $("#updateModal").modal("hide");
    function show_update(email_id,email_address,email_name){
        $('#update_id').val(email_id);
        $('#update_name').val(email_name)
        $('#update_address').val(email_address);



    }


    //更新
    function update(src){
        $.post("updateEmail",$("#update_form").serializeArray(),
            function(result){
                if(result == "更新成功"){
                    alert('更新成功');
                    window.location.replace("${ctx}/email/emailList");
                }else{
                    alert('更新失败，请联系管理员');
                }
            });

    }


    //删除
    function show_delete(email_id){
        var delet=document.getElementById("delete");
        delet.onclick=function(){
            $.post("deleteEmail",{email_id:email_id},
                function(result){
                    if(result == "删除成功"){
                        alert("删除成功");
                        window.location.replace("${ctx}/email/emailList");
                    }else{
                        alert("删除失败，请联系管理员");
                    }
                });
        }

    }

    function show_detail(email_id){
        taskTable(email_id);
        taskTable2(email_id);
    }

    function taskTable(email_id){

        $('#task_server').bootstrapTable('destroy');
        $('#task_server').bootstrapTable({
            method: 'GET',
            // 若以post方式提交，需要补充contentType信息，否则分页参数无法传递到controller
            //contentType: "application/x-www-form-urlencoded",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            // 查询传入起始页码数，后台需要计算起始查询条数
            url : "getTaskListByEmail/"+email_id+"/false/",
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
            queryParames:queryParamsByBegin,
            columns : [
                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_id',
                    title : 'tsk_id'
                },{
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
                }, {
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
                },{
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : '',
                    title : '操作',
                    // 调用operateFormatter函数
                    formatter : function (value, row, index) {
                        var del = '<button type="button" style="margin-left:10px;" class="btn btn-danger btn-xs"  onclick="deleteTask(\'' + row.tsk_id  + '\',\'' + email_id  + '\')">删除</button>';
                        return del;
                    }
                }],


        });
        // 隐藏主键显示
        $('#task_server').bootstrapTable('hideColumn', 'tsk_id');
        $('#task_server').bootstrapTable('hideColumn', 'anInterface.it_port');
        $('#task_server').bootstrapTable('hideColumn', 'anInterface.it_address');
    }



    function deleteTask(tsk_id,email_id){
        $.post("deleteTaskByEmail/"+email_id+"/",{tsk_id:tsk_id},
            function(result){
                if(result == "删除成功"){
                    alert("删除成功");
                    window.location.replace("${ctx}/email/emailList");
                }else{
                    alert("删除失败，请联系管理员");
                }
            });
    }


    function taskTable2(email_id){

        $('#task_table').bootstrapTable('destroy');
        $('#task_table').bootstrapTable({
            method: 'GET',
            // 若以post方式提交，需要补充contentType信息，否则分页参数无法传递到controller
            //contentType: "application/x-www-form-urlencoded",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            // 查询传入起始页码数，后台需要计算起始查询条数
            url : "getTaskListByEmail/"+email_id+"/true/",
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
            queryParames:queryParamsByBegin,
            columns : [
                {   field : 'checked',
                    checkbox: true,
                    align: 'center',
                    valign: 'middle'
                },

                {
                    align : "center",
                    halign : "center",
                    valign : "middle",
                    field : 'tsk_id',
                    title : 'tsk_id'
                },{
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
                }, {
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
                }],


        });
        // 隐藏主键显示
        $('#task_table').bootstrapTable('hideColumn', 'tsk_id');
        $('#task_table').bootstrapTable('hideColumn', 'anInterface.it_port');
        $('#task_table').bootstrapTable('hideColumn', 'anInterface.it_address');
        $('#update_task').click(function () {
            submit_task(email_id);
        })
    }

   function submit_task(email_id){
       var a = $('#task_table').bootstrapTable('getSelections');//获取选择行数据
       var list=[];
       for (var i = 0; i < a.length; i++) {//循环读取选中行数据
           var tsk_id = a[i].tsk_id;//获取选择行的值
           list.push(tsk_id);
       }
       $.post("addTaskByEmail/"+email_id+"/",{list:JSON.stringify(list)},
           function(result){
               if(result == "提交成功"){
                   alert("提交成功");
                   window.location.replace("${ctx}/email/emailList");
               }else{
                   alert("提交失败，请联系管理员");
               }
           });


       <%--$.ajax({--%>
           <%--contentType: "application/json;charset=utf-8",--%>
           <%--type: "POST",--%>
           <%--url: "addTaskByEmail",--%>
           <%--dataType: 'json',--%>
           <%--data: "list="+JSON.stringify(list),--%>
           <%--traditional: true,--%>
           <%--success: function(result){--%>
               <%--if(result == "提交成功"){--%>
                   <%--alert('提交成功');--%>
                   <%--window.location.replace("${ctx}/email/emailList");--%>
               <%--}else{--%>
                   <%--alert('提交失败，请联系管理员');--%>
               <%--}--%>
           <%--}--%>

       <%--});--%>
   }
</script>
<!-- Custom Js -->
<script src="${ctx}/assets/js/custom-scripts.js"></script>


</body>
</html>