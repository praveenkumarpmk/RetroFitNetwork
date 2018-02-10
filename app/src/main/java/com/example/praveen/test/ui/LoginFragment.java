package com.example.praveen.test.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.praveen.test.APIClient;
import com.example.praveen.test.APIInterface;
import com.example.praveen.test.model.UserDetail.InputParam;
import com.example.praveen.test.model.UserDetail.LoginResponse;
import com.example.praveen.test.R;
import com.example.praveen.test.util.AppConstant;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {
    private static final String TAG = LoginFragment.class.getSimpleName();
    // UI references.
    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;

    @BindView(R.id.password)
    EditText mPasswordView;

    @BindView(R.id.email_sign_in_button)
    Button email_sign_in_button;

    @BindView(R.id.tvPleaseWait)
    TextView tvPleaseWait;

    private UserLoginTask mAuthTask=null;

    private Context context;
    private LoginScreen loginScreen;

    public static LoginFragment newInstance() {

        LoginFragment fragment = new LoginFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        loginScreen = (LoginScreen) context;
        setHasOptionsMenu(true);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();

    }


     @OnClick(R.id.email_sign_in_button)
     public void clickOnSignIn(){
         attemptLogin();

     }
    private void initUi() {
        mEmailView.setText("mndlgen@gmail.com");
        mPasswordView.setText("123456");
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            hideView();
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    private void hideView(){
        tvPleaseWait.setVisibility(View.VISIBLE);
        email_sign_in_button.setVisibility(View.INVISIBLE);

    }
    private void showView(){
        tvPleaseWait.setVisibility(View.INVISIBLE);
        email_sign_in_button.setVisibility(View.VISIBLE);
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            performLogin(mEmail,mPassword);
            // TODO: register the new account here.
            return true;
        }


        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;

           // loginScreen.loginDetailFragment();
           /* if (success) {
            //    finish();
                loginScreen.loginDetailFragment();

            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }*/
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }

    public void userResponse(LoginResponse loginResponse){
        Log.i(TAG,loginResponse.toString());
        if(null != loginResponse) {
            String token = loginResponse.getData().getToken();
            loginScreen.setToken(token);

        }
        loginScreen.loginDetailFragment();

    }

    private void performLogin(String email, String password) {

        APIInterface apiInterface;
        apiInterface = APIClient.getClient().create(APIInterface.class);

        InputParam inputParam = new InputParam(email,password);
        Map<String,String> headers = new HashMap<>();
        headers.put("ApplicationId",AppConstant.APPLICATION_ID);
        headers.put("Content-Type","application/json");
        Call<LoginResponse> call = apiInterface.doGetListResources(inputParam,headers);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d(TAG, response.code() + "");
                showView();
                if(response.code() == 200) {
                    LoginResponse loginResponse = response.body();
                    userResponse(loginResponse);
                }
                else {
                    Snackbar.make(getView(), "Error Code :: "+response.code(), Snackbar.LENGTH_LONG).show();
                }



            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                showView();
                call.cancel();
                Log.i(TAG,t.getMessage());

                Snackbar.make(getView(),R.string.error_login,Snackbar.LENGTH_LONG).show();

            }
        });

    }

}