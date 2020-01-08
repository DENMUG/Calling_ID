package com.quick.tracking;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private boolean shouldReloadAd = true;
    private static ProgressDialog pd;
    private InterstitialAd interstitialAd;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void onBackPressed()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Thanks for using this app. We can help you:");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id="
                                    + getPackageName())));
                }

                dialog.dismiss();
                finish();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        alert.create();
        alert.show();


    }

    public void getStarted(View view) {
       // pd = ProgressDialog.show(this, "", "Loading Daily........", true, false);
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
        // MobileAds.initialize(this, getString(R.string.admob_app_id));
        /*interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                pd.dismiss();
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                pd.dismiss();
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                pd.dismiss();
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
            }
        });*/
        // startActivity(new Intent(this,LoanDetailActivity.class));
    }
    public void getStarted1(View view) {
       // pd = ProgressDialog.show(this, "", "Loading Premium........", true, false);
        startActivity(new Intent(MainActivity.this, Main3Activity.class));

        // MobileAds.initialize(this, getString(R.string.admob_app_id));
       /* interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                pd.dismiss();
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                pd.dismiss();
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                pd.dismiss();
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
            }
        });*/
        // startActivity(new Intent(this,LoanDetailActivity.class));
    }

    public void getStarted2(View view) {
       // pd = ProgressDialog.show(this, "", "Loading Guide........", true, false);
        startActivity(new Intent(MainActivity.this, Main4Activity.class));
        // MobileAds.initialize(this, getString(R.string.admob_app_id));
        /*interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                pd.dismiss();
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                pd.dismiss();
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                pd.dismiss();
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
            }
        });*/
        // startActivity(new Intent(this,LoanDetailActivity.class));
    }

    public void openWhatsAppChat(View view) {
        Intent sendIntent = new Intent("android.intent.action.SEND");
        sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.ContactPicker"));
        sendIntent.setType("text");
        sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators("254719108382")+"@s.whatsapp.net"); //number without '+' prefix and without '0' after country code
        sendIntent.putExtra(Intent.EXTRA_TEXT,"Hello Can you Track this Number for me?");
        startActivity(sendIntent);
    }

    public void getStarted4(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.predict.pesa.sports"));
        startActivity(intent);
    }

    public void getStarted5(View view) {


        Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);
        String url = "https://chat.whatsapp.com/BT7SlnIivrEE7wDh2vOuMf";
        intentWhatsapp.setData(Uri.parse(url));
        intentWhatsapp.setPackage("com.whatsapp");
        startActivity(intentWhatsapp);

    }

}
