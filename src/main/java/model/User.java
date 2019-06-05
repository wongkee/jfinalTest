package model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
    private  int user_id;
    private  String name;
    private String password;
    public static final User dao = new User().dao();

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
