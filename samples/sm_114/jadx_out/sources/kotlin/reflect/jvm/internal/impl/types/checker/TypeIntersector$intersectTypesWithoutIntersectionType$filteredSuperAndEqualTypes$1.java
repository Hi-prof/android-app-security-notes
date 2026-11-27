package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function2<kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType, java.lang.Boolean> {
    TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(java.lang.Object obj) {
        super(2, obj, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl.class, "equalTypes", "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final java.lang.Boolean invoke(kotlin.reflect.jvm.internal.impl.types.KotlinType p0, kotlin.reflect.jvm.internal.impl.types.KotlinType p1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p1, "p1");
        return java.lang.Boolean.valueOf(((kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl) this.receiver).equalTypes(p0, p1));
    }
}
