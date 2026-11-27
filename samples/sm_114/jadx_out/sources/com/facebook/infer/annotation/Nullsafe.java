package com.facebook.infer.annotation;

/* JADX INFO: loaded from: classes.dex */
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@javax.annotation.meta.TypeQualifierDefault({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
@javax.annotation.Nonnull
@kotlin.annotations.jvm.UnderMigration(status = kotlin.annotations.jvm.MigrationStatus.STRICT)
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
public @interface Nullsafe {

    public enum Mode {
        LOCAL,
        STRICT
    }

    public @interface TrustList {
        boolean trustAll() default false;

        java.lang.Class[] value();
    }

    com.facebook.infer.annotation.Nullsafe.TrustList trustOnly() default @com.facebook.infer.annotation.Nullsafe.TrustList(trustAll = true, value = {});

    com.facebook.infer.annotation.Nullsafe.Mode value();
}
