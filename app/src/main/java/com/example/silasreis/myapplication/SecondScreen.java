package com.example.silasreis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class SecondScreen extends AppCompatActivity {

    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        AdRequest adRequest = new AdRequest.Builder().build();
        interstitial = new InterstitialAd(SecondScreen.this);
        interstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayInterstitial();
            }
        });
    }

    private void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();

        }
    }
}
