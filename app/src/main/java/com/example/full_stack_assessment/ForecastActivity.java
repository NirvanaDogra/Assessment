package com.example.full_stack_assessment;

import android.os.Bundle;
import com.example.full_stack_assessment.ViewModels.ForecastViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * ForeCast activity navigates and manages calling the weather api
 * populating the resulting data into the forecast card
 */
public class ForecastActivity extends AppCompatActivity {

    //View model where all network calls are being preformed
    private ForecastViewModel forecastViewModel;

    //Hashmap containing possible forecasts and their corresponding icons
    private HashMap<String,Integer> forecastMap = new HashMap<String, Integer>(){{
        put("Sunny",R.drawable.ic_sun);
        put("Rain", R.drawable.ic_rain);
        put("Partially Sunny", R.drawable.ic_part_cloud);
        put("Snow",R.drawable.ic_snow);
        put("Cloud",R.drawable.ic_cloud);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        forecastViewModel = new ForecastViewModel();
        //ToDo: Fetch the results from the ViewModel and populate the forecast card
    }

}