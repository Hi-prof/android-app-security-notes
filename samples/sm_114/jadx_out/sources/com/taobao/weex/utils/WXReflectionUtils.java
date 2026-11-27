package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXReflectionUtils {
    public static java.lang.Object parseArgument(java.lang.reflect.Type type, java.lang.Object obj) {
        if (obj == null || (obj.getClass() != type && (!(type instanceof java.lang.Class) || !((java.lang.Class) type).isAssignableFrom(obj.getClass())))) {
            if (type == java.lang.String.class) {
                if (!(obj instanceof java.lang.String)) {
                    return com.alibaba.fastjson.JSON.toJSONString(obj);
                }
            } else if (type == java.lang.Integer.TYPE) {
                if (!obj.getClass().isAssignableFrom(java.lang.Integer.TYPE)) {
                    return java.lang.Integer.valueOf(com.taobao.weex.utils.WXUtils.getInt(obj));
                }
            } else if (type == java.lang.Long.TYPE) {
                if (!obj.getClass().isAssignableFrom(java.lang.Long.TYPE)) {
                    return java.lang.Long.valueOf(com.taobao.weex.utils.WXUtils.getLong(obj));
                }
            } else if (type == java.lang.Double.TYPE) {
                if (!obj.getClass().isAssignableFrom(java.lang.Double.TYPE)) {
                    return java.lang.Double.valueOf(com.taobao.weex.utils.WXUtils.getDouble(obj));
                }
            } else if (type == java.lang.Float.TYPE) {
                if (!obj.getClass().isAssignableFrom(java.lang.Float.TYPE)) {
                    return java.lang.Float.valueOf(com.taobao.weex.utils.WXUtils.getFloat(obj));
                }
            } else if ((type != com.alibaba.fastjson.JSONArray.class || obj == null || obj.getClass() != com.alibaba.fastjson.JSONArray.class) && (type != com.alibaba.fastjson.JSONObject.class || obj == null || obj.getClass() != com.alibaba.fastjson.JSONObject.class)) {
                return com.alibaba.fastjson.JSON.parseObject(obj instanceof java.lang.String ? (java.lang.String) obj : com.alibaba.fastjson.JSON.toJSONString(obj), type, new com.alibaba.fastjson.parser.Feature[0]);
            }
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    public static void setValue(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        java.lang.Object objValueOf;
        if (obj == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            java.lang.reflect.Field declaredField = getDeclaredField(obj, str);
            if (!(obj2 instanceof java.math.BigDecimal) && !(obj2 instanceof java.lang.Number) && !(obj2 instanceof java.lang.String)) {
                objValueOf = obj2;
            } else if (declaredField.getType() == java.lang.Float.class || declaredField.getType() == java.lang.Float.TYPE) {
                objValueOf = java.lang.Float.valueOf(java.lang.Float.parseFloat(obj2.toString()));
            } else if (declaredField.getType() == java.lang.Double.class || declaredField.getType() == java.lang.Double.TYPE) {
                objValueOf = java.lang.Double.valueOf(java.lang.Double.parseDouble(obj2.toString()));
            } else if (declaredField.getType() == java.lang.Integer.class || declaredField.getType() == java.lang.Integer.TYPE) {
                objValueOf = java.lang.Integer.valueOf((int) java.lang.Double.parseDouble(obj2.toString()));
            } else if (declaredField.getType() == java.lang.Boolean.class || declaredField.getType() == java.lang.Boolean.TYPE) {
                objValueOf = java.lang.Boolean.valueOf(obj2.toString());
            } else {
                objValueOf = obj2;
            }
            if ((declaredField.getType() == java.lang.Boolean.TYPE || declaredField.getType() == java.lang.Boolean.class) && obj2 != null) {
                objValueOf = java.lang.Boolean.valueOf(obj2.toString());
            }
            setProperty(obj, declaredField, objValueOf);
        } catch (java.lang.Exception unused) {
        }
    }

    public static java.lang.reflect.Field getDeclaredField(java.lang.Object obj, java.lang.String str) {
        for (java.lang.Class<?> superclass = obj.getClass(); superclass != java.lang.Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredField(str);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static void setProperty(java.lang.Object obj, java.lang.reflect.Field field, java.lang.Object obj2) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        if (obj == null || field == null) {
            return;
        }
        try {
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (java.lang.Exception unused) {
        }
    }
}
