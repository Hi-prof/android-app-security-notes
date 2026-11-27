package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KotlinTypeRefinerKt {
    private static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.types.checker.Ref<kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport>> REFINER_CAPABILITY = new kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<>("KotlinTypeRefiner");

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.types.checker.Ref<kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }

    public static final java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> refineTypes(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> types) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(types, 10));
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) it.next()));
        }
        return arrayList;
    }
}
