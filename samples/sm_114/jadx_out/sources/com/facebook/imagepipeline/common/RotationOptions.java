package com.facebook.imagepipeline.common;

/* JADX INFO: compiled from: RotationOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0003\u0013\u0014\u0015B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/facebook/imagepipeline/common/RotationOptions;", "", "rotation", "", "deferUntilRendered", "", "<init>", "(IZ)V", "useImageMetadata", "rotationEnabled", "forcedAngle", "getForcedAngle", "()I", "canDeferUntilRendered", "hashCode", "equals", "other", "toString", "", "Rotation", "RotationAngle", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RotationOptions {
    private static final int DISABLE_ROTATION = -2;
    public static final int NO_ROTATION = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    private static final int USE_EXIF_ROTATION_ANGLE = -1;
    private final boolean deferUntilRendered;
    private final int rotation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.common.RotationOptions.Companion INSTANCE = new com.facebook.imagepipeline.common.RotationOptions.Companion(null);
    private static final com.facebook.imagepipeline.common.RotationOptions ROTATION_OPTIONS_AUTO_ROTATE = new com.facebook.imagepipeline.common.RotationOptions(-1, false);
    private static final com.facebook.imagepipeline.common.RotationOptions ROTATION_OPTIONS_DISABLE_ROTATION = new com.facebook.imagepipeline.common.RotationOptions(-2, false);
    private static final com.facebook.imagepipeline.common.RotationOptions ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = new com.facebook.imagepipeline.common.RotationOptions(-1, true);

    /* JADX INFO: compiled from: RotationOptions.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/facebook/imagepipeline/common/RotationOptions$Rotation;", "", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(kotlin.annotation.AnnotationRetention.SOURCE)
    private @interface Rotation {
    }

    /* JADX INFO: compiled from: RotationOptions.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/facebook/imagepipeline/common/RotationOptions$RotationAngle;", "", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(kotlin.annotation.AnnotationRetention.SOURCE)
    public @interface RotationAngle {
    }

    public /* synthetic */ RotationOptions(int i, boolean z, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.common.RotationOptions autoRotate() {
        return INSTANCE.autoRotate();
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.common.RotationOptions autoRotateAtRenderTime() {
        return INSTANCE.autoRotateAtRenderTime();
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.common.RotationOptions disableRotation() {
        return INSTANCE.disableRotation();
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.common.RotationOptions forceRotation(int i) {
        return INSTANCE.forceRotation(i);
    }

    private RotationOptions(int i, boolean z) {
        this.rotation = i;
        this.deferUntilRendered = z;
    }

    public final boolean useImageMetadata() {
        return this.rotation == -1;
    }

    public final boolean rotationEnabled() {
        return this.rotation != -2;
    }

    public final int getForcedAngle() {
        if (useImageMetadata()) {
            throw new java.lang.IllegalStateException("Rotation is set to use EXIF".toString());
        }
        return this.rotation;
    }

    /* JADX INFO: renamed from: canDeferUntilRendered, reason: from getter */
    public final boolean getDeferUntilRendered() {
        return this.deferUntilRendered;
    }

    public int hashCode() {
        return com.facebook.common.util.HashCodeUtil.hashCode(java.lang.Integer.valueOf(this.rotation), java.lang.Boolean.valueOf(this.deferUntilRendered));
    }

    public boolean equals(java.lang.Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof com.facebook.imagepipeline.common.RotationOptions)) {
            return false;
        }
        com.facebook.imagepipeline.common.RotationOptions rotationOptions = (com.facebook.imagepipeline.common.RotationOptions) other;
        return this.rotation == rotationOptions.rotation && this.deferUntilRendered == rotationOptions.deferUntilRendered;
    }

    public java.lang.String toString() {
        kotlin.jvm.internal.StringCompanionObject stringCompanionObject = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
        java.lang.String str = java.lang.String.format(null, "%d defer:%b", java.util.Arrays.copyOf(new java.lang.Object[]{java.lang.Integer.valueOf(this.rotation), java.lang.Boolean.valueOf(this.deferUntilRendered)}, 2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: compiled from: RotationOptions.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\b\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/imagepipeline/common/RotationOptions$Companion;", "", "<init>", "()V", "NO_ROTATION", "", "ROTATE_90", "ROTATE_180", "ROTATE_270", "USE_EXIF_ROTATION_ANGLE", "DISABLE_ROTATION", "ROTATION_OPTIONS_AUTO_ROTATE", "Lcom/facebook/imagepipeline/common/RotationOptions;", "ROTATION_OPTIONS_DISABLE_ROTATION", "ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME", "autoRotate", "disableRotation", "autoRotateAtRenderTime", "forceRotation", "angle", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.common.RotationOptions autoRotate() {
            return com.facebook.imagepipeline.common.RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE;
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.common.RotationOptions disableRotation() {
            return com.facebook.imagepipeline.common.RotationOptions.ROTATION_OPTIONS_DISABLE_ROTATION;
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.common.RotationOptions autoRotateAtRenderTime() {
            return com.facebook.imagepipeline.common.RotationOptions.ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME;
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.common.RotationOptions forceRotation(int angle) {
            return new com.facebook.imagepipeline.common.RotationOptions(angle, false, null);
        }
    }
}
