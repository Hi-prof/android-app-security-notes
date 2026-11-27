package io.dcloud.feature.uniapp.utils.bitmap;

/* JADX INFO: loaded from: classes2.dex */
public interface BitmapLoadCallback<T> {
    void onFailure(java.lang.String str, java.lang.Throwable th);

    void onSuccess(java.lang.String str, T t);
}
