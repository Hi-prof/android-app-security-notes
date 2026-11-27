package io.dcloud.feature.weex.adapter.widget.refresh;

/* JADX INFO: loaded from: classes2.dex */
public class WeexDcRefreshLayout extends io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout {
    private boolean mDragger;
    private float mStartX;
    private float mStartY;
    private int mTouchSlop;

    public WeexDcRefreshLayout(android.content.Context context) {
        super(context);
        this.mTouchSlop = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    @Override // io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (!isViewRefresh()) {
                return false;
            }
            if (action == 0) {
                this.mStartY = motionEvent.getY();
                this.mStartX = motionEvent.getX();
                this.mDragger = false;
            } else if (action == 1) {
                this.mDragger = false;
            } else if (action != 2) {
                if (action == 3) {
                    this.mDragger = false;
                }
            } else {
                if (this.mDragger) {
                    return false;
                }
                float y = motionEvent.getY();
                float fAbs = java.lang.Math.abs(motionEvent.getX() - this.mStartX);
                float fAbs2 = java.lang.Math.abs(y - this.mStartY);
                if (fAbs > this.mTouchSlop && fAbs > fAbs2) {
                    this.mDragger = true;
                    return false;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean isViewRefresh() {
        for (int i = 0; i < getChildCount(); i++) {
            if (canScrollVertically(getChildAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean canScrollVertically(android.view.View view) {
        if (view instanceof android.view.ViewGroup) {
            if (!view.canScrollVertically(-1)) {
                int i = 0;
                while (true) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (canScrollVertically(viewGroup.getChildAt(i))) {
                        return true;
                    }
                    i++;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
