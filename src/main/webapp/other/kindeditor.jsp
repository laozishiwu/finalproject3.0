<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>

<script charset="utf-8" src="${pageContext.request.contextPath}/back/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/back/kindeditor/lang/zh-CN.js"></script>
<script>

    // KindEditor.ready(function(K) {              //不需要页面包含时与下一行一起使用
    //     window.editor = K.create('#editor_id',{ //不需要页面包含时与上一行一起使用
    var clearDefault = true;//是否显示默认内容
    KindEditor.create('#editor_id', {    //需要页面包含时使用
        width: '1000px',
        //图片上传功能
        //{"error":0,"url":"\/ke4\/attached\/W020091124524510014093.jpg"}
        uploadJson: "${pageContext.request.contextPath}/editor/add.do",
        //查询服务器上所有上传过的图片
        //
        fileManagerJson: "${pageContext.request.contextPath}/editor/browser.do",
        allowFileManager: true,
        filePostName: "file",
        //});
    });
    //}
    //})
    $(function () {
        $('#addArticle').form({
            success: function () {
                KindEditor.html("#editor_id", "");//清空kindeditor所有内容
                $('#addArticle').form('reset');
            }
        })
    })
</script>
<form id="addArticle" enctype="multipart/form-data" action="${pageContext.request.contextPath}/editor/upload.do">
    <textarea id="editor_id" name="content"
              style="width:700px;height:300px;">&lt;strong&gt;HTML内容&lt;/strong&gt;</textarea>
    <div>
        <label>标题:</label>
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true,"/>
    </div>
    <div>
        <label>作者：</label>
        <input id="cc" class="easyui-combobox" name="master.id"
               data-options="valueField:'id',textField:'faname',url:'${pageContext.request.contextPath}/master/showAll.do'"/>
    </div>
    <input type="submit" style="width: 88px;"/>
</form>


