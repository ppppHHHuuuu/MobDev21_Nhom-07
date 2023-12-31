package com.example.mobdev_nhom7.models.responseObj.trips;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CancelledHotelItem {
    public String getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(String reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    @SerializedName("reservation_id")
    @Expose
    private String reservation_id;
    @SerializedName("hotel_id")
    @Expose
    private String hotel_id;
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("hotel_imageURL")
    @Expose
    private String image_url;
    @SerializedName("hotel_name")
    @Expose
    private String name;
    @SerializedName("start_date")
    @Expose
    private String start_date;
    @SerializedName("total_cost")
    @Expose
    private String amount;
    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return start_date;
    }

    public void setStartDate(String start_date) {
        this.start_date = start_date;
    }

    public String getEndDate() {
        return end_date;
    }

    public void setEndDate(String end_date) {
        this.end_date = end_date;
    }

    @SerializedName("end_date")
    @Expose
    private String end_date;

    public String getUrl() {
        return image_url;
    }

    public void setUrl(String image_url) {
        this.image_url = image_url;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getImageURL() {
        return image_url;
    }

    public void setImageURL(String image_url) {
        this.image_url = image_url;
    }
}
