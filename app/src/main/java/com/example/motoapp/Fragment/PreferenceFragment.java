package com.example.motoapp.Fragment;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.motoapp.R;

public class PreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}