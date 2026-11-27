package net.lingala.zip4j.util;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    public static final byte[] DEFAULT_POSIX_FILE_ATTRIBUTES = {0, 0, -92, -127};
    public static final byte[] DEFAULT_POSIX_FOLDER_ATTRIBUTES = {0, 0, -19, 65};

    public static void setFileAttributes(java.nio.file.Path path, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        if (isWindows()) {
            applyWindowsFileAttributes(path, bArr);
        } else if (isMac() || isUnix()) {
            applyPosixFileAttributes(path, bArr);
        }
    }

    public static void setFileLastModifiedTime(java.nio.file.Path path, long j) {
        if (j <= 0 || !java.nio.file.Files.exists(path, new java.nio.file.LinkOption[0])) {
            return;
        }
        try {
            java.nio.file.Files.setLastModifiedTime(path, java.nio.file.attribute.FileTime.fromMillis(net.lingala.zip4j.util.Zip4jUtil.dosToExtendedEpochTme(j)));
        } catch (java.lang.Exception unused) {
        }
    }

    public static void setFileLastModifiedTimeWithoutNio(java.io.File file, long j) {
        file.setLastModified(net.lingala.zip4j.util.Zip4jUtil.dosToExtendedEpochTme(j));
    }

    public static byte[] getFileAttributes(java.io.File file) {
        if (file != null) {
            try {
                if (java.nio.file.Files.isSymbolicLink(file.toPath()) || file.exists()) {
                    java.nio.file.Path path = file.toPath();
                    if (isWindows()) {
                        return getWindowsFileAttributes(path);
                    }
                    if (!isMac() && !isUnix()) {
                        return new byte[4];
                    }
                    return getPosixFileAttributes(path);
                }
            } catch (java.lang.NoSuchMethodError unused) {
                return new byte[4];
            }
        }
        return new byte[4];
    }

    public static java.util.List<java.io.File> getFilesInDirectoryRecursive(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input path is null, cannot read files in the directory");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File[] fileArrListFiles = file.listFiles();
        if (file.isDirectory() && file.canRead() && fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                if ((zipParameters.getExcludeFileFilter() == null || !zipParameters.getExcludeFileFilter().isExcluded(file2)) && (!file2.isHidden() || zipParameters.isReadHiddenFiles())) {
                    arrayList.add(file2);
                    net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction symbolicLinkAction = zipParameters.getSymbolicLinkAction();
                    boolean zIsSymbolicLink = isSymbolicLink(file2);
                    if ((zIsSymbolicLink && !net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(symbolicLinkAction)) || (!zIsSymbolicLink && file2.isDirectory())) {
                        arrayList.addAll(getFilesInDirectoryRecursive(file2, zipParameters));
                    }
                }
            }
        }
        return arrayList;
    }

    public static java.lang.String getFileNameWithoutExtension(java.lang.String str) {
        int iLastIndexOf = str.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR);
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public static java.lang.String getZipFileNameWithoutExtension(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("zip file name is empty or null, cannot determine zip file name");
        }
        if (str.contains(java.lang.System.getProperty("file.separator"))) {
            str = str.substring(str.lastIndexOf(java.lang.System.getProperty("file.separator")) + 1);
        }
        return str.endsWith(".zip") ? str.substring(0, str.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR)) : str;
    }

    public static java.util.List<java.io.File> getSplitZipFiles(net.lingala.zip4j.model.ZipModel zipModel) throws net.lingala.zip4j.exception.ZipException {
        java.lang.String str;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("cannot get split zip files: zipmodel is null");
        }
        if (zipModel.getEndOfCentralDirectoryRecord() == null) {
            return null;
        }
        if (!zipModel.getZipFile().exists()) {
            throw new net.lingala.zip4j.exception.ZipException("zip file does not exist");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File zipFile = zipModel.getZipFile();
        if (!zipModel.isSplitArchive()) {
            arrayList.add(zipFile);
            return arrayList;
        }
        int numberOfThisDisk = zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk();
        if (numberOfThisDisk == 0) {
            arrayList.add(zipFile);
            return arrayList;
        }
        for (int i = 0; i <= numberOfThisDisk; i++) {
            if (i == numberOfThisDisk) {
                arrayList.add(zipModel.getZipFile());
            } else {
                if (i < 9) {
                    str = ".z0";
                } else {
                    str = ".z";
                }
                arrayList.add(new java.io.File((zipFile.getName().contains(com.taobao.weex.el.parse.Operators.DOT_STR) ? zipFile.getPath().substring(0, zipFile.getPath().lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR)) : zipFile.getPath()) + str + (i + 1)));
            }
        }
        return arrayList;
    }

    public static java.lang.String getRelativeFileName(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        java.lang.String nameOfFileInZip;
        java.lang.String strSubstring;
        try {
            java.lang.String canonicalPath = file.getCanonicalPath();
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipParameters.getDefaultFolderPath())) {
                java.lang.String canonicalPath2 = new java.io.File(zipParameters.getDefaultFolderPath()).getCanonicalPath();
                if (!canonicalPath2.endsWith(net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR)) {
                    canonicalPath2 = canonicalPath2 + net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR;
                }
                if (isSymbolicLink(file)) {
                    strSubstring = new java.io.File(file.getParentFile().getCanonicalFile().getPath() + java.io.File.separator + file.getCanonicalFile().getName()).getPath().substring(canonicalPath2.length());
                } else if (!file.getCanonicalFile().getPath().startsWith(canonicalPath2)) {
                    strSubstring = file.getCanonicalFile().getParentFile().getName() + net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR + file.getCanonicalFile().getName();
                } else {
                    strSubstring = canonicalPath.substring(canonicalPath2.length());
                }
                if (strSubstring.startsWith(java.lang.System.getProperty("file.separator"))) {
                    strSubstring = strSubstring.substring(1);
                }
                java.io.File file2 = new java.io.File(canonicalPath);
                if (file2.isDirectory()) {
                    nameOfFileInZip = strSubstring.replaceAll("\\\\", "/") + "/";
                } else {
                    nameOfFileInZip = strSubstring.substring(0, strSubstring.lastIndexOf(file2.getName())).replaceAll("\\\\", "/") + getNameOfFileInZip(file2, zipParameters.getFileNameInZip());
                }
            } else {
                java.io.File file3 = new java.io.File(canonicalPath);
                nameOfFileInZip = getNameOfFileInZip(file3, zipParameters.getFileNameInZip());
                if (file3.isDirectory()) {
                    nameOfFileInZip = nameOfFileInZip + "/";
                }
            }
            java.lang.String rootFolderNameInZip = zipParameters.getRootFolderNameInZip();
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                if (!rootFolderNameInZip.endsWith("\\") && !rootFolderNameInZip.endsWith("/")) {
                    rootFolderNameInZip = rootFolderNameInZip + net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR;
                }
                rootFolderNameInZip = rootFolderNameInZip.replaceAll("\\\\", "/");
                nameOfFileInZip = rootFolderNameInZip + nameOfFileInZip;
            }
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(nameOfFileInZip)) {
                return nameOfFileInZip;
            }
            java.lang.String str = "fileName to add to zip is empty or null. fileName: '" + nameOfFileInZip + "' DefaultFolderPath: '" + zipParameters.getDefaultFolderPath() + "' FileNameInZip: " + zipParameters.getFileNameInZip();
            if (isSymbolicLink(file)) {
                str = str + "isSymlink: true ";
            }
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                str = "rootFolderNameInZip: '" + rootFolderNameInZip + "' ";
            }
            throw new net.lingala.zip4j.exception.ZipException(str);
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    private static java.lang.String getNameOfFileInZip(java.io.File file, java.lang.String str) throws java.io.IOException {
        if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            return str;
        }
        return isSymbolicLink(file) ? file.toPath().toRealPath(java.nio.file.LinkOption.NOFOLLOW_LINKS).getFileName().toString() : file.getName();
    }

    public static boolean isZipEntryDirectory(java.lang.String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    public static void copyFile(java.io.RandomAccessFile randomAccessFile, java.io.OutputStream outputStream, long j, long j2, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, int i) throws net.lingala.zip4j.exception.ZipException {
        byte[] bArr;
        long j3 = 0;
        if (j < 0 || j2 < 0 || j > j2) {
            throw new net.lingala.zip4j.exception.ZipException("invalid offsets");
        }
        if (j == j2) {
            return;
        }
        try {
            randomAccessFile.seek(j);
            long j4 = j2 - j;
            if (j4 < i) {
                bArr = new byte[(int) j4];
            } else {
                bArr = new byte[i];
            }
            while (true) {
                int i2 = randomAccessFile.read(bArr);
                if (i2 == -1) {
                    return;
                }
                outputStream.write(bArr, 0, i2);
                long j5 = i2;
                progressMonitor.updateWorkCompleted(j5);
                if (progressMonitor.isCancelAllTasks()) {
                    progressMonitor.setResult(net.lingala.zip4j.progress.ProgressMonitor.Result.CANCELLED);
                    return;
                }
                j3 += j5;
                if (j3 == j4) {
                    return;
                }
                if (((long) bArr.length) + j3 > j4) {
                    bArr = new byte[(int) (j4 - j3)];
                }
            }
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public static void assertFilesExist(java.util.List<java.io.File> list, net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction symbolicLinkAction) throws net.lingala.zip4j.exception.ZipException {
        for (java.io.File file : list) {
            if (isSymbolicLink(file)) {
                if (symbolicLinkAction.equals(net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINK_AND_LINKED_FILE) || symbolicLinkAction.equals(net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY)) {
                    assertSymbolicLinkTargetExists(file);
                }
            } else {
                assertFileExists(file);
            }
        }
    }

    public static boolean isNumberedSplitFile(java.io.File file) {
        return file.getName().endsWith(net.lingala.zip4j.util.InternalZipConstants.SEVEN_ZIP_SPLIT_FILE_EXTENSION_PATTERN);
    }

    public static java.lang.String getFileExtension(java.io.File file) {
        java.lang.String name = file.getName();
        if (!name.contains(com.taobao.weex.el.parse.Operators.DOT_STR)) {
            return "";
        }
        return name.substring(name.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR) + 1);
    }

    public static java.io.File[] getAllSortedNumberedSplitFiles(java.io.File file) {
        final java.lang.String fileNameWithoutExtension = getFileNameWithoutExtension(file.getName());
        java.io.File[] fileArrListFiles = file.getParentFile().listFiles(new java.io.FilenameFilter() { // from class: net.lingala.zip4j.util.FileUtils.1
            @Override // java.io.FilenameFilter
            public boolean accept(java.io.File file2, java.lang.String str) {
                return str.startsWith(fileNameWithoutExtension + com.taobao.weex.el.parse.Operators.DOT_STR);
            }
        });
        if (fileArrListFiles == null) {
            return new java.io.File[0];
        }
        java.util.Arrays.sort(fileArrListFiles);
        return fileArrListFiles;
    }

    public static java.lang.String getNextNumberedSplitFileCounterAsExtension(int i) {
        return com.taobao.weex.el.parse.Operators.DOT_STR + getExtensionZerosPrefix(i) + (i + 1);
    }

    public static boolean isSymbolicLink(java.io.File file) {
        try {
            return java.nio.file.Files.isSymbolicLink(file.toPath());
        } catch (java.lang.Error | java.lang.Exception unused) {
            return false;
        }
    }

    public static java.lang.String readSymbolicLink(java.io.File file) {
        try {
            return java.nio.file.Files.readSymbolicLink(file.toPath()).toString();
        } catch (java.lang.Error | java.lang.Exception unused) {
            return "";
        }
    }

    public static byte[] getDefaultFileAttributes(boolean z) {
        byte[] bArr = new byte[4];
        if (!isUnix() && !isMac()) {
            if (isWindows() && z) {
                bArr[0] = net.lingala.zip4j.util.BitUtils.setBit(bArr[0], 4);
            }
            return bArr;
        }
        if (z) {
            java.lang.System.arraycopy(DEFAULT_POSIX_FOLDER_ATTRIBUTES, 0, bArr, 0, 4);
            return bArr;
        }
        java.lang.System.arraycopy(DEFAULT_POSIX_FILE_ATTRIBUTES, 0, bArr, 0, 4);
        return bArr;
    }

    public static boolean isWindows() {
        return java.lang.System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean isMac() {
        return java.lang.System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean isUnix() {
        return java.lang.System.getProperty("os.name").toLowerCase().contains("nux");
    }

    private static java.lang.String getExtensionZerosPrefix(int i) {
        if (i < 9) {
            return "00";
        }
        if (i < 99) {
            return com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
        }
        return "";
    }

    private static void applyWindowsFileAttributes(java.nio.file.Path path, byte[] bArr) {
        java.nio.file.attribute.DosFileAttributeView dosFileAttributeViewM;
        if (bArr[0] == 0 || (dosFileAttributeViewM = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) java.nio.file.Files.getFileAttributeView(path, kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m$2(), java.nio.file.LinkOption.NOFOLLOW_LINKS))) == null) {
            return;
        }
        try {
            dosFileAttributeViewM.setReadOnly(net.lingala.zip4j.util.BitUtils.isBitSet(bArr[0], 0));
            dosFileAttributeViewM.setHidden(net.lingala.zip4j.util.BitUtils.isBitSet(bArr[0], 1));
            dosFileAttributeViewM.setSystem(net.lingala.zip4j.util.BitUtils.isBitSet(bArr[0], 2));
            dosFileAttributeViewM.setArchive(net.lingala.zip4j.util.BitUtils.isBitSet(bArr[0], 5));
        } catch (java.io.IOException unused) {
        }
    }

    private static void applyPosixFileAttributes(java.nio.file.Path path, byte[] bArr) {
        if (bArr[2] == 0 && bArr[3] == 0) {
            return;
        }
        try {
            java.util.HashSet hashSet = new java.util.HashSet();
            addIfBitSet(bArr[3], 0, hashSet, java.nio.file.attribute.PosixFilePermission.OWNER_READ);
            addIfBitSet(bArr[2], 7, hashSet, java.nio.file.attribute.PosixFilePermission.OWNER_WRITE);
            addIfBitSet(bArr[2], 6, hashSet, java.nio.file.attribute.PosixFilePermission.OWNER_EXECUTE);
            addIfBitSet(bArr[2], 5, hashSet, java.nio.file.attribute.PosixFilePermission.GROUP_READ);
            addIfBitSet(bArr[2], 4, hashSet, java.nio.file.attribute.PosixFilePermission.GROUP_WRITE);
            addIfBitSet(bArr[2], 3, hashSet, java.nio.file.attribute.PosixFilePermission.GROUP_EXECUTE);
            addIfBitSet(bArr[2], 2, hashSet, java.nio.file.attribute.PosixFilePermission.OTHERS_READ);
            addIfBitSet(bArr[2], 1, hashSet, java.nio.file.attribute.PosixFilePermission.OTHERS_WRITE);
            addIfBitSet(bArr[2], 0, hashSet, java.nio.file.attribute.PosixFilePermission.OTHERS_EXECUTE);
            java.nio.file.Files.setPosixFilePermissions(path, hashSet);
        } catch (java.io.IOException unused) {
        }
    }

    private static byte[] getWindowsFileAttributes(java.nio.file.Path path) {
        byte[] bArr = new byte[4];
        try {
            java.nio.file.attribute.DosFileAttributeView dosFileAttributeViewM = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) java.nio.file.Files.getFileAttributeView(path, kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m$2(), java.nio.file.LinkOption.NOFOLLOW_LINKS));
            if (dosFileAttributeViewM != null) {
                java.nio.file.attribute.DosFileAttributes attributes = dosFileAttributeViewM.readAttributes();
                bArr[0] = setBitIfApplicable(attributes.isArchive(), setBitIfApplicable(attributes.isDirectory(), setBitIfApplicable(attributes.isSystem(), setBitIfApplicable(attributes.isHidden(), setBitIfApplicable(attributes.isReadOnly(), (byte) 0, 0), 1), 2), 4), 5);
            }
        } catch (java.io.IOException unused) {
        }
        return bArr;
    }

    private static void assertFileExists(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file.exists()) {
            return;
        }
        throw new net.lingala.zip4j.exception.ZipException("File does not exist: " + file);
    }

    private static void assertSymbolicLinkTargetExists(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file.exists()) {
            return;
        }
        throw new net.lingala.zip4j.exception.ZipException("Symlink target '" + readSymbolicLink(file) + "' does not exist for link '" + file + "'");
    }

    private static byte[] getPosixFileAttributes(java.nio.file.Path path) {
        byte[] bArr = new byte[4];
        try {
            java.util.Set setPermissions = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m1876m((java.lang.Object) java.nio.file.Files.getFileAttributeView(path, kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m$1(), java.nio.file.LinkOption.NOFOLLOW_LINKS)).readAttributes().permissions();
            boolean zIsSymbolicLink = java.nio.file.Files.isSymbolicLink(path);
            if (zIsSymbolicLink) {
                byte bit = net.lingala.zip4j.util.BitUtils.setBit(bArr[3], 7);
                bArr[3] = bit;
                bArr[3] = net.lingala.zip4j.util.BitUtils.unsetBit(bit, 6);
            } else {
                bArr[3] = setBitIfApplicable(java.nio.file.Files.isRegularFile(path, new java.nio.file.LinkOption[0]), bArr[3], 7);
                bArr[3] = setBitIfApplicable(java.nio.file.Files.isDirectory(path, new java.nio.file.LinkOption[0]), bArr[3], 6);
            }
            bArr[3] = setBitIfApplicable(zIsSymbolicLink, bArr[3], 5);
            bArr[3] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.OWNER_READ), bArr[3], 0);
            bArr[2] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.OWNER_WRITE), bArr[2], 7);
            bArr[2] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.OWNER_EXECUTE), bArr[2], 6);
            bArr[2] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.GROUP_READ), bArr[2], 5);
            bArr[2] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.GROUP_WRITE), bArr[2], 4);
            bArr[2] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.GROUP_EXECUTE), bArr[2], 3);
            bArr[2] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.OTHERS_READ), bArr[2], 2);
            bArr[2] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.OTHERS_WRITE), bArr[2], 1);
            bArr[2] = setBitIfApplicable(setPermissions.contains(java.nio.file.attribute.PosixFilePermission.OTHERS_EXECUTE), bArr[2], 0);
        } catch (java.io.IOException unused) {
        }
        return bArr;
    }

    private static byte setBitIfApplicable(boolean z, byte b, int i) {
        return z ? net.lingala.zip4j.util.BitUtils.setBit(b, i) : b;
    }

    private static void addIfBitSet(byte b, int i, java.util.Set<java.nio.file.attribute.PosixFilePermission> set, java.nio.file.attribute.PosixFilePermission posixFilePermission) {
        if (net.lingala.zip4j.util.BitUtils.isBitSet(b, i)) {
            set.add(posixFilePermission);
        }
    }
}
