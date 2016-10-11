package com.hecmatyar.crypto_cypher.Encrypting;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hecmatyar.crypto_cypher.R;

import org.xml.sax.helpers.ParserAdapter;


public class CustomAdarter extends ArrayAdapter<String> {


    public CustomAdarter(Context context, String[] enc) {
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
        int i = R.drawable.cyp1;;
        switch (a[0]) {
            case "1": i = R.drawable.cyp2; break;
            case "2": i = R.drawable.cyp3; break;
            case "3": i = R.drawable.cyp4; break;
            case "4": i = R.drawable.cyp1; break;
        }
        image.setImageResource(i);
        return customView;
    }
}
