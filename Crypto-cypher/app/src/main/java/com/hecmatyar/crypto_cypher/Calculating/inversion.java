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

public class inversion extends Fragment {


    EditText a;
    EditText b;
    EditText c;
    TextView y;

    public static inversion newInstance() {
        inversion fragment = new inversion();
        return fragment;
    }

    public inversion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inversion, container, false);
        a = (EditText) rootView.findViewById(R.id.inv_a);
        b = (EditText) rootView.findViewById(R.id.inv_b);
        c = (EditText) rootView.findViewById(R.id.inv_c);
        y = (TextView) rootView.findViewById(R.id.inv_answer);

        a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PostAnswer();
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
                PostAnswer();
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
                PostAnswer();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return rootView;
    }

    //Integer new_a, new_b, new_c, new_d, ans_x, ans_y;

    private void PostAnswer(){
        String value_a, value_b, value_c;
        value_a = a.getText().toString();
        if (value_a.isEmpty() || value_a == "0") {
            value_a = "1";
        }
        value_b = b.getText().toString();
        if (value_b.isEmpty()|| value_b == "0") {
            value_b = "1";
        }
        value_c = c.getText().toString();
        if (value_c.isEmpty()|| value_c == "0") {
            value_c ="1";
        }

        try {
            BigInteger bi1, bi2, bi3, answer;
            bi1 = new BigInteger(value_a);
            bi2 = new BigInteger(value_b);
            bi3 = new BigInteger(value_c);
            answer = bi1.modInverse(bi3);
            answer = answer.modPow(bi2, bi3);

            y.setText(answer.toString());
            }
        catch (ArithmeticException ex) {
            y.setText("Error");
        }
    }
}
