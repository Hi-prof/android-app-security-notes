package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDataSource<T> extends com.facebook.datasource.AbstractDataSource<T> {
    private SimpleDataSource() {
    }

    public static <T> com.facebook.datasource.SimpleDataSource<T> create() {
        return new com.facebook.datasource.SimpleDataSource<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setResult(T t, boolean z, java.util.Map<java.lang.String, java.lang.Object> map) {
        return super.setResult(com.facebook.common.internal.Preconditions.checkNotNull(t), z, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setResult(T t) {
        return super.setResult(com.facebook.common.internal.Preconditions.checkNotNull(t), true, null);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setFailure(java.lang.Throwable th) {
        return super.setFailure((java.lang.Throwable) com.facebook.common.internal.Preconditions.checkNotNull(th));
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setProgress(float f) {
        return super.setProgress(f);
    }
}
