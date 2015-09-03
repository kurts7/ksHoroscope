package projectk7.kshoroscope;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import projectk7.kshoroscope.XMLParseHelper.DaylyHoroscopeCreator;

/**
 * Created by alexander.kluev on 01.09.2015.
 */
public class NewActivity extends Activity {

    private InterstitialAd interstitial;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        //-------------------------------ADD PLACE-----------------------------------------

        AdView adView = (AdView)this.findViewById(R.id.adViewHoroScreen);

        AdRequest adRequest =new com.google.android.gms.ads.AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("e2ae6d65c5bc0ad2").build();

        //AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    @Override
    public void onStart()
    {
        super.onStart();

        final TextView v = (TextView)findViewById(R.id.horo_desc);
        v.setVisibility(View.INVISIBLE);
        final ImageView signPic = (ImageView)findViewById(R.id.signPic);
        signPic.setVisibility(View.INVISIBLE);
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Пожалуйста, подождите");
        dialog.setMessage("Идет загрузка...");
        dialog.setIndeterminate(false);
        dialog.setCancelable(false);
        dialog.show();

        String url = "http://img.ignio.com/r/export/utf/xml/daily/com.xml";

        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String result = DaylyHoroscopeCreator.getHoroscope(getIntent().getExtras().getString("sign"), "today", response);
                        int picId = getResources().getIdentifier(getIntent().getExtras().getString("sign")+"_black", "drawable", getPackageName());

                        v.setText(result);
                        signPic.setImageResource(picId);
                        dialog.dismiss();
                        v.setVisibility(View.VISIBLE);
                        signPic.setVisibility(View.VISIBLE);
                        /*Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                            }
                        }, 1000);*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();
            }
        });

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);

    }

    @Override
    public void onResume()
    {
        super.onResume();

    }

    @Override
    protected void onPause()
    {
        super.onPause();

        //ads 10% of the time :)
        int randomNum = 1 + (int)(Math.random()*10);

        if(randomNum == 5) {

            interstitial = new InterstitialAd(this);
            interstitial.setAdUnitId("ca-app-pub-1177132318340542/8371468917");

            AdRequest adRequesti = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("e2ae6d65c5bc0ad2")
                    .build();

            //AdRequest adRequesti = new AdRequest.Builder().build();

            interstitial.loadAd(adRequesti);

            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    // Call displayInterstitial() function
                    displayInterstitial();
                }

                public void displayInterstitial() {
                    // If Ads are loaded, show Interstitial else show nothing.
                    if (interstitial.isLoaded()) {
                        interstitial.show();
                    }
                }
            });
        }
    }
}
