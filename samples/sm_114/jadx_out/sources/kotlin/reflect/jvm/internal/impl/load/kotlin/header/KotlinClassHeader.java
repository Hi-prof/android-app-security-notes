package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

/* JADX INFO: compiled from: KotlinClassHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KotlinClassHeader {
    private final java.lang.String[] data;
    private final int extraInt;
    private final java.lang.String extraString;
    private final java.lang.String[] incompatibleData;
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind kind;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion;
    private final java.lang.String packageName;
    private final byte[] serializedIr;
    private final java.lang.String[] strings;

    private final boolean has(int i, int i2) {
        return (i & i2) != 0;
    }

    public KotlinClassHeader(kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind kind, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion, java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String[] strArr3, java.lang.String str, int i, java.lang.String str2, byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        this.kind = kind;
        this.metadataVersion = metadataVersion;
        this.data = strArr;
        this.incompatibleData = strArr2;
        this.strings = strArr3;
        this.extraString = str;
        this.extraInt = i;
        this.packageName = str2;
        this.serializedIr = bArr;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind getKind() {
        return this.kind;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public final java.lang.String[] getData() {
        return this.data;
    }

    public final java.lang.String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    public final java.lang.String[] getStrings() {
        return this.strings;
    }

    /* JADX INFO: compiled from: KotlinClassHeader.kt */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);

        private static final java.util.Map<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind> entryById;
        private final int id;
        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
        public static final kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.Companion(null);

        @kotlin.jvm.JvmStatic
        public static final kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind getById(int i) {
            return Companion.getById(i);
        }

        Kind(int i) {
            this.id = i;
        }

        static {
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind[] kindArrValues = values();
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kindArrValues.length), 16));
            for (kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind kind : kindArrValues) {
                linkedHashMap.put(java.lang.Integer.valueOf(kind.id), kind);
            }
            entryById = linkedHashMap;
        }

        /* JADX INFO: compiled from: KotlinClassHeader.kt */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @kotlin.jvm.JvmStatic
            public final kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind getById(int i) {
                kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind kind = (kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind) kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.entryById.get(java.lang.Integer.valueOf(i));
                return kind == null ? kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.UNKNOWN : kind;
            }
        }
    }

    public final java.lang.String getMultifileClassName() {
        java.lang.String str = this.extraString;
        if (this.kind == kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final java.util.List<java.lang.String> getMultifilePartNames() {
        java.lang.String[] strArr = this.data;
        if (this.kind != kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS) {
            strArr = null;
        }
        java.util.List<java.lang.String> listAsList = strArr != null ? kotlin.collections.ArraysKt.asList(strArr) : null;
        return listAsList == null ? kotlin.collections.CollectionsKt.emptyList() : listAsList;
    }

    public final boolean isUnstableJvmIrBinary() {
        return has(this.extraInt, 16) && !has(this.extraInt, 32);
    }

    public final boolean isPreRelease() {
        return has(this.extraInt, 2);
    }

    public java.lang.String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }
}
