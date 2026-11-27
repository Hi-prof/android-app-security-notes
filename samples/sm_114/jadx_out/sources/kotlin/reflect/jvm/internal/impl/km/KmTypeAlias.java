package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmTypeAlias {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations;
    public kotlin.reflect.jvm.internal.impl.km.KmType expandedType;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension> extensions;
    private int flags;
    private java.lang.String name;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> typeParameters;
    public kotlin.reflect.jvm.internal.impl.km.KmType underlyingType;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements;

    public KmTypeAlias(int i, java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        this.name = name;
        this.typeParameters = new java.util.ArrayList(0);
        this.annotations = new java.util.ArrayList(0);
        this.versionRequirements = new java.util.ArrayList(0);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension kmTypeAliasExtensionCreateTypeAliasExtension = ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createTypeAliasExtension();
            if (kmTypeAliasExtensionCreateTypeAliasExtension != null) {
                arrayList.add(kmTypeAliasExtensionCreateTypeAliasExtension);
            }
        }
        this.extensions = arrayList;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final void setUnderlyingType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.underlyingType = kmType;
    }

    public final void setExpandedType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.expandedType = kmType;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }
}
