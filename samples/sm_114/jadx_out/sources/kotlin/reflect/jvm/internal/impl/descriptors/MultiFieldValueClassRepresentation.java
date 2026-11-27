package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: MultiFieldValueClassRepresentation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MultiFieldValueClassRepresentation<Type extends kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> extends kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<Type> {
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, Type> map;
    private final java.util.List<kotlin.Pair<kotlin.reflect.jvm.internal.impl.name.Name, Type>> underlyingPropertyNamesToTypes;

    public java.util.List<kotlin.Pair<kotlin.reflect.jvm.internal.impl.name.Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MultiFieldValueClassRepresentation(java.util.List<? extends kotlin.Pair<kotlin.reflect.jvm.internal.impl.name.Name, ? extends Type>> underlyingPropertyNamesToTypes) {
        super(null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(underlyingPropertyNamesToTypes, "underlyingPropertyNamesToTypes");
        this.underlyingPropertyNamesToTypes = underlyingPropertyNamesToTypes;
        this.map = kotlin.collections.MapsKt.toMap(getUnderlyingPropertyNamesToTypes());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public boolean containsPropertyWithName(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return this.map.containsKey(name);
    }

    public java.lang.String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + getUnderlyingPropertyNamesToTypes() + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
