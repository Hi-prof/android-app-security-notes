package io.dcloud.feature.weex.adapter.Fresco;

/* JADX INFO: loaded from: classes2.dex */
public class DCGenericDraweeView extends com.facebook.drawee.view.DraweeView<io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchy> {
    private static com.facebook.common.internal.Supplier<? extends com.facebook.drawee.controller.AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    private com.facebook.drawee.controller.AbstractDraweeControllerBuilder mControllerBuilder;

    public static void initialize(com.facebook.common.internal.Supplier<? extends com.facebook.drawee.controller.AbstractDraweeControllerBuilder> supplier) {
        sDraweecontrollerbuildersupplier = supplier;
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    public DCGenericDraweeView(android.content.Context context, io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchy dCGenericDraweeHierarchy) {
        super(context);
        setHierarchy(dCGenericDraweeHierarchy);
        init();
    }

    public DCGenericDraweeView(android.content.Context context) {
        super(context);
        inflateHierarchy(context, null);
        init();
    }

    public DCGenericDraweeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
        init();
    }

    public DCGenericDraweeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
        init();
    }

    public DCGenericDraweeView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
        init();
    }

    private void init() {
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                com.facebook.common.internal.Preconditions.checkNotNull(sDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                this.mControllerBuilder = sDraweecontrollerbuildersupplier.get();
            }
        } finally {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
    }

    protected void inflateHierarchy(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("GenericDraweeView#inflateHierarchy");
        }
        io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder dCGenericDraweeHierarchyBuilderInflateBuilder = io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyInflater.inflateBuilder(context, attributeSet);
        setAspectRatio(dCGenericDraweeHierarchyBuilderInflateBuilder.getDesiredAspectRatio());
        setHierarchy(dCGenericDraweeHierarchyBuilderInflateBuilder.build());
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    protected com.facebook.drawee.controller.AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder;
    }

    public void setImageRequest(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        setController(this.mControllerBuilder.setImageRequest(imageRequest).setOldController(getController()).build());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(android.net.Uri uri) {
        setImageURI(uri, (java.lang.Object) null);
    }

    public void setImageURI(java.lang.String str) {
        setImageURI(str, (java.lang.Object) null);
    }

    public void setImageURI(android.net.Uri uri, java.lang.Object obj) {
        setController(this.mControllerBuilder.setCallerContext(obj).setUri(uri).setOldController(getController()).build());
    }

    public void setImageURI(java.lang.String str, java.lang.Object obj) {
        setImageURI(str != null ? android.net.Uri.parse(str) : null, obj);
    }

    public void setActualImageResource(int i) {
        setActualImageResource(i, null);
    }

    public void setActualImageResource(int i, java.lang.Object obj) {
        setImageURI(com.facebook.common.util.UriUtil.getUriForResourceId(i), obj);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }
}
