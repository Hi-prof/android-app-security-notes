package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: InlineClassRepresentation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineClassRepresentation<Type extends kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> extends kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<Type> {
    private final kotlin.reflect.jvm.internal.impl.name.Name underlyingPropertyName;
    private final Type underlyingType;

    public final kotlin.reflect.jvm.internal.impl.name.Name getUnderlyingPropertyName() {
        return this.underlyingPropertyName;
    }

    public final Type getUnderlyingType() {
        return this.underlyingType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineClassRepresentation(kotlin.reflect.jvm.internal.impl.name.Name underlyingPropertyName, Type underlyingType) {
        super(null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(underlyingPropertyName, "underlyingPropertyName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(underlyingType, "underlyingType");
        this.underlyingPropertyName = underlyingPropertyName;
        this.underlyingType = underlyingType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public boolean containsPropertyWithName(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.jvm.internal.Intrinsics.areEqual(this.underlyingPropertyName, name);
    }

    public java.lang.String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.underlyingPropertyName + ", underlyingType=" + this.underlyingType + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
