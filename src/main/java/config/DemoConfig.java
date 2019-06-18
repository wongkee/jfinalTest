package config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import controller.HelloController;
import controller.MyController;
import model.User;
import routes.FrontRoutes;

public class DemoConfig extends JFinalConfig {
/*
* 书写一些通用的配置
* */
    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class, 7878, true);
    }

    /*
    * 用于配置JFinal常量值  编码 视图类型 JSON解析使用的包等 都有默认值，建议使用时直接 Ctrl+单击 查看源码
    * devMode 开发模式常量， true表示Jfinal运行在开发模式
    * */
    public void configConstant(Constants me) {
        PropKit.use("config.txt");
       // me.setDevMode(true);
        me.setDevMode(PropKit.getBoolean("devMode"));
    }
        /*
    *   PropKit工具类用来读取外部键值对配置文件，PropKit可以极度方便地在系统任意时空使用
    *   配置文件格式
    *   userName=james
        email=no-reply@jfinal.com
        devMode=true

        使用方法
        PropKit.use("config.txt");
        String userName = PropKit.get("userName");
        String email = PropKit.get("email");

        // Prop 配合用法
        Prop p = PropKit.use("config.txt");
        Boolean devMode = p.getBoolean("devMode");
    * */


    /*
    * 用来配置访问路由
    * 如下代码 将 "/hello" 映射到HelloController这个控制器
    * 通过以下的配置，http://localhost/hello  将访问 HelloController.index() 方法
    * public Routes add(String controllerKey, Class<? extends Controller> controllerClass, String viewPath)
      public Routes add(String controllerKey, Class<? extends Controller> controllerClass)
    * 可以使用 setBaseViewPath()来设置基础路径
    * finalView = baseViewPath + viewPath + view
    * 路由访问规则参考文档
    *
    * 使用 @ActionKey("/login") 注解可以打破原有的路由规则
    * 可以使用Handle定制个性化路由
    * */

    public void configRoute(Routes me) {

       /*
         me.add("/hello", HelloController.class);
        me.add("/myvoice", MyController.class);
       访问cotrollerKey默认是访问其中的index方法
       http://localhost:8080/hello/  输出Hello JFinal World.
       controllerKey + methodName访问的是方法
        http://localhost:8080/hello/helloJFinal
        输出I am helloJFinal

       * 访问 MyController中的 voice方法
       * http://localhost:8080/myvoice/voice
       *
       * */
     /*
     * me.add(Routes routes)
     * 建议使用这种方法模块化开发，更易进行管理
     * 比如 将前端路由定义在FrontRoutes
     * */
       me.add(new FrontRoutes());
    }

    /*
    * 添加模板引擎
    * */
    public void configEngine(Engine me) {}

    /*
    * 配置插件 如配置Druid数据库连接池
    * */

    public void configPlugin(Plugins me) {
        //druid
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://10.27.143.11/cps?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "141540");
        me.add(dp);
        //active 插件的使用layout.html 里头的 template function
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);

        //建立表名到model之间的映射关系
        arp.addMapping("user","user_id", User.class);
    }

    /*
    * 用于配置全局拦截器，将会拦截所有的action请求，除非使用@Clear在Controller中清除
    * */
    public void configInterceptor(Interceptors me) {}

    /*
    *Handler可以接管所有web请求，并对应用拥有完全的控制权，可以很方便地实现更高层的功能性扩展。
    * */
    public void configHandler(Handlers me) {}





    public  void onStart(){
        System.out.println("项目启动前");
    }
    public  void  onStop(){
        System.out.println("项目关闭");
    }
}
