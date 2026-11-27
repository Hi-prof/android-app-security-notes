package com.facebook.fresco.ui.common;

/* JADX INFO: compiled from: ForwardingControllerListener2.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0016\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\u0014\u0010\u000b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\u0006\u0010\f\u001a\u00020\tJ+\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\t0\u0011H\u0082\bJ$\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J)\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00018\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001f\u0010 \u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0012\u0010#\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/facebook/fresco/ui/common/ForwardingControllerListener2;", "I", "Lcom/facebook/fresco/ui/common/BaseControllerListener2;", "<init>", "()V", "listeners", "", "Lcom/facebook/fresco/ui/common/ControllerListener2;", "addListener", "", "listener", "removeListener", "removeAllListeners", "forEachListener", "methodName", "", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Lkotlin/Function1;", "onSubmit", "id", "callerContext", "", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "onFinalImageSet", "imageInfo", "extraData", "(Ljava/lang/String;Ljava/lang/Object;Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;)V", "onFailure", "throwable", "", "onRelease", "onIntermediateImageSet", "(Ljava/lang/String;Ljava/lang/Object;)V", "onIntermediateImageFailed", "onEmptyEvent", "Companion", "ui-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ForwardingControllerListener2<I> extends com.facebook.fresco.ui.common.BaseControllerListener2<I> {
    private static final java.lang.String TAG = "FwdControllerListener2";
    private final java.util.List<com.facebook.fresco.ui.common.ControllerListener2<I>> listeners = new java.util.ArrayList(2);

    public final synchronized void addListener(com.facebook.fresco.ui.common.ControllerListener2<I> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final synchronized void removeListener(com.facebook.fresco.ui.common.ControllerListener2<I> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final synchronized void removeAllListeners() {
        this.listeners.clear();
    }

    private final void forEachListener(java.lang.String methodName, kotlin.jvm.functions.Function1<? super com.facebook.fresco.ui.common.ControllerListener2<I>, kotlin.Unit> block) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    block.invoke(this.listeners.get(i));
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } catch (java.lang.Exception e) {
                    java.lang.Integer.valueOf(android.util.Log.e(TAG, "InternalListener exception in " + methodName, e));
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(java.lang.String id, java.lang.Object callerContext, com.facebook.fresco.ui.common.ControllerListener2.Extras extras) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onSubmit(id, callerContext, extras);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } catch (java.lang.Exception e) {
                    java.lang.Integer.valueOf(android.util.Log.e(TAG, "InternalListener exception in onSubmit", e));
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(java.lang.String id, I imageInfo, com.facebook.fresco.ui.common.ControllerListener2.Extras extraData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onFinalImageSet(id, imageInfo, extraData);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } catch (java.lang.Exception e) {
                    java.lang.Integer.valueOf(android.util.Log.e(TAG, "InternalListener exception in onFinalImageSet", e));
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(java.lang.String id, java.lang.Throwable throwable, com.facebook.fresco.ui.common.ControllerListener2.Extras extras) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onFailure(id, throwable, extras);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } catch (java.lang.Exception e) {
                    java.lang.Integer.valueOf(android.util.Log.e(TAG, "InternalListener exception in onFailure", e));
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(java.lang.String id, com.facebook.fresco.ui.common.ControllerListener2.Extras extras) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onRelease(id, extras);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } catch (java.lang.Exception e) {
                    java.lang.Integer.valueOf(android.util.Log.e(TAG, "InternalListener exception in onRelease", e));
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(java.lang.String id, I imageInfo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onIntermediateImageSet(id, imageInfo);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } catch (java.lang.Exception e) {
                    java.lang.Integer.valueOf(android.util.Log.e(TAG, "InternalListener exception in onIntermediateImageSet", e));
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(java.lang.String id) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onIntermediateImageFailed(id);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } catch (java.lang.Exception e) {
                    java.lang.Integer.valueOf(android.util.Log.e(TAG, "InternalListener exception in onIntermediateImageFailed", e));
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onEmptyEvent(java.lang.Object callerContext) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onEmptyEvent(callerContext);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                } catch (java.lang.Exception e) {
                    java.lang.Integer.valueOf(android.util.Log.e(TAG, "InternalListener exception in onEmptyEvent", e));
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
                return;
            }
        }
    }
}
