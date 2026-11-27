package com.facebook.imagepipeline.filter;

/* JADX INFO: compiled from: RenderScriptBlurFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/imagepipeline/filter/RenderScriptBlurFilter;", "", "<init>", "()V", "BLUR_MAX_RADIUS", "", "blurBitmap", "", "dest", "Landroid/graphics/Bitmap;", "src", "context", "Landroid/content/Context;", "radius", "canUseRenderScript", "", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RenderScriptBlurFilter {
    public static final int BLUR_MAX_RADIUS = 25;
    public static final com.facebook.imagepipeline.filter.RenderScriptBlurFilter INSTANCE = new com.facebook.imagepipeline.filter.RenderScriptBlurFilter();

    @kotlin.jvm.JvmStatic
    public static final boolean canUseRenderScript() {
        return true;
    }

    private RenderScriptBlurFilter() {
    }

    @kotlin.jvm.JvmStatic
    public static final void blurBitmap(android.graphics.Bitmap dest, android.graphics.Bitmap src, android.content.Context context, int radius) throws java.lang.Throwable {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dest, "dest");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(src, "src");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(radius > 0 && radius <= 25));
        android.renderscript.RenderScript renderScript = null;
        try {
            android.renderscript.RenderScript renderScriptCreate = android.renderscript.RenderScript.create(context);
            if (renderScriptCreate == null) {
                throw new java.lang.IllegalStateException("Required value was null.".toString());
            }
            try {
                android.renderscript.ScriptIntrinsicBlur scriptIntrinsicBlurCreate = android.renderscript.ScriptIntrinsicBlur.create(renderScriptCreate, android.renderscript.Element.U8_4(renderScriptCreate));
                android.renderscript.Allocation allocationCreateFromBitmap = android.renderscript.Allocation.createFromBitmap(renderScriptCreate, src);
                if (allocationCreateFromBitmap == null) {
                    throw new java.lang.IllegalStateException("Required value was null.".toString());
                }
                android.renderscript.Allocation allocationCreateFromBitmap2 = android.renderscript.Allocation.createFromBitmap(renderScriptCreate, dest);
                if (allocationCreateFromBitmap2 == null) {
                    throw new java.lang.IllegalStateException("Required value was null.".toString());
                }
                scriptIntrinsicBlurCreate.setRadius(radius);
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                allocationCreateFromBitmap2.copyTo(dest);
                scriptIntrinsicBlurCreate.destroy();
                allocationCreateFromBitmap.destroy();
                allocationCreateFromBitmap2.destroy();
                if (renderScriptCreate != null) {
                    renderScriptCreate.destroy();
                    return;
                }
                return;
            } catch (java.lang.Throwable th) {
                th = th;
                renderScript = renderScriptCreate;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        if (renderScript != null) {
            renderScript.destroy();
        }
        throw th;
    }
}
