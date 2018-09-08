<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <title>专辑列表</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/icon.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/default/easyui.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/IconExtension.css">
</head>
<body>
<table id="albumlistdg"></table>
<div id="addalbumdiv" style="width: 650px;height: 500px;display: none">
    <form id="albumaddform" method="post" enctype="multipart/form-data">
        <div style="font-family: 楷体;font-size: 30px;color: blue;position: absolute;left: 240px;top: 40px;">
            添加专辑信息
        </div>

        <div style="width: 180px;height: 180px;position: absolute;top: 95px;left: 400px;">
            <img id="albumimg" style="width: 100%;height: 100%" src="${pageContext.request.contextPath }/img/car02.jpg">
        </div>

        <div style="position: absolute;top: 290px;left: 350px;">
            <input class="easyui-filebox" name="albumimg" style="width: 260px;"
                   data-options="label:'头像',labelWidth:'60px',buttonText:'选择图片'">
        </div>

        <div style="position: absolute;top: 330px;left: 350px;">
            <!-- <input class="easyui-textbox" name="grade" style="width: 260px;"> -->
            <select class="easyui-combobox" name="grade" style="width: 260px;"
                    data-options="label:'星级',labelWidth:'60px'">
                <option value="1">1颗星</option>
                <option value="2">2颗星</option>
                <option value="3">3颗星</option>
                <option value="4">4颗星</option>
                <option value="5">5颗星</option>
            </select>
        </div>
        <div style="position: absolute;top: 90px;left: 40px;">
            <label for="id">id:</label>
            <input class="easyui-textbox" id="id" name="id" style="width: 260px;"
                   data-options="label:'编 号:',labelWidth:'60px'">
        </div>

        <div style="position: absolute;top: 90px;left: 40px;">
            <label for="title">title:</label>
            <input class="easyui-textbox" id="title" name="title" style="width: 260px;"
                   data-options="label:'标 题:',labelWidth:'60px'">
        </div>

        <div style="position: absolute;top: 130px;left: 40px;">
            <label for="author">author:</label>
            <input class="easyui-textbox" id="author" name="author" style="width: 260px;"
                   data-options="label:'作 者:',labelWidth:'60px'">
        </div>

        <div style="position: absolute;top: 170px;left: 40px;">
            <label for="broadCast">broadCast:</label>
            <input class="easyui-textbox" id="broadCast" name="broadCast" style="width: 260px;"
                   data-options="label:'播 音:',labelWidth:'60px'">
        </div>


        <div style="position: absolute;top: 210px;left: 40px;">
            <label for="pubshtime">pubshtime:</label>
            <input class="easyui-datebox" id="pubshtime" name="pubshtime" style="width: 260px;"
                   data-options="label:'发布日期:',labelWidth:'60px'">
        </div>

        <div style="position: absolute;top: 250px;left: 40px;">
            <label for="brief">brief:</label>
            <input class="easyui-textbox" id="brief" name="brief" style="width: 260px;height: 110px;"
                   data-options="label:'内容简介',labelWidth:'60px',multiline:true">
        </div>

        <div style="position: absolute;top: 390px;left: 330px;">
            <a id="albumaddsub" style="width: 100px;height: 27px;" class="easyui-linkbutton"
               data-options="text:'提交',iconCls:'icon-image_star'"></a>
            <a id="albumaddclo" style="width: 100px;height: 27px;margin-left: 40px;" class="easyui-linkbutton"
               data-options="text:'关闭',iconCls:'icon-html_delete'"></a>
        </div>
    </form>
</div>
<script type="text/javascript">
    $.fn.datebox.defaults.formatter = function (date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + "-" + m + "-" + d;
    };

    $("#albumlistdg").datagrid({
        url: "${pageContext.request.contextPath }/special/queryBypage.do",
        fitColumns: true,
        striped: true,
        loadMsg: "玩命加载中............",
        rownumbers: true,
        singleSelect: true,
        pagination: true,
        pageSize: 3,
        fit: true,
        pageList: [3, 5, 10, 15],
        columns: [[
            {field: "id", title: "编号", width: 100, align: "center"},
            {field: "title", title: "专辑名", width: 100, align: "center"},
            {field: "count", title: "集数", width: 100, align: "center"},
            {
                field: "coverImg", title: "图片", width: 100, align: "center",
                formatter: function (value, row, index) {
                    return "<img src=\"${pageContext.request.contextPath }/special" + value + "\" style='width:100px;height:100px'/>";
                }
            },
            {
                field: "stars", title: "星级", width: 100, align: "center",
                formatter: function (value, row, index) {
                    var content = "";
                    for (var i = 0; i < value; i++) {
                        content += "<img src='${pageContext.request.contextPath}/images/star.png'>";
                    }
                    return content;
                }
            },
            {field: "author", title: "作者", width: 100, align: "center"},
            {field: "broadCast", title: "播音员", width: 100, align: "center"},
            {field: "brief", title: "简介", width: 100, align: "center"},
            {field: "creattime", title: "创建时间", width: 100, align: "center"},
            {field: "pubshtime", title: "上架时间", width: 100, align: "center"},
            {
                field: "dd", title: "操作", width: 100, align: "center",
                formatter: function (value, row, index) {
                    return "<a class='detalalbum' onClick=detalalbum('" + row.id + "','" + row.title + "','" + row.count + "')></a>" +
                        "<a class='modifyalbum' onClick=modifyalbum('" + row.id + "')></a>";
                }
            }
        ]],
        onLoadSuccess: function () {
            $(".detalalbum").linkbutton({
                text: "详情",
                iconCls: "icon-application_osx_link",

            });
            $(".modifyalbum").linkbutton({
                text: "删除",
                iconCls: "icon-image_delete",
            });
        },
        toolbar: [{
            text: "添加专辑",
            width: "110px",
            height: "28px",
            iconCls: "icon-group_add",
            handler: function () {
                $("#addalbumdiv").dialog({
                    title: "添加专辑",
                    closeable: true
                });
            }
        }],
    });

    $(function () {
        $("#albumaddsub").click(function () {
            $("#albumaddform").form("submit", {
                url: "${pageContext.request.contextPath }/special/add.do",
                success: function (data) {
                    alert(data);
                    $("#albumlistdg").datagrid("reload");
                    $("#addalbumdiv").dialog("close");
                }
            });
        });
        $("#albumaddclo").click(function () {
            $("#addalbumdiv").dialog("close");
        });

    });

    function detalalbum(i, n, j) {
        addTab(n, "icon-application_side_list", "/back/sing.jsp?id=" + i + "&count=" + j);
    }

    function modifyalbum(i) {
        $.messager.confirm("删除确认框", "您确定要删除该专辑吗?", function (r) {
            if (r) {
                $.post("${pageContext.request.contextPath }/special/update.do", {id: i, status: "up"}, function () {
                    $.messager.show({
                        title: "删除信息",
                        msg: "成功删除专辑,可在专辑回收站中找回该专辑...",
                        timeout: 3000,
                        showType: 'slide'
                    });
                    $("#albumlistdg").datagrid("reload");
                    if ($("#centertabs").tabs("exists", "专辑回收站")) {
                        $("#deletealbumlistdg").datagrid("reload");
                    }
                });
            }
        });
    }

</script>
</body>
</html>