package com.dcloud.zxing2.pdf417;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class PDF417ResultMetadata {
    private java.lang.String fileId;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentIndex;

    public java.lang.String getFileId() {
        return this.fileId;
    }

    public int[] getOptionalData() {
        return this.optionalData;
    }

    public int getSegmentIndex() {
        return this.segmentIndex;
    }

    public boolean isLastSegment() {
        return this.lastSegment;
    }

    public void setFileId(java.lang.String str) {
        this.fileId = str;
    }

    public void setLastSegment(boolean z) {
        this.lastSegment = z;
    }

    public void setOptionalData(int[] iArr) {
        this.optionalData = iArr;
    }

    public void setSegmentIndex(int i) {
        this.segmentIndex = i;
    }
}
