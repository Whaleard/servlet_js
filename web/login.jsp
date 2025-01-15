<%--
  Created by IntelliJ IDEA.
  User: Mr MC
  Date: 2024/7/1
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%-- 引入jstl核心标签库，需要先引入jstl.jar --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="utils.js"></script>
<html>
<head>
  <%--
      jstl：Jsp Standard Tag Library jsp标准标签库
      jstl.jar standard.jar
  --%>
  <%--
      el表达式用来获取对象以及属性
        jsp写法：<%=session.getAttribute("name")%>
        el表达式写法：${sessionScope.name}
        注意：表达式需写在jsp的html代码块中，而不能写在<%%>之间
   --%>
  <%-- ${xxx}相当于request.getAttribute(xxx) --%>
  <title>${tittle}</title>
</head>
<body>
<form>
  <%-- ${param.xxx}是从相当于request.getParameter(xxx) --%>
  <label for="userName">用户名：</label>
  <input id="userName" name="userName" /><br/>
  <label for="password">密码：</label>
  <input id="password" name="password" /><br/>
  <input type="submit" value="提交" onclick="login()" />
</form>
</body>
</html>
<script>
  window.onload = function () {}

  function login() {
    // 1、创建XMLHttpRequest对象
    // XMLHttpRequest对象用于在后台与服务器交换数据
    let xhr = new XMLHttpRequest();
    // 2、通过open函数配置请求方法和请求地址
    xhr.open("POST", getRootPath() + "/login", true);
    // 设置请求头
    xhr.setRequestHeader("Content-Type", "application/json");
    // 3-1、添加load监听事件（回调函数）
    // xhr.addEventListener("load", function () {});
    // 3-2、或者监听服务器的返回
    xhr.onreadystatechange = function () {
      // 服务端返回的文本会赋值给XMLHttpRequest对象的responseText属性
      // readyState值为4只能证明服务端已经返回响应了，很可能是错误的响应，只要当status值同时为200时，才能证明服务端返回了正确的响应
      if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
        window.location.href = getRootPath() + xhr.responseText;
      }
    }
    let userName = document.getElementById('userName').value;
    let password = document.getElementById('password').value;
    // 4.发送请求
    xhr.send(JSON.stringify({userName: userName, password: password}));
  }
</script>