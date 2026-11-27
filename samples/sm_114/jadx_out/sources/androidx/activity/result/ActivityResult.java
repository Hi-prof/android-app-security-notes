package androidx.activity.result;

/* JADX INFO: compiled from: ActivityResult.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Landroidx/activity/result/ActivityResult;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", com.taobao.weex.common.WXModule.RESULT_CODE, "", "data", "Landroid/content/Intent;", "(ILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "getResultCode", "()I", "describeContents", "toString", "", "writeToParcel", "", "dest", "flags", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityResult implements android.os.Parcelable {
    private final android.content.Intent data;
    private final int resultCode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final androidx.activity.result.ActivityResult.Companion INSTANCE = new androidx.activity.result.ActivityResult.Companion(null);
    public static final android.os.Parcelable.Creator<androidx.activity.result.ActivityResult> CREATOR = new android.os.Parcelable.Creator<androidx.activity.result.ActivityResult>() { // from class: androidx.activity.result.ActivityResult$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.activity.result.ActivityResult createFromParcel(android.os.Parcel parcel) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new androidx.activity.result.ActivityResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.activity.result.ActivityResult[] newArray(int size) {
            return new androidx.activity.result.ActivityResult[size];
        }
    };

    @kotlin.jvm.JvmStatic
    public static final java.lang.String resultCodeToString(int i) {
        return INSTANCE.resultCodeToString(i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityResult(int i, android.content.Intent intent) {
        this.resultCode = i;
        this.data = intent;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final android.content.Intent getData() {
        return this.data;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActivityResult(android.os.Parcel parcel) {
        this(parcel.readInt(), parcel.readInt() == 0 ? null : (android.content.Intent) android.content.Intent.CREATOR.createFromParcel(parcel));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public java.lang.String toString() {
        return "ActivityResult{resultCode=" + INSTANCE.resultCodeToString(this.resultCode) + ", data=" + this.data + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel dest, int flags) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.resultCode);
        dest.writeInt(this.data == null ? 0 : 1);
        android.content.Intent intent = this.data;
        if (intent != null) {
            intent.writeToParcel(dest, flags);
        }
    }

    /* JADX INFO: compiled from: ActivityResult.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u000b"}, d2 = {"Landroidx/activity/result/ActivityResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/activity/result/ActivityResult;", "getCREATOR$annotations", "resultCodeToString", "", com.taobao.weex.common.WXModule.RESULT_CODE, "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final java.lang.String resultCodeToString(int resultCode) {
            if (resultCode == -1) {
                return "RESULT_OK";
            }
            if (resultCode == 0) {
                return "RESULT_CANCELED";
            }
            return java.lang.String.valueOf(resultCode);
        }
    }
}
