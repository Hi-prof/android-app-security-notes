package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeSubstitutionKt {
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType replace(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> newArguments, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations newAnnotations) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        return replace$default(kotlinType, newArguments, newAnnotations, null, 4, null);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.KotlinType replace$default(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, java.util.List list2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((i & 2) != 0) {
            annotations = kotlinType.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return replace(kotlinType, list, annotations, list2);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType replace(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> newArguments, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations newAnnotations, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> newArgumentsForUpperBound) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == kotlinType.getArguments()) && newAnnotations == kotlinType.getAnnotations()) {
            return kotlinType;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes = kotlinType.getAttributes();
        if ((newAnnotations instanceof kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations) && ((kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations) newAnnotations).isEmpty()) {
            newAnnotations = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        }
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributesReplaceAnnotations = kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt.replaceAnnotations(attributes, newAnnotations);
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
            kotlin.reflect.jvm.internal.impl.types.FlexibleType flexibleType = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap;
            return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(replace(flexibleType.getLowerBound(), newArguments, typeAttributesReplaceAnnotations), replace(flexibleType.getUpperBound(), newArgumentsForUpperBound, typeAttributesReplaceAnnotations));
        }
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
            return replace((kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap, newArguments, typeAttributesReplaceAnnotations);
        }
        throw new kotlin.NoWhenBranchMatchedException();
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.SimpleType replace$default(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, java.util.List list, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            list = simpleType.getArguments();
        }
        if ((i & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        return replace(simpleType, (java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection>) list, typeAttributes);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType replace(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> newArguments, kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(simpleType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        if (newArguments.isEmpty() && newAttributes == simpleType.getAttributes()) {
            return simpleType;
        }
        if (newArguments.isEmpty()) {
            return simpleType.replaceAttributes(newAttributes);
        }
        if (simpleType instanceof kotlin.reflect.jvm.internal.impl.types.error.ErrorType) {
            return ((kotlin.reflect.jvm.internal.impl.types.error.ErrorType) simpleType).replaceArguments(newArguments);
        }
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(newAttributes, simpleType.getConstructor(), newArguments, simpleType.isMarkedNullable(), (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType asSimpleType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType ? (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap : null;
        if (simpleType != null) {
            return simpleType;
        }
        throw new java.lang.IllegalStateException(("This is should be simple type: " + kotlinType).toString());
    }
}
