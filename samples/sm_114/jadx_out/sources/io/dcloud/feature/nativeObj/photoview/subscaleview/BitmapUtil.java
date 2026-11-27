package io.dcloud.feature.nativeObj.photoview.subscaleview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BitmapUtil {
    public static android.graphics.Bitmap getRotatedBitmap(android.graphics.Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static android.graphics.Bitmap getRotatedBitmapFromBitmap(android.graphics.Bitmap bitmap) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return getRotatedBitmap(bitmap, new io.dcloud.common.util.ExifInterface(new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray())).getAttributeInt("Orientation", 1));
    }

    public static android.graphics.Bitmap getRotatedBitmapFromFile(java.io.File file) throws java.io.IOException {
        return getRotatedBitmap(android.graphics.BitmapFactory.decodeFile(file.getAbsolutePath()), new io.dcloud.common.util.ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 1));
    }

    public static boolean needRatationWithExif(java.io.File file) {
        try {
            int attributeInt = new io.dcloud.common.util.ExifInterface(file).getAttributeInt("Orientation", 1);
            return (attributeInt == 1 || attributeInt == 0) ? false : true;
        } catch (java.io.IOException unused) {
        }
    }
}
