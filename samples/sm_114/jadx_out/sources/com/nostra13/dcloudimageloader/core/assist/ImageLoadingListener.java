package com.nostra13.dcloudimageloader.core.assist;

/* JADX INFO: loaded from: classes.dex */
public interface ImageLoadingListener {
    void onLoadingCancelled(java.lang.String str, android.view.View view);

    void onLoadingComplete(java.lang.String str, android.view.View view, android.graphics.Bitmap bitmap);

    void onLoadingFailed(java.lang.String str, android.view.View view, com.nostra13.dcloudimageloader.core.assist.FailReason failReason);

    void onLoadingStarted(java.lang.String str, android.view.View view);
}
