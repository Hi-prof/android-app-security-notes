package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXViewToImageUtil {
    public static int mBackgroundColor;

    public interface OnImageSavedCallback {
        void onSaveFailed(java.lang.String str);

        void onSaveSucceed(java.lang.String str);
    }

    public static void generateImage(final android.view.View view, final int i, int i2, final com.taobao.weex.utils.WXViewToImageUtil.OnImageSavedCallback onImageSavedCallback) {
        mBackgroundColor = i2;
        com.taobao.weex.WXSDKManager.getInstance().getWXWorkThreadManager().post(new java.lang.Thread(new java.lang.Runnable() { // from class: com.taobao.weex.utils.WXViewToImageUtil.1
            @Override // java.lang.Runnable
            public void run() {
                android.graphics.Bitmap bitmapFromImageView = com.taobao.weex.utils.WXViewToImageUtil.getBitmapFromImageView(view, i);
                if (bitmapFromImageView == null) {
                    com.taobao.weex.utils.WXViewToImageUtil.OnImageSavedCallback onImageSavedCallback2 = onImageSavedCallback;
                    if (onImageSavedCallback2 != null) {
                        onImageSavedCallback2.onSaveFailed("Image is empty");
                        return;
                    }
                    return;
                }
                final java.lang.String strSaveBitmapToGallery = com.taobao.weex.utils.WXViewToImageUtil.saveBitmapToGallery(view.getContext(), bitmapFromImageView, onImageSavedCallback);
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.taobao.weex.utils.WXViewToImageUtil.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (onImageSavedCallback != null) {
                            onImageSavedCallback.onSaveSucceed(strSaveBitmapToGallery);
                            view.getContext().sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.parse(strSaveBitmapToGallery)));
                        }
                    }
                });
            }
        }));
    }

    public static java.lang.String saveBitmapToGallery(android.content.Context context, android.graphics.Bitmap bitmap, com.taobao.weex.utils.WXViewToImageUtil.OnImageSavedCallback onImageSavedCallback) {
        java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory(), "Weex");
        if (!file.exists()) {
            file.mkdir();
        }
        java.lang.String str = java.lang.System.currentTimeMillis() + ".jpg";
        java.io.File file2 = new java.io.File(file, str);
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (java.io.FileNotFoundException e) {
            if (onImageSavedCallback != null) {
                onImageSavedCallback.onSaveFailed("Image creation failed due to system reason");
            }
            e.printStackTrace();
        } catch (java.io.IOException e2) {
            if (onImageSavedCallback != null) {
                onImageSavedCallback.onSaveFailed("Android IOException");
            }
            e2.printStackTrace();
        }
        try {
            android.provider.MediaStore.Images.Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, (java.lang.String) null);
        } catch (java.io.FileNotFoundException e3) {
            e3.printStackTrace();
        }
        context.sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.parse(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + file.getAbsolutePath() + "/" + str)));
        return file2.getAbsolutePath();
    }

    public static android.graphics.Bitmap getBitmapFromImageView(android.view.View view, int i) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        view.setDrawingCacheEnabled(true);
        return view.getDrawingCache();
    }
}
