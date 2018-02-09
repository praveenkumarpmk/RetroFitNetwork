package com.example.praveen.test.ui;

import android.support.annotation.Keep;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.praveen.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UserDetailHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvFirstName)
    public TextView tvFirstName;



    @Keep
    public UserDetailHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
