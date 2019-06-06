<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/30
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>OpsManage</title>
    <!-- Bootstrap Styles-->
    <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${ctx}/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${ctx}/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${ctx}/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>

<!-- 站点 -->
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h1 class="page-header">
                    仪表盘<small> Dashboard</small>
                </h1>
            </div>
        </div>
        <c:forEach items="${serverList}" var="serverIp">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div id="title">服务器IP: ${serverIp.serverIp.sv_ip}</div>
                </div>
                <div class="panel-body">
                    <div id="main1${serverIp.ssh_id}" style="width: 400px;height:400px; float:left; display:inline"></div>
                    <div id="main2${serverIp.ssh_id}" style="width: 400px;height:400px; float:left; display:inline"></div>
                    <div id="main3${serverIp.ssh_id}" style="width: 400px;height:400px; float:left; display:inline"></div>
                </div>
            </div>

        </div>
        </c:forEach>


    </div>
</div>

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
<!-- Morris Chart Js -->
<script src="${ctx}/assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="${ctx}/assets/js/morris/morris.js"></script>
<!-- Custom Js -->
<script src="${ctx}/assets/js/custom-scripts.js"></script>
<script src="${ctx}/assets/js/echart.js"></script>
<script>


        $.ajax({
            contentType : "application/json;charset=utf-8",
            type : "GET",
            url : "${ctx}/main/serverMessage",
            dataType : "json",
            success : function(list) {
                $.each(list,function (i,data) {
                    var pie1=new Array();
                    var obj=new Object();
                    obj.name="已使用";
                    obj.value=data.systemMessage.cpuUse;
                    var obj2=new Object();
                    obj2.name="未使用";
                    obj2.value=data.systemMessage.cpuFree;
                    pie1.push(obj);
                    pie1.push(obj2);
                    var id1='main1'+data.ssh_id
                    var myChart1 = echarts.init(document.getElementById(id1));
                    option1 = {
                        title : {
                            text: 'CPU',       //大标题
                            x:'center'                 //标题位置   居中
                        },
                        tooltip : {
                            trigger: 'item',           //数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。
                            formatter: "{a} <br/>{b} : {c} ({d}%)"   //{a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）用于鼠标悬浮时对应的显示格式和内容
                        },
                        legend: {                           //图例组件。
                            orient: 'vertical',             //图例列表的布局朝向
                            left: 'left',
                            data: ['已使用','未使用']
                        },
                        series : [              //系列列表。每个系列通过 type 决定自己的图表类型
                            {
                                name: '访问来源',
                                type: 'pie',
                                radius : '55%',
                                center: ['50%', '60%'],
                                data:pie1,
                                // data:[
                                //     {value:335, name:'已使用'},
                                //     {value:310, name:'未使用'}
                                // ],
                                itemStyle: {
                                    emphasis: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ],
                        color: ['rgb(255,106,106)','rgb(60,179,113)']
                    };
                    myChart1.setOption(option1);

                    var pie2=new Array();
                    var obj3=new Object();
                    var obj4=new Object();
                    var obj5=new Object();
                    obj3.name="已使用";
                    obj3.value=data.systemMessage.memUse;
                    obj4.name="未使用";
                    obj4.value=data.systemMessage.memFree;
                    obj5.name="缓存";
                    obj5.value=data.systemMessage.memCache;
                    pie2.push(obj3);
                    pie2.push(obj4);
                    pie2.push(obj5);
                    var id2='main2'+data.ssh_id
                    var myChart2 = echarts.init(document.getElementById(id2));
                    option2 = {
                        title : {
                            text: '内存',       //大标题
                            x:'center'                 //标题位置   居中
                        },
                        tooltip : {
                            trigger: 'item',           //数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。
                            formatter: "{a} <br/>{b} : {c} ({d}%)"   //{a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）用于鼠标悬浮时对应的显示格式和内容
                        },
                        legend: {                           //图例组件。
                            orient: 'vertical',             //图例列表的布局朝向
                            left: 'left',
                            data: ['已使用','未使用','缓存']
                        },
                        series : [              //系列列表。每个系列通过 type 决定自己的图表类型
                            {
                                name: '访问来源',
                                type: 'pie',
                                radius : '55%',
                                center: ['50%', '60%'],
                                data: pie2,
                                // data:[
                                //     {value:335, name:'已使用'},
                                //     {value:310, name:'未使用'},
                                //     {value:1, name:'缓存'}
                                // ],
                                itemStyle: {
                                    emphasis: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ],
                        color: ['rgb(255,106,106)','rgb(60,179,113)','rgb(135,206,235)']
                    };
                    myChart2.setOption(option2);

                    var pie3=new Array();
                    var obj6=new Object();
                    obj6.name="已使用";
                    obj6.value=data.systemMessage.diskUse;
                    var obj7=new Object();
                    obj7.name="未使用";
                    obj7.value=data.systemMessage.diskFree;
                    pie3.push(obj6);
                    pie3.push(obj7);
                    var id3='main3'+data.ssh_id
                    var myChart3 = echarts.init(document.getElementById(id3));
                    option3 = {
                        title : {
                            text: '磁盘',       //大标题
                            x:'center'                 //标题位置   居中
                        },
                        tooltip : {
                            trigger: 'item',           //数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。
                            formatter: "{a} <br/>{b} : {c} ({d}%)"   //{a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）用于鼠标悬浮时对应的显示格式和内容
                        },
                        legend: {                           //图例组件。
                            orient: 'vertical',             //图例列表的布局朝向
                            left: 'left',
                            data: ['已使用','未使用']
                        },
                        series : [              //系列列表。每个系列通过 type 决定自己的图表类型
                            {
                                name: '访问来源',
                                type: 'pie',
                                radius : '55%',
                                center: ['50%', '60%'],
                                data: pie3,
                                // data:[
                                //     {value:335, name:'已使用'},
                                //     {value:310, name:'未使用'}
                                // ],
                                itemStyle: {
                                    emphasis: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ],
                        color: ['rgb(255,106,106)','rgb(60,179,113)']
                    };
                    myChart3.setOption(option3);
                })
            },
            error:function(){
                console.log("error")
            }
        });








</script>
</body>
</html>
