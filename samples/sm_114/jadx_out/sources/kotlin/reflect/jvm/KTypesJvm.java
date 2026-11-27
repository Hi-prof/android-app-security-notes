package kotlin.reflect.jvm;

/* JADX INFO: compiled from: KTypesJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "getJvmErasure", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KTypesJvm {
    public static /* synthetic */ void getJvmErasure$annotations(kotlin.reflect.KType kType) {
    }

    public static final kotlin.reflect.KClass<?> getJvmErasure(kotlin.reflect.KType kType) {
        kotlin.reflect.KClass<?> jvmErasure;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kType, "<this>");
        kotlin.reflect.KClassifier classifier = kType.getClassifier();
        if (classifier != null && (jvmErasure = getJvmErasure(classifier)) != null) {
            return jvmErasure;
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
    }

    public static final kotlin.reflect.KClass<?> getJvmErasure(kotlin.reflect.KClassifier kClassifier) {
        java.lang.Object obj;
        kotlin.reflect.KClass<?> jvmErasure;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClassifier, "<this>");
        if (kClassifier instanceof kotlin.reflect.KClass) {
            return (kotlin.reflect.KClass) kClassifier;
        }
        if (kClassifier instanceof kotlin.reflect.KTypeParameter) {
            java.util.List<kotlin.reflect.KType> upperBounds = ((kotlin.reflect.KTypeParameter) kClassifier).getUpperBounds();
            java.util.Iterator<T> it = upperBounds.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                java.lang.Object next = it.next();
                kotlin.reflect.KType kType = (kotlin.reflect.KType) next;
                kotlin.jvm.internal.Intrinsics.checkNotNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.KTypeImpl) kType).getType().getConstructor().mo1835getDeclarationDescriptor();
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
                if (classDescriptor != null && classDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE && classDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS) {
                    obj = next;
                    break;
                }
            }
            kotlin.reflect.KType kType2 = (kotlin.reflect.KType) obj;
            if (kType2 == null) {
                kType2 = (kotlin.reflect.KType) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) upperBounds);
            }
            return (kType2 == null || (jvmErasure = getJvmErasure(kType2)) == null) ? kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(java.lang.Object.class) : jvmErasure;
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kClassifier);
    }
}
