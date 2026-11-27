package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JvmAbi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmAbi {
    public static final kotlin.reflect.jvm.internal.impl.load.java.JvmAbi INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.JvmAbi();
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId JVM_FIELD_ANNOTATION_CLASS_ID;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName JVM_FIELD_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId REFLECTION_FACTORY_IMPL;
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION;

    private JvmAbi() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.JvmField");
        JVM_FIELD_ANNOTATION_FQ_NAME = fqName;
        JVM_FIELD_ANNOTATION_CLASS_ID = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName);
        REFLECTION_FACTORY_IMPL = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/jvm/internal/RepeatableContainer", false, 2, null);
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION() {
        return REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isGetterName(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.text.StringsKt.startsWith$default(name, "get", false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.startsWith$default(name, "is", false, 2, (java.lang.Object) null);
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isSetterName(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.text.StringsKt.startsWith$default(name, "set", false, 2, (java.lang.Object) null);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getterName(java.lang.String propertyName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        if (startsWithIsPrefix(propertyName)) {
            return propertyName;
        }
        return "get" + kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String setterName(java.lang.String propertyName) {
        java.lang.String strCapitalizeAsciiOnly;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        java.lang.StringBuilder sb = new java.lang.StringBuilder("set");
        if (startsWithIsPrefix(propertyName)) {
            strCapitalizeAsciiOnly = propertyName.substring(2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strCapitalizeAsciiOnly, "substring(...)");
        } else {
            strCapitalizeAsciiOnly = kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName);
        }
        sb.append(strCapitalizeAsciiOnly);
        return sb.toString();
    }

    @kotlin.jvm.JvmStatic
    public static final boolean startsWithIsPrefix(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (!kotlin.text.StringsKt.startsWith$default(name, "is", false, 2, (java.lang.Object) null) || name.length() == 2) {
            return false;
        }
        char cCharAt = name.charAt(2);
        return kotlin.jvm.internal.Intrinsics.compare(97, (int) cCharAt) > 0 || kotlin.jvm.internal.Intrinsics.compare((int) cCharAt, 122) > 0;
    }
}
