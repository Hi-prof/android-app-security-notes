package io.dcloud.feature.uniapp.common;

/* JADX INFO: loaded from: classes2.dex */
@java.lang.annotation.Inherited
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.Deprecated
public @interface UniModuleAnno {
    @java.lang.Deprecated
    boolean moduleMethod() default true;

    boolean runOnUIThread() default true;
}
