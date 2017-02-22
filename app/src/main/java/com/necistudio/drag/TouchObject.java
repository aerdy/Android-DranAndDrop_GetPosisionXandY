package com.necistudio.drag;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by vim on 21/02/17.
 */

public class TouchObject implements View.OnTouchListener {
    private ViewGroup viewGroup;

    public TouchObject(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
    }

    private int deltaX;
    private int deltaY;

    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                deltaX = X - lParams.leftMargin;
                deltaY = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                layoutParams.leftMargin = X - deltaX;
                layoutParams.topMargin = Y - deltaY;
                layoutParams.rightMargin = -100;
                layoutParams.bottomMargin = -250;
                view.setLayoutParams(layoutParams);
                Log.e("data x", String.valueOf((X - deltaX) + 23));
                Log.e("data x", String.valueOf((Y - deltaY) + 15));
                break;
        }
        viewGroup.invalidate();
        return true;
    }
}
