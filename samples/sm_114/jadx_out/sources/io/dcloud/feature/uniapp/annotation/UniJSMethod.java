package io.dcloud.feature.uniapp.annotation;

/* JADX INFO: loaded from: classes2.dex */
@java.lang.annotation.Inherited
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface UniJSMethod {
    public static final java.lang.String NOT_SET = "_";

    java.lang.String alias() default "_";

    boolean uiThread() default true;
}
