<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!-- 第二步:为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="map" style="width: 600px;height:400px;"></div>
<%--<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/echarts/echarts.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/echarts/china.js"></script>--%>
<script type="text/javascript">
    /*初始化init echarts表格*/
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('map'));
    //设置当前echarts表格的配置
    // 指定图表的配置项和数据
    $.ajax({
        url: "${pageContext.request.contextPath}/userDTO/queryBylocation.do",
        dataType: "JSON",
        type: "post",
        success: function (result) {
            console.log(result.男);
            console.log(result.女);
            var option = {
                title: {
                    text: '驰名法洲用户分布',
                    subtext: '纯属虚构',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['男', '女']
                },
                visualMap: {
                    min: 0,
                    max: 2500,
                    left: 'left',
                    top: 'bottom',
                    text: ['高', '低'],           // 文本，默认为数值文本
                    calculable: true
                },
                toolbox: {
                    show: true,
                    orient: 'vertical',
                    left: 'right',
                    top: 'center',
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                series: [
                    {
                        name: '男',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data: result.男
                    },
                    {
                        name: '女',
                        type: 'map',
                        mapType: 'china',
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data: result.女
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    });
</script>