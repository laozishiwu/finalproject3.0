<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/19 0019
  Time: 上午 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="dgLog"></table>

<script type="text/javascript">
    $(function () {
        $('#dgLog').datagrid({
            url: '${pageContext.request.contextPath}/log/showAll.do',
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'content', title: '日志信息', width: 500},
            ]]
        })


    });

</script>
