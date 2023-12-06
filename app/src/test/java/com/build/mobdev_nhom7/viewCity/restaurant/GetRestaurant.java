package com.build.mobdev_nhom7.viewCity.restaurant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.example.mobdev_nhom7.models.responseObj.cityDetail.Alert;
import com.example.mobdev_nhom7.models.responseObj.cityDetail.Restaurant;
import com.example.mobdev_nhom7.models.responseObj.comment.CommentItem;
import com.example.mobdev_nhom7.models.responseObj.trips.ActiveHotelItem;
import com.example.mobdev_nhom7.remote.APIService;
import com.example.mobdev_nhom7.remote.APIUtils;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetRestaurant {
    APIService apiService;
    Call<List<Restaurant>> getAlert;
    Response<List<Restaurant>> response;

    @BeforeAll
    public void setup() throws IOException {
        apiService = APIUtils.getTestService();
        getAlert = apiService.getRestaurant("AOLUEoqmAt5lN8IhpQ50");
        response = getAlert.execute();
    }
    @Test
    public void testGetAlert() throws IOException {
        setup();
        assertEquals(200, response.code());

        List<Restaurant> result = response.body();
        assertNotEquals(0, result.size());

        Restaurant restaurant = result.get(0);
        assertNotNull(restaurant.getAddress());
        assertNotNull(restaurant.getImage());
        assertNotNull(restaurant.getRating());
    }
}
