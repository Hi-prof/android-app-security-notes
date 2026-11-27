package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXCircleViewPager extends com.taobao.weex.ui.view.WXCircleViewPager {
    private boolean isVertical;
    private int pointCounr;

    public DCWXCircleViewPager(android.content.Context context) {
        super(context);
        this.isVertical = false;
        this.pointCounr = 0;
    }

    public DCWXCircleViewPager(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isVertical = false;
        this.pointCounr = 0;
    }

    private android.view.MotionEvent swapTouchEvent(android.view.MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    public void setVertical(boolean z) {
        this.isVertical = z;
        if (z) {
            setPageTransformer(false, new androidx.viewpager.widget.ViewPager.PageTransformer() { // from class: io.dcloud.feature.weex.extend.DCWXCircleViewPager.1
                @Override // androidx.viewpager.widget.ViewPager.PageTransformer
                public void transformPage(android.view.View view, float f) {
                    view.setTranslationX(view.getWidth() * (-f));
                    view.setTranslationY(f * view.getHeight());
                }
            });
        } else {
            setPageTransformer(false, null);
        }
    }

    @Override // com.taobao.weex.ui.view.WXCircleViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            if (this.isVertical) {
                boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(swapTouchEvent(motionEvent));
                swapTouchEvent(motionEvent);
                return zOnInterceptTouchEvent;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return super.onInterceptTouchEvent(motionEvent);
        } catch (java.lang.IllegalArgumentException e2) {
            e2.printStackTrace();
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public int getPointCounr() {
        return this.pointCounr;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0031  */
    @Override // com.taobao.weex.ui.view.WXCircleViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pointCounr = motionEvent.getPointerCount();
        } else if (action == 1 || action == 3) {
            this.pointCounr = 0;
        }
        if (this.isVertical) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
            int action2 = motionEvent.getAction();
            if (action2 == 1) {
                viewGroup.requestDisallowInterceptTouchEvent(false);
            } else if (action2 == 2) {
                viewGroup.requestDisallowInterceptTouchEvent(true);
            } else if (action2 == 3) {
                viewGroup.requestDisallowInterceptTouchEvent(false);
            }
            return super.onTouchEvent(swapTouchEvent(motionEvent));
        }
        return super.onTouchEvent(motionEvent);
    }
}
