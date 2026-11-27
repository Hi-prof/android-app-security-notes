package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeConstructor extends kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker {
    kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns();

    /* JADX INFO: renamed from: getDeclarationDescriptor */
    kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1835getDeclarationDescriptor();

    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters();

    /* JADX INFO: renamed from: getSupertypes */
    java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> mo1836getSupertypes();

    boolean isDenotable();

    kotlin.reflect.jvm.internal.impl.types.TypeConstructor refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner);
}
