package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmVersionRequirement {
    private java.lang.Integer errorCode;
    public kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind kind;
    public kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel level;
    private java.lang.String message;
    public kotlin.reflect.jvm.internal.impl.km.KmVersion version;

    public final kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind getKind() {
        kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind kmVersionRequirementVersionKind = this.kind;
        if (kmVersionRequirementVersionKind != null) {
            return kmVersionRequirementVersionKind;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("kind");
        return null;
    }

    public final void setKind(kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind kmVersionRequirementVersionKind) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmVersionRequirementVersionKind, "<set-?>");
        this.kind = kmVersionRequirementVersionKind;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel getLevel() {
        kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel kmVersionRequirementLevel = this.level;
        if (kmVersionRequirementLevel != null) {
            return kmVersionRequirementLevel;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(androidtranscoder.format.MediaFormatExtraConstants.KEY_LEVEL);
        return null;
    }

    public final void setLevel(kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel kmVersionRequirementLevel) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmVersionRequirementLevel, "<set-?>");
        this.level = kmVersionRequirementLevel;
    }

    public final java.lang.Integer getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(java.lang.Integer num) {
        this.errorCode = num;
    }

    public final java.lang.String getMessage() {
        return this.message;
    }

    public final void setMessage(java.lang.String str) {
        this.message = str;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmVersion getVersion() {
        kotlin.reflect.jvm.internal.impl.km.KmVersion kmVersion = this.version;
        if (kmVersion != null) {
            return kmVersion;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("version");
        return null;
    }

    public final void setVersion(kotlin.reflect.jvm.internal.impl.km.KmVersion kmVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmVersion, "<set-?>");
        this.version = kmVersion;
    }

    public java.lang.String toString() {
        return "KmVersionRequirement(kind=" + getKind() + ", level=" + getLevel() + ", version=" + getVersion() + ", errorCode=" + this.errorCode + ", message=" + this.message + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
