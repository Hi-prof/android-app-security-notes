package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CompressUtil {
    public static java.lang.String compressImage(java.lang.String str, java.lang.String str2, boolean z, android.content.Context context) {
        android.graphics.Bitmap bitmapDecodeByteArray;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            byte[] bArrInputStream2ByteArr = inputStream2ByteArr(str, context);
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeByteArray(bArrInputStream2ByteArr, 0, bArrInputStream2ByteArr.length, options);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
            android.graphics.Bitmap.CompressFormat compressFormat = z ? android.graphics.Bitmap.CompressFormat.PNG : android.graphics.Bitmap.CompressFormat.JPEG;
            int i = options.outWidth;
            if (i >= 1080 || options.outHeight >= 1080) {
                int i2 = options.outHeight;
                if (i2 < 1080 || i < 1080) {
                    float f = i / (i2 * 1.0f);
                    if (f > 2.0f || f < 0.5d) {
                        bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArrInputStream2ByteArr, 0, bArrInputStream2ByteArr.length, options);
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        bitmapDecodeByteArray.compress(compressFormat, 73, byteArrayOutputStream);
                    } else {
                        android.graphics.Matrix matrix = new android.graphics.Matrix();
                        int i3 = options.outWidth;
                        int i4 = options.outHeight;
                        float f2 = 1080.0f / (i3 > i4 ? i3 : i4);
                        matrix.setScale(f2, f2);
                        android.graphics.Bitmap bitmapDecodeByteArray2 = android.graphics.BitmapFactory.decodeByteArray(bArrInputStream2ByteArr, 0, bArrInputStream2ByteArr.length, options);
                        bitmapDecodeByteArray = android.graphics.Bitmap.createBitmap(bitmapDecodeByteArray2, 0, 0, bitmapDecodeByteArray2.getWidth(), bitmapDecodeByteArray2.getHeight(), matrix, true);
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        bitmapDecodeByteArray.compress(compressFormat, 75, byteArrayOutputStream);
                    }
                } else {
                    android.graphics.Matrix matrix2 = new android.graphics.Matrix();
                    int i5 = options.outWidth;
                    int i6 = options.outHeight;
                    float f3 = 1080.0f / (i5 > i6 ? i6 : i5);
                    matrix2.setScale(f3, f3);
                    android.graphics.Bitmap bitmapDecodeByteArray3 = android.graphics.BitmapFactory.decodeByteArray(bArrInputStream2ByteArr, 0, bArrInputStream2ByteArr.length, options);
                    bitmapDecodeByteArray = android.graphics.Bitmap.createBitmap(bitmapDecodeByteArray3, 0, 0, bitmapDecodeByteArray3.getWidth(), bitmapDecodeByteArray3.getHeight(), matrix2, true);
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    bitmapDecodeByteArray.compress(compressFormat, 70, byteArrayOutputStream);
                }
            } else {
                bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArrInputStream2ByteArr, 0, bArrInputStream2ByteArr.length, options);
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                bitmapDecodeByteArray.compress(compressFormat, 75, byteArrayOutputStream);
            }
            try {
                try {
                    try {
                        java.io.File file = new java.io.File(str2);
                        java.io.File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Exception unused) {
                            }
                            return "";
                        }
                        if (!file.exists() && !file.createNewFile()) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Exception unused2) {
                            }
                            return "";
                        }
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        fileOutputStream.close();
                        try {
                            io.dcloud.common.util.ExifInterface exifInterface = new io.dcloud.common.util.ExifInterface(new java.io.ByteArrayInputStream(bArrInputStream2ByteArr));
                            io.dcloud.common.util.ExifInterface exifInterface2 = new io.dcloud.common.util.ExifInterface(file);
                            exifInterface2.setAttribute("Orientation", exifInterface.getAttribute("Orientation"));
                            exifInterface2.saveAttributes();
                        } catch (java.lang.Exception unused3) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.lang.Exception unused4) {
                        }
                        bitmapDecodeByteArray.recycle();
                        return str2;
                    } catch (java.lang.Exception unused5) {
                    }
                } catch (java.lang.Exception unused6) {
                    byteArrayOutputStream.close();
                    return "";
                }
            } catch (java.lang.Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception unused7) {
                }
                throw th;
            }
            return "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] inputStream2ByteArr(java.lang.String str, android.content.Context context) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            java.io.InputStream fileInputStream = io.dcloud.common.util.FileUtil.checkPrivatePath(context, str) ? new java.io.FileInputStream(file) : io.dcloud.common.util.FileUtil.getImageFileStream(context, file);
            if (fileInputStream == null) {
                fileInputStream = new java.io.FileInputStream(file);
            }
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
