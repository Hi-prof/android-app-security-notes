package io.dcloud.common.adapter.io;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DHFile {
    public static final int BUF_SIZE = 204800;
    public static final byte FS_JAR = 0;
    public static final byte FS_NATIVE = 2;
    public static final byte FS_RMS = 1;
    public static final int READ = 1;
    public static final int READ_WRITE = 3;
    private static final java.lang.String ROOTPATH = "/";
    public static final int WRITE = 2;

    public static void addFile(java.lang.String str, byte[] bArr) throws java.io.IOException {
        java.lang.Object objCreateFileHandler = createFileHandler(str);
        createNewFile(objCreateFileHandler);
        java.io.OutputStream outputStream = getOutputStream(objCreateFileHandler, false);
        if (outputStream != null) {
            try {
                outputStream.write(bArr, 0, bArr.length);
                outputStream.flush();
                outputStream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean canRead(java.lang.String str) throws java.io.IOException {
        return getFile(getRealPath(str)).canRead();
    }

    private static boolean checkIsNeedReload(java.lang.String str) {
        return str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".xml") || str.endsWith(".bmp");
    }

    public static boolean copyAssetsFile(java.lang.String str, java.lang.String str2) {
        boolean zWriteFile = false;
        java.io.InputStream resInputStream = null;
        try {
            resInputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(str);
            if (resInputStream != null) {
                zWriteFile = writeFile(resInputStream, str2);
            } else if (checkIsNeedReload(str)) {
                io.dcloud.common.adapter.util.Logger.d("PlatFU copyAssetsFile fail ！！！！  is = null < " + str + " > to < " + str2 + " >");
            }
            io.dcloud.common.adapter.util.Logger.d("PlatFU copyAssetsFile < " + str + " > to < " + str2 + " >");
            return zWriteFile;
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.d("PlatFU copyAssetsFile " + str2 + " error!!!  is it a dir ?");
            java.lang.StringBuilder sb = new java.lang.StringBuilder("PlatFU copyAssetsFile ");
            sb.append(e);
            io.dcloud.common.adapter.util.Logger.d(sb.toString());
            if (checkIsNeedReload(str)) {
                io.dcloud.common.adapter.util.Logger.d("PlatFU copyAssetsFile fail ！！！！ Exception< " + str + " > to < " + str2 + " >");
            }
            return zWriteFile;
        } finally {
            io.dcloud.common.util.IOUtil.close(resInputStream);
        }
    }

    public static void copyDir(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            if (str.charAt(0) == '/') {
                str = str.substring(1, str.length());
            }
            if (str.charAt(str.length() - 1) == '/') {
                str = str.substring(0, str.length() - 1);
            }
            java.lang.String[] strArrListResFiles = io.dcloud.common.adapter.util.PlatformUtil.listResFiles(str);
            if (createNewFile(str2) != -1) {
                for (java.lang.String str3 : strArrListResFiles) {
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    stringBuffer.append(str);
                    stringBuffer.append('/');
                    stringBuffer.append(str3);
                    java.lang.String string = stringBuffer.toString();
                    java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
                    stringBuffer2.append(str2);
                    stringBuffer2.append(str3);
                    java.lang.String string2 = stringBuffer2.toString();
                    if (!copyAssetsFile(string, string2)) {
                        if (!checkIsNeedReload(str3)) {
                            copyDir(string, string2 + "/");
                        } else if (!copyAssetsFile(string, string2) && !copyAssetsFile(string, string2)) {
                            io.dcloud.common.adapter.util.Logger.d("PlatFU copyDir fail 3 times!!!!" + string);
                            copyDir(string, string2 + "/");
                        }
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static int copyFile(java.lang.String str, java.lang.String str2, boolean z, boolean z2, io.dcloud.common.DHInterface.ICallBack iCallBack) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.OutputStream outputStream;
        java.io.InputStream fileInputStream;
        java.lang.String realPath = getRealPath(str);
        java.lang.String realPath2 = getRealPath(str2);
        int i = -1;
        java.io.OutputStream outputStream2 = null;
        outputStream2 = null;
        outputStream2 = null;
        outputStream2 = null;
        java.io.InputStream inputStream2 = null;
        try {
            android.content.Context context = io.dcloud.application.DCLoudApplicationImpl.self().getContext();
            if (!io.dcloud.common.util.FileUtil.checkPathAccord(context, realPath2) && io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion > 28) {
                try {
                    java.lang.Thread.sleep(10L);
                } catch (java.lang.Exception unused) {
                }
                io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                io.dcloud.common.util.IOUtil.close((java.io.OutputStream) null);
                return -3;
            }
            if (isExist(realPath2)) {
                if (z2) {
                    try {
                        java.lang.Thread.sleep(10L);
                    } catch (java.lang.Exception unused2) {
                    }
                    io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                    io.dcloud.common.util.IOUtil.close((java.io.OutputStream) null);
                    return -2;
                }
                if (z && !isDirectory(new java.io.File(realPath2))) {
                    deleteFile(realPath2);
                }
            }
            java.io.File file = new java.io.File(realPath);
            if (!file.exists()) {
                if (iCallBack != null) {
                    iCallBack.onCallBack(-1, "not file =" + realPath);
                }
                try {
                    java.lang.Thread.sleep(10L);
                } catch (java.lang.Exception unused3) {
                }
                io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                io.dcloud.common.util.IOUtil.close((java.io.OutputStream) null);
                return -1;
            }
            if (file.isDirectory()) {
                java.lang.String[] list = list(file);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(realPath);
                java.lang.String str3 = java.io.File.separator;
                sb.append(realPath.endsWith(str3) ? "" : str3);
                java.lang.String string = sb.toString();
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(realPath2);
                if (realPath2.endsWith(str3)) {
                    str3 = "";
                }
                sb2.append(str3);
                java.lang.String string2 = sb2.toString();
                int iCopyFile = -1;
                for (int i2 = 0; i2 < list.length; i2++) {
                    iCopyFile = copyFile(string + list[i2], string2 + list[i2], z, z2);
                    if (iCopyFile != 1) {
                        if (iCallBack != null) {
                            iCallBack.onCallBack(iCopyFile, "copyFile error src=" + string + list[i2] + " dest=" + string2 + list[i2]);
                        }
                        try {
                            java.lang.Thread.sleep(10L);
                        } catch (java.lang.Exception unused4) {
                        }
                        io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                        io.dcloud.common.util.IOUtil.close((java.io.OutputStream) null);
                        return iCopyFile;
                    }
                }
                inputStream = null;
                i = iCopyFile;
            } else {
                if (io.dcloud.common.util.FileUtil.checkPathAccord(context, realPath) || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion <= 28) {
                    fileInputStream = new java.io.FileInputStream(file);
                } else {
                    if (!io.dcloud.common.util.FileUtil.isFilePathForPublic(context, realPath)) {
                        try {
                            java.lang.Thread.sleep(10L);
                        } catch (java.lang.Exception unused5) {
                        }
                        io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                        io.dcloud.common.util.IOUtil.close((java.io.OutputStream) null);
                        return -3;
                    }
                    fileInputStream = io.dcloud.common.util.FileUtil.getFileInputStream(context, file);
                }
                inputStream = fileInputStream;
                try {
                    java.lang.Object objCreateFileHandler = createFileHandler(realPath2);
                    if (!isExist(objCreateFileHandler)) {
                        createNewFile(objCreateFileHandler);
                    }
                    outputStream2 = getOutputStream(objCreateFileHandler);
                    byte[] bArr = new byte[BUF_SIZE];
                    if (inputStream != null) {
                        while (true) {
                            int i3 = inputStream.read(bArr);
                            if (i3 <= 0) {
                                break;
                            }
                            outputStream2.write(bArr, 0, i3);
                            outputStream2.flush();
                        }
                        i = 1;
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    java.io.OutputStream outputStream3 = outputStream2;
                    inputStream2 = inputStream;
                    outputStream = outputStream3;
                    try {
                        io.dcloud.common.adapter.util.Logger.i("copyFile:" + e);
                        if (iCallBack != null) {
                            iCallBack.onCallBack(-1, "copyFile error Message=" + e.getMessage());
                        }
                        try {
                            java.lang.Thread.sleep(10L);
                        } catch (java.lang.Exception unused6) {
                        }
                        io.dcloud.common.util.IOUtil.close(inputStream2);
                        io.dcloud.common.util.IOUtil.close(outputStream);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        java.io.InputStream inputStream3 = inputStream2;
                        outputStream2 = outputStream;
                        inputStream = inputStream3;
                        try {
                            java.lang.Thread.sleep(10L);
                        } catch (java.lang.Exception unused7) {
                        }
                        io.dcloud.common.util.IOUtil.close(inputStream);
                        io.dcloud.common.util.IOUtil.close(outputStream2);
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    java.lang.Thread.sleep(10L);
                    io.dcloud.common.util.IOUtil.close(inputStream);
                    io.dcloud.common.util.IOUtil.close(outputStream2);
                    throw th;
                }
            }
            try {
                java.lang.Thread.sleep(10L);
            } catch (java.lang.Exception unused8) {
            }
            io.dcloud.common.util.IOUtil.close(inputStream);
            io.dcloud.common.util.IOUtil.close(outputStream2);
            return i;
        } catch (java.lang.Exception e2) {
            e = e2;
            outputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public static java.lang.Object createFileHandler(java.lang.String str) {
        return str.replace('\\', '/');
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0040  */
    /* JADX WARN: Code duplicated, block: B:19:0x005b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0071 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:16:0x0040, please report this as an issue */
    public static byte createNewFile(java.lang.Object obj) {
        java.io.File file;
        boolean z;
        java.io.File parentFile;
        if (obj == null) {
            return (byte) -1;
        }
        boolean zCreateNewFile = false;
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            io.dcloud.common.adapter.util.Logger.d("createNewFile 0:" + str);
            file = new java.io.File(str);
            z = str.endsWith("/");
            parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                io.dcloud.common.adapter.util.Logger.d("createNewFile: parentPath mkdirs " + parentFile.mkdirs());
            }
            if (file.exists()) {
                return (byte) -2;
            }
            if (z) {
                zCreateNewFile = file.mkdirs();
            } else {
                try {
                    zCreateNewFile = file.createNewFile();
                } catch (java.io.IOException e) {
                    io.dcloud.common.adapter.util.Logger.w("createNewFile:", e);
                }
            }
            if (zCreateNewFile) {
                return (byte) 1;
            }
            return (byte) -1;
        }
        if (!(obj instanceof java.io.File)) {
            return (byte) -1;
        }
        file = (java.io.File) obj;
        parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            io.dcloud.common.adapter.util.Logger.d("createNewFile: parentPath mkdirs " + parentFile.mkdirs());
        }
        if (file.exists()) {
            return (byte) -2;
        }
        if (z) {
            zCreateNewFile = file.mkdirs();
        } else {
            zCreateNewFile = file.createNewFile();
        }
        if (zCreateNewFile) {
            return (byte) 1;
        }
        return (byte) -1;
    }

    public static boolean delete(java.lang.Object obj) {
        boolean zDelete;
        if (obj == null) {
            return false;
        }
        try {
            java.io.File file = getFile(obj);
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return file.delete();
            }
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    io.dcloud.common.adapter.util.Logger.d("delete:" + fileArrListFiles[i].getPath());
                    if (fileArrListFiles[i].isDirectory()) {
                        zDelete = delete(file.getPath() + "/" + fileArrListFiles[i].getName());
                    } else {
                        zDelete = fileArrListFiles[i].delete();
                        java.lang.Thread.sleep(2L);
                    }
                    if (!zDelete) {
                        return false;
                    }
                }
            }
            boolean zDelete2 = file.delete();
            io.dcloud.common.adapter.util.Logger.i("delete " + obj + ":" + java.lang.String.valueOf(zDelete2));
            return zDelete2;
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.w("DHFile.delete", e);
            return false;
        }
    }

    public static void deleteAsync(final java.lang.Object obj, final io.dcloud.common.adapter.io.IAsyncCallback iAsyncCallback) {
        if (iAsyncCallback == null) {
            return;
        }
        if (obj == null) {
            iAsyncCallback.done(false);
            return;
        }
        try {
            io.dcloud.common.util.ThreadPool.self().addSingleThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.io.DHFile.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        java.io.File file = io.dcloud.common.adapter.io.DHFile.getFile(obj);
                        if (!file.exists()) {
                            iAsyncCallback.done(false);
                            return;
                        }
                        if (file.isFile()) {
                            iAsyncCallback.done(file.delete());
                            return;
                        }
                        java.io.File[] fileArrListFiles = file.listFiles();
                        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                            for (int i = 0; i < fileArrListFiles.length; i++) {
                                if (!(fileArrListFiles[i].isDirectory() ? io.dcloud.common.adapter.io.DHFile.delete(file.getPath() + "/" + fileArrListFiles[i].getName()) : fileArrListFiles[i].delete())) {
                                    iAsyncCallback.done(false);
                                    return;
                                }
                            }
                        }
                        iAsyncCallback.done(file.delete());
                    } catch (java.lang.Exception e) {
                        io.dcloud.common.adapter.util.Logger.w("DHFile.delete", e);
                        iAsyncCallback.done(false);
                    }
                }
            });
        } catch (java.lang.Exception unused) {
            iAsyncCallback.done(false);
        }
    }

    public static int deleteFile(java.lang.String str) throws java.io.IOException {
        return delete(new java.io.File(getRealPath(str))) ? 1 : -1;
    }

    public static boolean exists(java.lang.Object obj) {
        try {
            if (!(obj instanceof java.lang.String)) {
                if (obj instanceof java.io.File) {
                    return ((java.io.File) obj).exists();
                }
                return false;
            }
            java.lang.String strSubstring = (java.lang.String) obj;
            if (strSubstring.endsWith("/")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            return new java.io.File(strSubstring).exists();
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.io.File getFile(java.lang.Object obj) {
        if (!(obj instanceof java.lang.String)) {
            if (obj instanceof java.io.File) {
                return (java.io.File) obj;
            }
            return null;
        }
        java.lang.String strSubstring = (java.lang.String) obj;
        if (strSubstring.endsWith("/")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return new java.io.File(strSubstring);
    }

    public static java.lang.String getFileName(java.lang.Object obj) {
        return getName(obj);
    }

    public static java.lang.String getFilePath(java.lang.Object obj) {
        return getPath(obj);
    }

    public static long getFileSize(java.io.File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        long fileSize = 0;
        for (java.io.File file2 : file.listFiles()) {
            fileSize += getFileSize(file2);
        }
        return fileSize;
    }

    public static java.lang.String getFileUrl(java.lang.Object obj) {
        return getPath(obj);
    }

    public static java.io.InputStream getInputStream(java.lang.Object obj) throws java.io.IOException {
        java.io.File file;
        if (obj instanceof java.lang.String) {
            java.lang.String strSubstring = (java.lang.String) obj;
            if (strSubstring.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                strSubstring = strSubstring.substring(7);
            }
            file = new java.io.File(strSubstring);
        } else {
            file = obj instanceof java.io.File ? (java.io.File) obj : null;
        }
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            return new java.io.FileInputStream(file);
        } catch (java.io.FileNotFoundException unused) {
            io.dcloud.common.adapter.util.Logger.e("DHFile getInputStream not found file: " + file.getPath());
            return null;
        } catch (java.lang.SecurityException e) {
            io.dcloud.common.adapter.util.Logger.w("getInputStream2", e);
            return null;
        }
    }

    public static long getLastModify(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(getRealPath(str));
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    public static java.lang.String getName(java.lang.Object obj) {
        if (!(obj instanceof java.lang.String)) {
            return ((java.io.File) obj).getName();
        }
        java.lang.String strSubstring = (java.lang.String) obj;
        if (strSubstring.endsWith("/")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return strSubstring.substring(strSubstring.lastIndexOf(47) + 1);
    }

    public static java.io.OutputStream getOutputStream(java.lang.Object obj) throws java.io.IOException {
        java.io.File file;
        if (obj instanceof java.lang.String) {
            file = new java.io.File((java.lang.String) obj);
        } else {
            file = obj instanceof java.io.File ? (java.io.File) obj : null;
        }
        if (file != null) {
            if (file.canWrite()) {
                try {
                    return new java.io.FileOutputStream(file);
                } catch (java.io.FileNotFoundException e) {
                    io.dcloud.common.adapter.util.Logger.w("getOutputStream:", e);
                    return null;
                }
            }
            io.dcloud.common.adapter.util.Logger.i("getOutputStream:can not write");
        }
        return null;
    }

    public static java.lang.Object getParent(java.lang.Object obj) throws java.io.IOException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(getPath(obj));
        if (((java.io.File) obj).isDirectory()) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.delete(stringBuffer.toString().lastIndexOf(47), stringBuffer.length());
        return createFileHandler(stringBuffer.toString());
    }

    public static java.lang.String getPath(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            return str.substring(0, str.lastIndexOf(47) + 1);
        }
        if (obj instanceof java.io.File) {
            return ((java.io.File) obj).getPath();
        }
        return null;
    }

    private static java.lang.String getRealPath(java.lang.String str) {
        java.lang.String str2 = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if ("".equals(str)) {
            return str2;
        }
        try {
            char[] charArray = str.toCharArray();
            int i = 0;
            while (i < charArray.length) {
                char c = charArray[0];
                int i2 = 3;
                if ((c == 'C' || c == 'c') && i == 0) {
                    stringBuffer.append(str2);
                    i = 3;
                }
                char c2 = charArray[0];
                if ((c2 == 'D' || c2 == 'd') && i == 0) {
                    stringBuffer.append(str2);
                } else {
                    i2 = i;
                }
                char c3 = charArray[i2];
                if (c3 == '\\') {
                    stringBuffer.append('/');
                } else {
                    stringBuffer.append(c3);
                }
                i = i2 + 1;
            }
            return stringBuffer.toString();
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            return str;
        }
    }

    public static boolean hasFile() {
        return false;
    }

    public static boolean isDirectory(java.lang.Object obj) throws java.io.IOException {
        return ((java.io.File) obj).isDirectory();
    }

    public static boolean isExist(java.lang.String str) throws java.io.IOException {
        return exists(getFile(getRealPath(str)));
    }

    public static boolean isHidden(java.lang.Object obj) throws java.io.IOException {
        java.io.File file = getFile(obj);
        if (file == null) {
            return false;
        }
        return file.isHidden();
    }

    public static long length(java.lang.Object obj) {
        try {
            return ((java.io.File) obj).length();
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.w("length:", e);
            return -1L;
        }
    }

    public static java.lang.String[] list(java.lang.Object obj) throws java.io.IOException {
        java.lang.Object[] objArrListFiles = listFiles(obj);
        if (objArrListFiles == null) {
            return null;
        }
        java.lang.String[] strArr = new java.lang.String[objArrListFiles.length];
        for (int i = 0; i < objArrListFiles.length; i++) {
            java.io.File file = (java.io.File) objArrListFiles[i];
            if (file.isDirectory()) {
                strArr[i] = file.getName() + "/";
            } else {
                strArr[i] = file.getName();
            }
        }
        return strArr;
    }

    public static java.lang.String[] listDir(java.lang.Object obj) throws java.io.IOException {
        java.lang.Object[] objArrListFiles = listFiles(obj);
        if (objArrListFiles == null) {
            return null;
        }
        java.lang.String[] strArr = new java.lang.String[objArrListFiles.length];
        for (int i = 0; i < objArrListFiles.length; i++) {
            java.io.File file = (java.io.File) objArrListFiles[i];
            if (file.isDirectory()) {
                strArr[i] = file.getName() + "/";
            }
        }
        return strArr;
    }

    public static java.lang.Object[] listFiles(java.lang.Object obj) throws java.io.IOException {
        java.io.File file;
        if (obj instanceof java.lang.String) {
            file = new java.io.File((java.lang.String) obj);
        } else {
            file = obj instanceof java.io.File ? (java.io.File) obj : null;
        }
        if (file != null) {
            file.isDirectory();
            try {
                return file.listFiles();
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.w("listFiles:", e);
            }
        }
        return null;
    }

    public static java.util.List<java.lang.String> listFilesWithName(java.lang.Object obj, final java.lang.String str) {
        java.io.File[] fileArrListFiles;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (str != null) {
            java.io.File file = obj instanceof java.lang.String ? new java.io.File((java.lang.String) obj) : obj instanceof java.io.File ? (java.io.File) obj : null;
            if (file != null && file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new java.io.FilenameFilter() { // from class: io.dcloud.common.adapter.io.DHFile.3
                @Override // java.io.FilenameFilter
                public boolean accept(java.io.File file2, java.lang.String str2) {
                    return new java.io.File(file2, str2).isDirectory() || str2.equals(str);
                }
            })) != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        arrayList.addAll(listFilesWithName(file2, str));
                    } else {
                        arrayList.add(file2.getPath());
                    }
                }
            }
        }
        return arrayList;
    }

    public static java.util.List<java.lang.String> listFilesWithSuffix(java.lang.Object obj, final java.lang.String str) {
        java.io.File[] fileArrListFiles;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (str != null) {
            java.io.File file = obj instanceof java.lang.String ? new java.io.File((java.lang.String) obj) : obj instanceof java.io.File ? (java.io.File) obj : null;
            if (file != null && file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new java.io.FilenameFilter() { // from class: io.dcloud.common.adapter.io.DHFile.2
                @Override // java.io.FilenameFilter
                public boolean accept(java.io.File file2, java.lang.String str2) {
                    return new java.io.File(file2, str2).isDirectory() || str2.toLowerCase().endsWith(str);
                }
            })) != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        arrayList.addAll(listFilesWithSuffix(file2, str));
                    } else {
                        arrayList.add(file2.getPath());
                    }
                }
            }
        }
        return arrayList;
    }

    public static java.lang.String[] listRoot() throws java.io.IOException {
        return new java.io.File("/").list();
    }

    protected static java.lang.Object openFile(java.lang.String str, int i, boolean z) throws java.io.IOException {
        return createFileHandler(getRealPath(str));
    }

    /* JADX WARN: Code duplicated, block: B:48:0x004f A[EXC_TOP_SPLITTER, PHI: r4
  0x004f: PHI (r4v8 java.io.InputStream) = (r4v5 java.io.InputStream), (r4v6 java.io.InputStream), (r4v7 java.io.InputStream), (r4v10 java.io.InputStream) binds: [B:32:0x0037, B:27:0x002d, B:36:0x004d, B:19:0x001f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static byte[] readAll(java.lang.Object obj) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        ?? r1 = 0;
        try {
            try {
                inputStream = getInputStream(obj);
                if (inputStream == null) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                }
                try {
                    byte[] bytes = io.dcloud.common.util.IOUtil.getBytes(inputStream);
                    try {
                        inputStream.close();
                        return bytes;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        return bytes;
                    }
                } catch (java.io.FileNotFoundException e2) {
                    e = e2;
                    io.dcloud.common.adapter.util.Logger.i("readAll 0:" + e.getLocalizedMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (java.io.IOException e4) {
                    e = e4;
                    io.dcloud.common.adapter.util.Logger.w("readAll 2:", e);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                } catch (java.lang.SecurityException e5) {
                    e = e5;
                    io.dcloud.common.adapter.util.Logger.w("readAll 1:", e);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                r1 = obj;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (java.io.IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.io.FileNotFoundException e7) {
            e = e7;
            inputStream = null;
        } catch (java.io.IOException e8) {
            e = e8;
            inputStream = null;
        } catch (java.lang.SecurityException e9) {
            e = e9;
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public static int rename(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        java.lang.String strSubstring;
        java.lang.String realPath = getRealPath(str);
        if (realPath.endsWith("/")) {
            if (!str2.endsWith("/")) {
                str2 = str2 + "/";
            }
            strSubstring = realPath.substring(0, realPath.length() - 1);
        } else {
            strSubstring = null;
        }
        if (strSubstring != null) {
            if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(str2)) {
                str2 = strSubstring.substring(0, strSubstring.lastIndexOf("/") + 1) + str2;
            }
            java.lang.String realPath2 = getRealPath(str2);
            java.io.File file = new java.io.File(realPath);
            if (file.exists()) {
                java.io.File file2 = new java.io.File(realPath2);
                if (!file2.exists() && file.renameTo(file2)) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static boolean writeFile(java.io.InputStream inputStream, java.lang.String str) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        java.io.File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        boolean z = false;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[BUF_SIZE];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                        z = true;
                    } catch (java.lang.Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        io.dcloud.common.util.IOUtil.close(fileOutputStream2);
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        io.dcloud.common.util.IOUtil.close(fileOutputStream);
                        throw th;
                    }
                }
                io.dcloud.common.util.IOUtil.close(fileOutputStream);
                return z;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    public static java.lang.Object openFile(java.lang.String str, int i) throws java.io.IOException {
        return openFile(str, i, false);
    }

    public static boolean isExist(java.lang.Object obj) throws java.io.IOException {
        java.io.File file = getFile(obj);
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    public static boolean isHidden(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(getRealPath(str));
        if (file.exists()) {
            return isHidden(file);
        }
        return false;
    }

    public static java.io.OutputStream getOutputStream(java.lang.Object obj, boolean z) throws java.io.IOException {
        java.io.File file;
        if (obj instanceof java.lang.String) {
            file = new java.io.File((java.lang.String) obj);
        } else {
            file = obj instanceof java.io.File ? (java.io.File) obj : null;
        }
        if (file != null) {
            if (file.canWrite()) {
                try {
                    return new java.io.FileOutputStream(file, z);
                } catch (java.io.FileNotFoundException e) {
                    io.dcloud.common.adapter.util.Logger.w("getOutputStream:", e);
                    return null;
                }
            }
            io.dcloud.common.adapter.util.Logger.i("getOutputStream:can not write");
        }
        return null;
    }

    public static void writeFile(byte[] bArr, int i, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        java.io.File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            io.dcloud.common.adapter.util.Logger.i(str + "cannot create!");
            return;
        }
        if (file.exists()) {
            try {
                java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rws");
                randomAccessFile.setLength(bArr.length + i);
                randomAccessFile.seek(i);
                randomAccessFile.write(bArr);
                randomAccessFile.close();
                return;
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            file.createNewFile();
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }
        try {
            fileOutputStream = new java.io.FileOutputStream(file);
        } catch (java.io.FileNotFoundException e4) {
            e4.printStackTrace();
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                if (bArr != null) {
                    try {
                        fileOutputStream.write(bArr, 0, bArr.length);
                        fileOutputStream.flush();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    public static void writeFile(java.io.InputStream inputStream, int i, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        java.io.File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            io.dcloud.common.adapter.util.Logger.i(str + "cannot create!");
            return;
        }
        if (file.exists()) {
            try {
                java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rws");
                randomAccessFile.seek(file.length());
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = inputStream.read(bArr, 0, 8192);
                    if (i2 != -1) {
                        randomAccessFile.write(bArr, 0, i2);
                    } else {
                        randomAccessFile.close();
                        return;
                    }
                }
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
            }
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.io.FileNotFoundException e4) {
                e4.printStackTrace();
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    try {
                        byte[] bArr2 = new byte[8192];
                        while (true) {
                            int i3 = inputStream.read(bArr2, 0, 8192);
                            if (i3 == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr2, 0, i3);
                            }
                        }
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e6) {
                        e6.printStackTrace();
                    }
                }
            }
        }
    }

    public static int copyFile(java.lang.String str, java.lang.String str2) {
        return copyFile(str, str2, false, false, null);
    }

    public static int copyFile(java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        return copyFile(str, str2, false, false, iCallBack);
    }

    public static int copyFile(java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        return copyFile(str, str2, z, z2, null);
    }
}
