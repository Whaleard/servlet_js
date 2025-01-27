<%--
  Created by IntelliJ IDEA.
  User: issuser
  Date: 2025/1/17
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
    <iframe name="target" width="500" height="500" style="display: inline-block"></iframe>
    <div style="display: inline-block">
      <ul>
        <li><a href="sessionServlet?action=createOrGetSession" target="target">Session的创建和获取（id号、是否为新创建）</a></li>
        <li><a href="sessionServlet?action=setAttribute" target="target">Session域数据的存储</a></li>
        <li><a href="sessionServlet?action=getAttribute" target="target">Session域数据的获取</a></li>
        <li>Session的存活周期</li>
        <li>
          <ul>
            <li><a href="sessionServlet?action=defaultLifeTime" target="target">Session的默认超时及配置</a></li>
            <li><a href="sessionServlet?action=setLifeTime" target="target">Session3秒超时销毁</a></li>
            <li><a href="" target="target">Session马上销毁</a></li>
          </ul>
        </li>
        <li><a href="" target="target">浏览器和Session绑定的原理</a></li>
      </ul>
    </div>
</body>
</html>
