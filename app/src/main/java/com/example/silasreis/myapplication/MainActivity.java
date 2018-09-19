package com.example.silasreis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private RewardedVideoAd mAd;
    private TextView mText;
    int moeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView)findViewById(R.id.textView);

        MobileAds.initialize(getApplicationContext(),"ca-app-pub-3940256099942544~3347511713");

        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);


        loadRewardVideoAd();

    }

    private void  loadRewardVideoAd()
    {
        if(!mAd.isLoaded())
        {
            mAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
        }
    }

    public void startVideoAd(View view)
    {
        if(mAd.isLoaded())
        {
            mAd.show();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

        loadRewardVideoAd();

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

        //moeda = 0;
        mText.setText(("Você Tem: "+ (moeda += 15)));

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    protected void onPause() {
        mAd.pause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        mAd.resume(this);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAd.destroy(this);
        super.onDestroy();
    }
}
