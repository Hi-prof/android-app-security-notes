package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypedArrayValue extends kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue {
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType type;

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType _init_$lambda$0(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return kotlinType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypedArrayValue(java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> value, final kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        super(value, new kotlin.jvm.functions.Function1(type) { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.types.KotlinType arg$0;

            {
                this.arg$0 = type;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue._init_$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor) obj);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
        return this.type;
    }
}
