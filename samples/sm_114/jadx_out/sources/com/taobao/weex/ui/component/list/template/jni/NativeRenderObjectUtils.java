package com.taobao.weex.ui.component.list.template.jni;

/* JADX INFO: loaded from: classes.dex */
public class NativeRenderObjectUtils {
    public static native void nativeAddChildRenderObject(long j, long j2);

    public static native long nativeCopyRenderObject(long j);

    public static native long nativeGetRenderObject(java.lang.String str, java.lang.String str2);

    public static native int nativeLayoutRenderObject(long j, float f, float f2);

    public static native int nativeRenderObjectChildCount(long j);

    public static native void nativeRenderObjectChildWaste(long j, boolean z);

    public static native long nativeRenderObjectGetChild(long j, int i);

    public static native int nativeRenderObjectGetLayoutDirectionFromPathNode(long j);

    public static native boolean nativeRenderObjectHasNewLayout(long j);

    public static native void nativeRenderObjectUpdateComponent(long j, com.taobao.weex.ui.component.WXComponent wXComponent);

    public static native void nativeUpdateRenderObjectAttr(long j, java.lang.String str, java.lang.String str2);

    public static native void nativeUpdateRenderObjectStyle(long j, java.lang.String str, java.lang.String str2);

    public static void updateComponentSize(com.taobao.weex.ui.component.WXComponent wXComponent, float f, float f2, float f3, float f4, float f5, float f6) {
        wXComponent.updateDemission(f, f2, f3, f4, f5, f6);
        wXComponent.applyLayoutOnly();
    }
}
