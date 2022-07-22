package com.example.customlistviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ProductAdaptor extends ArrayAdapter<Product> {

    private final Context context ; //the activity that runs the list view
    private final ArrayList<Product> products;

    public ProductAdaptor(Context context , ArrayList<Product> values)
    {
        super(context , R.layout.item_product , values);
        this.context=context;
        products=values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //this method runs for every element in the list

//        View rowView= LayoutInflater.from(context).inflate(R.layout.item_product , parent , false); //did not work!!!

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.item_product , parent , false);

        //find views
        TextView tvProduct=rowView.findViewById(R.id.tvProduct);
        TextView tvPrice=rowView.findViewById(R.id.tvPrice);
        TextView tvDescription =rowView.findViewById(R.id.tvDescription);
        ImageView ivProduct=rowView.findViewById(R.id.ivProduct);
        ImageView ivSale=rowView.findViewById(R.id.ivSale);

        //set values
        tvProduct.setText(products.get(position).getTitle());
        tvPrice.setText(String.valueOf(products.get(position).getPrice()));
        tvDescription.setText(products.get(position).getDescription());
        if (products.get(position).isSale())
        {
            ivSale.setImageResource(R.mipmap.on_sale_foreground);
        }
        else
        {
            ivSale.setImageResource(R.mipmap.best_price_foreground);
        }
        if (products.get(position).getType().equals("Memory")){
            ivProduct.setImageResource(R.mipmap.memory_foreground);
        }
        else if(products.get(position).getType().equals("Laptop"))
        {
            ivProduct.setImageResource(R.mipmap.laptop_foreground);
        }
        else if (products.get(position).getType().equals("HDD"))
        {
            ivProduct.setImageResource(R.mipmap.hdd_foreground);
        }
        else
        {
            ivProduct.setImageResource(R.mipmap.screen_foreground);
        }
        return rowView;


    }
}
