package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: KotlinTypePreparator.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class KotlinTypePreparator extends kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator {
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type;
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = simpleType.getConstructor();
        kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor alternative = null;
        unwrappedTypeUnwrap = null;
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = null;
        if (constructor instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl) {
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl capturedTypeConstructorImpl = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl) constructor;
            kotlin.reflect.jvm.internal.impl.types.TypeProjection projection = capturedTypeConstructorImpl.getProjection();
            if (projection.getProjectionKind() != kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                unwrappedTypeUnwrap = type.unwrap();
            }
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType = unwrappedTypeUnwrap;
            if (capturedTypeConstructorImpl.getNewTypeConstructor() == null) {
                kotlin.reflect.jvm.internal.impl.types.TypeProjection projection2 = capturedTypeConstructorImpl.getProjection();
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = capturedTypeConstructorImpl.mo1836getSupertypes();
                java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collectionMo1836getSupertypes, 10));
                java.util.Iterator<T> it = collectionMo1836getSupertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).unwrap());
                }
                capturedTypeConstructorImpl.setNewTypeConstructor(new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus = kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING;
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newTypeConstructor = capturedTypeConstructorImpl.getNewTypeConstructor();
            kotlin.jvm.internal.Intrinsics.checkNotNull(newTypeConstructor);
            return new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType(captureStatus, newTypeConstructor, unwrappedType, simpleType.getAttributes(), simpleType.isMarkedNullable(), false, 32, null);
        }
        boolean z = false;
        if (constructor instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor) {
            java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes2 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor) constructor).mo1836getSupertypes();
            java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collectionMo1836getSupertypes2, 10));
            java.util.Iterator<T> it2 = collectionMo1836getSupertypes2.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeMakeNullableAsSpecified = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified((kotlin.reflect.jvm.internal.impl.types.KotlinType) it2.next(), simpleType.isMarkedNullable());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeMakeNullableAsSpecified, "makeNullableAsSpecified(...)");
                arrayList2.add(kotlinTypeMakeNullableAsSpecified);
            }
            return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(simpleType.getAttributes(), new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor(arrayList2), kotlin.collections.CollectionsKt.emptyList(), false, simpleType.getMemberScope());
        }
        if (!(constructor instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) || !simpleType.isMarkedNullable()) {
            return simpleType;
        }
        kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor intersectionTypeConstructor = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) constructor;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes3 = intersectionTypeConstructor.mo1836getSupertypes();
        java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collectionMo1836getSupertypes3, 10));
        java.util.Iterator<T> it3 = collectionMo1836getSupertypes3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable((kotlin.reflect.jvm.internal.impl.types.KotlinType) it3.next()));
            z = true;
        }
        java.util.ArrayList arrayList4 = arrayList3;
        if (z) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
            alternative = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor(arrayList4).setAlternative(alternativeType != null ? kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(alternativeType) : null);
        }
        if (alternative != null) {
            intersectionTypeConstructor = alternative;
        }
        return intersectionTypeConstructor.createType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public kotlin.reflect.jvm.internal.impl.types.UnwrappedType prepareType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeFlexibleType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        if (!(type instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType)) {
            throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
        }
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = ((kotlin.reflect.jvm.internal.impl.types.KotlinType) type).unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
            simpleTypeFlexibleType = transformToNewType((kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap);
        } else {
            if (!(unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType)) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            kotlin.reflect.jvm.internal.impl.types.FlexibleType flexibleType = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap;
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeTransformToNewType = transformToNewType(flexibleType.getLowerBound());
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeTransformToNewType2 = transformToNewType(flexibleType.getUpperBound());
            simpleTypeFlexibleType = (simpleTypeTransformToNewType == flexibleType.getLowerBound() && simpleTypeTransformToNewType2 == flexibleType.getUpperBound()) ? unwrappedTypeUnwrap : kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(simpleTypeTransformToNewType, simpleTypeTransformToNewType2);
        }
        return kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(simpleTypeFlexibleType, unwrappedTypeUnwrap, new kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator$prepareType$1, reason: invalid class name */
    /* JADX INFO: compiled from: KotlinTypePreparator.kt */
    static final /* synthetic */ class AnonymousClass1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.UnwrappedType> {
        AnonymousClass1(java.lang.Object obj) {
            super(1, obj, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.class, "prepareType", "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final kotlin.reflect.jvm.internal.impl.types.UnwrappedType invoke2(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker p0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
            return ((kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator) this.receiver).prepareType(p0);
        }
    }

    /* JADX INFO: compiled from: KotlinTypePreparator.kt */
    public static final class Default extends kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator {
        public static final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default INSTANCE = new kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default();

        private Default() {
        }
    }
}
