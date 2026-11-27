package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmTypeParameter {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension> extensions;
    private int flags;
    private int id;
    private java.lang.String name;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> upperBounds;
    private kotlin.reflect.jvm.internal.impl.km.KmVariance variance;

    public KmTypeParameter(int i, java.lang.String name, int i2, kotlin.reflect.jvm.internal.impl.km.KmVariance variance) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(variance, "variance");
        this.flags = i;
        this.name = name;
        this.id = i2;
        this.variance = variance;
        this.upperBounds = new java.util.ArrayList(1);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createTypeParameterExtension());
        }
        this.extensions = arrayList;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final java.lang.String getName() {
        return this.name;
    }

    public final int getId() {
        return this.id;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmVariance getVariance() {
        return this.variance;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> getUpperBounds() {
        return this.upperBounds;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}
