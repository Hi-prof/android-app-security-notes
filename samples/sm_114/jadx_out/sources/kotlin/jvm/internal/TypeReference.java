package kotlin.jvm.internal;

/* JADX INFO: compiled from: TypeReference.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0013\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\rH\u0002J\f\u0010$\u001a\u00020#*\u00020\u0006H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u001dR\u001c\u0010&\u001a\u00020#*\u0006\u0012\u0002\b\u00030'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "platformTypeUpperBound", "flags", "", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getArguments", "()Ljava/util/List;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "getFlags$kotlin_stdlib$annotations", "getFlags$kotlin_stdlib", "()I", "annotations", "", "getAnnotations", "()Z", "equals", "other", "", "hashCode", "toString", "", "asString", "convertPrimitiveToWrapper", "arrayClassName", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TypeReference implements kotlin.reflect.KType {
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final java.util.List<kotlin.reflect.KTypeProjection> arguments;
    private final kotlin.reflect.KClassifier classifier;
    private final int flags;
    private final kotlin.reflect.KType platformTypeUpperBound;

    /* JADX INFO: compiled from: TypeReference.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.KVariance.values().length];
            try {
                iArr[kotlin.reflect.KVariance.INVARIANT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.KVariance.IN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.KVariance.OUT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public TypeReference(kotlin.reflect.KClassifier classifier, java.util.List<kotlin.reflect.KTypeProjection> arguments, kotlin.reflect.KType kType, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifier, "classifier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = kType;
        this.flags = i;
    }

    @Override // kotlin.reflect.KType
    public kotlin.reflect.KClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    public java.util.List<kotlin.reflect.KTypeProjection> getArguments() {
        return this.arguments;
    }

    /* JADX INFO: renamed from: getPlatformTypeUpperBound$kotlin_stdlib, reason: from getter */
    public final kotlin.reflect.KType getPlatformTypeUpperBound() {
        return this.platformTypeUpperBound;
    }

    /* JADX INFO: renamed from: getFlags$kotlin_stdlib, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(kotlin.reflect.KClassifier classifier, java.util.List<kotlin.reflect.KTypeProjection> arguments, boolean z) {
        this(classifier, arguments, null, z ? 1 : 0);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifier, "classifier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public java.util.List<java.lang.annotation.Annotation> getAnnotations() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    public boolean equals(java.lang.Object other) {
        if (!(other instanceof kotlin.jvm.internal.TypeReference)) {
            return false;
        }
        kotlin.jvm.internal.TypeReference typeReference = (kotlin.jvm.internal.TypeReference) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(getClassifier(), typeReference.getClassifier()) && kotlin.jvm.internal.Intrinsics.areEqual(getArguments(), typeReference.getArguments()) && kotlin.jvm.internal.Intrinsics.areEqual(this.platformTypeUpperBound, typeReference.platformTypeUpperBound) && this.flags == typeReference.flags;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + this.flags;
    }

    public java.lang.String toString() {
        return asString(false) + " (Kotlin reflection is not available)";
    }

    private final java.lang.String asString(boolean convertPrimitiveToWrapper) {
        java.lang.String name;
        kotlin.reflect.KClassifier classifier = getClassifier();
        kotlin.reflect.KClass kClass = classifier instanceof kotlin.reflect.KClass ? (kotlin.reflect.KClass) classifier : null;
        java.lang.Class<?> javaClass = kClass != null ? kotlin.jvm.JvmClassMappingKt.getJavaClass(kClass) : null;
        if (javaClass == null) {
            name = getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (javaClass.isArray()) {
            name = getArrayClassName(javaClass);
        } else if (convertPrimitiveToWrapper && javaClass.isPrimitive()) {
            kotlin.reflect.KClassifier classifier2 = getClassifier();
            kotlin.jvm.internal.Intrinsics.checkNotNull(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = kotlin.jvm.JvmClassMappingKt.getJavaObjectType((kotlin.reflect.KClass) classifier2).getName();
        } else {
            name = javaClass.getName();
        }
        java.lang.String str = name + (getArguments().isEmpty() ? "" : kotlin.collections.CollectionsKt.joinToString$default(getArguments(), ", ", com.taobao.weex.el.parse.Operators.L, com.taobao.weex.el.parse.Operators.G, 0, null, new kotlin.jvm.functions.Function1() { // from class: kotlin.jvm.internal.TypeReference$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.jvm.internal.TypeReference.asString$lambda$0(this.f$0, (kotlin.reflect.KTypeProjection) obj);
            }
        }, 24, null)) + (isMarkedNullable() ? com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING : "");
        kotlin.reflect.KType kType = this.platformTypeUpperBound;
        if (!(kType instanceof kotlin.jvm.internal.TypeReference)) {
            return str;
        }
        java.lang.String strAsString = ((kotlin.jvm.internal.TypeReference) kType).asString(true);
        if (kotlin.jvm.internal.Intrinsics.areEqual(strAsString, str)) {
            return str;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(strAsString, str + com.taobao.weex.el.parse.Operators.CONDITION_IF)) {
            return str + '!';
        }
        return com.taobao.weex.el.parse.Operators.BRACKET_START_STR + str + io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK + strAsString + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence asString$lambda$0(kotlin.jvm.internal.TypeReference typeReference, kotlin.reflect.KTypeProjection it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return typeReference.asString(it);
    }

    private final java.lang.String getArrayClassName(java.lang.Class<?> cls) {
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        return kotlin.jvm.internal.Intrinsics.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    private final java.lang.String asString(kotlin.reflect.KTypeProjection kTypeProjection) {
        java.lang.String strValueOf;
        if (kTypeProjection.getVariance() == null) {
            return "*";
        }
        kotlin.reflect.KType type = kTypeProjection.getType();
        kotlin.jvm.internal.TypeReference typeReference = type instanceof kotlin.jvm.internal.TypeReference ? (kotlin.jvm.internal.TypeReference) type : null;
        if (typeReference == null || (strValueOf = typeReference.asString(true)) == null) {
            strValueOf = java.lang.String.valueOf(kTypeProjection.getType());
        }
        kotlin.reflect.KVariance variance = kTypeProjection.getVariance();
        int i = variance == null ? -1 : kotlin.jvm.internal.TypeReference.WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            return strValueOf;
        }
        if (i == 2) {
            return "in " + strValueOf;
        }
        if (i != 3) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return "out " + strValueOf;
    }
}
