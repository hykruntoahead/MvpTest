package com.example.heyukun.mvptest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heyukun.mvptest.R;
import com.example.heyukun.mvptest.presenter.UserPresenter;

/**
 * activity 属于 MVP中的V(View）
 */

public class MainActivity extends AppCompatActivity  implements View.OnClickListener,IUserView{
    private EditText mIdEt,mFirstNameEt,mLastNameEt;
    private Button mSaveBtn,mLoadBtn;

    private UserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        mUserPresenter = new UserPresenter(this);
        mSaveBtn.setOnClickListener(this);
        mLoadBtn.setOnClickListener(this);
    }

    private void initWidgets() {
        mFirstNameEt = (EditText) findViewById(R.id.editText_FirstName);
        mLastNameEt = (EditText) findViewById(R.id.editText_LastName);
        mIdEt = (EditText) findViewById(R.id.editText_Id);

        mSaveBtn = (Button) findViewById(R.id.button_save);
        mLoadBtn = (Button) findViewById(R.id.button_load);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_save:
                mUserPresenter.saveUser(getID(),getFirstName(),getLastName());
                Toast.makeText(this,R.string.saved,Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_load:
                mUserPresenter.loadUser(getID());
                Toast.makeText(this,R.string.loaded,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    @Override
    public int getID() {
        return Integer.parseInt(TextUtils.isEmpty(mIdEt.getText().toString()) ? "0" : mIdEt.getText().toString());
    }

    @Override
    public String getFirstName() {
        return mFirstNameEt.getText().toString();
    }

    @Override
    public String getLastName() {
        return mLastNameEt.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
       mFirstNameEt.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        mLastNameEt.setText(lastName);

    }
}
