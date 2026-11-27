package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class g0 extends android.widget.Toast implements io.dcloud.common.DHInterface.ICallBack {
    private static java.util.ArrayList f = new java.util.ArrayList();
    android.view.View a;
    android.widget.TextView b;
    android.view.WindowManager.LayoutParams c;
    android.view.WindowManager d;
    java.lang.String e;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.p.g0.this.a();
        }
    }

    public g0(android.app.Activity activity, java.lang.String str) {
        super(activity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = str;
        this.d = activity.getWindowManager();
        android.widget.TextView textView = new android.widget.TextView(activity);
        this.b = textView;
        this.a = textView;
        textView.setPadding(20, 20, 20, 20);
        android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(-2, -2, 2, 8, -2);
        this.c = layoutParams;
        layoutParams.gravity = 17;
    }

    @Override // io.dcloud.common.DHInterface.ICallBack
    public java.lang.Object onCallBack(int i, java.lang.Object obj) {
        return null;
    }

    @Override // android.widget.Toast
    public void setDuration(int i) {
        if (i == 1) {
            i = 3500;
        } else if (i == 0) {
            i = 2000;
        }
        super.setDuration(i);
    }

    @Override // android.widget.Toast
    public void setGravity(int i, int i2, int i3) {
        android.view.WindowManager.LayoutParams layoutParams = this.c;
        layoutParams.gravity = i;
        layoutParams.x = i2;
        layoutParams.y = i3;
        super.setGravity(i, i2, i3);
    }

    @Override // android.widget.Toast
    public void setText(java.lang.CharSequence charSequence) {
        this.b.setText(charSequence);
        super.setText(charSequence);
    }

    @Override // android.widget.Toast
    public synchronized void show() {
        f.add(this);
        this.d.addView(this.a, this.c);
        this.a.postDelayed(new io.dcloud.p.g0.a(), getDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        android.view.View view = this.a;
        if (view != null) {
            try {
                this.d.removeViewImmediate(view);
            } catch (java.lang.Exception unused) {
            }
            f.remove(this);
            this.a = null;
        }
    }

    public void a(android.view.View view, android.widget.TextView textView) {
        this.a = view;
        this.b = textView;
    }

    public static synchronized void a(java.lang.String str) {
        if (f.isEmpty()) {
            return;
        }
        for (int size = f.size() - 1; size >= 0; size--) {
            ((io.dcloud.p.g0) f.get(size)).a();
        }
        f.clear();
    }
}
