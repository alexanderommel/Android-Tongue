package com.example.tongue.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class EntryView extends View {

    private int startX=0;
    private int startY=0;
    private int endX=0;
    private int newEndX=200;
    private int newEndY=250;
    private int newEndX2=250;
    private int newEndY2=150;
    private int newEndX3=350;
    private int newEndY3=350;
    private int newEndX4=450;
    private int newEndY4=150;
    private int newEndX5=500;
    private int newEndY5=250;
    private int endY=0;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG){
        {
            setDither(true);
            setStyle(Style.STROKE);
            setColor(Color.BLACK);
        }
    };

    public EntryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(startX,startY+250,endX,startY+250,paint);
        if (endX!=200 && endY!=200){
            endX++;
            endY++;
            postInvalidateDelayed(4);
        }
        if (endX==200 && endY==200){
            canvas.drawLine(endX,startY+250,newEndX,newEndY,paint);
            if (newEndX!=300 && newEndY!=150){
                newEndX++;
                newEndY=newEndY-2;
                postInvalidateDelayed(2);
            }
        }
        if (newEndX==250 && newEndY==150){
            canvas.drawLine(newEndX,newEndY,newEndX2,newEndY2,paint);
            if (newEndX2!=350 && newEndY2!=400){
                newEndX2++;
                newEndY2=newEndY2+2;
                postInvalidateDelayed(1);
            }
        }
        if (newEndX2==350 && newEndY2==350){
            canvas.drawLine(350,350,newEndX3,newEndY3,paint);
            if (newEndX3!=450 && newEndY3!=600){
                newEndX3++;
                newEndY3=newEndY3-2;
                postInvalidateDelayed(25);
            }
        }
        if (newEndX3==450 && newEndY3==150){
            canvas.drawLine(450,150,newEndX4,newEndY4,paint);
            if (newEndX4!=500 && newEndY3!=300){
                newEndX4++;
                newEndY4=newEndY4+2;
                postInvalidateDelayed(25);
            }
        }
        if (newEndX4==500){
            canvas.drawLine(500,250,newEndX5,250,paint);
            if (newEndX5!=800){
                newEndX5++;
                newEndY5++;
                postInvalidateDelayed(4);
            }
        }


    }
}
