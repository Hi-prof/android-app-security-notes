package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class BackupSoSource extends com.facebook.soloader.ExtractFromZipSoSource {
    private static final byte APK_SO_SOURCE_SIGNATURE_VERSION = 2;
    private static final byte LIBS_DIR_DOESNT_EXIST = 1;
    private static final byte LIBS_DIR_DONT_CARE = 0;
    private static final byte LIBS_DIR_SNAPSHOT = 2;
    public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
    private static final java.lang.String TAG = "BackupSoSource";
    private final int mFlags;

    public BackupSoSource(android.content.Context context, java.lang.String str, int i) {
        this(context, new java.io.File(context.getApplicationInfo().sourceDir), str, i);
    }

    public BackupSoSource(android.content.Context context, java.io.File file, java.lang.String str, int i) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.mFlags = i;
    }

    @Override // com.facebook.soloader.ExtractFromZipSoSource, com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public java.lang.String getName() {
        return TAG;
    }

    public boolean hasZippedLibs() throws java.io.IOException {
        com.facebook.soloader.BackupSoSource.ApkUnpacker apkUnpacker = new com.facebook.soloader.BackupSoSource.ApkUnpacker(this, false);
        try {
            boolean z = apkUnpacker.computeDsosFromZip().length != 0;
            apkUnpacker.close();
            return z;
        } catch (java.lang.Throwable th) {
            try {
                apkUnpacker.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.ExtractFromZipSoSource, com.facebook.soloader.UnpackingSoSource
    protected com.facebook.soloader.UnpackingSoSource.Unpacker makeUnpacker(boolean z) throws java.io.IOException {
        return new com.facebook.soloader.BackupSoSource.ApkUnpacker(this, z);
    }

    protected class ApkUnpacker extends com.facebook.soloader.ExtractFromZipSoSource.ZipUnpacker {
        private final int mFlags;
        private final boolean mForceUnpacking;
        private final java.io.File mLibDir;

        ApkUnpacker(com.facebook.soloader.ExtractFromZipSoSource extractFromZipSoSource, boolean z) throws java.io.IOException {
            super(extractFromZipSoSource);
            this.mForceUnpacking = z;
            this.mLibDir = new java.io.File(com.facebook.soloader.BackupSoSource.this.mContext.getApplicationInfo().nativeLibraryDir);
            this.mFlags = com.facebook.soloader.BackupSoSource.this.mFlags;
        }

        @Override // com.facebook.soloader.ExtractFromZipSoSource.ZipUnpacker
        protected com.facebook.soloader.ExtractFromZipSoSource.ZipDso[] getExtractableDsosFromZip() {
            if (this.mDsos != null) {
                return this.mDsos;
            }
            com.facebook.soloader.ExtractFromZipSoSource.ZipDso[] zipDsoArrComputeDsosFromZip = computeDsosFromZip();
            this.mDsos = zipDsoArrComputeDsosFromZip;
            if (this.mForceUnpacking) {
                com.facebook.soloader.LogUtil.w(com.facebook.soloader.BackupSoSource.TAG, "Unconditonally extracting all DSOs from zip");
                return this.mDsos;
            }
            if ((this.mFlags & 1) == 0) {
                com.facebook.soloader.LogUtil.w(com.facebook.soloader.BackupSoSource.TAG, "Self-extraction preferred (PREFER_ANDROID_LIBS_DRIECTORY not set)");
                return this.mDsos;
            }
            for (com.facebook.soloader.ExtractFromZipSoSource.ZipDso zipDso : zipDsoArrComputeDsosFromZip) {
                if (shouldExtract(zipDso.backingEntry, zipDso.name)) {
                    return this.mDsos;
                }
            }
            this.mDsos = new com.facebook.soloader.ExtractFromZipSoSource.ZipDso[0];
            return this.mDsos;
        }

        boolean shouldExtract(java.util.zip.ZipEntry zipEntry, java.lang.String str) {
            java.lang.String name = zipEntry.getName();
            java.io.File file = new java.io.File(this.mLibDir, str);
            try {
                if (!file.getCanonicalPath().startsWith(this.mLibDir.getCanonicalPath())) {
                    com.facebook.soloader.LogUtil.d(com.facebook.soloader.BackupSoSource.TAG, "Not allowing consideration of " + name + ": " + str + " not in lib dir.");
                    return false;
                }
                if (!file.isFile()) {
                    com.facebook.soloader.LogUtil.w(com.facebook.soloader.BackupSoSource.TAG, "Allowing consideration of " + name + ": " + str + " not in system lib dir");
                    return true;
                }
                long length = file.length();
                long size = zipEntry.getSize();
                if (length == size) {
                    com.facebook.soloader.LogUtil.w(com.facebook.soloader.BackupSoSource.TAG, "Not allowing consideration of " + name + ": deferring to libdir");
                    return false;
                }
                com.facebook.soloader.LogUtil.w(com.facebook.soloader.BackupSoSource.TAG, "Allowing consideration of " + file + ": sysdir file length is " + length + ", but the file is " + size + " bytes long in the APK");
                return true;
            } catch (java.io.IOException e) {
                com.facebook.soloader.LogUtil.w(com.facebook.soloader.BackupSoSource.TAG, "Not allowing consideration of " + name + ": " + str + ", IOException when constructing path: " + e.toString());
                return false;
            }
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected byte[] getDepsBlock() throws java.io.IOException {
        java.io.File canonicalFile = this.mZipFileName.getCanonicalFile();
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            parcelObtain.writeInt(com.facebook.soloader.SysUtil.getAppVersionCode(this.mContext));
            if ((this.mFlags & 1) == 0) {
                parcelObtain.writeByte((byte) 0);
                return parcelObtain.marshall();
            }
            java.lang.String str = this.mContext.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            java.io.File canonicalFile2 = new java.io.File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile2.getPath());
            parcelObtain.writeLong(canonicalFile2.lastModified());
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }
}
