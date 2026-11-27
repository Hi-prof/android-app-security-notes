package io.dcloud.uts;

/* JADX INFO: compiled from: Object.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lio/dcloud/uts/Object;", "", "<init>", "()V", "assign", "Lio/dcloud/uts/UTSJSONObject;", "arguments", "", "Lio/dcloud/uts/IUTSObject;", "([Lio/dcloud/uts/IUTSObject;)Lio/dcloud/uts/UTSJSONObject;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Object {
    public static final io.dcloud.uts.Object INSTANCE = new io.dcloud.uts.Object();

    private Object() {
    }

    public final io.dcloud.uts.UTSJSONObject assign(io.dcloud.uts.IUTSObject... arguments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        java.util.ArrayList arrayList = new java.util.ArrayList(arguments.length);
        for (io.dcloud.uts.IUTSObject iUTSObject : arguments) {
            uTSJSONObject.mergeOther(iUTSObject);
            arrayList.add(kotlin.Unit.INSTANCE);
        }
        return uTSJSONObject;
    }
}
