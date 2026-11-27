package com.dmcbig.mediapicker.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class HackyViewPager extends androidx.viewpager.widget.ViewPager {
    public HackyViewPager(android.content.Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (java.lang.IllegalArgumentException unused) {
            return false;
        }
    }

    public HackyViewPager(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
