package com.example.full_stack_assessment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Main Activity class holds the logic for the forecast btn
 * The forecast btn starts the ForecastActivity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        observeButtonEvents();
    }

    private void observeButtonEvents() {
        Button buttonView = findViewById(R.id.button_main_activity);
        buttonView.setOnClickListener(v -> {
            handleForecastButtonClicked();
        });
    }

    private void handleForecastButtonClicked() {
        Intent intent = new Intent(this, ForecastActivity.class);
        startActivity(intent);
    }
}