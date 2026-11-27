package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmFunction {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> contextReceiverTypes;
    private kotlin.reflect.jvm.internal.impl.km.KmContract contract;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> extensionReceiverParameterAnnotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension> extensions;
    private int flags;
    private java.lang.String name;
    private kotlin.reflect.jvm.internal.impl.km.KmType receiverParameterType;
    public kotlin.reflect.jvm.internal.impl.km.KmType returnType;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> typeParameters;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmValueParameter> valueParameters;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements;

    public KmFunction(int i, java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        this.name = name;
        this.typeParameters = new java.util.ArrayList(0);
        this.extensionReceiverParameterAnnotations = new java.util.ArrayList(0);
        this.contextReceiverTypes = new java.util.ArrayList(0);
        this.valueParameters = new java.util.ArrayList();
        this.versionRequirements = new java.util.ArrayList(0);
        this.annotations = new java.util.ArrayList(0);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createFunctionExtension());
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

    public final void setReceiverParameterType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        this.receiverParameterType = kmType;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getExtensionReceiverParameterAnnotations() {
        return this.extensionReceiverParameterAnnotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final void setReturnType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.returnType = kmType;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setContract(kotlin.reflect.jvm.internal.impl.km.KmContract kmContract) {
        this.contract = kmContract;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}
