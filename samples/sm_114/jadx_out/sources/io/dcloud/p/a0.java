package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 {
    private static int a(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int iA = a(i);
        if (iA <= 0) {
            return bitmap;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(iA);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static android.graphics.Bitmap a(java.io.File file, android.graphics.BitmapFactory.Options options) {
        try {
            int i = java.lang.Integer.parseInt(new io.dcloud.common.util.ExifInterface(file).getAttribute("Orientation"));
            byte[] bArrA = a(file);
            if (i > 1) {
                return a(android.graphics.BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options), i);
            }
            return android.graphics.BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static android.graphics.Bitmap a(java.io.InputStream inputStream, android.graphics.BitmapFactory.Options options) {
        try {
            byte[] bArrA = a(inputStream);
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArrA);
            io.dcloud.common.util.ExifInterface exifInterface = new io.dcloud.common.util.ExifInterface(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (java.lang.Exception unused) {
            }
            int i = java.lang.Integer.parseInt(exifInterface.getAttribute("Orientation"));
            if (i > 1) {
                return a(android.graphics.BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length), i);
            }
            return android.graphics.BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options);
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public static byte[] a(java.io.InputStream inputStream) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[10240];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static byte[] a(java.io.File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            return a(new java.io.FileInputStream(file));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
