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

    @BindView(R.id.tvPublic)
    public TextView tvPublic;

    @BindView(R.id.tvDate)
    public TextView tvDate;

    @BindView(R.id.tvDateTime)
    public TextView tvDateTime;

    @BindView(R.id.tvTime)
    public TextView tvTime;

    @BindView(R.id.tvFrom)
    public TextView tvFrom;

    @BindView(R.id.tvTo)
    public TextView tvTo;

    @BindView(R.id.tvDistance)
    public TextView tvDistance;





    @Keep
    public UserDetailHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
