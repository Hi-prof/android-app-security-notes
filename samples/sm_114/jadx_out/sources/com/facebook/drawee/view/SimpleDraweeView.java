package com.facebook.drawee.view;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class SimpleDraweeView extends com.facebook.drawee.view.GenericDraweeView {

    @javax.annotation.Nullable
    private static com.facebook.common.internal.Supplier<? extends com.facebook.drawee.controller.AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    private com.facebook.drawee.controller.AbstractDraweeControllerBuilder mControllerBuilder;

    public static void initialize(com.facebook.common.internal.Supplier<? extends com.facebook.drawee.controller.AbstractDraweeControllerBuilder> supplier) {
        sDraweecontrollerbuildersupplier = supplier;
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    public SimpleDraweeView(android.content.Context context, com.facebook.drawee.generic.GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        init(context, null);
    }

    public SimpleDraweeView(android.content.Context context) {
        super(context);
        init(context, null);
    }

    public SimpleDraweeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SimpleDraweeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public SimpleDraweeView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    private void init(android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet) {
        int resourceId;
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
            if (attributeSet != null) {
                android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.facebook.drawee.R.styleable.SimpleDraweeView);
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(com.facebook.drawee.R.styleable.SimpleDraweeView_actualImageUri)) {
                        setImageURI(android.net.Uri.parse(typedArrayObtainStyledAttributes.getString(com.facebook.drawee.R.styleable.SimpleDraweeView_actualImageUri)), (java.lang.Object) null);
                    } else if (typedArrayObtainStyledAttributes.hasValue(com.facebook.drawee.R.styleable.SimpleDraweeView_actualImageResource) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(com.facebook.drawee.R.styleable.SimpleDraweeView_actualImageResource, -1)) != -1) {
                        if (isInEditMode()) {
                            setImageResource(resourceId);
                        } else {
                            setActualImageResource(resourceId);
                        }
                    }
                    typedArrayObtainStyledAttributes.recycle();
                } catch (java.lang.Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            }
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        } catch (java.lang.Throwable th2) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            throw th2;
        }
    }

    public com.facebook.drawee.controller.AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder;
    }

    public void setImageRequest(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        setController(this.mControllerBuilder.setImageRequest(imageRequest).setOldController(getController()).build());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(android.net.Uri uri) {
        setImageURI(uri, (java.lang.Object) null);
    }

    public void setImageURI(@javax.annotation.Nullable java.lang.String str) {
        setImageURI(str, (java.lang.Object) null);
    }

    public void setImageURI(android.net.Uri uri, @javax.annotation.Nullable java.lang.Object obj) {
        setController(this.mControllerBuilder.setCallerContext(obj).setUri(uri).setOldController(getController()).build());
    }

    public void setImageURI(@javax.annotation.Nullable java.lang.String str, @javax.annotation.Nullable java.lang.Object obj) {
        setImageURI(str != null ? android.net.Uri.parse(str) : null, obj);
    }

    public void setActualImageResource(int i) {
        setActualImageResource(i, null);
    }

    public void setActualImageResource(int i, @javax.annotation.Nullable java.lang.Object obj) {
        setImageURI(com.facebook.common.util.UriUtil.getUriForResourceId(i), obj);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }
}
