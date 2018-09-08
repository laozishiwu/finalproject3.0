<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>

<html>
<head>
    <script type="text/javascript" src="${path }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path }/js/jquery.easyui.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${path }/css/themes/default/easyui.css">
    <link type="text/css" rel="stylesheet" href="${path }/css/themes/icon.css">
</head>
<body>
<script type="text/javascript">
    $(function () {
        // 定制数据表格
        $('#tt').datagrid({
            title: '<a style="color:red" href="${pageContext.request.contextPath}/back/main.jsp">城市信息概况</a>',
            fitColumns: true,// 自动计算适应列宽
            width: 800,
            method: 'post',
            url: '${path}/city/findByPage.do', // 加载远程数据
            columns: [[
                {field: 'ck', checkbox: true, width: 100},
                {field: 'id', title: 'ID', width: 100},
                {field: 'name', title: 'NAME', width: 100},
                {field: 'url', title: 'URL', width: 100},
                {field: 'leaf', title: 'LEAF', width: 100},
                {field: 'parentId', title: 'PARENTID', width: 100},
                {
                    field: 'operation', title: 'OPERATION', width: 100,
                    formatter: function () {
                        return '<a href="${path}/city/deleteCity.do?id=${id}">删除</a><a href="${path}/city/findCity.do?id=${id}">修改</a>';
                    }
                }
            ]],
            rownumbers: true,
            idField: 'id',
            pagination: true,
            //pageList:[25,50,100,150,365],
//   				pageSize:365,
            selectOnCheck: false,
            ctrlSelect: true,
            toolbar: [
                {
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        // 初始化dialog
                        $('#dg').dialog({
                            title: '添加',
                            iconCls: 'icon-add',
                            width: 600,
                            height: 300,
                            buttons: [
                                {
                                    text: '提交',
                                    iconCls: 'icon-ok',
                                    handler: function () {
                                        // 提交表单
                                        $('#fom').submit();
                                    }
                                }
                            ]
                        });
                        // 初始化表单
                        $('#fom').form({
                            url: '${path}/city/addCity.do',
                            onSubmit: function (param) {
                                return true;
                            },
                            success: function (data) {
                                console.log(data);
                                //关闭dialog
                                $('#dg').dialog('close');
                                // 刷新datagrid
                                $('#tt').datagrid('load');
                            }
                        });
                    }
                },
                {
                    text: '编辑',
                    iconCls: 'icon-edit',
                    handler: function () {
                        // 初始化dialog
                        $('#dg').dialog({
                            title: '编辑',
                            iconCls: 'icon-edit',
                            width: 600,
                            height: 300,
                            buttons: [
                                {
                                    text: '提交',
                                    iconCls: 'icon-ok',
                                    handler: function () {
                                        // 提交表单
                                        $('#fom').submit();
                                    }
                                }
                            ]
                        });
                        // 初始化表单
                        $('#fom').form({
                            url: '${path}/city/modifyCity.do',
                            onSubmit: function (param) {
                                return true;
                            },
                            success: function (data) {
                                console.log(data);
                                //关闭dialog
                                $('#dg').dialog('close');
                                // 刷新datagrid
                                $('#tt').datagrid('load');
                            }
                        });
                        // 给表单元素添加默认数据 --》  将选中行的数据添加到表单
                        var row = $('#tt').datagrid('getSelected');
                        $('#fom').form('load', {
                            // 表单元素name属性值: 值
                            name: row.name,
                            url: row.url
                        });

                    }
                },
                {
                    text: '测试',
                    iconCls: 'icon-help',
                    handler: function () {
                        url:"${pageContext.request.contextPath}/other/main.jsp",
                            // 重新加载 -->  实现刷新效果
                            // $('#tt').datagrid('load'); // 重新加载，返回第一页
                            $('#tt').datagrid('reload'); // 重新加载 ，保持当前页
                        // 获取加载完毕后的所有数据
                        //console.log($('#tt').datagrid('getData'));
                        // 返回当前页所有数据
                        //console.log($('#tt').datagrid('getRows'));
                        // 根据标识字段的值获取其所在行的下标 , 前提字段必须指定为标识字段
                        //console.log($('#tt').datagrid('getRowIndex',210212));
                        // 获取所有checkbox勾选的行
                        //console.log($('#tt').datagrid('getChecked'));
                        // 获取选中所有行中的第一个
                        //console.log($('#tt').datagrid('getSelected'));
                        // 返回所有选中行
                        console.log($('#tt').datagrid('getSelections'));
                    }
                },
                {
                    text: '清除选中',
                    iconCls: 'icon-help',
                    handler: function () {
                        //清除所有checkbox勾选
                        //$('#tt').datagrid('clearChecked');
                        // 清除所有选中的行
                        $('#tt').datagrid('clearSelections');
                    }
                },
            ]
        });
    });

</script>
<table id="tt">
</table>
<div id="dg" style="padding:20px;display:none;">
    <form id="fom">
        <div class="in">
            ID:<input id="id" name="id" class="easyui-passwordbox"
                      data-options="required:true"/>
        </div>
        <div class="in">
            NAME:<input id="name" name="name" class="easyui-passwordbox" data-options="required:true"/>
        </div>
        <div class="in">
            URL:<input id="url" name="url" class="easyui-passwordbox"
                       data-options="required:true"/>
        </div>
        <div class="in">
            LEAF:<input id="leaf" name="leaf" class="easyui-passwordbox"
                        data-options="required:true"/>
        </div>
        <div class="in">
            PARENTID:<input id="parentId" name="parentId" class="easyui-passwordbox"
                            data-options="required:true"/>
        </div>
    </form>

</div>
</body>
</html>