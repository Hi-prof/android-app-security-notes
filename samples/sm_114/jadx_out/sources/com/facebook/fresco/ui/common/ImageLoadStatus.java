package com.facebook.fresco.ui.common;

/* JADX INFO: compiled from: ImageLoadStatus.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0012"}, d2 = {"Lcom/facebook/fresco/ui/common/ImageLoadStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "REQUESTED", "INTERMEDIATE_AVAILABLE", "SUCCESS", "ERROR", "EMPTY_EVENT", "RELEASED", "toString", "", "Companion", "ui-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum ImageLoadStatus {
    UNKNOWN(-1),
    REQUESTED(0),
    INTERMEDIATE_AVAILABLE(2),
    SUCCESS(3),
    ERROR(5),
    EMPTY_EVENT(7),
    RELEASED(8);

    private final int value;
    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.fresco.ui.common.ImageLoadStatus.Companion INSTANCE = new com.facebook.fresco.ui.common.ImageLoadStatus.Companion(null);
    private static final com.facebook.fresco.ui.common.ImageLoadStatus[] VALUES = values();

    /* JADX INFO: compiled from: ImageLoadStatus.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.facebook.fresco.ui.common.ImageLoadStatus.values().length];
            try {
                iArr[com.facebook.fresco.ui.common.ImageLoadStatus.REQUESTED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[com.facebook.fresco.ui.common.ImageLoadStatus.SUCCESS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[com.facebook.fresco.ui.common.ImageLoadStatus.INTERMEDIATE_AVAILABLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[com.facebook.fresco.ui.common.ImageLoadStatus.ERROR.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[com.facebook.fresco.ui.common.ImageLoadStatus.RELEASED.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static kotlin.enums.EnumEntries<com.facebook.fresco.ui.common.ImageLoadStatus> getEntries() {
        return $ENTRIES;
    }

    ImageLoadStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        int i = com.facebook.fresco.ui.common.ImageLoadStatus.WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "requested";
        }
        if (i == 2) {
            return com.taobao.weex.ui.component.WXImage.SUCCEED;
        }
        if (i == 3) {
            return "intermediate_available";
        }
        if (i == 4) {
            return "error";
        }
        if (i == 5) {
            return "released";
        }
        return "unknown";
    }

    /* JADX INFO: compiled from: ImageLoadStatus.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/facebook/fresco/ui/common/ImageLoadStatus$Companion;", "", "<init>", "()V", "VALUES", "", "Lcom/facebook/fresco/ui/common/ImageLoadStatus;", "[Lcom/facebook/fresco/ui/common/ImageLoadStatus;", "fromInt", "value", "", "ui-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final com.facebook.fresco.ui.common.ImageLoadStatus fromInt(int value) {
            for (com.facebook.fresco.ui.common.ImageLoadStatus imageLoadStatus : com.facebook.fresco.ui.common.ImageLoadStatus.VALUES) {
                if (imageLoadStatus.getValue() == value) {
                    return imageLoadStatus;
                }
            }
            return null;
        }
    }
}
