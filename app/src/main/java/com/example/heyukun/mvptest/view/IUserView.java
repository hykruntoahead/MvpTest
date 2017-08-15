package com.example.heyukun.mvptest.view;

/**
 * Created by heyukun on 2017/8/15.
 */

public interface IUserView {
    int getID();
    String getFirstName();
    String getLastName();
    void setFirstName(String firstName);
    void setLastName(String lastName);
}
