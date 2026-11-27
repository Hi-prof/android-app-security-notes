package kotlin.annotations.jvm;

/* JADX INFO: loaded from: classes2.dex */
@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface UnderMigration {
    kotlin.annotations.jvm.MigrationStatus status();
}
