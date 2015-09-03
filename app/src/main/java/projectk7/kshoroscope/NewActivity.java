package projectk7.kshoroscope;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import projectk7.kshoroscope.XMLParseHelper.DaylyHoroscopeCreator;

/**
 * Created by alexander.kluev on 01.09.2015.
 */
public class NewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_activity);


    }

    @Override
    public void onStart()
    {
        super.onStart();

        final TextView v = (TextView)findViewById(R.id.horo_desc);
        v.setVisibility(View.INVISIBLE);
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
                        v.setText(result);
                        dialog.dismiss();
                        v.setVisibility(View.VISIBLE);
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
}
