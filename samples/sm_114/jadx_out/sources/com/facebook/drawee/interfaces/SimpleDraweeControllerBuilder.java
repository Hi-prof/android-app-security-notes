package com.facebook.drawee.interfaces;

/* JADX INFO: loaded from: classes.dex */
public interface SimpleDraweeControllerBuilder {
    com.facebook.drawee.interfaces.DraweeController build();

    com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder setCallerContext(java.lang.Object obj);

    com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder setOldController(@javax.annotation.Nullable com.facebook.drawee.interfaces.DraweeController draweeController);

    com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder setUri(android.net.Uri uri);

    com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder setUri(@javax.annotation.Nullable java.lang.String str);
}
