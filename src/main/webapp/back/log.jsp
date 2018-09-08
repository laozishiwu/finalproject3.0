<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
    <title>日志列表</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/icon.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/default/easyui.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/IconExtension.css">
</head>
<body>
<table id="loglistdg"></table>

<script type="text/javascript">
    $(function () {
        $("#loglistdg").datagrid({
            url: "${pageContext.request.contextPath }/log/queryBypage.do",
            fitColumns: true,
            fit: true,
            striped: true,
            loadMsg: "玩命加载中............",
            rownumbers: true,
            singleSelect: true,
            nowrap: false,
            pagination: true,
            pageSize: 10,
            pageList: [10, 20, 30],
            columns: [[
                {field: "id", title: "编号", align: "center", width: 100},
                {field: "manager", title: "操作者", align: "center", width: 80},
                {field: "content", title: "操作内容", align: "center", width: 400},
                {field: "operatetime", title: "操作日期", align: "center", width: 80},
                {field: "operatetype", title: "操作类型", align: "center", width: 50},
            ]],
        });
    });


</script>
</body>
</html>