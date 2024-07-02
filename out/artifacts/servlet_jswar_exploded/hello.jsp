<%--
  Created by IntelliJ IDEA.
  User: Mr.MC
  Date: 2022/10/31
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <input id="userName" name="userName" value="${param.userName}" />
      <input id="password" name="password" value="${param.password}" />
    </form>
  </body>
</html>
<script>
  window.onload = function () {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", getRootPath() + "/hello", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
  }
</script>
