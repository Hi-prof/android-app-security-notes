package io.dcloud.uts;

/* JADX INFO: compiled from: Math.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b*\n\u0002\u0010\u0011\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\b\u0010\"\u001a\u00020\u0005H\u0007J\u0012\u0010\"\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J!\u0010.\u001a\u00020\u00052\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000500\"\u00020\u0005H\u0007¢\u0006\u0002\u00101J!\u00102\u001a\u00020\u00052\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000500\"\u00020\u0005H\u0007¢\u0006\u0002\u00101J\u0018\u00103\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\b\u00104\u001a\u00020\u0005H\u0007J\u0010\u00105\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u00106\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u00107\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u00108\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u00109\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010:\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007¨\u0006="}, d2 = {"Lio/dcloud/uts/Math;", "", "<init>", "()V", "E", "", "getE", "()Ljava/lang/Number;", "PI", "getPI", "LN10", "getLN10", "LN2", "getLN2", "LOG10E", "getLOG10E", "LOG2E", "getLOG2E", "SQRT1_2", "getSQRT1_2", "SQRT2", "getSQRT2", "abs", com.taobao.weex.common.Constants.Name.X, "acos", "acosh", "asin", "asinh", "atan", "atanh", "atan2", com.taobao.weex.common.Constants.Name.Y, "cbrt", "ceil", "clz32", "cos", "cosh", "exp", "expm1", "floor", "fround", "hypot", "log", "log10", "log1p", "log2", "max", "values", "", "([Ljava/lang/Number;)Ljava/lang/Number;", com.taobao.weex.common.Constants.Name.MIN, "pow", "random", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ROUND, "sign", "sin", "sinh", "sqrt", "tan", "tanh", "trunc", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Math {
    public static final io.dcloud.uts.Math INSTANCE = new io.dcloud.uts.Math();
    private static final java.lang.Number E = java.lang.Double.valueOf(2.718281828459045d);
    private static final java.lang.Number PI = java.lang.Double.valueOf(3.141592653589793d);
    private static final java.lang.Number LN10 = java.lang.Double.valueOf(2.302585092994046d);
    private static final java.lang.Number LN2 = java.lang.Double.valueOf(0.6931471805599453d);
    private static final java.lang.Number LOG10E = java.lang.Double.valueOf(0.4342944819032518d);
    private static final java.lang.Number LOG2E = java.lang.Double.valueOf(1.4426950408889634d);
    private static final java.lang.Number SQRT1_2 = java.lang.Double.valueOf(0.7071067811865476d);
    private static final java.lang.Number SQRT2 = java.lang.Double.valueOf(1.4142135623730951d);

    private Math() {
    }

    public final java.lang.Number getE() {
        return E;
    }

    public final java.lang.Number getPI() {
        return PI;
    }

    public final java.lang.Number getLN10() {
        return LN10;
    }

    public final java.lang.Number getLN2() {
        return LN2;
    }

    public final java.lang.Number getLOG10E() {
        return LOG10E;
    }

    public final java.lang.Number getLOG2E() {
        return LOG2E;
    }

    public final java.lang.Number getSQRT1_2() {
        return SQRT1_2;
    }

    public final java.lang.Number getSQRT2() {
        return SQRT2;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number abs(java.lang.Number x) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Double) {
            numberValueOf = java.lang.Double.valueOf(java.lang.Math.abs(x.doubleValue()));
        } else if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf(java.lang.Math.abs(x.floatValue()));
        } else if (x instanceof java.lang.Integer) {
            numberValueOf = java.lang.Integer.valueOf(java.lang.Math.abs(x.intValue()));
        } else if (x instanceof java.lang.Long) {
            numberValueOf = java.lang.Long.valueOf(java.lang.Math.abs(x.longValue()));
        } else if (x instanceof java.lang.Byte) {
            numberValueOf = java.lang.Integer.valueOf(java.lang.Math.abs((int) x.byteValue()));
        } else if (x instanceof java.lang.Short) {
            numberValueOf = java.lang.Integer.valueOf(java.lang.Math.abs((int) x.shortValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(java.lang.Math.abs(x.doubleValue()));
        }
        return numberValueOf;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number acos(java.lang.Number x) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf((float) java.lang.Math.acos(x.floatValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(java.lang.Math.acos(x.doubleValue()));
        }
        return io.dcloud.uts.NumberKt.UTSNumber(numberValueOf);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number acosh(java.lang.Number x) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf((float) kotlin.math.MathKt.acosh(x.floatValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(kotlin.math.MathKt.acosh(x.doubleValue()));
        }
        return io.dcloud.uts.NumberKt.UTSNumber(numberValueOf);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number asin(java.lang.Number x) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf((float) java.lang.Math.asin(x.floatValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(java.lang.Math.asin(x.doubleValue()));
        }
        return io.dcloud.uts.NumberKt.UTSNumber(numberValueOf);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number asinh(java.lang.Number x) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf((float) kotlin.math.MathKt.asinh(x.floatValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(kotlin.math.MathKt.asinh(x.doubleValue()));
        }
        return io.dcloud.uts.NumberKt.UTSNumber(numberValueOf);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number atan(java.lang.Number x) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf((float) java.lang.Math.atan(x.floatValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(java.lang.Math.atan(x.doubleValue()));
        }
        return io.dcloud.uts.NumberKt.UTSNumber(numberValueOf);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number atanh(java.lang.Number x) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf((float) kotlin.math.MathKt.atanh(x.floatValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(kotlin.math.MathKt.atanh(x.doubleValue()));
        }
        return io.dcloud.uts.NumberKt.UTSNumber(numberValueOf);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number atan2(java.lang.Number x, java.lang.Number y) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(y, "y");
        return io.dcloud.uts.NumberKt.UTSNumber(java.lang.Double.valueOf(java.lang.Math.atan2(x.doubleValue(), y.doubleValue())));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number cbrt(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return io.dcloud.uts.NumberKt.UTSNumber(java.lang.Double.valueOf(java.lang.Math.pow(x.doubleValue(), 0.3333333333333333d)));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number ceil(java.lang.Number x) {
        java.lang.Number numberValueOf;
        java.lang.Number numberValueOf2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (kotlin.jvm.internal.Intrinsics.areEqual(x, io.dcloud.uts.NumberKt.getNaN())) {
            return x;
        }
        if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf((float) java.lang.Math.ceil(x.floatValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(java.lang.Math.ceil(x.doubleValue()));
        }
        java.lang.Number number = numberValueOf;
        if (io.dcloud.uts.NumberKt.compareTo(number, (java.lang.Number) Integer.MAX_VALUE) > 0 || io.dcloud.uts.NumberKt.compareTo(number, (java.lang.Number) Integer.MIN_VALUE) < 0) {
            numberValueOf2 = java.lang.Long.valueOf(number.longValue());
        } else {
            numberValueOf2 = java.lang.Integer.valueOf(number.intValue());
        }
        return numberValueOf2;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number clz32() {
        return (java.lang.Number) 32;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number clz32(java.lang.Number x) {
        if (x == null || kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSNumber.INSTANCE.getNaN(), x) || kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSNumber.INSTANCE.getPOSITIVE_INFINITY(), x) || kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSNumber.INSTANCE.getNEGATIVE_INFINITY(), x) || kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSNumber.INSTANCE.getMAX_VALUE(), x) || kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSNumber.INSTANCE.getMIN_VALUE(), x)) {
            return (java.lang.Number) 32;
        }
        int iM638constructorimpl = kotlin.UInt.m638constructorimpl(x.intValue());
        if (iM638constructorimpl == kotlin.UInt.m638constructorimpl(0)) {
            return (java.lang.Number) 32;
        }
        return java.lang.Integer.valueOf(32 - io.dcloud.uts.NumberKt.toString((java.lang.Number) java.lang.Long.valueOf(((long) iM638constructorimpl) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT), (java.lang.Number) 2).length());
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number cos(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            return java.lang.Float.valueOf((float) java.lang.Math.cos(x.floatValue()));
        }
        return java.lang.Double.valueOf(java.lang.Math.cos(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number cosh(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            return java.lang.Float.valueOf((float) java.lang.Math.cosh(x.floatValue()));
        }
        return java.lang.Double.valueOf(java.lang.Math.cosh(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number exp(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            return java.lang.Float.valueOf((float) java.lang.Math.exp(x.floatValue()));
        }
        return java.lang.Double.valueOf(java.lang.Math.exp(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number expm1(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            return java.lang.Float.valueOf((float) java.lang.Math.expm1(x.floatValue()));
        }
        return java.lang.Double.valueOf(java.lang.Math.expm1(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number floor(java.lang.Number x) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (x instanceof java.lang.Float) {
            numberValueOf = java.lang.Float.valueOf((float) java.lang.Math.floor(x.floatValue()));
        } else {
            numberValueOf = java.lang.Double.valueOf(java.lang.Math.floor(x.doubleValue()));
        }
        java.lang.Number number = numberValueOf;
        if (io.dcloud.uts.NumberKt.compareTo(number, (java.lang.Number) Integer.MAX_VALUE) > 0 || io.dcloud.uts.NumberKt.compareTo(number, (java.lang.Number) Integer.MIN_VALUE) < 0) {
            return java.lang.Long.valueOf(number.longValue());
        }
        return java.lang.Integer.valueOf(number.intValue());
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number fround(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Float.valueOf(x.floatValue());
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number hypot(java.lang.Number x, java.lang.Number y) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(y, "y");
        if ((x instanceof java.lang.Float) && (y instanceof java.lang.Float)) {
            return java.lang.Float.valueOf((float) java.lang.Math.hypot(x.floatValue(), y.floatValue()));
        }
        return java.lang.Double.valueOf(java.lang.Math.hypot(x.doubleValue(), y.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number log(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(java.lang.Math.log(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number log10(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(java.lang.Math.log10(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number log1p(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(java.lang.Math.log(io.dcloud.uts.NumberKt.plus(x, (java.lang.Number) 1).doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number log2(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(kotlin.math.MathKt.log2(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number max(java.lang.Number... values) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(values, "values");
        if (kotlin.collections.ArraysKt.contains(values, io.dcloud.uts.UTSNumber.INSTANCE.getNaN())) {
            return io.dcloud.uts.UTSNumber.INSTANCE.getNaN();
        }
        if (values.length == 0) {
            return (java.lang.Number) (-1);
        }
        java.lang.Number number = values[0];
        for (java.lang.Number number2 : values) {
            if (io.dcloud.uts.NumberKt.compareTo(number2, number) > 0) {
                number = number2;
            }
        }
        return number;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number min(java.lang.Number... values) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(values, "values");
        if (kotlin.collections.ArraysKt.contains(values, io.dcloud.uts.UTSNumber.INSTANCE.getNaN())) {
            return io.dcloud.uts.UTSNumber.INSTANCE.getNaN();
        }
        if (values.length == 0) {
            return (java.lang.Number) 0;
        }
        java.lang.Number number = values[0];
        for (java.lang.Number number2 : values) {
            if (io.dcloud.uts.NumberKt.compareTo(number2, number) < 0) {
                number = number2;
            }
        }
        return number;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number pow(java.lang.Number x, java.lang.Number y) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(y, "y");
        return java.lang.Double.valueOf(java.lang.Math.pow(x.doubleValue(), y.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number random() {
        return java.lang.Double.valueOf(kotlin.random.Random.INSTANCE.nextDouble());
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number round(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (kotlin.jvm.internal.Intrinsics.areEqual(x, io.dcloud.uts.UTSNumber.INSTANCE.getNaN()) || kotlin.jvm.internal.Intrinsics.areEqual(x, io.dcloud.uts.UTSNumber.INSTANCE.getPOSITIVE_INFINITY()) || kotlin.jvm.internal.Intrinsics.areEqual(x, io.dcloud.uts.UTSNumber.INSTANCE.getNEGATIVE_INFINITY()) || kotlin.jvm.internal.Intrinsics.areEqual(x, io.dcloud.uts.UTSNumber.INSTANCE.getMAX_VALUE())) {
            return x;
        }
        double dDoubleValue = x.doubleValue();
        if (dDoubleValue > 2.147483647E9d || dDoubleValue < -2.147483648E9d) {
            return java.lang.Long.valueOf(kotlin.math.MathKt.roundToLong(dDoubleValue));
        }
        return java.lang.Integer.valueOf(kotlin.math.MathKt.roundToInt(dDoubleValue));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number sign(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        if (io.dcloud.uts.NumberKt.compareTo(x, (java.lang.Number) 0) < 0) {
            return (java.lang.Number) (-1);
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) x, (java.lang.Object) 0)) {
            return (java.lang.Number) 0;
        }
        return (java.lang.Number) 1;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number sin(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(java.lang.Math.sin(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number sinh(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(java.lang.Math.sinh(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number sqrt(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(java.lang.Math.sqrt(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number tan(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(java.lang.Math.tan(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number tanh(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Double.valueOf(java.lang.Math.tanh(x.doubleValue()));
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number trunc(java.lang.Number x) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        return java.lang.Integer.valueOf(x.intValue());
    }
}
