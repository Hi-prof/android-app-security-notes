package com.facebook.binaryresource;

/* JADX INFO: compiled from: FileBinaryResource.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/facebook/binaryresource/FileBinaryResource;", "Lcom/facebook/binaryresource/BinaryResource;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "openStream", "Ljava/io/InputStream;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "read", "", "equals", "", "other", "", "hashCode", "", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileBinaryResource implements com.facebook.binaryresource.BinaryResource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.binaryresource.FileBinaryResource.Companion INSTANCE = new com.facebook.binaryresource.FileBinaryResource.Companion(null);
    private final java.io.File file;

    public /* synthetic */ FileBinaryResource(java.io.File file, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(file);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.binaryresource.FileBinaryResource create(java.io.File file) {
        return INSTANCE.create(file);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.binaryresource.FileBinaryResource createOrNull(java.io.File file) {
        return INSTANCE.createOrNull(file);
    }

    private FileBinaryResource(java.io.File file) {
        this.file = file;
    }

    public final java.io.File getFile() {
        return this.file;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public java.io.InputStream openStream() throws java.io.IOException {
        return new java.io.FileInputStream(this.file);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.file.length();
    }

    @Override // com.facebook.binaryresource.BinaryResource
    /* JADX INFO: renamed from: read */
    public byte[] getBytes() throws java.lang.Throwable {
        byte[] byteArray = com.facebook.common.internal.Files.toByteArray(this.file);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public boolean equals(java.lang.Object other) {
        if (other == null || !(other instanceof com.facebook.binaryresource.FileBinaryResource)) {
            return false;
        }
        return kotlin.jvm.internal.Intrinsics.areEqual(this.file, ((com.facebook.binaryresource.FileBinaryResource) other).file);
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    /* JADX INFO: compiled from: FileBinaryResource.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/binaryresource/FileBinaryResource$Companion;", "", "<init>", "()V", "createOrNull", "Lcom/facebook/binaryresource/FileBinaryResource;", "file", "Ljava/io/File;", "create", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.binaryresource.FileBinaryResource createOrNull(java.io.File file) {
            kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker = null;
            if (file != null) {
                return new com.facebook.binaryresource.FileBinaryResource(file, defaultConstructorMarker);
            }
            return null;
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.binaryresource.FileBinaryResource create(java.io.File file) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "file");
            return new com.facebook.binaryresource.FileBinaryResource(file, null);
        }
    }
}
