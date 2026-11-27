package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeSubstitution {
    public static final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution EMPTY = new kotlin.reflect.jvm.internal.impl.types.TypeSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeSubstitution$Companion$EMPTY$1
        public java.lang.Void get(kotlin.reflect.jvm.internal.impl.types.KotlinType key) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
        public boolean isEmpty() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
        /* JADX INFO: renamed from: get, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.types.TypeProjection mo1840get(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
            return (kotlin.reflect.jvm.internal.impl.types.TypeProjection) get(kotlinType);
        }

        public java.lang.String toString() {
            return "Empty TypeSubstitution";
        }
    };

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations filterAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        return annotations;
    }

    /* JADX INFO: renamed from: get */
    public abstract kotlin.reflect.jvm.internal.impl.types.TypeProjection mo1840get(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType);

    public boolean isEmpty() {
        return false;
    }

    public kotlin.reflect.jvm.internal.impl.types.KotlinType prepareTopLevelType(kotlin.reflect.jvm.internal.impl.types.KotlinType topLevelType, kotlin.reflect.jvm.internal.impl.types.Variance position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(topLevelType, "topLevelType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(position, "position");
        return topLevelType;
    }

    /* JADX INFO: compiled from: TypeSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor buildSubstitutor() {
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorCreate = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(this);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeSubstitutorCreate, "create(...)");
        return typeSubstitutorCreate;
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeSubstitution replaceWithNonApproximating() {
        return new kotlin.reflect.jvm.internal.impl.types.TypeSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.replaceWithNonApproximating.1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public boolean approximateCapturedTypes() {
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public boolean approximateContravariantCapturedTypes() {
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            /* JADX INFO: renamed from: get */
            public kotlin.reflect.jvm.internal.impl.types.TypeProjection mo1840get(kotlin.reflect.jvm.internal.impl.types.KotlinType key) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
                return kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.this.mo1840get(key);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations filterAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
                return kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.this.filterAnnotations(annotations);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public kotlin.reflect.jvm.internal.impl.types.KotlinType prepareTopLevelType(kotlin.reflect.jvm.internal.impl.types.KotlinType topLevelType, kotlin.reflect.jvm.internal.impl.types.Variance position) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(topLevelType, "topLevelType");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(position, "position");
                return kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.this.prepareTopLevelType(topLevelType, position);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public boolean isEmpty() {
                return kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.this.isEmpty();
            }
        };
    }
}
