1、创建maven支持的web项目   结构 mavan-archetype-webapp
2、添加依赖
```xml
<dependency>
    <groupId>com.jfinal</groupId>
    <artifactId>jfinal-undertow</artifactId>
    <version>1.6</version>
</dependency>
 
<dependency>
    <groupId>com.jfinal</groupId>
    <artifactId>jfinal</artifactId>
    <version>4.0</version>
</dependency>

<!--如果需要 WebSocket 支持，再添加一个依赖，不开发 WebSocket 无需理会-->
<dependency>
    <groupId>io.undertow</groupId>
    <artifactId>undertow-websockets-jsr</artifactId>
    <version>2.0.19.Final</version>
</dependency>

```

TODO:  
JFinalConfig 已完成  
Controller  
    接收前台传递过来的数据：
        getModel/getBean  ?
     将数据发送到前台
AOP
ActiveRecord  
Enjoy 模板引擎  
EhCachePlugin  
RedisPlugin  
...

    
