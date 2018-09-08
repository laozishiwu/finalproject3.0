<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {
        $("#btn").click(function (data) {
            var titles = $("#customer_tree").combotree("getText");
            var params = $("#customer_tree").combotree("getValues");
            var a = "";
            $.each(params, function (index, param) {
                if (params.length - 1 == index) {
                    a += param;
                } else {
                    a += param + ",";
                }
            })
            $("#customer_form").form("submit", {
                url: "${pageContext.request.contextPath}/poi/Export.do",
                queryParams: {
                    titles: titles,
                    params: a
                }
            })
        })
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "添加",
            handler: function () {
                $("#dd").dialog("open");
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-help',
            handler: function () {
                /*
                 * 删除数据
                 *
                 * */
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-help',
            handler: function () {
                /*
                 *使当前选中行可编辑模式
                 * */
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {

                    var index = $("#dg").edatagrid("getRowIndex", row)
                    //当前行可编辑
                    $("#dg").edatagrid("editRow", index)

                } else {
                    alert("请先选中行")
                }


            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-help',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        }, '-', {
            text: "自定义导出",
            iconCls: 'icon-help',
            handler: function () {
                $("#customer_dd").dialog("open")
            }
        }]

        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/user/queryBypage.do',
            method: "get",
            updateUrl: "${pageContext.request.contextPath}/cmfz/banner/add",
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
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.img + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.registtime + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
    })

    function submit() {
        $("#ff").form("submit", {
            url: "${pageContext.request.contextPath}/banner/add"
        })
    }
</script>
<div id="adduserdiv" style="width: 350px;height: 250px;display: none">
    <form id="useraddform" method="post" enctype="multipart/form-data">
        <div style="font-family: 楷体;font-size: 25px;color: blue;position: absolute;left: 45px;top: 50px;">
            Excel批量导入用户信息
        </div>

        <div style="position: absolute;top: 130px;left: 50px;">
            <input class="easyui-filebox" name="excelfile" style="width: 250px;"
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
<table id="dg"></table>
<div id="dd" class="easyui-dialog" title="用户信息管理" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submit();
                      $('#dd').dialog('close');
                      $('#dg').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#dd').dialog('close');
				}
			}]">
    <form id="ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">title:</label>
            <input class="easyui-validatebox" id="title" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <label for="description">description:</label>
            <input class="easyui-textbox" type="text" id="description" name="description" data-options=""/>
        </div>
        <div>
            <select id="cc" class="easyui-combobox" name="status" style="width:200px;">
                <option value="Y">展示</option>
                <option value="N">不展示</option>
            </select>
        </div>
        <div>
            <input class="easyui-filebox" name="img" style="width:300px">
        </div>

    </form>


</div>
<div id="customer_dd" class="easyui-dialog" title="用户信息管理" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <select id="customer_tree" class="easyui-combotree" style="width:200px;"
            data-options="checkbox:true,multiple:true,onlyLeafCheck:true,required:true,
            data:[{
    'id':'custome',
    'checked':false,
    'text': '请选择',
    'children': [
      {
        'id':'id',
        'text': '编号',
        'checked': true
      },
      { 'id':'name',
        'text': '名字',
        'checked': true
      },
      { 'id':'dhamaname',
        'text': '法号',
        'checked': true
      },{
        'id':'img',
        'text': '头像',
        'checked': true
      },
      { 'id':'sex',
        'text': '性别',
        'checked': true
      },
      { 'id':'location',
        'text': '籍贯',
        'checked': true
      },{
        'id':'sign',
        'text': '格言',
        'checked': true
      },
      { 'id':'phone',
        'text': '手机',
        'checked': true
      },
      { 'id':'password',
        'text': '密码',
        'checked': true
      },{
        'id':'salt',
        'text': '加密盐',
        'checked': true
      },
      { 'id':'status',
        'text': '状态',
        'checked': true
      },
      { 'id':'registtime',
        'text': '注册时间',
        'checked': true
      }
    ]
  }
]"></select>
    <form action="" method="post" id="customer_form">
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a>
    </form>

</div>





