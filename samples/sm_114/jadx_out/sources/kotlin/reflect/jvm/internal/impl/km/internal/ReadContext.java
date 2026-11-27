package kotlin.reflect.jvm.internal.impl.km.internal;

/* JADX INFO: compiled from: Readers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReadContext {
    private final java.util.List<java.lang.Object> contextExtensions;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> extensions;
    private final boolean ignoreUnknownVersionRequirements;
    private final kotlin.reflect.jvm.internal.impl.km.internal.ReadContext parent;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver strings;
    private final java.util.Map<java.lang.Integer, java.lang.Integer> typeParameterNameToId;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable types;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirements;

    public ReadContext(kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver strings, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable types, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirements, boolean z, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext, java.util.List<? extends java.lang.Object> contextExtensions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(versionRequirements, "versionRequirements");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        this.strings = strings;
        this.types = types;
        this.versionRequirements = versionRequirements;
        this.ignoreUnknownVersionRequirements = z;
        this.parent = readContext;
        this.contextExtensions = contextExtensions;
        this.typeParameterNameToId = new java.util.LinkedHashMap();
        this.extensions = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver getStrings() {
        return this.strings;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable getTypes() {
        return this.types;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable getVersionRequirements$kotlin_metadata() {
        return this.versionRequirements;
    }

    public final boolean getIgnoreUnknownVersionRequirements$kotlin_metadata() {
        return this.ignoreUnknownVersionRequirements;
    }

    public /* synthetic */ ReadContext(kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable, boolean z, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext, java.util.List list, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(nameResolver, typeTable, versionRequirementTable, z, (i & 16) != 0 ? null : readContext, (i & 32) != 0 ? kotlin.collections.CollectionsKt.emptyList() : list);
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final java.lang.String get(int i) {
        return this.strings.getString(i);
    }

    public final java.lang.String className$kotlin_metadata(int i) {
        return kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.getClassName(this.strings, i);
    }

    public final java.lang.Integer getTypeParameterId$kotlin_metadata(int i) {
        java.lang.Integer num = this.typeParameterNameToId.get(java.lang.Integer.valueOf(i));
        if (num != null) {
            return num;
        }
        kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext = this.parent;
        if (readContext != null) {
            return readContext.getTypeParameterId$kotlin_metadata(i);
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.km.internal.ReadContext withTypeParameters$kotlin_metadata(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameters) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext = new kotlin.reflect.jvm.internal.impl.km.internal.ReadContext(this.strings, this.types, this.versionRequirements, this.ignoreUnknownVersionRequirements, this, this.contextExtensions);
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter : typeParameters) {
            readContext.typeParameterNameToId.put(java.lang.Integer.valueOf(typeParameter.getName()), java.lang.Integer.valueOf(typeParameter.getId()));
        }
        return readContext;
    }
}
