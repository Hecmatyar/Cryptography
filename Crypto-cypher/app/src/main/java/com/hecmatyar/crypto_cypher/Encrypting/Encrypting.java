package com.hecmatyar.crypto_cypher.Encrypting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hecmatyar.crypto_cypher.BasicListItemActivity;
import com.hecmatyar.crypto_cypher.R;

public class Encrypting extends Fragment {

    public Encrypting() {
        // Required empty public constructor
    }

    public static Encrypting newInstance(String param1, String param2) {
        Encrypting fragment = new Encrypting();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_encrypting, container, false);
        String[] enc = {
                "1:Диффи - Хеллман:Формирование общего ключа без передачи секретной информации",
                "2:Шифр Шамира:Обмен секретными сообщениями по открытому каналу",
                "3:Шифр Эль - Гамаля:Основан на трудности вычисления дискретных логарифмов",
                "4:Шифр RSA:Базируется на высокой сложности разложения целых чисел на простые множители"};
        ListAdapter la = new CustomAdarter(getActivity(),enc);

        ListView lv = (ListView)rootView.findViewById(R.id.encoing_list);
        lv.setAdapter(la);

        lv.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String itemclick = String.valueOf(adapterView.getItemAtPosition(i));
                    Toast.makeText(getActivity(), itemclick, Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(getActivity(), BasicListItemActivity.class));

                    Intent intent = new Intent(getActivity(), BasicListItemActivity.class);
                    intent.putExtra("activity", itemclick);
                    startActivity(intent);
                }
        });

        return rootView;
    }
}
