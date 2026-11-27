package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmProperty {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.KmProperty.class, "_hasSetter", "get_hasSetter()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.km.KmProperty.class, "_hasGetter", "get_hasGetter()Z", 0))};
    private final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate _hasGetter$delegate;
    private final kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate _hasSetter$delegate;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> backingFieldAnnotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> contextReceiverTypes;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> delegateFieldAnnotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> extensionReceiverParameterAnnotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension> extensions;
    private int flags;
    private final kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes getter;
    private java.lang.String name;
    private kotlin.reflect.jvm.internal.impl.km.KmType receiverParameterType;
    public kotlin.reflect.jvm.internal.impl.km.KmType returnType;
    private kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes setter;
    private kotlin.reflect.jvm.internal.impl.km.KmValueParameter setterParameter;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> typeParameters;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements;

    public KmProperty(int i, java.lang.String name, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        this.name = name;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_SETTER = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_SETTER;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_SETTER, "HAS_SETTER");
        this._hasSetter$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_SETTER));
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField HAS_GETTER = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_GETTER;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(HAS_GETTER, "HAS_GETTER");
        this._hasGetter$delegate = kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag(new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(HAS_GETTER));
        kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes kmPropertyAccessorAttributes = new kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes(i2);
        set_hasGetter(true);
        this.getter = kmPropertyAccessorAttributes;
        this.setter = get_hasSetter() ? new kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes(i3) : null;
        this.typeParameters = new java.util.ArrayList(0);
        this.extensionReceiverParameterAnnotations = new java.util.ArrayList(0);
        this.contextReceiverTypes = new java.util.ArrayList(0);
        this.versionRequirements = new java.util.ArrayList(0);
        this.annotations = new java.util.ArrayList(0);
        this.backingFieldAnnotations = new java.util.ArrayList(0);
        this.delegateFieldAnnotations = new java.util.ArrayList(0);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlin_metadata, 10));
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createPropertyExtension());
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

    private final boolean get_hasSetter() {
        return this._hasSetter$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void set_hasGetter(boolean z) {
        this._hasGetter$delegate.setValue(this, $$delegatedProperties[1], z);
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes getGetter() {
        return this.getter;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes getSetter() {
        return this.setter;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmType getReceiverParameterType() {
        return this.receiverParameterType;
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

    public final kotlin.reflect.jvm.internal.impl.km.KmValueParameter getSetterParameter() {
        return this.setterParameter;
    }

    public final void setSetterParameter(kotlin.reflect.jvm.internal.impl.km.KmValueParameter kmValueParameter) {
        this.setterParameter = kmValueParameter;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmType getReturnType() {
        kotlin.reflect.jvm.internal.impl.km.KmType kmType = this.returnType;
        if (kmType != null) {
            return kmType;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("returnType");
        return null;
    }

    public final void setReturnType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.returnType = kmType;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getBackingFieldAnnotations() {
        return this.backingFieldAnnotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getDelegateFieldAnnotations() {
        return this.delegateFieldAnnotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}
