package projectk7.kshoroscope;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    public static String[] signs = {"aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius", "pisces"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(String sign: signs)
        {
            setClickListenerToImageButton(sign);
        }

        //-------------------------------ADD PLACE-----------------------------------------

        AdView adView = (AdView)this.findViewById(R.id.adViewMainScreen);

        AdRequest adRequest =new com.google.android.gms.ads.AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("e2ae6d65c5bc0ad2").build();

        //AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener myButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent myIntent = new Intent(MainActivity.this,
                    NewActivity.class);

            myIntent.putExtra("sign", getResources().getResourceEntryName(v.getId()));
            startActivity(myIntent);

        }
    };

    private void setClickListenerToImageButton(String id)
    {
        int buttonId = this.getResources().getIdentifier(id, "id", this.getPackageName());
        ImageButton imageButton = (ImageButton)findViewById(buttonId);
        imageButton.setOnClickListener(myButtonClickListener);
    }
}
