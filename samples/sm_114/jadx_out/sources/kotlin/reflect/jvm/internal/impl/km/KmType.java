package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmType {
    private kotlin.reflect.jvm.internal.impl.km.KmType abbreviatedType;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeProjection> arguments;
    public kotlin.reflect.jvm.internal.impl.km.KmClassifier classifier;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension> extensions;
    private int flags;
    private kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound flexibleTypeUpperBound;
    private kotlin.reflect.jvm.internal.impl.km.KmType outerType;

    public KmType(int i) {
        this.flags = i;
        this.arguments = new java.util.ArrayList(0);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createTypeExtension());
        }
        this.extensions = arrayList;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public KmType() {
        this(0);
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmClassifier getClassifier() {
        kotlin.reflect.jvm.internal.impl.km.KmClassifier kmClassifier = this.classifier;
        if (kmClassifier != null) {
            return kmClassifier;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("classifier");
        return null;
    }

    public final void setClassifier(kotlin.reflect.jvm.internal.impl.km.KmClassifier kmClassifier) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClassifier, "<set-?>");
        this.classifier = kmClassifier;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeProjection> getArguments() {
        return this.arguments;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmType getAbbreviatedType() {
        return this.abbreviatedType;
    }

    public final void setAbbreviatedType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        this.abbreviatedType = kmType;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmType getOuterType() {
        return this.outerType;
    }

    public final void setOuterType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        this.outerType = kmType;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound getFlexibleTypeUpperBound() {
        return this.flexibleTypeUpperBound;
    }

    public final void setFlexibleTypeUpperBound(kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound) {
        this.flexibleTypeUpperBound = kmFlexibleTypeUpperBound;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.metadata.KmType");
        kotlin.reflect.jvm.internal.impl.km.KmType kmType = (kotlin.reflect.jvm.internal.impl.km.KmType) obj;
        return this.flags == kmType.flags && kotlin.jvm.internal.Intrinsics.areEqual(getClassifier(), kmType.getClassifier()) && kotlin.jvm.internal.Intrinsics.areEqual(this.arguments, kmType.arguments) && kotlin.jvm.internal.Intrinsics.areEqual(this.outerType, kmType.outerType) && kotlin.jvm.internal.Intrinsics.areEqual(this.abbreviatedType, kmType.abbreviatedType) && kotlin.jvm.internal.Intrinsics.areEqual(this.flexibleTypeUpperBound, kmType.flexibleTypeUpperBound) && kotlin.jvm.internal.Intrinsics.areEqual(this.extensions, kmType.extensions);
    }

    public int hashCode() {
        return (((this.flags * 31) + getClassifier().hashCode()) * 31) + this.arguments.hashCode();
    }
}
