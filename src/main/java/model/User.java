package model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
/*
* 基于ActiveRecord的Model无需定义属性，无需定义getter、setter方法，无需XML配置，无需Annotation配置，极大降低了代码量。
* */

    public static final User dao = new User().dao();
}
