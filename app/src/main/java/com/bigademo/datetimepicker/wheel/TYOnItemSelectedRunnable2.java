package com.bigademo.datetimepicker.wheel;

final class TYOnItemSelectedRunnable2 implements Runnable {

    final TYLoopView loopView;

    TYOnItemSelectedRunnable2(TYLoopView loopview) {
        loopView = loopview;
    }

    @Override
    public final void run() {
        loopView.onItemSelectedListener.onItemSelected(loopView.getSelectedItem());
    }
}
