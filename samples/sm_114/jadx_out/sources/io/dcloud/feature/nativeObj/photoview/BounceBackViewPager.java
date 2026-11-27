package io.dcloud.feature.nativeObj.photoview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BounceBackViewPager extends androidx.viewpager.widget.ViewPager {
    private static final float RATIO = 0.5f;
    private static final float SCROLL_WIDTH = 10.0f;
    private int currentPosition;
    private boolean handleDefault;
    private android.graphics.Rect mRect;
    private float preX;

    public BounceBackViewPager(android.content.Context context) {
        super(context);
        this.currentPosition = 0;
        this.mRect = new android.graphics.Rect();
        this.handleDefault = true;
        this.preX = 0.0f;
        if (java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) >= 9) {
            setOverScrollMode(2);
        }
    }

    private void onTouchActionUp() {
        if (this.mRect.isEmpty()) {
            return;
        }
        recoveryPosition();
    }

    private void recoveryPosition() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(getLeft(), this.mRect.left, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        startAnimation(translateAnimation);
        android.graphics.Rect rect = this.mRect;
        layout(rect.left, rect.top, rect.right, rect.bottom);
        this.mRect.setEmpty();
        this.handleDefault = true;
    }

    private void whetherConditionIsRight(float f) {
        if (this.mRect.isEmpty()) {
            this.mRect.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.handleDefault = false;
        int i = (int) (f * 0.5f);
        layout(getLeft() + i, getTop(), getRight() + i, getBottom());
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                this.preX = motionEvent.getX();
                this.currentPosition = getCurrentItem();
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (java.lang.IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            onTouchActionUp();
        } else if (action == 2) {
            if (getAdapter().getCount() == 1) {
                float x = motionEvent.getX();
                float f = x - this.preX;
                this.preX = x;
                if (f > SCROLL_WIDTH || f < -10.0f) {
                    whetherConditionIsRight(f);
                } else if (!this.handleDefault) {
                    int i = (int) (f * 0.5f);
                    if (getLeft() + i != this.mRect.left) {
                        layout(getLeft() + i, getTop(), getRight() + i, getBottom());
                    }
                }
            } else {
                int i2 = this.currentPosition;
                if (i2 == 0 || i2 == getAdapter().getCount() - 1) {
                    float x2 = motionEvent.getX();
                    float f2 = x2 - this.preX;
                    this.preX = x2;
                    if (this.currentPosition == 0) {
                        if (f2 > SCROLL_WIDTH) {
                            whetherConditionIsRight(f2);
                        } else if (!this.handleDefault) {
                            int i3 = (int) (f2 * 0.5f);
                            if (getLeft() + i3 >= this.mRect.left) {
                                layout(getLeft() + i3, getTop(), getRight() + i3, getBottom());
                            }
                        }
                    } else if (f2 < -10.0f) {
                        whetherConditionIsRight(f2);
                    } else if (!this.handleDefault) {
                        int i4 = (int) (f2 * 0.5f);
                        if (getRight() + i4 <= this.mRect.right) {
                            layout(getLeft() + i4, getTop(), getRight() + i4, getBottom());
                        }
                    }
                } else {
                    this.handleDefault = true;
                }
            }
            if (!this.handleDefault) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
