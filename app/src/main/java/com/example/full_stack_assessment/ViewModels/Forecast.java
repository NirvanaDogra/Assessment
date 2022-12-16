package com.example.full_stack_assessment.ViewModels;

public class Forecast {
    String temperature;
    String timeOfDay;
    String weatherType;

    Forecast(String temperature, String timeOfDay, String weatherType) {
        this.temperature = temperature;
        this.timeOfDay = timeOfDay;
        this.weatherType = weatherType;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public String getTimeOfDay() {
        return this.timeOfDay;
    }

    public String getWeatherType() {
        return this.weatherType;
    }
}
