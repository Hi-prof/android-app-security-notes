package com.facebook.drawee.gestures;

/* JADX INFO: loaded from: classes.dex */
public class GestureDetector {
    long mActionDownTime;
    float mActionDownX;
    float mActionDownY;

    @javax.annotation.Nullable
    com.facebook.drawee.gestures.GestureDetector.ClickListener mClickListener;
    boolean mIsCapturingGesture;
    boolean mIsClickCandidate;
    final float mSingleTapSlopPx;

    public interface ClickListener {
        boolean onClick();
    }

    public GestureDetector(android.content.Context context) {
        this.mSingleTapSlopPx = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static com.facebook.drawee.gestures.GestureDetector newInstance(android.content.Context context) {
        return new com.facebook.drawee.gestures.GestureDetector(context);
    }

    public void init() {
        this.mClickListener = null;
        reset();
    }

    public void reset() {
        this.mIsCapturingGesture = false;
        this.mIsClickCandidate = false;
    }

    public void setClickListener(com.facebook.drawee.gestures.GestureDetector.ClickListener clickListener) {
        this.mClickListener = clickListener;
    }

    public boolean isCapturingGesture() {
        return this.mIsCapturingGesture;
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.facebook.drawee.gestures.GestureDetector.ClickListener clickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mIsCapturingGesture = true;
            this.mIsClickCandidate = true;
            this.mActionDownTime = motionEvent.getEventTime();
            this.mActionDownX = motionEvent.getX();
            this.mActionDownY = motionEvent.getY();
        } else if (action == 1) {
            this.mIsCapturingGesture = false;
            if (java.lang.Math.abs(motionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx || java.lang.Math.abs(motionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
                this.mIsClickCandidate = false;
            }
            if (this.mIsClickCandidate && motionEvent.getEventTime() - this.mActionDownTime <= android.view.ViewConfiguration.getLongPressTimeout() && (clickListener = this.mClickListener) != null) {
                clickListener.onClick();
            }
            this.mIsClickCandidate = false;
        } else if (action != 2) {
            if (action == 3) {
                this.mIsCapturingGesture = false;
                this.mIsClickCandidate = false;
            }
        } else if (java.lang.Math.abs(motionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx || java.lang.Math.abs(motionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
            this.mIsClickCandidate = false;
        }
        return true;
    }
}
