package com.example.praveen.test.model.UserDetail;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserDetailPost implements Serializable {
    @SerializedName("total")
    private Integer total;
    @SerializedName("per_page")
    private Integer perPage;
    @SerializedName("current_page")
    private Integer currentPage;
    @SerializedName("last_page")
    private Integer lastPage;
    @SerializedName("next_page_url")
    private Object nextPageUrl;
    @SerializedName("prev_page_url")
    private Object prevPageUrl;
    @SerializedName("from")
    private Integer from;
    @SerializedName("to")
    private Integer to;
    @SerializedName("data")
    private List<Datum> data = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Object getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(Object nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public Object getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(Object prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}