package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmClass implements kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer {
    private java.lang.String companionObject;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension> extensions;
    private int flags;
    private java.lang.String inlineClassUnderlyingPropertyName;
    private kotlin.reflect.jvm.internal.impl.km.KmType inlineClassUnderlyingType;
    public java.lang.String name;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> typeParameters = new java.util.ArrayList(0);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> supertypes = new java.util.ArrayList(1);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmFunction> functions = new java.util.ArrayList();
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> properties = new java.util.ArrayList();
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeAlias> typeAliases = new java.util.ArrayList(0);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmConstructor> constructors = new java.util.ArrayList(1);
    private final java.util.List<java.lang.String> nestedClasses = new java.util.ArrayList(0);
    private final java.util.List<java.lang.String> enumEntries = new java.util.ArrayList(0);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEnumEntry> kmEnumEntries = new java.util.ArrayList(0);
    private final java.util.List<java.lang.String> sealedSubclasses = new java.util.ArrayList(0);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = new java.util.ArrayList(0);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> contextReceiverTypes = new java.util.ArrayList(0);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements = new java.util.ArrayList(0);

    public KmClass() {
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createClassExtension());
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
        java.lang.String str = this.name;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final void setName(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> getSupertypes() {
        return this.supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public java.util.List<kotlin.reflect.jvm.internal.impl.km.KmFunction> getFunctions() {
        return this.functions;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> getProperties() {
        return this.properties;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmConstructor> getConstructors() {
        return this.constructors;
    }

    public final void setCompanionObject(java.lang.String str) {
        this.companionObject = str;
    }

    public final java.util.List<java.lang.String> getNestedClasses() {
        return this.nestedClasses;
    }

    public final java.util.List<java.lang.String> getEnumEntries() {
        return this.enumEntries;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEnumEntry> getKmEnumEntries() {
        return this.kmEnumEntries;
    }

    public final java.util.List<java.lang.String> getSealedSubclasses() {
        return this.sealedSubclasses;
    }

    public final void setInlineClassUnderlyingPropertyName(java.lang.String str) {
        this.inlineClassUnderlyingPropertyName = str;
    }

    public final void setInlineClassUnderlyingType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        this.inlineClassUnderlyingType = kmType;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}
