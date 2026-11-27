package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u0007*\u00060\bj\u0002`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u0007*\u00060\bj\u0002`\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "<init>", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderCallable", "", "descriptor", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReflectionObjectRenderer {
    public static final kotlin.reflect.jvm.internal.ReflectionObjectRenderer INSTANCE = new kotlin.reflect.jvm.internal.ReflectionObjectRenderer();
    private static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer renderer = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.FQ_NAMES_IN_TYPES;

    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.KParameter.Kind.values().length];
            try {
                iArr[kotlin.reflect.KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.KParameter.Kind.INSTANCE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.KParameter.Kind.VALUE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ReflectionObjectRenderer() {
    }

    private final void appendReceiverType(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = receiverParameterDescriptor.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            sb.append(renderType(type));
            sb.append(com.taobao.weex.el.parse.Operators.DOT_STR);
        }
    }

    private final void appendReceivers(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor instanceReceiverParameter = kotlin.reflect.jvm.internal.UtilKt.getInstanceReceiverParameter(callableDescriptor);
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        appendReceiverType(sb, instanceReceiverParameter);
        boolean z = (instanceReceiverParameter == null || extensionReceiverParameter == null) ? false : true;
        if (z) {
            sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
        }
        appendReceiverType(sb, extensionReceiverParameter);
        if (z) {
            sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
    }

    private final java.lang.String renderCallable(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor descriptor) {
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) {
            return renderProperty((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) descriptor);
        }
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) {
            return renderFunction((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) descriptor);
        }
        throw new java.lang.IllegalStateException(("Illegal callable: " + descriptor).toString());
    }

    public final java.lang.String renderProperty(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(descriptor.isVar() ? "var " : "val ");
        kotlin.reflect.jvm.internal.ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, descriptor);
        kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer descriptorRenderer = renderer;
        kotlin.reflect.jvm.internal.impl.name.Name name = descriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        sb.append(descriptorRenderer.renderName(name, true));
        sb.append(": ");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = descriptor.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        sb.append(reflectionObjectRenderer.renderType(type));
        return sb.toString();
    }

    public final java.lang.String renderFunction(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("fun ");
        kotlin.reflect.jvm.internal.ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, descriptor);
        kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer descriptorRenderer = renderer;
        kotlin.reflect.jvm.internal.impl.name.Name name = descriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        sb.append(descriptorRenderer.renderName(name, true));
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        kotlin.collections.CollectionsKt.joinTo(valueParameters, sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : com.taobao.weex.el.parse.Operators.BRACKET_START_STR, (112 & 8) != 0 ? "" : com.taobao.weex.el.parse.Operators.BRACKET_END_STR, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.ReflectionObjectRenderer.renderFunction$lambda$2$lambda$1((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj);
            }
        });
        sb.append(": ");
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = descriptor.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        sb.append(reflectionObjectRenderer.renderType(returnType));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence renderFunction$lambda$2$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor) {
        kotlin.reflect.jvm.internal.ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = valueParameterDescriptor.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return reflectionObjectRenderer.renderType(type);
    }

    public final java.lang.String renderLambda(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor invoke) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(invoke, "invoke");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        kotlin.reflect.jvm.internal.ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, invoke);
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = invoke.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        kotlin.collections.CollectionsKt.joinTo(valueParameters, sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : com.taobao.weex.el.parse.Operators.BRACKET_START_STR, (112 & 8) != 0 ? "" : com.taobao.weex.el.parse.Operators.BRACKET_END_STR, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.ReflectionObjectRenderer.renderLambda$lambda$4$lambda$3((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj);
            }
        });
        sb.append(" -> ");
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = invoke.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        sb.append(reflectionObjectRenderer.renderType(returnType));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence renderLambda$lambda$4$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor) {
        kotlin.reflect.jvm.internal.ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = valueParameterDescriptor.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return reflectionObjectRenderer.renderType(type);
    }

    public final java.lang.String renderParameter(kotlin.reflect.jvm.internal.KParameterImpl parameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameter, "parameter");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = kotlin.reflect.jvm.internal.ReflectionObjectRenderer.WhenMappings.$EnumSwitchMapping$0[parameter.getKind().ordinal()];
        if (i == 1) {
            sb.append("extension receiver parameter");
        } else if (i == 2) {
            sb.append("instance parameter");
        } else {
            if (i != 3) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            sb.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
        }
        sb.append(" of ");
        sb.append(INSTANCE.renderCallable(parameter.getCallable().getDescriptor()));
        return sb.toString();
    }

    public final java.lang.String renderType(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return renderer.renderType(type);
    }
}
