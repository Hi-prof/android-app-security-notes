package com.alibaba.android.bindingx.core;

/* JADX INFO: loaded from: classes.dex */
public class BindingXPropertyInterceptor {
    private static com.alibaba.android.bindingx.core.BindingXPropertyInterceptor sInstance = new com.alibaba.android.bindingx.core.BindingXPropertyInterceptor();
    private final android.os.Handler sUIHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private final java.util.LinkedList<com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.IPropertyUpdateInterceptor> mPropertyInterceptors = new java.util.LinkedList<>();

    public interface IPropertyUpdateInterceptor {
        boolean updateView(android.view.View view, java.lang.String str, java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.Object... objArr);
    }

    private BindingXPropertyInterceptor() {
    }

    public static com.alibaba.android.bindingx.core.BindingXPropertyInterceptor getInstance() {
        return sInstance;
    }

    public void addInterceptor(com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.IPropertyUpdateInterceptor iPropertyUpdateInterceptor) {
        if (iPropertyUpdateInterceptor != null) {
            this.mPropertyInterceptors.add(iPropertyUpdateInterceptor);
        }
    }

    public boolean removeInterceptor(com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.IPropertyUpdateInterceptor iPropertyUpdateInterceptor) {
        if (iPropertyUpdateInterceptor != null) {
            return this.mPropertyInterceptors.remove(iPropertyUpdateInterceptor);
        }
        return false;
    }

    public void clear() {
        this.mPropertyInterceptors.clear();
    }

    public void performIntercept(final android.view.View view, final java.lang.String str, final java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, final java.util.Map<java.lang.String, java.lang.Object> map, final java.lang.Object... objArr) {
        if (this.mPropertyInterceptors.isEmpty()) {
            return;
        }
        this.sUIHandler.post(new com.alibaba.android.bindingx.core.WeakRunnable(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.1
            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator it = com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.this.mPropertyInterceptors.iterator();
                while (it.hasNext()) {
                    ((com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.IPropertyUpdateInterceptor) it.next()).updateView(view, str, obj, iDeviceResolutionTranslator, map, objArr);
                }
            }
        }));
    }

    public void clearCallbacks() {
        this.sUIHandler.removeCallbacksAndMessages(null);
    }

    public java.util.List<com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.IPropertyUpdateInterceptor> getInterceptors() {
        return java.util.Collections.unmodifiableList(this.mPropertyInterceptors);
    }
}
