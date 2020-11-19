package com.example.lab4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class SearchResult extends View {
    Paint names = new Paint();
    String name="";
    public SearchResult(Context context, String name) {
        super(context);
        this.name = name;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(500,80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        names.setColor(Color.BLACK);
        names.setTextSize(50 );


        if(name != null) {
            canvas.drawText(name, 100, 80, names);
        }
        else {
            canvas.drawText("", 40, 50, names);
        }

    }
}

