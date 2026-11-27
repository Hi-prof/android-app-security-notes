package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class AnnotationSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    public static com.alibaba.fastjson.serializer.AnnotationSerializer instance = new com.alibaba.fastjson.serializer.AnnotationSerializer();
    private static volatile java.lang.Class sun_AnnotationType = null;
    private static volatile boolean sun_AnnotationType_error = false;
    private static volatile java.lang.reflect.Method sun_AnnotationType_getInstance;
    private static volatile java.lang.reflect.Method sun_AnnotationType_members;

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        java.lang.Class<?>[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            java.lang.Class<?> cls = interfaces[0];
            if (sun_AnnotationType == null && !sun_AnnotationType_error) {
                try {
                    sun_AnnotationType = java.lang.Class.forName("sun.reflect.annotation.AnnotationType");
                } catch (java.lang.Throwable th) {
                    sun_AnnotationType_error = true;
                    throw new com.alibaba.fastjson.JSONException("not support Type Annotation.", th);
                }
            }
            if (sun_AnnotationType == null) {
                throw new com.alibaba.fastjson.JSONException("not support Type Annotation.");
            }
            if (sun_AnnotationType_getInstance == null && !sun_AnnotationType_error) {
                try {
                    sun_AnnotationType_getInstance = sun_AnnotationType.getMethod("getInstance", java.lang.Class.class);
                } catch (java.lang.Throwable th2) {
                    sun_AnnotationType_error = true;
                    throw new com.alibaba.fastjson.JSONException("not support Type Annotation.", th2);
                }
            }
            if (sun_AnnotationType_members == null && !sun_AnnotationType_error) {
                try {
                    sun_AnnotationType_members = sun_AnnotationType.getMethod("members", null);
                } catch (java.lang.Throwable th3) {
                    sun_AnnotationType_error = true;
                    throw new com.alibaba.fastjson.JSONException("not support Type Annotation.", th3);
                }
            }
            if (sun_AnnotationType_getInstance == null || sun_AnnotationType_error) {
                throw new com.alibaba.fastjson.JSONException("not support Type Annotation.");
            }
            try {
                try {
                    java.util.Map map = (java.util.Map) sun_AnnotationType_members.invoke(sun_AnnotationType_getInstance.invoke(null, cls), null);
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject(map.size());
                    java.lang.Object objInvoke = null;
                    for (java.util.Map.Entry entry : map.entrySet()) {
                        try {
                            objInvoke = ((java.lang.reflect.Method) entry.getValue()).invoke(obj, null);
                        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
                        }
                        jSONObject.put((java.lang.String) entry.getKey(), com.alibaba.fastjson.JSON.toJSON(objInvoke));
                    }
                    jSONSerializer.write(jSONObject);
                } catch (java.lang.Throwable th4) {
                    sun_AnnotationType_error = true;
                    throw new com.alibaba.fastjson.JSONException("not support Type Annotation.", th4);
                }
            } catch (java.lang.Throwable th5) {
                sun_AnnotationType_error = true;
                throw new com.alibaba.fastjson.JSONException("not support Type Annotation.", th5);
            }
        }
    }
}
