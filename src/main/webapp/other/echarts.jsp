<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <%--引入goeasy的js文件--%>
    <script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/back/static/jquery.min.js"></script>
    <%--第一步:引入ecahrts.js文件--%>
    <script charset="utf-8" src="${pageContext.request.contextPath}/back/echarts/echarts.js"></script>
</head>
<body>
<!-- 第二步:为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="echarts" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    /*初始化init echarts表格*/
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echarts'));
    //设置当前echarts表格的配置
    // 指定图表的配置项和数据
    /*var goEasy = new GoEasy({
        //appkey: "BS-4484f5c3344448129d93f119e7751d02"
        appkey:"BS-1a16ac2acb9945dc8599f041dc11a74b"
    });
    goEasy.subscribe({
        //channel: "my_channel",
        channel:"zhy",
        onMessage: function (message) {
            console.log(message);
            alert("Channel:" + message.channel + " content:" + message.content);
            //json格式字符串转换js对象
            var cdata = $.parseJSON(message.content);
            //设置当前echarts表格的配置
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '最近几周...注册用户的数量'
                },
                tooltip: {},
                legend: {
                    data:['注册数量']
                },
                xAxis: {
                    data: cdata.week
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: cdata.count
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    });*/

    //发送ajax查询数据
    $.ajax({
        url: '${pageContext.request.contextPath}/userPlus/showByWeek.do',
        dataType: "json",
        type: "post",

        success: function (result) {
            // var data = JSON.stringify(result).replace(/\"/g,"'");
            // var data = JSON.parse(result);
            console.log(result);
            var option = {
                title: {
                    text: '最近几周...注册用户的数量'
                },
                tooltip: {},
                legend: {
                    data: ['注册数量']
                },
                xAxis: {
                    data: result.week,
                },
                yAxis: {},
                series: [{
                    name: '注册数量',
                    type: 'bar',
                    data: result.count,
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    });

</script>
</body>
</html>
