package com.dcloud.android.widget.toast;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ToastCompat extends android.widget.Toast {
    private final android.widget.Toast toast;

    public ToastCompat(android.content.Context context) {
        super(context);
        this.toast = this;
    }

    public static com.dcloud.android.widget.toast.ToastCompat makeText(android.content.Context context, java.lang.CharSequence charSequence, int i) {
        android.widget.Toast toastMakeText = android.widget.Toast.makeText(context, charSequence, i);
        setContextCompat(toastMakeText.getView(), new com.dcloud.android.widget.toast.SafeToastContext(context));
        return new com.dcloud.android.widget.toast.ToastCompat(context, toastMakeText);
    }

    private static void setContextCompat(android.view.View view, android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT == 25) {
            try {
                java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public android.widget.Toast getBaseToast() {
        return this.toast;
    }

    @Override // android.widget.Toast
    public int getDuration() {
        android.widget.Toast toast = this.toast;
        return toast instanceof com.dcloud.android.widget.toast.ToastCompat ? super.getDuration() : toast.getDuration();
    }

    @Override // android.widget.Toast
    public int getGravity() {
        android.widget.Toast toast = this.toast;
        return toast instanceof com.dcloud.android.widget.toast.ToastCompat ? super.getGravity() : toast.getGravity();
    }

    @Override // android.widget.Toast
    public float getHorizontalMargin() {
        android.widget.Toast toast = this.toast;
        return toast instanceof com.dcloud.android.widget.toast.ToastCompat ? super.getHorizontalMargin() : toast.getHorizontalMargin();
    }

    @Override // android.widget.Toast
    public float getVerticalMargin() {
        android.widget.Toast toast = this.toast;
        return toast instanceof com.dcloud.android.widget.toast.ToastCompat ? super.getVerticalMargin() : toast.getVerticalMargin();
    }

    @Override // android.widget.Toast
    public android.view.View getView() {
        android.widget.Toast toast = this.toast;
        return toast instanceof com.dcloud.android.widget.toast.ToastCompat ? super.getView() : toast.getView();
    }

    @Override // android.widget.Toast
    public int getXOffset() {
        android.widget.Toast toast = this.toast;
        return toast instanceof com.dcloud.android.widget.toast.ToastCompat ? super.getXOffset() : toast.getXOffset();
    }

    @Override // android.widget.Toast
    public int getYOffset() {
        android.widget.Toast toast = this.toast;
        return toast instanceof com.dcloud.android.widget.toast.ToastCompat ? super.getYOffset() : toast.getYOffset();
    }

    @Override // android.widget.Toast
    public void setDuration(int i) {
        android.widget.Toast toast = this.toast;
        if (toast instanceof com.dcloud.android.widget.toast.ToastCompat) {
            super.setDuration(i);
        } else {
            toast.setDuration(i);
        }
    }

    @Override // android.widget.Toast
    public void setGravity(int i, int i2, int i3) {
        android.widget.Toast toast = this.toast;
        if (toast instanceof com.dcloud.android.widget.toast.ToastCompat) {
            super.setGravity(i, i2, i3);
        } else {
            toast.setGravity(i, i2, i3);
        }
    }

    @Override // android.widget.Toast
    public void setMargin(float f, float f2) {
        android.widget.Toast toast = this.toast;
        if (toast instanceof com.dcloud.android.widget.toast.ToastCompat) {
            super.setMargin(f, f2);
        } else {
            toast.setMargin(f, f2);
        }
    }

    @Override // android.widget.Toast
    public void setText(int i) {
        android.widget.Toast toast = this.toast;
        if (toast instanceof com.dcloud.android.widget.toast.ToastCompat) {
            super.setText(i);
        } else {
            toast.setText(i);
        }
    }

    @Override // android.widget.Toast
    public void setView(android.view.View view) {
        android.widget.Toast toast = this.toast;
        if (toast instanceof com.dcloud.android.widget.toast.ToastCompat) {
            super.setView(view);
        } else {
            toast.setView(view);
        }
        setContextCompat(view, new com.dcloud.android.widget.toast.SafeToastContext(view.getContext()));
    }

    @Override // android.widget.Toast
    public void show() {
        android.widget.Toast toast = this.toast;
        if (toast instanceof com.dcloud.android.widget.toast.ToastCompat) {
            super.show();
        } else {
            toast.show();
        }
    }

    private ToastCompat(android.content.Context context, android.widget.Toast toast) {
        super(context);
        this.toast = toast;
    }

    public static com.dcloud.android.widget.toast.ToastCompat makeText(android.content.Context context, int i, int i2) throws android.content.res.Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i), i2);
    }

    @Override // android.widget.Toast
    public void setText(java.lang.CharSequence charSequence) {
        android.widget.Toast toast = this.toast;
        if (toast instanceof com.dcloud.android.widget.toast.ToastCompat) {
            super.setText(charSequence);
        } else {
            toast.setText(charSequence);
        }
    }
}
