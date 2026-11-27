package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes2.dex */
final class JvmTypeFactoryImpl implements kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType> {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl INSTANCE = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl();

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.CHAR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BYTE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.SHORT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.INT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.LONG.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private JvmTypeFactoryImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType boxType(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType possiblyPrimitiveType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (!(possiblyPrimitiveType instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive)) {
            return possiblyPrimitiveType;
        }
        kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive primitive = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive) possiblyPrimitiveType;
        if (primitive.getJvmPrimitiveType() == null) {
            return possiblyPrimitiveType;
        }
        java.lang.String internalName = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byFqNameWithoutInnerClasses(primitive.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(internalName, "getInternalName(...)");
        return createObjectType(internalName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType createFromString(java.lang.String representation) {
        kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType jvmPrimitiveType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(representation, "representation");
        java.lang.String str = representation;
        str.length();
        char cCharAt = representation.charAt(0);
        kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType[] jvmPrimitiveTypeArrValues = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.values();
        int length = jvmPrimitiveTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = jvmPrimitiveTypeArrValues[i];
            if (jvmPrimitiveType.getDesc().charAt(0) == cCharAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(jvmPrimitiveType);
        }
        if (cCharAt == 'V') {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(null);
        }
        if (cCharAt != '[') {
            if (cCharAt == 'L') {
                kotlin.text.StringsKt.endsWith$default((java.lang.CharSequence) str, ';', false, 2, (java.lang.Object) null);
            }
            java.lang.String strSubstring = representation.substring(1, representation.length() - 1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object(strSubstring);
        }
        java.lang.String strSubstring2 = representation.substring(1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array(createFromString(strSubstring2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType createPrimitiveType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        switch (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl.WhenMappings.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1:
                return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion.getBOOLEAN$descriptors_jvm();
            case 2:
                return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion.getCHAR$descriptors_jvm();
            case 3:
                return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion.getBYTE$descriptors_jvm();
            case 4:
                return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion.getSHORT$descriptors_jvm();
            case 5:
                return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion.getINT$descriptors_jvm();
            case 6:
                return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion.getFLOAT$descriptors_jvm();
            case 7:
                return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion.getLONG$descriptors_jvm();
            case 8:
                return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion.getDOUBLE$descriptors_jvm();
            default:
                throw new kotlin.NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType createObjectType(java.lang.String internalName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(internalName, "internalName");
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object(internalName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public java.lang.String toString(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType type) {
        java.lang.String desc;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        if (type instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array) {
            return com.taobao.weex.el.parse.Operators.ARRAY_START_STR + toString(((kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array) type).getElementType());
        }
        if (type instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive) {
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType jvmPrimitiveType = ((kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive) type).getJvmPrimitiveType();
            return (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) ? "V" : desc;
        }
        if (!(type instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object)) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return "L" + ((kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object) type).getInternalName() + ';';
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }
}
