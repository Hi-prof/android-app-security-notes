package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmPackage implements kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension> extensions;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmFunction> functions;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> properties;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeAlias> typeAliases;

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

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}
