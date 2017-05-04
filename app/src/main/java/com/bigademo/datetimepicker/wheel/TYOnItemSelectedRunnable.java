package com.bigademo.datetimepicker.wheel;

final class TYOnItemSelectedRunnable implements Runnable {
    final TYWheelView loopView;

    TYOnItemSelectedRunnable(TYWheelView loopview) {
        loopView = loopview;
    }

    @Override
    public final void run() {
        loopView.onItemSelectedListener.onItemSelected(loopView.getCurrentItem());
    }
}
