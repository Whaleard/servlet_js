# servlet_js
JavaWeb的三大组件分别是：Servlet程序、Filter过滤器、Listener监听器

# 浏览器、Cookie、Session
1、客户端在没有任何Cookie信息的情况下给浏览器发送请求
2、服务器通过Request的getSession()创建回话对象
   服务器每次创建Session回话的时候，都会创建一个Cookie对象。
   这个Cookie对象的key永远是JSESSIONID，值是新创建出来的Session的id值。
3、服务器通过响应把新创建出来的Session值返回给客户端。
4、浏览器解析收到的数据，就马上创建出一个Cookie对象。
5、后面有了Cookie之后，每次请求，都会把Session的id以Cookie的形式发送给服务器。
6、服务器再通过getSession()创建回话对象时，就会通过Cookie中的id值找到自己之前创建好的Session对象，并返回。
注：Session技术，底层其实是基于Cookie技术来实现的。