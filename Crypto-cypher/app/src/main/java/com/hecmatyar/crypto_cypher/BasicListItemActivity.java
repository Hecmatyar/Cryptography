package com.hecmatyar.crypto_cypher;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hecmatyar.crypto_cypher.Calculating.Calculate;
import com.hecmatyar.crypto_cypher.Encrypting.Cypher_LGamal;
import com.hecmatyar.crypto_cypher.Encrypting.Cypher_RSA;
import com.hecmatyar.crypto_cypher.Encrypting.Cypher_Shamir;
import com.hecmatyar.crypto_cypher.Encrypting.Difi_Hellman;
import com.hecmatyar.crypto_cypher.R;

public class BasicListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);


        String activity = getIntent().getStringExtra("activity");
        String[] setactivity = activity.split(":");
        collapsingToolbar.setTitle(setactivity[1]);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction ftrans = fragmentManager.beginTransaction();

        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new Difi_Hellman();
        fragmentManager.beginTransaction().replace(R.id.setactivity, fragment).commit();

        //ftrans.replace(R.id.setactivity, new Difi_Hellman()).commit();

//        switch (setactivity[0]) {
//            case "1":
//                ftrans.replace(R.id.container, new Difi_Hellman()).commit();
//                break;
//            case "2":
//                ftrans.replace(R.id.container, new Cypher_Shamir()).commit();
//                break;
//            case "3":
//                ftrans.replace(R.id.container, new Cypher_LGamal()).commit();
//                break;
//            case "4":
//                ftrans.replace(R.id.container, new Cypher_RSA()).commit();
//                break;
//            case "5":  break;
//            case "6":  break;
//            default: break;
//        }
        //fragmentcypher
    }
}
