package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public final class ExoSoSource extends com.facebook.soloader.UnpackingSoSource {
    public ExoSoSource(android.content.Context context, java.lang.String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public java.lang.String getName() {
        return "ExoSoSource";
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected java.security.MessageDigest getHashingAlgorithm() throws java.security.NoSuchAlgorithmException {
        return java.security.MessageDigest.getInstance("SHA-1");
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected com.facebook.soloader.UnpackingSoSource.Unpacker makeUnpacker(boolean z) throws java.io.IOException {
        return new com.facebook.soloader.ExoSoSource.ExoUnpacker(this);
    }

    private final class ExoUnpacker extends com.facebook.soloader.UnpackingSoSource.Unpacker {
        private final com.facebook.soloader.ExoSoSource.FileDso[] mDsos;

        /* JADX WARN: Bottom block not found for handler: all -> 0x010c */
        /* JADX WARN: Code duplicated, block: B:6:0x0049  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        ExoUnpacker(com.facebook.soloader.UnpackingSoSource r20) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 311
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.ExoSoSource.ExoUnpacker.<init>(com.facebook.soloader.ExoSoSource, com.facebook.soloader.UnpackingSoSource):void");
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public com.facebook.soloader.UnpackingSoSource.Dso[] getDsos() throws java.io.IOException {
            return this.mDsos;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public void unpack(java.io.File file) throws java.io.IOException {
            byte[] bArr = new byte[32768];
            for (com.facebook.soloader.ExoSoSource.FileDso fileDso : this.mDsos) {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(fileDso.backingFile);
                try {
                    com.facebook.soloader.UnpackingSoSource.InputDso inputDso = new com.facebook.soloader.UnpackingSoSource.InputDso(fileDso, fileInputStream);
                    fileInputStream = null;
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
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th3;
                }
            }
        }
    }

    private static final class FileDso extends com.facebook.soloader.UnpackingSoSource.Dso {
        final java.io.File backingFile;

        FileDso(java.lang.String str, java.lang.String str2, java.io.File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }
}
