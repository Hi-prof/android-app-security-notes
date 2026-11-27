package com.facebook.fresco.urimod;

/* JADX INFO: compiled from: NopUriModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0013"}, d2 = {"Lcom/facebook/fresco/urimod/NopUriModifier;", "Lcom/facebook/fresco/urimod/UriModifierInterface;", "<init>", "()V", "modifyUri", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult;", "imageSource", "Lcom/facebook/fresco/vito/source/UriImageSource;", "viewport", "Lcom/facebook/fresco/urimod/Dimensions;", "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "callerContext", "", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "modifyPrefetchUri", "Landroid/net/Uri;", "uri", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NopUriModifier implements com.facebook.fresco.urimod.UriModifierInterface {
    public static final com.facebook.fresco.urimod.NopUriModifier INSTANCE = new com.facebook.fresco.urimod.NopUriModifier();

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public android.net.Uri modifyPrefetchUri(android.net.Uri uri, java.lang.Object callerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        return uri;
    }

    private NopUriModifier() {
    }

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public com.facebook.fresco.urimod.UriModifierInterface.ModificationResult modifyUri(com.facebook.fresco.vito.source.UriImageSource imageSource, com.facebook.fresco.urimod.Dimensions viewport, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, java.lang.Object callerContext, com.facebook.common.callercontext.ContextChain contextChain) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        return new com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Disabled("NopUriModifier");
    }
}
