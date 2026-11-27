package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CapturedTypeConstructorKt {
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType createCapturedType(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        return new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.getConstructor() instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.TypeSubstitution wrapWithCapturingSubstitution$default(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution, z);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution wrapWithCapturingSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, final boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeSubstitution, "<this>");
        if (typeSubstitution instanceof kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution) {
            kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution indexedParametersSubstitution = (kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution) typeSubstitution;
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor[] parameters = indexedParametersSubstitution.getParameters();
            java.util.List<kotlin.Pair> listZip = kotlin.collections.ArraysKt.zip(indexedParametersSubstitution.getArguments(), indexedParametersSubstitution.getParameters());
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listZip, 10));
            for (kotlin.Pair pair : listZip) {
                arrayList.add(createCapturedIfNeeded((kotlin.reflect.jvm.internal.impl.types.TypeProjection) pair.getFirst(), (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) pair.getSecond()));
            }
            return new kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution(parameters, (kotlin.reflect.jvm.internal.impl.types.TypeProjection[]) arrayList.toArray(new kotlin.reflect.jvm.internal.impl.types.TypeProjection[0]), z);
        }
        return new kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution(typeSubstitution) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.wrapWithCapturingSubstitution.2
            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public boolean approximateContravariantCapturedTypes() {
                return z;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            /* JADX INFO: renamed from: get */
            public kotlin.reflect.jvm.internal.impl.types.TypeProjection mo1840get(kotlin.reflect.jvm.internal.impl.types.KotlinType key) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
                kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionMo1840get = super.mo1840get(key);
                if (typeProjectionMo1840get == null) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = key.getConstructor().mo1835getDeclarationDescriptor();
                return kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.createCapturedIfNeeded(typeProjectionMo1840get, classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.TypeProjection createCapturedIfNeeded(final kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() == typeProjection.getProjectionKind()) {
            if (typeProjection.isStarProjection()) {
                kotlin.reflect.jvm.internal.impl.storage.StorageManager NO_LOCKS = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NO_LOCKS;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_LOCKS, "NO_LOCKS");
                return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(new kotlin.reflect.jvm.internal.impl.types.LazyWrappedType(NO_LOCKS, new kotlin.jvm.functions.Function0(typeProjection) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$$Lambda$0
                    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection arg$0;

                    {
                        this.arg$0 = typeProjection;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public java.lang.Object invoke() {
                        return kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.createCapturedIfNeeded$lambda$1(this.arg$0);
                    }
                }));
            }
            return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(typeProjection.getType());
        }
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(createCapturedType(typeProjection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType createCapturedIfNeeded$lambda$1(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }
}
