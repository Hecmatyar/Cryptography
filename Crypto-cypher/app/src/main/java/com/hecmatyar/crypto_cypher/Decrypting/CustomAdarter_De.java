package com.hecmatyar.crypto_cypher.Decrypting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hecmatyar.crypto_cypher.R;


public class CustomAdarter_De extends ArrayAdapter<String> {


    public CustomAdarter_De(Context context, String[] enc) {
        super(context, R.layout.custom_row_list ,enc);
        //String[] enc = {"Диффи - Хеллмана","Шифр Шамира","Шифр Эль - Гамаля","Шифр RSA"};

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(getContext());
        View customView = li.inflate(R.layout.custom_row_list, parent, false);
        String singleItem = getItem(position);
        TextView title = (TextView) customView.findViewById(R.id.ecrypting_title);
        TextView sub = (TextView) customView.findViewById(R.id.ecrypting_sub);
        ImageView image = (ImageView) customView.findViewById(R.id.ecryption_image);

        String[] a = singleItem.split(":");
        title.setText(a[1]);
        sub.setText(a[2]);
        int i = R.drawable.decyp1;;
        switch (a[0]) {
            case "5": i = R.drawable.decyp1; break;
            case "6": i = R.drawable.decyp2; break;
        }
        image.setImageResource(i);
        return customView;
    }
}
