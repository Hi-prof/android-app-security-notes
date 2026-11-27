package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NewCapturedTypeKt {
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType captureFromArguments(kotlin.reflect.jvm.internal.impl.types.SimpleType type, kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus status) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(status, "status");
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = type;
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> listCaptureArguments = captureArguments(simpleType, status);
        if (listCaptureArguments != null) {
            return replaceArguments(simpleType, listCaptureArguments);
        }
        return null;
    }

    private static final kotlin.reflect.jvm.internal.impl.types.SimpleType replaceArguments(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list) {
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(unwrappedType.getAttributes(), unwrappedType.getConstructor(), list, unwrappedType.isMarkedNullable(), (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
    }

    private static final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> captureArguments(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus) {
        if (unwrappedType.getArguments().size() != unwrappedType.getConstructor().getParameters().size()) {
            return null;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = unwrappedType.getArguments();
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> list = arguments;
        if (!(list instanceof java.util.Collection) || !list.isEmpty()) {
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((kotlin.reflect.jvm.internal.impl.types.TypeProjection) it.next()).getProjectionKind() != kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = unwrappedType.getConstructor().getParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                    java.util.List<kotlin.Pair> listZip = kotlin.collections.CollectionsKt.zip(list, parameters);
                    java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listZip, 10));
                    for (kotlin.Pair pair : listZip) {
                        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionAsTypeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) pair.component1();
                        kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) pair.component2();
                        if (typeProjectionAsTypeProjection.getProjectionKind() != kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
                            kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = (typeProjectionAsTypeProjection.isStarProjection() || typeProjectionAsTypeProjection.getProjectionKind() != kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE) ? null : typeProjectionAsTypeProjection.getType().unwrap();
                            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
                            typeProjectionAsTypeProjection = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection(new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType(captureStatus, unwrappedTypeUnwrap, typeProjectionAsTypeProjection, typeParameterDescriptor));
                        }
                        arrayList.add(typeProjectionAsTypeProjection);
                    }
                    java.util.ArrayList arrayList2 = arrayList;
                    kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorBuildSubstitutor = kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.create(unwrappedType.getConstructor(), arrayList2).buildSubstitutor();
                    int size = arguments.size();
                    for (int i = 0; i < size; i++) {
                        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = arguments.get(i);
                        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection2 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) arrayList2.get(i);
                        if (typeProjection.getProjectionKind() != kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
                            java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = unwrappedType.getConstructor().getParameters().get(i).getUpperBounds();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                            java.util.ArrayList arrayList3 = new java.util.ArrayList();
                            java.util.Iterator<T> it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayList3.add(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default.INSTANCE.prepareType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) typeSubstitutorBuildSubstitutor.safeSubstitute((kotlin.reflect.jvm.internal.impl.types.KotlinType) it2.next(), kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT).unwrap()));
                            }
                            java.util.ArrayList arrayList4 = arrayList3;
                            if (!typeProjection.isStarProjection() && typeProjection.getProjectionKind() == kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE) {
                                arrayList4.add(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default.INSTANCE.prepareType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) typeProjection.getType().unwrap()));
                            }
                            kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection2.getType();
                            kotlin.jvm.internal.Intrinsics.checkNotNull(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                            ((kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) type).getConstructor().initializeSupertypes(arrayList4);
                        }
                    }
                    return arrayList2;
                }
            }
        }
        return null;
    }
}
