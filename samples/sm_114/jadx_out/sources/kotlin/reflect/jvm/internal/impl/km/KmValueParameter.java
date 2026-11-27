package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmValueParameter {
    private kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument annotationParameterDefaultValue;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension> extensions;
    private int flags;
    private java.lang.String name;
    public kotlin.reflect.jvm.internal.impl.km.KmType type;
    private kotlin.reflect.jvm.internal.impl.km.KmType varargElementType;

    public KmValueParameter(int i, java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        this.name = name;
        this.annotations = new java.util.ArrayList(0);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension kmValueParameterExtensionCreateValueParameterExtension = ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createValueParameterExtension();
            if (kmValueParameterExtensionCreateValueParameterExtension != null) {
                arrayList.add(kmValueParameterExtensionCreateValueParameterExtension);
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

    public final java.lang.String getName() {
        return this.name;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmType getType() {
        kotlin.reflect.jvm.internal.impl.km.KmType kmType = this.type;
        if (kmType != null) {
            return kmType;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final void setType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.type = kmType;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmType getVarargElementType() {
        return this.varargElementType;
    }

    public final void setVarargElementType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        this.varargElementType = kmType;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument getAnnotationParameterDefaultValue() {
        return this.annotationParameterDefaultValue;
    }

    public final void setAnnotationParameterDefaultValue(kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument kmAnnotationArgument) {
        this.annotationParameterDefaultValue = kmAnnotationArgument;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }
}
