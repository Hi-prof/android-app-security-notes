package io.dcloud.uts;

/* JADX INFO: compiled from: Number.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u001a\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001a\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u000e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u001a\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u001a\u001a\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u0018\u001a\u00020\u0013*\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001\u001a\n\u0010\u001a\u001a\u00020\u0013*\u00020\u0001\u001a\u0014\u0010\u001b\u001a\u00020\u0013*\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0001\u001a\u001d\u0010\u001b\u001a\u00020\u0013*\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001c\u001a\u0014\u0010\u001b\u001a\u00020\u0013*\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0001\u001a\u001d\u0010\u001b\u001a\u00020\u0013*\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001c\u001a\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u001f\u001a\u0016\u0010 \u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u001f\u001a\u0016\u0010\"\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u001f\u001a\u0012\u0010$\u001a\u00020\u0013*\u00020\u00012\u0006\u0010%\u001a\u00020\u0001\u001a\n\u0010&\u001a\u00020\u0001*\u00020\u0001\u001a\u0015\u0010'\u001a\u00020\u001f*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010)\u001a\u00020\u0001*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010)\u001a\u00020\u0013*\u00020\u00012\u0006\u0010(\u001a\u00020\u0013H\u0086\u0002\u001a\u0015\u0010*\u001a\u00020\u0001*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010+\u001a\u00020\u0001*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010,\u001a\u00020\u0001*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010-\u001a\u00020\u0001*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\u001a\r\u0010.\u001a\u00020\u0001*\u00020\u0001H\u0086\u0002\u001a\r\u0010/\u001a\u00020\u0001*\u00020\u0001H\u0086\u0002\u001a\r\u00100\u001a\u00020\u0001*\u00020\u0001H\u0086\u0002\u001a\r\u00101\u001a\u00020\u0001*\u00020\u0001H\u0086\u0002\u001a\u0015\u00102\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u00105\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0004\u001a\n\u00106\u001a\u00020\u0001*\u00020\u0001\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u00108\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u00109\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010:\u001a\u00020;*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010:\u001a\u00020;*\u00020\u00012\u0006\u0010(\u001a\u00020\u001fH\u0086\u0002\u001a\u0015\u0010:\u001a\u00020<*\u00020\u00012\u0006\u0010(\u001a\u00020=H\u0086\u0002\u001a\u0015\u0010:\u001a\u00020;*\u00020\u001f2\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010:\u001a\u00020<*\u00020=2\u0006\u0010(\u001a\u00020\u0001H\u0086\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006>"}, d2 = {"NaN", "", "getNaN", "()Ljava/lang/Number;", "Infinity", "getInfinity", "UTSNumber", "input", "numberEquals", "", "a", "", "b", "numberEqualsImpl", "isFinite", "number", "isNaN", "parseFloatInternal", "string", "", "parseFloat", "parseIntInternal", "radix", "parseInt", "toFixed", "fractionDigits", "toStringAsJS", "toString", "toString_number_nullable", "intToString", "value", "", "bigIntToString", "Ljava/math/BigDecimal;", "doubleToString", "", "toPrecision", "precision", "valueOf", "compareTo", "other", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS, "minus", "times", com.taobao.weex.ui.component.WXBasicComponentType.DIV, "rem", "inc", "dec", "unaryPlus", "unaryMinus", "and", "next", "or", "xor", "inv", "shl", "shr", "ushr", "rangeTo", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "", "utsplugin_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NumberKt {
    private static final java.lang.Number NaN = io.dcloud.uts.UTSNumber.INSTANCE.getNaN();
    private static final java.lang.Number Infinity = io.dcloud.uts.UTSNumber.INSTANCE.getPOSITIVE_INFINITY();

    @kotlin.Deprecated(message = "use kotlin.Number instead", replaceWith = @kotlin.ReplaceWith(expression = "kotlin.Number", imports = {}))
    public static final java.lang.Number UTSNumber(java.lang.Number input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return input;
    }

    public static final java.lang.Number valueOf(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        return number;
    }

    public static final java.lang.Number getNaN() {
        return NaN;
    }

    public static final java.lang.Number getInfinity() {
        return Infinity;
    }

    public static final boolean numberEquals(java.lang.Object obj, java.lang.Object obj2) {
        boolean z = obj == null;
        boolean z2 = obj2 == null;
        if (z && z2) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        boolean z3 = obj2 instanceof java.lang.Number;
        if ((obj instanceof java.lang.Number) && z3) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Number");
            return numberEqualsImpl((java.lang.Number) obj, (java.lang.Number) obj2);
        }
        return kotlin.jvm.internal.Intrinsics.areEqual(obj, obj2);
    }

    public static final boolean numberEqualsImpl(java.lang.Number a, java.lang.Number b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        boolean z = a instanceof java.lang.Double;
        boolean z2 = b instanceof java.lang.Double;
        if (z && z2) {
            return a.doubleValue() == b.doubleValue();
        }
        boolean z3 = a instanceof java.lang.Integer;
        boolean z4 = b instanceof java.lang.Integer;
        if (z3 && z4) {
            return kotlin.jvm.internal.Intrinsics.areEqual(a, b);
        }
        boolean z5 = a instanceof java.lang.Long;
        boolean z6 = b instanceof java.lang.Long;
        if (z5 && z6) {
            return kotlin.jvm.internal.Intrinsics.areEqual(a, b);
        }
        boolean z7 = a instanceof java.lang.Float;
        boolean z8 = b instanceof java.lang.Float;
        if (z7 && z8) {
            return a.floatValue() == b.floatValue();
        }
        boolean z9 = a instanceof java.lang.Byte;
        boolean z10 = b instanceof java.lang.Byte;
        if (z9 && z10) {
            return a.byteValue() == b.byteValue();
        }
        boolean z11 = a instanceof java.lang.Short;
        boolean z12 = b instanceof java.lang.Short;
        if (z11 && z12) {
            return a.shortValue() == b.shortValue();
        }
        if (z) {
            if (z8) {
                return ((float) a.doubleValue()) == b.floatValue();
            }
            return a.doubleValue() == b.doubleValue();
        }
        if (z7) {
            if (z2) {
                return a.floatValue() == ((float) b.doubleValue());
            }
            return a.floatValue() == b.floatValue();
        }
        if (z5) {
            if (z2) {
                return ((double) a.longValue()) == b.doubleValue();
            }
            if (z8) {
                return ((float) a.longValue()) == b.floatValue();
            }
            return kotlin.jvm.internal.Intrinsics.areEqual(a, java.lang.Long.valueOf(b.longValue()));
        }
        if (z3) {
            if (z2) {
                return ((double) a.intValue()) == b.doubleValue();
            }
            if (z8) {
                return ((float) a.intValue()) == b.floatValue();
            }
            if (z6) {
                return z6 && ((long) a.intValue()) == b.longValue();
            }
            return kotlin.jvm.internal.Intrinsics.areEqual(a, java.lang.Integer.valueOf(b.intValue()));
        }
        if (z11) {
            if (z2) {
                return ((double) a.shortValue()) == b.doubleValue();
            }
            if (z8) {
                return ((float) a.shortValue()) == b.floatValue();
            }
            if (z6) {
                return z6 && ((long) a.shortValue()) == b.longValue();
            }
            return a.shortValue() == b.intValue();
        }
        if (!z9) {
            return a.intValue() == b.intValue();
        }
        if (z2) {
            return ((double) a.byteValue()) == b.doubleValue();
        }
        if (z8) {
            return ((float) a.byteValue()) == b.floatValue();
        }
        if (z6) {
            return z6 && ((long) a.byteValue()) == b.longValue();
        }
        return a.byteValue() == b.intValue();
    }

    public static final boolean isFinite(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "number");
        return io.dcloud.uts.UTSNumber.INSTANCE.isFinite(number);
    }

    public static final boolean isNaN(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "number");
        return io.dcloud.uts.UTSNumber.INSTANCE.isNaN(number);
    }

    private static final java.lang.Number parseFloatInternal(java.lang.String str) {
        java.lang.String string = kotlin.text.StringsKt.trim((java.lang.CharSequence) str).toString();
        kotlin.text.MatchResult matchResultFind$default = kotlin.text.Regex.find$default(new kotlin.text.Regex("[^\\d+-.Ee]"), string, 0, 2, null);
        if (matchResultFind$default != null) {
            string = io.dcloud.uts.StringKt.substring(str, (java.lang.Number) 0, java.lang.Integer.valueOf(matchResultFind$default.getRange().getFirst()));
        }
        java.lang.String string2 = kotlin.text.StringsKt.trim((java.lang.CharSequence) string).toString();
        java.lang.String str2 = string2;
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str2, (java.lang.CharSequence) "E", false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str2, (java.lang.CharSequence) "e", false, 2, (java.lang.Object) null)) {
            return java.lang.Double.valueOf(new java.math.BigDecimal(string2).doubleValue());
        }
        if (!kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str2, (java.lang.CharSequence) com.taobao.weex.el.parse.Operators.DOT_STR, false, 2, (java.lang.Object) null)) {
            java.lang.Long longOrNull = kotlin.text.StringsKt.toLongOrNull(string2);
            return longOrNull != null ? longOrNull : java.lang.Double.valueOf(Double.NaN);
        }
        java.lang.Double doubleOrNull = kotlin.text.StringsKt.toDoubleOrNull(string2);
        return doubleOrNull != null ? doubleOrNull : java.lang.Double.valueOf(Double.NaN);
    }

    public static final java.lang.Number parseFloat(java.lang.String string) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        return parseFloatInternal(string);
    }

    public static /* synthetic */ java.lang.Number parseIntInternal$default(java.lang.String str, java.lang.Number number, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number = (java.lang.Number) 0;
        }
        return parseIntInternal(str, number);
    }

    public static final java.lang.Number parseIntInternal(java.lang.String string, java.lang.Number number) {
        int iIntValue;
        java.lang.String strSubstring;
        java.lang.String strSubstring$default;
        java.lang.Double dValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        java.lang.String str = string;
        boolean zIsBlank = kotlin.text.StringsKt.isBlank(str);
        java.lang.Double dValueOf2 = java.lang.Double.valueOf(Double.NaN);
        if (zIsBlank) {
            return dValueOf2;
        }
        if (number == null || kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) number, (java.lang.Object) 0)) {
            iIntValue = 0;
        } else if (kotlin.collections.CollectionsKt.contains(new kotlin.ranges.IntRange(2, 36), number)) {
            iIntValue = number.intValue();
        } else {
            return dValueOf2;
        }
        java.lang.String lowerCase = io.dcloud.uts.StringKt.toLowerCase(kotlin.text.StringsKt.trim((java.lang.CharSequence) str).toString());
        if (kotlin.text.StringsKt.startsWith$default(lowerCase, com.taobao.weex.el.parse.Operators.PLUS, false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.startsWith$default(lowerCase, com.taobao.weex.el.parse.Operators.SUB, false, 2, (java.lang.Object) null)) {
            strSubstring = io.dcloud.uts.StringKt.substring(lowerCase, (java.lang.Number) 0, (java.lang.Number) 1);
            strSubstring$default = io.dcloud.uts.StringKt.substring$default(lowerCase, (java.lang.Number) 1, null, 2, null);
        } else {
            strSubstring = "";
            strSubstring$default = lowerCase;
        }
        if (iIntValue == 0) {
            if (!kotlin.text.StringsKt.startsWith$default(strSubstring$default, "0x", false, 2, (java.lang.Object) null) || strSubstring$default.length() <= 2) {
                iIntValue = 10;
            } else {
                strSubstring$default = io.dcloud.uts.StringKt.substring$default(strSubstring$default, (java.lang.Number) 2, null, 2, null);
                iIntValue = 16;
            }
        } else if (iIntValue == 16 && kotlin.text.StringsKt.startsWith$default(lowerCase, "0x", false, 2, (java.lang.Object) null)) {
            strSubstring$default = io.dcloud.uts.StringKt.substring$default(strSubstring$default, (java.lang.Number) 2, null, 2, null);
        }
        java.lang.String strSubstring2 = io.dcloud.uts.StringKt.substring("0123456789abcdefghijklmnopqrstuvwxyz", (java.lang.Number) 0, java.lang.Integer.valueOf(iIntValue));
        double d = 0.0d;
        for (kotlin.collections.IndexedValue<java.lang.Character> indexedValue : kotlin.text.StringsKt.withIndex(strSubstring$default)) {
            int iIndexOf$default = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) strSubstring2, indexedValue.getValue().charValue(), 0, false, 6, (java.lang.Object) null);
            if (iIndexOf$default < 0) {
                if (indexedValue.getIndex() != 0) {
                    break;
                }
                return dValueOf2;
            }
            d = (d * ((double) iIntValue)) + ((double) iIndexOf$default);
        }
        if (d < 2.147483647E9d) {
            dValueOf = java.lang.Integer.valueOf((int) d);
        } else if (d < 9.223372036854776E18d) {
            dValueOf = java.lang.Long.valueOf((long) d);
        } else {
            dValueOf = java.lang.Double.valueOf(d);
        }
        return kotlin.jvm.internal.Intrinsics.areEqual(strSubstring, com.taobao.weex.el.parse.Operators.SUB) ? unaryMinus(dValueOf) : dValueOf;
    }

    public static /* synthetic */ java.lang.Number parseInt$default(java.lang.String str, java.lang.Number number, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            number = (java.lang.Number) 0;
        }
        return parseInt(str, number);
    }

    public static final java.lang.Number parseInt(java.lang.String string, java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        return parseIntInternal(string, number);
    }

    public static /* synthetic */ java.lang.String toFixed$default(java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            number2 = (java.lang.Number) 0;
        }
        return toFixed(number, number2);
    }

    public static final java.lang.String toFixed(java.lang.Number number, java.lang.Number fractionDigits) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fractionDigits, "fractionDigits");
        if (android.os.Build.VERSION.SDK_INT <= 23) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(number, java.lang.Double.valueOf(Double.NEGATIVE_INFINITY))) {
                return "-Infinity";
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(number, java.lang.Double.valueOf(Double.POSITIVE_INFINITY))) {
                return "Infinity";
            }
            if (io.dcloud.uts.UTSNumber.INSTANCE.isNaN(number)) {
                return "NaN";
            }
            java.lang.String plainString = new java.math.BigDecimal(number.doubleValue()).setScale(fractionDigits.intValue(), java.math.RoundingMode.HALF_EVEN).toPlainString();
            if (number.doubleValue() < 0.0d) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(plainString);
                if (java.lang.Double.parseDouble(plainString) == 0.0d) {
                    return com.taobao.weex.el.parse.Operators.SUB + plainString;
                }
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(plainString);
            return plainString;
        }
        java.lang.String str = java.lang.String.format("%." + fractionDigits + 'f', java.util.Arrays.copyOf(new java.lang.Object[]{java.lang.Double.valueOf(number.doubleValue())}, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final java.lang.String toStringAsJS(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        return toString(number, (java.lang.Number) 10);
    }

    public static /* synthetic */ java.lang.String toString$default(java.lang.Object obj, java.lang.Number number, int i, java.lang.Object obj2) {
        if ((i & 1) != 0) {
            number = (java.lang.Number) 10;
        }
        return toString(obj, number);
    }

    public static final java.lang.String toString(java.lang.Object obj, java.lang.Number radix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(obj, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(radix, "radix");
        if (obj instanceof java.lang.Number) {
            return toString((java.lang.Number) obj, radix);
        }
        return obj.toString();
    }

    public static /* synthetic */ java.lang.String toString_number_nullable$default(java.lang.Object obj, java.lang.Number number, int i, java.lang.Object obj2) {
        if ((i & 1) != 0) {
            number = (java.lang.Number) 10;
        }
        return toString_number_nullable(obj, number);
    }

    public static final java.lang.String toString_number_nullable(java.lang.Object obj, java.lang.Number radix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(radix, "radix");
        if (obj == null) {
            return "null";
        }
        return toString(obj, radix);
    }

    public static /* synthetic */ java.lang.String toString$default(java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            number2 = (java.lang.Number) 10;
        }
        return toString(number, number2);
    }

    public static final java.lang.String toString(java.lang.Number number, java.lang.Number radix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(radix, "radix");
        if ((number instanceof java.lang.Double) || (number instanceof java.lang.Float)) {
            return doubleToString(number.doubleValue(), radix.intValue());
        }
        return intToString(number, radix.intValue());
    }

    public static /* synthetic */ java.lang.String toString_number_nullable$default(java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            number2 = (java.lang.Number) 10;
        }
        return toString_number_nullable(number, number2);
    }

    public static final java.lang.String toString_number_nullable(java.lang.Number number, java.lang.Number radix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(radix, "radix");
        if (number == null) {
            return "null";
        }
        return toString(number, radix);
    }

    public static final java.lang.String intToString(java.lang.Number value, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        java.lang.String str = "";
        if (i >= 2 && i <= 36) {
            if (i == 10) {
                return value.toString();
            }
            long jAbs = java.lang.Math.abs(value.longValue());
            do {
                long j = i;
                str = io.dcloud.uts.StringKt.get("0123456789abcdefghijklmnopqrstuvwxyz", java.lang.Long.valueOf(jAbs % j)) + str;
                jAbs /= j;
            } while (jAbs > 0);
            if (value.doubleValue() < 0.0d) {
                return com.taobao.weex.el.parse.Operators.SUB + str;
            }
        }
        return str;
    }

    public static final java.lang.String bigIntToString(java.math.BigDecimal number, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "number");
        char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        java.math.BigDecimal bigDecimalAbs = number.abs();
        boolean zAreEqual = kotlin.jvm.internal.Intrinsics.areEqual(number, bigDecimalAbs);
        java.math.BigDecimal bigDecimal = new java.math.BigDecimal(i);
        java.lang.String str = "";
        while (true) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(bigDecimalAbs);
            if (compareTo(bigDecimalAbs, (java.lang.Number) 0) <= 0) {
                break;
            }
            java.math.BigDecimal[] bigDecimalArrDivideAndRemainder = bigDecimalAbs.divideAndRemainder(bigDecimal);
            java.math.BigDecimal bigDecimal2 = bigDecimalArrDivideAndRemainder[0];
            str = charArray[bigDecimalArrDivideAndRemainder[1].intValue()] + str;
            bigDecimalAbs = bigDecimal2;
        }
        if (zAreEqual) {
            return str;
        }
        return com.taobao.weex.el.parse.Operators.SUB + str;
    }

    public static final java.lang.String doubleToString(double d, int i) {
        double dFloor;
        double dAbs;
        java.lang.String strIntToString;
        java.lang.String str;
        java.lang.String str2 = "";
        if (i < 2 || i > 36) {
            return "";
        }
        if (java.lang.Double.isNaN(d)) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (i == 10) {
            return io.dcloud.uts.android.ClassLogWrapper.INSTANCE.wrapNumberText(java.lang.Double.valueOf(d));
        }
        if (d < 0.0d) {
            dFloor = java.lang.Math.ceil(d);
            dAbs = java.lang.Math.abs(dFloor - d);
        } else {
            dFloor = java.lang.Math.floor(d);
            dAbs = d - dFloor;
        }
        if (dFloor > 9.223372036854776E18d) {
            java.math.BigDecimal bigDecimalValueOf = java.math.BigDecimal.valueOf(dFloor);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
            strIntToString = bigIntToString(bigDecimalValueOf, i);
        } else {
            strIntToString = intToString(java.lang.Double.valueOf(d), i);
        }
        while (dAbs > 0.0d && str2.length() < 60) {
            double d2 = dAbs * ((double) i);
            double dFloor2 = java.lang.Math.floor(d2);
            if (dFloor2 > 9.223372036854776E18d) {
                str = str2 + bigIntToString(new java.math.BigDecimal(dFloor2), i);
            } else {
                str = str2 + intToString(java.lang.Long.valueOf((long) dFloor2), i);
            }
            str2 = str;
            dAbs = d2 - dFloor2;
        }
        if (str2.length() == 0) {
            return strIntToString;
        }
        return strIntToString + com.taobao.weex.el.parse.Operators.DOT + str2;
    }

    public static final java.lang.String toPrecision(java.lang.Number number, java.lang.Number precision) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(precision, "precision");
        java.lang.StringBuilder sb = new java.lang.StringBuilder("%.");
        if (precision.intValue() <= 0) {
            precision = (java.lang.Number) 16;
        }
        sb.append(precision);
        sb.append('g');
        java.lang.String str = java.lang.String.format(sb.toString(), java.util.Arrays.copyOf(new java.lang.Object[]{number}, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return io.dcloud.uts.StringKt.replace(io.dcloud.uts.StringKt.replace(str, "e+0", "e+"), "e-0", "e-");
    }

    public static final int compareTo(java.lang.Number number, java.lang.Number other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (number instanceof java.lang.Byte) {
            byte bByteValue = number.byteValue();
            if (other instanceof java.lang.Integer) {
                return kotlin.jvm.internal.Intrinsics.compare((int) bByteValue, other.intValue());
            }
            if (other instanceof java.lang.Byte) {
                return kotlin.jvm.internal.Intrinsics.compare((int) bByteValue, (int) other.byteValue());
            }
            if (other instanceof java.lang.Short) {
                return kotlin.jvm.internal.Intrinsics.compare((int) bByteValue, (int) other.shortValue());
            }
            if (other instanceof java.lang.Long) {
                return kotlin.jvm.internal.Intrinsics.compare(bByteValue, other.longValue());
            }
            return other instanceof java.lang.Float ? java.lang.Float.compare(bByteValue, other.floatValue()) : java.lang.Double.compare(bByteValue, other.doubleValue());
        }
        if (number instanceof java.lang.Short) {
            short sShortValue = number.shortValue();
            if (other instanceof java.lang.Integer) {
                return kotlin.jvm.internal.Intrinsics.compare((int) sShortValue, other.intValue());
            }
            if (other instanceof java.lang.Byte) {
                return kotlin.jvm.internal.Intrinsics.compare((int) sShortValue, (int) other.byteValue());
            }
            if (other instanceof java.lang.Short) {
                return kotlin.jvm.internal.Intrinsics.compare((int) sShortValue, (int) other.shortValue());
            }
            if (other instanceof java.lang.Long) {
                return kotlin.jvm.internal.Intrinsics.compare(sShortValue, other.longValue());
            }
            return other instanceof java.lang.Float ? java.lang.Float.compare(sShortValue, other.floatValue()) : java.lang.Double.compare(sShortValue, other.doubleValue());
        }
        if (number instanceof java.lang.Integer) {
            int iIntValue = number.intValue();
            if (other instanceof java.lang.Integer) {
                return kotlin.jvm.internal.Intrinsics.compare(iIntValue, other.intValue());
            }
            if (other instanceof java.lang.Byte) {
                return kotlin.jvm.internal.Intrinsics.compare(iIntValue, (int) other.byteValue());
            }
            if (other instanceof java.lang.Short) {
                return kotlin.jvm.internal.Intrinsics.compare(iIntValue, (int) other.shortValue());
            }
            if (other instanceof java.lang.Long) {
                return kotlin.jvm.internal.Intrinsics.compare(iIntValue, other.longValue());
            }
            return other instanceof java.lang.Float ? java.lang.Float.compare(iIntValue, other.floatValue()) : java.lang.Double.compare(iIntValue, other.doubleValue());
        }
        if (number instanceof java.lang.Long) {
            long jLongValue = number.longValue();
            if (other instanceof java.lang.Integer) {
                return kotlin.jvm.internal.Intrinsics.compare(jLongValue, other.intValue());
            }
            if (other instanceof java.lang.Byte) {
                return kotlin.jvm.internal.Intrinsics.compare(jLongValue, other.byteValue());
            }
            if (other instanceof java.lang.Short) {
                return kotlin.jvm.internal.Intrinsics.compare(jLongValue, other.shortValue());
            }
            if (other instanceof java.lang.Long) {
                return kotlin.jvm.internal.Intrinsics.compare(jLongValue, other.longValue());
            }
            return other instanceof java.lang.Float ? java.lang.Float.compare(jLongValue, other.floatValue()) : java.lang.Double.compare(jLongValue, other.doubleValue());
        }
        if (number instanceof java.lang.Float) {
            float fFloatValue = number.floatValue();
            if (other instanceof java.lang.Integer) {
                return java.lang.Float.compare(fFloatValue, other.intValue());
            }
            if (other instanceof java.lang.Byte) {
                return java.lang.Float.compare(fFloatValue, other.byteValue());
            }
            if (other instanceof java.lang.Short) {
                return java.lang.Float.compare(fFloatValue, other.shortValue());
            }
            if (other instanceof java.lang.Long) {
                return java.lang.Float.compare(fFloatValue, other.longValue());
            }
            return other instanceof java.lang.Float ? java.lang.Float.compare(fFloatValue, other.floatValue()) : java.lang.Double.compare(fFloatValue, other.doubleValue());
        }
        double dDoubleValue = number.doubleValue();
        if (other instanceof java.lang.Integer) {
            return java.lang.Double.compare(dDoubleValue, other.intValue());
        }
        if (other instanceof java.lang.Byte) {
            return java.lang.Double.compare(dDoubleValue, other.byteValue());
        }
        if (other instanceof java.lang.Short) {
            return java.lang.Double.compare(dDoubleValue, other.shortValue());
        }
        if (other instanceof java.lang.Long) {
            return java.lang.Double.compare(dDoubleValue, other.longValue());
        }
        return other instanceof java.lang.Float ? java.lang.Double.compare(dDoubleValue, other.floatValue()) : java.lang.Double.compare(dDoubleValue, other.doubleValue());
    }

    public static final java.lang.Number plus(java.lang.Number number, java.lang.Number other) {
        java.lang.Number numberValueOf;
        double dFloatValue;
        int iShortValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if ((number instanceof java.lang.Byte) || (number instanceof java.lang.Short) || (number instanceof java.lang.Integer)) {
            int iIntValue = number.intValue();
            if ((other instanceof java.lang.Integer) || (other instanceof java.lang.Byte) || (other instanceof java.lang.Short)) {
                try {
                    return java.lang.Integer.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m(iIntValue, other.intValue()));
                } catch (java.lang.ArithmeticException unused) {
                    return java.lang.Long.valueOf(((long) iIntValue) + other.longValue());
                }
            }
            if (other instanceof java.lang.Long) {
                try {
                    return java.lang.Long.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m610m(iIntValue, other.longValue()));
                } catch (java.lang.ArithmeticException unused2) {
                    return java.lang.Double.valueOf(((double) iIntValue) + other.longValue());
                }
            }
            numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(iIntValue + other.floatValue()) : java.lang.Double.valueOf(((double) iIntValue) + other.doubleValue());
        } else if (number instanceof java.lang.Long) {
            long jLongValue = number.longValue();
            if ((other instanceof java.lang.Integer) || (other instanceof java.lang.Byte) || (other instanceof java.lang.Short) || (other instanceof java.lang.Long)) {
                try {
                    return java.lang.Long.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m610m(jLongValue, other.longValue()));
                } catch (java.lang.ArithmeticException unused3) {
                    return java.lang.Double.valueOf(jLongValue + other.doubleValue());
                }
            }
            numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(jLongValue + other.floatValue()) : java.lang.Double.valueOf(jLongValue + other.doubleValue());
        } else if (number instanceof java.lang.Float) {
            float fFloatValue = number.floatValue();
            if (other instanceof java.lang.Integer) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue + other.intValue());
            } else if (other instanceof java.lang.Byte) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue + other.byteValue());
            } else if (other instanceof java.lang.Short) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue + other.shortValue());
            } else if (other instanceof java.lang.Long) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue + other.longValue());
            } else {
                numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(fFloatValue + other.floatValue()) : java.lang.Double.valueOf(((double) fFloatValue) + other.doubleValue());
            }
        } else {
            double dDoubleValue = number.doubleValue();
            if (other instanceof java.lang.Integer) {
                iShortValue = other.intValue();
            } else if (other instanceof java.lang.Byte) {
                iShortValue = other.byteValue();
            } else {
                if (other instanceof java.lang.Short) {
                    iShortValue = other.shortValue();
                } else if (other instanceof java.lang.Long) {
                    dFloatValue = other.longValue();
                } else {
                    dFloatValue = other instanceof java.lang.Float ? other.floatValue() : other.doubleValue();
                }
                numberValueOf = java.lang.Double.valueOf(dDoubleValue + dFloatValue);
            }
            dFloatValue = iShortValue;
            numberValueOf = java.lang.Double.valueOf(dDoubleValue + dFloatValue);
        }
        return numberValueOf;
    }

    public static final java.lang.String plus(java.lang.Number number, java.lang.String other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return number + other;
    }

    public static final java.lang.Number minus(java.lang.Number number, java.lang.Number other) {
        java.lang.Number numberValueOf;
        double dFloatValue;
        int iShortValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if ((number instanceof java.lang.Byte) || (number instanceof java.lang.Short) || (number instanceof java.lang.Integer)) {
            int iIntValue = number.intValue();
            if ((other instanceof java.lang.Integer) || (other instanceof java.lang.Byte) || (other instanceof java.lang.Short)) {
                try {
                    return java.lang.Integer.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m$2(iIntValue, other.intValue()));
                } catch (java.lang.ArithmeticException unused) {
                    return java.lang.Long.valueOf(((long) iIntValue) - other.longValue());
                }
            }
            if (other instanceof java.lang.Long) {
                try {
                    return java.lang.Long.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m$2(iIntValue, other.longValue()));
                } catch (java.lang.ArithmeticException unused2) {
                    return java.lang.Double.valueOf(((double) iIntValue) - other.longValue());
                }
            }
            numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(iIntValue - other.floatValue()) : java.lang.Double.valueOf(((double) iIntValue) - other.doubleValue());
        } else if (number instanceof java.lang.Long) {
            long jLongValue = number.longValue();
            if ((other instanceof java.lang.Integer) || (other instanceof java.lang.Byte) || (other instanceof java.lang.Short) || (other instanceof java.lang.Long)) {
                try {
                    return java.lang.Long.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m$2(jLongValue, other.longValue()));
                } catch (java.lang.ArithmeticException unused3) {
                    return java.lang.Double.valueOf(jLongValue - other.doubleValue());
                }
            }
            numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(jLongValue - other.floatValue()) : java.lang.Double.valueOf(jLongValue - other.doubleValue());
        } else if (number instanceof java.lang.Float) {
            float fFloatValue = number.floatValue();
            if (other instanceof java.lang.Integer) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue - other.intValue());
            } else if (other instanceof java.lang.Byte) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue - other.byteValue());
            } else if (other instanceof java.lang.Short) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue - other.shortValue());
            } else if (other instanceof java.lang.Long) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue - other.longValue());
            } else {
                numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(fFloatValue - other.floatValue()) : java.lang.Double.valueOf(((double) fFloatValue) - other.doubleValue());
            }
        } else {
            double dDoubleValue = number.doubleValue();
            if (other instanceof java.lang.Integer) {
                iShortValue = other.intValue();
            } else if (other instanceof java.lang.Byte) {
                iShortValue = other.byteValue();
            } else {
                if (other instanceof java.lang.Short) {
                    iShortValue = other.shortValue();
                } else if (other instanceof java.lang.Long) {
                    dFloatValue = other.longValue();
                } else {
                    dFloatValue = other instanceof java.lang.Float ? other.floatValue() : other.doubleValue();
                }
                numberValueOf = java.lang.Double.valueOf(dDoubleValue - dFloatValue);
            }
            dFloatValue = iShortValue;
            numberValueOf = java.lang.Double.valueOf(dDoubleValue - dFloatValue);
        }
        return numberValueOf;
    }

    public static final java.lang.Number times(java.lang.Number number, java.lang.Number other) {
        java.lang.Number numberValueOf;
        double dFloatValue;
        int iShortValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if ((number instanceof java.lang.Byte) || (number instanceof java.lang.Short) || (number instanceof java.lang.Integer)) {
            int iIntValue = number.intValue();
            if ((other instanceof java.lang.Integer) || (other instanceof java.lang.Byte) || (other instanceof java.lang.Short)) {
                try {
                    return java.lang.Integer.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m$1(iIntValue, other.intValue()));
                } catch (java.lang.ArithmeticException unused) {
                    return java.lang.Long.valueOf(((long) iIntValue) * other.longValue());
                }
            }
            if (other instanceof java.lang.Long) {
                try {
                    return java.lang.Long.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m$1(iIntValue, other.longValue()));
                } catch (java.lang.ArithmeticException unused2) {
                    return java.lang.Double.valueOf(((double) iIntValue) * other.longValue());
                }
            }
            numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(iIntValue * other.floatValue()) : java.lang.Double.valueOf(((double) iIntValue) * other.doubleValue());
        } else if (number instanceof java.lang.Long) {
            long jLongValue = number.longValue();
            if ((other instanceof java.lang.Integer) || (other instanceof java.lang.Byte) || (other instanceof java.lang.Short) || (other instanceof java.lang.Long)) {
                try {
                    return java.lang.Long.valueOf(kotlin.UByte$$ExternalSyntheticBackport0.m$1(jLongValue, other.longValue()));
                } catch (java.lang.ArithmeticException unused3) {
                    return java.lang.Double.valueOf(jLongValue * other.doubleValue());
                }
            }
            numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(jLongValue * other.floatValue()) : java.lang.Double.valueOf(jLongValue * other.doubleValue());
        } else if (number instanceof java.lang.Float) {
            float fFloatValue = number.floatValue();
            if (other instanceof java.lang.Integer) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue * other.intValue());
            } else if (other instanceof java.lang.Byte) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue * other.byteValue());
            } else if (other instanceof java.lang.Short) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue * other.shortValue());
            } else if (other instanceof java.lang.Long) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue * other.longValue());
            } else {
                numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(fFloatValue * other.floatValue()) : java.lang.Double.valueOf(((double) fFloatValue) * other.doubleValue());
            }
        } else {
            double dDoubleValue = number.doubleValue();
            if (other instanceof java.lang.Integer) {
                iShortValue = other.intValue();
            } else if (other instanceof java.lang.Byte) {
                iShortValue = other.byteValue();
            } else {
                if (other instanceof java.lang.Short) {
                    iShortValue = other.shortValue();
                } else if (other instanceof java.lang.Long) {
                    dFloatValue = other.longValue();
                } else {
                    dFloatValue = other instanceof java.lang.Float ? other.floatValue() : other.doubleValue();
                }
                numberValueOf = java.lang.Double.valueOf(dDoubleValue * dFloatValue);
            }
            dFloatValue = iShortValue;
            numberValueOf = java.lang.Double.valueOf(dDoubleValue * dFloatValue);
        }
        return numberValueOf;
    }

    public static final java.lang.Number div(java.lang.Number number, java.lang.Number other) {
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        boolean z = true;
        boolean z2 = (other instanceof java.lang.Byte) || (other instanceof java.lang.Short) || (other instanceof java.lang.Integer) || (other instanceof java.lang.Long);
        if (!(number instanceof java.lang.Byte) && !(number instanceof java.lang.Short) && !(number instanceof java.lang.Integer) && !(number instanceof java.lang.Long)) {
            z = false;
        }
        if (z2) {
            if (other.longValue() == 0) {
                long jLongValue = number.longValue();
                if (jLongValue == 0) {
                    return java.lang.Double.valueOf(Double.NaN);
                }
                if (jLongValue > 0) {
                    return java.lang.Double.valueOf(Double.POSITIVE_INFINITY);
                }
                return java.lang.Double.valueOf(Double.NEGATIVE_INFINITY);
            }
        } else if (other.doubleValue() == 0.0d) {
            double dDoubleValue = number.doubleValue();
            if (dDoubleValue == 0.0d) {
                return java.lang.Double.valueOf(Double.NaN);
            }
            if (dDoubleValue > 0.0d) {
                return java.lang.Double.valueOf(Double.POSITIVE_INFINITY);
            }
            return java.lang.Double.valueOf(Double.NEGATIVE_INFINITY);
        }
        if (z2 && z && kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) rem(number, other), (java.lang.Object) 0)) {
            numberValueOf = java.lang.Long.valueOf(number.longValue() / other.longValue());
        } else {
            numberValueOf = java.lang.Double.valueOf(number.doubleValue() / other.doubleValue());
        }
        return numberValueOf;
    }

    public static final java.lang.Number rem(java.lang.Number number, java.lang.Number other) {
        double dFloatValue;
        int iShortValue;
        java.lang.Number numberValueOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (number instanceof java.lang.Byte) {
            byte bByteValue = number.byteValue();
            if (other instanceof java.lang.Integer) {
                numberValueOf = java.lang.Integer.valueOf(bByteValue % other.intValue());
            } else if (other instanceof java.lang.Byte) {
                numberValueOf = java.lang.Integer.valueOf(bByteValue % other.byteValue());
            } else if (other instanceof java.lang.Short) {
                numberValueOf = java.lang.Integer.valueOf(bByteValue % other.shortValue());
            } else if (other instanceof java.lang.Long) {
                numberValueOf = java.lang.Long.valueOf(((long) bByteValue) % other.longValue());
            } else {
                numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(bByteValue % other.floatValue()) : java.lang.Double.valueOf(((double) bByteValue) % other.doubleValue());
            }
        } else if (number instanceof java.lang.Short) {
            short sShortValue = number.shortValue();
            if (other instanceof java.lang.Integer) {
                numberValueOf = java.lang.Integer.valueOf(sShortValue % other.intValue());
            } else if (other instanceof java.lang.Byte) {
                numberValueOf = java.lang.Integer.valueOf(sShortValue % other.byteValue());
            } else if (other instanceof java.lang.Short) {
                numberValueOf = java.lang.Integer.valueOf(sShortValue % other.shortValue());
            } else if (other instanceof java.lang.Long) {
                numberValueOf = java.lang.Long.valueOf(((long) sShortValue) % other.longValue());
            } else {
                numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(sShortValue % other.floatValue()) : java.lang.Double.valueOf(((double) sShortValue) % other.doubleValue());
            }
        } else if (number instanceof java.lang.Integer) {
            int iIntValue = number.intValue();
            if (other instanceof java.lang.Integer) {
                numberValueOf = java.lang.Integer.valueOf(iIntValue % other.intValue());
            } else if (other instanceof java.lang.Byte) {
                numberValueOf = java.lang.Integer.valueOf(iIntValue % other.byteValue());
            } else if (other instanceof java.lang.Short) {
                numberValueOf = java.lang.Integer.valueOf(iIntValue % other.shortValue());
            } else if (other instanceof java.lang.Long) {
                numberValueOf = java.lang.Long.valueOf(((long) iIntValue) % other.longValue());
            } else {
                numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(iIntValue % other.floatValue()) : java.lang.Double.valueOf(((double) iIntValue) % other.doubleValue());
            }
        } else if (number instanceof java.lang.Long) {
            long jLongValue = number.longValue();
            if (other instanceof java.lang.Integer) {
                numberValueOf = java.lang.Long.valueOf(jLongValue % ((long) other.intValue()));
            } else if (other instanceof java.lang.Byte) {
                numberValueOf = java.lang.Long.valueOf(jLongValue % ((long) other.byteValue()));
            } else if (other instanceof java.lang.Short) {
                numberValueOf = java.lang.Long.valueOf(jLongValue % ((long) other.shortValue()));
            } else if (other instanceof java.lang.Long) {
                numberValueOf = java.lang.Long.valueOf(jLongValue % other.longValue());
            } else {
                numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(jLongValue % other.floatValue()) : java.lang.Double.valueOf(jLongValue % other.doubleValue());
            }
        } else if (number instanceof java.lang.Float) {
            float fFloatValue = number.floatValue();
            if (other instanceof java.lang.Integer) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue % other.intValue());
            } else if (other instanceof java.lang.Byte) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue % other.byteValue());
            } else if (other instanceof java.lang.Short) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue % other.shortValue());
            } else if (other instanceof java.lang.Long) {
                numberValueOf = java.lang.Float.valueOf(fFloatValue % other.longValue());
            } else {
                numberValueOf = other instanceof java.lang.Float ? java.lang.Float.valueOf(fFloatValue % other.floatValue()) : java.lang.Double.valueOf(((double) fFloatValue) % other.doubleValue());
            }
        } else {
            double dDoubleValue = number.doubleValue();
            if (other instanceof java.lang.Integer) {
                iShortValue = other.intValue();
            } else if (other instanceof java.lang.Byte) {
                iShortValue = other.byteValue();
            } else {
                if (other instanceof java.lang.Short) {
                    iShortValue = other.shortValue();
                } else if (other instanceof java.lang.Long) {
                    dFloatValue = other.longValue();
                } else {
                    dFloatValue = other instanceof java.lang.Float ? other.floatValue() : other.doubleValue();
                }
                numberValueOf = java.lang.Double.valueOf(dDoubleValue % dFloatValue);
            }
            dFloatValue = iShortValue;
            numberValueOf = java.lang.Double.valueOf(dDoubleValue % dFloatValue);
        }
        return numberValueOf;
    }

    public static final java.lang.Number inc(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        if (number instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(number.intValue() + 1);
        }
        if (number instanceof java.lang.Byte) {
            return java.lang.Byte.valueOf((byte) (number.byteValue() + 1));
        }
        if (number instanceof java.lang.Short) {
            return java.lang.Short.valueOf((short) (number.shortValue() + 1));
        }
        if (number instanceof java.lang.Long) {
            return java.lang.Long.valueOf(number.longValue() + 1);
        }
        return number instanceof java.lang.Float ? java.lang.Float.valueOf(number.floatValue() + 1.0f) : java.lang.Double.valueOf(number.doubleValue() + 1.0d);
    }

    public static final java.lang.Number dec(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        if (number instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(number.intValue() - 1);
        }
        if (number instanceof java.lang.Byte) {
            return java.lang.Byte.valueOf((byte) (number.byteValue() - 1));
        }
        if (number instanceof java.lang.Short) {
            return java.lang.Short.valueOf((short) (number.shortValue() - 1));
        }
        if (number instanceof java.lang.Long) {
            return java.lang.Long.valueOf(number.longValue() - 1);
        }
        return number instanceof java.lang.Float ? java.lang.Float.valueOf(number.floatValue() - 1.0f) : java.lang.Double.valueOf(number.doubleValue() - 1.0d);
    }

    public static final java.lang.Number unaryPlus(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        if (number instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(number.intValue());
        }
        if (number instanceof java.lang.Byte) {
            return java.lang.Integer.valueOf(number.byteValue());
        }
        if (number instanceof java.lang.Short) {
            return java.lang.Integer.valueOf(number.shortValue());
        }
        if (number instanceof java.lang.Long) {
            return java.lang.Long.valueOf(number.longValue());
        }
        return number instanceof java.lang.Float ? java.lang.Float.valueOf(number.floatValue()) : java.lang.Double.valueOf(number.doubleValue());
    }

    public static final java.lang.Number unaryMinus(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        if (number instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(-number.intValue());
        }
        if (number instanceof java.lang.Byte) {
            return java.lang.Integer.valueOf(-number.byteValue());
        }
        if (number instanceof java.lang.Short) {
            return java.lang.Integer.valueOf(-number.shortValue());
        }
        if (number instanceof java.lang.Long) {
            return java.lang.Long.valueOf(-number.longValue());
        }
        return number instanceof java.lang.Float ? java.lang.Float.valueOf(-number.floatValue()) : java.lang.Double.valueOf(-number.doubleValue());
    }

    public static final java.lang.Number and(java.lang.Number number, java.lang.Number next) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(next, "next");
        return java.lang.Integer.valueOf(number.intValue() & next.intValue());
    }

    public static final java.lang.Number or(java.lang.Number number, java.lang.Number next) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(next, "next");
        if (!(next instanceof java.lang.Double) && !(next instanceof java.lang.Float) && !(number instanceof java.lang.Double) && !(number instanceof java.lang.Float)) {
            return java.lang.Integer.valueOf(number.intValue() | next.intValue());
        }
        return java.lang.Integer.valueOf(io.dcloud.uts.JSNumberUtil.INSTANCE.doubleToInt32(number.doubleValue()) | io.dcloud.uts.JSNumberUtil.INSTANCE.doubleToInt32(next.doubleValue()));
    }

    public static final java.lang.Number xor(java.lang.Number number, java.lang.Number next) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(next, "next");
        return java.lang.Integer.valueOf(number.intValue() ^ next.intValue());
    }

    public static final java.lang.Number inv(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        return java.lang.Integer.valueOf(~number.intValue());
    }

    public static final java.lang.Number shl(java.lang.Number number, java.lang.Number next) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(next, "next");
        return java.lang.Integer.valueOf(number.intValue() << next.intValue());
    }

    public static final java.lang.Number shr(java.lang.Number number, java.lang.Number next) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(next, "next");
        return java.lang.Integer.valueOf(number.intValue() >> next.intValue());
    }

    public static final java.lang.Number ushr(java.lang.Number number, java.lang.Number next) {
        int iDoubleToInt32;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(next, "next");
        if ((number instanceof java.lang.Double) || (number instanceof java.lang.Float)) {
            iDoubleToInt32 = io.dcloud.uts.JSNumberUtil.INSTANCE.doubleToInt32(number.doubleValue());
        } else {
            iDoubleToInt32 = (int) (number.longValue() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT);
        }
        int iIntValue = iDoubleToInt32 >>> (next.intValue() & 31);
        if (iIntValue < 0) {
            return java.lang.Long.valueOf(((long) iIntValue) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT);
        }
        return java.lang.Long.valueOf(iIntValue);
    }

    public static final kotlin.ranges.IntRange rangeTo(java.lang.Number number, java.lang.Number other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return rangeTo(number.intValue(), other);
    }

    public static final kotlin.ranges.IntRange rangeTo(java.lang.Number number, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        return new kotlin.ranges.IntRange(number.intValue(), i);
    }

    public static final kotlin.ranges.LongRange rangeTo(java.lang.Number number, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<this>");
        return new kotlin.ranges.LongRange(number.longValue(), j);
    }

    public static final kotlin.ranges.IntRange rangeTo(int i, java.lang.Number other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return new kotlin.ranges.IntRange(i, other.intValue());
    }

    public static final kotlin.ranges.LongRange rangeTo(long j, java.lang.Number other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return new kotlin.ranges.LongRange(j, other.longValue());
    }
}
