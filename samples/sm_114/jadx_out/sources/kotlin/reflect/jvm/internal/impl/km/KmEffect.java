package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Contracts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmEffect {
    private kotlin.reflect.jvm.internal.impl.km.KmEffectExpression conclusion;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> constructorArguments;
    private kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind invocationKind;
    private kotlin.reflect.jvm.internal.impl.km.KmEffectType type;

    public KmEffect(kotlin.reflect.jvm.internal.impl.km.KmEffectType type, kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind kmEffectInvocationKind) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.invocationKind = kmEffectInvocationKind;
        this.constructorArguments = new java.util.ArrayList(1);
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> getConstructorArguments() {
        return this.constructorArguments;
    }

    public final void setConclusion(kotlin.reflect.jvm.internal.impl.km.KmEffectExpression kmEffectExpression) {
        this.conclusion = kmEffectExpression;
    }
}
