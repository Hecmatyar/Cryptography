package com.hecmatyar.crypto_cypher.Digital_Signature;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.hecmatyar.crypto_cypher.R;

/**
 * Created by Hecmatyar on 12.10.2016.
 */
public class PopUp extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int widht = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(widht*.8),(int)(height*.6));
        Button bu = (Button) findViewById(R.id.button);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
