package io.dcloud.uts;

/* JADX INFO: compiled from: TextDecoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/dcloud/uts/TextDecoder;", "", "label", "", "<init>", "(Ljava/lang/String;)V", "encoding", "getEncoding", "()Ljava/lang/String;", "setEncoding", "supportEncoding", "", "getSupportEncoding", "getRes", "buffer", "Lio/dcloud/uts/ArrayBuffer;", "decode", "input", "Lio/dcloud/uts/TypedArray;", "Lio/dcloud/uts/DataView;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextDecoder {
    private java.lang.String encoding;
    private final java.util.List<java.lang.String> supportEncoding;

    public final java.lang.String getEncoding() {
        return this.encoding;
    }

    public final void setEncoding(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encoding = str;
    }

    public TextDecoder(java.lang.String str) {
        java.lang.String lowerCase;
        this.encoding = "utf-8";
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("utf-8");
        arrayList.add("gb2312");
        arrayList.add("gbk");
        this.supportEncoding = arrayList;
        this.encoding = (str == null || (lowerCase = io.dcloud.uts.StringKt.toLowerCase(str)) == null) ? this.encoding : lowerCase;
    }

    public /* synthetic */ TextDecoder(java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "utf-8" : str);
    }

    private final java.lang.String getSupportEncoding() {
        if (this.supportEncoding.indexOf(this.encoding) != -1) {
            for (java.lang.Object obj : this.supportEncoding) {
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.String) obj, this.encoding)) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
                    return (java.lang.String) obj;
                }
            }
            obj = null;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
            return (java.lang.String) obj;
        }
        return this.encoding;
    }

    private final java.lang.String getRes(io.dcloud.uts.ArrayBuffer buffer) {
        java.nio.ByteBuffer byteBuffer;
        java.nio.charset.CharsetDecoder charsetDecoderOnUnmappableCharacter = java.nio.charset.Charset.forName(getSupportEncoding()).newDecoder().onMalformedInput(java.nio.charset.CodingErrorAction.REPLACE).onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPLACE);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(charsetDecoderOnUnmappableCharacter, "onUnmappableCharacter(...)");
        if (buffer != null && (byteBuffer = buffer.getByteBuffer()) != null) {
            byteBuffer.rewind();
        }
        java.lang.String string = charsetDecoderOnUnmappableCharacter.decode(buffer != null ? buffer.getByteBuffer() : null).toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final java.lang.String decode(io.dcloud.uts.TypedArray input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return getRes(input.getBuffer());
    }

    public final java.lang.String decode(io.dcloud.uts.ArrayBuffer input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return getRes(input);
    }

    public final java.lang.String decode(io.dcloud.uts.DataView input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return getRes(input.getBuffer());
    }
}
