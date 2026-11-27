package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: LazyJavaTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaTypeParameterDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor {
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter javaTypeParameter;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError */
    protected void mo1838reportSupertypeLoopError(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter javaTypeParameter, int i, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration) {
        super(c.getStorageManager(), containingDeclaration, new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations(c, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, false, i, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, c.getComponents().getSupertypeLoopChecker());
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        this.c = c;
        this.javaTypeParameter = javaTypeParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> resolveUpperBounds() {
        return computeNotEnhancedBounds();
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeNotEnhancedBounds() {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType anyType = this.c.getModule().getBuiltIns().getAnyType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
            kotlin.reflect.jvm.internal.impl.types.SimpleType nullableAnyType = this.c.getModule().getBuiltIns().getNullableAnyType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nullableAnyType, "getNullableAnyType(...)");
            return kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType> collection = upperBounds;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
        java.util.Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.c.getTypeResolver().transformJavaType((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) it.next(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, false, this, 3, null)));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> processBoundsWithoutCycles(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> bounds) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bounds, "bounds");
        return this.c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, bounds, this.c);
    }
}
