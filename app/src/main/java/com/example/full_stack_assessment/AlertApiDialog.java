package com.example.full_stack_assessment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class AlertApiDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setTitle(R.string.api_failed_title_dialog_fragment_alert)
                .setMessage(R.string.api_failed_dialog_fragment_alert)
                .setCancelable(false)
                .create();
    }
}
