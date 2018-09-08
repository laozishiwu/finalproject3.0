<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
     <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/icon.css">
     <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/default/easyui.css">
     <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/IconExtension.css">--%>
</head>
<body>
<script type="text/javascript">
    $("#masterlist").edatagrid({
        url: "${pageContext.request.contextPath }/master/queryBypage.do",
        fitColumns: true,
        striped: true,
        loadMsg: "玩命加载中............",
        rownumbers: true,
        singleSelect: true,
        pagination: true,
        pageSize: 3,
        fit: true,
        pageList: [3, 5, 10, 15],
        toolbar: toolbar,
        columns: [[
            {field: "id", title: "编号", width: 100, align: "center"},
            {field: "name", title: "姓名", width: 100, align: "center"},
            {field: "dharmaname", title: "法号", width: 100, align: "center"},
            {field: "phone", title: "手机", width: 100, align: "center"},
            {
                field: "photo", title: "图片", width: 100, align: "center",
                formatter: function (value, row, index) {
                    return "<img src=\"${pageContext.request.contextPath }" + value + "\" style='width:100px;height:100px'/>";
                }
            },
            {
                field: "dd", title: "操作", width: 50, align: "center",
                formatter: function (value, row, index) {
                    return "<a class='masterdel' onClick=\"delmaster(\'" + row.id + "\')\"></a>";
                }
            }
        ]],
        detailFormatter: function (rowIndex, rowData) {
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.photo + '" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>Status: ' + rowData.status + '</p>' +
                '</td>' +
                '</tr></table>';
        },
        onLoadSuccess: function () {
            $(".masterdel").linkbutton({
                text: "删除",
                iconCls: "icon-image_delete",
            });
        },
        toolbar: [{
            text: "添加上师",
            width: "110px",
            height: "28px",
            iconCls: "icon-group_add",
            handler: function () {
                $("#addmasterdiv").dialog({
                    title: "添加上师",
                    closeable: true
                });
            }

        }
        ],
    });

    $(function () {
        $("#masteraddsub").click(function () {
            $("#masteraddform").form("submit", {
                url: "${pageContext.request.contextPath }/master/add.do",
                success: function (data) {
                    $("#masterlist").datagrid("reload");
                    $("#addmasterdiv").dialog("close");
                }
            });
        });
        $("#masteraddclo").click(function () {
            $("#addmasterdiv").dialog("close");
        });
    });

    function delmaster(i) {
        $.post("${pageContext.request.contextPath}/master/delete.do", {id: i}, function (data) {
            $("#masterlist").datagrid("reload");
        });
    }

    $(function () {
        $("#imgfile").change(function () {
            change_photo();
        });
    });

    function change_photo() {
        PreviewImage($("input[name='imgfile']")[0], "masterimg", 'Imgdiv');
    }

    function PreviewImage(fileObj, imgPreviewId, divPreviewId) {
        var allowExtention = ".jpg";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
        var extention = fileObj.value.substring(fileObj.value.lastIndexOf(".") + 1).toLowerCase();
        var browserVersion = window.navigator.userAgent.toUpperCase();
        if (allowExtention.indexOf(extention) > -1) {
            if (fileObj.files) {//HTML5实现预览，兼容chrome、火狐7+等
                if (window.FileReader) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        document.getElementById(imgPreviewId).setAttribute("src", e.target.result);
                    };
                    reader.readAsDataURL(fileObj.files[0]);
                } else if (browserVersion.indexOf("SAFARI") > -1) {
                    alert("不支持Safari6.0以下浏览器的图片预览!");
                }
            } else if (browserVersion.indexOf("MSIE") > -1) {
                if (browserVersion.indexOf("MSIE 6") > -1) {//ie6
                    document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
                } else {//ie[7-9]
                    fileObj.select();
                    if (browserVersion.indexOf("MSIE 9") > -1)
                        fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问
                }
            } else if (browserVersion.indexOf("FIREFOX") > -1) {//firefox
                var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
                if (firefoxVersion < 7) {//firefox7以下版本
                    document.getElementById(imgPreviewId).setAttribute("src", fileObj.files[0].getAsDataURL());
                } else {//firefox7.0+
                    document.getElementById(imgPreviewId).setAttribute("src", window.URL.createObjectURL(fileObj.files[0]));
                }
            } else {
                document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
            }
        } else {
            alert("仅支持" + allowExtention + "为后缀名的文件!");
            if (browserVersion.indexOf("MSIE") > -1) {
                fileObj.select();
                document.selection.clear();
            }
            $('#file_upload').filebox('clear');
        }
    }
</script>
<table id="masterlist">
    <title>上师列表</title>
</table>
<div id="addmasterdiv" style="width: 350px;height:365px;display: none">
    <form id="masteraddform" method="post" enctype="multipart/form-data">
        <div class="in">
            编号:<input id="id" name="id" class="easyui-passwordbox"
                      data-options="required:true"/>
        </div>
        <div class="in">
            姓名:<input id="name" name="name" class="easyui-passwordbox" data-options="required:true"/>
        </div>
        <div class="in">
            法号:<input id="url" name="url" class="easyui-passwordbox"
                      data-options="required:true"/>
        </div>
        <div class="in">
            手机:<input id="leaf" name="leaf" class="easyui-passwordbox"
                      data-options="required:true"/>
        </div>
        <div class="in">
            <div style="position: absolute;top: 125px;left: 0px;">
                头像：<input id="imgfile" class="easyui-filebox" name="imgfile" style="width: 250px;"
                          data-options="label:'头像',labelWidth:'40px',buttonText:'选择图片'">
            </div>
        </div>
        <div style="position: absolute;top: 158px;left: 110px;">
            <a id="masteraddsub" style="width: 80px;height: 27px;" class="easyui-linkbutton"
               data-options="text:'提交',iconCls:'icon-image_star'"></a>
            <a id="masteraddclo" style="width: 80px;height: 27px;margin-left: 10px;" class="easyui-linkbutton"
               data-options="text:'关闭',iconCls:'icon-html_delete'"></a>
        </div>
    </form>
</div>
</body>
</html>