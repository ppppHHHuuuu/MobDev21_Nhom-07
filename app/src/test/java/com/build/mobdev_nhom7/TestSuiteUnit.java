package com.build.mobdev_nhom7;

import com.build.mobdev_nhom7.activeHotels.DeleteActiveHotelTest;
import com.build.mobdev_nhom7.activeHotels.GetActiveHotelsTest;
import com.build.mobdev_nhom7.cancelledHotels.GetCancelledHotelsTest;
import com.build.mobdev_nhom7.pastHotels.GetPastHotelsTest;
import com.build.mobdev_nhom7.searchHotels.GetHotelByDateAndQuantityTest;
import com.build.mobdev_nhom7.viewCity.alerts.GetAlert;
import com.build.mobdev_nhom7.viewCity.restaurant.GetRestaurant;
import com.build.mobdev_nhom7.viewHotel.comments.GetAllFeedbackTest;
import com.build.mobdev_nhom7.favouriteHotels.PostFavoriteHotelTest;
import com.build.mobdev_nhom7.favouriteHotels.DeleteFavoriteHotelTest;
import com.build.mobdev_nhom7.searchHotels.GetAllHotelTest;
import com.build.mobdev_nhom7.searchHotels.GetSuggestedCityTest;
import com.build.mobdev_nhom7.viewHotel.comments.PostBookingTest;
import com.example.mobdev_nhom7.LoginUnitTest;
import com.example.mobdev_nhom7.NewPasswordTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LoginUnitTest.class,
    NewPasswordTest.class
})
public class TestSuiteUnit {

}
