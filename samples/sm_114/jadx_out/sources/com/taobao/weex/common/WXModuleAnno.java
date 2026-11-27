package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
@java.lang.annotation.Inherited
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.Deprecated
public @interface WXModuleAnno {
    @java.lang.Deprecated
    boolean moduleMethod() default true;

    boolean runOnUIThread() default true;
}
