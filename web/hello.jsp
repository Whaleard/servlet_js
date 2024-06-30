<%--
  Created by IntelliJ IDEA.
  User: issuser
  Date: 2022/10/31
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="utils.js"></script>
<html>
  <head>
    <%-- ${}相当于 --%>
    <title>${tittle}</title>
  </head>
  <body>
    <form>
      <%-- ${param.xxx}是从相当于request.getParameter() --%>
      <input id="userName" name="userName" value="${param.userName}" />
    </form>
  </body>
</html>
<script>
  window.onload = function () {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", getRootPath() + "/hello", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
  }
</script>
