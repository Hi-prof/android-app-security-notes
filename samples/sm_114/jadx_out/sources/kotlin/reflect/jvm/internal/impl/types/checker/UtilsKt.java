package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UtilsKt {
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType findCorrespondingSupertype(kotlin.reflect.jvm.internal.impl.types.KotlinType subtype, kotlin.reflect.jvm.internal.impl.types.KotlinType supertype, kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subtype, "subtype");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(supertype, "supertype");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        arrayDeque.add(new kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode(subtype, null));
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = supertype.getConstructor();
        while (!arrayDeque.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode subtypePathNode = (kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode) arrayDeque.poll();
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = subtypePathNode.getType();
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor2 = type.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean zIsMarkedNullable = type.isMarkedNullable();
                for (kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode previous = subtypePathNode.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = previous.getType();
                    java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = type2.getArguments();
                    if (!(arguments instanceof java.util.Collection) || !arguments.isEmpty()) {
                        java.util.Iterator<T> it = arguments.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                type = kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.create(type2).buildSubstitutor().safeSubstitute(type, kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
                                kotlin.jvm.internal.Intrinsics.checkNotNull(type);
                                break;
                            }
                            if (((kotlin.reflect.jvm.internal.impl.types.TypeProjection) it.next()).getProjectionKind() != kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
                                kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSafeSubstitute = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "safeSubstitute(...)");
                                type = approximate(kotlinTypeSafeSubstitute);
                                break;
                            }
                        }
                    } else {
                        type = kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.create(type2).buildSubstitutor().safeSubstitute(type, kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(type);
                        break;
                    }
                    zIsMarkedNullable = zIsMarkedNullable || type2.isMarkedNullable();
                }
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor3 = type.getConstructor();
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor)) {
                    return kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified(type, zIsMarkedNullable);
                }
                throw new java.lang.AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + debugInfo(constructor3) + ", \n\nsupertype: " + debugInfo(constructor) + " \n" + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor));
            }
            for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : constructor2.mo1836getSupertypes()) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
                arrayDeque.add(new kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode(kotlinType, subtypePathNode));
            }
        }
        return null;
    }

    private static final kotlin.reflect.jvm.internal.impl.types.KotlinType approximate(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.approximateCapturedTypes(kotlinType).getUpper();
    }

    private static final java.lang.String debugInfo(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        debugInfo$lambda$1$unaryPlus("type: " + typeConstructor, sb);
        debugInfo$lambda$1$unaryPlus("hashCode: " + typeConstructor.hashCode(), sb);
        debugInfo$lambda$1$unaryPlus("javaClass: " + typeConstructor.getClass().getCanonicalName(), sb);
        for (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = typeConstructor.mo1835getDeclarationDescriptor(); classifierDescriptorMo1835getDeclarationDescriptor != null; classifierDescriptorMo1835getDeclarationDescriptor = classifierDescriptorMo1835getDeclarationDescriptor.getContainingDeclaration()) {
            debugInfo$lambda$1$unaryPlus("fqName: " + kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.FQ_NAMES_IN_TYPES.render(classifierDescriptorMo1835getDeclarationDescriptor), sb);
            debugInfo$lambda$1$unaryPlus("javaClass: " + classifierDescriptorMo1835getDeclarationDescriptor.getClass().getCanonicalName(), sb);
        }
        return sb.toString();
    }

    private static final java.lang.StringBuilder debugInfo$lambda$1$unaryPlus(java.lang.String str, java.lang.StringBuilder sb) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        sb.append(str);
        sb.append('\n');
        return sb;
    }
}
