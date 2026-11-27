package com.facebook.datasource;

/* JADX INFO: compiled from: SuccessfulVoidDataSource.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/datasource/SuccessfulVoidDataSource;", "Lcom/facebook/datasource/AbstractDataSource;", "Ljava/lang/Void;", "<init>", "()V", "fbcore_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SuccessfulVoidDataSource extends com.facebook.datasource.AbstractDataSource<java.lang.Void> {
    public static final com.facebook.datasource.SuccessfulVoidDataSource INSTANCE;

    private SuccessfulVoidDataSource() {
    }

    static {
        com.facebook.datasource.SuccessfulVoidDataSource successfulVoidDataSource = new com.facebook.datasource.SuccessfulVoidDataSource();
        INSTANCE = successfulVoidDataSource;
        successfulVoidDataSource.setResult(null, true);
    }
}
