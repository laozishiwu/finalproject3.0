<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/11 0011
  Time: 下午 3:12
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
<div id="addViewpager" style="display: none;">
    <div style="width: 88%;height: 90%;border: white solid 2px;margin: 2% auto;">
        <div style="float: left;width: 300px;height: 80%;border: lavender solid 2px;margin: 5% 1.5%;">
            <form id="upFom1" method="post" enctype="multipart/form-data">
                <div style="border: lavender solid 2px;width: 90%;height:70%;margin: auto;">
                    <img alt="头像" src="" style="width: 100%;height:100%" id="img">
                </div>
                <input type="file" name="srcFile"/>
                <a id="upload" class="easyui-linkbutton" name="srcFile" onclick="upFile(this);">上传</a>
            </form>
        </div>
        <div style="float: left;width: 300px;height: 80%;border: lavender solid 2px;margin: 5% 1.5%;padding: 20% auto;text-align: center;">
            <form id="upFom2" method="post" enctype="multipart/form-data">
                <h1 style="color: #00bbee">添加主页轮播图</h1>
                图片描述：
                <input class="easyui-textbox" name="description" data-options="iconCls:'icon-search'"
                       style="width:200px">
                <br/>
                <br/>
                <br/>
                <br/>
                图片状态:
                <select id="cc" class="easyui-combobox" name="status" style="width:200px;">
                    <option></option>
                    <option value="y">y</option>
                    <option value="n">n</option>
                </select>
                <br/>
                <br/>
                <br/>
                <br/>
                <input type="button" onclick="upFile2();" value="确认"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置"/>
            </form>
        </div>
    </div>
</div>

<div id="pager" style="background:#efefef;border:1px solid #ccc;"></div>


<script type="text/javascript">
    $(function () {

        $('#dg').datagrid({
            height: '100%',
            width: '100%',
            url: '${pageContext.request.contextPath}/view/showByPage.do',
            fitColumns: true,// 当所有列的宽度总和 超过表格总宽， 会自适应
            rownumbers: true,// 显示行号
            pagination: true,
            pagePosition: 'both',
            pageList: [1, 3, 5, 10],
            pageSize: 3,
            columns: [[
                {field: '选项框', title: '选项框', checkbox: true,},
                {field: 'id', title: '编号', align: 'center', width: 100,},
                {field: 'description', title: '图片描述', width: 100, align: 'center'},
                {field: 'status', title: '图片状态', width: 100, align: 'center'},
                {field: 'credate', title: '上传时间', width: 100, align: 'center'},
                {field: 'updates', title: '修改时间', width: 100, align: 'center',},
                {
                    field: 'src', title: '图片预览', width: 100, align: 'center',
                    formatter: function (value, row, index) {
                        return '<img style="width:200px;height:100px;" src="${pageContext.request.contextPath}' + value + '"/>';
                    }
                },
                {
                    field: '操作', title: '操作', width: 100, align: 'center',
                    formatter: function (value, row, index) {
                        var temp = JSON.stringify(row).replace(/\"/g, "'");
                        return '<a class="del"  style="color: darkblue;" onclick="del(' + temp + ')"> 删除 </a>';
                    }
                },
            ]],
            striped: true,
            toolbar: [{
                iconCls: 'icon-add',
                text: '添加',
                width: 60,
                handler: function () {
                    $('#addViewpager').window({
                        width: 800,
                        height: 400,
                        modal: true,
                        colsed: false,
                        title: '添加轮播图',
                    });
                }
            }, '---', {
                iconCls: 'icon-edit',
                text: '修改',
                width: 60,
                handler: function () {
                    alert('该功能未上线');
                }
            }, '---', {
                iconCls: 'icon-help',
                text: '帮助',
                width: 60,
                handler: function () {
                    alert('此功能在维护中。。。')
                }
            }],
            onLoadSuccess: function () {
                $('.del').linkbutton({
                    iconCls: 'icon-no',
                    width: 60,
                    height: 30,
                });
            }
        });
        $('#upload').linkbutton({
            width: '100%',
            height: 20,
        });
        $('#upFom1').form({
            url: '${pageContext.request.contextPath}/view/uploadFile.do',
            onSubmit: function () {
                // do some check
                // return false to prevent submit;
                return true;
            },
            ajax: true,
            success: function (viewpager) {
                var viewpager = JSON.parse(viewpager);
                id = viewpager.id;
                $('#img').prop('src', "${pageContext.request.contextPath}" + viewpager.src);
            }
        });
        $('#upFom2').form({
            url: '${pageContext.request.contextPath}/view/uploadFile2.do',
            onSubmit: function (param) {
                param.id = id;
                // do some check
                // return false to prevent submit;
                return true;
            },
            ajax: true,
            success: function (data) {
                if (data == 'success') {
                    $('#addViewpager').window('close', {
                        onBeforeClose: function () {
                            return false;
                        },
                    });
                    $('#dg').datagrid('reload');
                }
            }
        });

    });
    var id;

    function del(viewpager) {
        $.ajax({
            url: '${pageContext.request.contextPath}/view/remove.do',
            type: 'POST',
            data: 'id=' + viewpager.id + '&status=' + viewpager.status,
            dataType: 'json',
            success: function (data) {
                if (data == 'success') {
                    $('#dg').datagrid('reload');
                }
            }
        });
    };

    function upFile() {
        $('#upFom1').submit();
    };

    function upFile2() {
        $('#upFom2').submit();
        $('#img').prop('src', '');
        $('#upFom1').form('reset');
        $('#upFom2').form('reset');
    };


</script>
</body>
</html>
