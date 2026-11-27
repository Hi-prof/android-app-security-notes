package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeBitmap implements io.dcloud.common.DHInterface.INativeBitmap {
    private static final int ERROR = 40;
    private static final int SUCCESS = 10;
    private io.dcloud.common.DHInterface.IApp mApp;
    private android.graphics.Bitmap mBitmap;
    private java.lang.String mExt;
    private pl.droidsonroids.gif.GifDrawable mGifDrawable;
    private java.lang.String mId;
    private java.lang.String mPath;
    private java.lang.String mUUid;
    private boolean isNetWorkBitmapDownload = false;
    private io.dcloud.common.DHInterface.ICallBack mSucCallBackLoad = null;
    private io.dcloud.common.DHInterface.ICallBack mErrCallBackLoad = null;
    private android.os.Handler mHandler = new android.os.Handler() { // from class: io.dcloud.feature.nativeObj.NativeBitmap.3
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i != 10) {
                if (i == 40 && io.dcloud.feature.nativeObj.NativeBitmap.this.mErrCallBackLoad != null) {
                    io.dcloud.feature.nativeObj.NativeBitmap.this.mErrCallBackLoad.onCallBack(0, message.obj);
                }
            } else if (io.dcloud.feature.nativeObj.NativeBitmap.this.mSucCallBackLoad != null) {
                io.dcloud.feature.nativeObj.NativeBitmap.this.mSucCallBackLoad.onCallBack(0, message.obj);
            }
            super.handleMessage(message);
        }
    };

    public NativeBitmap(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mExt = "jpg";
        this.mId = str;
        this.mUUid = str2;
        this.mPath = str3;
        io.dcloud.common.util.ImageLoaderUtil.addNetIconDownloadUrl(str3);
        this.mExt = getExt(str3);
        this.mApp = iApp;
    }

    private java.lang.String bitmap2String(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(getCF(), 100, byteArrayOutputStream);
        return android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private android.graphics.Bitmap.CompressFormat getCF() {
        return "png".equals(this.mExt) ? android.graphics.Bitmap.CompressFormat.PNG : android.graphics.Bitmap.CompressFormat.JPEG;
    }

    private java.lang.String getExt(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isNetPath(str)) {
            if (str.contains(".jpg")) {
                return "jpg";
            }
            if (str.contains(".png")) {
                return "png";
            }
            if (str.contains(".gif")) {
                return "gif";
            }
            if (str.contains(".webp")) {
                return "webp";
            }
        }
        return android.text.TextUtils.isEmpty(str) ? str : str.substring(str.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR) + 1, str.length()).toLowerCase(java.util.Locale.ENGLISH);
    }

    private void getExtFromBase64(java.lang.String str) {
        if (str.indexOf(",") != -1) {
            this.mExt = str.split(",")[0].replace("data:image/", "").replace(";base64", "");
        }
    }

    private java.lang.String getFilePath(java.lang.String str) {
        android.net.Uri fileUri;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(str) || !io.dcloud.common.util.PdrUtil.isNetPath(str)) {
            if (this.mApp != null) {
                java.io.File file = new java.io.File(str);
                if (file.exists() || str.startsWith("/storage")) {
                    android.content.Context context = io.dcloud.application.DCLoudApplicationImpl.self().getContext();
                    if (io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(context) && !io.dcloud.common.util.FileUtil.checkPrivatePath(context, this.mPath) && (fileUri = io.dcloud.common.util.FileUtil.getFileUri(context, file, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) != null) {
                        return fileUri.toString();
                    }
                } else if (this.mApp.obtainRunningAppMode() == 1) {
                    if (str.startsWith("/")) {
                        str = str.substring(1, str.length());
                    }
                    return com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.ASSETS.wrap(str);
                }
            }
            if (!str.contains(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + str;
            }
        }
        return str;
    }

    private com.nostra13.dcloudimageloader.core.DisplayImageOptions getImageOptions() {
        return new com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder().cacheInMemory(true).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).imageScaleType(com.nostra13.dcloudimageloader.core.assist.ImageScaleType.NONE).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveFile(java.lang.String str, android.graphics.Bitmap bitmap, io.dcloud.feature.nativeObj.NativeBitmapSaveOptions nativeBitmapSaveOptions) throws java.lang.Exception {
        if (bitmap == null || bitmap.getHeight() == 0 || bitmap.getWidth() == 0) {
            return;
        }
        java.io.File file = new java.io.File(str.substring(0, str.lastIndexOf("/")));
        if (!file.exists()) {
            file.mkdirs();
        }
        java.io.File file2 = new java.io.File(str);
        if (!file2.exists()) {
            file2.createNewFile();
        }
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file2));
        bitmap.compress("png".equals(getExt(str)) ? android.graphics.Bitmap.CompressFormat.PNG : android.graphics.Bitmap.CompressFormat.JPEG, nativeBitmapSaveOptions.mQuality, bufferedOutputStream);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        nativeBitmapSaveOptions.path = file2.getAbsolutePath();
        nativeBitmapSaveOptions.width = bitmap.getWidth();
        nativeBitmapSaveOptions.height = bitmap.getHeight();
        nativeBitmapSaveOptions.size = file2.length();
    }

    private android.graphics.Bitmap string2Bitmap(java.lang.String str) {
        if (str.indexOf(",") != -1) {
            str = str.substring(str.indexOf(","));
        }
        byte[] bArrDecode = android.util.Base64.decode(str, 2);
        return android.graphics.BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    @Override // io.dcloud.common.DHInterface.INativeBitmap
    @android.webkit.JavascriptInterface
    public void clear() {
        recycle();
        this.mBitmap = null;
        this.mGifDrawable = null;
    }

    @Override // io.dcloud.common.DHInterface.INativeBitmap
    public android.graphics.Bitmap getBitmap() {
        if (isRecycled()) {
            java.lang.String filePath = getFilePath(this.mPath);
            if (android.text.TextUtils.isEmpty(filePath)) {
                return null;
            }
            if (io.dcloud.common.util.PdrUtil.isNetPath(filePath) && !this.isNetWorkBitmapDownload) {
                return null;
            }
            this.mBitmap = com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().loadImageSync(filePath, getImageOptions());
        }
        return this.mBitmap;
    }

    public pl.droidsonroids.gif.GifDrawable getGifDrawable() {
        pl.droidsonroids.gif.GifDrawable gifDrawable = this.mGifDrawable;
        if ((gifDrawable == null || (gifDrawable != null && gifDrawable.isRecycled())) && !io.dcloud.common.util.PdrUtil.isEmpty(this.mPath) && this.mApp != null) {
            if (!io.dcloud.common.util.PdrUtil.isNetPath(this.mPath)) {
                java.io.File file = new java.io.File(this.mPath);
                if (this.mApp.obtainRunningAppMode() == 1 && !file.exists()) {
                    java.lang.String strSubstring = this.mPath;
                    if (strSubstring.startsWith("/")) {
                        java.lang.String str = this.mPath;
                        strSubstring = str.substring(1, str.length());
                    }
                    try {
                        this.mGifDrawable = new pl.droidsonroids.gif.GifDrawable(this.mApp.getActivity().getAssets(), strSubstring);
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                } else if (file.exists()) {
                    try {
                        this.mGifDrawable = new pl.droidsonroids.gif.GifDrawable(file);
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                if (!this.isNetWorkBitmapDownload) {
                    return null;
                }
                java.io.File file2 = com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().getDiscCache().get(this.mPath);
                if (file2.exists()) {
                    try {
                        this.mGifDrawable = new pl.droidsonroids.gif.GifDrawable(file2);
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        return this.mGifDrawable;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getId() {
        return this.mId;
    }

    public android.graphics.Bitmap initNetworkBitmap(com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        if (isRecycled()) {
            this.isNetWorkBitmapDownload = false;
            java.lang.String filePath = getFilePath(this.mPath);
            if (android.text.TextUtils.isEmpty(filePath)) {
                return null;
            }
            com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().loadImage(filePath, imageLoadingListener);
        }
        return this.mBitmap;
    }

    public boolean isGif() {
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mExt)) {
            return false;
        }
        return this.mExt.equalsIgnoreCase("gif");
    }

    public boolean isNetWorkBitmap() {
        if (android.text.TextUtils.isEmpty(this.mPath) || !io.dcloud.common.util.PdrUtil.isNetPath(this.mPath)) {
            return false;
        }
        return (this.isNetWorkBitmapDownload && com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().getDiscCache().get(this.mPath).exists()) ? false : true;
    }

    public boolean isRecycled() {
        android.graphics.Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.isRecycled();
        }
        pl.droidsonroids.gif.GifDrawable gifDrawable = this.mGifDrawable;
        if (gifDrawable != null) {
            return gifDrawable.isRecycled();
        }
        return true;
    }

    @android.webkit.JavascriptInterface
    public void load(io.dcloud.common.DHInterface.IWebview iWebview, android.content.Context context, java.lang.String str, final io.dcloud.common.DHInterface.ICallBack iCallBack, final io.dcloud.common.DHInterface.ICallBack iCallBack2) {
        this.isNetWorkBitmapDownload = false;
        if (android.text.TextUtils.isEmpty(str)) {
            this.mErrCallBackLoad = iCallBack2;
            android.os.Message messageObtainMessage = this.mHandler.obtainMessage();
            messageObtainMessage.what = 40;
            messageObtainMessage.obj = context.getString(io.dcloud.base.R.string.dcloud_native_obj_path_cannot_empty);
            this.mHandler.sendMessage(messageObtainMessage);
            return;
        }
        java.util.Locale locale = java.util.Locale.ENGLISH;
        if (str.toLowerCase(locale).startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || str.toLowerCase(locale).startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) || str.toLowerCase(locale).startsWith("ftp://")) {
            this.mErrCallBackLoad = iCallBack2;
            android.os.Message messageObtainMessage2 = this.mHandler.obtainMessage();
            messageObtainMessage2.what = 40;
            messageObtainMessage2.obj = context.getString(io.dcloud.base.R.string.dcloud_native_obj_path_not_network);
            this.mHandler.sendMessage(messageObtainMessage2);
            return;
        }
        str.toLowerCase(locale).startsWith("_");
        this.mPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), str);
        if (io.dcloud.common.util.FileUtil.checkPathAccord(iWebview.getContext(), this.mPath) || io.dcloud.common.util.FileUtil.isFilePathForPublic(context, this.mPath)) {
            this.mExt = getExt(str);
            com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().loadImage(getFilePath(this.mPath), getImageOptions(), new com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener() { // from class: io.dcloud.feature.nativeObj.NativeBitmap.1
                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingCancelled(java.lang.String str2, android.view.View view) {
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingComplete(java.lang.String str2, android.view.View view, android.graphics.Bitmap bitmap) {
                    io.dcloud.feature.nativeObj.NativeBitmap.this.mBitmap = bitmap;
                    io.dcloud.feature.nativeObj.NativeBitmap.this.mSucCallBackLoad = iCallBack;
                    io.dcloud.feature.nativeObj.NativeBitmap.this.mHandler.sendEmptyMessage(10);
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingFailed(java.lang.String str2, android.view.View view, com.nostra13.dcloudimageloader.core.assist.FailReason failReason) {
                    io.dcloud.feature.nativeObj.NativeBitmap.this.mErrCallBackLoad = iCallBack2;
                    io.dcloud.feature.nativeObj.NativeBitmap.this.mHandler.sendEmptyMessage(40);
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingStarted(java.lang.String str2, android.view.View view) {
                }
            });
            return;
        }
        this.mErrCallBackLoad = iCallBack2;
        android.os.Message messageObtainMessage3 = this.mHandler.obtainMessage();
        messageObtainMessage3.what = 40;
        messageObtainMessage3.obj = io.dcloud.common.constant.DOMException.MSG_PATH_NOT_PRIVATE_ERROR;
        this.mHandler.sendMessage(messageObtainMessage3);
    }

    @android.webkit.JavascriptInterface
    public void loadBase64Data(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack, io.dcloud.common.DHInterface.ICallBack iCallBack2) {
        try {
            android.graphics.Bitmap bitmapString2Bitmap = string2Bitmap(str);
            this.mBitmap = bitmapString2Bitmap;
            if (bitmapString2Bitmap == null) {
                this.mErrCallBackLoad = iCallBack2;
                this.mHandler.sendEmptyMessage(40);
            } else {
                getExtFromBase64(str);
                this.mSucCallBackLoad = iCallBack;
                this.mHandler.sendEmptyMessage(10);
            }
        } catch (java.lang.Exception unused) {
            this.mErrCallBackLoad = iCallBack2;
            this.mHandler.sendEmptyMessage(40);
        }
    }

    public void recycle() {
        recycle(false);
    }

    @android.webkit.JavascriptInterface
    public void save(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, final io.dcloud.feature.nativeObj.NativeBitmapSaveOptions nativeBitmapSaveOptions, final float f, final io.dcloud.common.DHInterface.ICallBack iCallBack, final io.dcloud.common.DHInterface.ICallBack iCallBack2) {
        if (android.text.TextUtils.isEmpty(str)) {
            this.mErrCallBackLoad = iCallBack2;
            android.os.Message messageObtainMessage = this.mHandler.obtainMessage();
            messageObtainMessage.what = 40;
            messageObtainMessage.obj = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_native_obj_path_cannot_empty);
            this.mHandler.sendMessage(messageObtainMessage);
            return;
        }
        java.util.Locale locale = java.util.Locale.ENGLISH;
        if (!str.toLowerCase(locale).startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) && !str.toLowerCase(locale).startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) && !str.toLowerCase(locale).startsWith("ftp://")) {
            final java.lang.String str2 = this.mPath;
            this.mPath = str;
            new java.lang.Thread() { // from class: io.dcloud.feature.nativeObj.NativeBitmap.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        io.dcloud.feature.nativeObj.NativeBitmap.this.getBitmap();
                        if (nativeBitmapSaveOptions.mClip != null) {
                            int width = io.dcloud.feature.nativeObj.NativeBitmap.this.mBitmap.getWidth();
                            int height = io.dcloud.feature.nativeObj.NativeBitmap.this.mBitmap.getHeight();
                            int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(nativeBitmapSaveOptions.mClip.optString("left"), width, 0, f);
                            int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(nativeBitmapSaveOptions.mClip.optString("top"), height, 0, f);
                            int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(nativeBitmapSaveOptions.mClip.optString("width"), width, width, f);
                            int iConvertToScreenInt4 = io.dcloud.common.util.PdrUtil.convertToScreenInt(nativeBitmapSaveOptions.mClip.optString("height"), height, height, f);
                            if (iConvertToScreenInt + iConvertToScreenInt3 > width) {
                                iConvertToScreenInt3 = width - iConvertToScreenInt;
                            }
                            if (iConvertToScreenInt2 + iConvertToScreenInt4 > height) {
                                iConvertToScreenInt4 = height - iConvertToScreenInt2;
                            }
                            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(io.dcloud.feature.nativeObj.NativeBitmap.this.mBitmap, iConvertToScreenInt, iConvertToScreenInt2, iConvertToScreenInt3, iConvertToScreenInt4);
                            io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap = io.dcloud.feature.nativeObj.NativeBitmap.this;
                            nativeBitmap.saveFile(nativeBitmap.mPath, bitmapCreateBitmap, nativeBitmapSaveOptions);
                            bitmapCreateBitmap.recycle();
                            io.dcloud.feature.nativeObj.NativeBitmap.this.mPath = str2;
                        } else {
                            io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap2 = io.dcloud.feature.nativeObj.NativeBitmap.this;
                            nativeBitmap2.saveFile(nativeBitmap2.mPath, io.dcloud.feature.nativeObj.NativeBitmap.this.mBitmap, nativeBitmapSaveOptions);
                        }
                        io.dcloud.feature.nativeObj.NativeBitmap.this.mSucCallBackLoad = iCallBack;
                        android.os.Message messageObtainMessage2 = io.dcloud.feature.nativeObj.NativeBitmap.this.mHandler.obtainMessage();
                        messageObtainMessage2.what = 10;
                        messageObtainMessage2.obj = nativeBitmapSaveOptions;
                        io.dcloud.feature.nativeObj.NativeBitmap.this.mHandler.sendMessage(messageObtainMessage2);
                    } catch (java.lang.Exception e) {
                        io.dcloud.feature.nativeObj.NativeBitmap.this.mErrCallBackLoad = iCallBack2;
                        io.dcloud.feature.nativeObj.NativeBitmap.this.mHandler.sendEmptyMessage(40);
                        io.dcloud.common.adapter.util.Logger.e("mabo", "saveFile: " + e.toString());
                    }
                }
            }.start();
        } else {
            this.mErrCallBackLoad = iCallBack2;
            android.os.Message messageObtainMessage2 = this.mHandler.obtainMessage();
            messageObtainMessage2.what = 40;
            messageObtainMessage2.obj = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_native_obj_path_not_network);
            this.mHandler.sendMessage(messageObtainMessage2);
        }
    }

    @Override // io.dcloud.common.DHInterface.INativeBitmap
    public void setBitmap(android.graphics.Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setNetWorkBitmapDownload(boolean z) {
        this.isNetWorkBitmapDownload = z;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String toBase64Data() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("data:image/");
        sb.append("jpg".equals(this.mExt) ? "jepg" : this.mExt);
        sb.append(";base64,");
        sb.append(bitmap2String(this.mBitmap));
        return sb.toString();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String toJsString() {
        return "{\"id\":\"" + this.mId + "\",\"__id__\":\"" + this.mUUid + "\"}";
    }

    public void recycle(boolean z) {
        if (z && android.text.TextUtils.isEmpty(this.mPath)) {
            return;
        }
        android.graphics.Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
            java.lang.String filePath = getFilePath(this.mPath);
            if (!android.text.TextUtils.isEmpty(filePath)) {
                com.nostra13.dcloudimageloader.core.assist.MemoryCacheUtil.removeFromCache(filePath, com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().getMemoryCache());
            }
        }
        pl.droidsonroids.gif.GifDrawable gifDrawable = this.mGifDrawable;
        if (gifDrawable == null || gifDrawable.isRecycled()) {
            return;
        }
        this.mGifDrawable.recycle();
    }
}
