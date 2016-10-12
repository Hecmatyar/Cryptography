package com.hecmatyar.crypto_cypher.Encrypting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hecmatyar.crypto_cypher.R;


public class Difi_Hellman extends Fragment {

    public Difi_Hellman() {
        // Required empty public constructor
    }
    public static Difi_Hellman newInstance() {
        Difi_Hellman fragment = new Difi_Hellman();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_difi__hellman, container, false);
        return rootView;
    }
}
