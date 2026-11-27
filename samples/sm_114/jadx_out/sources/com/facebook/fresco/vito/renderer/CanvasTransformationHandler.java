package com.facebook.fresco.vito.renderer;

/* JADX INFO: compiled from: CanvasTransformationHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/fresco/vito/renderer/CanvasTransformationHandler;", "", "canvasTransformation", "Lcom/facebook/fresco/vito/renderer/CanvasTransformation;", "<init>", "(Lcom/facebook/fresco/vito/renderer/CanvasTransformation;)V", "getCanvasTransformation", "()Lcom/facebook/fresco/vito/renderer/CanvasTransformation;", "setCanvasTransformation", "tempMatrix", "Landroid/graphics/Matrix;", "drawMatrix", "getMatrix", "configure", "", "bounds", "Landroid/graphics/Rect;", "childWidth", "", "childHeight", "renderer_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CanvasTransformationHandler {
    private com.facebook.fresco.vito.renderer.CanvasTransformation canvasTransformation;
    private android.graphics.Matrix drawMatrix;
    private final android.graphics.Matrix tempMatrix;

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasTransformationHandler() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CanvasTransformationHandler(com.facebook.fresco.vito.renderer.CanvasTransformation canvasTransformation) {
        this.canvasTransformation = canvasTransformation;
        this.tempMatrix = new android.graphics.Matrix();
    }

    public /* synthetic */ CanvasTransformationHandler(com.facebook.fresco.vito.renderer.CanvasTransformation canvasTransformation, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : canvasTransformation);
    }

    public final com.facebook.fresco.vito.renderer.CanvasTransformation getCanvasTransformation() {
        return this.canvasTransformation;
    }

    public final void setCanvasTransformation(com.facebook.fresco.vito.renderer.CanvasTransformation canvasTransformation) {
        this.canvasTransformation = canvasTransformation;
    }

    /* JADX INFO: renamed from: getMatrix, reason: from getter */
    public final android.graphics.Matrix getDrawMatrix() {
        return this.drawMatrix;
    }

    public final void configure(android.graphics.Rect bounds, int childWidth, int childHeight) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (childWidth <= 0 || childHeight <= 0) {
            this.drawMatrix = null;
        } else {
            com.facebook.fresco.vito.renderer.CanvasTransformation canvasTransformation = this.canvasTransformation;
            this.drawMatrix = canvasTransformation != null ? canvasTransformation.calculateTransformation(this.tempMatrix, bounds, childWidth, childHeight) : null;
        }
    }
}
