package com.bigademo.datetimepicker.wheel;

import android.view.MotionEvent;

final class TYLoopViewGestureListener2 extends android.view.GestureDetector.SimpleOnGestureListener {

    final TYLoopView loopView;

    TYLoopViewGestureListener2(TYLoopView loopview) {
        loopView = loopview;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        loopView.scrollBy(velocityY);
        return true;
    }
}
