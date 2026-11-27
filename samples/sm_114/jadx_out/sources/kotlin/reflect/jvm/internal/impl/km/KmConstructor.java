package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmConstructor {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension> extensions;
    private int flags;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmValueParameter> valueParameters;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements;

    public KmConstructor(int i) {
        this.flags = i;
        this.valueParameters = new java.util.ArrayList();
        this.versionRequirements = new java.util.ArrayList(0);
        this.annotations = new java.util.ArrayList(0);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createConstructorExtension());
        }
        this.extensions = arrayList;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public KmConstructor() {
        this(0);
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}
