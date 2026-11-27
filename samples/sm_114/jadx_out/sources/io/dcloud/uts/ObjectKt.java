package io.dcloud.uts;

/* JADX INFO: compiled from: Object.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\".\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0018\u00010\fj\u0004\u0018\u0001`\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"encodeURI", "", "input", "encodeURIComponent", "decodeURI", "decodeURIComponent", "btoa", "source", "atob", "encode", "globalError", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getGlobalError", "()Ljava/util/Map;", "setGlobalError", "(Ljava/util/Map;)V", "utsplugin_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ObjectKt {
    private static java.util.Map<java.lang.String, java.lang.Exception> globalError;

    public static final java.lang.String encodeURI(java.lang.String input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return io.dcloud.uts.android.UTSURLEncoder.encode$default(new io.dcloud.uts.android.UTSURLEncoder(false, 1, null), input, null, 2, null);
    }

    public static final java.lang.String encodeURIComponent(java.lang.String input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return io.dcloud.uts.android.UTSURLEncoder.encode$default(new io.dcloud.uts.android.UTSURLEncoder(true), input, null, 2, null);
    }

    public static final java.lang.String decodeURI(java.lang.String input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return io.dcloud.uts.android.UTSURLDecoder.decode$default(new io.dcloud.uts.android.UTSURLDecoder(false, 1, null), input, null, 2, null);
    }

    public static final java.lang.String decodeURIComponent(java.lang.String input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return io.dcloud.uts.android.UTSURLDecoder.decode$default(new io.dcloud.uts.android.UTSURLDecoder(false, 1, null), input, null, 2, null);
    }

    public static final java.lang.String btoa(java.lang.String source) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        byte[] bytes = source.getBytes(kotlin.text.Charsets.UTF_8);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        java.lang.String strEncodeToString = android.util.Base64.encodeToString(bytes, 2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public static final java.lang.String atob(java.lang.String encode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(encode, "encode");
        byte[] bArrDecode = android.util.Base64.decode(encode, 2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        java.nio.charset.Charset charsetDefaultCharset = java.nio.charset.Charset.defaultCharset();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        return new java.lang.String(bArrDecode, charsetDefaultCharset);
    }

    static {
        java.util.Map<java.lang.String, java.lang.Exception> mapSynchronizedMap = java.util.Collections.synchronizedMap(new java.util.WeakHashMap());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(...)");
        globalError = mapSynchronizedMap;
    }

    public static final java.util.Map<java.lang.String, java.lang.Exception> getGlobalError() {
        return globalError;
    }

    public static final void setGlobalError(java.util.Map<java.lang.String, java.lang.Exception> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<set-?>");
        globalError = map;
    }
}
