<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/14 0014
  Time: 下午 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table id="dgMaster"></table>

<script type="text/javascript">
    $(function () {
        $('#dgMaster').datagrid({
            url: '${pageContext.request.contextPath}/master/showAll.do',
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'faname', title: '上师名字', width: 100},
                {
                    field: 'imgsrc', title: '上师头像', width: 500, align: 'center',
                    formatter: function (value, row, index) {
                        return '<img style="width:200px;height:100px;" src="${pageContext.request.contextPath}/back/shangshi/' + value + '"/>';
                    }
                }
            ]]
        })


    });

</script>
