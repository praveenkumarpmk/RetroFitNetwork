package com.example.praveen.test.model.UserDetail;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable{


    @SerializedName("id")
    private Integer id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_lame")
    private String lastLame;
    @SerializedName("gender")
    private String gender;
    @SerializedName("username")
    private String username;
    @SerializedName("dob")
    private String dob;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("email")
    private String email;
    @SerializedName("photo")
    private String photo;
    @SerializedName("carbon_saved")
    private String carbonSaved;
    @SerializedName("total_travelled")
    private String totalTravelled;
    @SerializedName("is_vehicle_verified")
    private String isVehicleVerified;
    @SerializedName("is_personal_verified")
    private String isPersonalVerified;
    @SerializedName("is_email_verified")
    private String isEmailVerified;
    @SerializedName("has_wallet")
    private String hasWallet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastLame() {
        return lastLame;
    }

    public void setLastLame(String lastLame) {
        this.lastLame = lastLame;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCarbonSaved() {
        return carbonSaved;
    }

    public void setCarbonSaved(String carbonSaved) {
        this.carbonSaved = carbonSaved;
    }

    public String getTotalTravelled() {
        return totalTravelled;
    }

    public void setTotalTravelled(String totalTravelled) {
        this.totalTravelled = totalTravelled;
    }

    public String getIsVehicleVerified() {
        return isVehicleVerified;
    }

    public void setIsVehicleVerified(String isVehicleVerified) {
        this.isVehicleVerified = isVehicleVerified;
    }

    public String getIsPersonalVerified() {
        return isPersonalVerified;
    }

    public void setIsPersonalVerified(String isPersonalVerified) {
        this.isPersonalVerified = isPersonalVerified;
    }

    public String getIsEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(String isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public String getHasWallet() {
        return hasWallet;
    }

    public void setHasWallet(String hasWallet) {
        this.hasWallet = hasWallet;
    }

}


