package io.dcloud.feature.internal.splash;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SplashViewDBackground extends android.widget.RelativeLayout implements io.dcloud.feature.internal.splash.ISplash {
    java.lang.String a;
    io.dcloud.feature.internal.splash.a b;
    android.widget.TextView c;
    boolean d;
    private boolean e;

    public SplashViewDBackground(android.content.Context context, android.graphics.Bitmap bitmap, java.lang.String str, boolean z) {
        super(context);
        this.b = null;
        this.c = null;
        this.e = false;
        this.a = str;
        this.d = z;
        if (io.dcloud.common.util.AppRuntime.getAppDarkMode(context)) {
            setBackgroundColor(context.getResources().getColor(io.dcloud.base.R.color.nightBG));
        } else {
            setBackgroundColor(-1);
        }
        a(bitmap);
    }

    private void a(android.graphics.Bitmap bitmap) {
        float fA;
        if (this.e) {
            return;
        }
        this.b = new io.dcloud.feature.internal.splash.a(getContext(), this.d);
        int i = getResources().getDisplayMetrics().heightPixels;
        int iA = (int) this.b.a(6.0f);
        int iA2 = (int) this.b.a(65.0f);
        int iA3 = (int) this.b.a(8.0f);
        if (getResources().getDisplayMetrics().widthPixels >= 1080) {
            fA = this.b.a(6.0f);
        } else {
            if (getResources().getDisplayMetrics().widthPixels < 720) {
                if (getResources().getDisplayMetrics().widthPixels >= 540) {
                    fA = this.b.a(10.0f);
                }
                io.dcloud.feature.internal.splash.a aVar = this.b;
                aVar.a(bitmap, iA2, iA2, (int) aVar.a(1.0f), 12962246, -5592406);
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(iA2, iA2);
                layoutParams.addRule(14);
                layoutParams.topMargin = ((i / 2) - ((iA2 + iA) + iA3)) / 2;
                this.b.setId(android.R.id.button1);
                addView(this.b, layoutParams);
                android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(3, this.b.getId());
                layoutParams2.addRule(13);
                layoutParams2.topMargin = iA;
                android.widget.TextView textView = new android.widget.TextView(getContext());
                this.c = textView;
                textView.setSingleLine();
                this.c.setTextSize(iA3);
                this.c.setTextColor(-10855846);
                this.c.setId(android.R.id.button2);
                setNameText(this.a);
                this.c.setTypeface(android.graphics.Typeface.create("宋体", 0));
                addView(this.c, layoutParams2);
            }
            fA = this.b.a(8.0f);
        }
        iA3 = (int) fA;
        io.dcloud.feature.internal.splash.a aVar2 = this.b;
        aVar2.a(bitmap, iA2, iA2, (int) aVar2.a(1.0f), 12962246, -5592406);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams3.addRule(14);
        layoutParams3.topMargin = ((i / 2) - ((iA2 + iA) + iA3)) / 2;
        this.b.setId(android.R.id.button1);
        addView(this.b, layoutParams3);
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, this.b.getId());
        layoutParams4.addRule(13);
        layoutParams4.topMargin = iA;
        android.widget.TextView textView2 = new android.widget.TextView(getContext());
        this.c = textView2;
        textView2.setSingleLine();
        this.c.setTextSize(iA3);
        this.c.setTextColor(-10855846);
        this.c.setId(android.R.id.button2);
        setNameText(this.a);
        this.c.setTypeface(android.graphics.Typeface.create("宋体", 0));
        addView(this.c, layoutParams4);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (view instanceof io.dcloud.feature.internal.splash.ISplash) {
            this.e = true;
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.e) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    @Override // io.dcloud.feature.internal.splash.ISplash
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        this.b.setBitmap(bitmap);
    }

    @Override // io.dcloud.feature.internal.splash.ISplash
    public void setNameText(java.lang.String str) {
        android.widget.TextView textView = this.c;
        if (textView == null || !android.text.TextUtils.isEmpty(textView.getText())) {
            return;
        }
        this.c.setText(str);
    }
}
