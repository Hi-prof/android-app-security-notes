package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VersionRequirement {
    public static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Companion Companion = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Companion(null);
    private final java.lang.Integer errorCode;
    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind kind;
    private final kotlin.DeprecationLevel level;
    private final java.lang.String message;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version version;

    public VersionRequirement(kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version version, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind kind, kotlin.DeprecationLevel level, java.lang.Integer num, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(version, "version");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(level, "level");
        this.version = version;
        this.kind = kind;
        this.level = level;
        this.errorCode = num;
        this.message = str;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version getVersion() {
        return this.version;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    public final kotlin.DeprecationLevel getLevel() {
        return this.level;
    }

    public final java.lang.Integer getErrorCode() {
        return this.errorCode;
    }

    public final java.lang.String getMessage() {
        return this.message;
    }

    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class Version {
        public static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version.Companion Companion = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version.Companion(null);
        public static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version INFINITY = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version(256, 256, 256);
        private final int major;
        private final int minor;
        private final int patch;

        public final int component1() {
            return this.major;
        }

        public final int component2() {
            return this.minor;
        }

        public final int component3() {
            return this.patch;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version version = (kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version) obj;
            return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.patch;
        }

        public Version(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.patch = i3;
        }

        public final java.lang.String asString() {
            java.lang.StringBuilder sb;
            int i;
            if (this.patch == 0) {
                sb = new java.lang.StringBuilder();
                sb.append(this.major);
                sb.append(com.taobao.weex.el.parse.Operators.DOT);
                i = this.minor;
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(this.major);
                sb.append(com.taobao.weex.el.parse.Operators.DOT);
                sb.append(this.minor);
                sb.append(com.taobao.weex.el.parse.Operators.DOT);
                i = this.patch;
            }
            sb.append(i);
            return sb.toString();
        }

        public final void encode(kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> writeVersion, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> writeVersionFull) {
            int i;
            int i2;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(writeVersion, "writeVersion");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(writeVersionFull, "writeVersionFull");
            if (kotlin.jvm.internal.Intrinsics.areEqual(this, INFINITY)) {
                return;
            }
            int i3 = this.major;
            if (i3 > 7 || (i = this.minor) > 15 || (i2 = this.patch) > 127) {
                writeVersionFull.invoke(java.lang.Integer.valueOf((this.minor << 8) | i3 | (this.patch << 16)));
            } else {
                writeVersion.invoke(java.lang.Integer.valueOf((i << 3) | i3 | (i2 << 7)));
            }
        }

        public java.lang.String toString() {
            return asString();
        }

        /* JADX INFO: compiled from: VersionRequirement.kt */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version decode(java.lang.Integer num, java.lang.Integer num2) {
                if (num2 != null) {
                    return new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & kotlinx.coroutines.scheduling.WorkQueueKt.MASK);
                }
                return kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version.INFINITY;
            }
        }
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("since ");
        sb.append(this.version);
        sb.append(' ');
        sb.append(this.level);
        java.lang.String str2 = "";
        if (this.errorCode != null) {
            str = " error " + this.errorCode;
        } else {
            str = "";
        }
        sb.append(str);
        if (this.message != null) {
            str2 = ": " + this.message;
        }
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: VersionRequirement.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.values().length];
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                } catch (java.lang.NoSuchFieldError unused) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                } catch (java.lang.NoSuchFieldError unused2) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                } catch (java.lang.NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement create(int i, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable table) {
            kotlin.DeprecationLevel deprecationLevel;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(table, "table");
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement versionRequirement = table.get(i);
            if (versionRequirement == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version versionDecode = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version.Companion.decode(versionRequirement.hasVersion() ? java.lang.Integer.valueOf(versionRequirement.getVersion()) : null, versionRequirement.hasVersionFull() ? java.lang.Integer.valueOf(versionRequirement.getVersionFull()) : null);
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level level = versionRequirement.getLevel();
            kotlin.jvm.internal.Intrinsics.checkNotNull(level);
            int i2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Companion.WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i2 == 1) {
                deprecationLevel = kotlin.DeprecationLevel.WARNING;
            } else if (i2 == 2) {
                deprecationLevel = kotlin.DeprecationLevel.ERROR;
            } else {
                if (i2 != 3) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                deprecationLevel = kotlin.DeprecationLevel.HIDDEN;
            }
            kotlin.DeprecationLevel deprecationLevel2 = deprecationLevel;
            java.lang.Integer numValueOf = versionRequirement.hasErrorCode() ? java.lang.Integer.valueOf(versionRequirement.getErrorCode()) : null;
            java.lang.String string = versionRequirement.hasMessage() ? nameResolver.getString(versionRequirement.getMessage()) : null;
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind versionKind = versionRequirement.getVersionKind();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionKind, "getVersionKind(...)");
            return new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement(versionDecode, versionKind, deprecationLevel2, numValueOf, string);
        }
    }
}
