package com.example.mobdev_nhom7.remote;

import com.example.mobdev_nhom7.models.bookingRequest.BookingRequest;
import com.example.mobdev_nhom7.models.hotel.HotelItem;
import com.example.mobdev_nhom7.models.hotel.adapters.CardHotelAdapter;
import com.example.mobdev_nhom7.models.requestObj.feedback.FeedbackRequest;
import com.example.mobdev_nhom7.models.responseObj.DefaultResponseData;
import com.example.mobdev_nhom7.models.responseObj.DefaultResponseObj;
import com.example.mobdev_nhom7.models.responseObj.cityDetail.Alert;
import com.example.mobdev_nhom7.models.responseObj.cityDetail.Restaurant;
import com.example.mobdev_nhom7.models.responseObj.cityDetail.Todo;
import com.example.mobdev_nhom7.models.responseObj.cityDetail.Transportation;
import com.example.mobdev_nhom7.models.responseObj.cityName.CityItem;
import com.example.mobdev_nhom7.models.responseObj.comment.CommentItem;
import com.example.mobdev_nhom7.models.responseObj.places.PlaceItem;
import com.example.mobdev_nhom7.models.responseObj.ratings.RatingItem;
import com.example.mobdev_nhom7.models.responseObj.reservation.HistoryResponseObj;
import com.example.mobdev_nhom7.models.responseObj.search.SearchHotelItem;
import com.example.mobdev_nhom7.models.responseObj.search.SearchHotelResponseData;
import com.example.mobdev_nhom7.models.responseObj.trips.ActiveHotelItem;
import com.example.mobdev_nhom7.models.responseObj.trips.CancelledHotelItem;
import com.example.mobdev_nhom7.models.responseObj.trips.PastHotelItem;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @POST("auth/")
    @FormUrlEncoded
    Call<HistoryResponseObj> register(@Field("username") String username,
                                    @Field("firstname") String firstname,
                                    @Field("lastname") String lastname,
                                    @Field("email") String email,
                                    @Field("password") String password);

    @GET("hotel/{id}")
    Call <com.example.mobdev_nhom7.models.responseObj.hotel.HotelItem> getHotelInRange(@Path("id") String id,
                                                                                       @Query("start_date") String start_date,
                                                                                       @Query("end_date") String end_date);
    @GET("hotel/search?limit=10")
    Call<List<SearchHotelItem>> searchHotels(@Query("user_id") String user_id,
                                             @Query("hotel_id") String hotel_id,
                                             @Query("city") String city,
                                             @Query("start_date") String start_date,
                                             @Query("end_date") String end_date,
                                             @Query("room_quantity") String numberRoom,
                                             @Query("ppl_quantity") String numberPpl);

    @GET("hotel/detail")
    @FormUrlEncoded
    Call<SearchHotelResponseData> searchHotelDetail(@Query("id") String id);
    @GET("cities/find")
    Call<List<CityItem>> getSuggestedCity();
    @GET("hotel/favourite")
    Call<List<SearchHotelItem>> getFavouriteHotel(@Query("user_id") String user_id);
    @DELETE("hotel/favourite")
    Call<String> deleteFavouriteHotel(@Query("user_id") String user_id,
                                      @Query("hotel_id") String hotel_id);
    @POST("hotel/favourite")
    Call<String> addFavouriteHotel(@Query("user_id") String user_id,
                                      @Query("hotel_id") String hotel_id);
    @GET("hotel")
    Call<List<HotelItem>> getAllHotel();
    @GET("hotel/suggest")
    Call<List<SearchHotelItem>> getSuggestedHotel(@Query("user_id") String user_id);
    @GET("hotel/feedbacks/{id}")
    Call<List<CommentItem>> getAllFeedback(@Path("id") String id);
    @GET("hotel/favourite")
    Call<List<CardHotelAdapter>> getAllFavouriteHotels(@Query("id") String user_id);
    @GET("reservation/active/{user_id}")
    Call<List<ActiveHotelItem>> getActiveReservation(@Path("user_id") String user_id);
    @GET("reservation/cancel/{user_id}")
    Call<List<CancelledHotelItem>> getCancelReservation(@Path("user_id") String user_id);
    @GET("reservation/rated/{user_id}")
    Call<List<PastHotelItem>> getRatedReservation(@Path("user_id") String user_id);
    @GET("reservation/notRated/{user_id}")
    Call<List<PastHotelItem>> getNotRatedReservation(@Path("user_id") String user_id);
    @POST("/user/{id}")
    Call<DefaultResponseData> createUser(@Path("id") String id);

    @GET("/cities/find")
    Call<List<CityItem>> getAllCity();
    @GET("/cities/restaurant/{id}")
    Call<List<Restaurant>> getRestaurant(@Path("id") String id);

    @GET("/cities/transportation/{id}")
    Call<List<Transportation>> getTransportation(@Path("id") String id);

    @GET("/cities/todo/{id}")
    Call<List<Todo>> getTodo(@Path("id") String id);

    @GET("/cities/alert/{id}")
    Call<List<Alert>> getAlert(@Path("id") String id);

    @POST("/reservation/createFeedback")
    Call<DefaultResponseObj> postUserCommentHotel(@Body FeedbackRequest feedbackRequest);

    @PUT("/reservation/cancel/{id}")
    Call <DefaultResponseObj> cancelUserComment(@Path("id") String id );

    @POST("/reservation")
    Call<Object> booking(
            @Body BookingRequest request
    );

}