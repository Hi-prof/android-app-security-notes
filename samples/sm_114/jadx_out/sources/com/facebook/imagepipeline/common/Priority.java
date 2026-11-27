package com.facebook.imagepipeline.common;

/* JADX INFO: compiled from: Priority.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/common/Priority;", "", "<init>", "(Ljava/lang/String;I)V", "LOW", "MEDIUM", "HIGH", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.common.Priority.Companion INSTANCE = new com.facebook.imagepipeline.common.Priority.Companion(null);

    public static kotlin.enums.EnumEntries<com.facebook.imagepipeline.common.Priority> getEntries() {
        return $ENTRIES;
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.common.Priority getHigherPriority(com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.common.Priority priority2) {
        return INSTANCE.getHigherPriority(priority, priority2);
    }

    /* JADX INFO: compiled from: Priority.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/common/Priority$Companion;", "", "<init>", "()V", "getHigherPriority", "Lcom/facebook/imagepipeline/common/Priority;", "priority1", "priority2", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.common.Priority getHigherPriority(com.facebook.imagepipeline.common.Priority priority1, com.facebook.imagepipeline.common.Priority priority2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(priority1, "priority1");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(priority2, "priority2");
            return priority1.ordinal() > priority2.ordinal() ? priority1 : priority2;
        }
    }
}
