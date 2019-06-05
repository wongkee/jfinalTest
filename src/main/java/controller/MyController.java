package controller;

import com.jfinal.core.Controller;
import model.User;

public class MyController extends Controller {
    public  void voice(){
        System.out.println("I am voice");
        renderText("I am voice!!!");
    }
 /*
  public void test(){
       // new User().set("user_id",2).set("username","lisi").set("password","123").save();
       //User user=User.dao.findById(2);
       renderText(user.toString()); //将数据存储进数据库
    }
    */
}
