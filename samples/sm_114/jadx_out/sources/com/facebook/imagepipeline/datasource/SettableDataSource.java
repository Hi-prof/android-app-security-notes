package com.facebook.imagepipeline.datasource;

/* JADX INFO: compiled from: SettableDataSource.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0013*\u0004\b\u0000\u0010\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00030\u0002:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0014¨\u0006\u0014"}, d2 = {"Lcom/facebook/imagepipeline/datasource/SettableDataSource;", "T", "Lcom/facebook/datasource/AbstractDataSource;", "Lcom/facebook/common/references/CloseableReference;", "<init>", "()V", "set", "", "valueRef", "setException", "throwable", "", "setProgress", "progress", "", "getResult", "closeResult", "", "result", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SettableDataSource<T> extends com.facebook.datasource.AbstractDataSource<com.facebook.common.references.CloseableReference<T>> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.datasource.SettableDataSource.Companion INSTANCE = new com.facebook.imagepipeline.datasource.SettableDataSource.Companion(null);

    public /* synthetic */ SettableDataSource(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @kotlin.jvm.JvmStatic
    public static final <V> com.facebook.imagepipeline.datasource.SettableDataSource<V> create() {
        return INSTANCE.create();
    }

    private SettableDataSource() {
    }

    public final boolean set(com.facebook.common.references.CloseableReference<T> valueRef) {
        return super.setResult(com.facebook.common.references.CloseableReference.cloneOrNull(valueRef), true, null);
    }

    public final boolean setException(java.lang.Throwable throwable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(throwable, "throwable");
        return super.setFailure(throwable);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setProgress(float progress) {
        return super.setProgress(progress);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public com.facebook.common.references.CloseableReference<T> getResult() {
        return com.facebook.common.references.CloseableReference.cloneOrNull((com.facebook.common.references.CloseableReference) super.getResult());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.datasource.AbstractDataSource
    public void closeResult(com.facebook.common.references.CloseableReference<T> result) {
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) result);
    }

    /* JADX INFO: compiled from: SettableDataSource.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/imagepipeline/datasource/SettableDataSource$Companion;", "", "<init>", "()V", "create", "Lcom/facebook/imagepipeline/datasource/SettableDataSource;", "V", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final <V> com.facebook.imagepipeline.datasource.SettableDataSource<V> create() {
            return new com.facebook.imagepipeline.datasource.SettableDataSource<>(null);
        }
    }
}
