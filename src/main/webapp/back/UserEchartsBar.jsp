<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!-- 第二步:为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="echarts" style="width: 600px;height:400px;"></div>
<%--<script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/echarts/echarts.js"></script>--%>
<script type="text/javascript">
    /*初始化init echarts表格*/
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echarts'));
    var goEasy = new GoEasy({
        appkey: "BS-0d804f8111b847a1baa970666394cd43"
    });
    goEasy.subscribe({
        channel: "wuyongchao",
        onMessage: function (message) {
            //alert("Channel:" + message.channel + " content:" + message.content);
            //发送ajax查询数据
            $.ajax({
                url: '${pageContext.request.contextPath}/userDTO/queryByweek.do',
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
                            data: ['男', '女']
                        },
                        xAxis: {
                            data: result.week
                        },
                        yAxis: {},
                        series: [{
                            name: '男',
                            type: 'bar',
                            data: result.count
                        }, {
                            name: '女',
                            type: 'line',
                            data: result.count
                        }]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                }
            });
        }
    });

</script>