package com.facebook.imagepipeline.systrace;

/* JADX INFO: compiled from: DefaultFrescoSystrace.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/systrace/DefaultFrescoSystrace;", "Lcom/facebook/imagepipeline/systrace/FrescoSystrace$Systrace;", "<init>", "()V", "beginSection", "", "name", "", "beginSectionWithArgs", "Lcom/facebook/imagepipeline/systrace/FrescoSystrace$ArgsBuilder;", "endSection", "isTracing", "", "DefaultArgsBuilder", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultFrescoSystrace implements com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace {
    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public boolean isTracing() {
        return false;
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void beginSection(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (isTracing()) {
            android.os.Trace.beginSection(name);
        }
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder beginSectionWithArgs(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (isTracing()) {
            return new com.facebook.imagepipeline.systrace.DefaultFrescoSystrace.DefaultArgsBuilder(name);
        }
        return com.facebook.imagepipeline.systrace.FrescoSystrace.NO_OP_ARGS_BUILDER;
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void endSection() {
        if (isTracing()) {
            android.os.Trace.endSection();
        }
    }

    /* JADX INFO: compiled from: DefaultFrescoSystrace.kt */
    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J%\u0010\u0013\u001a\n \u0014*\u0004\u0018\u00010\b0\b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0006\u001a\u00060\bj\u0002`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/facebook/imagepipeline/systrace/DefaultFrescoSystrace$DefaultArgsBuilder;", "Lcom/facebook/imagepipeline/systrace/FrescoSystrace$ArgsBuilder;", "name", "", "<init>", "(Ljava/lang/String;)V", "stringBuilder", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "Ljava/lang/StringBuilder;", "flush", "", com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ARG, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "value", "", "", "", "", "appendArgument", "kotlin.jvm.PlatformType", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class DefaultArgsBuilder implements com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder {
        private final java.lang.StringBuilder stringBuilder;

        public DefaultArgsBuilder(java.lang.String name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            this.stringBuilder = new java.lang.StringBuilder(name);
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
            if (this.stringBuilder.length() > 127) {
                this.stringBuilder.setLength(kotlinx.coroutines.scheduling.WorkQueueKt.MASK);
            }
            android.os.Trace.beginSection(this.stringBuilder.toString());
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public com.facebook.imagepipeline.systrace.DefaultFrescoSystrace.DefaultArgsBuilder arg(java.lang.String key, java.lang.Object value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            appendArgument(key, value);
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public com.facebook.imagepipeline.systrace.DefaultFrescoSystrace.DefaultArgsBuilder arg(java.lang.String key, int value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
            appendArgument(key, java.lang.Integer.valueOf(value));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public com.facebook.imagepipeline.systrace.DefaultFrescoSystrace.DefaultArgsBuilder arg(java.lang.String key, long value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
            appendArgument(key, java.lang.Long.valueOf(value));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public com.facebook.imagepipeline.systrace.DefaultFrescoSystrace.DefaultArgsBuilder arg(java.lang.String key, double value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
            appendArgument(key, java.lang.Double.valueOf(value));
            return this;
        }

        private final java.lang.StringBuilder appendArgument(java.lang.String key, java.lang.Object value) {
            java.lang.StringBuilder sb = this.stringBuilder;
            sb.append(';');
            sb.append(key + "=" + value);
            return sb;
        }
    }
}
