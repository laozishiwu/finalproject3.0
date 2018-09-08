<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/17 0017
  Time: 下午 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/static/themes/icon.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/back/static/themes/default/easyui.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/back/static/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/static/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/static/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/static/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="dg"></table>
<form id="exportOutAll" style="display: none;"></form>
<script type="text/javascript">
    $(function () {
        $('#dg').datagrid({
            height: '100%',
            width: '100%',
            url: '${pageContext.request.contextPath}/user/showAll.do',
            fitColumns: true,
            columns: [[
                {field: 'id', title: '编号', align: 'center', width: 100,},
                {field: 'realname', title: '真实姓名', width: 100, align: 'center'},
                {field: 'fahao', title: '法号', width: 100, align: 'center'},
                {field: 'email', title: '邮箱', width: 100, align: 'center'},
                {field: 'mobile', title: '电话', width: 100, align: 'center',},
                {field: 'sex', title: '性别', width: 100, align: 'center',},
                {field: 'addr', title: '所在地区', width: 100, align: 'center',},
                {field: 'status', title: '状态', width: 100, align: 'center',},
                {field: 'registDate', title: '注册时间', width: 100, align: 'center',},
                {field: 'loginDate', title: '登陆时间', width: 100, align: 'center',},
                {
                    field: 'src', title: '图片预览', width: 100, align: 'center',
                    formatter: function (value, row, index) {
                        return '<img style="width:200px;height:100px;" src="${pageContext.request.contextPath}' + value + '"/>';
                    }
                },
            ]],
            striped: true,
            toolbar: [{
                iconCls: 'icon-print',
                text: '全部导出',
                width: 100,
                handler: function () {
                    $.messager.confirm('确认对话框', '您想要导出所有数据吗？', function (r) {
                        if (r) {
                            // 导出操作;
                            $('#exportOutAll').form('submit', {
                                url: '${pageContext.request.contextPath}/user/exportOutAll.do',
                            })
                        }
                    });
                }
            }, '---', {
                iconCls: 'icon-edit',
                text: '自定义导出',
                width: 100,
                handler: function () {
                    $("#dd").dialog({
                        closed: false,
                    })
                }
            }, '---', {
                iconCls: 'icon-pencil',
                text: '导入',
                width: 60,
                handler: function () {
                    $('#excleIn').window({
                        width: 600,
                        height: 400,
                        modal: true
                    });

                }
            }],
        });
        $('#exportIn').form('submit', {
            url: "${pageContext.request.contextPath}/user/importExcel.do",
            success: function () {
                $('#exportIn').form('reset');
                $('#excleIn').window('close');
                $('#dg').datagrid('reload');    // 重新载入当前页面数据
            }
        })
    });

</script>
<div id="excleIn" style="display:none;">
    <form id="exportIn" method="post" enctype="multipart/form-data">
        <input name="multipartFile" class="easyui-filebox" style="width:300px">
    </form>
    <a id="importExcle"
       class="easyui-linkbutton" data-options="iconCls:'icon-search'">导入数据</a>
</div>

<div id="dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="fff" method="post">
        <select id="cc" class="easyui-combotree" style="width:200px;"
                data-options="url:'get_data.php',required:true"></select>
    </form>
    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a>
</div>


<script>
    $('#importExcle').click(function () {
        $('#exportIn').form('submit');
    });
    $('#cc').combotree({
        url: '${pageContext.request.contextPath}/back/json/userFiledsData.json',
        required: true,
        checkbox: true,
        onlyLeafCheck: true,
        multiple: true,
    });
    $("#btn").click(function () {
        //获取combotree的选中信息
        var content = $("#cc").combotree("getText");
        console.log(content);
        var vals = $("#cc").combotree("getValues");
        var ss = "";
        $.each(vals, function (index, filed) {
            if (index < vals.length - 1) {
                ss += filed + ",";
            } else {
                ss += filed;
            }

        })
        //提交form表单
        $("#fff").form("submit", {
            url: "${pageContext.request.contextPath}/user/export.do",
            queryParams: {"content": content, "fields": ss}
        });
    });
</script>
</body>
</html>
