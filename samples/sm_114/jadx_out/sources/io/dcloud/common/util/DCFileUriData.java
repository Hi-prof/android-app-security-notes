package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCFileUriData {
    public java.lang.String filePath;
    public java.lang.String fileReplacePath;
    public android.net.Uri fileUri;
    public boolean isReplace = false;

    public void clear() {
        if (this.fileUri != null) {
            this.fileUri = null;
        }
        if (!android.text.TextUtils.isEmpty(this.filePath)) {
            this.filePath = null;
        }
        if (android.text.TextUtils.isEmpty(this.fileReplacePath)) {
            return;
        }
        this.fileReplacePath = null;
    }
}
