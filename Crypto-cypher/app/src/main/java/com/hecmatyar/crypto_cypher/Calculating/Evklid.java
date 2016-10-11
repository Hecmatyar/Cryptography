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


public class Evklid extends Fragment {

    EditText a,b;
    TextView gdc, answer_x, answer_y, d;

    public static Evklid newInstance() {
        Evklid fragment = new Evklid();
        return fragment;
    }

    public Evklid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_evklid, container, false);

        Init(rootView);
        ChangeText();

        return  rootView;
    }

    private void Init(View rootView){
        a = (EditText) rootView.findViewById(R.id.evklid_a);
        b = (EditText) rootView.findViewById(R.id.evklid_b);
        gdc = (TextView) rootView.findViewById(R.id.gdc);
        d = (TextView) rootView.findViewById(R.id.d);
        answer_x = (TextView) rootView.findViewById(R.id.answer_x);
        answer_y = (TextView) rootView.findViewById(R.id.answer_y);
    }
    private void ChangeText(){
        a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Change();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        b.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Change();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
    Integer new_a, new_b, new_d = 0 , ans_x = 0, ans_y = 0;

    private void Change(){
        String value_a, value_b;

        value_a = a.getText().toString();
        value_b = b.getText().toString();
        if(!value_a.isEmpty()){
            new_a = Integer.parseInt(value_a);
        } else value_a = "1";
        if(!value_b.isEmpty()){
            new_b = Integer.parseInt(value_b);
        } else value_b = "1";
        gdc.setText("gcd (" + value_a + " , " + value_b + " )");

        try{
            extended_euclid();
            answer_x.setText("x = " + ans_x.toString() + ";");
            answer_y.setText("y = " + ans_y.toString() + ";");

            d.setText(gdc.getText().toString() + " = " + new_d.toString());
        }
        catch (ArithmeticException ex) {

        }

    }
    private void extended_euclid()
    {
        try {
            Integer q, v3 = 1, v2 = 0, v1, u3 = 0, u2 = 1, u1, t1, t2, t3;
            u1 = new_a; v1 = new_b;

            while (v1 != 0) {
                q = u1 / v1;
                t1 = u1 % v1;
                t2 = u2 - q * v2;
                t3 = u3 - q * v3;

                u1 = v1; u2 = v2; u3 = v3;
                v1 = t1; v2 = t2; v3 = t3;
            }
            new_d = u1;
            ans_x = u2;
            ans_y = u3;
        }
        catch (Exception ex){}
    }
}
