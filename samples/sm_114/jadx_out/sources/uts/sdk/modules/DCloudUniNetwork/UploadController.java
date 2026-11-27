package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/UploadController;", "", "<init>", "()V", "uploadExecutorService", "Ljava/util/concurrent/ExecutorService;", "uploadFile", "Luts/sdk/modules/DCloudUniNetwork/UploadTask;", "options", "Luts/sdk/modules/DCloudUniNetwork/UploadFileOptions;", "listener", "Luts/sdk/modules/DCloudUniNetwork/NetworkUploadFileListener;", "createUploadClient", "Lokhttp3/OkHttpClient;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "createUploadRequest", "Lokhttp3/Request;", "getFileInformation", "Luts/sdk/modules/DCloudUniNetwork/FileInformation;", "reassignedUri", "", "copyAssetFileToPrivateDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "fileName", "checkPrivatePath", "", "reassignedPath", "isDescendant", "parent", "child", "isAssetFile", "filePath", "getMimeType", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME, "Companion", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UploadController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniNetwork.UploadController.Companion INSTANCE = new uts.sdk.modules.DCloudUniNetwork.UploadController.Companion(null);
    private static uts.sdk.modules.DCloudUniNetwork.UploadController instance;
    private java.util.concurrent.ExecutorService uploadExecutorService;

    public uts.sdk.modules.DCloudUniNetwork.UploadTask uploadFile(uts.sdk.modules.DCloudUniNetwork.UploadFileOptions options, uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener listener) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        okhttp3.OkHttpClient okHttpClientCreateUploadClient = createUploadClient(options);
        okhttp3.Request requestCreateUploadRequest = createUploadRequest(options, listener);
        if (requestCreateUploadRequest == null) {
            return new uts.sdk.modules.DCloudUniNetwork.NetworkUploadTaskImpl(null, listener);
        }
        okhttp3.Call callNewCall = okHttpClientCreateUploadClient.newCall(requestCreateUploadRequest);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(callNewCall, "newCall(...)");
        callNewCall.enqueue(new uts.sdk.modules.DCloudUniNetwork.SimpleUploadCallback(listener));
        return new uts.sdk.modules.DCloudUniNetwork.NetworkUploadTaskImpl(callNewCall, listener);
    }

    private final okhttp3.OkHttpClient createUploadClient(uts.sdk.modules.DCloudUniNetwork.UploadFileOptions option) {
        long jLongValue;
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        if (option.getTimeout() != null) {
            java.lang.Number timeout = option.getTimeout();
            kotlin.jvm.internal.Intrinsics.checkNotNull(timeout);
            jLongValue = timeout.longValue();
        } else {
            jLongValue = 120000;
        }
        builder.connectTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.readTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.writeTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.addInterceptor(new uts.sdk.modules.DCloudUniNetwork.CookieInterceptor());
        if (this.uploadExecutorService == null) {
            this.uploadExecutorService = java.util.concurrent.Executors.newFixedThreadPool(10);
        }
        builder.dispatcher(new okhttp3.Dispatcher(this.uploadExecutorService));
        okhttp3.OkHttpClient okHttpClientBuild = builder.build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "build(...)");
        return okHttpClientBuild;
    }

    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:79:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:82:0x0211  */
    /* JADX WARN: Code duplicated, block: B:88:0x022d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0249  */
    /* JADX WARN: Code duplicated, block: B:91:0x024e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0253  */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01c3, code lost:
    
        if (io.dcloud.uts.NumberKt.numberEquals(r21.getLength(), 0) != false) goto L68;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:88:0x022d, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final okhttp3.Request createUploadRequest(uts.sdk.modules.DCloudUniNetwork.UploadFileOptions r29, uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener r30) throws java.lang.IllegalAccessException {
        /*
            Method dump skipped, instruction units count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uts.sdk.modules.DCloudUniNetwork.UploadController.createUploadRequest(uts.sdk.modules.DCloudUniNetwork.UploadFileOptions, uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener):okhttp3.Request");
    }

    private final uts.sdk.modules.DCloudUniNetwork.FileInformation getFileInformation(java.lang.String reassignedUri) {
        java.lang.String strConvert2AbsFullPath;
        if (kotlin.text.StringsKt.startsWith$default(reassignedUri, "content://", false, 2, (java.lang.Object) null)) {
            android.net.Uri uri = android.net.Uri.parse(reassignedUri);
            android.content.Context appContext = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
            kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
            android.database.Cursor cursorQuery = appContext.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.moveToFirst();
            uts.sdk.modules.DCloudUniNetwork.FileInformation fileInformation = new uts.sdk.modules.DCloudUniNetwork.FileInformation();
            fileInformation.setInputStream(appContext.getContentResolver().openInputStream(uri));
            fileInformation.setSize(cursorQuery.getInt(cursorQuery.getColumnIndex("_size")));
            fileInformation.setName(cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")));
            fileInformation.setMime(cursorQuery.getString(cursorQuery.getColumnIndex("mime_type")));
            cursorQuery.close();
            return fileInformation;
        }
        if (kotlin.text.StringsKt.startsWith$default(reassignedUri, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, false, 2, (java.lang.Object) null)) {
            strConvert2AbsFullPath = io.dcloud.uts.StringKt.substring$default(reassignedUri, (java.lang.Number) 7, null, 2, null);
        } else if (kotlin.text.StringsKt.startsWith$default(reassignedUri, "unifile://", false, 2, (java.lang.Object) null)) {
            strConvert2AbsFullPath = io.dcloud.uts.UTSAndroid.INSTANCE.convert2AbsFullPath(reassignedUri);
        } else {
            strConvert2AbsFullPath = io.dcloud.uts.UTSAndroid.INSTANCE.convert2AbsFullPath(reassignedUri);
            if (kotlin.text.StringsKt.startsWith$default(strConvert2AbsFullPath, "/android_asset/", false, 2, (java.lang.Object) null)) {
                java.lang.String strReplace = io.dcloud.uts.StringKt.replace(strConvert2AbsFullPath, "/android_asset/", "");
                android.content.Context appContext2 = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
                kotlin.jvm.internal.Intrinsics.checkNotNull(appContext2);
                kotlin.jvm.internal.Intrinsics.checkNotNull(appContext2);
                java.io.File fileCopyAssetFileToPrivateDir = copyAssetFileToPrivateDir(appContext2, strReplace);
                if (fileCopyAssetFileToPrivateDir != null) {
                    strConvert2AbsFullPath = fileCopyAssetFileToPrivateDir.getPath();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strConvert2AbsFullPath, "getPath(...)");
                }
            }
        }
        java.io.File file = new java.io.File(strConvert2AbsFullPath);
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        long length = file.length();
        java.lang.String name = file.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNull(name);
        java.lang.String mimeType = getMimeType(name);
        uts.sdk.modules.DCloudUniNetwork.FileInformation fileInformation2 = new uts.sdk.modules.DCloudUniNetwork.FileInformation();
        fileInformation2.setInputStream(fileInputStream);
        fileInformation2.setSize(length);
        fileInformation2.setName(name);
        fileInformation2.setMime(mimeType);
        return fileInformation2;
    }

    private final java.io.File copyAssetFileToPrivateDir(android.content.Context context, java.lang.String fileName) {
        try {
            java.io.File file = new java.io.File(context.getCacheDir().getPath() + "/uploadFiles/" + fileName);
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            java.io.InputStream inputStreamOpen = context.getAssets().open(fileName);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return file;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final boolean checkPrivatePath(java.lang.String reassignedPath) {
        java.io.File parentFile;
        if (android.os.Build.VERSION.SDK_INT > 29 && android.os.Environment.isExternalStorageManager()) {
            return true;
        }
        if (kotlin.text.StringsKt.startsWith$default(reassignedPath, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, false, 2, (java.lang.Object) null)) {
            reassignedPath = io.dcloud.uts.StringKt.replace(reassignedPath, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "");
        }
        if (isAssetFile(reassignedPath) || android.os.Build.VERSION.SDK_INT < 29) {
            return true;
        }
        android.content.Context appContext = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
        kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
        java.io.File externalCacheDir = appContext.getExternalCacheDir();
        if (externalCacheDir == null) {
            parentFile = new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + appContext.getPackageName());
        } else {
            parentFile = externalCacheDir.getParentFile();
        }
        if (!kotlin.text.StringsKt.startsWith$default(reassignedPath, "/", false, 2, (java.lang.Object) null)) {
            reassignedPath = "/" + reassignedPath;
        }
        java.io.File file = new java.io.File(reassignedPath);
        java.io.File parentFile2 = appContext.getFilesDir().getParentFile();
        if (parentFile2 == null || !isDescendant(parentFile2, file)) {
            return parentFile != null && isDescendant(parentFile, file);
        }
        return true;
    }

    private final boolean isDescendant(java.io.File parent, java.io.File child) {
        if (kotlin.jvm.internal.Intrinsics.areEqual(child.getCanonicalPath(), parent.getCanonicalPath())) {
            return true;
        }
        java.io.File parentFile = child.getParentFile();
        if (parentFile == null) {
            return false;
        }
        return isDescendant(parent, parentFile);
    }

    private final boolean isAssetFile(java.lang.String filePath) {
        return kotlin.text.StringsKt.startsWith$default(filePath, "apps/", false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.startsWith$default(filePath, "/android_asset/", false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.startsWith$default(filePath, "android_asset/", false, 2, (java.lang.Object) null);
    }

    private final java.lang.String getMimeType(java.lang.String filename) {
        android.webkit.MimeTypeMap singleton = android.webkit.MimeTypeMap.getSingleton();
        java.lang.String fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(filename);
        if (android.text.TextUtils.isEmpty(fileExtensionFromUrl) && io.dcloud.uts.NumberKt.compareTo(io.dcloud.uts.StringKt.lastIndexOf$default(filename, com.taobao.weex.el.parse.Operators.DOT_STR, null, 2, null), (java.lang.Number) 0) >= 0) {
            fileExtensionFromUrl = io.dcloud.uts.StringKt.substring$default(filename, io.dcloud.uts.NumberKt.plus(io.dcloud.uts.StringKt.lastIndexOf$default(filename, com.taobao.weex.el.parse.Operators.DOT_STR, null, 2, null), (java.lang.Number) 1), null, 2, null);
        }
        if (fileExtensionFromUrl != null) {
            fileExtensionFromUrl = io.dcloud.uts.StringKt.toLowerCase(fileExtensionFromUrl);
        }
        java.lang.String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
        if (android.text.TextUtils.isEmpty(mimeTypeFromExtension)) {
            if (android.text.TextUtils.isEmpty(fileExtensionFromUrl)) {
                mimeTypeFromExtension = "application/octet-stream";
            } else {
                mimeTypeFromExtension = "application/" + fileExtensionFromUrl;
            }
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(mimeTypeFromExtension);
        return mimeTypeFromExtension;
    }

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/UploadController$Companion;", "", "<init>", "()V", "instance", "Luts/sdk/modules/DCloudUniNetwork/UploadController;", "getInstance", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final uts.sdk.modules.DCloudUniNetwork.UploadController getInstance() {
            if (uts.sdk.modules.DCloudUniNetwork.UploadController.instance == null) {
                uts.sdk.modules.DCloudUniNetwork.UploadController.instance = new uts.sdk.modules.DCloudUniNetwork.UploadController();
            }
            uts.sdk.modules.DCloudUniNetwork.UploadController uploadController = uts.sdk.modules.DCloudUniNetwork.UploadController.instance;
            kotlin.jvm.internal.Intrinsics.checkNotNull(uploadController);
            return uploadController;
        }
    }
}
