<%--
  Created by IntelliJ IDEA.
  User: Mr MC
  Date: 2025/1/15
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
    <iframe name="target" width="500" height="500" style="display: inline-block"></iframe>
    <div style="display: inline-block">
      <ul>
        <li><a href="cookieServlet?action=createCookie" target="target">Cookie的创建</a></li>
        <li><a href="cookieServlet?action=getCookie" target="target">Cookie的获取</a></li>
        <li><a href="cookieServlet?action=updateCookie" target="target">Cookie值的修改</a></li>
        <li>Cookie的存活周期</li>
        <li>
          <ul>
            <li><a href="cookieServlet?action=defaultLife" target="target">Cookie的默认存活时间（会话）</a></li>
            <li><a href="cookieServlet?action=deleteCookie" target="target">Cookie立即删除</a></li>
            <li><a href="" target="target">Cookie存活3600秒（1小时）</a></li>
          </ul>
        </li>
        <li><a href="" target="target">Cookie的路径设置</a></li>
        <li><a href="" target="target">Cookie的用户免登录练习</a></li>
      </ul>
    </div>
</body>
</html>
