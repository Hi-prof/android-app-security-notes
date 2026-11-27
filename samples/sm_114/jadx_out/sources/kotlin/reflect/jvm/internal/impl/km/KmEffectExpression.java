package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Contracts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmEffectExpression {
    private kotlin.reflect.jvm.internal.impl.km.KmConstantValue constantValue;
    private int flags;
    private kotlin.reflect.jvm.internal.impl.km.KmType isInstanceType;
    private java.lang.Integer parameterIndex;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> andArguments = new java.util.ArrayList(0);
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> orArguments = new java.util.ArrayList(0);

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final void setParameterIndex(java.lang.Integer num) {
        this.parameterIndex = num;
    }

    public final void setConstantValue(kotlin.reflect.jvm.internal.impl.km.KmConstantValue kmConstantValue) {
        this.constantValue = kmConstantValue;
    }

    public final void setInstanceType(kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        this.isInstanceType = kmType;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> getAndArguments() {
        return this.andArguments;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> getOrArguments() {
        return this.orArguments;
    }
}
