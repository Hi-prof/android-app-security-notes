package com.dcloud.android.widget.toast;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class SafeToastContext extends android.content.ContextWrapper {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private final class ApplicationContextWrapper extends android.content.ContextWrapper {
        @Override // android.content.ContextWrapper, android.content.Context
        public java.lang.Object getSystemService(java.lang.String str) {
            return "window".equals(str) ? new com.dcloud.android.widget.toast.SafeToastContext.WindowManagerWrapper((android.view.WindowManager) getBaseContext().getSystemService(str)) : super.getSystemService(str);
        }

        private ApplicationContextWrapper(android.content.Context context) {
            super(context);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private final class WindowManagerWrapper implements android.view.WindowManager {
        private static final java.lang.String TAG = "WindowManagerWrapper";
        private final android.view.WindowManager base;

        @Override // android.view.ViewManager
        public void addView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
            try {
                this.base.addView(view, layoutParams);
            } catch (android.view.WindowManager.BadTokenException e) {
                android.util.Log.i(TAG, e.getMessage());
            } catch (java.lang.Throwable th) {
                android.util.Log.e(TAG, "[addView]", th);
            }
        }

        @Override // android.view.WindowManager
        public android.view.Display getDefaultDisplay() {
            return this.base.getDefaultDisplay();
        }

        @Override // android.view.ViewManager
        public void removeView(android.view.View view) {
            this.base.removeView(view);
        }

        @Override // android.view.WindowManager
        public void removeViewImmediate(android.view.View view) {
            this.base.removeViewImmediate(view);
        }

        @Override // android.view.ViewManager
        public void updateViewLayout(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
            this.base.updateViewLayout(view, layoutParams);
        }

        private WindowManagerWrapper(android.view.WindowManager windowManager) {
            this.base = windowManager;
        }
    }

    SafeToastContext(android.content.Context context) {
        super(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.Context getApplicationContext() {
        return new com.dcloud.android.widget.toast.SafeToastContext.ApplicationContextWrapper(getBaseContext().getApplicationContext());
    }
}
