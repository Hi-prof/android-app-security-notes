package com.alibaba.android.bindingx.core;

/* JADX INFO: loaded from: classes.dex */
public class PlatformManager {
    private com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator mResolutionTranslator;
    private com.alibaba.android.bindingx.core.PlatformManager.IViewFinder mViewFinder;
    private com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater mViewUpdater;

    public interface IDeviceResolutionTranslator {
        double nativeToWeb(double d, java.lang.Object... objArr);

        double webToNative(double d, java.lang.Object... objArr);
    }

    public interface IViewFinder {
        android.view.View findViewBy(java.lang.String str, java.lang.Object... objArr);
    }

    public interface IViewUpdater {
        void synchronouslyUpdateViewOnUIThread(android.view.View view, java.lang.String str, java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.Object... objArr);
    }

    private PlatformManager() {
    }

    public com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator getResolutionTranslator() {
        return this.mResolutionTranslator;
    }

    public com.alibaba.android.bindingx.core.PlatformManager.IViewFinder getViewFinder() {
        return this.mViewFinder;
    }

    public com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater getViewUpdater() {
        return this.mViewUpdater;
    }

    public static class Builder {
        private com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator deviceResolutionTranslator;
        private com.alibaba.android.bindingx.core.PlatformManager.IViewFinder viewFinder;
        private com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater viewUpdater;

        public com.alibaba.android.bindingx.core.PlatformManager build() {
            com.alibaba.android.bindingx.core.PlatformManager platformManager = new com.alibaba.android.bindingx.core.PlatformManager();
            platformManager.mViewFinder = this.viewFinder;
            platformManager.mResolutionTranslator = this.deviceResolutionTranslator;
            platformManager.mViewUpdater = this.viewUpdater;
            return platformManager;
        }

        public com.alibaba.android.bindingx.core.PlatformManager.Builder withDeviceResolutionTranslator(com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
            this.deviceResolutionTranslator = iDeviceResolutionTranslator;
            return this;
        }

        public com.alibaba.android.bindingx.core.PlatformManager.Builder withViewFinder(com.alibaba.android.bindingx.core.PlatformManager.IViewFinder iViewFinder) {
            this.viewFinder = iViewFinder;
            return this;
        }

        public com.alibaba.android.bindingx.core.PlatformManager.Builder withViewUpdater(com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater iViewUpdater) {
            this.viewUpdater = iViewUpdater;
            return this;
        }
    }
}
