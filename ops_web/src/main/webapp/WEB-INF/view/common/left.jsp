<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/12
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">

            <li>
                <a class="active-menu" href="../../../index.jsp"><i class="fa fa-dashboard"></i> 导航菜单</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-sitemap"></i>监控管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/main/ipList">服务器管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/main/interfaceList">接口地址管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/main/taskList">接口检测任务管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-sitemap"></i>报表管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/export/index">数据导出</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
            </li>
        </ul>

    </div>

</nav>

</body>
</html>
