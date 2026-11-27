package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes2.dex */
public class TypeUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType DONT_CARE = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.DONT_CARE, new java.lang.String[0]);
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType CANNOT_INFER_FUNCTION_PARAM_TYPE = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new java.lang.String[0]);
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType NO_EXPECTED_TYPE = new kotlin.reflect.jvm.internal.impl.types.TypeUtils.SpecialType("NO_EXPECTED_TYPE");
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType UNIT_EXPECTED_TYPE = new kotlin.reflect.jvm.internal.impl.types.TypeUtils.SpecialType("UNIT_EXPECTED_TYPE");

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105  */
    /* JADX WARN: Code duplicated, block: B:82:0x0120  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str;
        int i2;
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 48 && i != 53 && i != 6 && i != 7) {
            switch (i) {
                case 56:
                case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                case 58:
                case 59:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 48 && i != 53 && i != 6 && i != 7) {
            switch (i) {
                case 56:
                case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                case 58:
                case 59:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        java.lang.Object[] objArr = new java.lang.Object[i2];
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
            case 58:
            case 59:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 5:
            case 8:
            case 10:
            case 18:
            case 23:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 40:
            default:
                objArr[0] = "type";
                break;
            case 12:
                objArr[0] = "typeConstructor";
                break;
            case 13:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 14:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = "parameters";
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case 24:
                objArr[0] = "result";
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case 41:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
                objArr[0] = "isSpecialType";
                break;
            case 45:
            case 46:
                objArr[0] = "parameterDescriptor";
                break;
            case 47:
            case 51:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 49:
            case 50:
                objArr[0] = "supertypes";
                break;
            case 52:
            case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                objArr[0] = "expectedType";
                break;
            case 54:
                objArr[0] = "literalTypeConstructor";
                break;
        }
        if (i == 4) {
            objArr[1] = "makeNullableAsSpecified";
        } else if (i == 9) {
            objArr[1] = "makeNullableIfNeeded";
        } else if (i == 11 || i == 15) {
            objArr[1] = "makeUnsubstitutedType";
        } else if (i == 17) {
            objArr[1] = "getDefaultTypeProjections";
        } else if (i == 19) {
            objArr[1] = "getImmediateSupertypes";
        } else if (i == 26) {
            objArr[1] = "getAllSupertypes";
        } else if (i == 35) {
            objArr[1] = "substituteProjectionsForParameters";
        } else if (i == 48) {
            objArr[1] = "getDefaultPrimitiveNumberType";
        } else if (i != 53) {
            if (i != 6 && i != 7) {
                switch (i) {
                    case 56:
                    case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                    case 58:
                    case 59:
                        objArr[1] = "getPrimitiveNumberType";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                }
            } else {
                objArr[1] = "makeNullableIfNeeded";
            }
        } else {
            objArr[1] = "getPrimitiveNumberType";
        }
        switch (i) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
            case 58:
            case 59:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case 24:
                objArr[2] = "collectAllSupertypes";
                break;
            case 25:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case 41:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 44:
                objArr[2] = "contains";
                break;
            case 45:
            case 46:
                objArr[2] = "makeStarProjection";
                break;
            case 47:
            case 49:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 50:
                objArr[2] = "findByFqName";
                break;
            case 51:
            case 52:
            case 54:
            case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 60:
                objArr[2] = "isTypeParameter";
                break;
            case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 62:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 48 && i != 53 && i != 6 && i != 7) {
            switch (i) {
                case 56:
                case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                case 58:
                case 59:
                    break;
                default:
                    throw new java.lang.IllegalArgumentException(str2);
            }
        }
        throw new java.lang.IllegalStateException(str2);
    }

    public static class SpecialType extends kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType {
        private final java.lang.String name;

        /* JADX WARN: Code duplicated, block: B:20:0x0030  */
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = (i == 1 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            java.lang.Object[] objArr = new java.lang.Object[(i == 1 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else if (i == 2) {
                objArr[0] = "delegate";
            } else if (i == 3) {
                objArr[0] = "kotlinTypeRefiner";
            } else if (i != 4) {
                objArr[0] = "newAttributes";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            }
            if (i == 1) {
                objArr[1] = "toString";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else {
                objArr[1] = "refine";
            }
            if (i != 1) {
                if (i == 2) {
                    objArr[2] = "replaceDelegate";
                } else if (i == 3) {
                    objArr[2] = "refine";
                } else if (i != 4) {
                    objArr[2] = "replaceAttributes";
                }
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i != 1 && i != 4) {
                throw new java.lang.IllegalArgumentException(str2);
            }
            throw new java.lang.IllegalStateException(str2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public kotlin.reflect.jvm.internal.impl.types.TypeUtils.SpecialType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner == null) {
                $$$reportNull$$$0(3);
            }
            return this;
        }

        public SpecialType(java.lang.String str) {
            this.name = str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        protected kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
            throw new java.lang.IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes) {
            if (typeAttributes == null) {
                $$$reportNull$$$0(0);
            }
            throw new java.lang.IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableAsSpecified(boolean z) {
            throw new java.lang.IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
        public java.lang.String toString() {
            java.lang.String str = this.name;
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        public kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType replaceDelegate(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
            if (simpleType == null) {
                $$$reportNull$$$0(2);
            }
            throw new java.lang.IllegalStateException(this.name);
        }
    }

    public static boolean noExpectedType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        return kotlinType == NO_EXPECTED_TYPE || kotlinType == UNIT_EXPECTED_TYPE;
    }

    public static boolean isDontCarePlaceholder(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return kotlinType != null && kotlinType.getConstructor() == DONT_CARE.getConstructor();
    }

    public static kotlin.reflect.jvm.internal.impl.types.KotlinType makeNullable(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        return makeNullableAsSpecified(kotlinType, true);
    }

    public static kotlin.reflect.jvm.internal.impl.types.KotlinType makeNotNullable(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        return makeNullableAsSpecified(kotlinType, false);
    }

    public static kotlin.reflect.jvm.internal.impl.types.KotlinType makeNullableAsSpecified(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            $$$reportNull$$$0(3);
        }
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeMakeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z);
        if (unwrappedTypeMakeNullableAsSpecified == null) {
            $$$reportNull$$$0(4);
        }
        return unwrappedTypeMakeNullableAsSpecified;
    }

    public static kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableIfNeeded(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, boolean z) {
        if (simpleType == null) {
            $$$reportNull$$$0(5);
        }
        if (!z) {
            if (simpleType == null) {
                $$$reportNull$$$0(7);
            }
            return simpleType;
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeNullableAsSpecified = simpleType.makeNullableAsSpecified(true);
        if (simpleTypeMakeNullableAsSpecified == null) {
            $$$reportNull$$$0(6);
        }
        return simpleTypeMakeNullableAsSpecified;
    }

    public static kotlin.reflect.jvm.internal.impl.types.KotlinType makeNullableIfNeeded(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (z) {
            return makeNullable(kotlinType);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(9);
        }
        return kotlinType;
    }

    public static kotlin.reflect.jvm.internal.impl.types.SimpleType makeUnsubstitutedType(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.SimpleType> function1) {
        if (kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(classifierDescriptor)) {
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType errorTypeCreateErrorType = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, classifierDescriptor.toString());
            if (errorTypeCreateErrorType == null) {
                $$$reportNull$$$0(11);
            }
            return errorTypeCreateErrorType;
        }
        return makeUnsubstitutedType(classifierDescriptor.getTypeConstructor(), memberScope, function1);
    }

    public static kotlin.reflect.jvm.internal.impl.types.SimpleType makeUnsubstitutedType(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.SimpleType> function1) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(12);
        }
        if (memberScope == null) {
            $$$reportNull$$$0(13);
        }
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeSimpleTypeWithNonTrivialMemberScope = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty(), typeConstructor, getDefaultTypeProjections(typeConstructor.getParameters()), false, memberScope, function1);
        if (simpleTypeSimpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(15);
        }
        return simpleTypeSimpleTypeWithNonTrivialMemberScope;
    }

    public static java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getDefaultTypeProjections(java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list) {
        if (list == null) {
            $$$reportNull$$$0(16);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(it.next().getDefaultType()));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> list2 = kotlin.collections.CollectionsKt.toList(arrayList);
        if (list2 == null) {
            $$$reportNull$$$0(17);
        }
        return list2;
    }

    public static java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> getImmediateSupertypes(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(18);
        }
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorCreate = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(kotlinType);
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = kotlinType.getConstructor().mo1836getSupertypes();
        java.util.ArrayList arrayList = new java.util.ArrayList(collectionMo1836getSupertypes.size());
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.KotlinType> it = collectionMo1836getSupertypes.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeCreateSubstitutedSupertype = createSubstitutedSupertype(kotlinType, it.next(), typeSubstitutorCreate);
            if (kotlinTypeCreateSubstitutedSupertype != null) {
                arrayList.add(kotlinTypeCreateSubstitutedSupertype);
            }
        }
        return arrayList;
    }

    public static kotlin.reflect.jvm.internal.impl.types.KotlinType createSubstitutedSupertype(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor) {
        if (kotlinType == null) {
            $$$reportNull$$$0(20);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(21);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute = typeSubstitutor.substitute(kotlinType2, kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
        if (kotlinTypeSubstitute != null) {
            return makeNullableIfNeeded(kotlinTypeSubstitute, kotlinType.isMarkedNullable());
        }
        return null;
    }

    public static boolean isNullableType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(27);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(kotlinType) && isNullableType(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return true;
        }
        if (kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            return false;
        }
        if (isTypeParameter(kotlinType)) {
            return hasNullableSuperType(kotlinType);
        }
        if (kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.AbstractStubType) {
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor originalTypeParameter = ((kotlin.reflect.jvm.internal.impl.types.AbstractStubType) kotlinType).getOriginalTypeVariable().getOriginalTypeParameter();
            return originalTypeParameter == null || hasNullableSuperType(originalTypeParameter.getDefaultType());
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) {
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.KotlinType> it = constructor.mo1836getSupertypes().iterator();
            while (it.hasNext()) {
                if (isNullableType(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean acceptsNullable(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(28);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(kotlinType) && acceptsNullable(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound());
    }

    public static boolean hasNullableSuperType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(29);
        }
        if (kotlinType.getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return false;
        }
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.KotlinType> it = getImmediateSupertypes(kotlinType).iterator();
        while (it.hasNext()) {
            if (isNullableType(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getClassDescriptor(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(30);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor;
        }
        return null;
    }

    public static boolean contains(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.UnwrappedType, java.lang.Boolean> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(43);
        }
        return contains(kotlinType, function1, null);
    }

    private static boolean contains(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.UnwrappedType, java.lang.Boolean> function1, kotlin.reflect.jvm.internal.impl.utils.SmartSet<kotlin.reflect.jvm.internal.impl.types.KotlinType> smartSet) {
        if (function1 == null) {
            $$$reportNull$$$0(44);
        }
        if (kotlinType == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (noExpectedType(kotlinType)) {
            return function1.invoke2(unwrappedTypeUnwrap).booleanValue();
        }
        if (smartSet != null && smartSet.contains(kotlinType)) {
            return false;
        }
        if (function1.invoke2(unwrappedTypeUnwrap).booleanValue()) {
            return true;
        }
        if (smartSet == null) {
            smartSet = kotlin.reflect.jvm.internal.impl.utils.SmartSet.create();
        }
        smartSet.add(kotlinType);
        kotlin.reflect.jvm.internal.impl.types.FlexibleType flexibleType = unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType ? (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap : null;
        if (flexibleType != null && (contains(flexibleType.getLowerBound(), function1, smartSet) || contains(flexibleType.getUpperBound(), function1, smartSet))) {
            return true;
        }
        if ((unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) && contains(((kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) unwrappedTypeUnwrap).getOriginal(), function1, smartSet)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) {
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.KotlinType> it = ((kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) constructor).mo1836getSupertypes().iterator();
            while (it.hasNext()) {
                if (contains(it.next(), function1, smartSet)) {
                    return true;
                }
            }
            return false;
        }
        for (kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection : kotlinType.getArguments()) {
            if (!typeProjection.isStarProjection()) {
                if (contains(typeProjection.getType(), function1, smartSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static kotlin.reflect.jvm.internal.impl.types.TypeProjection makeStarProjection(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(45);
        }
        return new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor);
    }

    public static kotlin.reflect.jvm.internal.impl.types.TypeProjection makeStarProjection(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes erasureTypeAttributes) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(46);
        }
        if (erasureTypeAttributes.getHowThisTypeIsUsed() == kotlin.reflect.jvm.internal.impl.types.TypeUsage.SUPERTYPE) {
            return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt.starProjectionType(typeParameterDescriptor));
        }
        return new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor);
    }

    public static boolean isTypeParameter(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(60);
        }
        return getTypeParameterDescriptorOrNull(kotlinType) != null || (kotlinType.getConstructor() instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor);
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor getTypeParameterDescriptorOrNull(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(63);
        }
        if (kotlinType.getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        }
        return null;
    }
}
