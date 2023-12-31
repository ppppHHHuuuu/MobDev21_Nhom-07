package com.example.mobdev_nhom7.fragment.main_activity.trips;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mobdev_nhom7.R;
import com.example.mobdev_nhom7.activity.ViewHotel;
import com.example.mobdev_nhom7.models.hotel.adapters.CardHotel2Adapter;
import com.example.mobdev_nhom7.models.hotel.adapters.CardHotelAdapter;
import com.example.mobdev_nhom7.models.responseObj.search.SearchHotelItem;
import com.example.mobdev_nhom7.models.responseObj.trips.ActiveHotelItem;
import com.example.mobdev_nhom7.models.responseObj.trips.ActiveHotelItem;
import com.example.mobdev_nhom7.models.responseObj.trips.adapters.CardHotelActiveTripAdapter;
import com.example.mobdev_nhom7.remote.APIService;
import com.example.mobdev_nhom7.remote.APIUtils;
import com.example.mobdev_nhom7.utils.DateTimeUtil;
import com.example.mobdev_nhom7.utils.SendID;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripsActiveFragment extends Fragment {
    private APIService apiService = APIUtils.getUserService();
    SharedPreferences preferences;
    NestedScrollView nestedScrollView;
    CardHotelActiveTripAdapter cardHotelActiveTripAdapter;
    ArrayList<ActiveHotelItem> hotelItemList;
    RecyclerView recyclerView;
    CollapsingToolbarLayout appBarLayout;
    private RelativeLayout noResultsLayout;

    public void deleteActive(int position) {
        hotelItemList.remove(position);
        if (hotelItemList.size() == 0) {
            nestedScrollView.setVisibility(View.GONE);
            noResultsLayout.setVisibility(View.VISIBLE);
        }
//        nestedScrollView.setVisibility(View.GONE);
//        noResultsLayout.setVisibility(View.VISIBLE);
        cardHotelActiveTripAdapter.notifyDataSetChanged();
    }

    public TripsActiveFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trips_active, container, false);
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        noResultsLayout = v.findViewById(R.id.noResultsLayoutActive);
        noResultsLayout.setVisibility(View.GONE);

        hotelItemList = new ArrayList<>();
        cardHotelActiveTripAdapter = new CardHotelActiveTripAdapter(requireContext(), hotelItemList, new SendID() {
            @Override
            public void go(String hotel_id, String city_id, String reservation_id) {
                Intent intent = new Intent(getContext(), ViewHotel.class);
                intent.putExtra("hotel_id", hotel_id);
                startActivity(intent);
            }
        }, this);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(cardHotelActiveTripAdapter);
        nestedScrollView= v.findViewById(R.id.nestedScrollViewActive);
        return v;
    }
    @Override
    public void onResume() {
        super.onResume();
        getUserActiveHotel();
    }
    private void getUserActiveHotel() {

        String user_id = preferences.getString("user_id", "empty user_id");
        Log.d("user_id", user_id);
        Call<List<ActiveHotelItem>> call = apiService.getActiveReservation(user_id);
        String requestUrl = call.request().url().toString();
        Log.d("Request URL", requestUrl);
        call.enqueue(new Callback<List<ActiveHotelItem>>() {
            @Override
            public void onResponse(Call<List<ActiveHotelItem>> call, Response<List<ActiveHotelItem>> response) {
                if (!response.isSuccessful()) {
                    Log.d("response error", String.valueOf(response.code()));
                    return;
                }
                if (response.body() == null) {
                    Log.d("response error", "Empty response");
                    return;
                }

                hotelItemList.clear();
                hotelItemList.addAll(response.body());
                cardHotelActiveTripAdapter.notifyDataSetChanged();

                if (hotelItemList.isEmpty()) {
                    Log.d("tripActive", "empty");
                    nestedScrollView.setVisibility(View.GONE);
                    noResultsLayout.setVisibility(View.VISIBLE);
                } else {
                    noResultsLayout.setVisibility(View.GONE);
                    nestedScrollView.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<List<ActiveHotelItem>> call, Throwable t) {
                Log.d("loadHotel",t.toString());
            }
        });
    }


}