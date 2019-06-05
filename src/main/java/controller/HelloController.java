package controller;

import com.jfinal.core.Controller;
import com.jfinal.core.NotAction;


/*
* Controller类作为MVC模式中的控制器，所有基于JFinal的Web应用的控制器都需要继承该类
* 1、定义Action 方法
* Controller中定义的public方法均称为Action，Action是请求的最小单位。比如该类中有两个action
* HelloController.index()和HelloController.helloJFinal()
* 如果希望controller中的一个public方法不是action，可以使用@NotAction注解,使用URL访问notAction注解的方法时会默认访问index方法
* 如果没有index方法，则报错404
* 2、线程安全
*
* 3、获取请求中的参数  getPara
* 分为两种类型
* (1)、 getPara(String name)  获取表单或者url中问号挂参的域值
* (2) getPara(int)/getPara()  获取urlPara中的参数值
*  getRawData() 获取到了客户端传过来的 String 型的 json 数据库。
* */
public class HelloController extends Controller {
    //若不指定访问哪个方法 默认访问index方法
    public void index() {
        renderText("Hello JFinal World.");
    }

    public void helloJFinal(){
        renderText("I am helloJFinal");

    }

    @NotAction
    public void helloAction(){
        renderText("I am helloJFinal");
    }
}
