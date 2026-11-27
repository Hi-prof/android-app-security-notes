package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class KotlinTypeRefiner extends kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner {
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findClassAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.name.ClassId classId);

    public abstract <S extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> S getOrPutScopeForClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.jvm.functions.Function0<? extends S> function0);

    public abstract boolean isRefinementNeededForModule(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor);

    public abstract boolean isRefinementNeededForTypeConstructor(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor);

    public abstract kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor refineDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor);

    public abstract java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> refineSupertypes(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor);

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
    public abstract kotlin.reflect.jvm.internal.impl.types.KotlinType refineType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker);

    /* JADX INFO: compiled from: KotlinTypeRefiner.kt */
    public static final class Default extends kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner {
        public static final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default INSTANCE = new kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default();

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findClassAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor refineDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor descriptor) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return null;
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public kotlin.reflect.jvm.internal.impl.types.KotlinType refineType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            return (kotlin.reflect.jvm.internal.impl.types.KotlinType) type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> refineSupertypes(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = classDescriptor.getTypeConstructor().mo1836getSupertypes();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
            return collectionMo1836getSupertypes;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public <S extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> S getOrPutScopeForClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.jvm.functions.Function0<? extends S> compute) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(compute, "compute");
            return compute.invoke();
        }
    }
}
