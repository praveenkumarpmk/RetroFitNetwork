package com.example.praveen.test.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.praveen.test.APIClient;
import com.example.praveen.test.APIInterface;
import com.example.praveen.test.InputParam;
import com.example.praveen.test.LoginResponse;
import com.example.praveen.test.R;
import com.example.praveen.test.model.UserDetail.Datum;
import com.example.praveen.test.model.UserDetail.UserDetailResponse;
import com.example.praveen.test.util.AppConstant;
import com.example.praveen.test.util.RecyclerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginDetailFragment extends Fragment {
    // UI references.
    @BindView(R.id.rvUserDetail)
    RecyclerView rvUserDetail;

    private Context context;
    private RecyclerAdapter<Datum, UserDetailHolder> baseRecyclerAdapter;
    private LoginScreen loginScreen;
    private List<Datum> data = new ArrayList<>();
    private UserDetailTask userDetailTask;
    private static final String TAG = LoginDetailFragment.class.getSimpleName();

    public static LoginDetailFragment newInstance() {

        LoginDetailFragment fragment = new LoginDetailFragment();
        return fragment;
    }

    //Listener
    private RecyclerAdapter.BindAdapterListener<UserDetailHolder> offerNotificationListener =
            new RecyclerAdapter.BindAdapterListener<UserDetailHolder>() {
                @Override
                public void onBind(UserDetailHolder holder, final int position) {
                    holder.tvFirstName.setText(getFirstName(position));
                }
            };


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
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();

    }


    private void initUi() {


        Datum datum = new Datum();
        datum.setFirstName("Kadlikoa");
        Datum datum1 = new Datum();
        datum.setFirstName("Kadlikoaccc");
        Datum datum2 = new Datum();
        datum.setFirstName("Kadlikocccca");
        data.add(datum);
        data.add(datum1);
        data.add(datum2);
        initRecyclerViews(data);
        userDetailTask = new UserDetailTask();
        userDetailTask.execute();

    }

    //Init Recyclerview
    private void initRecyclerViews(List<Datum> newsDownloadList) {
        if (newsDownloadList != null && !newsDownloadList.isEmpty()) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

            rvUserDetail.setLayoutManager(layoutManager);

            baseRecyclerAdapter =
                    new RecyclerAdapter<>(context, newsDownloadList, offerNotificationListener, UserDetailHolder.class, R.layout.user_detail);
            rvUserDetail.setAdapter(baseRecyclerAdapter);

        }
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserDetailTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            performGetUserDetail();

            // TODO: register the new account here.
            return null;
        }


        @Override
        protected void onPostExecute(final Void param) {
            userDetailTask = null;
        }


    }

    private void performGetUserDetail() {
        APIInterface apiInterface;
        apiInterface = APIClient.getClient().create(APIInterface.class);


        /**
         GET List Resources
         **/

        String token = loginScreen.getToken();
        Map<String,String> headers = new HashMap<>();
        headers.put("token",token);
        headers.put("ApplicationId",AppConstant.APPLICATION_ID);
        headers.put("Content-Type","application/json");
        Call<UserDetailResponse> call = apiInterface.getUserDetail(headers);
        call.enqueue(new Callback<UserDetailResponse>() {
            @Override
            public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
                //result = true;
                UserDetailResponse loginResponse = response.body();
                userResponse(loginResponse);
                Log.d("TAG", response.code() + "");

            }

            @Override
            public void onFailure(Call<UserDetailResponse> call, Throwable t) {
                call.cancel();
                Log.i(TAG, t.toString());
                Snackbar.make(getView(), R.string.error_fetch_data, Snackbar.LENGTH_LONG).show();

            }
        });

    }

    private void userResponse(UserDetailResponse userDetailResponse) {

    }

    public String getFirstName(int position) {

        return data.get(position).getFirstName();
    }
}