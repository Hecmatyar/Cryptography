package com.hecmatyar.crypto_cypher.Calculating;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.hecmatyar.crypto_cypher.R;

import java.math.BigInteger;



public class Exponent extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText a;
    EditText b;
    EditText c;
    TextView y;

    public static Exponent newInstance() {

        Exponent fragment = new Exponent();
        return fragment;
    }

    public Exponent() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_exponent, container, false);
        a = (EditText) rootView.findViewById(R.id.number_a);
        b = (EditText) rootView.findViewById(R.id.number_b);
        c = (EditText) rootView.findViewById(R.id.number_c);
        y = (TextView) rootView.findViewById(R.id.answer);

        a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Consider();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        b.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Consider();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        c.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Consider();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return rootView;
    }

    private void Consider() {
        //try {
        String value_a, value_b, value_c;
        value_a = a.getText().toString();
        if (value_a.isEmpty()) {
            value_a = "1";
        }
        value_b = b.getText().toString();
        if (value_b.isEmpty()) {
            value_b = "1";
        }
        value_c = c.getText().toString();
        if (value_c.isEmpty()) {
            value_c = "1";
        }

        try {
            BigInteger bi1, bi2, bi3, bi4;
            bi1 = new BigInteger(value_a);
            bi2 = new BigInteger(value_b);
            bi3 = new BigInteger(value_c);
            try {
                bi4 = bi1.modPow(bi2, bi3);
                y.setText(bi4 + "");
            } catch (ArithmeticException ex) {
                y.setText("Error");
            }
        } catch (Exception ex){

        }
    }

}
