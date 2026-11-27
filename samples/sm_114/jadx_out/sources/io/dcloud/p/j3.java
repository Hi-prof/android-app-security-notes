package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class j3 {
    io.dcloud.p.x2 a;
    java.lang.Class b;
    java.lang.Object c;
    java.lang.String d;

    public j3(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.Class cls, java.lang.String str, org.json.JSONArray jSONArray) {
        this.c = null;
        this.a = x2Var;
        this.b = cls;
        this.d = str;
        this.c = a(iWebview, x2Var, cls, jSONArray);
    }

    public static java.lang.Object a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.Class cls, org.json.JSONArray jSONArray) {
        java.lang.reflect.Constructor<?> constructor;
        if (jSONArray == null) {
            return cls.newInstance();
        }
        java.lang.Object[] objArrA = a(iWebview, x2Var, jSONArray);
        java.lang.Class<?>[] clsArr = (java.lang.Class[]) objArrA[0];
        java.lang.Object[] objArr = (java.lang.Object[]) objArrA[1];
        try {
            constructor = cls.getConstructor(clsArr);
        } catch (java.lang.NoSuchMethodException unused) {
            java.lang.reflect.Constructor<?>[] constructors = cls.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
                java.lang.Class<?>[] parameterTypes = constructors[i].getParameterTypes();
                if (parameterTypes.length == clsArr.length && a(parameterTypes, clsArr, objArr)) {
                    constructor = constructors[i];
                }
            }
            constructor = null;
        }
        if (constructor != null) {
            return constructor.newInstance(objArr);
        }
        return null;
    }

    public static void b(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.Class cls, java.lang.Object obj, java.lang.String str, org.json.JSONArray jSONArray) {
        java.lang.Object[] objArrA = a(iWebview, x2Var, jSONArray);
        try {
            java.lang.reflect.Field field = cls.getField(str);
            if (field != null) {
                field.setAccessible(true);
                field.set(obj, ((java.lang.Object[]) objArrA[1])[0]);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    static boolean c(java.lang.Class cls, java.lang.Class[] clsArr, int i) {
        boolean zC = c(cls, clsArr[i]);
        if (zC) {
            clsArr[i] = cls;
        }
        return zC;
    }

    static boolean d(java.lang.Class cls) {
        return java.lang.Character.TYPE.equals(cls) || java.lang.Character.class.equals(cls);
    }

    static boolean e(java.lang.Class cls) {
        return cls.equals(java.lang.Byte.TYPE) || cls.equals(java.lang.Byte.class) || cls.equals(java.lang.Integer.TYPE) || cls.equals(java.lang.Integer.class) || cls.equals(java.lang.Short.TYPE) || cls.equals(java.lang.Short.class) || cls.equals(java.lang.Float.TYPE) || cls.equals(java.lang.Float.class) || cls.equals(java.lang.Long.TYPE) || cls.equals(java.lang.Long.class) || cls.equals(java.lang.Double.TYPE) || cls.equals(java.lang.Double.class);
    }

    public boolean equals(java.lang.Object obj) {
        return super.equals(obj) || this.c.equals(obj);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class a {
        private int[] a;

        a(int i) {
            this.a = null;
            this.a = new int[i];
        }

        int[] a(int i) {
            int[] iArr = this.a;
            if (i > iArr.length) {
                return null;
            }
            return java.util.Arrays.copyOfRange(iArr, iArr.length - i, iArr.length);
        }

        void a(int i, int i2) {
            int[] iArr = this.a;
            if (i > iArr.length) {
                return;
            }
            iArr[iArr.length - i] = i2;
        }
    }

    static boolean c(java.lang.Class cls, java.lang.Class cls2) {
        if (java.lang.Number.class.isAssignableFrom(cls) && java.lang.Number.class.isAssignableFrom(cls2)) {
            return true;
        }
        return e(cls) && e(cls2);
    }

    static boolean c(java.lang.Class cls) {
        return java.lang.Boolean.TYPE.equals(cls) || java.lang.Boolean.class.equals(cls);
    }

    private static java.lang.reflect.Method b(java.lang.Class cls, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        int i;
        int length;
        try {
            java.lang.reflect.Method[] declaredMethods = cls.getDeclaredMethods();
            while (i < declaredMethods.length) {
                java.lang.reflect.Method method = declaredMethods[i];
                i = (method.getName().equals(str) && (length = method.getParameterTypes().length) == clsArr.length && (length == 0 || a(method.getParameterTypes(), clsArr, objArr))) ? 0 : i + 1;
                return method;
            }
            if (cls != java.lang.Object.class) {
                return b(cls.getSuperclass(), str, clsArr, objArr);
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public j3(io.dcloud.p.x2 x2Var, java.lang.Class cls, java.lang.String str, java.lang.Object obj) {
        this.a = x2Var;
        this.b = cls;
        this.d = str;
        this.c = obj;
    }

    public static java.lang.Object a(java.lang.Class cls, java.lang.Object obj, java.lang.String str) {
        try {
            java.lang.reflect.Field field = cls.getField(str);
            if (field == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static java.lang.Object[] b(java.lang.Class cls) {
        java.lang.Class<?> cls2;
        java.lang.String name = cls.getName();
        java.lang.Class<?> cls3 = null;
        int i = 0;
        for (int i2 = 0; i2 < name.length(); i2++) {
            char cCharAt = name.charAt(i2);
            if (cCharAt == '[') {
                i++;
            } else if (cCharAt == 'B') {
                cls3 = java.lang.Byte.TYPE;
            } else if (cCharAt == 'I') {
                cls3 = java.lang.Integer.TYPE;
            } else if (cCharAt == 'F') {
                cls3 = java.lang.Float.TYPE;
            } else if (cCharAt == 'D') {
                cls3 = java.lang.Double.TYPE;
            } else if (cCharAt == 'Z') {
                cls3 = java.lang.Boolean.TYPE;
            } else if (cCharAt == 'J') {
                cls3 = java.lang.Long.TYPE;
            } else {
                if (cCharAt != 'S') {
                    if (cCharAt == 'L') {
                        try {
                            cls2 = java.lang.Class.forName(name.substring(i2 + 1));
                            cls3 = cls2;
                            break;
                        } catch (java.lang.ClassNotFoundException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    try {
                        cls2 = java.lang.Class.forName(name);
                        cls3 = cls2;
                        break;
                    } catch (java.lang.ClassNotFoundException e2) {
                        e2.printStackTrace();
                        break;
                    }
                }
                cls3 = java.lang.Short.TYPE;
            }
        }
        return new java.lang.Object[]{java.lang.Integer.valueOf(i), cls3};
    }

    java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        for (java.lang.reflect.Field field : this.b.getFields()) {
            io.dcloud.p.k3.a(iWebview, x2Var, this.c, field, false, stringBuffer, stringBuffer2);
        }
        return stringBuffer.toString();
    }

    java.lang.Object a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray) {
        return a(iWebview, this.a, this.b, this.c, str, jSONArray);
    }

    public static final java.lang.Object a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.Class cls, java.lang.Object obj, java.lang.String str, org.json.JSONArray jSONArray) {
        java.lang.Object[] objArrA = a(iWebview, x2Var, jSONArray);
        java.lang.Class[] clsArr = (java.lang.Class[]) objArrA[0];
        java.lang.Object[] objArr = (java.lang.Object[]) objArrA[1];
        return a(obj, a(cls, str, clsArr, objArr), objArr, true);
    }

    private static final java.lang.Object a(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr, boolean z) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        try {
            if (method.getReturnType().equals(java.lang.Void.class)) {
                method.invoke(obj, objArr);
                return null;
            }
            return method.invoke(obj, objArr);
        } catch (java.lang.IllegalArgumentException e) {
            if (z) {
                java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes == null || objArr == null || parameterTypes.length != objArr.length) {
                    return null;
                }
                for (int i = 0; i < parameterTypes.length; i++) {
                    java.lang.Object obj2 = objArr[i];
                    if (obj2 != null) {
                        java.lang.Class<?> cls = obj2.getClass();
                        java.lang.Class<?> cls2 = parameterTypes[i];
                        if (cls.isAssignableFrom(cls2)) {
                            continue;
                        } else if (e(cls) && e(cls2)) {
                            objArr[i] = a(objArr[i], cls2);
                        } else {
                            throw e;
                        }
                    }
                }
                return a(obj, method, objArr, false);
            }
            throw e;
        }
    }

    static java.lang.reflect.Method a(java.lang.Class cls, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        boolean zEquals = "getClass".equals(str);
        java.lang.Class superclass = cls;
        while (true) {
            if (!zEquals && superclass == java.lang.Object.class) {
                return b(cls, str, clsArr, objArr);
            }
            try {
                java.lang.reflect.Method method = cls.getMethod(str, clsArr);
                if (method != null) {
                    method.setAccessible(true);
                    return method;
                }
                continue;
            } catch (java.lang.NoSuchMethodException unused) {
            }
            superclass = superclass.getSuperclass();
        }
    }

    static boolean b(java.lang.Class cls, java.lang.Class cls2) {
        return d(cls) && d(cls2);
    }

    static boolean b(java.lang.Class cls, java.lang.Class[] clsArr, int i) {
        boolean zB = b(cls, clsArr[i]);
        if (zB) {
            clsArr[i] = cls;
        }
        return zB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(java.lang.Class[] clsArr, java.lang.Class[] clsArr2, java.lang.Object[] objArr) {
        boolean z = false;
        for (int i = 0; i < clsArr.length; i++) {
            java.lang.Class cls = clsArr2[i];
            java.lang.Class cls2 = clsArr[i];
            z = cls == null ? !(e(cls2) || java.lang.Boolean.TYPE.equals(cls2) || java.lang.Boolean.class.equals(cls2) || java.lang.Character.TYPE.equals(cls2) || java.lang.Character.class.equals(cls2)) : cls2.isAssignableFrom(cls) || c(cls2, clsArr2, i) || a(cls2, clsArr2, i) || b(cls2, clsArr2, i) || (cls2.isArray() && cls2.isArray() && a(cls2, clsArr2, objArr, i));
            if (!z) {
                return z;
            }
        }
        return z;
    }

    static boolean a(java.lang.Class cls, java.lang.Class[] clsArr, java.lang.Object[] objArr, int i) {
        if (cls == clsArr[i]) {
            return true;
        }
        java.lang.Object[] objArrB = b(cls);
        java.lang.Object[] objArrB2 = b(clsArr[i]);
        int i2 = java.lang.Integer.parseInt(java.lang.String.valueOf(objArrB[0]));
        java.lang.Class<?> cls2 = (java.lang.Class) objArrB[1];
        int i3 = java.lang.Integer.parseInt(java.lang.String.valueOf(objArrB2[0]));
        java.lang.Class cls3 = (java.lang.Class) objArrB2[1];
        if (i2 == i3 && (a((java.lang.Class) cls2, cls3) || b(cls2, cls3) || c(cls2, cls3) || cls3.isAssignableFrom(cls2))) {
            try {
                java.lang.Object objA = a(objArr[i], cls2, i2, new io.dcloud.p.j3.a(i2));
                if (objA != null) {
                    clsArr[i] = cls;
                    objArr[i] = objA;
                    return true;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    static java.lang.Object a(java.lang.Object obj, java.lang.Class cls, int i, io.dcloud.p.j3.a aVar) {
        if (obj.getClass().isArray()) {
            int length = java.lang.reflect.Array.getLength(obj);
            java.lang.Object objNewInstance = null;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    java.lang.Object objA = a(java.lang.reflect.Array.get(obj, i2), cls, i - 1, aVar);
                    if (objNewInstance == null) {
                        aVar.a(i, length);
                        if (i == 1) {
                            objNewInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, length);
                        } else {
                            objNewInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, aVar.a(i));
                        }
                    }
                    java.lang.reflect.Array.set(objNewInstance, i2, objA);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    android.util.Log.w("test", "i=" + i2 + ";mAw=" + i);
                }
            }
            return objNewInstance;
        }
        return a(obj, cls);
    }

    static boolean a(java.lang.Class cls, java.lang.Class cls2) {
        return c(cls) && c(cls2);
    }

    static boolean a(java.lang.Class cls, java.lang.Class[] clsArr, int i) {
        boolean zA = a(cls, clsArr[i]);
        if (zA) {
            clsArr[i] = cls;
        }
        return zA;
    }

    static java.lang.Object a(java.lang.Object obj, java.lang.Class cls) {
        if (cls == obj.getClass()) {
            return obj;
        }
        if (cls != java.lang.Byte.TYPE && cls != java.lang.Byte.class) {
            if (cls != java.lang.Integer.TYPE && cls != java.lang.Integer.class) {
                if (cls != java.lang.Boolean.TYPE && cls != java.lang.Boolean.class) {
                    if (cls != java.lang.Short.TYPE && cls != java.lang.Short.class) {
                        if (cls != java.lang.Long.TYPE && cls != java.lang.Long.class) {
                            if (cls != java.lang.Double.TYPE && cls != java.lang.Double.class) {
                                if (cls != java.lang.Float.TYPE && cls != java.lang.Float.class) {
                                    if (cls != java.lang.Character.TYPE && cls != java.lang.Character.class) {
                                        return cls.cast(obj);
                                    }
                                    return java.lang.String.valueOf(obj);
                                }
                                return java.lang.Float.valueOf(java.lang.Float.parseFloat(java.lang.String.valueOf(obj)));
                            }
                            return java.lang.Double.valueOf(java.lang.Double.parseDouble(java.lang.String.valueOf(obj)));
                        }
                        return java.lang.Long.valueOf(java.lang.Long.parseLong(java.lang.String.valueOf(obj)));
                    }
                    return java.lang.Short.valueOf(java.lang.Short.parseShort(java.lang.String.valueOf(obj)));
                }
                return java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(java.lang.String.valueOf(obj)));
            }
            return java.lang.Integer.valueOf(java.lang.Integer.parseInt(java.lang.String.valueOf(obj)));
        }
        return java.lang.Byte.valueOf(java.lang.Byte.parseByte(java.lang.String.valueOf(obj)));
    }

    static java.lang.Class a(java.lang.Class cls) {
        if (cls == java.lang.Integer.class) {
            return java.lang.Integer.TYPE;
        }
        return cls == java.lang.Boolean.class ? java.lang.Boolean.TYPE : cls;
    }

    static java.lang.Object[] a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, java.lang.Object obj) {
        java.lang.Object[] objArr = new java.lang.Object[2];
        if (obj instanceof org.json.JSONArray) {
            org.json.JSONArray jSONArray = (org.json.JSONArray) obj;
            int length = jSONArray.length();
            java.lang.Object objNewInstance = null;
            for (int i = 0; i < length; i++) {
                java.lang.Object[] objArrA = a(iWebview, x2Var, jSONArray.opt(i));
                java.lang.Class<?> cls = objArrA[1].getClass();
                if (i == 0) {
                    objNewInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) a(objArrA[1].getClass()), length);
                }
                if (cls == java.lang.Boolean.class) {
                    java.lang.reflect.Array.setBoolean(objNewInstance, i, ((java.lang.Boolean) objArrA[1]).booleanValue());
                } else if (cls == java.lang.Byte.class) {
                    java.lang.reflect.Array.setByte(objNewInstance, i, ((java.lang.Byte) objArrA[1]).byteValue());
                } else if (cls == java.lang.Double.class) {
                    java.lang.reflect.Array.setDouble(objNewInstance, i, ((java.lang.Double) objArrA[1]).doubleValue());
                } else if (cls == java.lang.Float.class) {
                    java.lang.reflect.Array.setFloat(objNewInstance, i, ((java.lang.Float) objArrA[1]).floatValue());
                } else if (cls == java.lang.Integer.class) {
                    java.lang.reflect.Array.setInt(objNewInstance, i, ((java.lang.Integer) objArrA[1]).intValue());
                } else if (cls == java.lang.Long.class) {
                    java.lang.reflect.Array.setLong(objNewInstance, i, ((java.lang.Long) objArrA[1]).longValue());
                } else {
                    java.lang.reflect.Array.set(objNewInstance, i, objArrA[1]);
                }
            }
            if (objNewInstance != null) {
                objArr[0] = objNewInstance.getClass();
                objArr[1] = objNewInstance;
                return objArr;
            }
        } else if (obj instanceof org.json.JSONObject) {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            java.lang.String strOptString = jSONObject.optString("type");
            java.lang.Object objOpt = jSONObject.opt("value");
            if (strOptString.equals("object")) {
                io.dcloud.p.j3 j3VarA = x2Var.a(iWebview, java.lang.String.valueOf(objOpt));
                objArr[0] = j3VarA.b;
                objArr[1] = j3VarA.c;
                return objArr;
            }
            if (strOptString.equals("string")) {
                objArr[0] = java.lang.String.class;
                objArr[1] = objOpt;
                return objArr;
            }
            if (strOptString.equals("number")) {
                if (objOpt instanceof java.lang.Integer) {
                    objArr[0] = java.lang.Integer.TYPE;
                    objArr[1] = (java.lang.Integer) objOpt;
                    return objArr;
                }
                if (objOpt instanceof java.lang.Double) {
                    objArr[0] = java.lang.Double.class;
                    objArr[1] = (java.lang.Double) objOpt;
                    return objArr;
                }
                if (objOpt instanceof java.lang.Float) {
                    objArr[0] = java.lang.Float.class;
                    objArr[1] = (java.lang.Float) objOpt;
                    return objArr;
                }
                if (objOpt instanceof java.lang.Long) {
                    objArr[0] = java.lang.Long.class;
                    objArr[1] = (java.lang.Long) objOpt;
                    return objArr;
                }
            } else {
                if (strOptString.equals("boolean")) {
                    objArr[0] = java.lang.Boolean.class;
                    objArr[1] = (java.lang.Boolean) objOpt;
                    return objArr;
                }
                if ("JSBObject".equals(jSONObject.optString("__TYPE__"))) {
                    io.dcloud.p.j3 j3VarA2 = x2Var.a(iWebview, jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_UUID));
                    objArr[0] = j3VarA2.b;
                    objArr[1] = j3VarA2.c;
                }
            }
        } else {
            objArr[0] = obj.getClass();
            objArr[1] = obj;
            return objArr;
        }
        return objArr;
    }

    protected static java.lang.Object[] a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.p.x2 x2Var, org.json.JSONArray jSONArray) {
        int length;
        java.lang.Object[] objArr = new java.lang.Object[2];
        if (jSONArray != null) {
            try {
                length = jSONArray.length();
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                return objArr;
            }
        } else {
            length = 0;
        }
        java.lang.Class[] clsArr = new java.lang.Class[length];
        java.lang.Object[] objArr2 = new java.lang.Object[length];
        for (int i = 0; i < length; i++) {
            java.lang.Object[] objArrA = a(iWebview, x2Var, jSONArray.get(i));
            clsArr[i] = (java.lang.Class) objArrA[0];
            objArr2[i] = objArrA[1];
        }
        objArr[0] = clsArr;
        objArr[1] = objArr2;
        return objArr;
    }

    public void a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }
}
