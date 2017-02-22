package com.necistudio.drag;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity  {
    private ViewGroup mRrootLayout;
    private int idimage = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRrootLayout = (ViewGroup) findViewById(R.id.root);
        FloatingActionButton floating = (FloatingActionButton)findViewById(R.id.floating);
        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idimage == 0){
                    initImage(mRrootLayout);
                }
            }
        });

    }


    private void initImage(ViewGroup view){
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams vp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(vp);
        imageView.setImageResource(R.mipmap.ic_launcher);
        view.addView(imageView);
        imageView.setOnTouchListener(new TouchObject(view));
        idimage = 1;
    }
}
