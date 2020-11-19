package com.example.lab4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONArray;

public class MyAdapter extends ArrayAdapter<String> {
    Context context;
    String [] arr ;
    public MyAdapter(Context context, String[] arr) {
        super(context,0,arr);
        this.arr = arr;
        this.context = context;
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        SearchResult result = new SearchResult(this.context,arr[position]);

        return result;
    }


}
