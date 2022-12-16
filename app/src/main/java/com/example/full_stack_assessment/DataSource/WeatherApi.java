package com.example.full_stack_assessment.DataSource;

import com.example.full_stack_assessment.Data.Forecast.Weather;
import com.example.full_stack_assessment.Data.Grid.GridCall;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WeatherApi {
    @GET
    Call<GridCall> createGridProperties(@Url String url);

    @GET
    Call<Weather> createWeatherData(@Url String url);
}
