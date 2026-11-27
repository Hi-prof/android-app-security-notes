package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class ParsedResult {
    private final com.dcloud.zxing2.client.result.ParsedResultType type;

    protected ParsedResult(com.dcloud.zxing2.client.result.ParsedResultType parsedResultType) {
        this.type = parsedResultType;
    }

    public static void maybeAppend(java.lang.String str, java.lang.StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public abstract java.lang.String getDisplayResult();

    public final com.dcloud.zxing2.client.result.ParsedResultType getType() {
        return this.type;
    }

    public final java.lang.String toString() {
        return getDisplayResult();
    }

    public static void maybeAppend(java.lang.String[] strArr, java.lang.StringBuilder sb) {
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                maybeAppend(str, sb);
            }
        }
    }
}
