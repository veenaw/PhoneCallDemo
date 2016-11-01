package com.example.android.phonecalldemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.makeCall);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                makeCall();
            }
        });

    }
    protected void makeCall() {
        Log.i("Make call", "");
        /*PackageManager pm = getPackageManager();
        boolean telephonySupported = pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
        boolean gsmSupported =  pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA);
        boolean cdmaSupported =  pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_GSM);
        if(telephonySupported == true){
            if(gsmSupported == true){
                Toast.makeText(MainActivity.this,
                        "Telephony Support is present and it is GSM", Toast.LENGTH_LONG).show();
            }
            else if(cdmaSupported == true){
                Toast.makeText(MainActivity.this,
                        "Telephony Support is present and it is CDMA", Toast.LENGTH_LONG).show();
            }*/
            Intent phoneIntent = new Intent(Intent.ACTION_CALL);
            phoneIntent.setData(Uri.parse("tel:5556"));

            try {
                startActivity(phoneIntent);
                finish();
                Log.i("Finished calling", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this,
                        "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
            }
      // }

    }

}