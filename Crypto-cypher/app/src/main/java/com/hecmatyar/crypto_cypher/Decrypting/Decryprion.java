package com.hecmatyar.crypto_cypher.Decrypting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hecmatyar.crypto_cypher.Encrypting.CustomAdarter;
import com.hecmatyar.crypto_cypher.R;

public class Decryprion extends Fragment {

    public Decryprion() {
    }
    public static Decryprion newInstance(String param1, String param2) {
        Decryprion fragment = new Decryprion();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_decryprion, container, false);
        String[] enc = {
                "5:Алгоритм Шенкса:Детерминированный алгоритм дискретного логарифмирования",
                "6:Исчисление порядка:Алгоритм вычисления дискретного " +
                        "алгоритма по модулю простого числа"};
        ListAdapter la = new CustomAdarter_De(getActivity(),enc);
        //ListAdapter le = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, enc);
        // ArrayList<ListviewContactItem> listContact = GetlistContact();
        ListView lv = (ListView)rootView.findViewById(R.id.decryption_list);
        lv.setAdapter(la);

        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String itemclick = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(getActivity(), itemclick, Toast.LENGTH_LONG).show();
                    }
                });

        return rootView;
    }
}
