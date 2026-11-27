package com.alibaba.fastjson.annotation;

/* JADX INFO: loaded from: classes.dex */
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface JSONPOJOBuilder {
    java.lang.String buildMethod() default "build";

    java.lang.String withPrefix() default "with";
}
