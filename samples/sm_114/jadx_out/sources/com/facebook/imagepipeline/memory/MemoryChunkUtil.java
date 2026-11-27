package com.facebook.imagepipeline.memory;

/* JADX INFO: compiled from: MemoryChunkUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007J0\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007¨\u0006\r"}, d2 = {"Lcom/facebook/imagepipeline/memory/MemoryChunkUtil;", "", "<init>", "()V", "adjustByteCount", "", "offset", "count", "memorySize", "checkBounds", "", "otherLength", "otherOffset", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryChunkUtil {
    public static final com.facebook.imagepipeline.memory.MemoryChunkUtil INSTANCE = new com.facebook.imagepipeline.memory.MemoryChunkUtil();

    private MemoryChunkUtil() {
    }

    @kotlin.jvm.JvmStatic
    public static final int adjustByteCount(int offset, int count, int memorySize) {
        return java.lang.Math.min(java.lang.Math.max(0, memorySize - offset), count);
    }

    @kotlin.jvm.JvmStatic
    public static final void checkBounds(int offset, int otherLength, int otherOffset, int count, int memorySize) {
        com.facebook.common.internal.Preconditions.checkArgument(count >= 0, "count (%d) ! >= 0", java.lang.Integer.valueOf(count));
        com.facebook.common.internal.Preconditions.checkArgument(offset >= 0, "offset (%d) ! >= 0", java.lang.Integer.valueOf(offset));
        com.facebook.common.internal.Preconditions.checkArgument(otherOffset >= 0, "otherOffset (%d) ! >= 0", java.lang.Integer.valueOf(otherOffset));
        com.facebook.common.internal.Preconditions.checkArgument(offset + count <= memorySize, "offset (%d) + count (%d) ! <= %d", java.lang.Integer.valueOf(offset), java.lang.Integer.valueOf(count), java.lang.Integer.valueOf(memorySize));
        com.facebook.common.internal.Preconditions.checkArgument(otherOffset + count <= otherLength, "otherOffset (%d) + count (%d) ! <= %d", java.lang.Integer.valueOf(otherOffset), java.lang.Integer.valueOf(count), java.lang.Integer.valueOf(otherLength));
    }
}
