package controller;

import com.jfinal.core.Controller;
import model.User;
import service.DemoDao;

public class MyController extends Controller {
    public  void voice(){
        System.out.println("I am voice");
        renderText("I am voice!!!");
    }
    public void testDao(){
        DemoDao demoDao=new DemoDao();
        User user= demoDao.findById(2);
        int userId=user.getInt("user_id");
        String username= user.getStr("username");
        String password= user.getStr("password");
        demoDao.findAll();
        renderText(userId+"  "+username+ " "+password);

   /*    boolean flg= demoDao.addUser("wangwu","321");
        if(flg){
            System.out.println("添加成功");
        }
*/
        if(demoDao.updatePassword(2,"890")){
            System.out.println("更新成功");
        }

        User user1=demoDao.findTargetAttr(2,"username");
        System.out.println("Id为2 的用户名为"+user1.getStr("username"));
    }

}
