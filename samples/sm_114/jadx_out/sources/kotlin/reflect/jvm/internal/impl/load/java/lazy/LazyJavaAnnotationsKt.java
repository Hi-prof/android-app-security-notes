package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: LazyJavaAnnotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaAnnotationsKt {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations resolveAnnotations(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner annotationsOwner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationsOwner, "annotationsOwner");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations(lazyJavaResolverContext, annotationsOwner, false, 4, null);
    }
}
