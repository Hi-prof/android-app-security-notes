package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ClassicTypeSystemContext extends kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext {
    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker asCapturedType(kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker asRigidType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker);

    kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker createFlexibleType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isStarProjection(kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker typeArgumentMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker lowerBound(kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructor(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker upperBound(kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker withNullability(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, boolean z);

    /* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
    public static final class DefaultImpls {
        public static boolean isK2(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext) {
            return false;
        }

        public static boolean isDenotable(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                return ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).isDenotable();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isIntegerLiteralTypeConstructor(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker getTypeParameter(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor) {
                return ((kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor) receiver).getOriginalTypeParameter();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> possibleIntegerTypes(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = classicTypeSystemContext.typeConstructor(receiver);
            if (typeConstructorMarkerTypeConstructor instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor) {
                return ((kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor) typeConstructorMarkerTypeConstructor).getPossibleTypes();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker withNullability(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker receiver, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                return ((kotlin.reflect.jvm.internal.impl.types.SimpleType) receiver).makeNullableAsSpecified(z);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isError(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isStubType((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubTypeForBuilderInference(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isStubTypeForBuilderInference((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker lowerType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) {
                return ((kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) receiver).getLowerType();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isIntersection(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean identicalArguments(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker a, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker b) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
            if (a instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                if (b instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                    return ((kotlin.reflect.jvm.internal.impl.types.SimpleType) a).getArguments() == ((kotlin.reflect.jvm.internal.impl.types.SimpleType) b).getArguments();
                }
                throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + b + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(b.getClass())).toString());
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + a + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(a.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker asRigidType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = ((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver).unwrap();
                return unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType ? (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap : null;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker asFlexibleType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = ((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver).unwrap();
                return unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType ? (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap : null;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker asDynamicType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.types.DynamicType ? (kotlin.reflect.jvm.internal.impl.types.DynamicType) receiver : null;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isRawType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.types.RawType;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker upperBound(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
                return ((kotlin.reflect.jvm.internal.impl.types.FlexibleType) receiver).getUpperBound();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker lowerBound(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
                return ((kotlin.reflect.jvm.internal.impl.types.FlexibleType) receiver).getLowerBound();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker asCapturedType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement) {
                    return classicTypeSystemContext.asCapturedType(((kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement) receiver).getOrigin());
                }
                return receiver instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType ? (kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) receiver : null;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker asDefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType ? (kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) receiver : null;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isNotNullTypeParameter(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver instanceof kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
        }

        public static boolean isMarkedNullable(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) && ((kotlin.reflect.jvm.internal.impl.types.SimpleType) receiver).isMarkedNullable();
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructor(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                return ((kotlin.reflect.jvm.internal.impl.types.SimpleType) receiver).getConstructor();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker typeConstructor(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) {
                return ((kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) receiver).getConstructor();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker projection(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor) {
                return ((kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor) receiver).getProjection();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static int argumentsCount(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return ((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver).getArguments().size();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker getArgument(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return ((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver).getArguments().get(i);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static java.util.List<kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker> getArguments(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return ((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver).getArguments();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isStarProjection(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeProjection) {
                return ((kotlin.reflect.jvm.internal.impl.types.TypeProjection) receiver).isStarProjection();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeVariance getVariance(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeProjection) {
                kotlin.reflect.jvm.internal.impl.types.Variance projectionKind = ((kotlin.reflect.jvm.internal.impl.types.TypeProjection) receiver).getProjectionKind();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                return kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt.convertVariance(projectionKind);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker getType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (classicTypeSystemContext.isStarProjection(receiver)) {
                return null;
            }
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeProjection) {
                return ((kotlin.reflect.jvm.internal.impl.types.TypeProjection) receiver).getType().unwrap();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static int parametersCount(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                return ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).getParameters().size();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker getParameter(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).getParameters().get(i);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "get(...)");
                return typeParameterDescriptor;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static java.util.List<kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker> getParameters(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).getParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                return parameters;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> supertypes(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1836getSupertypes();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
                return collectionMo1836getSupertypes;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeVariance getVariance(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
                kotlin.reflect.jvm.internal.impl.types.Variance variance = ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) receiver).getVariance();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(variance, "getVariance(...)");
                return kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt.convertVariance(variance);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static java.util.List<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> getUpperBounds(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
                java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) receiver).getUpperBounds();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                return upperBounds;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean hasRecursiveBounds(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker receiver, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) receiver;
                if (typeConstructorMarker == null ? true : typeConstructorMarker instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                    return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.hasTypeParameterRecursiveBounds$default(typeParameterDescriptor, (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) typeConstructorMarker, null, 4, null);
                }
                throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterDescriptor + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(typeParameterDescriptor.getClass())).toString());
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean areEqualTypeConstructors(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker c1, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker c2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c1, "c1");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c2, "c2");
            if (c1 instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                if (c2 instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                    return kotlin.jvm.internal.Intrinsics.areEqual(c1, c2);
                }
                throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c2 + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(c2.getClass())).toString());
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c1 + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(c1.getClass())).toString());
        }

        public static boolean isClassTypeConstructor(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                return ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1835getDeclarationDescriptor();
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
                return (classDescriptor == null || !kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt.isFinalClass(classDescriptor) || classDescriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY || classDescriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker asArgumentList(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                return (kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker) receiver;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.SimpleType captureFromArguments(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker type, kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus status) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(status, "status");
            if (type instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                return kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeKt.captureFromArguments((kotlin.reflect.jvm.internal.impl.types.SimpleType) type, status);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(type.getClass())).toString());
        }

        public static boolean isAnyConstructor(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isTypeConstructorForGivenClass((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.any);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isNothingConstructor(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isTypeConstructorForGivenClass((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.nothing);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker asTypeArgument(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isSingleClassifierType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver)) {
                    return false;
                }
                kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = (kotlin.reflect.jvm.internal.impl.types.SimpleType) receiver;
                if (simpleType.getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) {
                    return false;
                }
                return simpleType.getConstructor().mo1835getDeclarationDescriptor() != null || (receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType) || (receiver instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) || (receiver instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) || (simpleType.getConstructor() instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor) || isSingleClassifierTypeWithEnhancement(classicTypeSystemContext, (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        private static boolean isSingleClassifierTypeWithEnhancement(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker simpleTypeMarker) {
            return (simpleTypeMarker instanceof kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement) && classicTypeSystemContext.isSingleClassifierType(((kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement) simpleTypeMarker).getOrigin());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker intersectTypes(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> types) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
            return kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt.intersectTypes(types);
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker createFlexibleType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker lowerBound, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker upperBound) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperBound, "upperBound");
            if (lowerBound instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                if (upperBound instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                    return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType((kotlin.reflect.jvm.internal.impl.types.SimpleType) lowerBound, (kotlin.reflect.jvm.internal.impl.types.SimpleType) upperBound);
                }
                throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker withNullability(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) {
                return classicTypeSystemContext.withNullability((kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) receiver, z);
            }
            if (!(receiver instanceof kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker)) {
                throw new java.lang.IllegalStateException("sealed".toString());
            }
            kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarker = (kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker) receiver;
            return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability((kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) classicTypeSystemContext.lowerBound(flexibleTypeMarker), z), classicTypeSystemContext.withNullability((kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) classicTypeSystemContext.upperBound(flexibleTypeMarker), z));
        }

        public static kotlin.reflect.jvm.internal.impl.types.TypeCheckerState newTypeCheckerState(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, boolean z, boolean z2, boolean z3) {
            return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(z, z2, classicTypeSystemContext, null, null, 24, null);
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker makeDefinitelyNotNullOrNotNull(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.UnwrappedType) {
                return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContextKt.makeDefinitelyNotNullOrNotNullInternal((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isProjectionNotNull(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) {
                return ((kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) receiver).isProjectionNotNull();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) {
                return ((kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) receiver).getCaptureStatus();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isOldCapturedType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
        }

        public static boolean isNullableType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker original(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) {
                return ((kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) receiver).getOriginal();
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isPrimitiveType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean hasAnnotation(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return ((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver).getAnnotations().hasAnnotation(fqName);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker getTypeParameterClassifier(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1835getDeclarationDescriptor();
                return classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isInlineClass(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1835getDeclarationDescriptor();
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
                return (classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null) instanceof kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker getUnsubstitutedUnderlyingType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType) {
                return kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.unsubstitutedUnderlyingType((kotlin.reflect.jvm.internal.impl.types.KotlinType) receiver);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getPrimitiveType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1835getDeclarationDescriptor();
                kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.getPrimitiveType((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getPrimitiveArrayType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1835getDeclarationDescriptor();
                kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.getPrimitiveArrayType((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isUnderKotlinPackage(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1835getDeclarationDescriptor();
                return classifierDescriptorMo1835getDeclarationDescriptor != null && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnderKotlinPackage(classifierDescriptorMo1835getDeclarationDescriptor);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe getClassFqNameUnsafe(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.TypeConstructor) receiver).mo1835getDeclarationDescriptor();
                kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(final kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
                final kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorBuildSubstitutor = kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.create((kotlin.reflect.jvm.internal.impl.types.KotlinType) type).buildSubstitutor();
                return new kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.DoCustomTransform() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext$substitutionSupertypePolicy$2
                    @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
                    /* JADX INFO: renamed from: transformType */
                    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker mo1839transformType(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type2) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type2, "type");
                        kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext2 = classicTypeSystemContext;
                        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor = typeSubstitutorBuildSubstitutor;
                        java.lang.Object objLowerBoundIfFlexible = classicTypeSystemContext2.lowerBoundIfFlexible(type2);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(objLowerBoundIfFlexible, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSafeSubstitute = typeSubstitutor.safeSubstitute((kotlin.reflect.jvm.internal.impl.types.KotlinType) objLowerBoundIfFlexible, kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "safeSubstitute(...)");
                        kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker simpleTypeMarkerAsRigidType = classicTypeSystemContext2.asRigidType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) kotlinTypeSafeSubstitute);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(simpleTypeMarkerAsRigidType);
                        return simpleTypeMarkerAsRigidType;
                    }
                };
            }
            throw new java.lang.IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(type.getClass())).toString());
        }

        public static boolean isTypeVariableType(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext classicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker receiver) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return (receiver instanceof kotlin.reflect.jvm.internal.impl.types.UnwrappedType) && (((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) receiver).getConstructor() instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor);
        }
    }
}
