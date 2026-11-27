package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k3 {
    static java.util.HashMap a = new java.util.HashMap(2);
    static java.util.HashMap b = new java.util.HashMap(2);
    private static java.lang.String c = "cache/invCache/";
    private static java.lang.String d = "cache/invCache_temp/";

    public static java.lang.Class a(java.lang.String str) {
        java.lang.Class<?> cls = (java.lang.Class) a.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            cls = java.lang.Class.forName(str);
            a.put(str, cls);
            return cls;
        } catch (java.lang.ClassNotFoundException unused) {
            return cls;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        return c(a(str));
    }

    public static java.lang.String c(java.lang.Class cls) {
        java.lang.String str = (java.lang.String) b.get(cls);
        if (str != null) {
            return str.toString();
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE).append(cls.getName()).append("\",");
        for (java.lang.Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE).append(superclass.getName()).append("\",");
            if (superclass == java.lang.Object.class) {
                break;
            }
        }
        a(stringBuffer);
        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        java.lang.String string = stringBuffer.toString();
        b.put(cls, string);
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(string, false);
    }

    public static java.lang.String b(java.lang.Class cls) {
        return cls.getName();
    }

    public static void a(java.lang.StringBuffer stringBuffer, java.util.ArrayList arrayList, java.lang.StringBuffer stringBuffer2, java.util.ArrayList arrayList2, java.lang.Class cls) {
        for (java.lang.reflect.Method method : cls.getMethods()) {
            java.lang.String name = method.getName();
            int modifiers = method.getModifiers();
            if (java.lang.reflect.Modifier.isPublic(modifiers)) {
                if (java.lang.reflect.Modifier.isStatic(modifiers) && !arrayList2.contains(name) && !name.contains(com.taobao.weex.el.parse.Operators.SUB) && !"toString".equals(name) && !"valueOf".equals(name) && !"propertyIsEnumerable".equals(name) && !"hasOwnProperty".equals(name) && !"isPrototypeOf".equals(name) && !"constructor".equals(name) && !"toLocaleString".equals(name)) {
                    arrayList2.add(name);
                    stringBuffer2.append(io.dcloud.common.util.JSUtil.QUOTE + name + io.dcloud.common.util.JSUtil.QUOTE);
                    stringBuffer2.append(",");
                }
                if (!arrayList.contains(name) && !name.contains(com.taobao.weex.el.parse.Operators.SUB)) {
                    arrayList.add(name);
                    stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE + name + io.dcloud.common.util.JSUtil.QUOTE);
                    stringBuffer.append(",");
                }
            }
        }
    }

    public static void a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.Object obj, java.lang.reflect.Field field, boolean z, java.lang.StringBuffer stringBuffer, java.lang.StringBuffer stringBuffer2) {
        java.lang.String name = field.getName();
        int modifiers = field.getModifiers();
        if (!(z && java.lang.reflect.Modifier.isStatic(modifiers) && java.lang.reflect.Modifier.isFinal(modifiers)) && (z || java.lang.reflect.Modifier.isStatic(modifiers) || !java.lang.reflect.Modifier.isPublic(modifiers))) {
            return;
        }
        try {
            a(iWebview, x2Var, field.getType(), field.get(obj), name, z, stringBuffer, stringBuffer2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    static void a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.Class cls, java.lang.Object obj, java.lang.String str, boolean z, java.lang.StringBuffer stringBuffer, java.lang.StringBuffer stringBuffer2) {
        if (z) {
            stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE + str + io.dcloud.common.util.JSUtil.QUOTE);
            a(iWebview, x2Var, obj, cls, stringBuffer2);
            stringBuffer.append(",");
            stringBuffer2.append(",");
            return;
        }
        stringBuffer.append("self.").append(str).append("=");
        a(iWebview, x2Var, obj, cls, stringBuffer2);
        stringBuffer.append(stringBuffer2.toString()).append(";");
        stringBuffer2.delete(0, stringBuffer2.length());
    }

    public static void a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.Object obj, java.lang.Class cls, java.lang.StringBuffer stringBuffer) {
        if (obj == null) {
            stringBuffer.append("null");
            return;
        }
        if (a(cls)) {
            stringBuffer.append(java.lang.String.valueOf(obj));
            return;
        }
        if (!cls.equals(java.lang.String.class) && !cls.equals(java.lang.Character.class)) {
            int iA = a(obj);
            if (iA > -1) {
                java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
                stringBuffer2.append(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
                for (int i = 0; i < iA; i++) {
                    java.lang.Object objA = a(java.lang.reflect.Array.get(obj, i), obj.getClass());
                    a(iWebview, x2Var, objA, objA.getClass(), stringBuffer2);
                    stringBuffer2.append(",");
                }
                a(stringBuffer2);
                stringBuffer2.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                stringBuffer.append(stringBuffer2);
                return;
            }
            stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE + io.dcloud.common.util.JSUtil.toJsResponseText(io.dcloud.p.x2.b(iWebview, obj)) + io.dcloud.common.util.JSUtil.QUOTE);
            return;
        }
        stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE + io.dcloud.common.util.JSUtil.toJsResponseText(io.dcloud.common.util.JSUtil.QUOTE + java.lang.String.valueOf(obj) + io.dcloud.common.util.JSUtil.QUOTE) + io.dcloud.common.util.JSUtil.QUOTE);
    }

    public static int a(java.lang.Object obj) {
        if (obj instanceof java.lang.Object[]) {
            return ((java.lang.Object[]) obj).length;
        }
        if (obj instanceof boolean[]) {
            return ((boolean[]) obj).length;
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj).length;
        }
        if (obj instanceof char[]) {
            return ((char[]) obj).length;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj).length;
        }
        if (obj instanceof int[]) {
            return ((int[]) obj).length;
        }
        if (obj instanceof long[]) {
            return ((long[]) obj).length;
        }
        if (obj instanceof float[]) {
            return ((float[]) obj).length;
        }
        if (obj instanceof double[]) {
            return ((double[]) obj).length;
        }
        return -1;
    }

    public static java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.String str) {
        java.lang.StringBuffer stringBuffer;
        java.lang.Class clsA = a(str);
        java.lang.System.currentTimeMillis();
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer();
        java.lang.StringBuffer stringBuffer4 = new java.lang.StringBuffer();
        java.lang.StringBuffer stringBuffer5 = new java.lang.StringBuffer();
        if (clsA != null) {
            try {
                a(stringBuffer2, new java.util.ArrayList(), stringBuffer3, new java.util.ArrayList(), clsA);
                a(stringBuffer2);
                a(stringBuffer3);
                for (java.lang.reflect.Field field : clsA.getFields()) {
                    a(iWebview, x2Var, null, field, true, stringBuffer4, stringBuffer5);
                }
                stringBuffer = stringBuffer5;
                try {
                    a(iWebview, x2Var, java.lang.Class.class, clsA, "class", true, stringBuffer4, stringBuffer);
                    try {
                        a(clsA, str, stringBuffer4, stringBuffer);
                        a(stringBuffer4);
                        a(stringBuffer);
                    } catch (java.lang.Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    stringBuffer4 = stringBuffer4;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                stringBuffer = stringBuffer5;
            }
        } else {
            stringBuffer = stringBuffer5;
        }
        return io.dcloud.common.util.StringUtil.format("{InstanceMethod:[%s],ClassMethod:[%s],ClassConstKeys:[%s],ClassConstValues:[%s]}", stringBuffer2.toString(), stringBuffer3.toString(), stringBuffer4.toString(), stringBuffer.toString());
    }

    private static void a(java.lang.Class cls, java.lang.String str, java.lang.StringBuffer stringBuffer, java.lang.StringBuffer stringBuffer2) {
        java.lang.Class<?>[] classes = cls.getClasses();
        if (classes != null) {
            for (java.lang.Class<?> cls2 : classes) {
                java.lang.String simpleName = cls2.getSimpleName();
                java.lang.String name = cls2.getName();
                stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE + simpleName + io.dcloud.common.util.JSUtil.QUOTE);
                stringBuffer2.append(io.dcloud.common.util.JSUtil.QUOTE + io.dcloud.common.util.JSUtil.toJsResponseText(io.dcloud.common.util.StringUtil.format("plus.android.importClass('%s')", name)) + io.dcloud.common.util.JSUtil.QUOTE);
                stringBuffer.append(",");
                stringBuffer2.append(",");
            }
        }
    }

    public static void a(java.lang.StringBuffer stringBuffer) {
        if (stringBuffer.length() <= 0 || stringBuffer.charAt(stringBuffer.length() - 1) != ',') {
            return;
        }
        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
    }

    public static boolean a(java.lang.Class cls) {
        return cls == java.lang.Boolean.class || cls == java.lang.Boolean.TYPE || cls == java.lang.Double.class || cls == java.lang.Double.TYPE || cls == java.lang.Integer.class || cls == java.lang.Integer.TYPE || cls == java.lang.Float.class || cls == java.lang.Float.TYPE || cls == java.lang.Long.class || cls == java.lang.Long.TYPE || cls == java.lang.Byte.class || cls == java.lang.Byte.TYPE;
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.Class cls) {
        if (obj != null) {
            return obj;
        }
        java.lang.String string = cls.toString();
        if (!string.contains("java.lang.Byte") && !string.contains("java.lang.Long") && !string.contains("java.lang.Float") && !string.contains("java.lang.Integer") && !string.contains("java.lang.Double")) {
            if (string.contains("java.lang.Boolean")) {
                return java.lang.Boolean.FALSE;
            }
            return null;
        }
        return 0;
    }
}
