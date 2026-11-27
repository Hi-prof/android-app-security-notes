package com.dcloud.android.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCProgressView extends android.view.View {
    int alpha;
    int curProgress;
    float h;
    android.graphics.Paint p;
    int w;
    int webviewProgress;

    public DCProgressView(android.content.Context context) {
        super(context);
        this.p = new android.graphics.Paint();
        this.curProgress = 0;
        this.webviewProgress = 0;
        this.alpha = 255;
        this.w = context.getResources().getDisplayMetrics().widthPixels;
    }

    public void fadeDisappear() {
        postDelayed(new java.lang.Runnable() { // from class: com.dcloud.android.widget.DCProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                com.dcloud.android.widget.DCProgressView dCProgressView = com.dcloud.android.widget.DCProgressView.this;
                int i = dCProgressView.alpha - 5;
                dCProgressView.alpha = i;
                if (i > 0) {
                    dCProgressView.postDelayed(this, 5L);
                } else {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) dCProgressView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(com.dcloud.android.widget.DCProgressView.this);
                    }
                }
                com.dcloud.android.widget.DCProgressView.this.invalidate();
            }
        }, 50L);
    }

    public void finishProgress() {
        updateProgress(100);
    }

    public float getHeightInt() {
        return this.h;
    }

    public boolean isFinish() {
        return this.curProgress >= this.w;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.p.setAlpha(this.alpha);
        canvas.drawRect(0.0f, 0.0f, this.curProgress, this.h, this.p);
    }

    public void setAlphaInt(int i) {
        this.alpha = i;
    }

    public void setColorInt(int i) {
        this.p.setColor(android.graphics.Color.argb(this.alpha, android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i)));
    }

    public void setCurProgress(int i) {
        this.curProgress = i;
    }

    public void setHeightInt(int i) {
        this.h = i;
    }

    public void setMaxProgress(int i) {
        this.w = i;
    }

    public void setWebviewProgress(int i) {
        this.webviewProgress = i;
    }

    public void updateProgress(int i) {
        int i2 = (this.w * i) / 100;
        if (this.curProgress >= this.webviewProgress) {
            postDelayed(new java.lang.Runnable() { // from class: com.dcloud.android.widget.DCProgressView.2
                @Override // java.lang.Runnable
                public void run() {
                    com.dcloud.android.widget.DCProgressView dCProgressView = com.dcloud.android.widget.DCProgressView.this;
                    int i3 = dCProgressView.webviewProgress;
                    int i4 = dCProgressView.curProgress;
                    int i5 = 10;
                    int i6 = (i3 - i4) / 10;
                    if (i6 <= 10) {
                        i5 = 1;
                        if (i6 >= 1) {
                            i5 = i6;
                        }
                    }
                    int i7 = i4 + i5;
                    dCProgressView.curProgress = i7;
                    if (i3 > i7) {
                        dCProgressView.postDelayed(this, 5L);
                    } else if (i3 >= dCProgressView.w) {
                        dCProgressView.fadeDisappear();
                    }
                    com.dcloud.android.widget.DCProgressView.this.invalidate();
                }
            }, 5L);
        }
        this.webviewProgress = i2;
    }
}
