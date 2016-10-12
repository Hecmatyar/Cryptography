package com.hecmatyar.crypto_cypher;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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

        Fragment fragment = new Difi_Hellman();
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (setactivity[0]) {
            case "1":
                fragment = new Difi_Hellman();
                break;
            case "2":
                fragment = new Cypher_Shamir();
                break;
            case "3":
                fragment = new Cypher_LGamal();
                break;
            case "4":
                fragment = new Cypher_RSA();
                break;
            case "5":  break;
            case "6":  break;
            default: break;
        }
        fragmentManager.beginTransaction().add(R.id.setnewactivity, fragment).commit();
    }
}
