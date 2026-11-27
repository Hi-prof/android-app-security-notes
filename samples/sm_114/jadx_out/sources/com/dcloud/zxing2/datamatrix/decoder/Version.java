package com.dcloud.zxing2.datamatrix.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Version {
    private static final com.dcloud.zxing2.datamatrix.decoder.Version[] VERSIONS = buildVersions();
    private final int dataRegionSizeColumns;
    private final int dataRegionSizeRows;
    private final com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks ecBlocks;
    private final int symbolSizeColumns;
    private final int symbolSizeRows;
    private final int totalCodewords;
    private final int versionNumber;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class ECB {
        private final int count;
        private final int dataCodewords;

        int getCount() {
            return this.count;
        }

        int getDataCodewords() {
            return this.dataCodewords;
        }

        private ECB(int i, int i2) {
            this.count = i;
            this.dataCodewords = i2;
        }
    }

    private Version(int i, int i2, int i3, int i4, int i5, com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks eCBlocks) {
        this.versionNumber = i;
        this.symbolSizeRows = i2;
        this.symbolSizeColumns = i3;
        this.dataRegionSizeRows = i4;
        this.dataRegionSizeColumns = i5;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int count = 0;
        for (com.dcloud.zxing2.datamatrix.decoder.Version.ECB ecb : eCBlocks.getECBlocks()) {
            count += ecb.getCount() * (ecb.getDataCodewords() + eCCodewords);
        }
        this.totalCodewords = count;
    }

    private static com.dcloud.zxing2.datamatrix.decoder.Version[] buildVersions() {
        int i = 1;
        int i2 = 5;
        int i3 = 8;
        com.dcloud.zxing2.datamatrix.decoder.Version version = new com.dcloud.zxing2.datamatrix.decoder.Version(1, 10, 10, 8, 8, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i2, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, 3)));
        com.dcloud.zxing2.datamatrix.decoder.Version version2 = new com.dcloud.zxing2.datamatrix.decoder.Version(2, 12, 12, 10, 10, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(7, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, i2)));
        com.dcloud.zxing2.datamatrix.decoder.Version version3 = new com.dcloud.zxing2.datamatrix.decoder.Version(3, 14, 14, 12, 12, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(10, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, i3)));
        int i4 = 12;
        com.dcloud.zxing2.datamatrix.decoder.Version version4 = new com.dcloud.zxing2.datamatrix.decoder.Version(4, 16, 16, 14, 14, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i4, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, i4)));
        com.dcloud.zxing2.datamatrix.decoder.Version version5 = new com.dcloud.zxing2.datamatrix.decoder.Version(5, 18, 18, 16, 16, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(14, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, 18)));
        com.dcloud.zxing2.datamatrix.decoder.Version version6 = new com.dcloud.zxing2.datamatrix.decoder.Version(6, 20, 20, 18, 18, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(18, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, 22)));
        com.dcloud.zxing2.datamatrix.decoder.Version version7 = new com.dcloud.zxing2.datamatrix.decoder.Version(7, 22, 22, 20, 20, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(20, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, 30)));
        int i5 = 36;
        com.dcloud.zxing2.datamatrix.decoder.Version version8 = new com.dcloud.zxing2.datamatrix.decoder.Version(8, 24, 24, 22, 22, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(24, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, i5)));
        com.dcloud.zxing2.datamatrix.decoder.Version version9 = new com.dcloud.zxing2.datamatrix.decoder.Version(9, 26, 26, 24, 24, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(28, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, 44)));
        int i6 = 62;
        com.dcloud.zxing2.datamatrix.decoder.Version version10 = new com.dcloud.zxing2.datamatrix.decoder.Version(10, 32, 32, 14, 14, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i5, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, i6)));
        com.dcloud.zxing2.datamatrix.decoder.Version version11 = new com.dcloud.zxing2.datamatrix.decoder.Version(11, 36, 36, 16, 16, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(42, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, 86)));
        com.dcloud.zxing2.datamatrix.decoder.Version version12 = new com.dcloud.zxing2.datamatrix.decoder.Version(12, 40, 40, 18, 18, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(48, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, uni.app.UNIGF0182AE.BuildConfig.VERSION_CODE)));
        int i7 = 56;
        com.dcloud.zxing2.datamatrix.decoder.Version version13 = new com.dcloud.zxing2.datamatrix.decoder.Version(13, 44, 44, 20, 20, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i7, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444)));
        int i8 = 68;
        com.dcloud.zxing2.datamatrix.decoder.Version version14 = new com.dcloud.zxing2.datamatrix.decoder.Version(14, 48, 48, 22, 22, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i8, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i, 174)));
        int i9 = 2;
        int i10 = 4;
        int i11 = 6;
        int i12 = 1;
        int i13 = 1;
        return new com.dcloud.zxing2.datamatrix.decoder.Version[]{version, version2, version3, version4, version5, version6, version7, version8, version9, version10, version11, version12, version13, version14, new com.dcloud.zxing2.datamatrix.decoder.Version(15, 52, 52, 24, 24, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(42, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i9, 102))), new com.dcloud.zxing2.datamatrix.decoder.Version(16, 64, 64, 14, 14, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i7, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i9, 140))), new com.dcloud.zxing2.datamatrix.decoder.Version(17, 72, 72, 16, 16, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i5, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i10, 92))), new com.dcloud.zxing2.datamatrix.decoder.Version(18, 80, 80, 18, 18, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(48, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i10, uni.app.UNIGF0182AE.BuildConfig.VERSION_CODE))), new com.dcloud.zxing2.datamatrix.decoder.Version(19, 88, 88, 20, 20, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i7, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i10, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444))), new com.dcloud.zxing2.datamatrix.decoder.Version(20, 96, 96, 22, 22, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i8, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i10, 174))), new com.dcloud.zxing2.datamatrix.decoder.Version(21, androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER, androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER, 24, 24, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i7, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i11, 136))), new com.dcloud.zxing2.datamatrix.decoder.Version(22, 120, 120, 18, 18, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i8, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i11, 175))), new com.dcloud.zxing2.datamatrix.decoder.Version(23, 132, 132, 20, 20, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i6, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i3, com.alibaba.fastjson.asm.Opcodes.IF_ICMPGT))), new com.dcloud.zxing2.datamatrix.decoder.Version(24, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 22, 22, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(i6, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i3, 156), new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i9, 155))), new com.dcloud.zxing2.datamatrix.decoder.Version(25, 8, 18, 6, 16, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(7, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i12, 5))), new com.dcloud.zxing2.datamatrix.decoder.Version(26, 8, 32, 6, 14, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(11, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i12, 10))), new com.dcloud.zxing2.datamatrix.decoder.Version(27, 12, 26, 10, 24, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(14, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i13, 16))), new com.dcloud.zxing2.datamatrix.decoder.Version(28, 12, 36, 10, 16, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(18, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(i13, 22))), new com.dcloud.zxing2.datamatrix.decoder.Version(29, 16, 36, 14, 16, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(24, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(1, 32))), new com.dcloud.zxing2.datamatrix.decoder.Version(30, 16, 48, 14, 22, new com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks(28, new com.dcloud.zxing2.datamatrix.decoder.Version.ECB(1, 49)))};
    }

    public static com.dcloud.zxing2.datamatrix.decoder.Version getVersionForDimensions(int i, int i2) throws com.dcloud.zxing2.FormatException {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        for (com.dcloud.zxing2.datamatrix.decoder.Version version : VERSIONS) {
            if (version.symbolSizeRows == i && version.symbolSizeColumns == i2) {
                return version;
            }
        }
        throw com.dcloud.zxing2.FormatException.getFormatInstance();
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(this.versionNumber);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class ECBlocks {
        private final com.dcloud.zxing2.datamatrix.decoder.Version.ECB[] ecBlocks;
        private final int ecCodewords;

        com.dcloud.zxing2.datamatrix.decoder.Version.ECB[] getECBlocks() {
            return this.ecBlocks;
        }

        int getECCodewords() {
            return this.ecCodewords;
        }

        private ECBlocks(int i, com.dcloud.zxing2.datamatrix.decoder.Version.ECB ecb) {
            this.ecCodewords = i;
            this.ecBlocks = new com.dcloud.zxing2.datamatrix.decoder.Version.ECB[]{ecb};
        }

        private ECBlocks(int i, com.dcloud.zxing2.datamatrix.decoder.Version.ECB ecb, com.dcloud.zxing2.datamatrix.decoder.Version.ECB ecb2) {
            this.ecCodewords = i;
            this.ecBlocks = new com.dcloud.zxing2.datamatrix.decoder.Version.ECB[]{ecb, ecb2};
        }
    }
}
