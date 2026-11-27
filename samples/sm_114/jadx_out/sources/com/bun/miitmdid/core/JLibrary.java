package com.bun.miitmdid.core;

/* JADX INFO: loaded from: classes.dex */
public class JLibrary {
    public static java.lang.String ASSET = "assets/";
    public static java.lang.String SeriailizationString = "stub_liu_0_dex_so:39285EFA@com/jdog;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;";
    public static final java.lang.String TAG = "JLibrary";
    public static java.lang.ClassLoader classLoader = null;
    public static android.content.Context context = null;
    public static java.lang.String o00o0a0odod = null;
    public static java.lang.String o00o0a0odou = null;
    public static java.lang.String xdata = ".00000000000";
    public static java.lang.String ydata = ".11111111111";

    enum ReturnStatus {
        RETURN_OK,
        RETURN_ERR;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static com.bun.miitmdid.core.JLibrary.ReturnStatus[] valuesCustom() {
            com.bun.miitmdid.core.JLibrary.ReturnStatus[] returnStatusArrValuesCustom = values();
            int length = returnStatusArrValuesCustom.length;
            com.bun.miitmdid.core.JLibrary.ReturnStatus[] returnStatusArr = new com.bun.miitmdid.core.JLibrary.ReturnStatus[length];
            java.lang.System.arraycopy(returnStatusArrValuesCustom, 0, returnStatusArr, 0, length);
            return returnStatusArr;
        }
    }

    public static com.bun.miitmdid.core.JLibrary.ReturnStatus InitEntry(android.content.Context context2) throws java.lang.Exception {
        if (context2 == null) {
            throw new java.lang.ExceptionInInitializerError("pass InitEntry arg(context) is null");
        }
        context = context2;
        classLoader = com.bun.miitmdid.core.JLibrary.class.getClassLoader();
        java.lang.String str = SeriailizationString;
        java.lang.System.loadLibrary(str.substring(str.lastIndexOf(58) + 1, SeriailizationString.indexOf(64)));
        a();
        return com.bun.miitmdid.core.JLibrary.ReturnStatus.RETURN_OK;
    }

    public static java.nio.ByteBuffer ReadByteBuffer(java.lang.String str) {
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(fileInputStream.available());
            for (int i = 0; i < fileInputStream.available(); i += fileInputStream.read(byteBufferAllocate.array(), i, fileInputStream.available() - i)) {
            }
            fileInputStream.close();
            return byteBufferAllocate;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static native boolean a();

    public static java.lang.Object[] o0o0o0o0o0(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.util.List<java.io.IOException> list) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.String[] strArrSplit = str.split(";");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str3 : strArrSplit) {
            arrayList.add(ReadByteBuffer(str3));
        }
        return (java.lang.Object[]) o0o0o0o0o0o0(obj, str2, java.nio.ByteBuffer[].class, java.util.List.class).invoke(obj, arrayList.toArray(new java.nio.ByteBuffer[arrayList.size()]), list);
    }

    private static java.lang.reflect.Method o0o0o0o0o0o0(java.lang.Object obj, java.lang.String str, java.lang.Class<?>... clsArr) throws java.lang.NoSuchMethodException {
        for (java.lang.Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                java.lang.reflect.Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (java.lang.NoSuchMethodException unused) {
            }
        }
        throw new java.lang.NoSuchMethodException("Method " + str + " with parameters " + java.util.Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static void o0oo0o0(android.content.Context context2, java.lang.String str) throws java.lang.Exception {
        int i;
        int i2;
        try {
            java.io.InputStream inputStreamOpen = context2.getAssets().open(str);
            o00o0a0odod = com.bun.miitmdid.core.Utils.getXdataDir(context2, "");
            o00o0a0odou = com.bun.miitmdid.core.Utils.getYdataDir(context2, "");
            java.io.File file = new java.io.File(o00o0a0odod);
            java.io.File file2 = new java.io.File(o00o0a0odou);
            int i3 = 3;
            if (!file.exists()) {
                int i4 = 3;
                while (true) {
                    i = i4 - 1;
                    if (i4 <= 0 || file.mkdir()) {
                        break;
                        break;
                    }
                    i4 = i;
                }
            } else {
                i = 3;
            }
            if (i == -1) {
                throw new java.lang.IllegalStateException("User dir cannot be created: " + file.getAbsolutePath());
            }
            if (!file2.exists()) {
                while (true) {
                    i2 = i3 - 1;
                    if (i3 <= 0 || file2.mkdir()) {
                        break;
                        break;
                    }
                    i3 = i2;
                }
                i3 = i2;
            }
            if (i3 == -1) {
                throw new java.lang.IllegalStateException("User dir cannot be created: " + file2.getAbsolutePath());
            }
            if (!com.bun.miitmdid.core.Utils.update(context2)) {
                if (new java.io.File(java.lang.String.valueOf(o00o0a0odod) + str).exists()) {
                    return;
                }
            }
            com.bun.miitmdid.core.Utils.x0xooXdata(inputStreamOpen, java.lang.String.valueOf(o00o0a0odod) + str, context2);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
