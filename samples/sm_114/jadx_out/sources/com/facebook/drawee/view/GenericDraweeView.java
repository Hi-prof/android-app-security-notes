package com.facebook.drawee.view;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class GenericDraweeView extends com.facebook.drawee.view.DraweeView<com.facebook.drawee.generic.GenericDraweeHierarchy> {
    public GenericDraweeView(android.content.Context context, com.facebook.drawee.generic.GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }

    public GenericDraweeView(android.content.Context context) throws java.lang.Throwable {
        super(context);
        inflateHierarchy(context, null);
    }

    public GenericDraweeView(android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet) throws java.lang.Throwable {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet, int i) throws java.lang.Throwable {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) throws java.lang.Throwable {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
    }

    protected void inflateHierarchy(android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet) throws java.lang.Throwable {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("GenericDraweeView#inflateHierarchy");
        }
        com.facebook.drawee.generic.GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilderInflateBuilder = com.facebook.drawee.generic.GenericDraweeHierarchyInflater.inflateBuilder(context, attributeSet);
        setAspectRatio(genericDraweeHierarchyBuilderInflateBuilder.getDesiredAspectRatio());
        setHierarchy(genericDraweeHierarchyBuilderInflateBuilder.build());
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }
}
