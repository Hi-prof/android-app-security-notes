package kotlin.reflect.full;

/* JADX INFO: compiled from: KAnnotatedElements.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0007¨\u0006\u000b"}, d2 = {"findAnnotation", "T", "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "hasAnnotation", "", "findAnnotations", "", "klass", "Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KAnnotatedElements {
    public static final /* synthetic */ <T extends java.lang.annotation.Annotation> T findAnnotation(kotlin.reflect.KAnnotatedElement kAnnotatedElement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kAnnotatedElement, "<this>");
        for (java.lang.Object obj : kAnnotatedElement.getAnnotations()) {
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(3, "T");
            if (((java.lang.annotation.Annotation) obj) instanceof java.lang.annotation.Annotation) {
                kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T?");
                return (T) obj;
            }
        }
        obj = null;
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T?");
        return (T) obj;
    }

    public static final /* synthetic */ <T extends java.lang.annotation.Annotation> java.util.List<T> findAnnotations(kotlin.reflect.KAnnotatedElement kAnnotatedElement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kAnnotatedElement, "<this>");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
        return findAnnotations(kAnnotatedElement, kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(java.lang.annotation.Annotation.class));
    }

    public static final <T extends java.lang.annotation.Annotation> java.util.List<T> findAnnotations(kotlin.reflect.KAnnotatedElement kAnnotatedElement, kotlin.reflect.KClass<T> klass) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.Object next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kAnnotatedElement, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        java.util.List<T> listFilterIsInstance = kotlin.collections.CollectionsKt.filterIsInstance(kAnnotatedElement.getAnnotations(), kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) klass));
        if (!listFilterIsInstance.isEmpty()) {
            return listFilterIsInstance;
        }
        java.lang.Class<? extends java.lang.annotation.Annotation> clsLoadRepeatableContainer = kotlin.reflect.full.Java8RepeatableContainerLoader.INSTANCE.loadRepeatableContainer(kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) klass));
        if (clsLoadRepeatableContainer != null) {
            java.util.Iterator<T> it = kAnnotatedElement.getAnnotations().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!kotlin.jvm.internal.Intrinsics.areEqual(kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass((java.lang.annotation.Annotation) next)), clsLoadRepeatableContainer));
            java.lang.annotation.Annotation annotation = (java.lang.annotation.Annotation) next;
            if (annotation != null) {
                java.lang.Object objInvoke = annotation.getClass().getMethod("value", null).invoke(annotation, null);
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
                return kotlin.collections.ArraysKt.asList((java.lang.annotation.Annotation[]) objInvoke);
            }
        }
        return kotlin.collections.CollectionsKt.emptyList();
    }

    public static final /* synthetic */ <T extends java.lang.annotation.Annotation> boolean hasAnnotation(kotlin.reflect.KAnnotatedElement kAnnotatedElement) {
        java.lang.Object next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kAnnotatedElement, "<this>");
        java.util.Iterator<T> it = kAnnotatedElement.getAnnotations().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(3, "T");
        } while (!(((java.lang.annotation.Annotation) next) instanceof java.lang.annotation.Annotation));
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T?");
        return ((java.lang.annotation.Annotation) next) != null;
    }
}
