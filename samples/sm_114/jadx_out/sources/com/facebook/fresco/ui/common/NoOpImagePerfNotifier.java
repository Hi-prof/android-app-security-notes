package com.facebook.fresco.ui.common;

/* JADX INFO: compiled from: NoOpImagePerfNotifier.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/facebook/fresco/ui/common/NoOpImagePerfNotifier;", "Lcom/facebook/fresco/ui/common/ImagePerfNotifier;", "<init>", "()V", "notifyVisibilityUpdated", "", "state", "Lcom/facebook/fresco/ui/common/ImagePerfState;", "visibilityState", "Lcom/facebook/fresco/ui/common/VisibilityState;", "notifyStatusUpdated", "imageLoadStatus", "Lcom/facebook/fresco/ui/common/ImageLoadStatus;", "ui-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoOpImagePerfNotifier implements com.facebook.fresco.ui.common.ImagePerfNotifier {
    public static final com.facebook.fresco.ui.common.NoOpImagePerfNotifier INSTANCE = new com.facebook.fresco.ui.common.NoOpImagePerfNotifier();

    @Override // com.facebook.fresco.ui.common.ImagePerfNotifier
    public void notifyStatusUpdated(com.facebook.fresco.ui.common.ImagePerfState state, com.facebook.fresco.ui.common.ImageLoadStatus imageLoadStatus) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageLoadStatus, "imageLoadStatus");
    }

    @Override // com.facebook.fresco.ui.common.ImagePerfNotifier
    public void notifyVisibilityUpdated(com.facebook.fresco.ui.common.ImagePerfState state, com.facebook.fresco.ui.common.VisibilityState visibilityState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibilityState, "visibilityState");
    }

    private NoOpImagePerfNotifier() {
    }
}
