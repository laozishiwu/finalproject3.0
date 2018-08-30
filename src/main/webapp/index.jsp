<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/IconExtension.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript">
        function addTab($obj,options){ // options { title:'',closable:''}
            if($obj.tabs('exists',options.title)){
                $obj.tabs('select',options.title);
            }else{
                $obj.tabs('add',options);
            }
        }
        $(function(){
        });
        function showInfo(){
            // 添加一个新的选项卡 并展示信息
            addTab($('#centerTb'),{
                title:'信息展示',
                closable:true,
                iconCls:'icon-ok',
                href:'${path}/datagrid.jsp',
                fit:true
            });
            // 添加一个新的选项卡 并展示信息
            addTab($('#centerTb'),{
                title:'信息展示',
                closable:true,
                iconCls:'icon-ok',
                href:'goods.jsp',
                fit:true
            });
        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.username} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="menu" class="easyui-accordion" data-options="fit:true">
        <div data-options="title:'轮播图管理'" style="text-align:center;">
            <div class="btn">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-undo',width:200" onclick="showInfo()">添加轮播图</a>
            </div>
        </div>
        <div data-options="title:'吉祥妙音'" style="text-align:center;">
            <div class="btn">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-undo',width:200" onclick="showInfo()">吉祥妙音信息</a>
            </div>
        </div>
        <div data-options="title:'甘露秒宝'" style="text-align:center;">
            <div class="btn">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-undo',width:200" onclick="showInfo()">甘露秒宝信息</a>
            </div>
        </div>
        <div data-options="title:'功课记录'" style="text-align:center;">
            <div class="btn">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-undo',width:200" onclick="showInfo()">查看功课信息</a>
            </div>
        </div>
    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;">
            <img src="${pageContext.request.contextPath}/main/image/shouye.jpg" style="width: 100%;height: 100%;"/>
        </div>
    </div>
</div>
</body>
</html>