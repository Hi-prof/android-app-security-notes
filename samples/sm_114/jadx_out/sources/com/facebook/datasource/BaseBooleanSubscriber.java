package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBooleanSubscriber implements com.facebook.datasource.DataSubscriber<java.lang.Boolean> {
    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(com.facebook.datasource.DataSource<java.lang.Boolean> dataSource) {
    }

    protected abstract void onFailureImpl(com.facebook.datasource.DataSource<java.lang.Boolean> dataSource);

    protected abstract void onNewResultImpl(boolean z);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(com.facebook.datasource.DataSource<java.lang.Boolean> dataSource) {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(com.facebook.datasource.DataSource<java.lang.Boolean> dataSource) {
        try {
            onNewResultImpl(dataSource.getResult().booleanValue());
        } finally {
            dataSource.close();
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(com.facebook.datasource.DataSource<java.lang.Boolean> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }
}
