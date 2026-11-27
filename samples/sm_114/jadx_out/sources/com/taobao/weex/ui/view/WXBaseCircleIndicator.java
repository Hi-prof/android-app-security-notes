package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXBaseCircleIndicator extends android.widget.FrameLayout implements com.taobao.weex.ui.view.gesture.WXGestureObservable {
    private float circlePadding;
    private int fillColor;
    private com.taobao.weex.ui.view.WXCircleViewPager mCircleViewPager;
    private androidx.viewpager.widget.ViewPager.OnPageChangeListener mListener;
    private final android.graphics.Paint mPaintFill;
    private final android.graphics.Paint mPaintPage;
    private int pageColor;
    private float radius;
    private int realCurrentItem;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public WXBaseCircleIndicator(android.content.Context context) {
        super(context);
        this.mPaintPage = new android.graphics.Paint();
        this.mPaintFill = new android.graphics.Paint();
        this.pageColor = -3355444;
        this.fillColor = -12303292;
        init();
    }

    private void init() {
        this.radius = com.taobao.weex.utils.WXViewUtils.dip2px(5.0f);
        this.circlePadding = com.taobao.weex.utils.WXViewUtils.dip2px(5.0f);
        this.pageColor = -3355444;
        this.fillColor = -12303292;
        this.mPaintFill.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaintFill.setAntiAlias(true);
        this.mPaintPage.setAntiAlias(true);
        this.mPaintPage.setColor(this.pageColor);
        this.mPaintFill.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaintFill.setColor(this.fillColor);
        setWillNotDraw(false);
    }

    public WXBaseCircleIndicator(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaintPage = new android.graphics.Paint();
        this.mPaintFill = new android.graphics.Paint();
        this.pageColor = -3355444;
        this.fillColor = -12303292;
        init();
    }

    public void setCircleViewPager(com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager) {
        this.mCircleViewPager = wXCircleViewPager;
        if (wXCircleViewPager != null) {
            if (this.mListener == null) {
                this.mListener = new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: com.taobao.weex.ui.view.WXBaseCircleIndicator.1
                    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int i) {
                        com.taobao.weex.ui.view.WXBaseCircleIndicator wXBaseCircleIndicator = com.taobao.weex.ui.view.WXBaseCircleIndicator.this;
                        wXBaseCircleIndicator.realCurrentItem = wXBaseCircleIndicator.mCircleViewPager.getRealCurrentItem();
                        com.taobao.weex.ui.view.WXBaseCircleIndicator.this.invalidate();
                    }
                };
            }
            this.mCircleViewPager.addOnPageChangeListener(this.mListener);
            int realCurrentItem = this.mCircleViewPager.getRealCurrentItem();
            this.realCurrentItem = realCurrentItem;
            if (realCurrentItem < 0) {
                this.realCurrentItem = 0;
            }
        }
        requestLayout();
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        this.mPaintFill.setColor(i);
    }

    public void setPageColor(int i) {
        this.pageColor = i;
        this.mPaintPage.setColor(i);
    }

    public int getRealCurrentItem() {
        return this.realCurrentItem;
    }

    public void setRealCurrentItem(int i) {
        this.realCurrentItem = i;
        invalidate();
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zDispatchTouchEvent : zDispatchTouchEvent;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        float f = (this.circlePadding + this.radius) * 2.0f;
        float width = (getWidth() / 2) - (((getCount() - 1) * f) / 2.0f);
        float height = (getHeight() / 2) + getPaddingTop();
        for (int i = 0; i < getCount(); i++) {
            float f2 = (i * f) + width;
            if (i != this.realCurrentItem) {
                canvas.drawCircle(f2, height, this.radius, this.mPaintPage);
            } else {
                canvas.drawCircle(f2, height, this.radius, this.mPaintFill);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int size = android.view.View.MeasureSpec.getSize(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = ((int) (getPaddingLeft() + (this.radius * 2.0f * getCount()) + (this.circlePadding * (getCount() - 1)) + getPaddingRight())) + 1;
        }
        if (mode2 != 1073741824) {
            size2 = ((int) (getPaddingTop() + (this.radius * 2.0f) + getPaddingBottom())) + 1;
        }
        setMeasuredDimension(size, size2);
    }

    public int getCount() {
        com.taobao.weex.ui.view.WXCircleViewPager wXCircleViewPager = this.mCircleViewPager;
        if (wXCircleViewPager == null || wXCircleViewPager.getAdapter() == null) {
            return 0;
        }
        return this.mCircleViewPager.getRealCount();
    }
}
