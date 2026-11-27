package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/UploadFileOptionFiles;", "Lio/dcloud/uts/UTSObject;", "name", "", "uri", "file", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getUri", "setUri", "getFile", "()Ljava/lang/Object;", "setFile", "(Ljava/lang/Object;)V", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UploadFileOptionFiles extends io.dcloud.uts.UTSObject {
    private java.lang.Object file;
    private java.lang.String name;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String uri;

    public /* synthetic */ UploadFileOptionFiles(java.lang.String str, java.lang.String str2, java.lang.Object obj, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2, (i & 4) != 0 ? null : obj);
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public java.lang.String getUri() {
        return this.uri;
    }

    public void setUri(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uri = str;
    }

    public java.lang.Object getFile() {
        return this.file;
    }

    public void setFile(java.lang.Object obj) {
        this.file = obj;
    }

    public UploadFileOptionFiles(java.lang.String str, java.lang.String uri, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        this.name = str;
        this.uri = uri;
        this.file = obj;
    }
}
