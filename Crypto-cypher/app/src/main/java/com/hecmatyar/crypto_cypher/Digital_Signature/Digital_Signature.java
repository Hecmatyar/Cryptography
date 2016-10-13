package com.hecmatyar.crypto_cypher.Digital_Signature;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

import com.hecmatyar.crypto_cypher.R;

public class Digital_Signature extends Fragment {

    //RSA
    EditText text_rsa_h, text_rsa_p, text_rsa_q, text_rsa_d;
    TextView text_rsa_answer_n, text_rsa_answer_fi, text_rsa_answer_c, text_rsa_answer_s, text_rsa_answer_w;

    EditText text_rsa_check_n, text_rsa_check_d,text_rsa_check_m,text_rsa_check_s;
    TextView text_rsa_check_answer;

    //LGAMAL
    EditText text_lgamal_h, text_lgamal_p, text_lgamal_g, text_lgamal_k, text_lgamal_x;
    TextView text_lgamal_answer_y, text_lgamal_answer_r, text_lgamal_answer_u, text_lgamal_answer_s, text_lgamal_answer;

    EditText text_lgamal_check_p, text_lgamal_check_g, text_lgamal_check_y;
    EditText text_lgamal_check_m, text_lgamal_check_r, text_lgamal_check_s;
    TextView text_lgamal_check_answer;


    public Digital_Signature() {
        // Required empty public constructor
    }

    public static Digital_Signature newInstance(String param1, String param2) {
        Digital_Signature fragment = new Digital_Signature();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_digital__signature, container, false);

        //RSA
        initRSA(rootview);
        ListenerRSA();
        initRSACheck(rootview);
        ListenerRSACheck();

        //Lgamal
        initLGamal(rootview);
        ListenerLGamal();
        initLGamalCheck(rootview);
        ListenerLGamalCheck();



