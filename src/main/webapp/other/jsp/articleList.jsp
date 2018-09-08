<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>

<script charset="utf-8" src="${pageContext.request.contextPath}/back/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/back/kindeditor/lang/zh-CN.js"></script>
<script>
    $(function () {
        $('#dgArticle').datagrid({
            url: '${pageContext.request.contextPath}/editor/showAll.do',
            fitColumns: true,
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'title', title: '标题', width: 100},
                {
                    field: 'content', title: '内容', width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return value;
                    }
                },
                {field: 'creDate', title: '创建时间'},
                {field: 'upDate', title: '修改时间'},
                {
                    field: '操作', title: '操作', width: 100, align: 'center',
                    formatter: function (value, row, index) {
                        var temp = JSON.stringify(row).replace(/\"/g, "'");
                        return '<a class="del2"  style="color: darkblue;" onclick="delArticle(' + temp + ')"> 删除 </a>';
                    }
                },
            ]],
            toolbar: [{
                iconCls: 'icon-edit',
                handler: function () {
                    alert('编辑按钮')
                }
            }, '-', {
                iconCls: 'icon-help',
                handler: function () {
                    alert('帮助按钮')
                }
            }]

        });
    })

    function delArticle(article) {
        var id = article.id;
        $.ajax({
            url: '${pageContext.request.contextPath}/editor/remove.do',
            type: 'POST',
            data: 'id=' + id,
            dataType: 'json',
            success: function (data) {
                if (data == 'success') {
                    $('#dgArticle').datagrid('reload');
                }
            }
        });
    }
</script>
<table id="dgArticle"></table>



