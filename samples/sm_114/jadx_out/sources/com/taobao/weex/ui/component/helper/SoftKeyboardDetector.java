package com.taobao.weex.ui.component.helper;

/* JADX INFO: loaded from: classes.dex */
public class SoftKeyboardDetector {
    private static final int KEYBOARD_VISIBLE_THRESHOLD_DIP = 100;

    public interface OnKeyboardEventListener {
        void onKeyboardEvent(boolean z);
    }

    public interface Unregister {
        void execute();
    }

    public static com.taobao.weex.ui.component.helper.SoftKeyboardDetector.Unregister registerKeyboardEventListener(android.app.Activity activity, final com.taobao.weex.ui.component.helper.SoftKeyboardDetector.OnKeyboardEventListener onKeyboardEventListener) {
        android.view.WindowManager.LayoutParams attributes;
        int i;
        if (activity == null || onKeyboardEventListener == null) {
            com.taobao.weex.utils.WXLogUtils.e("Activity or listener is null!");
            return null;
        }
        if (activity.getWindow() != null && (attributes = activity.getWindow().getAttributes()) != null && ((i = attributes.softInputMode) == 48 || i == 32)) {
            com.taobao.weex.utils.WXLogUtils.e("SoftKeyboard detector can't work with softInputMode is SOFT_INPUT_ADJUST_NOTHING or SOFT_INPUT_ADJUST_PAN");
            return null;
        }
        final android.view.View activityRoot = getActivityRoot(activity);
        if (activityRoot == null) {
            com.taobao.weex.utils.WXLogUtils.e("Activity root is null!");
            return null;
        }
        android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.taobao.weex.ui.component.helper.SoftKeyboardDetector.1
            private final android.graphics.Rect visibleFrame = new android.graphics.Rect();
            private final int threshold = com.taobao.weex.utils.WXViewUtils.dip2px(100.0f);
            private boolean wasKeyboardOpened = false;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                activityRoot.getWindowVisibleDisplayFrame(this.visibleFrame);
                boolean z = activityRoot.getRootView().getHeight() - this.visibleFrame.height() > this.threshold;
                if (z == this.wasKeyboardOpened) {
                    return;
                }
                this.wasKeyboardOpened = z;
                onKeyboardEventListener.onKeyboardEvent(z);
            }
        };
        activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        return new com.taobao.weex.ui.component.helper.SoftKeyboardDetector.DefaultUnRegister(activity, onGlobalLayoutListener);
    }

    public static boolean isKeyboardVisible(android.app.Activity activity) {
        android.graphics.Rect rect = new android.graphics.Rect();
        android.view.View activityRoot = getActivityRoot(activity);
        if (activityRoot != null) {
            activityRoot.getWindowVisibleDisplayFrame(rect);
            if (activityRoot.getRootView().getHeight() - rect.height() > com.taobao.weex.utils.WXViewUtils.dip2px(100.0f)) {
                return true;
            }
        }
        return false;
    }

    public static android.view.View getActivityRoot(android.app.Activity activity) {
        if (activity != null) {
            return activity.findViewById(android.R.id.content);
        }
        return null;
    }

    public static final class DefaultUnRegister implements com.taobao.weex.ui.component.helper.SoftKeyboardDetector.Unregister {
        private java.lang.ref.WeakReference<android.app.Activity> activityRef;
        private java.lang.ref.WeakReference<android.view.ViewTreeObserver.OnGlobalLayoutListener> listenerRef;

        public DefaultUnRegister(android.app.Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.activityRef = new java.lang.ref.WeakReference<>(activity);
            this.listenerRef = new java.lang.ref.WeakReference<>(onGlobalLayoutListener);
        }

        @Override // com.taobao.weex.ui.component.helper.SoftKeyboardDetector.Unregister
        public void execute() {
            android.view.View activityRoot;
            android.app.Activity activity = this.activityRef.get();
            android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.listenerRef.get();
            if (activity != null && onGlobalLayoutListener != null && (activityRoot = com.taobao.weex.ui.component.helper.SoftKeyboardDetector.getActivityRoot(activity)) != null) {
                activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.activityRef.clear();
            this.listenerRef.clear();
        }
    }
}
