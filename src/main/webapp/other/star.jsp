<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            //开发事件监听函数
            function overImg(idx) {
                // 根据class属性值获取
                var imgs = document.getElementsByClassName('star');
                for (var i = 0; i < idx; i++) {
                    imgs[i].src = 'img/x2.png';
                }
            }

            function outImg(idx1) {
                // 根据class属性值获取
                var imgs = document.getElementsByClassName('star');
                for (var i = idx1 - 1; i < imgs.length; i++) {
                    imgs[i].src = 'img/x3.png';
                }
            }
        });
    </script>
</head>

<body>
<img class="star" src="${pageContext.request.contextPath}/img/x3.png" onmouseover="overImg(1);"
     onmouseout="outImg(1);"/>
<img class="star" src="${pageContext.request.contextPath}/img/x3.png" onmouseover="overImg(2);"
     onmouseout="outImg(2);"/>
<img class="star" src="${pageContext.request.contextPath}/img/x3.png" onmouseover="overImg(3);"
     onmouseout="outImg(3);"/>
<img class="star" src="${pageContext.request.contextPath}/img/x3.png" onmouseover="overImg(4);"
     onmouseout="outImg(4);"/>
<img class="star" src="${pageContext.request.contextPath}/img/x3.png" onmouseover="overImg(5);"
     onmouseout="outImg(5);"/>
</body>
</html>
























