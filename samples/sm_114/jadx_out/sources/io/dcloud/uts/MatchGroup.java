package io.dcloud.uts;

/* JADX INFO: compiled from: UTSRegExp2.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lio/dcloud/uts/MatchGroup;", "", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MatchGroup {
    private final java.lang.String value;

    public static /* synthetic */ io.dcloud.uts.MatchGroup copy$default(io.dcloud.uts.MatchGroup matchGroup, java.lang.String str, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = matchGroup.value;
        }
        return matchGroup.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final java.lang.String getValue() {
        return this.value;
    }

    public final io.dcloud.uts.MatchGroup copy(java.lang.String value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        return new io.dcloud.uts.MatchGroup(value);
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof io.dcloud.uts.MatchGroup) && kotlin.jvm.internal.Intrinsics.areEqual(this.value, ((io.dcloud.uts.MatchGroup) other).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public java.lang.String toString() {
        return "MatchGroup(value=" + this.value + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public MatchGroup(java.lang.String value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final java.lang.String getValue() {
        return this.value;
    }
}
