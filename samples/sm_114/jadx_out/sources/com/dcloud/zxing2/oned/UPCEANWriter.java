package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class UPCEANWriter extends com.dcloud.zxing2.oned.OneDimensionalCodeWriter {
    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter
    public int getDefaultMargin() {
        return com.dcloud.zxing2.oned.UPCEANReader.START_END_PATTERN.length;
    }
}
