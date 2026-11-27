package com.dcloud.zxing2.pdf417.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class BarcodeValue {
    private final java.util.Map<java.lang.Integer, java.lang.Integer> values = new java.util.HashMap();

    BarcodeValue() {
    }

    public java.lang.Integer getConfidence(int i) {
        return this.values.get(java.lang.Integer.valueOf(i));
    }

    int[] getValue() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int iIntValue = -1;
        for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry : this.values.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return com.dcloud.zxing2.pdf417.PDF417Common.toIntArray(arrayList);
    }

    void setValue(int i) {
        java.lang.Integer num = this.values.get(java.lang.Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.values.put(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(num.intValue() + 1));
    }
}
