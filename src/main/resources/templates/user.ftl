<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
    href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" />
</head>
<body style="font-family:'Courier New'">
    <h3 class="text-center">这是用户${name}的信息页！</h3>
    <div class="col-md-6 column">
        <table class="table table-bordered">
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>状态</th>
                <th>时间</th>
            </tr>
            <tr>
                <td>${id}</td>
                <td>${name}</td>
                <td>${status}</td>
                <td>${durationAsString}</td>
            </tr>
        </table>
    </div>
</body>
</html>