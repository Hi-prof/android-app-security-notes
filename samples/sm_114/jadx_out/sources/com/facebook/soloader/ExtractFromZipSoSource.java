package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class ExtractFromZipSoSource extends com.facebook.soloader.UnpackingSoSource {
    private static final java.lang.String TAG = "soloader.ExtractFromZipSoSource";
    protected final java.io.File mZipFileName;
    protected final java.lang.String mZipSearchPattern;

    public ExtractFromZipSoSource(android.content.Context context, java.lang.String str, java.io.File file, java.lang.String str2) {
        super(context, str);
        this.mZipFileName = file;
        this.mZipSearchPattern = str2;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public java.lang.String getName() {
        return "ExtractFromZipSoSource";
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected com.facebook.soloader.UnpackingSoSource.Unpacker makeUnpacker(boolean z) throws java.io.IOException {
        return new com.facebook.soloader.ExtractFromZipSoSource.ZipUnpacker(this);
    }

    protected class ZipUnpacker extends com.facebook.soloader.UnpackingSoSource.Unpacker {

        @javax.annotation.Nullable
        protected com.facebook.soloader.ExtractFromZipSoSource.ZipDso[] mDsos;
        private final com.facebook.soloader.UnpackingSoSource mSoSource;
        private final java.util.zip.ZipFile mZipFile;

        ZipUnpacker(com.facebook.soloader.UnpackingSoSource unpackingSoSource) throws java.io.IOException {
            this.mZipFile = new java.util.zip.ZipFile(com.facebook.soloader.ExtractFromZipSoSource.this.mZipFileName);
            this.mSoSource = unpackingSoSource;
        }

        com.facebook.soloader.ExtractFromZipSoSource.ZipDso[] computeDsosFromZip() {
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            java.util.HashMap map = new java.util.HashMap();
            java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(com.facebook.soloader.ExtractFromZipSoSource.this.mZipSearchPattern);
            java.lang.String[] supportedAbis = com.facebook.soloader.SysUtil.getSupportedAbis();
            java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = this.mZipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                java.util.regex.Matcher matcher = patternCompile.matcher(zipEntryNextElement.getName());
                if (matcher.matches()) {
                    java.lang.String strGroup = matcher.group(1);
                    java.lang.String strGroup2 = matcher.group(2);
                    int iFindAbiScore = com.facebook.soloader.SysUtil.findAbiScore(supportedAbis, strGroup);
                    if (iFindAbiScore >= 0) {
                        linkedHashSet.add(strGroup);
                        com.facebook.soloader.ExtractFromZipSoSource.ZipDso zipDso = (com.facebook.soloader.ExtractFromZipSoSource.ZipDso) map.get(strGroup2);
                        if (zipDso == null || iFindAbiScore < zipDso.abiScore) {
                            map.put(strGroup2, new com.facebook.soloader.ExtractFromZipSoSource.ZipDso(strGroup2, zipEntryNextElement, iFindAbiScore));
                        }
                    }
                }
            }
            this.mSoSource.setSoSourceAbis((java.lang.String[]) linkedHashSet.toArray(new java.lang.String[linkedHashSet.size()]));
            com.facebook.soloader.ExtractFromZipSoSource.ZipDso[] zipDsoArr = (com.facebook.soloader.ExtractFromZipSoSource.ZipDso[]) map.values().toArray(new com.facebook.soloader.ExtractFromZipSoSource.ZipDso[map.size()]);
            java.util.Arrays.sort(zipDsoArr);
            return zipDsoArr;
        }

        com.facebook.soloader.ExtractFromZipSoSource.ZipDso[] getExtractableDsosFromZip() {
            com.facebook.soloader.ExtractFromZipSoSource.ZipDso[] zipDsoArr = this.mDsos;
            if (zipDsoArr != null) {
                return zipDsoArr;
            }
            com.facebook.soloader.ExtractFromZipSoSource.ZipDso[] zipDsoArrComputeDsosFromZip = computeDsosFromZip();
            this.mDsos = zipDsoArrComputeDsosFromZip;
            return zipDsoArrComputeDsosFromZip;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.mZipFile.close();
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final com.facebook.soloader.UnpackingSoSource.Dso[] getDsos() throws java.io.IOException {
            return getExtractableDsosFromZip();
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public void unpack(java.io.File file) throws java.io.IOException {
            byte[] bArr = new byte[32768];
            for (com.facebook.soloader.ExtractFromZipSoSource.ZipDso zipDso : getExtractableDsosFromZip()) {
                java.io.InputStream inputStream = this.mZipFile.getInputStream(zipDso.backingEntry);
                try {
                    com.facebook.soloader.UnpackingSoSource.InputDso inputDso = new com.facebook.soloader.UnpackingSoSource.InputDso(zipDso, inputStream);
                    inputStream = null;
                    try {
                        extractDso(inputDso, bArr, file);
                        inputDso.close();
                    } catch (java.lang.Throwable th) {
                        try {
                            inputDso.close();
                        } catch (java.lang.Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th3) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected java.lang.String computeFileHash(java.io.File file) {
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        crc32.update(bArr, 0, i);
                    } else {
                        java.lang.String strValueOf = java.lang.String.valueOf(crc32.getValue());
                        fileInputStream.close();
                        return strValueOf;
                    }
                    com.facebook.soloader.LogUtil.w(TAG, "Failed to compute file hash ", e);
                    return "";
                }
            } catch (java.lang.Throwable th) {
                try {
                    fileInputStream.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (java.io.IOException e) {
            com.facebook.soloader.LogUtil.w(TAG, "Failed to compute file hash ", e);
            return "";
        }
    }

    protected static final class ZipDso extends com.facebook.soloader.UnpackingSoSource.Dso implements java.lang.Comparable<com.facebook.soloader.ExtractFromZipSoSource.ZipDso> {
        final int abiScore;
        final java.util.zip.ZipEntry backingEntry;

        ZipDso(java.lang.String str, java.util.zip.ZipEntry zipEntry, int i) {
            super(str, java.lang.String.valueOf(zipEntry.getCrc()));
            this.backingEntry = zipEntry;
            this.abiScore = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.facebook.soloader.ExtractFromZipSoSource.ZipDso zipDso) {
            return this.name.compareTo(zipDso.name);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                com.facebook.soloader.ExtractFromZipSoSource.ZipDso zipDso = (com.facebook.soloader.ExtractFromZipSoSource.ZipDso) obj;
                if (this.backingEntry.equals(zipDso.backingEntry) && this.abiScore == zipDso.abiScore) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.abiScore * 31) + this.backingEntry.hashCode();
        }
    }
}
