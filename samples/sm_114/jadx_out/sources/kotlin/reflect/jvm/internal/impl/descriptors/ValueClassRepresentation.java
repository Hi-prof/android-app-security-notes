package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: ValueClassRepresentation.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ValueClassRepresentation<Type extends kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> {
    public /* synthetic */ ValueClassRepresentation(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean containsPropertyWithName(kotlin.reflect.jvm.internal.impl.name.Name name);

    private ValueClassRepresentation() {
    }

    public final <Other extends kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<Other> mapUnderlyingType(kotlin.jvm.functions.Function1<? super Type, ? extends Other> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        if (this instanceof kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation) {
            kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation inlineClassRepresentation = (kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation) this;
            return new kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation(inlineClassRepresentation.getUnderlyingPropertyName(), transform.invoke(inlineClassRepresentation.getUnderlyingType()));
        }
        if (!(this instanceof kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation)) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        java.util.List<kotlin.Pair<kotlin.reflect.jvm.internal.impl.name.Name, Type>> underlyingPropertyNamesToTypes = ((kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation) this).getUnderlyingPropertyNamesToTypes();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(underlyingPropertyNamesToTypes, 10));
        java.util.Iterator<T> it = underlyingPropertyNamesToTypes.iterator();
        while (it.hasNext()) {
            kotlin.Pair pair = (kotlin.Pair) it.next();
            arrayList.add(kotlin.TuplesKt.to((kotlin.reflect.jvm.internal.impl.name.Name) pair.component1(), transform.invoke((kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) pair.component2())));
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation(arrayList);
    }
}
