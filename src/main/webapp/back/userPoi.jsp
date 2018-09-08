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
            url: "${pageContext.request.contextPath }/user/queryBypage.do",
            fitColumns: true,
            striped: true,
            loadMsg: "玩命加载中............",
            rownumbers: true,
            singleSelect: false,
            pagination: true,
            fit: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            columns: [[
                {field: 'id', title: '编号', width: 88},
                {field: 'name', title: '姓名', width: 88},
                {field: 'dhamaname', title: '法号', width: 88},
                {
                    field: "img", title: "头像", width: 100, align: "center",
                    formatter: function (value, row, index) {
                        return "<img src=\"${pageContext.request.contextPath }" + value + "\" style='width:100px;height:100px'/>";
                    }
                },
                {field: 'sex', title: '性别', width: 88},
                {field: 'location', title: '籍贯', width: 88},
                {field: 'sign', title: '格言', width: 88},
                {field: 'phone', title: '手机', width: 88},
                {field: 'password', title: '密码', width: 88},
                {field: 'salt', title: '加密盐', width: 88},
                {
                    field: 'status', title: '状态', width: 88, editor: {
                        type: "text",
                        options: {
                            required: true
                        },
                    }
                },
                {field: 'registtime', title: '注册时间', width: 88},
                {
                    field: "dd", title: "操作", width: 50, align: "center",
                    formatter: function (value, row, index) {
                        return "<a class='userdown' onClick=\"downuser(\'" + row.id + "\')\"></a>";
                    }
                }
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
                                url: '${pageContext.request.contextPath}/user/Export.do',
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
            url: "${pageContext.request.contextPath}/user/Import.do",
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
        url: '${pageContext.request.contextPath}/back/filepoi/userFiledsData.json',
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
            url: "${pageContext.request.contextPath}/user/Export.do",
            queryParams: {"content": content, "fields": ss}
        });
    });
</script>
</body>
</html>