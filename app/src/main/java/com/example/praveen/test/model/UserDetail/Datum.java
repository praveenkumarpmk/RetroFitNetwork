package com.example.praveen.test.model.UserDetail;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Datum implements Serializable {

    @SerializedName("postId")
    private Integer postId;
    @SerializedName("contents")
    private Object contents;
    @SerializedName("postTimestamp")
    private String postTimestamp;
    @SerializedName("category")
    private String category;
    @SerializedName("rideId")
    private Integer rideId;
    @SerializedName("images")
    private Object images;
    @SerializedName("sharedPostId")
    private Object sharedPostId;
    @SerializedName("privacy")
    private String privacy;
    @SerializedName("userId")
    private Integer userId;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("photo")
    private String photo;
    @SerializedName("username")
    private String username;
    @SerializedName("ownerCommented")
    private Boolean ownerCommented;
    @SerializedName("comments")
    private List<Object> comments = null;
    @SerializedName("commentCount")
    private Integer commentCount;
    @SerializedName("shareCount")
    private Integer shareCount;
    @SerializedName("commented")
    private Boolean commented;
    @SerializedName("likes")
    private Integer likes;
    @SerializedName("ownerLiked")
    private Boolean ownerLiked;
    @SerializedName("liked")
    private Boolean liked;
    @SerializedName("ride")
    private Object ride;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }

    public String getPostTimestamp() {
        return postTimestamp;
    }

    public void setPostTimestamp(String postTimestamp) {
        this.postTimestamp = postTimestamp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    public Object getImages() {
        return images;
    }

    public void setImages(Object images) {
        this.images = images;
    }

    public Object getSharedPostId() {
        return sharedPostId;
    }

    public void setSharedPostId(Object sharedPostId) {
        this.sharedPostId = sharedPostId;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getOwnerCommented() {
        return ownerCommented;
    }

    public void setOwnerCommented(Boolean ownerCommented) {
        this.ownerCommented = ownerCommented;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Boolean getCommented() {
        return commented;
    }

    public void setCommented(Boolean commented) {
        this.commented = commented;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getOwnerLiked() {
        return ownerLiked;
    }

    public void setOwnerLiked(Boolean ownerLiked) {
        this.ownerLiked = ownerLiked;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Object getRide() {
        return ride;
    }

    public void setRide(Object ride) {
        this.ride = ride;
    }

}