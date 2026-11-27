package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    public static boolean checkFilePathLegalization(android.content.Context context, java.lang.String str) {
        if (checkPrivatePath(context, str)) {
            return true;
        }
        return needMediaStoreOpenFile(context) && !android.text.TextUtils.isEmpty(getPathForPublicType(str));
    }

    public static boolean checkPathAccord(android.content.Context context, java.lang.String... strArr) {
        boolean z = true;
        if (needMediaStoreOpenFile(context)) {
            if (android.os.Build.VERSION.SDK_INT > 29 && android.os.Environment.isExternalStorageManager()) {
                return true;
            }
            for (java.lang.String str : strArr) {
                if (!checkPrivatePath(context, str)) {
                    z = false;
                }
            }
        }
        return z;
    }

    public static boolean checkPrivatePath(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(io.dcloud.common.adapter.util.DeviceInfo.sPrivateDir)) {
            io.dcloud.common.adapter.util.DeviceInfo.initAppDir(context);
        }
        int i = android.os.Build.VERSION.SDK_INT;
        if (i > 29 && android.os.Environment.isExternalStorageManager()) {
            return true;
        }
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
            str = str.replace(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "");
        }
        if (io.dcloud.common.adapter.util.DeviceInfo.sPrivateExternalDir.startsWith("/") && !str.startsWith("/")) {
            str = "/" + str;
        }
        return str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPrivateDir) || str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPrivateExternalDir) || isAssetFile(str) || i < 29;
    }

    private static android.net.Uri copyMediaFile(android.content.Context context, java.io.InputStream inputStream, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) throws java.lang.Exception {
        java.lang.String fileTypeForSuffix = getFileTypeForSuffix(str2);
        if (android.text.TextUtils.isEmpty(fileTypeForSuffix)) {
            return null;
        }
        android.net.Uri contentUriForSuffix = getContentUriForSuffix(str2);
        java.io.File file = new java.io.File(io.dcloud.common.adapter.util.DeviceInfo.sPublicDCIMDir + "/" + str4 + str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.DOT_STR);
        sb.append(str2);
        java.lang.String string = sb.toString();
        java.lang.String strReplace = str.replace(string, "");
        android.content.ContentResolver contentResolver = context.getContentResolver();
        int i = 1;
        while (file.exists()) {
            str = strReplace + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + i + com.taobao.weex.el.parse.Operators.BRACKET_END_STR + string;
            i++;
            file = new java.io.File(io.dcloud.common.adapter.util.DeviceInfo.sPublicDCIMDir + "/" + str4 + str);
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", fileTypeForSuffix);
        contentValues.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, str);
        contentValues.put("relative_path", str3 + str4);
        android.net.Uri uriInsert = contentResolver.insert(contentUriForSuffix, contentValues);
        if (uriInsert == null) {
            return null;
        }
        java.io.OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uriInsert);
        byte[] bArr = new byte[io.dcloud.common.adapter.io.DHFile.BUF_SIZE];
        if (outputStreamOpenOutputStream != null) {
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                outputStreamOpenOutputStream.write(bArr, 0, i2);
                outputStreamOpenOutputStream.flush();
            }
            outputStreamOpenOutputStream.close();
        }
        inputStream.close();
        return uriInsert;
    }

    public static android.net.Uri copyMediaFileToDCIM(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        if (needMediaStoreOpenFile(context)) {
            try {
                java.io.File file = new java.io.File(str);
                if (!file.exists()) {
                    return null;
                }
                java.io.InputStream fileInputStream = checkPrivatePath(context, str) ? new java.io.FileInputStream(file) : getFileInputStream(context, file);
                if (fileInputStream == null) {
                    return null;
                }
                java.lang.String fileNameForPath = getFileNameForPath(str);
                java.lang.String fileNameWithSuffix = getFileNameWithSuffix(fileNameForPath);
                if (android.text.TextUtils.isEmpty(fileNameWithSuffix)) {
                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    if (checkPrivatePath(context, str)) {
                        android.graphics.BitmapFactory.decodeFile(str, options);
                    } else {
                        java.io.InputStream fileInputStream2 = getFileInputStream(context, file);
                        android.graphics.BitmapFactory.decodeStream(fileInputStream2, null, options);
                        fileInputStream2.close();
                    }
                    java.lang.String str3 = options.outMimeType;
                    if (io.dcloud.common.util.PdrUtil.isEmpty(str3) || !str3.contains("/")) {
                        str2 = "jpg";
                    } else {
                        java.lang.String[] strArrSplit = str3.split("/");
                        str2 = strArrSplit[strArrSplit.length - 1];
                    }
                    fileNameWithSuffix = str2;
                }
                return copyMediaFile(context, fileInputStream, fileNameForPath, fileNameWithSuffix, "DCIM/", "Camera/");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static android.net.Uri createPublicDocumentsFile(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (needMediaStoreOpenFile(context)) {
            android.net.Uri contentUri = android.provider.MediaStore.Files.getContentUri("external");
            java.io.File file = new java.io.File(io.dcloud.common.adapter.util.DeviceInfo.sPublicDocumentsDir + "/" + str);
            if (file.exists()) {
                return getFileUri(context, file, contentUri);
            }
            android.content.ContentResolver contentResolver = context.getContentResolver();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", str2);
            contentValues.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, str);
            contentValues.put("relative_path", "Documents/");
            try {
                return contentResolver.insert(contentUri, contentValues);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void deleteFile(android.content.Context context, java.lang.String str) {
        if (context != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                java.io.File fileStreamPath = context.getFileStreamPath(str);
                if (fileStreamPath.exists()) {
                    fileStreamPath.delete();
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static android.net.Uri getContentUriForSuffix(java.lang.String str) {
        java.lang.String upperCase = str.toUpperCase();
        upperCase.getClass();
        upperCase.hashCode();
        switch (upperCase) {
            case "AAC":
            case "AMR":
            case "M4A":
            case "MKA":
            case "MP3":
            case "OGG":
            case "WAV":
            case "WMA":
            case "FLAC":
                return android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            case "ASF":
            case "AVI":
            case "M4V":
            case "MKV":
            case "MP4":
            case "WMV":
            case "3GPP":
            case "WEBM":
            case "3GPP2":
            case "MP2TS":
                return android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            case "BMP":
            case "GIF":
            case "JPG":
            case "PNG":
            case "JPEG":
            case "WBMP":
            case "WEBP":
                return android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            default:
                return android.provider.MediaStore.Files.getContentUri("external");
        }
    }

    public static java.io.InputStream getFileInputStream(android.content.Context context, java.lang.String str) {
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
            str = str.replace(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "");
        }
        return getFileInputStream(context, new java.io.File(str));
    }

    public static java.lang.String getFileNameForPath(java.lang.String str) {
        int iLastIndexOf;
        if (android.text.TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf("/")) == -1) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    public static java.lang.String getFileNameWithSuffix(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    public static java.lang.String getFileProviderUriToPath(android.content.Context context, android.net.Uri uri) {
        try {
            java.lang.reflect.Method declaredMethod = androidx.core.content.FileProvider.class.getDeclaredMethod("getPathStrategy", android.content.Context.class, java.lang.String.class);
            declaredMethod.setAccessible(true);
            java.lang.Object objInvoke = declaredMethod.invoke(null, context, uri.getAuthority());
            if (objInvoke != null) {
                java.lang.reflect.Method declaredMethod2 = java.lang.Class.forName(androidx.core.content.FileProvider.class.getName() + "$PathStrategy").getDeclaredMethod("getFileForUri", android.net.Uri.class);
                declaredMethod2.setAccessible(true);
                java.lang.Object objInvoke2 = declaredMethod2.invoke(objInvoke, uri);
                if (objInvoke2 instanceof java.io.File) {
                    return ((java.io.File) objInvoke2).getAbsolutePath();
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public static java.lang.String getFileTypeForSuffix(java.lang.String str) {
        java.lang.String upperCase = str.toUpperCase();
        upperCase.getClass();
        upperCase.hashCode();
        switch (upperCase) {
            case "AAC":
            case "AMR":
            case "M4A":
            case "MKA":
            case "MP3":
            case "OGG":
            case "WAV":
            case "WMA":
            case "FLAC":
                return "audio/*";
            case "ASF":
            case "AVI":
            case "M4V":
            case "MKV":
            case "MP4":
            case "WMV":
            case "3GPP":
            case "WEBM":
            case "3GPP2":
            case "MP2TS":
                return "video/*";
            case "BMP":
            case "GIF":
            case "JPG":
            case "PNG":
            case "JPEG":
            case "WBMP":
            case "WEBP":
                return "image/*";
            default:
                return null;
        }
    }

    public static android.net.Uri getFileUri(android.content.Context context, java.io.File file, android.net.Uri uri) {
        android.database.Cursor cursorQuery = context.getContentResolver().query(uri, new java.lang.String[]{"_id"}, "_data=? ", new java.lang.String[]{file.getAbsolutePath()}, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        }
        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
        cursorQuery.close();
        return android.net.Uri.withAppendedPath(uri, "" + i);
    }

    public static java.io.InputStream getImageFileStream(android.content.Context context, java.io.File file) {
        android.net.Uri imageFileUri = getImageFileUri(context, file.getPath());
        if (imageFileUri == null) {
            return null;
        }
        try {
            return context.getContentResolver().openInputStream(imageFileUri);
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static android.net.Uri getImageFileUri(android.content.Context context, java.lang.String str) {
        return getImageFileUri(context, new java.io.File(str));
    }

    public static java.lang.String getPathForPublicType(java.lang.String str) {
        if (str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPublicDCIMDir)) {
            return android.os.Environment.DIRECTORY_DCIM;
        }
        if (str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPublicDownloadDir)) {
            return android.os.Environment.DIRECTORY_DOWNLOADS;
        }
        if (str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPublicMoviesDir)) {
            return android.os.Environment.DIRECTORY_MOVIES;
        }
        if (str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPublicMusicDir)) {
            return android.os.Environment.DIRECTORY_MUSIC;
        }
        if (str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPublicPicturesDir)) {
            return android.os.Environment.DIRECTORY_PICTURES;
        }
        if (str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPublicDocumentsDir)) {
            return android.os.Environment.DIRECTORY_DOCUMENTS;
        }
        if (str.contains(io.dcloud.common.adapter.util.DeviceInfo.sPublicRingtonesDir)) {
            return android.os.Environment.DIRECTORY_RINGTONES;
        }
        return null;
    }

    public static io.dcloud.common.util.DCFileUriData getShareImageUri(android.content.Context context, java.io.File file, java.lang.String str, android.content.Intent intent) {
        io.dcloud.common.util.DCFileUriData dCFileUriData = new io.dcloud.common.util.DCFileUriData();
        java.lang.String path = file.getPath();
        dCFileUriData.filePath = path;
        if (isExternalPublicDir(path) || android.os.Build.VERSION.SDK_INT < 29 || getPathForPublicType(path) != null) {
            if (!isExternalPublicDir(path)) {
                dCFileUriData.fileUri = android.net.Uri.fromFile(file);
                return dCFileUriData;
            }
            java.io.File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            dCFileUriData.fileUri = androidx.core.content.FileProvider.getUriForFile(context, context.getPackageName() + ".dc.fileprovider", file);
            return dCFileUriData;
        }
        java.lang.String str2 = context.getExternalFilesDir(android.os.Environment.DIRECTORY_DCIM).getPath() + "/" + str.hashCode() + com.taobao.weex.el.parse.Operators.DOT_STR + getFileNameWithSuffix(str);
        java.io.File file2 = new java.io.File(str2);
        java.io.File parentFile2 = file2.getParentFile();
        if (!parentFile2.exists()) {
            parentFile2.mkdirs();
        }
        dCFileUriData.fileUri = androidx.core.content.FileProvider.getUriForFile(context, context.getPackageName() + ".dc.fileprovider", file2);
        dCFileUriData.isReplace = true;
        dCFileUriData.fileReplacePath = str2;
        if (intent != null) {
            intent.addFlags(1);
        }
        return dCFileUriData;
    }

    public static android.net.Uri getVideoFileUri(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(str);
        return checkPrivatePath(context, str) ? android.net.Uri.fromFile(file) : getFileUri(context, file, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    }

    public static boolean isAssetFile(java.lang.String str) {
        return str.startsWith("apps/") || str.startsWith("/android_asset/") || str.startsWith("android_asset/");
    }

    private static boolean isExternalPublicDir(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(io.dcloud.common.adapter.util.DeviceInfo.sPrivateExternalDir);
        sb.append("/file/");
        return str.contains(sb.toString()) || str.contains(io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath);
    }

    public static boolean isFilePathForPublic(android.content.Context context, java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
            str = str.replace(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "");
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return false;
        }
        if (!needMediaStoreOpenFile(context)) {
            return true;
        }
        java.lang.String fileNameWithSuffix = getFileNameWithSuffix(str);
        return (io.dcloud.common.util.PdrUtil.isEmpty(fileNameWithSuffix) || getFileUri(context, file, getContentUriForSuffix(fileNameWithSuffix)) == null) ? false : true;
    }

    public static boolean needMediaStoreOpenFile(android.content.Context context) {
        int i = android.os.Build.VERSION.SDK_INT;
        return (i >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) || i >= 30;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003b A[PHI: r8
  0x003b: PHI (r8v4 android.database.Cursor) = (r8v3 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:19:0x0039, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0044  */
    /* JADX WARN: Code duplicated, block: B:32:? A[SYNTHETIC] */
    private static java.lang.String queryAbsolutePath(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.lang.Exception exc;
        android.database.Cursor cursorQuery;
        android.database.Cursor cursor = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            cursorQuery.close();
                            cursorQuery.close();
                            return string;
                        }
                    } catch (java.lang.Exception e) {
                        exc = e;
                        exc.printStackTrace();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Exception e2) {
            exc = e2;
            cursorQuery = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (cursor != null) {
                throw th;
            }
            cursor.close();
            throw th;
        }
        return null;
    }

    public static java.lang.Object readData4Disk(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        java.io.ObjectInputStream objectInputStream;
        java.io.ObjectInputStream objectInputStream2 = null;
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                objectInputStream = new java.io.ObjectInputStream(new java.io.FileInputStream(context.getFileStreamPath(str)));
                try {
                    java.lang.Object object = objectInputStream.readObject();
                    objectInputStream.close();
                    io.dcloud.common.util.IOUtil.close(objectInputStream);
                    return object;
                } catch (java.lang.Exception unused) {
                    io.dcloud.common.util.IOUtil.close(objectInputStream);
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    objectInputStream2 = objectInputStream;
                    io.dcloud.common.util.IOUtil.close(objectInputStream2);
                    throw th;
                }
            } catch (java.lang.Exception unused2) {
                objectInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static void saveData2Disk(android.content.Context context, java.lang.Object obj, java.lang.String str) throws java.lang.Throwable {
        if (context == null || obj == null || !(obj instanceof java.io.Serializable) || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.io.ObjectOutputStream objectOutputStream = null;
        try {
            java.io.File fileStreamPath = context.getFileStreamPath(str);
            if (!fileStreamPath.exists()) {
                fileStreamPath.createNewFile();
            }
            java.io.ObjectOutputStream objectOutputStream2 = new java.io.ObjectOutputStream(new java.io.FileOutputStream(fileStreamPath));
            try {
                objectOutputStream2.writeObject(obj);
                objectOutputStream2.close();
                io.dcloud.common.util.IOUtil.close(objectOutputStream2);
            } catch (java.io.IOException unused) {
                objectOutputStream = objectOutputStream2;
                io.dcloud.common.util.IOUtil.close(objectOutputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                io.dcloud.common.util.IOUtil.close(objectOutputStream);
                throw th;
            }
        } catch (java.io.IOException unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void writeStream2File(java.io.InputStream inputStream, java.io.File file) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            if (inputStream != null) {
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, i);
                            }
                        }
                        fileOutputStream.close();
                        inputStream.close();
                        fileOutputStream2 = fileOutputStream;
                    } catch (java.lang.Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        io.dcloud.common.util.IOUtil.close(inputStream);
                        io.dcloud.common.util.IOUtil.close(fileOutputStream2);
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        io.dcloud.common.util.IOUtil.close(inputStream);
                        io.dcloud.common.util.IOUtil.close(fileOutputStream);
                        throw th;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
            }
            io.dcloud.common.util.IOUtil.close(inputStream);
            io.dcloud.common.util.IOUtil.close(fileOutputStream2);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }

    public static java.lang.String getPathFromUri(android.content.Context context, android.net.Uri uri) {
        android.net.Uri uri2;
        if (uri == null) {
            return null;
        }
        if (!android.provider.DocumentsContract.isDocumentUri(context, uri)) {
            java.lang.String scheme = uri.getScheme();
            if (com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME.equals(scheme)) {
                return queryAbsolutePath(context, uri);
            }
            if ("file".equals(scheme)) {
                return uri.getPath();
            }
            return null;
        }
        java.lang.String authority = uri.getAuthority();
        if ("com.android.externalstorage.documents".equals(authority)) {
            java.lang.String[] strArrSplit = android.provider.DocumentsContract.getDocumentId(uri).split(":");
            java.lang.String str = strArrSplit[0];
            return "primary".equals(str) ? android.os.Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(strArrSplit[1]) : "/storage/".concat(str).concat("/").concat(strArrSplit[1]);
        }
        if ("com.android.providers.downloads.documents".equals(authority)) {
            java.lang.String documentId = android.provider.DocumentsContract.getDocumentId(uri);
            return documentId.startsWith("raw:") ? documentId.replaceFirst("raw:", "") : queryAbsolutePath(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.parseLong(documentId)));
        }
        if ("com.android.providers.media.documents".equals(authority)) {
            java.lang.String[] strArrSplit2 = android.provider.DocumentsContract.getDocumentId(uri).split(":");
            java.lang.String str2 = strArrSplit2[0];
            if ("image".equals(str2)) {
                uri2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str2)) {
                uri2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str2)) {
                uri2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return queryAbsolutePath(context, android.content.ContentUris.withAppendedId(uri2, java.lang.Long.parseLong(strArrSplit2[1])));
        }
        return null;
    }

    public static android.net.Uri getImageFileUri(android.content.Context context, java.io.File file) {
        if (checkPrivatePath(context, file.getPath())) {
            return android.net.Uri.fromFile(file);
        }
        return getFileUri(context, file, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:69:0x0110 A[Catch: FileNotFoundException -> 0x0129, TryCatch #0 {FileNotFoundException -> 0x0129, blocks: (B:7:0x000f, B:9:0x0019, B:11:0x001f, B:13:0x0029, B:15:0x002f, B:17:0x0039, B:19:0x0042, B:21:0x004c, B:25:0x0057, B:27:0x005f, B:29:0x0065, B:31:0x006f, B:33:0x0078, B:35:0x0080, B:37:0x0088, B:39:0x0091, B:41:0x0099, B:43:0x00a1, B:45:0x00aa, B:47:0x00b2, B:49:0x00ba, B:51:0x00c3, B:53:0x00cb, B:55:0x00d5, B:57:0x00de, B:59:0x00e6, B:61:0x00ee, B:63:0x00f7, B:65:0x00ff, B:67:0x0107, B:69:0x0110, B:71:0x011a, B:73:0x0123), top: B:78:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:71:0x011a A[Catch: FileNotFoundException -> 0x0129, TryCatch #0 {FileNotFoundException -> 0x0129, blocks: (B:7:0x000f, B:9:0x0019, B:11:0x001f, B:13:0x0029, B:15:0x002f, B:17:0x0039, B:19:0x0042, B:21:0x004c, B:25:0x0057, B:27:0x005f, B:29:0x0065, B:31:0x006f, B:33:0x0078, B:35:0x0080, B:37:0x0088, B:39:0x0091, B:41:0x0099, B:43:0x00a1, B:45:0x00aa, B:47:0x00b2, B:49:0x00ba, B:51:0x00c3, B:53:0x00cb, B:55:0x00d5, B:57:0x00de, B:59:0x00e6, B:61:0x00ee, B:63:0x00f7, B:65:0x00ff, B:67:0x0107, B:69:0x0110, B:71:0x011a, B:73:0x0123), top: B:78:0x000f }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static java.io.InputStream getFileInputStream(android.content.Context context, java.io.File file) {
        android.net.Uri fileUri;
        android.net.Uri fileUri2;
        if (file != null && !android.text.TextUtils.isEmpty(file.getPath())) {
            try {
                java.lang.String path = file.getPath();
                if (checkPrivatePath(context, path)) {
                    return new java.io.FileInputStream(file);
                }
                java.lang.String fileNameWithSuffix = getFileNameWithSuffix(path);
                if (needMediaStoreOpenFile(context)) {
                    if (!android.text.TextUtils.isEmpty(fileNameWithSuffix)) {
                        android.net.Uri fileUri3 = getFileUri(context, file, getContentUriForSuffix(fileNameWithSuffix));
                        if (fileUri3 != null) {
                            return context.getContentResolver().openInputStream(fileUri3);
                        }
                    } else {
                        java.lang.String pathForPublicType = getPathForPublicType(path);
                        if (!android.text.TextUtils.isEmpty(pathForPublicType)) {
                            switch (pathForPublicType.hashCode()) {
                                case -1984392349:
                                    if (pathForPublicType.equals("Movies")) {
                                        android.net.Uri fileUri4 = getFileUri(context, file, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                                        if (fileUri4 != null) {
                                            return context.getContentResolver().openInputStream(fileUri4);
                                        }
                                    } else {
                                        fileUri = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                        if (fileUri != null) {
                                            return context.getContentResolver().openInputStream(fileUri);
                                        }
                                    }
                                case -1970382607:
                                    if (pathForPublicType.equals("Ringtones")) {
                                        android.net.Uri fileUri5 = getFileUri(context, file, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                                        if (fileUri5 != null) {
                                            return context.getContentResolver().openInputStream(fileUri5);
                                        }
                                    } else {
                                        fileUri = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                        if (fileUri != null) {
                                            return context.getContentResolver().openInputStream(fileUri);
                                        }
                                    }
                                case -1347456360:
                                    if (pathForPublicType.equals("Documents")) {
                                        android.net.Uri fileUri6 = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                        if (fileUri6 != null) {
                                            return context.getContentResolver().openInputStream(fileUri6);
                                        }
                                    } else {
                                        fileUri = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                        if (fileUri != null) {
                                            return context.getContentResolver().openInputStream(fileUri);
                                        }
                                    }
                                case -665475243:
                                    if (pathForPublicType.equals("Pictures")) {
                                        android.net.Uri fileUri7 = getFileUri(context, file, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        if (fileUri7 != null) {
                                            return context.getContentResolver().openInputStream(fileUri7);
                                        }
                                    } else {
                                        fileUri = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                        if (fileUri != null) {
                                            return context.getContentResolver().openInputStream(fileUri);
                                        }
                                    }
                                case 2092515:
                                    if (pathForPublicType.equals("DCIM")) {
                                        android.net.Uri fileUri8 = getFileUri(context, file, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        if (fileUri8 != null) {
                                            return context.getContentResolver().openInputStream(fileUri8);
                                        }
                                    } else {
                                        fileUri = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                        if (fileUri != null) {
                                            return context.getContentResolver().openInputStream(fileUri);
                                        }
                                    }
                                case 74710533:
                                    if (pathForPublicType.equals("Music")) {
                                        android.net.Uri fileUri9 = getFileUri(context, file, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                                        if (fileUri9 != null) {
                                            return context.getContentResolver().openInputStream(fileUri9);
                                        }
                                    } else {
                                        fileUri = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                        if (fileUri != null) {
                                            return context.getContentResolver().openInputStream(fileUri);
                                        }
                                    }
                                case 1492462760:
                                    if (pathForPublicType.equals("Download")) {
                                        if (android.os.Build.VERSION.SDK_INT >= 29 && (fileUri2 = getFileUri(context, file, android.provider.MediaStore.Downloads.EXTERNAL_CONTENT_URI)) != null) {
                                            return context.getContentResolver().openInputStream(fileUri2);
                                        }
                                    } else {
                                        fileUri = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                        if (fileUri != null) {
                                            return context.getContentResolver().openInputStream(fileUri);
                                        }
                                    }
                                default:
                                    fileUri = getFileUri(context, file, android.provider.MediaStore.Files.getContentUri("external"));
                                    if (fileUri != null) {
                                        return context.getContentResolver().openInputStream(fileUri);
                                    }
                                    break;
                            }
                        }
                    }
                } else {
                    return new java.io.FileInputStream(file);
                }
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static android.net.Uri copyMediaFileToDCIM(android.content.Context context, java.io.InputStream inputStream, java.lang.String str) {
        if (!needMediaStoreOpenFile(context) || inputStream == null) {
            return null;
        }
        try {
            java.lang.String fileNameWithSuffix = getFileNameWithSuffix(str);
            if (android.text.TextUtils.isEmpty(getFileTypeForSuffix(fileNameWithSuffix))) {
                return null;
            }
            return copyMediaFile(context, inputStream, str, fileNameWithSuffix, "DCIM/", "Camera/");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
