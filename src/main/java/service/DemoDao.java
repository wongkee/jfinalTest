package service;

import com.jfinal.plugin.activerecord.Model;
import model.User;

import java.util.List;

public class DemoDao {

  public User findById(int id){
        User user=User.dao.findById(id);//需要注意的是这里源码返回的是Model，如果打印user 输出会为 null
        return  user;

  }

  public List<User> findAll(){
      List<User> users = User.dao.find("select * from user");
      for (User user:users) {
          System.out.println(user.getInt("user_id")+"   "+user.getStr("username")+" "+user.getStr("password"));
      }
      return  users;
  }
  public boolean addUser(String username, String password){
      boolean flg=false;
      //在数据库中添加一个用户，主键自增
      flg=new User().set("username",username).set("password",password).save();
      return  flg;
  }
  public boolean updatePassword(int userId,String password){
      boolean flg=false;
      flg=User.dao.findById(2).set("password",password).update();
      return  flg;
  }

  public User findTargetAttr(int userId,String username){
      //根据Id 之查找特定的列
      User user = User.dao.findByIdLoadColumns(userId, username);
      return user;
  }
}
