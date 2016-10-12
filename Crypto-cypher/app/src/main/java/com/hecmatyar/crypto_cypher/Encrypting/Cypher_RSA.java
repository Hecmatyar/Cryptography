package com.hecmatyar.crypto_cypher.Encrypting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hecmatyar.crypto_cypher.R;


public class Cypher_RSA extends Fragment {
    public Cypher_RSA() {
        // Required empty public constructor
    }
    public static Cypher_RSA newInstance() {
        Cypher_RSA fragment = new Cypher_RSA();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cypher__r, container, false);
    }
}
