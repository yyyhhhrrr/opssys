<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/24
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<script src="${ctx}/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="${ctx}/assets/js/common.js" type="text/javascript"></script>
<%--<script src="${ctx}/resource/check.js" type="text/javascript"></script>--%>

<script type="text/javascript">
    function saveAnd(){
        if(window.opener.parent.parent != window.opener.parent){
            try{
                if(window.opener.location.href.indexOf('d-16544-p') == -1) {
                    window.opener.parent.document.forms[0].submit();

                } else {
                    window.opener.location.reload();
                }
            } catch(e){
                window.opener.document.forms[0].submit();
            }
        } else {
            try {

                window.opener.document.forms[0].submit();
            } catch(e){
                window.opener.location.reload();
            }
        }
        window.close();
    }
</script>