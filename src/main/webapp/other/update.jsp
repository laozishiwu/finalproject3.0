<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户信息管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">Main</a>
                    <div style="text-align:center">Welcome ${sessionScope.manager.username}!</div>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                update Manager info:
            </h1>
            <form action="${pageContext.request.contextPath}/city/modifyCity.do" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            id:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="id" value="${sessionScope.employee.id}" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            name:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${sessionScope.employee.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            leaf:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="leaf" value="${sessionScope.employee.leaf}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            parentId:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="parentId"
                                   value="${sessionScope.employee.parentId}" readonly/>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Confirm"/>
                    --->>
                    <a style="color:red" href="${pageContext.request.contextPath}/other/city.jsp">返回主页</a>
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
