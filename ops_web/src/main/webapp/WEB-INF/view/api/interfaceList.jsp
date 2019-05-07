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

</head>
<body>




    <!-- 站点  -->

    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        接口地址管理<small> Address Management</small>
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
                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">添加接口地址</button>

                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">

                                <!-- 添加接口地址模态框（Modal） -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">添加接口地址信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="form1" action="" method="post">
                                                    <div class="form-group">
                                                        <label>端口</label>
                                                        <input id="port" class="form-control" name="it_port">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>接口地址</label>
                                                        <input id="address" class="form-control" name="it_address">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>详细信息</label>
                                                        <input id="detail" class="form-control" name="it_detail">
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
                                                <h4 class="modal-title" id="updateModalLabel">修改接口地址信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="update_form" action="" method="post">
                                                    <input  id="update_id" type="hidden" name="it_id" value=""/>
                                                    <div class="form-group">
                                                        <label>端口</label>
                                                        <input id="update_port" class="form-control" name="it_port" value="" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label>接口地址</label>
                                                        <input id="update_address" class="form-control" name="it_address" value="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>详细信息</label>
                                                        <input id="update_detail" class="form-control" name="it_detail" value="">
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


                                <!--查看详情模态框(modal) -->
                                <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="detailModalLabel">接口地址信息</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form id="detail_form" action="" method="post">
                                                    <div class="form-group">
                                                        <label>端口</label>
                                                        <div id="detail_port"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>接口地址</label>
                                                        <div id="detail_address"></div>
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
            url : "getInterfaceList",
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
                    field : 'it_id',
                    title : 'it_id'
                },
                {
                align : "center",
                halign : "center",
                valign : "middle",
                field : 'it_port',
                title : '端口'

            }, {
                align : "center",
                halign : "center",
                valign : "middle",
                field : 'it_address',
                title : '接口地址'
            }, {
                align : "center",
                halign : "center",
                valign : "middle",
                field : 'it_detail',
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
                field : 'it_create_time',
                title : '创建时间'
            },{
                align : "center",
                halign : "center",
                valign : "middle",
                field : 'it_update_time',
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
        $('#table_server').bootstrapTable('hideColumn', 'it_id');
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
        var update = '<button type="button"   class="btn btn-success btn-xs"  data-toggle="modal" data-target="#updateModal" onclick="show_update(\'' + row.it_id  + '\',\'' + row.it_port  + '\',\'' + row.it_address  + '\',\'' + row.it_detail + '\')">修改</button>';
        var detail = '<button type="button" style="margin-left:10px;" class="btn btn-xs btn-green-yhr"  data-toggle="modal" data-target="#detailModal" onclick="show_detail(\'' + row.it_port  + '\',\'' + row.it_address  + '\',\'' + row.it_detail + '\',\'' + row.it_create_time + '\',\'' + row.it_update_time+ '\')" >查看详情</button>';
        var del = '<button type="button" style="margin-left:10px;" class="btn btn-danger btn-xs"  data-toggle="modal" data-target="#deleteModal" onclick="show_delete('+  row.it_id + ')">删除</button>';
        return update+del+detail;
    }
    //详情悬浮窗
    function paramsMatter(value, row, index) {
        var values = row.it_detail;//获取当前字段的值
        //替换空格，因为字符串拼接的时候如果遇到空格，会自动将后面的部分截掉，所有这里用html的转义符
        // 代替
        values = values.replace(/\s+/g,' ')
        return "<span title="+values+">"+row.it_detail+"</span>"
    }




    //新增
    function save(src) {
        $.post("saveInterface",$("#form1").serializeArray(),
            function(result){
                if(result == "提交成功"){
                    alert('提交成功');
                    window.location.replace("${ctx}/main/interfaceList");
                }else{
                    alert('提交失败，请联系管理员');
                }
                $("#port").val("");
                $("#address").val("");
                $("#detail").val("");
                $("#myModal").modal('hide');

            }
        );
    }

    //修改信息填充
    $("#updateModal").modal("hide");
    function show_update(it_id,it_port,it_address,it_detail){
            $('#update_id').val(it_id);
            $('#update_port').val(it_port);
            $('#update_address').val(it_address);
            $('#update_detail').val(it_detail);


    }


    //更新
    function update(src){
        $.post("updateInterface",$("#update_form").serializeArray(),
            function(result){
                if(result == "更新成功"){
                    alert('更新成功');
                    window.location.replace("${ctx}/main/interfaceList");
                }else{
                    alert('更新失败，请联系管理员');
                }
            });

    }


    //删除
    function show_delete(it_id){
              var delet=document.getElementById("delete");
              delet.onclick=function(){
                  $.post("deleteInterface",{it_id:it_id},
                      function(result){
                          if(result == "删除成功"){
                              alert("删除成功");
                              window.location.replace("${ctx}/main/interfaceList");
                          }else{
                              alert("删除失败，请联系管理员");
                          }
                      });
              }

    }


    //详细信息显示
    function show_detail(it_port,it_address,it_detail,it_create_time,it_update_time){
        $('#detail_port').html(it_port);
        $('#detail_address').html(it_address);
        $('#detail_detail').html(it_detail);

        $('#detail_create_time').html(it_create_time);
        $('#detail_update_time').html(it_update_time);
    }



</script>
<!-- Custom Js -->
<script src="${ctx}/assets/js/custom-scripts.js"></script>


</body>
</html>
