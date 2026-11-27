package io.dcloud.uts.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class Primitives {
    private Primitives() {
    }

    public static boolean isPrimitive(java.lang.reflect.Type type) {
        return (type instanceof java.lang.Class) && ((java.lang.Class) type).isPrimitive();
    }

    public static boolean isWrapperType(java.lang.reflect.Type type) {
        return type == java.lang.Integer.class || type == java.lang.Float.class || type == java.lang.Byte.class || type == java.lang.Double.class || type == java.lang.Long.class || type == java.lang.Character.class || type == java.lang.Boolean.class || type == java.lang.Short.class || type == java.lang.Void.class;
    }

    public static <T> java.lang.Class<T> wrap(java.lang.Class<T> cls) {
        if (cls == java.lang.Integer.TYPE) {
            return java.lang.Integer.class;
        }
        if (cls == java.lang.Float.TYPE) {
            return java.lang.Float.class;
        }
        if (cls == java.lang.Byte.TYPE) {
            return java.lang.Byte.class;
        }
        if (cls == java.lang.Double.TYPE) {
            return java.lang.Double.class;
        }
        if (cls == java.lang.Long.TYPE) {
            return java.lang.Long.class;
        }
        if (cls == java.lang.Character.TYPE) {
            return java.lang.Character.class;
        }
        if (cls == java.lang.Boolean.TYPE) {
            return java.lang.Boolean.class;
        }
        if (cls == java.lang.Short.TYPE) {
            return java.lang.Short.class;
        }
        return cls == java.lang.Void.TYPE ? java.lang.Void.class : cls;
    }

    public static <T> java.lang.Class<T> unwrap(java.lang.Class<T> cls) {
        if (cls == java.lang.Integer.class) {
            return java.lang.Integer.TYPE;
        }
        if (cls == java.lang.Float.class) {
            return java.lang.Float.TYPE;
        }
        if (cls == java.lang.Byte.class) {
            return java.lang.Byte.TYPE;
        }
        if (cls == java.lang.Double.class) {
            return java.lang.Double.TYPE;
        }
        if (cls == java.lang.Long.class) {
            return java.lang.Long.TYPE;
        }
        if (cls == java.lang.Character.class) {
            return java.lang.Character.TYPE;
        }
        if (cls == java.lang.Boolean.class) {
            return java.lang.Boolean.TYPE;
        }
        if (cls == java.lang.Short.class) {
            return java.lang.Short.TYPE;
        }
        return cls == java.lang.Void.class ? java.lang.Void.TYPE : cls;
    }
}
