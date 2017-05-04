package com.bigademo.datetimepicker.wheel;

import android.view.MotionEvent;

final class TYLoopViewGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {

    final TYWheelView loopView;

    TYLoopViewGestureListener(TYWheelView loopview) {
        loopView = loopview;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        loopView.scrollBy(velocityY);
        return true;
    }
}
