package io.dcloud.uts.android;

/* JADX INFO: compiled from: UTSURLEncoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/dcloud/uts/android/UTSURLEncoder;", "", "isComponent", "", "<init>", "(Z)V", "shouldNotNeedEncoding", "Ljava/util/BitSet;", "caseDiff", "", "dfltEncName", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "encode", "", "s", "charset", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSURLEncoder {
    private final int caseDiff;
    private java.nio.charset.Charset dfltEncName;
    private java.util.BitSet shouldNotNeedEncoding;

    public UTSURLEncoder(boolean z) {
        this.shouldNotNeedEncoding = new java.util.BitSet(256);
        this.caseDiff = 32;
        this.dfltEncName = java.nio.charset.Charset.forName("UTF-8");
        for (int i = 97; i < 123; i++) {
            this.shouldNotNeedEncoding.set(i);
        }
        for (int i2 = 65; i2 < 91; i2++) {
            this.shouldNotNeedEncoding.set(i2);
        }
        for (int i3 = 48; i3 < 58; i3++) {
            this.shouldNotNeedEncoding.set(i3);
        }
        java.lang.Character[] chArr = {' ', '-', '_', java.lang.Character.valueOf(com.taobao.weex.el.parse.Operators.DOT), '!', '~', '*', java.lang.Character.valueOf(com.taobao.weex.el.parse.Operators.SINGLE_QUOTE), java.lang.Character.valueOf(com.taobao.weex.el.parse.Operators.BRACKET_START), java.lang.Character.valueOf(com.taobao.weex.el.parse.Operators.BRACKET_END)};
        for (int i4 = 0; i4 < 10; i4++) {
            this.shouldNotNeedEncoding.set(chArr[i4].charValue());
        }
        if (z) {
            return;
        }
        java.lang.Character[] chArr2 = {';', java.lang.Character.valueOf(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR), '/', java.lang.Character.valueOf(com.taobao.weex.el.parse.Operators.CONDITION_IF), java.lang.Character.valueOf(com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE), java.lang.Character.valueOf(com.taobao.weex.ui.component.list.template.TemplateDom.SEPARATOR), java.lang.Character.valueOf(kotlin.text.Typography.amp), '=', '+', '$', '#'};
        for (int i5 = 0; i5 < 11; i5++) {
            this.shouldNotNeedEncoding.set(chArr2[i5].charValue());
        }
    }

    public /* synthetic */ UTSURLEncoder(boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public static /* synthetic */ java.lang.String encode$default(io.dcloud.uts.android.UTSURLEncoder uTSURLEncoder, java.lang.String str, java.nio.charset.Charset dfltEncName, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            dfltEncName = uTSURLEncoder.dfltEncName;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dfltEncName, "dfltEncName");
        }
        return uTSURLEncoder.encode(str, dfltEncName);
    }

    public final java.lang.String encode(java.lang.String s, java.nio.charset.Charset charset) {
        java.util.BitSet bitSet;
        int i;
        char cCharAt;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(s, "s");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charset, "charset");
        java.lang.StringBuilder sb = new java.lang.StringBuilder(s.length());
        java.io.CharArrayWriter charArrayWriter = new java.io.CharArrayWriter();
        int i2 = 0;
        boolean z = false;
        while (i2 < s.length()) {
            char cCharAt2 = s.charAt(i2);
            if (this.shouldNotNeedEncoding.get(cCharAt2)) {
                if (cCharAt2 == ' ') {
                    sb.append("%20");
                    z = true;
                } else {
                    sb.append(cCharAt2);
                }
                i2++;
            } else {
                do {
                    charArrayWriter.write(cCharAt2);
                    if (55296 <= cCharAt2 && cCharAt2 < 56320 && (i = i2 + 1) < s.length() && 56320 <= (cCharAt = s.charAt(i)) && cCharAt < 57344) {
                        charArrayWriter.write(cCharAt);
                        i2 = i;
                    }
                    i2++;
                    if (i2 >= s.length()) {
                        break;
                    }
                    bitSet = this.shouldNotNeedEncoding;
                    cCharAt2 = s.charAt(i2);
                } while (!bitSet.get(cCharAt2));
                charArrayWriter.flush();
                char[] charArray = charArrayWriter.toCharArray();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                byte[] bytes = new java.lang.String(charArray).getBytes(charset);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                int length = bytes.length;
                for (int i3 = 0; i3 < length; i3++) {
                    sb.append(com.taobao.weex.utils.WXUtils.PERCENT);
                    char cForDigit = java.lang.Character.forDigit((bytes[i3] >> 4) & 15, 16);
                    if (java.lang.Character.isLetter(cForDigit)) {
                        cForDigit = (char) (cForDigit - this.caseDiff);
                    }
                    sb.append(cForDigit);
                    char cForDigit2 = java.lang.Character.forDigit(bytes[i3] & 15, 16);
                    if (java.lang.Character.isLetter(cForDigit2)) {
                        cForDigit2 = (char) (cForDigit2 - this.caseDiff);
                    }
                    sb.append(cForDigit2);
                }
                charArrayWriter.reset();
                z = true;
            }
        }
        if (!z) {
            return s;
        }
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
