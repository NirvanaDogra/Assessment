package com.example.full_stack_assessment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.full_stack_assessment.ViewModels.ForecastViewModel;

import java.util.HashMap;

/**
 * ForeCast activity navigates and manages calling the weather api
 * populating the resulting data into the forecast card
 */
public class ForecastActivity extends AppCompatActivity {
    final private String API_ALERT = "API Alert";
    final private String SUNNY = "Sunny";
    final private String THIS = "This";
    final private String SPACE = " ";
    //View model where all network calls are being preformed
    private ForecastViewModel viewModel;
    private  ProgressBar progressBar = null;

    //Hashmap containing possible forecasts and their corresponding icons
    private HashMap<String, Integer> forecastMap = new HashMap<String, Integer>() {{
        put("Sunny", R.drawable.ic_sun);
        put("Mostly Clear", R.drawable.ic_sun);
        put("Mostly Sunny", R.drawable.ic_sun);
        put("Rain", R.drawable.ic_rain);
        put("Areas Of Drizzle", R.drawable.ic_rain);
        put("Chance Light Rain", R.drawable.ic_rain);
        put("Patchy Drizzle", R.drawable.ic_rain);
        put("Partly Sunny", R.drawable.ic_part_cloud);
        put("Snow", R.drawable.ic_snow);
        put("Slight Chance Light Snow", R.drawable.ic_snow);
        put("Cloud", R.drawable.ic_cloud);
        put("Partly Cloudy", R.drawable.ic_cloud);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        initializeView();
        observeLiveData();
    }

    /**
     * This function is observing the live data holding value about the
     * forecast retrieved from the API
     * the current state of the api LOADING, ERROR or DONE
     */
    private void observeLiveData() {
        viewModel.forecast.observe(this, forecast -> {
            setForecast(forecast.getTemperature(), forecast.getTimeOfDay(), forecast.getWeatherType());
        });

        viewModel.status.observe(this, status -> {
            progressBar.setVisibility(View.GONE);
            switch (status) {
                case DONE:
                    break;
                case ERROR:
                    showAlertDialogBox();
                    break;
                case LOADING:
                    showLoadingScreen();
            }
        });
    }

    private void showLoadingScreen() {
        progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * This function show an error dialog box the the API produces an error
     */
    private void showAlertDialogBox() {
        AlertApiDialog alert = new AlertApiDialog();
        alert.show(getSupportFragmentManager(), API_ALERT);
    }

    /**
     * THis function set the values for the weather icon, the text for temperature and
     * timeOfDay
     * @param temperature This is the temperature in F
     * @param timeOfDay This can be either afternoon, evening, or morning
     * @param shortDescription This can be the type of weather eg sunny
     */
    private void setForecast(String temperature, String timeOfDay, String shortDescription) {
        ImageView imgForecastIcon = findViewById(R.id.image_view_forecast);
        TextView textViewTimeOfDay = findViewById(R.id.text_view_time);
        TextView textViewTemperature = findViewById(R.id.text_view_degree);
        textViewTemperature.setText(temperature);
        String thisTimeOfDay = THIS + SPACE + timeOfDay;
        textViewTimeOfDay.setText(thisTimeOfDay);
        try {
            imgForecastIcon.setImageResource(forecastMap.get(shortDescription));
        } catch (NullPointerException e) {
            imgForecastIcon.setImageResource(forecastMap.get(SUNNY));
        }
    }

    private void initializeView() {
        viewModel = new ViewModelProvider(this).get(ForecastViewModel.class);
        progressBar = findViewById(R.id.progress_forecast);
    }

}