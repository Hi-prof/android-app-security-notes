package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class FieldDeserializer {
    protected com.alibaba.fastjson.serializer.BeanContext beanContext;
    protected final java.lang.Class<?> clazz;
    public final com.alibaba.fastjson.util.FieldInfo fieldInfo;

    public int getFastMatchToken() {
        return 0;
    }

    public abstract void parseField(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map);

    public FieldDeserializer(java.lang.Class<?> cls, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo;
    }

    public java.lang.Class<?> getOwnerClass() {
        return this.clazz;
    }

    public void setValue(java.lang.Object obj, boolean z) {
        setValue(obj, java.lang.Boolean.valueOf(z));
    }

    public void setValue(java.lang.Object obj, int i) {
        setValue(obj, java.lang.Integer.valueOf(i));
    }

    public void setValue(java.lang.Object obj, long j) {
        setValue(obj, java.lang.Long.valueOf(j));
    }

    public void setValue(java.lang.Object obj, java.lang.String str) {
        setValue(obj, (java.lang.Object) str);
    }

    public void setValue(java.lang.Object obj, java.lang.Object obj2) {
        if (obj2 == null && this.fieldInfo.fieldClass.isPrimitive()) {
            return;
        }
        if (this.fieldInfo.fieldClass == java.lang.String.class && this.fieldInfo.format != null && this.fieldInfo.format.equals(io.dcloud.common.constant.AbsoluteConst.XML_TRIM)) {
            obj2 = ((java.lang.String) obj2).trim();
        }
        try {
            java.lang.reflect.Method method = this.fieldInfo.method;
            if (method != null) {
                if (this.fieldInfo.getOnly) {
                    if (this.fieldInfo.fieldClass == java.util.concurrent.atomic.AtomicInteger.class) {
                        java.util.concurrent.atomic.AtomicInteger atomicInteger = (java.util.concurrent.atomic.AtomicInteger) method.invoke(obj, null);
                        if (atomicInteger != null) {
                            atomicInteger.set(((java.util.concurrent.atomic.AtomicInteger) obj2).get());
                            return;
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                    }
                    if (this.fieldInfo.fieldClass == java.util.concurrent.atomic.AtomicLong.class) {
                        java.util.concurrent.atomic.AtomicLong atomicLong = (java.util.concurrent.atomic.AtomicLong) method.invoke(obj, null);
                        if (atomicLong != null) {
                            atomicLong.set(((java.util.concurrent.atomic.AtomicLong) obj2).get());
                            return;
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                    }
                    if (this.fieldInfo.fieldClass == java.util.concurrent.atomic.AtomicBoolean.class) {
                        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = (java.util.concurrent.atomic.AtomicBoolean) method.invoke(obj, null);
                        if (atomicBoolean != null) {
                            atomicBoolean.set(((java.util.concurrent.atomic.AtomicBoolean) obj2).get());
                            return;
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                    }
                    if (java.util.Map.class.isAssignableFrom(method.getReturnType())) {
                        try {
                            java.util.Map map = (java.util.Map) method.invoke(obj, null);
                            if (map == null) {
                                if (obj2 != null) {
                                    degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                    return;
                                }
                                return;
                            } else {
                                if (map == java.util.Collections.EMPTY_MAP) {
                                    return;
                                }
                                if (map.isEmpty() && ((java.util.Map) obj2).isEmpty()) {
                                    return;
                                }
                                java.lang.String name = map.getClass().getName();
                                if (!name.equals("java.util.ImmutableCollections$Map1") && !name.equals("java.util.ImmutableCollections$MapN") && !name.startsWith("java.util.Collections$Unmodifiable")) {
                                    if (map.getClass().getName().equals("kotlin.collections.EmptyMap")) {
                                        degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                        return;
                                    } else {
                                        map.putAll((java.util.Map) obj2);
                                        return;
                                    }
                                }
                                return;
                            }
                        } catch (java.lang.reflect.InvocationTargetException unused) {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                    }
                    try {
                        java.util.Collection collection = (java.util.Collection) method.invoke(obj, null);
                        if (collection == null || obj2 == null) {
                            if (collection != null || obj2 == null) {
                                return;
                            }
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                        java.lang.String name2 = collection.getClass().getName();
                        if (collection != java.util.Collections.EMPTY_SET && collection != java.util.Collections.EMPTY_LIST && name2 != "java.util.ImmutableCollections$ListN" && name2 != "java.util.ImmutableCollections$List12" && !name2.startsWith("java.util.Collections$Unmodifiable")) {
                            if (!collection.isEmpty()) {
                                collection.clear();
                            } else if (((java.util.Collection) obj2).isEmpty()) {
                                return;
                            }
                            if (!name2.equals("kotlin.collections.EmptyList") && !name2.equals("kotlin.collections.EmptySet")) {
                                collection.addAll((java.util.Collection) obj2);
                                return;
                            }
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                        return;
                    } catch (java.lang.reflect.InvocationTargetException unused2) {
                        degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        return;
                    }
                    throw new com.alibaba.fastjson.JSONException("set property error, " + this.clazz.getName() + "#" + this.fieldInfo.name, e);
                }
                method.invoke(obj, obj2);
                return;
            }
            java.lang.reflect.Field field = this.fieldInfo.field;
            if (!this.fieldInfo.getOnly) {
                if (field != null) {
                    field.set(obj, obj2);
                    return;
                }
                return;
            }
            if (this.fieldInfo.fieldClass == java.util.concurrent.atomic.AtomicInteger.class) {
                java.util.concurrent.atomic.AtomicInteger atomicInteger2 = (java.util.concurrent.atomic.AtomicInteger) field.get(obj);
                if (atomicInteger2 != null) {
                    atomicInteger2.set(((java.util.concurrent.atomic.AtomicInteger) obj2).get());
                    return;
                }
                return;
            }
            if (this.fieldInfo.fieldClass == java.util.concurrent.atomic.AtomicLong.class) {
                java.util.concurrent.atomic.AtomicLong atomicLong2 = (java.util.concurrent.atomic.AtomicLong) field.get(obj);
                if (atomicLong2 != null) {
                    atomicLong2.set(((java.util.concurrent.atomic.AtomicLong) obj2).get());
                    return;
                }
                return;
            }
            if (this.fieldInfo.fieldClass == java.util.concurrent.atomic.AtomicBoolean.class) {
                java.util.concurrent.atomic.AtomicBoolean atomicBoolean2 = (java.util.concurrent.atomic.AtomicBoolean) field.get(obj);
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(((java.util.concurrent.atomic.AtomicBoolean) obj2).get());
                    return;
                }
                return;
            }
            if (java.util.Map.class.isAssignableFrom(this.fieldInfo.fieldClass)) {
                java.util.Map map2 = (java.util.Map) field.get(obj);
                if (map2 != null && map2 != java.util.Collections.EMPTY_MAP && !map2.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                    map2.putAll((java.util.Map) obj2);
                    return;
                }
                return;
            }
            java.util.Collection collection2 = (java.util.Collection) field.get(obj);
            if (collection2 != null && obj2 != null && collection2 != java.util.Collections.EMPTY_SET && collection2 != java.util.Collections.EMPTY_LIST && !collection2.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                collection2.clear();
                collection2.addAll((java.util.Collection) obj2);
            }
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("set property error, " + this.clazz.getName() + "#" + this.fieldInfo.name, e);
        }
    }

    private static boolean degradeValueAssignment(java.lang.reflect.Field field, java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object obj2) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        if (setFieldValue(field, obj, obj2)) {
            return true;
        }
        try {
            obj.getClass().getDeclaredMethod("set" + method.getName().substring(3), method.getReturnType()).invoke(obj, obj2);
            return true;
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    private static boolean setFieldValue(java.lang.reflect.Field field, java.lang.Object obj, java.lang.Object obj2) throws java.lang.IllegalAccessException {
        if (field == null || java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
            return false;
        }
        field.set(obj, obj2);
        return true;
    }

    public void setWrappedValue(java.lang.String str, java.lang.Object obj) {
        throw new com.alibaba.fastjson.JSONException("TODO");
    }
}
