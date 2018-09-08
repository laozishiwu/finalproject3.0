<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/echarts/echarts.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/echarts/china.js"></script>
    <script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/menu/queryAll.do",
                type: "get",
                dataType: "JSON",
                success: function (data) {
                    $.each(data, function (index, first) {
                        var c = "";
                        $.each(first.children, function (index1, second) {

                            c += "<p style='text-align: center'><a href='#' data-options=\"iconCls:'icon-add'\" class='easyui-linkbutton' onclick=\"addTabs('" + second.iconCls + "','" + second.title + "','" + second.href + "')\">" + second.title + "</a></p>";
                        })
                        $('#menu').accordion('add', {
                            title: first.title,
                            content: c,
                            iconCls: first.iconCls,
                            selected: false
                        });
                    })
                }
            })
        });
        $("#upadmincls").click(function () {
            $("#updateuserdiv").dialog("close");
        });
        $("#upadminsub").click(function () {
            $("#upadminform").form("submit", {
                url: "${pageContext.request.contextPath}/manager/update.do",
                onSubmit: function (param) {
                    param.realname = $("#uprealname").textbox("getText");
                    param.username = $("#upusername").textbox("getText");
                    param.password = $("#uppassword").textbox("getText");
                },
                success: function (data) {
                    $("#updateuserdiv").dialog("close");
                },
            });
        });

        function updateUser() {
            $("#updateuserdiv").dialog({
                title: "修改信息",
                iconCls: "icon-pencil",
            });
            $.post("${pageContext.request.contextPath}/manager/query.do", function (data) {
                $("#upadminid").val(data.id);
                $("#uprealname").textbox("setText", data.realname);
                $("#upusername").textbox("setText", data.username);
                $("#uppassword").textbox("setText", data.password);
            });
        }

        function loginOut() {
            $(location).prop("href", "${pageContext.request.contextPath}/manager/loginout.do");
        }

        function addTabs(iconCls, title, href) {
            /*创建选项卡*/
            var flag = $("#tt").tabs("exists", title)
            if (flag) {
                $("#tt").tabs("select", title)
                console.log(href)
            } else {
                $('#tt').tabs('add', {
                    title: title,
                    selected: true,
                    closable: true,
                    href: "${pageContext.request.contextPath}" + href
                });
            }

        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:${sessionScope.username} &nbsp;<a href="${pageContext.request.contextPath}/other/manager.jsp"
                                              class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a
            href="${pageContext.request.contextPath}/manager/loginout.do" class="easyui-linkbutton"
            data-options="iconCls:'icon-01'">退出系统</a></div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="menu" class="easyui-accordion" data-options="fit:true">

    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(../main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;">
            <img src="${pageContext.request.contextPath}/main/image/shouye.jpg" style="width: 100%;height: 100%;"/>
        </div>
    </div>
</div>

<div style="width:500px;height: 330px;display: none" id="updateuserdiv">

    <form id="upadminform">
        <div style="position: absolute;top: 50px;left: 160px;color: blue;font-family: 楷体;font-size: 30px">
            用户信息修改
        </div>
        <input type="hidden" id="upadminid" name="id">
        <div style="position: absolute;top: 110px;left: 85px">
            <label for="upid">id:</label>
            <input id="upid" class="easyui-textbox" style="width: 300px;" data-options="label:'用户编号',labelWidth:'60'">
        </div>

        <div style="position: absolute;top: 155px;left: 85px">
            <label for="upusername">username:</label>
            <input id="upusername" class="easyui-textbox" style="width: 300px;"
                   data-options="label:'用户名',labelWidth:'60'">
        </div>

        <div style="position: absolute;top: 200px;left: 85px">
            <label for="uppassword">password:</label>
            <input id="uppassword" class="easyui-passwordbox" style="width: 300px;"
                   data-options="label:'密码',prompt:'若不修改密码,可不填写',labelWidth:'60'">
        </div>
        <div style="position: absolute;top: 250px;left: 230px">
            <a id="upadminsub" class="easyui-linkbutton" style="width: 100px;height: 30px"
               data-options="iconCls:'icon-photo_paint'">修改</a>
            <a id="upadmincls" class="easyui-linkbutton" style="margin-left: 20px;width: 100px;height: 30px"
               data-options="iconCls:'icon-photo_delete'">取消</a>
        </div>
    </form>
</div>
</body>
</html>