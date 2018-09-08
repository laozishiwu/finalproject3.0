<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户信息管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript">
        function fun() {
            var fom = $('#ids').val();
            if (fom = null) {
                alert("请选择内容！");
            }
        }
    </script>
</head>
<body>
<div id="wrap" style="">
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
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            <h1 style="float:left">
                Welcome ==> <span
                    style="color:orange;background-color: #00AA00">》${sessionScope.manager.username }《</span> !
            </h1>
            <h1 style="float:right">
                <form action="${pageContext.request.contextPath }/city/findLikename.do" method="post">
                    <select name="name">
                        <option value="name">名称</option>
                    </select>
                    <input type="text" name="name"/>
                    <input type="submit" value="》搜索《"/>
                </form>
            </h1>
            </p>

            <form action="${pageContext.request.contextPath }/city/modifyremoveBachAcc.do" method="post" id="form">
                <table class="table">
                    <tr class="table_header">

                        <td>
                            ID
                        </td>
                        <td>
                            Name
                        </td>
                        <td>
                            Url
                        </td>
                        <td>
                            Leaf
                        </td>
                        <td>
                            ParentId
                        </td>
                        <td>
                            Operation
                        </td>
                    </tr>
                    <c:forEach items="${requestScope.employee}" var="employee">
                    <tr class="row1">
                        <td>
                            <input type="checkbox" name="ids" value="${employee.id }" id="ids"/>
                                ${employee.id }
                        </td>
                        <td>
                                ${employee.name }
                        </td>
                        <td>
                                ${employee.url }
                        </td>
                        <td>
                                ${employee.leaf }
                        </td>
                        <td>
                                ${employee.parentId}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath }/city/deleteCity.do?id=${employee.id }">delete
                                emp</a>
                            <a href="${pageContext.request.contextPath }/city/findCity.do?id=${employee.id }">update
                                emp</a>
                        </td>
                    </tr>
                    </c:forEach>
            </form>
            <a style="color:red" href="${pageContext.request.contextPath}/other/main.jsp">返回主页</a>
            </table>
            <!-- 分页 -->
            <p>
                当前第${currentPage}页/共${totalPage}页
                <c:if test="${currentPage==1 }">
                    首页
                </c:if>
                <c:if test="${currentPage>1 }">
                    <a href="${pageContext.request.contextPath}/city/findByPage.do?page=1">首页</a>
                </c:if>
                <c:if test="${currentPage==1 }">
                    上一页
                </c:if>
                <c:if test="${currentPage>1 }">
                    <a href="${pageContext.request.contextPath }/city/findByPage.do?page=${currentPage-1 }">上一页</a>
                </c:if>
                <c:forEach var="i" begin="1" end="${totalPage}" step="1">
                    <c:if test="${i==currentPage }">${i }</c:if>
                    <c:if test="${ i!=currentPage}">
                        <a href="${pageContext.request.contextPath }/city/findByPage.do?page=${i}">${i }</a>
                    </c:if>
                </c:forEach>
                <c:if test="${currentPage==totalPage }">
                    下一页
                </c:if>
                <c:if test="${currentPage<totalPage }">
                    <a href="${pageContext.request.contextPath }/city/findByPage.do?page=${currentPage+1 }">下一页</a>
                </c:if>
                <c:if test="${currentPage==totalPage }">尾页</c:if>
                <c:if test="${currentPage<totalPage }">
                    <a href="${pageContext.request.contextPath }/city/findByPage.do?page=${totalPage }">尾页</a>
                </c:if>
            </p>


            <p>
                <input type="submit" value="批量删除" onclick="fun()"/>
                ---->>
                <input type="button" class="button" value="Add Employee"
                       onclick="location='${pageContext.request.contextPath}/model/addEmp.jsp'"/>
                ---->>
                <a style="color:red" href="${pageContext.request.contextPath }/other/city.jsp">安全退出</a>
            </p>
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
