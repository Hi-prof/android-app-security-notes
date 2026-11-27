package io.dcloud.uts;

/* JADX INFO: compiled from: Date2.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J&\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J \u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J&\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J \u0010\"\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020\u0006J6\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J$\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J&\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006+"}, d2 = {"Lio/dcloud/uts/DateParser;", "", "<init>", "()V", "DAY_NAMES", "", "", "getDAY_NAMES", "()[Ljava/lang/String;", "[Ljava/lang/String;", "MONTH_NAMES", "getMONTH_NAMES", "getDateString", "dateDouble", "", "magic", "", "timeClip", "t", "parseAndValidateDate", "dateString", "(Ljava/lang/String;)Ljava/lang/Double;", "parseOtherString", "Lio/dcloud/uts/ISODateResult;", "skipSpaces", "", "str", "startPos", "parseMonth", "Lkotlin/Pair;", "matchString", "match", "parseTimeZoneAbbr", "skipSeparators", "skipUntil", "chars", "parseISOString", "isoString", "getDigits", "minDigits", "maxDigits", "parseMilliseconds", "parseTzOffset", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DateParser {
    public static final io.dcloud.uts.DateParser INSTANCE = new io.dcloud.uts.DateParser();
    private static final java.lang.String[] DAY_NAMES = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final java.lang.String[] MONTH_NAMES = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private DateParser() {
    }

    public final java.lang.String[] getDAY_NAMES() {
        return DAY_NAMES;
    }

    public final java.lang.String[] getMONTH_NAMES() {
        return MONTH_NAMES;
    }

    public final java.lang.String getDateString(double dateDouble, int magic) {
        int i;
        java.lang.String string;
        int i2 = magic >> 4;
        int i3 = i2 & 15;
        int i4 = magic & 15;
        double[] dateFields = io.dcloud.uts.DateHolder.INSTANCE.getDateFields(dateDouble, (i2 & 1) != 0, false);
        if (dateFields == null) {
            if (i3 != 2) {
                return "Invalid Date";
            }
            throw new java.lang.RuntimeException("Date value is NaN");
        }
        int i5 = (int) dateFields[0];
        int i6 = (int) dateFields[1];
        int i7 = (int) dateFields[2];
        int i8 = (int) dateFields[3];
        int i9 = (int) dateFields[4];
        int i10 = (int) dateFields[5];
        int i11 = (int) dateFields[6];
        int i12 = (int) dateFields[7];
        int i13 = (int) dateFields[8];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if ((magic & 1) != 0) {
            if (i3 == 0) {
                java.lang.String str = DAY_NAMES[i12];
                java.lang.String str2 = MONTH_NAMES[i6];
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(str);
                sb2.append(", ");
                sb2.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i7), 2, '0'));
                sb2.append(' ');
                sb2.append(str2);
                sb2.append(' ');
                sb2.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i5), (i5 < 0 ? 1 : 0) + 4, '0'));
                sb2.append(' ');
                sb.append(sb2.toString());
            } else if (i3 == 1) {
                java.lang.String str3 = DAY_NAMES[i12];
                java.lang.String str4 = MONTH_NAMES[i6];
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(str3);
                sb3.append(' ');
                sb3.append(str4);
                sb3.append(' ');
                sb3.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i7), 2, '0'));
                sb3.append(' ');
                sb3.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i5), (i5 < 0 ? 1 : 0) + 4, '0'));
                sb.append(sb3.toString());
                if (i4 == 3) {
                    sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
                }
            } else if (i3 == 2) {
                if (i5 >= 0) {
                    if (i <= 9999) {
                        i = i5;
                        string = kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i), 4, '0');
                    }
                    sb.append(string + '-' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i6 + 1), 2, '0') + '-' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i7), 2, '0') + 'T');
                } else {
                    i = i5;
                }
                i = i5;
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append(i >= 0 ? com.taobao.weex.el.parse.Operators.PLUS : "");
                sb4.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i), 6, '0'));
                string = sb4.toString();
                sb.append(string + '-' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i6 + 1), 2, '0') + '-' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i7), 2, '0') + 'T');
            } else if (i3 == 3) {
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                sb5.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i6 + 1), 2, '0'));
                sb5.append('/');
                sb5.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i7), 2, '0'));
                sb5.append('/');
                sb5.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i5), (i5 < 0 ? 1 : 0) + 4, '0'));
                sb.append(sb5.toString());
                if (i4 == 3) {
                    sb.append(", ");
                }
            }
        }
        if ((magic & 2) != 0) {
            if (i3 == 0) {
                sb.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i8), 2, '0') + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i9), 2, '0') + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i10), 2, '0') + " GMT");
            } else if (i3 == 1) {
                sb.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i8), 2, '0') + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i9), 2, '0') + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i10), 2, '0') + " GMT");
                if (i13 < 0) {
                    sb.append(com.taobao.weex.el.parse.Operators.SUB);
                    i13 = -i13;
                } else {
                    sb.append(com.taobao.weex.el.parse.Operators.PLUS);
                }
                sb.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i13 / 60), 2, '0') + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i13 % 60), 2, '0'));
            } else if (i3 == 2) {
                sb.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i8), 2, '0') + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i9), 2, '0') + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i10), 2, '0') + com.taobao.weex.el.parse.Operators.DOT + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i11), 3, '0') + 'Z');
            } else if (i3 == 3) {
                int i14 = ((i8 + 11) % 12) + 1;
                sb.append(kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i14), 2, '0') + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i9), 2, '0') + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i10), 2, '0') + ' ' + (i8 < 12 ? 'A' : 'P') + 'M');
            }
        }
        java.lang.String string2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    public final double timeClip(double t) {
        if (t < -8.64E15d || t > 8.64E15d) {
            return Double.NaN;
        }
        return kotlin.math.MathKt.truncate(t) + 0.0d;
    }

    public final java.lang.Double parseAndValidateDate(java.lang.String dateString) {
        int i;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dateString, "dateString");
        io.dcloud.uts.DateParser dateParser = INSTANCE;
        io.dcloud.uts.ISODateResult iSOString = dateParser.parseISOString(dateString);
        if (iSOString == null && (iSOString = dateParser.parseOtherString(dateString)) == null) {
            return null;
        }
        int[] fields = iSOString.getFields();
        boolean zIsLocal = iSOString.isLocal();
        int[] iArr = {0, 11, 31, 24, 59, 59};
        boolean z = true;
        int i2 = 1;
        while (true) {
            if (i2 >= 6) {
                break;
            }
            if (fields[i2] > iArr[i2]) {
                z = false;
                break;
            }
            i2++;
        }
        if (fields[3] == 24 && (fields[4] != 0 || fields[5] != 0 || fields[6] != 0)) {
            z = false;
        }
        if (!z) {
            return null;
        }
        double[] dArr = new double[7];
        for (i = 0; i < 7; i++) {
            dArr[i] = fields[i];
        }
        return java.lang.Double.valueOf(io.dcloud.uts.DateHolder.INSTANCE.setDateFields(dArr, zIsLocal) - (((double) fields[8]) * 60000.0d));
    }

    /* JADX WARN: Code duplicated, block: B:115:0x021e A[PHI: r10
  0x021e: PHI (r10v4 int) = (r10v3 int), (r10v7 int) binds: [B:109:0x01f7, B:114:0x021c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x0225  */
    /* JADX WARN: Code duplicated, block: B:119:0x023b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x023e  */
    /* JADX WARN: Code duplicated, block: B:194:0x023d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:0x0244 A[SYNTHETIC] */
    public final io.dcloud.uts.ISODateResult parseOtherString(java.lang.String dateString) {
        io.dcloud.uts.ISODateResult iSODateResult;
        kotlin.Pair<java.lang.Integer, java.lang.Integer> digits;
        int iIntValue;
        boolean z;
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dateString, "dateString");
        io.dcloud.uts.ISODateResult iSODateResult2 = null;
        io.dcloud.uts.ISODateResult iSODateResult3 = new io.dcloud.uts.ISODateResult(null, false, 3, null);
        int[] fields = iSODateResult3.getFields();
        int[] iArr = new int[3];
        fields[0] = 2001;
        fields[1] = 0;
        fields[2] = 1;
        for (int i = 3; i < 9; i++) {
            fields[i] = 0;
        }
        iSODateResult3.setLocal(true);
        int iIntValue2 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            iSODateResult = iSODateResult2;
            if (!skipSpaces(dateString, iIntValue2) || iIntValue2 >= dateString.length()) {
                break;
            }
            char cCharAt = dateString.charAt(iIntValue2);
            if (cCharAt == '+' || cCharAt == '-') {
                if (z2) {
                    kotlin.Pair<java.lang.Integer, java.lang.Integer> tzOffset = parseTzOffset(dateString, iIntValue2);
                    if (tzOffset != null) {
                        fields[8] = tzOffset.getFirst().intValue();
                        iIntValue2 = tzOffset.getSecond().intValue();
                        iSODateResult3.setLocal(false);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        continue;
                    } else {
                        iIntValue2++;
                        digits = getDigits(dateString, iIntValue2, 1, Integer.MAX_VALUE);
                        if (digits != null) {
                            iIntValue = digits.getFirst().intValue();
                            iIntValue2 = digits.getSecond().intValue();
                            if (cCharAt == '-') {
                                if (iIntValue == 0) {
                                    return iSODateResult;
                                }
                                iIntValue = -iIntValue;
                            }
                            fields[0] = iIntValue;
                            i2 = 1;
                        } else {
                            continue;
                        }
                    }
                } else {
                    iIntValue2++;
                    digits = getDigits(dateString, iIntValue2, 1, Integer.MAX_VALUE);
                    if (digits != null) {
                        iIntValue = digits.getFirst().intValue();
                        iIntValue2 = digits.getSecond().intValue();
                        if (cCharAt == '-') {
                            if (iIntValue == 0) {
                                return iSODateResult;
                            }
                            iIntValue = -iIntValue;
                        }
                        fields[0] = iIntValue;
                        i2 = 1;
                    } else {
                        continue;
                    }
                }
            } else if ('0' <= cCharAt && cCharAt < ':') {
                kotlin.Pair<java.lang.Integer, java.lang.Integer> digits2 = getDigits(dateString, iIntValue2, 1, Integer.MAX_VALUE);
                if (digits2 != null) {
                    int iIntValue3 = digits2.component1().intValue();
                    int iIntValue4 = digits2.component2().intValue();
                    if (iIntValue4 >= dateString.length() || dateString.charAt(iIntValue4) != ':') {
                        if (iIntValue4 - iIntValue2 > 2) {
                            fields[0] = iIntValue3;
                        } else if (iIntValue3 < 1 || iIntValue3 > 31) {
                            fields[0] = iIntValue3 + (iIntValue3 >= 100 ? 0 : 1900) + (iIntValue3 < 50 ? 100 : 0);
                        } else {
                            if (i3 >= 3) {
                                return iSODateResult;
                            }
                            iArr[i3] = iIntValue3;
                            iIntValue2 = iIntValue4;
                            i3++;
                        }
                        iIntValue2 = iIntValue4;
                        i2 = 1;
                    } else {
                        fields[3] = iIntValue3;
                        io.dcloud.uts.DateParser dateParser = INSTANCE;
                        kotlin.Pair<java.lang.Integer, java.lang.Integer> digits3 = dateParser.getDigits(dateString, iIntValue4 + 1, 1, 2);
                        if (digits3 == null) {
                            return iSODateResult;
                        }
                        int iIntValue5 = digits3.component1().intValue();
                        int iIntValue6 = digits3.component2().intValue();
                        fields[4] = iIntValue5;
                        if (iIntValue6 < dateString.length() && dateString.charAt(iIntValue6) == ':') {
                            kotlin.Pair<java.lang.Integer, java.lang.Integer> digits4 = dateParser.getDigits(dateString, iIntValue6 + 1, 1, 2);
                            if (digits4 == null) {
                                return iSODateResult;
                            }
                            int iIntValue7 = digits4.component1().intValue();
                            iIntValue6 = digits4.component2().intValue();
                            fields[5] = iIntValue7;
                            if (iIntValue6 < dateString.length() && dateString.charAt(iIntValue6) == '.') {
                                kotlin.Pair<java.lang.Integer, java.lang.Integer> milliseconds = dateParser.parseMilliseconds(dateString, iIntValue6 + 1);
                                fields[6] = milliseconds.getFirst().intValue();
                                iIntValue6 = milliseconds.getSecond().intValue();
                            }
                        }
                        iIntValue2 = iIntValue6;
                        z2 = true;
                    }
                } else {
                    continue;
                }
            } else {
                kotlin.Pair<java.lang.Integer, java.lang.Integer> month = parseMonth(dateString, iIntValue2);
                if (month != null) {
                    int iIntValue8 = month.component1().intValue();
                    int iIntValue9 = month.component2().intValue();
                    fields[1] = iIntValue8;
                    iIntValue2 = INSTANCE.skipUntil(dateString, iIntValue9, "0123456789 -/(");
                    i4 = 1;
                    z3 = true;
                } else {
                    if (z2 && matchString(dateString, iIntValue2, "PM")) {
                        int i5 = fields[3];
                        if (i5 != 12) {
                            fields[3] = i5 + 12;
                        }
                    } else if (z2 && matchString(dateString, iIntValue2, "AM")) {
                        int i6 = fields[3];
                        if (i6 > 12) {
                            return iSODateResult;
                        }
                        if (i6 == 12) {
                            fields[3] = 0;
                        }
                    } else {
                        kotlin.Pair<java.lang.Integer, java.lang.Integer> timeZoneAbbr = parseTimeZoneAbbr(dateString, iIntValue2);
                        if (timeZoneAbbr != null) {
                            int iIntValue10 = timeZoneAbbr.component1().intValue();
                            iIntValue2 = timeZoneAbbr.component2().intValue();
                            fields[8] = iIntValue10;
                            iSODateResult3.setLocal(false);
                            obj = kotlin.Unit.INSTANCE;
                        } else {
                            obj = iSODateResult;
                        }
                        if (obj != null) {
                            continue;
                        } else if (cCharAt == '(') {
                            iIntValue2++;
                            int i7 = 0;
                            while (iIntValue2 < dateString.length()) {
                                int i8 = iIntValue2 + 1;
                                char cCharAt2 = dateString.charAt(iIntValue2);
                                if (cCharAt2 == '(') {
                                    i7++;
                                }
                                if (cCharAt2 == ')') {
                                    i7--;
                                }
                                iIntValue2 = i8;
                                if (i7 <= 0) {
                                    break;
                                }
                            }
                            if (i7 > 0) {
                                return iSODateResult;
                            }
                        } else {
                            if (cCharAt == ')' || i2 != 0 || i4 != 0 || z2 || i3 > 0) {
                                return iSODateResult;
                            }
                            iIntValue2 = skipUntil(dateString, iIntValue2 + 1, " -/(");
                        }
                    }
                    iIntValue2 += 2;
                }
            }
            iIntValue2 = skipSeparators(dateString, iIntValue2);
            iSODateResult2 = iSODateResult;
        }
        if (i3 + i2 + i4 > 3) {
            return iSODateResult;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        int i9 = iArr[2];
                        fields[0] = i9 + (i9 >= 100 ? 0 : 1900) + (i9 < 50 ? 100 : 0);
                        int i10 = iArr[0];
                        fields[1] = i10;
                        if (!z3) {
                            fields[1] = i10 - 1;
                        }
                        fields[2] = iArr[1];
                    }
                } else if (i2 != 0) {
                    int i11 = iArr[0];
                    fields[1] = i11;
                    if (!z3) {
                        fields[1] = i11 - 1;
                    }
                    fields[2] = iArr[1];
                } else if (i4 != 0) {
                    int i12 = iArr[1];
                    fields[0] = i12 + (i12 >= 100 ? 0 : 1900) + (i12 >= 50 ? 0 : 100);
                    fields[2] = iArr[0];
                } else {
                    int i13 = iArr[0];
                    fields[1] = i13;
                    if (!z3) {
                        fields[1] = i13 - 1;
                    }
                    fields[2] = iArr[1];
                }
            } else if (i4 != 0) {
                fields[2] = iArr[0];
            } else {
                int i14 = iArr[0];
                fields[1] = i14;
                if (!z3) {
                    fields[1] = i14 - 1;
                }
            }
        } else if (i2 == 0) {
            return iSODateResult;
        }
        int i15 = fields[1];
        return (i15 < 0 || i15 > 11) ? iSODateResult : iSODateResult3;
    }

    private final boolean skipSpaces(java.lang.String str, int startPos) {
        while (startPos < str.length() && kotlin.text.CharsKt.isWhitespace(str.charAt(startPos))) {
            startPos++;
        }
        return startPos < str.length();
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> parseMonth(java.lang.String str, int startPos) {
        java.lang.String[] strArr = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        for (int i = 0; i < 12; i++) {
            java.lang.String str2 = strArr[i];
            if (str2.length() + startPos <= str.length()) {
                java.lang.String lowerCase = io.dcloud.uts.StringKt.substring(str, java.lang.Integer.valueOf(startPos), java.lang.Integer.valueOf(str2.length() + startPos)).toLowerCase(java.util.Locale.ROOT);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (kotlin.jvm.internal.Intrinsics.areEqual(lowerCase, str2)) {
                    return new kotlin.Pair<>(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(startPos + str2.length()));
                }
            }
        }
        return null;
    }

    private final boolean matchString(java.lang.String str, int startPos, java.lang.String match) {
        return match.length() + startPos <= str.length() && kotlin.text.StringsKt.equals(io.dcloud.uts.StringKt.substring(str, java.lang.Integer.valueOf(startPos), java.lang.Integer.valueOf(startPos + match.length())), match, true);
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> parseTimeZoneAbbr(java.lang.String str, int startPos) {
        for (java.util.Map.Entry entry : kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to("ut", 0), kotlin.TuplesKt.to("utc", 0), kotlin.TuplesKt.to("gmt", 0), kotlin.TuplesKt.to("est", -300), kotlin.TuplesKt.to("edt", -240), kotlin.TuplesKt.to("cst", -360), kotlin.TuplesKt.to("cdt", -300), kotlin.TuplesKt.to("mst", -420), kotlin.TuplesKt.to("mdt", -360), kotlin.TuplesKt.to("pst", -480), kotlin.TuplesKt.to("pdt", -420)).entrySet()) {
            java.lang.String str2 = (java.lang.String) entry.getKey();
            int iIntValue = ((java.lang.Number) entry.getValue()).intValue();
            if (matchString(str, startPos, str2)) {
                return new kotlin.Pair<>(java.lang.Integer.valueOf(iIntValue), java.lang.Integer.valueOf(startPos + str2.length()));
            }
        }
        return null;
    }

    private final int skipSeparators(java.lang.String str, int startPos) {
        while (startPos < str.length() && (str.charAt(startPos) == ' ' || str.charAt(startPos) == ',' || str.charAt(startPos) == '-' || str.charAt(startPos) == '/')) {
            startPos++;
        }
        return startPos;
    }

    private final int skipUntil(java.lang.String str, int startPos, java.lang.String chars) {
        while (startPos < str.length() && kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) chars, str.charAt(startPos), 0, false, 6, (java.lang.Object) null) < 0) {
            startPos++;
        }
        return startPos;
    }

    public final io.dcloud.uts.ISODateResult parseISOString(java.lang.String isoString) {
        int iIntValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(isoString, "isoString");
        io.dcloud.uts.ISODateResult iSODateResult = new io.dcloud.uts.ISODateResult(null, false, 3, null);
        int[] fields = iSODateResult.getFields();
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= 9) {
                break;
            }
            if (i != 2) {
                i2 = 0;
            }
            fields[i] = i2;
            i++;
        }
        if (isoString.length() > 0) {
            char cCharAt = isoString.charAt(0);
            if (cCharAt == '+' || cCharAt == '-') {
                kotlin.Pair<java.lang.Integer, java.lang.Integer> digits = getDigits(isoString, 1, 6, 6);
                if (digits == null) {
                    return null;
                }
                int iIntValue2 = digits.getSecond().intValue();
                int iIntValue3 = digits.getFirst().intValue();
                fields[0] = iIntValue3;
                if (cCharAt == '-') {
                    if (iIntValue3 == 0) {
                        return null;
                    }
                    fields[0] = -iIntValue3;
                }
                iIntValue = iIntValue2;
            } else {
                kotlin.Pair<java.lang.Integer, java.lang.Integer> digits2 = getDigits(isoString, 0, 4, 4);
                if (digits2 == null) {
                    return null;
                }
                iIntValue = digits2.getSecond().intValue();
                fields[0] = digits2.getFirst().intValue();
            }
            if (iIntValue < isoString.length() && isoString.charAt(iIntValue) == '-') {
                kotlin.Pair<java.lang.Integer, java.lang.Integer> digits3 = getDigits(isoString, iIntValue + 1, 2, 2);
                if (digits3 == null) {
                    return null;
                }
                iIntValue = digits3.getSecond().intValue();
                int iIntValue4 = digits3.getFirst().intValue() - 1;
                fields[1] = iIntValue4;
                if (iIntValue4 < 0) {
                    return null;
                }
                if (iIntValue < isoString.length() && isoString.charAt(iIntValue) == '-') {
                    kotlin.Pair<java.lang.Integer, java.lang.Integer> digits4 = getDigits(isoString, iIntValue + 1, 2, 2);
                    if (digits4 == null) {
                        return null;
                    }
                    iIntValue = digits4.getSecond().intValue();
                    int iIntValue5 = digits4.getFirst().intValue();
                    fields[2] = iIntValue5;
                    if (iIntValue5 < 1) {
                        return null;
                    }
                }
            }
            if (iIntValue < isoString.length() && isoString.charAt(iIntValue) == 'T') {
                iSODateResult.setLocal(true);
                kotlin.Pair<java.lang.Integer, java.lang.Integer> digits5 = getDigits(isoString, iIntValue + 1, 2, 2);
                if (digits5 == null) {
                    return null;
                }
                int iIntValue6 = digits5.getSecond().intValue();
                fields[3] = digits5.getFirst().intValue();
                if (iIntValue6 >= isoString.length() || isoString.charAt(iIntValue6) != ':') {
                    fields[3] = 100;
                    return iSODateResult;
                }
                kotlin.Pair<java.lang.Integer, java.lang.Integer> digits6 = getDigits(isoString, iIntValue6 + 1, 2, 2);
                if (digits6 == null) {
                    return null;
                }
                iIntValue = digits6.getSecond().intValue();
                fields[4] = digits6.getFirst().intValue();
                if (iIntValue < isoString.length() && isoString.charAt(iIntValue) == ':') {
                    kotlin.Pair<java.lang.Integer, java.lang.Integer> digits7 = getDigits(isoString, iIntValue + 1, 2, 2);
                    if (digits7 == null) {
                        return null;
                    }
                    iIntValue = digits7.getSecond().intValue();
                    fields[5] = digits7.getFirst().intValue();
                    if (iIntValue < isoString.length() && isoString.charAt(iIntValue) == '.') {
                        kotlin.Pair<java.lang.Integer, java.lang.Integer> milliseconds = parseMilliseconds(isoString, iIntValue + 1);
                        fields[6] = milliseconds.getFirst().intValue();
                        iIntValue = milliseconds.getSecond().intValue();
                    }
                }
            }
            if (iIntValue < isoString.length()) {
                iSODateResult.setLocal(false);
                if (isoString.charAt(iIntValue) == 'Z') {
                    iIntValue++;
                } else {
                    kotlin.Pair<java.lang.Integer, java.lang.Integer> tzOffset = parseTzOffset(isoString, iIntValue);
                    if (tzOffset == null) {
                        return null;
                    }
                    fields[8] = tzOffset.getFirst().intValue();
                    iIntValue = tzOffset.getSecond().intValue();
                }
            }
            if (iIntValue == isoString.length()) {
                return iSODateResult;
            }
        }
        return null;
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> getDigits(java.lang.String str, int startPos, int minDigits, int maxDigits) {
        char cCharAt;
        int i = 0;
        int i2 = 0;
        while (startPos < str.length() && i < maxDigits && '0' <= (cCharAt = str.charAt(startPos)) && cCharAt < ':') {
            i2 = (i2 * 10) + (cCharAt - '0');
            startPos++;
            i++;
        }
        if (i >= minDigits) {
            return new kotlin.Pair<>(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(startPos));
        }
        return null;
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> parseMilliseconds(java.lang.String str, int startPos) {
        char cCharAt;
        char cCharAt2;
        int iCharAt = 0;
        int i = 100;
        for (int i2 = 0; i2 < 3 && startPos < str.length() && '0' <= (cCharAt2 = str.charAt(startPos)) && cCharAt2 < ':'; i2++) {
            iCharAt += (str.charAt(startPos) - '0') * i;
            i /= 10;
            startPos++;
        }
        while (startPos < str.length() && '0' <= (cCharAt = str.charAt(startPos)) && cCharAt < ':') {
            startPos++;
        }
        return new kotlin.Pair<>(java.lang.Integer.valueOf(iCharAt), java.lang.Integer.valueOf(startPos));
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> parseTzOffset(java.lang.String str, int startPos) {
        int i;
        kotlin.Pair<java.lang.Integer, java.lang.Integer> digits;
        if (startPos >= str.length()) {
            return null;
        }
        char cCharAt = str.charAt(startPos);
        if (cCharAt == '+') {
            i = 1;
        } else {
            if (cCharAt != '-') {
                return null;
            }
            i = -1;
        }
        kotlin.Pair<java.lang.Integer, java.lang.Integer> digits2 = getDigits(str, startPos + 1, 2, 2);
        if (digits2 == null) {
            return null;
        }
        int iIntValue = digits2.getSecond().intValue();
        int iIntValue2 = digits2.getFirst().intValue() * 60;
        if (iIntValue < str.length() && str.charAt(iIntValue) == ':') {
            iIntValue++;
        }
        if (iIntValue < str.length() && (digits = getDigits(str, iIntValue, 2, 2)) != null) {
            iIntValue2 += digits.getFirst().intValue();
            iIntValue = digits.getSecond().intValue();
        }
        return new kotlin.Pair<>(java.lang.Integer.valueOf(i * iIntValue2), java.lang.Integer.valueOf(iIntValue));
    }
}
