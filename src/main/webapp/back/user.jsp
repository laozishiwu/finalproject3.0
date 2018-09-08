<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Insert title here</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/icon.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/default/easyui.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/IconExtension.css">
</head>
<body>
<table id="userlistdg"></table>
<div id="adduserdiv" style="width: 350px;height: 250px;display: none">
    <form id="useraddform" method="post" enctype="multipart/form-data">
        <div style="font-family: 楷体;font-size: 25px;color: blue;position: absolute;left: 45px;top: 50px;">
            Excel批量导入用户信息
        </div>

        <div style="position: absolute;top: 130px;left: 50px;">
            <input class="easyui-filebox" name="file" style="width: 250px;"
                   data-options="label:'头像',labelWidth:'40px',buttonText:'选择Excel文档'">
        </div>
        <div style="position: absolute;top: 190px;left: 145px;">
            <a id="exceladdsub" style="width: 80px;height: 27px;" class="easyui-linkbutton"
               data-options="text:'提交',iconCls:'icon-image_star'"></a>
            <a id="exceladdclo" style="width: 80px;height: 27px;margin-left: 10px;" class="easyui-linkbutton"
               data-options="text:'关闭',iconCls:'icon-html_delete'"></a>
        </div>
    </form>
</div>
<script type="text/javascript">
    $(function () {
        $("#exceladdsub").click(function () {
            $("#useraddform").form("submit", {
                url: "${pageContext.request.contextPath }/poi/Import.do",
                success: function (data) {
                    $("#userlistdg").datagrid("reload");
                    $("#adduserdiv").dialog("close");
                }
            });
        });
        $("#exceladdclo").click(function () {
            $("#adduserdiv").dialog("close");
        });
    });
    $("#userlistdg").datagrid({
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
        onLoadSuccess: function () {
            $(".userdown").linkbutton({
                text: "删除",
                iconCls: "icon-image_delete",
            });
        },
        toolbar: [{
            text: "导出Excel表格",
            width: "110px",
            height: "28px",
            iconCls: "icon-group_add",
            handler: function () {
                $(location).prop("href", "${pageContext.request.contextPath}/poi/Export.do");

            }
        }, {
            text: "Excel导入",
            width: "110px",
            height: "28px",
            iconCls: "icon-group_add",
            handler: function () {
                $("#adduserdiv").dialog({
                    title: "批量添加用户",
                    closeable: true

                });
            }
        }, {
            text: "删除选择",
            width: "110px",
            height: "28px",
            iconCls: "icon-book_addresses_delete",
            handler: function () {
                if ($("#userlistdg").datagrid("getChecked") == null || $("#userlistdg").datagrid("getChecked").length == 0) {
                    $.messager.alert('警告', '请指示选择一个用户！', 'warning');
                } else {
                    $.messager.confirm('删除对话框', '您想要删除选择的用户吗？', function (r) {
                        if (r) {
                            var idss = new Array();
                            $.each($("#userlistdg").datagrid("getChecked"), function (index, item) {
                                idss[index] = item.id;
                            });
                            var aa = JSON.stringify(idss);
                            console.log(aa);
                            $.ajax({
                                // headers必须添加，否则会报415错误

                                contentType: 'application/json',
                                type: "post",
                                data: aa,
                                url: "${pageContext.request.contextPath}/user/delete.do",
                                async: true,
                                dataType: "json",
                                beforeSend: function () {

                                },
                                success: function (result) {
                                    if (result == "success") {
                                        $("#userlistdg").datagrid("reload");
                                    } else {
                                        $.messager.alert('错误', '您没有该权限删除！', 'error');
                                    }

                                },
                                error: function () {
                                    $.messager.alert('错误', '您没有该权限删除！', 'error');

                                }
                            });
                        }
                    });
                }
            }
        }],
    });

    function downuser(i) {
        $.post("${pageContext.request.contextPath}/user/removeuser.do", {id: i}, function (data) {
            $("#userlistdg").datagrid("reload");
        });
    }
</script>
</body>
</html>