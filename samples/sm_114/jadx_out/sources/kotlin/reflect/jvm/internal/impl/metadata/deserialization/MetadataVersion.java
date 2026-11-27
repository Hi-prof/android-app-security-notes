package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

/* JADX INFO: compiled from: MetadataVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MetadataVersion extends kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion {
    public static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion.Companion Companion = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion INSTANCE;
    public static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion INSTANCE_NEXT;
    public static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion INVALID_VERSION;
    private final boolean isStrictSemantics;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataVersion(int[] versionArray, boolean z) {
        super(java.util.Arrays.copyOf(versionArray, versionArray.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(versionArray, "versionArray");
        this.isStrictSemantics = z;
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MetadataVersion(int... numbers) {
        this(numbers, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(numbers, "numbers");
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion lastSupportedVersionWithThisLanguageVersion(boolean z) {
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion = z ? INSTANCE : INSTANCE_NEXT;
        return metadataVersion.newerThan(this) ? metadataVersion : this;
    }

    public final boolean isCompatible(kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersionFromLanguageVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        return isCompatibleInternal(metadataVersionFromLanguageVersion.lastSupportedVersionWithThisLanguageVersion(this.isStrictSemantics));
    }

    private final boolean isCompatibleInternal(kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        if ((getMajor() == 1 && getMinor() == 0) || getMajor() == 0) {
            return false;
        }
        return !newerThan(metadataVersion);
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion next() {
        return (getMajor() == 1 && getMinor() == 9) ? new kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion(2, 0, 0) : new kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion(getMajor(), getMinor() + 1, 0);
    }

    private final boolean newerThan(kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        if (getMajor() > metadataVersion.getMajor()) {
            return true;
        }
        return getMajor() >= metadataVersion.getMajor() && getMinor() > metadataVersion.getMinor();
    }

    /* JADX INFO: compiled from: MetadataVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion(2, 2, 0);
        INSTANCE = metadataVersion;
        INSTANCE_NEXT = metadataVersion.next();
        INVALID_VERSION = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion(new int[0]);
    }
}
