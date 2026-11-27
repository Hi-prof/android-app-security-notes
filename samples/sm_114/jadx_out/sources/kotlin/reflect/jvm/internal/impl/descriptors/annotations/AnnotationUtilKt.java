package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: compiled from: annotationUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnnotationUtilKt {
    private static final kotlin.reflect.jvm.internal.impl.name.Name DEPRECATED_LEVEL_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.Name DEPRECATED_MESSAGE_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.Name DEPRECATED_REPLACE_WITH_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.Name REPLACE_WITH_EXPRESSION_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.Name REPLACE_WITH_IMPORTS_NAME;

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor createDeprecatedAnnotation$default(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3, z);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor createDeprecatedAnnotation(final kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns, java.lang.String message, java.lang.String replaceWith, java.lang.String level, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replaceWith, "replaceWith");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(level, "level");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor(kotlinBuiltIns, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.replaceWith, kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(REPLACE_WITH_EXPRESSION_NAME, new kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue(replaceWith)), kotlin.TuplesKt.to(REPLACE_WITH_IMPORTS_NAME, new kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue(kotlin.collections.CollectionsKt.emptyList(), new kotlin.jvm.functions.Function1(kotlinBuiltIns) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns arg$0;

            {
                this.arg$0 = kotlinBuiltIns;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt.createDeprecatedAnnotation$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor) obj);
            }
        }))), false, 8, null);
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.deprecated;
        kotlin.reflect.jvm.internal.impl.name.Name name = DEPRECATED_LEVEL_NAME;
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.deprecationLevel);
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(level);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(DEPRECATED_MESSAGE_NAME, new kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue(message)), kotlin.TuplesKt.to(DEPRECATED_REPLACE_WITH_NAME, new kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue(builtInAnnotationDescriptor)), kotlin.TuplesKt.to(name, new kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue(classId, nameIdentifier))), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType createDeprecatedAnnotation$lambda$0(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.reflect.jvm.internal.impl.types.SimpleType arrayType = module.getBuiltIns().getArrayType(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlinBuiltIns.getStringType());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrayType, "getArrayType(...)");
        return arrayType;
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("message");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        DEPRECATED_MESSAGE_NAME = nameIdentifier;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("replaceWith");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        DEPRECATED_REPLACE_WITH_NAME = nameIdentifier2;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier3 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(androidtranscoder.format.MediaFormatExtraConstants.KEY_LEVEL);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier3, "identifier(...)");
        DEPRECATED_LEVEL_NAME = nameIdentifier3;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier4 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_EXPRESSION);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier4, "identifier(...)");
        REPLACE_WITH_EXPRESSION_NAME = nameIdentifier4;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier5 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("imports");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier5, "identifier(...)");
        REPLACE_WITH_IMPORTS_NAME = nameIdentifier5;
    }
}
