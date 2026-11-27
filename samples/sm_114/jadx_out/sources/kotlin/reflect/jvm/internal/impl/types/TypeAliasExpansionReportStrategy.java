package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface TypeAliasExpansionReportStrategy {
    void boundsViolationInSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType);

    void recursiveTypeAlias(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor);

    /* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class DO_NOTHING implements kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy {
        public static final kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy.DO_NOTHING INSTANCE = new kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy.DO_NOTHING();

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor substitutor, kotlin.reflect.jvm.internal.impl.types.KotlinType unsubstitutedArgument, kotlin.reflect.jvm.internal.impl.types.KotlinType argument, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitutor, "substitutor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unsubstitutedArgument, "unsubstitutedArgument");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(argument, "argument");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void conflictingProjection(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAlias, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType substitutedArgument) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAlias, "typeAlias");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitutedArgument, "substitutedArgument");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAlias) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAlias, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotation) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        }

        private DO_NOTHING() {
        }
    }
}
