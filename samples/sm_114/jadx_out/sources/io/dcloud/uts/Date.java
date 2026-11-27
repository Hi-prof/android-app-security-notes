package io.dcloud.uts;

/* JADX INFO: compiled from: Date2.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001OB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\nBU\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0002\u0010\u0014J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u00100\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u00101\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J&\u00101\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005J\u000e\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\u001a\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005J\u000e\u00105\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005J\u000e\u00106\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u00108\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u001a\u00108\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u001a\u00109\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J&\u0010:\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J&\u0010;\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u000e\u0010<\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J2\u0010<\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J2\u0010=\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u000e\u0010>\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005J\u001a\u0010?\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005J&\u0010@\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005J\u0011\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0000H\u0096\u0002J\b\u0010D\u001a\u00020\tH\u0016J\u0006\u0010E\u001a\u00020\tJ\u0006\u0010F\u001a\u00020\tJ\u0006\u0010G\u001a\u00020\tJ\b\u0010H\u001a\u0004\u0018\u00010IJ\u0006\u0010J\u001a\u00020\tJ\u0006\u0010K\u001a\u00020\tJ\u0006\u0010L\u001a\u00020\tJ\u0006\u0010M\u001a\u00020\tJ\u0006\u0010N\u001a\u00020\tR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006P"}, d2 = {"Lio/dcloud/uts/Date;", "", "<init>", "()V", "value", "", "(Ljava/lang/Number;)V", "souceDate", "(Lio/dcloud/uts/Date;)V", "", "(Ljava/lang/String;)V", "year", "monthIndex", "day", "hours", "minutes", "seconds", "milliseconds", "isUTC", "", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Z)V", "dateDouble", "", "getDateDouble", "()D", "setDateDouble", "(D)V", "getTime", "valueOf", "getDate", "getUTCDate", "getYear", "getFullYear", "getUTCFullYear", "getMonth", "getUTCMonth", "getHours", "getUTCHours", "getMinutes", "getUTCMinutes", "getSeconds", "getUTCSeconds", "getMilliseconds", "getUTCMilliseconds", "getDay", "getUTCDay", "getTimezoneOffset", "setTime", "setYear", "setFullYear", "month", "date", "setMonth", "setDate", "setMilliseconds", "setUTCMilliseconds", "setSeconds", "setUTCSeconds", "setMinutes", "setUTCMinutes", "setHours", "setUTCHours", "setUTCDate", "setUTCMonth", "setUTCFullYear", "compareTo", "", "other", "toString", "toUTCString", "toGMTString", "toISOString", "toJSON", "", "toDateString", "toTimeString", "toLocaleString", "toLocaleDateString", "toLocaleTimeString", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Date implements java.lang.Comparable<io.dcloud.uts.Date> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.Date.Companion INSTANCE = new io.dcloud.uts.Date.Companion(null);
    private static final double MAX_TIME_VALUE = 8.64E15d;
    private double dateDouble;

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number UTC(java.lang.Number number, java.lang.Number number2, java.lang.Number number3, java.lang.Number number4, java.lang.Number number5, java.lang.Number number6, java.lang.Number number7) {
        return INSTANCE.UTC(number, number2, number3, number4, number5, number6, number7);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number now() {
        return INSTANCE.now();
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Number parse(java.lang.String str) {
        return INSTANCE.parse(str);
    }

    /* JADX INFO: compiled from: Date2.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007JJ\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/dcloud/uts/Date$Companion;", "", "<init>", "()V", "MAX_TIME_VALUE", "", "now", "", "parse", "value", "", "UTC", "year", "month", "day", "hour", "minute", "second", "millisecond", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final java.lang.Number now() {
            return new io.dcloud.uts.Date().getTime();
        }

        @kotlin.jvm.JvmStatic
        public final java.lang.Number parse(java.lang.String value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            return new io.dcloud.uts.Date(value).getTime();
        }

        public static /* synthetic */ java.lang.Number UTC$default(io.dcloud.uts.Date.Companion companion, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, java.lang.Number number4, java.lang.Number number5, java.lang.Number number6, java.lang.Number number7, int i, java.lang.Object obj) {
            if ((i & 4) != 0) {
                number3 = (java.lang.Number) 1;
            }
            java.lang.Number number8 = number3;
            if ((i & 8) != 0) {
                number4 = (java.lang.Number) 0;
            }
            java.lang.Number number9 = number4;
            if ((i & 16) != 0) {
                number5 = (java.lang.Number) 0;
            }
            java.lang.Number number10 = number5;
            if ((i & 32) != 0) {
                number6 = (java.lang.Number) 0;
            }
            return companion.UTC(number, number2, number8, number9, number10, number6, (i & 64) != 0 ? (java.lang.Number) 0 : number7);
        }

        @kotlin.jvm.JvmStatic
        public final java.lang.Number UTC(java.lang.Number year, java.lang.Number month, java.lang.Number day, java.lang.Number hour, java.lang.Number minute, java.lang.Number second, java.lang.Number millisecond) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(year, "year");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(month, "month");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(day, "day");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hour, "hour");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minute, "minute");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(second, "second");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(millisecond, "millisecond");
            double[] dArr = {0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d};
            java.lang.Number[] numberArr = {year, month, day, hour, minute, second, millisecond};
            for (int i = 0; i < 7; i++) {
                double dDoubleValue = numberArr[i].doubleValue();
                if (java.lang.Math.abs(dDoubleValue) > Double.MAX_VALUE) {
                    return java.lang.Double.valueOf(Double.NaN);
                }
                dArr[i] = java.lang.Math.floor(dDoubleValue);
            }
            double d = dArr[0];
            if (d >= 0.0d && d < 100.0d) {
                dArr[0] = d + ((double) 1900);
            }
            return java.lang.Double.valueOf(io.dcloud.uts.DateHolder.INSTANCE.setDateFields(dArr, false));
        }
    }

    public final double getDateDouble() {
        return this.dateDouble;
    }

    public final void setDateDouble(double d) {
        this.dateDouble = d;
    }

    public Date() {
        this.dateDouble = new java.util.Date().getTime();
    }

    public Date(java.lang.Number value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        this.dateDouble = value.doubleValue();
    }

    public Date(io.dcloud.uts.Date souceDate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(souceDate, "souceDate");
        this.dateDouble = souceDate.dateDouble;
    }

    public Date(java.lang.String value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        java.lang.Double andValidateDate = io.dcloud.uts.DateParser.INSTANCE.parseAndValidateDate(value);
        kotlin.jvm.internal.Intrinsics.checkNotNull(andValidateDate);
        this.dateDouble = andValidateDate.doubleValue();
    }

    public /* synthetic */ Date(java.lang.Number number, java.lang.Number number2, java.lang.Number number3, java.lang.Number number4, java.lang.Number number5, java.lang.Number number6, java.lang.Number number7, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(number, number2, (i & 4) != 0 ? (java.lang.Number) 1 : number3, (i & 8) != 0 ? (java.lang.Number) 0 : number4, (i & 16) != 0 ? (java.lang.Number) 0 : number5, (i & 32) != 0 ? (java.lang.Number) 0 : number6, (i & 64) != 0 ? (java.lang.Number) 0 : number7, (i & 128) != 0 ? false : z);
    }

    public Date(java.lang.Number year, java.lang.Number monthIndex, java.lang.Number day, java.lang.Number hours, java.lang.Number minutes, java.lang.Number seconds, java.lang.Number milliseconds, boolean z) {
        double dateFields;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(year, "year");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(monthIndex, "monthIndex");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(day, "day");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hours, "hours");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minutes, "minutes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(seconds, "seconds");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(milliseconds, "milliseconds");
        double[] dArr = new double[7];
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
        dArr[2] = 1.0d;
        java.lang.Number[] numberArr = {year, monthIndex, day, hours, minutes, seconds, milliseconds};
        int i = 0;
        while (true) {
            if (i < 7) {
                double dDoubleValue = numberArr[i].doubleValue();
                if (java.lang.Math.abs(dDoubleValue) > Double.MAX_VALUE) {
                    dateFields = Double.NaN;
                    break;
                }
                dArr[i] = kotlin.math.MathKt.truncate(dDoubleValue);
                if (i == 0) {
                    double d = dArr[0];
                    if (d >= 0.0d && d < 100.0d) {
                        dArr[0] = d + ((double) 1900) + d;
                    }
                }
                i++;
            } else {
                dateFields = io.dcloud.uts.DateHolder.INSTANCE.setDateFields(dArr, !z);
                break;
            }
        }
        this.dateDouble = dateFields;
    }

    public final java.lang.Number getTime() {
        return java.lang.Long.valueOf((long) this.dateDouble);
    }

    public final java.lang.Number valueOf() {
        return java.lang.Long.valueOf((long) this.dateDouble);
    }

    public final java.lang.Number getDate() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 33).intValue());
    }

    public final java.lang.Number getUTCDate() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 32).intValue());
    }

    public final java.lang.Number getYear() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 257).intValue());
    }

    public final java.lang.Number getFullYear() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 1).intValue());
    }

    public final java.lang.Number getUTCFullYear() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 0).intValue());
    }

    public final java.lang.Number getMonth() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 17).intValue());
    }

    public final java.lang.Number getUTCMonth() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 16).intValue());
    }

    public final java.lang.Number getHours() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 49).intValue());
    }

    public final java.lang.Number getUTCHours() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 48).intValue());
    }

    public final java.lang.Number getMinutes() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 65).intValue());
    }

    public final java.lang.Number getUTCMinutes() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 64).intValue());
    }

    public final java.lang.Number getSeconds() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 81).intValue());
    }

    public final java.lang.Number getUTCSeconds() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 80).intValue());
    }

    public final java.lang.Number getMilliseconds() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 97).intValue());
    }

    public final java.lang.Number getUTCMilliseconds() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 96).intValue());
    }

    public final java.lang.Number getDay() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 113).intValue());
    }

    public final java.lang.Number getUTCDay() {
        return java.lang.Integer.valueOf(io.dcloud.uts.DateHolder.INSTANCE.getDateField(this.dateDouble, 112).intValue());
    }

    public final java.lang.Number getTimezoneOffset() {
        if (java.lang.Double.isNaN(this.dateDouble)) {
            return java.lang.Double.valueOf(Double.NaN);
        }
        java.util.Date date = new java.util.Date((long) this.dateDouble);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        return java.lang.Integer.valueOf((-calendar.getTimeZone().getOffset((long) this.dateDouble)) / com.taobao.weex.common.WXRequest.DEFAULT_TIMEOUT_MS);
    }

    public final java.lang.Number setTime(java.lang.Number value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        double dDoubleValue = value.doubleValue();
        if (java.lang.Double.isNaN(dDoubleValue) || dDoubleValue > MAX_TIME_VALUE || dDoubleValue < -8.64E15d) {
            dDoubleValue = Double.NaN;
        }
        this.dateDouble = dDoubleValue;
        return java.lang.Double.valueOf(dDoubleValue);
    }

    public final java.lang.Number setYear(java.lang.Number year) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(year, "year");
        double dDoubleValue = year.doubleValue();
        if (java.lang.Double.isNaN(dDoubleValue)) {
            this.dateDouble = Double.NaN;
            return java.lang.Double.valueOf(Double.NaN);
        }
        double dFloor = java.lang.Math.floor(dDoubleValue);
        if (dFloor >= 0.0d && dFloor < 100.0d) {
            dFloor += (double) 1900;
        }
        double dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 17, java.lang.Double.valueOf(dFloor));
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setFullYear(java.lang.Number year) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(year, "year");
        return setFullYear(year, null, null);
    }

    public static /* synthetic */ java.lang.Number setFullYear$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        if ((i & 4) != 0) {
            number3 = null;
        }
        return date.setFullYear(number, number2, number3);
    }

    public final java.lang.Number setFullYear(java.lang.Number year, java.lang.Number month, java.lang.Number date) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(year, "year");
        if (month != null && date != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 49, year, month, date);
        } else if (month != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 49, year, month);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 49, year);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setMonth(java.lang.Number month) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(month, "month");
        return setMonth(month, null);
    }

    public static /* synthetic */ java.lang.Number setMonth$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        return date.setMonth(number, number2);
    }

    public final java.lang.Number setMonth(java.lang.Number month, java.lang.Number date) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(month, "month");
        if (date != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 305, month, date);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 305, month);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setDate(java.lang.Number date) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(date, "date");
        double dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 561, date);
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setMilliseconds(java.lang.Number milliseconds) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(milliseconds, "milliseconds");
        double dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1649, milliseconds);
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setUTCMilliseconds(java.lang.Number milliseconds) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(milliseconds, "milliseconds");
        double dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1648, milliseconds);
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setSeconds(java.lang.Number seconds) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(seconds, "seconds");
        return setSeconds(seconds, null);
    }

    public static /* synthetic */ java.lang.Number setSeconds$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        return date.setSeconds(number, number2);
    }

    public final java.lang.Number setSeconds(java.lang.Number seconds, java.lang.Number milliseconds) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(seconds, "seconds");
        if (milliseconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1393, seconds, milliseconds);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1393, seconds);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public static /* synthetic */ java.lang.Number setUTCSeconds$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        return date.setUTCSeconds(number, number2);
    }

    public final java.lang.Number setUTCSeconds(java.lang.Number seconds, java.lang.Number milliseconds) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(seconds, "seconds");
        if (milliseconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1392, seconds, milliseconds);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1392, seconds);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setMinutes(java.lang.Number minutes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minutes, "minutes");
        return setMinutes(minutes, null, null);
    }

    public static /* synthetic */ java.lang.Number setMinutes$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        if ((i & 4) != 0) {
            number3 = null;
        }
        return date.setMinutes(number, number2, number3);
    }

    public final java.lang.Number setMinutes(java.lang.Number minutes, java.lang.Number seconds, java.lang.Number milliseconds) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minutes, "minutes");
        if (seconds != null && milliseconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1137, minutes, seconds, milliseconds);
        } else if (seconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1137, minutes, seconds);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1137, minutes);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public static /* synthetic */ java.lang.Number setUTCMinutes$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        if ((i & 4) != 0) {
            number3 = null;
        }
        return date.setUTCMinutes(number, number2, number3);
    }

    public final java.lang.Number setUTCMinutes(java.lang.Number minutes, java.lang.Number seconds, java.lang.Number milliseconds) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minutes, "minutes");
        if (seconds != null && milliseconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1136, minutes, seconds, milliseconds);
        } else if (seconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1136, minutes, seconds);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 1136, minutes);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setHours(java.lang.Number hours) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hours, "hours");
        return setHours(hours, null, null, null);
    }

    public static /* synthetic */ java.lang.Number setHours$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, java.lang.Number number4, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        if ((i & 4) != 0) {
            number3 = null;
        }
        if ((i & 8) != 0) {
            number4 = null;
        }
        return date.setHours(number, number2, number3, number4);
    }

    public final java.lang.Number setHours(java.lang.Number hours, java.lang.Number minutes, java.lang.Number seconds, java.lang.Number milliseconds) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hours, "hours");
        if (minutes != null && seconds != null && milliseconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 881, hours, minutes, seconds, milliseconds);
        } else if (minutes != null && seconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 881, hours, minutes, seconds);
        } else if (minutes != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 881, hours, minutes);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 881, hours);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public static /* synthetic */ java.lang.Number setUTCHours$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, java.lang.Number number4, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        if ((i & 4) != 0) {
            number3 = null;
        }
        if ((i & 8) != 0) {
            number4 = null;
        }
        return date.setUTCHours(number, number2, number3, number4);
    }

    public final java.lang.Number setUTCHours(java.lang.Number hours, java.lang.Number minutes, java.lang.Number seconds, java.lang.Number milliseconds) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hours, "hours");
        if (minutes != null && seconds != null && milliseconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 880, hours, minutes, seconds, milliseconds);
        } else if (minutes != null && seconds != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 880, hours, minutes, seconds);
        } else if (minutes != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 880, hours, minutes);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 880, hours);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public final java.lang.Number setUTCDate(java.lang.Number date) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(date, "date");
        double dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 560, date);
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public static /* synthetic */ java.lang.Number setUTCMonth$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        return date.setUTCMonth(number, number2);
    }

    public final java.lang.Number setUTCMonth(java.lang.Number month, java.lang.Number date) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(month, "month");
        if (date != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 304, month, date);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 304, month);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    public static /* synthetic */ java.lang.Number setUTCFullYear$default(io.dcloud.uts.Date date, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number2 = null;
        }
        if ((i & 4) != 0) {
            number3 = null;
        }
        return date.setUTCFullYear(number, number2, number3);
    }

    public final java.lang.Number setUTCFullYear(java.lang.Number year, java.lang.Number month, java.lang.Number date) {
        double dateField;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(year, "year");
        if (month != null && date != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 48, year, month, date);
        } else if (month != null) {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 48, year, month);
        } else {
            dateField = io.dcloud.uts.DateHolder.INSTANCE.setDateField(this.dateDouble, 48, year);
        }
        this.dateDouble = dateField;
        return java.lang.Double.valueOf(dateField);
    }

    @Override // java.lang.Comparable
    public int compareTo(io.dcloud.uts.Date other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return java.lang.Double.compare(this.dateDouble, other.dateDouble);
    }

    public java.lang.String toString() {
        return io.dcloud.uts.DateParser.INSTANCE.getDateString(this.dateDouble, 19);
    }

    public final java.lang.String toUTCString() {
        return io.dcloud.uts.DateParser.INSTANCE.getDateString(this.dateDouble, 3);
    }

    public final java.lang.String toGMTString() {
        return toUTCString();
    }

    public final java.lang.String toISOString() {
        return io.dcloud.uts.DateParser.INSTANCE.getDateString(this.dateDouble, 35);
    }

    public final java.lang.Object toJSON() {
        if (java.lang.Math.abs(this.dateDouble) <= Double.MAX_VALUE) {
            return toISOString();
        }
        return null;
    }

    public final java.lang.String toDateString() {
        return io.dcloud.uts.DateParser.INSTANCE.getDateString(this.dateDouble, 17);
    }

    public final java.lang.String toTimeString() {
        return io.dcloud.uts.DateParser.INSTANCE.getDateString(this.dateDouble, 18);
    }

    public final java.lang.String toLocaleString() {
        return io.dcloud.uts.DateParser.INSTANCE.getDateString(this.dateDouble, 51);
    }

    public final java.lang.String toLocaleDateString() {
        return io.dcloud.uts.DateParser.INSTANCE.getDateString(this.dateDouble, 49);
    }

    public final java.lang.String toLocaleTimeString() {
        return io.dcloud.uts.DateParser.INSTANCE.getDateString(this.dateDouble, 50);
    }
}
