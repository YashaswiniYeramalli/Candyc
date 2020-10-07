package com.example.candycrush;

import android.content.Context;
import android.media.midi.MidiOutputPort;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class OnSwipeListener implements View.OnTouchListener{
    public GestureDetector gestureDetector;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public OnSwipeListener(Context context)
    {
      gestureDetector =new GestureDetector(context, new GestureListner());
    }

    private final class GestureListner extends GestureDetector.SimpleOnGestureListener
    {
        public static final int SWIPE_THRESOLD=100;
        public static final int SWIPE_VELOCITY_THRESOLD=100;

        @Override
        public boolean onDown(MotionEvent e)
        {
            return super.onDown(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            boolean result =false;
            float yDiff =e2.getY()-e1.getY();
            float xDiff =e2.getX() - e1.getX();
            //if(Math.abs(xDiff)>Math.abs(yDiff))

            if (Math.abs(xDiff)>Math.abs(yDiff))
            {
                if(Math.abs(xDiff)>SWIPE_THRESOLD && Math.abs(velocityX)> SWIPE_VELOCITY_THRESOLD) {
                    if (xDiff > 0)//the point at which the finger touches the screen that will be the origin do if we swipe right
                    {
                        onSwipeRight();
                    } else {
                        onSwipeleft();
                    }
                    result = true;
                }
            }
            else if(Math.abs(yDiff)>SWIPE_THRESOLD && Math.abs(velocityY)> SWIPE_VELOCITY_THRESOLD)
            {
                if (yDiff > 0)//the point at which the finger touches the screen that will be the origin do if we swipe right
                {
                    onSwipeBottom();
                } else {
                    onSwipeTop();
                }
                result = true;
            }
            return result;
        }
    }
    void onSwipeleft()
    {

    }

    void onSwipeRight()
    {

    }

    void onSwipeTop()
    {

    }
    void onSwipeBottom()
    {

    }
}

