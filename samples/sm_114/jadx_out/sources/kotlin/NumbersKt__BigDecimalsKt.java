package kotlin;

/* JADX INFO: compiled from: BigDecimals.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000bH\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000eH\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000fH\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0010H\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0087\b¨\u0006\u0011"}, d2 = {io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS, "Ljava/math/BigDecimal;", "other", "minus", "times", com.taobao.weex.ui.component.WXBasicComponentType.DIV, "rem", "unaryMinus", "inc", "dec", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt {
    private static final java.math.BigDecimal plus(java.math.BigDecimal bigDecimal, java.math.BigDecimal other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        java.math.BigDecimal bigDecimalAdd = bigDecimal.add(other);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
        return bigDecimalAdd;
    }

    private static final java.math.BigDecimal minus(java.math.BigDecimal bigDecimal, java.math.BigDecimal other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        java.math.BigDecimal bigDecimalSubtract = bigDecimal.subtract(other);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, "subtract(...)");
        return bigDecimalSubtract;
    }

    private static final java.math.BigDecimal times(java.math.BigDecimal bigDecimal, java.math.BigDecimal other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        java.math.BigDecimal bigDecimalMultiply = bigDecimal.multiply(other);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "multiply(...)");
        return bigDecimalMultiply;
    }

    private static final java.math.BigDecimal div(java.math.BigDecimal bigDecimal, java.math.BigDecimal other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        java.math.BigDecimal bigDecimalDivide = bigDecimal.divide(other, java.math.RoundingMode.HALF_EVEN);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalDivide, "divide(...)");
        return bigDecimalDivide;
    }

    private static final java.math.BigDecimal rem(java.math.BigDecimal bigDecimal, java.math.BigDecimal other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        java.math.BigDecimal bigDecimalRemainder = bigDecimal.remainder(other);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalRemainder, "remainder(...)");
        return bigDecimalRemainder;
    }

    private static final java.math.BigDecimal unaryMinus(java.math.BigDecimal bigDecimal) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        java.math.BigDecimal bigDecimalNegate = bigDecimal.negate();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalNegate, "negate(...)");
        return bigDecimalNegate;
    }

    private static final java.math.BigDecimal inc(java.math.BigDecimal bigDecimal) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        java.math.BigDecimal bigDecimalAdd = bigDecimal.add(java.math.BigDecimal.ONE);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
        return bigDecimalAdd;
    }

    private static final java.math.BigDecimal dec(java.math.BigDecimal bigDecimal) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        java.math.BigDecimal bigDecimalSubtract = bigDecimal.subtract(java.math.BigDecimal.ONE);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, "subtract(...)");
        return bigDecimalSubtract;
    }

    private static final java.math.BigDecimal toBigDecimal(int i) {
        java.math.BigDecimal bigDecimalValueOf = java.math.BigDecimal.valueOf(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        return bigDecimalValueOf;
    }

    private static final java.math.BigDecimal toBigDecimal(int i, java.math.MathContext mathContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new java.math.BigDecimal(i, mathContext);
    }

    private static final java.math.BigDecimal toBigDecimal(long j) {
        java.math.BigDecimal bigDecimalValueOf = java.math.BigDecimal.valueOf(j);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        return bigDecimalValueOf;
    }

    private static final java.math.BigDecimal toBigDecimal(long j, java.math.MathContext mathContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new java.math.BigDecimal(j, mathContext);
    }

    private static final java.math.BigDecimal toBigDecimal(float f) {
        return new java.math.BigDecimal(java.lang.String.valueOf(f));
    }

    private static final java.math.BigDecimal toBigDecimal(float f, java.math.MathContext mathContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new java.math.BigDecimal(java.lang.String.valueOf(f), mathContext);
    }

    private static final java.math.BigDecimal toBigDecimal(double d) {
        return new java.math.BigDecimal(java.lang.String.valueOf(d));
    }

    private static final java.math.BigDecimal toBigDecimal(double d, java.math.MathContext mathContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new java.math.BigDecimal(java.lang.String.valueOf(d), mathContext);
    }
}
