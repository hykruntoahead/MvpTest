package com.example.heyukun.mvptest.presenter;

import com.example.heyukun.mvptest.bean.UserBean;
import com.example.heyukun.mvptest.model.IUserModel;
import com.example.heyukun.mvptest.model.UserModel;
import com.example.heyukun.mvptest.view.IUserView;

/**
 * Created by heyukun on 2017/8/15.
 * MVP 中 P 部分
 */

public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView mUserView) {
        this.mUserView = mUserView;
        mUserModel = new UserModel();
    }

    public void saveUser(int id ,String firstName,String lastName){
        mUserModel.setID(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }

    public void loadUser(int id){
        UserBean userBean = mUserModel.load(id);

        mUserView.setFirstName(userBean.getmFirstName());
        mUserView.setLastName(userBean.getmLastName());
    }


}
