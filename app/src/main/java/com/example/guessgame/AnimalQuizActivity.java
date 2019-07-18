package com.example.guessgame;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class AnimalQuizActivity extends AppCompatActivity {
    Context mContext;
    ImageButton aib;
    String[] imagename={"lion","tapir","proboscismonkey","redpanda","turtle"};
    Set<Integer> s;
    Set<Integer> sb;
    Button next,b1,b2,b3,b4;
    int id;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_display);
        aib=findViewById(R.id.pic);
        next=findViewById(R.id.next);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        s=new <Integer> HashSet();
        sb=new <Integer> HashSet();
        double randomDouble = Math.random();
        randomDouble = randomDouble * 5;
        int randomInt = (int) randomDouble;
        id = getResources().getIdentifier(imagename[randomInt], "drawable", getPackageName());
        s.add(randomInt);
        aib.setImageResource(id);
        aib.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int rb;
        double rd;
        rd = Math.random()*4;
        rb = (int) rd;int flag=rb;
        if(rb==0)
            b1.setText(imagename[randomInt]);
        if(rb==1)
            b2.setText(imagename[randomInt]);
        if(rb==2)
            b3.setText(imagename[randomInt]);
        if(rb==3)
            b4.setText(imagename[randomInt]);
        int temp=rb;
        while(sb.size()<3)
        {
            rd = Math.random() * 4;
            rb = (int) rd;
            if(rb==temp||rb==randomInt)
                continue;
            else {
                sb.add(rb);

                temp = rb;
            }
        }
        Log.d("ADebugTag", "Value: " + sb.toString());
        int a[]=new int[3];int j=0;
        for(int i:sb)
        {
            a[j++]=i;
        }
        if(flag==0)
        {
            b2.setText(imagename[a[0]]);
            b3.setText(imagename[a[1]]);
            b4.setText(imagename[a[2]]);
        }
        else if(flag==1)
        {
            b1.setText(imagename[a[0]]);
            b3.setText(imagename[a[1]]);
            b4.setText(imagename[a[2]]);
        }
        else if(flag==2)
        {
            b2.setText(imagename[a[0]]);
            b1.setText(imagename[a[1]]);
            b4.setText(imagename[a[2]]);
        }
        else
        {
            b2.setText(imagename[a[0]]);
            b3.setText(imagename[a[1]]);
            b1.setText(imagename[a[2]]);
        }
        mContext=this;
    }
    public void onSubmit(View view) {

    }

    public void next(View view) {
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            sb.removeAll(sb);
            int randomInt;
            double randomDouble;
            randomDouble = Math.random();
            randomDouble = randomDouble * 5;
            randomInt = (int) randomDouble;
            while (s.contains(randomInt)) {
                randomDouble = Math.random();
                randomDouble = randomDouble * 5;
                randomInt = (int) randomDouble;
            }
            id = getResources().getIdentifier(imagename[randomInt], "drawable", getPackageName());
            s.add(randomInt);
            aib.setImageResource(id);
            aib.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int rb;
            double rd;
            rd = Math.random()*4;
            rb = (int) rd;int flag=rb;
            if(rb==0)
                b1.setText(imagename[randomInt]);
            else if(rb==1)
                b2.setText(imagename[randomInt]);
            else if(rb==2)
                b3.setText(imagename[randomInt]);
            else
                b4.setText(imagename[randomInt]);
            int temp=rb;
            while(sb.size()<3)
            {
                rd = Math.random() * 4;
                rb = (int) rd;
                if(rb==temp||rb==randomInt)
                    continue;
                else {
                    sb.add(rb);

                    temp = rb;
                }
            }
        Log.d("ADebugTag", "Value: " + sb.toString());
            int a[]=new int[3];int j=0;
            for(int i:sb)
            {
                a[j++]=i;
            }
            if(flag==0)
            {
                b2.setText(imagename[a[0]]);
                b3.setText(imagename[a[1]]);
                b4.setText(imagename[a[2]]);
            }
            else if(flag==1)
            {
                b1.setText(imagename[a[0]]);
                b3.setText(imagename[a[1]]);
                b4.setText(imagename[a[2]]);
            }
            else if(flag==2)
            {
                b2.setText(imagename[a[0]]);
                b1.setText(imagename[a[1]]);
                b4.setText(imagename[a[2]]);
            }
            else
            {
                b2.setText(imagename[a[0]]);
                b3.setText(imagename[a[1]]);
                b1.setText(imagename[a[2]]);
            }
            if(s.size()==imagename.length)
            {
                next.setEnabled(false);
                Toast.makeText(mContext,"here",Toast.LENGTH_SHORT);
            }
    }
}
