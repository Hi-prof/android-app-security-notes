package kotlin.time;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0015\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a)\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a)\u0010\u001c\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002\u001a\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001a\u0015\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u001d\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010/\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "substringWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "skipWhile", "NANOS_IN_MILLIS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long millisToNanos(long j) {
        return j * ((long) NANOS_IN_MILLIS);
    }

    public static final long toDuration(int i, kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(kotlin.time.DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(kotlin.time.DurationUnitKt.convertDurationUnitOverflow(i, unit, kotlin.time.DurationUnit.NANOSECONDS));
        }
        return toDuration(i, unit);
    }

    public static final long toDuration(long j, kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        long jConvertDurationUnitOverflow = kotlin.time.DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, kotlin.time.DurationUnit.NANOSECONDS, unit);
        if ((-jConvertDurationUnitOverflow) <= j && j <= jConvertDurationUnitOverflow) {
            return durationOfNanos(kotlin.time.DurationUnitKt.convertDurationUnitOverflow(j, unit, kotlin.time.DurationUnit.NANOSECONDS));
        }
        return durationOfMillis(kotlin.ranges.RangesKt.coerceIn(kotlin.time.DurationUnitKt.convertDurationUnit(j, unit, kotlin.time.DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }

    public static final long toDuration(double d, kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        double dConvertDurationUnit = kotlin.time.DurationUnitKt.convertDurationUnit(d, unit, kotlin.time.DurationUnit.NANOSECONDS);
        if (java.lang.Double.isNaN(dConvertDurationUnit)) {
            throw new java.lang.IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long jRoundToLong = kotlin.math.MathKt.roundToLong(dConvertDurationUnit);
        if (-4611686018426999999L <= jRoundToLong && jRoundToLong < 4611686018427000000L) {
            return durationOfNanos(jRoundToLong);
        }
        return durationOfMillisNormalized(kotlin.math.MathKt.roundToLong(kotlin.time.DurationUnitKt.convertDurationUnit(d, unit, kotlin.time.DurationUnit.MILLISECONDS)));
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m2034timesmvk6XK0(int i, long j) {
        return kotlin.time.Duration.m1968timesUwyO8pc(j, i);
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m2033timeskIfJnKk(double d, long j) {
        return kotlin.time.Duration.m1967timesUwyO8pc(j, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseDuration(java.lang.String str, boolean z) {
        int i;
        char cCharAt;
        char cCharAt2;
        int i2;
        int length = str.length();
        if (length == 0) {
            throw new java.lang.IllegalArgumentException("The string is empty");
        }
        long jM2028getZEROUwyO8pc = kotlin.time.Duration.INSTANCE.m2028getZEROUwyO8pc();
        char cCharAt3 = str.charAt(0);
        int length2 = (cCharAt3 == '+' || cCharAt3 == '-') ? 1 : 0;
        boolean z2 = length2 > 0;
        kotlin.time.DurationUnit durationUnit = null;
        boolean z3 = z2 && kotlin.text.StringsKt.startsWith$default((java.lang.CharSequence) str, '-', false, 2, (java.lang.Object) null);
        if (length <= length2) {
            throw new java.lang.IllegalArgumentException("No components");
        }
        char cCharAt4 = str.charAt(length2);
        char c = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
        char c2 = '0';
        if (cCharAt4 == 'P') {
            int i3 = length2 + 1;
            if (i3 == length) {
                throw new java.lang.IllegalArgumentException();
            }
            kotlin.time.DurationUnit durationUnit2 = null;
            boolean z4 = false;
            while (i3 < length) {
                if (str.charAt(i3) != 'T') {
                    int i4 = i3;
                    while (true) {
                        if (i4 >= str.length()) {
                            i2 = length;
                            break;
                        }
                        char cCharAt5 = str.charAt(i4);
                        if (c2 > cCharAt5 || cCharAt5 >= c) {
                            i2 = length;
                            if (!kotlin.text.StringsKt.contains$default((java.lang.CharSequence) "+-.", cCharAt5, false, 2, (java.lang.Object) null)) {
                                break;
                            }
                        } else {
                            i2 = length;
                        }
                        i4++;
                        length = i2;
                        c = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
                        c2 = '0';
                    }
                    kotlin.jvm.internal.Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    java.lang.String strSubstring = str.substring(i3, i4);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    java.lang.String str2 = strSubstring;
                    if (str2.length() == 0) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    int length3 = i3 + strSubstring.length();
                    java.lang.String str3 = str;
                    if (length3 < 0 || length3 >= str3.length()) {
                        throw new java.lang.IllegalArgumentException("Missing unit for value " + strSubstring);
                    }
                    char cCharAt6 = str3.charAt(length3);
                    i3 = length3 + 1;
                    kotlin.time.DurationUnit durationUnitDurationUnitByIsoChar = kotlin.time.DurationUnitKt.durationUnitByIsoChar(cCharAt6, z4);
                    if (durationUnit2 != null && durationUnit2.compareTo(durationUnitDurationUnitByIsoChar) <= 0) {
                        throw new java.lang.IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iIndexOf$default = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) str2, com.taobao.weex.el.parse.Operators.DOT, 0, false, 6, (java.lang.Object) null);
                    if (durationUnitDurationUnitByIsoChar == kotlin.time.DurationUnit.SECONDS && iIndexOf$default > 0) {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        java.lang.String strSubstring2 = strSubstring.substring(0, iIndexOf$default);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        long jM1966plusLRDsOJo = kotlin.time.Duration.m1966plusLRDsOJo(jM2028getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(strSubstring2), durationUnitDurationUnitByIsoChar));
                        kotlin.jvm.internal.Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        java.lang.String strSubstring3 = strSubstring.substring(iIndexOf$default);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                        jM2028getZEROUwyO8pc = kotlin.time.Duration.m1966plusLRDsOJo(jM1966plusLRDsOJo, toDuration(java.lang.Double.parseDouble(strSubstring3), durationUnitDurationUnitByIsoChar));
                    } else {
                        jM2028getZEROUwyO8pc = kotlin.time.Duration.m1966plusLRDsOJo(jM2028getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(strSubstring), durationUnitDurationUnitByIsoChar));
                    }
                    durationUnit2 = durationUnitDurationUnitByIsoChar;
                    length = i2;
                    c = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
                    c2 = '0';
                } else {
                    if (z4 || (i3 = i3 + 1) == length) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    z4 = true;
                }
            }
        } else {
            if (z) {
                throw new java.lang.IllegalArgumentException();
            }
            int iMax = java.lang.Math.max(length - length2, 8);
            char c3 = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
            if (kotlin.text.StringsKt.regionMatches(str, length2, "Infinity", 0, iMax, true)) {
                jM2028getZEROUwyO8pc = kotlin.time.Duration.INSTANCE.m2026getINFINITEUwyO8pc();
            } else {
                boolean z5 = !z2;
                if (z2 && str.charAt(length2) == '(' && kotlin.text.StringsKt.last(str) == ')') {
                    length2++;
                    int i5 = length - 1;
                    if (length2 == i5) {
                        throw new java.lang.IllegalArgumentException("No components");
                    }
                    i = i5;
                    z5 = true;
                } else {
                    i = length;
                }
                boolean z6 = false;
                while (length2 < i) {
                    if (z6 && z5) {
                        while (length2 < str.length() && str.charAt(length2) == ' ') {
                            length2++;
                        }
                    }
                    int i6 = length2;
                    while (i6 < str.length() && (('0' <= (cCharAt2 = str.charAt(i6)) && cCharAt2 < c3) || cCharAt2 == '.')) {
                        i6++;
                    }
                    kotlin.jvm.internal.Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    java.lang.String strSubstring4 = str.substring(length2, i6);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                    java.lang.String str4 = strSubstring4;
                    if (str4.length() == 0) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    int length4 = length2 + strSubstring4.length();
                    int i7 = length4;
                    while (i7 < str.length() && 'a' <= (cCharAt = str.charAt(i7)) && cCharAt < '{') {
                        i7++;
                    }
                    kotlin.jvm.internal.Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    java.lang.String strSubstring5 = str.substring(length4, i7);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                    length2 = length4 + strSubstring5.length();
                    kotlin.time.DurationUnit durationUnitDurationUnitByShortName = kotlin.time.DurationUnitKt.durationUnitByShortName(strSubstring5);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitDurationUnitByShortName) <= 0) {
                        throw new java.lang.IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iIndexOf$default2 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) str4, com.taobao.weex.el.parse.Operators.DOT, 0, false, 6, (java.lang.Object) null);
                    if (iIndexOf$default2 > 0) {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        java.lang.String strSubstring6 = strSubstring4.substring(0, iIndexOf$default2);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        long jM1966plusLRDsOJo2 = kotlin.time.Duration.m1966plusLRDsOJo(jM2028getZEROUwyO8pc, toDuration(java.lang.Long.parseLong(strSubstring6), durationUnitDurationUnitByShortName));
                        kotlin.jvm.internal.Intrinsics.checkNotNull(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        java.lang.String strSubstring7 = strSubstring4.substring(iIndexOf$default2);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        jM2028getZEROUwyO8pc = kotlin.time.Duration.m1966plusLRDsOJo(jM1966plusLRDsOJo2, toDuration(java.lang.Double.parseDouble(strSubstring7), durationUnitDurationUnitByShortName));
                        if (length2 < i) {
                            throw new java.lang.IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jM2028getZEROUwyO8pc = kotlin.time.Duration.m1966plusLRDsOJo(jM2028getZEROUwyO8pc, toDuration(java.lang.Long.parseLong(strSubstring4), durationUnitDurationUnitByShortName));
                    }
                    durationUnit = durationUnitDurationUnitByShortName;
                    z6 = true;
                    c3 = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
                }
            }
        }
        return z3 ? kotlin.time.Duration.m1981unaryMinusUwyO8pc(jM2028getZEROUwyO8pc) : jM2028getZEROUwyO8pc;
    }

    private static final long parseOverLongIsoComponent(java.lang.String str) {
        char cCharAt;
        int length = str.length();
        int i = (length <= 0 || !kotlin.text.StringsKt.contains$default((java.lang.CharSequence) "+-", str.charAt(0), false, 2, (java.lang.Object) null)) ? 0 : 1;
        if (length - i > 16) {
            int i2 = i;
            while (true) {
                if (i >= length) {
                    if (length - i2 <= 16) {
                        break;
                    }
                    return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == '0') {
                    if (i2 == i) {
                        i2++;
                    }
                } else if ('1' > cCharAt2 || cCharAt2 >= ':') {
                    break;
                }
                i++;
            }
        }
        return (!kotlin.text.StringsKt.startsWith$default(str, com.taobao.weex.el.parse.Operators.PLUS, false, 2, (java.lang.Object) null) || length <= 1 || '0' > (cCharAt = str.charAt(1)) || cCharAt >= ':') ? java.lang.Long.parseLong(str) : java.lang.Long.parseLong(kotlin.text.StringsKt.drop(str, 1));
    }

    private static final int skipWhile(java.lang.String str, int i, kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> function1) {
        while (i < str.length() && function1.invoke(java.lang.Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long nanosToMillis(long j) {
        return j / ((long) NANOS_IN_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanos(long j) {
        return kotlin.time.Duration.m1937constructorimpl(j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillis(long j) {
        return kotlin.time.Duration.m1937constructorimpl((j << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOf(long j, int i) {
        return kotlin.time.Duration.m1937constructorimpl((j << 1) + ((long) i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanosNormalized(long j) {
        if (-4611686018426999999L <= j && j < 4611686018427000000L) {
            return durationOfNanos(j);
        }
        return durationOfMillis(nanosToMillis(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillisNormalized(long j) {
        if (-4611686018426L <= j && j < 4611686018427L) {
            return durationOfNanos(millisToNanos(j));
        }
        return durationOfMillis(kotlin.ranges.RangesKt.coerceIn(j, -4611686018427387903L, MAX_MILLIS));
    }

    private static final java.lang.String substringWhile(java.lang.String str, int i, kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> function1) {
        int i2 = i;
        while (i2 < str.length() && function1.invoke(java.lang.Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        java.lang.String strSubstring = str.substring(i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
