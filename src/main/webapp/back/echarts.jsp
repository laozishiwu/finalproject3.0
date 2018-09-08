<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>--%>
<script type="text/javascript">
    var goEasy = new GoEasy({
        appkey: "BS-0d804f8111b847a1baa970666394cd43"
    });
    goEasy.subscribe({
        channel: "wuyongchao",
        onMessage: function (message) {
            //alert("Channel:" + message.channel + " content:" + message.content);
            var obj = JSON.parse(message.content);
            var myChart = echarts.init(document.getElementById('main'));
            var option = {
                title: {
                    text: 'ECharts 入门示例',
                    subtext: "我试试"
                },
                tooltip: {},
                legend: {
                    data: ['男', '女']
                },
                xAxis: {
                    data: obj.xAxis
                },
                yAxis: {},
                series: [{
                    name: '男',
                    type: 'line',
                    data: obj.men
                }, {
                    name: '女',
                    type: 'bar',
                    data: obj.womens
                }]
            };
            myChart.setOption(option)
        }
    })
</script>