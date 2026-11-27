package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: loaded from: classes2.dex */
public final class JvmAnnotationNames {
    public static final kotlin.reflect.jvm.internal.impl.name.Name DEFAULT_ANNOTATION_MEMBER_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName DEPRECATED_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName DOCUMENTED_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName ELEMENT_TYPE_ENUM;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName ENHANCED_MUTABILITY_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName ENHANCED_NULLABILITY_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName JETBRAINS_MUTABLE_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName JETBRAINS_NOT_NULL_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName JETBRAINS_NULLABLE_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName JETBRAINS_READONLY_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName KOTLIN_JVM_INTERNAL;
    public static final java.lang.String METADATA_DESC;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName METADATA_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName MUTABLE_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName OVERRIDE_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName PURELY_IMPLEMENTS_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName READONLY_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName REPEATABLE_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName RETENTION_ANNOTATION;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName RETENTION_POLICY_ENUM;
    public static final java.lang.String SERIALIZED_IR_DESC;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName SERIALIZED_IR_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName TARGET_ANNOTATION;

    static {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.Metadata");
        METADATA_FQ_NAME = fqName;
        METADATA_DESC = "L" + kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byFqNameWithoutInnerClasses(fqName).getInternalName() + ";";
        DEFAULT_ANNOTATION_MEMBER_NAME = kotlin.reflect.jvm.internal.impl.name.Name.identifier("value");
        TARGET_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName(java.lang.annotation.Target.class.getName());
        ELEMENT_TYPE_ENUM = new kotlin.reflect.jvm.internal.impl.name.FqName(java.lang.annotation.ElementType.class.getName());
        RETENTION_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName(java.lang.annotation.Retention.class.getName());
        RETENTION_POLICY_ENUM = new kotlin.reflect.jvm.internal.impl.name.FqName(java.lang.annotation.RetentionPolicy.class.getName());
        DEPRECATED_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName(java.lang.Deprecated.class.getName());
        DOCUMENTED_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName(java.lang.annotation.Documented.class.getName());
        REPEATABLE_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("java.lang.annotation.Repeatable");
        OVERRIDE_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName(java.lang.Override.class.getName());
        JETBRAINS_NOT_NULL_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jetbrains.annotations.NotNull");
        JETBRAINS_NULLABLE_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jetbrains.annotations.Nullable");
        JETBRAINS_MUTABLE_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jetbrains.annotations.Mutable");
        JETBRAINS_READONLY_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jetbrains.annotations.ReadOnly");
        READONLY_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.annotations.jvm.ReadOnly");
        MUTABLE_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.annotations.jvm.Mutable");
        PURELY_IMPLEMENTS_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.PurelyImplements");
        KOTLIN_JVM_INTERNAL = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal");
        kotlin.reflect.jvm.internal.impl.name.FqName fqName2 = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal.SerializedIr");
        SERIALIZED_IR_FQ_NAME = fqName2;
        SERIALIZED_IR_DESC = "L" + kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byFqNameWithoutInnerClasses(fqName2).getInternalName() + ";";
        ENHANCED_NULLABILITY_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal.EnhancedNullability");
        ENHANCED_MUTABILITY_ANNOTATION = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal.EnhancedMutability");
    }
}
