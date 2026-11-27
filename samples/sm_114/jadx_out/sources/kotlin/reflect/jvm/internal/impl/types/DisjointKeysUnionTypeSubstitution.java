package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DisjointKeysUnionTypeSubstitution extends kotlin.reflect.jvm.internal.impl.types.TypeSubstitution {
    public static final kotlin.reflect.jvm.internal.impl.types.DisjointKeysUnionTypeSubstitution.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.DisjointKeysUnionTypeSubstitution.Companion(null);
    private final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution first;
    private final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution second;

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(typeSubstitution, typeSubstitution2);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution create(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution2) {
        return Companion.create(typeSubstitution, typeSubstitution2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    /* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution create(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution first, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution second) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(first, "first");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(second, "second");
            if (first.isEmpty()) {
                return second;
            }
            return second.isEmpty() ? first : new kotlin.reflect.jvm.internal.impl.types.DisjointKeysUnionTypeSubstitution(first, second, null);
        }
    }

    private DisjointKeysUnionTypeSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution2) {
        this.first = typeSubstitution;
        this.second = typeSubstitution2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection mo1840get(kotlin.reflect.jvm.internal.impl.types.KotlinType key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionMo1840get = this.first.mo1840get(key);
        return typeProjectionMo1840get == null ? this.second.mo1840get(key) : typeProjectionMo1840get;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public kotlin.reflect.jvm.internal.impl.types.KotlinType prepareTopLevelType(kotlin.reflect.jvm.internal.impl.types.KotlinType topLevelType, kotlin.reflect.jvm.internal.impl.types.Variance position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(topLevelType, "topLevelType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(position, "position");
        return this.second.prepareTopLevelType(this.first.prepareTopLevelType(topLevelType, position), position);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        return this.first.approximateCapturedTypes() || this.second.approximateCapturedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.first.approximateContravariantCapturedTypes() || this.second.approximateContravariantCapturedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations filterAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        return this.second.filterAnnotations(this.first.filterAnnotations(annotations));
    }
}
