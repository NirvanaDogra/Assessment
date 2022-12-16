package com.example.full_stack_assessment.ViewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.full_stack_assessment.Data.Forecast.Weather;
import com.example.full_stack_assessment.Data.Grid.GridCall;
import com.example.full_stack_assessment.DataSource.WeatherApi;
import com.google.android.gms.maps.model.LatLng;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * The ForecastViewModel sets the UI state of the ForecastActivity
 * It asynchronously calls the National Weather API and returns a Json
 * A Gson builder converts the returning Json into objects found in the data directory
 */
public class ForecastViewModel extends ViewModel {

    private String BASE_URL = "https://api.weather.gov/";

    private final LatLng location = new LatLng(40.091135131249494, -88.24013532344047);

    //Variables used for the final weather GET request
    private String gridId = "";
    private int gridX;
    private int gridY;

    //Network status holder
    private MutableLiveData<APIStatus> _status = new MutableLiveData<>();
    public LiveData<APIStatus> status = _status;

    //Retrofit REST Network caller
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //Initialize national Weather Api class
    private WeatherApi weatherApi = retrofit.create(WeatherApi.class);

    //Api call on init of the viewModel
    public ForecastViewModel(){
        makeGridApiCall();
    }

    public void makeGridApiCall(){
        _status.postValue(APIStatus.LOADING);

        try{
            getGridProperties();

        }catch(Exception e){
            Log.e("Forecast ViewModel Grid",e.toString());
            _status.postValue(APIStatus.ERROR);
        }
    }

    /**
     * Sends GET request to the weather api with a location point
     * Manipulates a GridCall type object
     */
    private void getGridProperties(){
        //The additional url
        String locationString = "points/"+ location.latitude + "," + location.longitude;

        //The GET call using Retrofit
        Call<GridCall> call = weatherApi.createGridProperties(locationString);

        //The asynchronous GET request
        call.enqueue(new Callback<GridCall>(){
            @Override
            public void onResponse(Call<GridCall> call, Response<GridCall> response) {

                //The first Api response will be put into a GridCall object
                GridCall gridCall = response.body();

                //Fill in the grid variables for the second weather api call
                if(gridCall != null) {
                    gridId = gridCall.getGridProperties().getGridID();
                    gridX = gridCall.getGridProperties().getGridX();
                    gridY = gridCall.getGridProperties().getGridY();
                }
                //Preform the final API call
                getWeatherProperties();
            }

            @Override
            public void onFailure(Call<GridCall> call, Throwable t) {
                Log.e("Forecast ViewModel Grid Call",t.toString());
                _status.postValue(APIStatus.ERROR);
            }
        });
    }

    /**
     * Sends GET request to the weather api with grid data
     * Manipulates a Weather type object
     */
    private void getWeatherProperties(){
        //ToDO: Write your own api call
    }
}










