package com.taobao.weex.ui.view.refresh.core;

/* JADX INFO: loaded from: classes.dex */
public class WXRefreshView extends android.widget.FrameLayout {
    private com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar circleProgressBar;
    private android.widget.LinearLayout linearLayout;

    public WXRefreshView(android.content.Context context) {
        super(context);
        setupViews();
    }

    public WXRefreshView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        setupViews();
    }

    public WXRefreshView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setupViews();
    }

    private void setupViews() {
        this.linearLayout = new android.widget.LinearLayout(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        this.linearLayout.setOrientation(1);
        this.linearLayout.setGravity(17);
        addView(this.linearLayout, layoutParams);
    }

    public void setContentGravity(int i) {
        android.widget.LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            linearLayout.setGravity(i);
        }
    }

    public void setRefreshView(final android.view.View view) {
        if (view == null) {
            return;
        }
        post(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.view.refresh.core.WXRefreshView.1
            @Override // java.lang.Runnable
            public void run() {
                android.view.View view2 = view;
                if (view2.getParent() != null) {
                    ((android.view.ViewGroup) view.getParent()).removeView(view);
                }
                com.taobao.weex.ui.view.refresh.core.WXRefreshView.this.linearLayout.removeAllViews();
                int i = 0;
                while (true) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2;
                    if (i >= viewGroup.getChildCount()) {
                        com.taobao.weex.ui.view.refresh.core.WXRefreshView.this.linearLayout.addView(view2);
                        return;
                    }
                    android.view.View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar) {
                        com.taobao.weex.ui.view.refresh.core.WXRefreshView.this.circleProgressBar = (com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar) childAt;
                    }
                    i++;
                }
            }
        }));
    }

    public void setProgressBgColor(int i) {
        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setBackgroundColor(i);
        }
    }

    public void setProgressColor(int i) {
        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setColorSchemeColors(i);
        }
    }

    protected void startAnimation() {
        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.start();
        }
    }

    public void setStartEndTrim(float f, float f2) {
        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setStartEndTrim(f, f2);
        }
    }

    protected void stopAnimation() {
        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.stop();
        }
    }

    public void setProgressRotation(float f) {
        com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setProgressRotation(f);
        }
    }
}
