package com.example.praveen.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.praveen.test.ui.LoginDetailFragment;
import com.example.praveen.test.ui.LoginFragment;
import com.example.praveen.test.ui.LoginScreen;
import com.example.praveen.test.util.FragmentUtil;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity
        implements LoginScreen {
 private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @Override
    protected void onStart() {
        super.onStart();
        loginFragment();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    // Screens may override this function for necessary behaviours
    protected void handleBackKey() {
        finish();
    }

    protected void handleBackKeyFromStack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            handleBackKey();
        }
    }

    @Override
    public void loginFragment() {
        FragmentUtil.changeFragment(getSupportFragmentManager(), R.id.main_content, LoginFragment.newInstance());

    }

    @Override
    public void loginDetailFragment() {
        FragmentUtil.changeFragment(getSupportFragmentManager(), R.id.main_content, LoginDetailFragment.newInstance());

    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }
}