        Button shopopup = (Button)rootview.findViewById(R.id.showpopup);
        shopopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PopUp.class));
            }
        });
        return rootview;
    }

    //RSA
    public void initRSA(View root) {
        text_rsa_h = (EditText) root.findViewById(R.id.rsa_hesh);
        text_rsa_p = (EditText) root.findViewById(R.id.rsa_p);
        text_rsa_q = (EditText) root.findViewById(R.id.rsa_q);
        text_rsa_d = (EditText) root.findViewById(R.id.rsa_d);

        text_rsa_answer_n = (TextView) root.findViewById(R.id.rsa_answer_n);
        text_rsa_answer_fi = (TextView) root.findViewById(R.id.rsa_answer_φ);
        text_rsa_answer_c = (TextView) root.findViewById(R.id.rsa_answer_c);
        text_rsa_answer_s = (TextView) root.findViewById(R.id.rsa_answer_s);
        text_rsa_answer_w = (TextView) root.findViewById(R.id.rsa_answer_w);
    }
    public void initRSACheck(View root){
        text_rsa_check_n = (EditText) root.findViewById(R.id.rsa_check_N);
        text_rsa_check_d = (EditText) root.findViewById(R.id.rsa_check_d);
        text_rsa_check_m = (EditText) root.findViewById(R.id.rsa_check_m);
        text_rsa_check_s = (EditText) root.findViewById(R.id.rsa_check_s);
        text_rsa_check_answer = (TextView) root.findViewById(R.id.rsa_check_answer);
    }

    public void ComputeRSA(){
        try{
            BigInteger rsa_answer_n, rsa_answer_fi, rsa_answer_c;
            BigInteger rsa_answer_s, rsa_answer_w, rsa_h, rsa_p, rsa_q, rsa_d;

            String string_rsa_h , string_rsa_p, string_rsa_q, string_rsa_d;

            string_rsa_h = text_rsa_h.getText().toString();
            string_rsa_d = text_rsa_d.getText().toString();
            string_rsa_p = text_rsa_p.getText().toString();
            string_rsa_q = text_rsa_q.getText().toString();

            if(!string_rsa_h.isEmpty() && !string_rsa_d.isEmpty()&& !string_rsa_p.isEmpty() && !string_rsa_q.isEmpty()){
                rsa_h = new BigInteger(string_rsa_h);
                rsa_p = new BigInteger(string_rsa_p);
                rsa_q = new BigInteger(string_rsa_q);
                rsa_d = new BigInteger(string_rsa_d);

                rsa_answer_n = rsa_p.multiply(rsa_q);
                rsa_answer_fi = rsa_p.subtract(BigInteger.ONE).multiply(rsa_q.subtract(BigInteger.ONE));
                rsa_answer_c = rsa_d.modInverse(rsa_answer_fi);
                rsa_answer_s = rsa_h.modPow(rsa_answer_c, rsa_answer_n);
                rsa_answer_w = rsa_answer_s.modPow(rsa_d,rsa_answer_n);

                text_rsa_answer_n.setText("N = " + rsa_answer_n);
                text_rsa_answer_fi.setText("φ = " + rsa_answer_fi);
                text_rsa_answer_c.setText("c = " + rsa_answer_c);
                text_rsa_answer_s.setText("S = y^c mod N = " + rsa_answer_s);

                if (rsa_answer_w.equals(rsa_h)) {
                    text_rsa_answer_w.setTextColor(getResources().getColor(R.color.color7));
                    text_rsa_answer_w.setText("Совпадение c h, ω = S^d mod N = " + rsa_answer_w);
                }
                else {
                    text_rsa_answer_w.setText("Несовпадение c h, ω = S^d mod N = " + rsa_answer_w);
                    text_rsa_answer_w.setTextColor(getResources().getColor(R.color.colorPrimary3));
                }
            }
        }
        catch(Exception ex) {
            text_rsa_answer_w.setText("Compuriong error");
            text_rsa_answer_w.setTextColor(getResources().getColor(R.color.colorPrimary3));
        }
    }
    public void ComputeRSACheck(){
        try{
            BigInteger rsa_n, rsa_d, rsa_m, rsa_s, rsa_answer_check_w;

            String string_rsa_check_n , string_rsa_check_m, string_rsa_check_d, string_rsa_check_s;

            string_rsa_check_n = text_rsa_check_n.getText().toString();
            string_rsa_check_m = text_rsa_check_m.getText().toString();
            string_rsa_check_d = text_rsa_check_d.getText().toString();
            string_rsa_check_s = text_rsa_check_s.getText().toString();

            if(!string_rsa_check_n.isEmpty() && !string_rsa_check_m.isEmpty()&&
                    !string_rsa_check_d.isEmpty() && !string_rsa_check_s.isEmpty()){

                rsa_n = new BigInteger(string_rsa_check_n);
                rsa_d = new BigInteger(string_rsa_check_d);
                rsa_m = new BigInteger(string_rsa_check_m);
                rsa_s = new BigInteger(string_rsa_check_s);

                rsa_answer_check_w = rsa_s.modPow(rsa_d,rsa_n);
                if(rsa_answer_check_w.equals(rsa_m)){
                    text_rsa_check_answer.setTextColor(getResources().getColor(R.color.color7));
                    text_rsa_check_answer.setText("Подпись подлинна, ω = m = " + rsa_answer_check_w);
                } else {
                    text_rsa_check_answer.setText("Подпись не подлинна, ω = " + rsa_answer_check_w);
                    text_rsa_check_answer.setTextColor(getResources().getColor(R.color.colorPrimary3));
                }
            }
        }
        catch(Exception ex) {
            text_rsa_answer_w.setText("Compuriong error");
            text_rsa_answer_w.setTextColor(getResources().getColor(R.color.colorPrimary3));
        }
    }

    public void ListenerRSA(){
        text_rsa_h.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeRSA();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_rsa_p.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeRSA();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_rsa_q.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeRSA();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_rsa_d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeRSA();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void ListenerRSACheck(){
        text_rsa_check_n.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeRSACheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_rsa_check_d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeRSACheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_rsa_check_m.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeRSACheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_rsa_check_s.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeRSACheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //LGAMAl
    public void initLGamal(View root) {
        text_lgamal_h = (EditText) root.findViewById(R.id.lgamal_hesh);
        text_lgamal_p = (EditText) root.findViewById(R.id.lgamal_p);
        text_lgamal_g = (EditText) root.findViewById(R.id.lgamal_g);
        text_lgamal_k = (EditText) root.findViewById(R.id.lgamal_k);
        text_lgamal_x = (EditText) root.findViewById(R.id.lgamal_x);

        text_lgamal_answer_y = (TextView) root.findViewById(R.id.lgamal_answer_y);
        text_lgamal_answer_r = (TextView) root.findViewById(R.id.lgamal_answer_r);
        text_lgamal_answer_u = (TextView) root.findViewById(R.id.lgamal_answer_u);
        text_lgamal_answer_s = (TextView) root.findViewById(R.id.lgamal_answer_s);
        text_lgamal_answer = (TextView) root.findViewById(R.id.lgamal_answer_check);
    }
    public void initLGamalCheck(View root){
        text_lgamal_check_p = (EditText) root.findViewById(R.id.lgamal_check_p);
        text_lgamal_check_g = (EditText) root.findViewById(R.id.lgamal_check_g);
        text_lgamal_check_y = (EditText) root.findViewById(R.id.lgamal_check_y);
        text_lgamal_check_m = (EditText) root.findViewById(R.id.lgamal_check_m);
        text_lgamal_check_r = (EditText) root.findViewById(R.id.lgamal_check_r);
        text_lgamal_check_s = (EditText) root.findViewById(R.id.lgamal_check_s);
        text_lgamal_check_answer = (TextView) root.findViewById(R.id.lgamal_check_answer);
    }

    public void ComputeLGamal(){
        try{
            BigInteger lgamal_answer_y, lgamal_answer_r, lgamal_answer_u, lgamal_answer_s;
            BigInteger lgamal_h, lgamal_p, lgamal_g, lgamal_k, lgamal_x, ch1, ch2;

            String string_lgamal_h , string_lgamal_p, string_lgamal_g, string_lgamal_k, string_lgamal_x;

            string_lgamal_h = text_lgamal_h.getText().toString();
            string_lgamal_p = text_lgamal_p.getText().toString();
            string_lgamal_g = text_lgamal_g.getText().toString();
            string_lgamal_k = text_lgamal_k.getText().toString();
            string_lgamal_x = text_lgamal_x.getText().toString();

            if(!string_lgamal_h.isEmpty() && !string_lgamal_g.isEmpty()&&
                    !string_lgamal_g.isEmpty() && !string_lgamal_k.isEmpty() && !string_lgamal_x.isEmpty()){
                lgamal_h = new BigInteger(string_lgamal_h);
                lgamal_p = new BigInteger(string_lgamal_p);
                lgamal_g = new BigInteger(string_lgamal_g);
                lgamal_k = new BigInteger(string_lgamal_k);
                lgamal_x = new BigInteger(string_lgamal_x);

                lgamal_answer_y = lgamal_g.modPow(lgamal_x, lgamal_p);
                lgamal_answer_r = lgamal_g.modPow(lgamal_k, lgamal_p);
                lgamal_answer_u = (lgamal_h.subtract(lgamal_x.multiply(lgamal_answer_r))).
                        mod(lgamal_p.subtract(BigInteger.ONE));
                lgamal_answer_s = ((lgamal_k.modInverse(lgamal_p.subtract(BigInteger.ONE))).
                        multiply(lgamal_answer_u)).
                        mod(lgamal_p.subtract(BigInteger.ONE));

                ch1 = (lgamal_answer_y.modPow(lgamal_answer_r,lgamal_p)).
                        multiply(lgamal_answer_r.modPow(lgamal_answer_s,lgamal_p)).
                        mod(lgamal_p);
                ch2 = lgamal_g.modPow(lgamal_h,lgamal_p);

                text_lgamal_answer_y.setText("y = g^x mod p = " + lgamal_answer_y);
                text_lgamal_answer_r.setText("r = g^k mod p = " + lgamal_answer_r);
                text_lgamal_answer_u.setText("U = (h - x*r) mod (p - 1) = " + lgamal_answer_u);
                text_lgamal_answer_s.setText("S = k^-1*u mod (p - 1) = " + lgamal_answer_s);

                if (ch1.equals(ch2)) {
                    text_lgamal_answer.setTextColor(getResources().getColor(R.color.color7));
                    text_lgamal_answer.setText("Вычисления верны    " + ch1 + " = " + ch2);
                }
                else {
                    text_lgamal_answer.setText("Вычисления не верны    " + ch1 + " != " + ch2);
                    text_lgamal_answer.setTextColor(getResources().getColor(R.color.colorPrimary3));
                }
            }
        }
        catch(Exception ex) {
            text_lgamal_answer_y.setText("y = g^x mod p = ");
            text_lgamal_answer_r.setText("r = g^k mod p = ");
            text_lgamal_answer_u.setText("U = (h - x*r) mod (p - 1) = ");
            text_lgamal_answer_s.setText("S = k^-1*u mod (p - 1) = ");
            text_lgamal_answer.setText("Compuriong error");
            text_lgamal_answer.setTextColor(getResources().getColor(R.color.colorPrimary3));
        }
    }
    public void ComputeLGamalCheck(){
        try{
            BigInteger  lgamal_m, lgamal_p, lgamal_g, lgamal_y, lgamal_r, lgamal_s, ch1, ch2;
            String string_lgamal_check_m , string_lgamal_check_p, string_lgamal_check_g;
            String string_lgamal_check_y , string_lgamal_check_r, string_lgamal_check_s;


            string_lgamal_check_m = text_lgamal_check_m.getText().toString();
            string_lgamal_check_p = text_lgamal_check_p.getText().toString();
            string_lgamal_check_g = text_lgamal_check_g.getText().toString();
            string_lgamal_check_y = text_lgamal_check_y.getText().toString();
            string_lgamal_check_r = text_lgamal_check_r.getText().toString();
            string_lgamal_check_s = text_lgamal_check_s.getText().toString();


            if(!string_lgamal_check_m.isEmpty() && !string_lgamal_check_p.isEmpty()&&
                    !string_lgamal_check_g.isEmpty() && !string_lgamal_check_y.isEmpty()&&
                    !string_lgamal_check_r.isEmpty() && !string_lgamal_check_s.isEmpty()){

                lgamal_m = new BigInteger(string_lgamal_check_m);
                lgamal_p = new BigInteger(string_lgamal_check_p);
                lgamal_g = new BigInteger(string_lgamal_check_g);
                lgamal_y = new BigInteger(string_lgamal_check_y);
                lgamal_r = new BigInteger(string_lgamal_check_r);
                lgamal_s = new BigInteger(string_lgamal_check_s);

                ch1 = (lgamal_y.modPow(lgamal_r,lgamal_p)).
                        multiply(lgamal_r.modPow(lgamal_s,lgamal_p)).
                        mod(lgamal_p);
                ch2 = lgamal_g.modPow(lgamal_m,lgamal_p);


                if(ch1.equals(ch2)){
                    text_lgamal_check_answer.setTextColor(getResources().getColor(R.color.color7));
                    text_lgamal_check_answer.setText("Подпись подлинна");
                } else {
                    text_lgamal_check_answer.setText("Подпись не подлинна");
                    text_lgamal_check_answer.setTextColor(getResources().getColor(R.color.colorPrimary3));
                }
            }
        }
        catch(Exception ex) {
            text_rsa_answer_w.setText("Compuriong error");
            text_rsa_answer_w.setTextColor(getResources().getColor(R.color.colorPrimary3));
        }
    }

    public void ListenerLGamal(){
        text_lgamal_h.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamal();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_x.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamal();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_p.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamal();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_g.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamal();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_k.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamal();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void ListenerLGamalCheck(){
        text_lgamal_check_p.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamalCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_check_g.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamalCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_check_y.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamalCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_check_m.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamalCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_check_r.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamalCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_lgamal_check_s.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ComputeLGamalCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
