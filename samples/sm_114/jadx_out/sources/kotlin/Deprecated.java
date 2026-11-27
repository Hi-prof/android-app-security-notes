package kotlin;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.ANNOTATION_TYPE})
@kotlin.annotation.MustBeDocumented
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\b\u0002\u0010\u0004\u001a\u00020\u0005B\u0018\b\u000bB\u0014\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\b\b\u0012\u0002\b\f\u0012\u0010\b\u0002\u0010\t\u001a\u00020\nB\u0006\b\n0\n8\u000bR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\fR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u000f\u0010\t\u001a\u00020\n¢\u0006\u0006\u001a\u0004\b\t\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/Deprecated;", "", "message", "", "replaceWith", "Lkotlin/ReplaceWith;", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_EXPRESSION, "", "imports", androidtranscoder.format.MediaFormatExtraConstants.KEY_LEVEL, "Lkotlin/DeprecationLevel;", "WARNING", "()Ljava/lang/String;", "()Lkotlin/ReplaceWith;", "()Lkotlin/DeprecationLevel;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {kotlin.annotation.AnnotationTarget.CLASS, kotlin.annotation.AnnotationTarget.FUNCTION, kotlin.annotation.AnnotationTarget.PROPERTY, kotlin.annotation.AnnotationTarget.ANNOTATION_CLASS, kotlin.annotation.AnnotationTarget.CONSTRUCTOR, kotlin.annotation.AnnotationTarget.PROPERTY_SETTER, kotlin.annotation.AnnotationTarget.PROPERTY_GETTER, kotlin.annotation.AnnotationTarget.TYPEALIAS})
@java.lang.annotation.Documented
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Deprecated {
    kotlin.DeprecationLevel level() default kotlin.DeprecationLevel.WARNING;

    java.lang.String message();

    kotlin.ReplaceWith replaceWith() default @kotlin.ReplaceWith(expression = "", imports = {});
}
