<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>OpsManage</title>
    <script src="${ctx}/assets/js/jquery-1.10.2.js"></script>
    <link rel="shortcut icon" href="${ctx}/assets/ico/apple-touch-icon-114-precomposed.png" type="image/x-icon">
    <link rel="stylesheet" href="${ctx}/assets/layui/css/layui.css">
    <link href="${ctx}/assets/css/font-awesome.css" rel="stylesheet" />
</head>
  <body class="layui-layout-body">
      <div class="layui-layout layui-layout-admin">
              <!--1.头部区域-->
              <div class="layui-header">
                <div class="layui-logo">OpsManage</div>
                <!-- 头部区域（可配合layui已有的水平导航） -->
                <ul class="layui-nav layui-layout-left">
                </ul>
                <ul class="layui-nav layui-layout-right">
                  <li class="layui-nav-item">
    <i class="fa fa-user fa-fw fa-lg"></i>
                    <dl class="layui-nav-child">
                      <dd><a href="">个人信息</a></dd>             
                    </dl>
                  </li>
    <li class="layui-nav-item">
        <i class="fa fa-gear fa-fw fa-lg"></i>
                         <dl class="layui-nav-child">
                          <dd><a href="">设置</a></dd>
                        </dl>
                 </li>
                  <li class="layui-nav-item">
    <i class="fa fa-times fa-fw fa-lg"></i>
                    <dl class="layui-nav-child">
                      <dd><a href="">退出</a></dd>             
                    </dl>
</li>
                </ul>
              </div>
                <!--2.左侧导航-->
              <div class="layui-side layui-bg-black">
                <div class="layui-side-scroll">
                  <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                  <ul class="layui-nav layui-nav-tree "  lay-filter="test">
    <li class="layui-nav-item ">
        <a href="javascript:;">监控管理</a>
        <dl class="layui-nav-child">
            <dd>
                <a class="site-demo-active leftdaohang" data-url="${ctx}/main/ipList" mytitle="服务器管理">服务器管理</a>
            </dd>
                              <dd>
            <a class="site-demo-active leftdaohang" data-url="${ctx}/main/interfaceList" mytitle="接口地址管理">接口地址管理</a>
        </dd>  
            <dd>
                <a class="site-demo-active leftdaohang" data-url="${ctx}/main/taskList" mytitle="接口检测任务管理">接口检测任务管理</a>
            </dd>            
        </dl>
    </li>      
    <li class="layui-nav-item">
        <a href="javascript:;">报表管理</a>
        <dl class="layui-nav-child">
            <dd>
                <a class="site-demo-active leftdaohang" data-url="${ctx}/export/index" mytitle="数据导出">数据导出</a>
            </dd>
        </dl>
    </li>  
    <li class="layui-nav-item">
        <a href="javascript:;">文档管理</a>
        <dl class="layui-nav-child">
            <dd>
                <a class="site-demo-active leftdaohang" data-url="${ctx}/swagger-ui.html" mytitle="swagger文档">swagger文档</a>
            </dd>
        </dl>
    </li>             
</ul>
                </div>
              </div>
              <!--3.右侧主体内容区-->
              <div class="layui-body">
                  <!--tabs标签-->
                  <div class="layui-tab layui-tab-card" lay-filter="demo" lay-allowclose="true">
                  <ul class="layui-tab-title">
                 <!--   <li class="layui-this">角色管理</li>-->
                  </ul>
                  <div class="layui-tab-content" style="height: 150px;">            
                  </div>
                </div> 
              </div>

               <!--4.底部固定区域-->
              <div class="layui-footer">
                <!-- 底部固定区域 -->
                © layui.com - 底部固定区域
              </div>
            </div>
<script src="${ctx}/assets/layui/layui.all.js"></script>
<script>
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            tabAdd: function(){
                //新增一个Tab项
                var htmlurl=$(this).attr('data-url');
                var mytitle=$(this).attr('mytitle');
//                  alert("触发tab增加事件："+mytitle);
                //先判断是否已经有了tab
                var arrayObj = new Array();　//创建一个数组  
                $(".layui-tab-title").find('li').each(function() {
                    var y = $(this).attr("lay-id");
                    arrayObj.push(y);
                });
//                    alert("遍历取到的数组："+arrayObj);
                var have=$.inArray(mytitle, arrayObj);  //返回 3,
                if (have>=0) {
                    //tab已有标签
//                        alert("遍历的已有标签："+mytitle);
                    element.tabChange('demo', mytitle); //切换到当前点击的页面
                } else{
                    //没有相同tab
//                      alert("遍历的没有相同tab："+mytitle);
                    element.tabAdd('demo', {
                        title:mytitle //用于演示
                        ,content: '<iframe style="width: 100%;height: 500%;" scrolling="no" src='+htmlurl+' ></iframe>'
                        ,id: mytitle //实际使用一般是规定好的id，这里以时间戳模拟下
                    })
                    element.tabChange('demo', mytitle); //切换到当前点击的页面
                }
            }

        };
        $(".leftdaohang").click(function(){
            var type="tabAdd";
            var othis = $(this);
//                var htmlurl=$(this).attr('data-url');
//                var mytitle=$(this).attr('mytitle');
            active[type] ? active[type].call(this, othis) : '';
        });

    });
</script>   
</body>
</html>
