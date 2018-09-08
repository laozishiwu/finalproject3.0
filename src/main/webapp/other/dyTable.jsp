<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script type="text/javascript">
        //开发事件监听函数
        // 添加一行
        function addRow() {
            //  获取用户输入的内容
            var pidVal = document.getElementById('pid').value;
            var nameVal = document.getElementById('name').value;
            var originVal = document.getElementById('origin').value;
            //  创建列  并将输入的内容添加到列中
            var td1 = document.createElement('td');
            td1.innerHTML = '<input type="checkbox" name="tbBox"/>';

            var td2 = document.createElement('td');
            td2.innerHTML = pidVal;

            var td3 = document.createElement('td');
            td3.innerHTML = nameVal;

            var td4 = document.createElement('td');
            td4.innerHTML = originVal;

            var td5 = document.createElement('td');
            td5.innerHTML = '<input type="button" value="delete" onclick="delRow(this);"/>';
            //  创建行
            var tr = document.createElement('tr');
            tr.setAttribute('align', 'center');
            //  将列放到行中
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);
            //  将行放到tbody上
            var tb = document.getElementById('tb');
            tb.appendChild(tr);
        }

        // 删除当前行
        function delRow(obj) {
            // obj是当前按钮对象
            // 获取当前行对象
            var tr = obj.parentNode.parentNode;
            // 获取tbody对象 | tbody是行的父节点
            var tb = tr.parentNode;
            // 移除当前行
            tb.removeChild(tr);
        }

        // 反选
        function reverseSel() {
            //  获取到所有的tbody中checkbox
            var tbBoxs = document.getElementsByName('tbBox');
            for (var i = 0; i < tbBoxs.length; i++) {
                //反选
                tbBoxs[i].checked = !tbBoxs[i].checked;
            }
        }
    </script>
</head>

<body>
<div style="text-align:center;">
    商品编号：<input type="text" name="pid" id="pid"/>
    商品名称：<input type="text" name="name" id="name"/>
    商品产地：<input type="text" name="origin" id="origin"/>
</div>
<hr color="red"/>
<table border="2px" align="center" cellspacing="0" cellpadding="5px" width="500px">
    <thead id="thd">
    <tr bgcolor="#00FFFF" align="center">
        <td><input type="checkbox" id="thBox"/></td>
        <td>产品编号</td>
        <td>产品名称</td>
        <td>产品产地</td>
        <td>operate</td>
    </tr>
    </thead>
    <tbody id="tb">
    <tr align="center">
        <td><input type="checkbox" name="tbBox"/></td>
        <td>1</td>
        <td>新疆大枣</td>
        <td>新疆</td>
        <td>
            <input type="button" value="delete" onclick="delRow(this);"/>
        </td>
    </tr>
    <tr align="center">
        <td><input type="checkbox" name="tbBox"/></td>
        <td>2</td>
        <td>东北樱桃</td>
        <td>长春</td>
        <td>
            <input type="button" value="delete" onclick="delRow(this);"/>
        </td>
    </tr>
    </tbody>
</table>
<div style="text-align:center;">
    <input type="button" value="添加" onclick="addRow();"/>
    <input type="button" value="删除选中"/>
    <input type="button" value="反选" onclick="reverseSel();"/>
</div>
</body>
</html>
























