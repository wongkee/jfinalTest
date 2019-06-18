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
AOP  以了解基本的使用，需进一步总结原理和分析源码
ActiveRecord  
    所有与数据库相关的逻辑 放在Service中  不要放在Model中，更不要放在Controller中，养成好的习惯，有利于大型项目的开发和维护
Enjoy 模板引擎  
EhCachePlugin  
RedisPlugin  


Session 和 Cookie比较详细的解释
https://www.cnblogs.com/whgk/p/6422391.html


JFinal中的AOP切面编程
Interceptor 对方法进行拦截，即拦截后所要进行的操作
Before  在哪拦截   包括类级  方法级拦截器
Clear  Clear用于清除自身所处层次以上层的拦截器
Inject 依赖注入  如果 在Controller或者 Interceptor中进行依赖注入  可以直接使用 @Inject。否则使用 Aop.get(...)方法进行依赖对象的创建以及注入
AOP工具
1、获取对象
2、注入
3、管理Aop的各种配置

Routes级别拦截器
Routes级别拦截器是指在Routes中添加的拦截器

##### TODO  结合Spring Action中对AOP的描述  深入理解Jfinal是如何实现AOP思想的


ActiveRecord
用途：用于操作数据库，将极大地减少代码量，极大地提升开发效率
核心：一个Model对象唯一对应数据库表中的一条记录，而对应关系依靠的是数据库表中的主键值
使用方法
1、在configPlugin中配置ActiveRecordPlugin和DruidPlugin
    （1）创建DruidPlugin对象，将其添加至配置
    （2）创建ActiveRecordPlugin 对象,将其添加至配置
    （3）为ActiveRecordPlugin 对象添加表与Model的映射关系
2、创建model，充当MVC模式中的Model部分。
    （1）继承Model类----拥有众多方便的操作数据库的方法
    （2）无需定义属性，无需定义getter、setter，无需XML配置，无需Annotation配置
    
    
为什么要再数据库层进行分页  https://blog.csdn.net/XiaoYouSiFang/article/details/5659667  
sql中的group by  https://www.cnblogs.com/lovemewoxjm/archive/2013/01/06/group_by.html
