package com.example.heyukun.mvptest.model;

import com.example.heyukun.mvptest.bean.UserBean;

/**
 * Created by heyukun on 2017/8/15.
 */

public interface IUserModel {
    void setID(int id);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    int getID();
    //通过ID读取user信息，返回一个userBean
    UserBean load(int id);
}
