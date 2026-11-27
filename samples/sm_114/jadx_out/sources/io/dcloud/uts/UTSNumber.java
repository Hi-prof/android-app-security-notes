package io.dcloud.uts;

/* JADX INFO: compiled from: Number.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0001J\u0010\u0010\u001f\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001J\u001a\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00182\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005J\u001a\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00182\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007¨\u0006$"}, d2 = {"Lio/dcloud/uts/UTSNumber;", "", "<init>", "()V", "MAX_SAFE_INTEGER", "", "getMAX_SAFE_INTEGER", "()Ljava/lang/Number;", "MIN_SAFE_INTEGER", "getMIN_SAFE_INTEGER", "EPSILON", "getEPSILON", "MAX_VALUE", "getMAX_VALUE", "MIN_VALUE", "getMIN_VALUE", "NaN", "getNaN", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "from", "str", "", "inputNum", "isNaN", "", "number", "isFinite", "isInteger", "isSafeInteger", "parseInt", "string", "radix", "parseFloat", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSNumber {
    public static final io.dcloud.uts.UTSNumber INSTANCE = new io.dcloud.uts.UTSNumber();
    private static final java.lang.Number MAX_SAFE_INTEGER = (java.lang.Number) 9007199254740991L;
    private static final java.lang.Number MIN_SAFE_INTEGER = (java.lang.Number) (-9007199254740991L);
    private static final java.lang.Number EPSILON = java.lang.Double.valueOf(2.220446049250313E-16d);
    private static final java.lang.Number MAX_VALUE = java.lang.Double.valueOf(Double.MAX_VALUE);
    private static final java.lang.Number MIN_VALUE = java.lang.Double.valueOf(Double.MIN_VALUE);
    private static final java.lang.Number NaN = java.lang.Double.valueOf(Double.NaN);
    private static final java.lang.Number NEGATIVE_INFINITY = java.lang.Double.valueOf(Double.NEGATIVE_INFINITY);
    private static final java.lang.Number POSITIVE_INFINITY = java.lang.Double.valueOf(Double.POSITIVE_INFINITY);

    public final java.lang.Number from(java.lang.Number inputNum) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputNum, "inputNum");
        return inputNum;
    }

    private UTSNumber() {
    }

    public final java.lang.Number getMAX_SAFE_INTEGER() {
        return MAX_SAFE_INTEGER;
    }

    public final java.lang.Number getMIN_SAFE_INTEGER() {
        return MIN_SAFE_INTEGER;
    }

    public final java.lang.Number getEPSILON() {
        return EPSILON;
    }

    public final java.lang.Number getMAX_VALUE() {
        return MAX_VALUE;
    }

    public final java.lang.Number getMIN_VALUE() {
        return MIN_VALUE;
    }

    public final java.lang.Number getNaN() {
        return NaN;
    }

    public final java.lang.Number getNEGATIVE_INFINITY() {
        return NEGATIVE_INFINITY;
    }

    public final java.lang.Number getPOSITIVE_INFINITY() {
        return POSITIVE_INFINITY;
    }

    public final java.lang.Number from(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "str");
        if (io.dcloud.uts.StringKt.includes$default(str, com.taobao.weex.el.parse.Operators.DOT_STR, null, 2, null) || io.dcloud.uts.StringKt.includes$default(str, "e", null, 2, null) || io.dcloud.uts.StringKt.includes$default(str, "E", null, 2, null)) {
            return java.lang.Double.valueOf(java.lang.Double.parseDouble(str));
        }
        try {
            try {
                try {
                    return java.lang.Integer.valueOf(java.lang.Integer.parseInt(str));
                } catch (java.lang.Exception unused) {
                    return java.lang.Double.valueOf(Double.NaN);
                }
            } catch (java.lang.NumberFormatException unused2) {
                return java.lang.Double.valueOf(java.lang.Double.parseDouble(str));
            }
        } catch (java.lang.Exception unused3) {
            return java.lang.Long.valueOf(java.lang.Long.parseLong(str));
        }
    }

    public final boolean isNaN(java.lang.Object number) {
        if (!(number instanceof java.lang.Number)) {
            return false;
        }
        java.lang.Number number2 = (java.lang.Number) number;
        if (number2 instanceof java.lang.Double) {
            return java.lang.Double.isNaN(number2.doubleValue());
        }
        if (number2 instanceof java.lang.Float) {
            return java.lang.Float.isNaN(number2.floatValue());
        }
        return false;
    }

    public final boolean isFinite(java.lang.Object number) {
        if (!(number instanceof java.lang.Number)) {
            return false;
        }
        java.lang.Number number2 = (java.lang.Number) number;
        if (number2 instanceof java.lang.Double) {
            return java.lang.Math.abs(number2.doubleValue()) <= Double.MAX_VALUE;
        }
        return !(number2 instanceof java.lang.Float) || java.lang.Math.abs(number2.floatValue()) <= Float.MAX_VALUE;
    }

    public final boolean isInteger(java.lang.Object inputNum) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputNum, "inputNum");
        if (!(inputNum instanceof java.lang.Number) || !isFinite(inputNum)) {
            return false;
        }
        if ((inputNum instanceof java.lang.Integer) || (inputNum instanceof java.lang.Long) || (inputNum instanceof java.lang.Short) || (inputNum instanceof java.lang.Byte)) {
            return true;
        }
        return kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.NumberKt.times(io.dcloud.uts.Math.floor((java.lang.Number) inputNum), java.lang.Double.valueOf(1.0d)), inputNum);
    }

    public final boolean isSafeInteger(java.lang.Object number) {
        if (!(number instanceof java.lang.Number)) {
            return false;
        }
        java.lang.Number number2 = (java.lang.Number) number;
        return io.dcloud.uts.NumberKt.compareTo(number2, MAX_SAFE_INTEGER) <= 0 && io.dcloud.uts.NumberKt.compareTo(number2, MIN_SAFE_INTEGER) >= 0;
    }

    public static /* synthetic */ java.lang.Number parseInt$default(io.dcloud.uts.UTSNumber uTSNumber, java.lang.String str, java.lang.Number number, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number = (java.lang.Number) 0;
        }
        return uTSNumber.parseInt(str, number);
    }

    public final java.lang.Number parseInt(java.lang.String string, java.lang.Number radix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        return io.dcloud.uts.NumberKt.parseInt(string, radix);
    }

    public static /* synthetic */ java.lang.Number parseFloat$default(io.dcloud.uts.UTSNumber uTSNumber, java.lang.String str, java.lang.Number number, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number = (java.lang.Number) 0;
        }
        return uTSNumber.parseFloat(str, number);
    }

    public final java.lang.Number parseFloat(java.lang.String string, java.lang.Number radix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        return io.dcloud.uts.NumberKt.parseFloat(string);
    }
}
