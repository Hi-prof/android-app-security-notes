package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PredefinedEnhancementInfoKt {
    private static final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers NULLABLE = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers NOT_PLATFORM = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers NOT_NULLABLE = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL, null, true, false, 8, null);

    static {
        final kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        final java.lang.String strJavaLang = signatureBuildingComponents.javaLang("Object");
        final java.lang.String strJavaFunction = signatureBuildingComponents.javaFunction("Predicate");
        final java.lang.String strJavaFunction2 = signatureBuildingComponents.javaFunction("Function");
        final java.lang.String strJavaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        final java.lang.String strJavaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        final java.lang.String strJavaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        final java.lang.String strJavaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        final java.lang.String strJavaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        final java.lang.String strJavaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder signatureEnhancementBuilder = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder();
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator")), "forEachRemaining", null, new kotlin.jvm.functions.Function1(strJavaFunction3) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$0
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaFunction3;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$1$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("Iterable")), "spliterator", null, new kotlin.jvm.functions.Function1(signatureBuildingComponents) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents arg$0;

            {
                this.arg$0 = signatureBuildingComponents;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$3$lambda$2(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Collection"));
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder, "removeIf", null, new kotlin.jvm.functions.Function1(strJavaFunction) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$2
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaFunction;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$4(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_STREAM, null, new kotlin.jvm.functions.Function1(strJavaUtil) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$3
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaUtil;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$5(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder, "parallelStream", null, new kotlin.jvm.functions.Function1(strJavaUtil) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$4
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaUtil;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$6(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("List"));
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder2, "replaceAll", null, new kotlin.jvm.functions.Function1(strJavaFunction6) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$5
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaFunction6;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$8(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        classEnhancementBuilder2.function("addFirst", "2.1", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$6
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$9(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("addLast", "2.1", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$7
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$10(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("removeFirst", "2.1", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$8
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$11(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("removeLast", "2.1", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$9
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$12(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("LinkedList"));
        classEnhancementBuilder3.function("addFirst", "2.1", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$10
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$14(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("addLast", "2.1", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$11
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$15(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("removeFirst", "2.1", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$12
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$16(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("removeLast", "2.1", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$13
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$17(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder4 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("LinkedHashSet"));
        classEnhancementBuilder4.function("addFirst", "2.2", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$14
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$19(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder4.function("addLast", "2.2", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$15
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$20(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder4.function("removeFirst", "2.2", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$16
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$21(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder4.function("removeLast", "2.2", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$17
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$22(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder4.function("getFirst", "2.2", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$18
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$23(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder4.function("getLast", "2.2", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$19
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$24(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder5 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Map"));
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "forEach", null, new kotlin.jvm.functions.Function1(strJavaFunction5) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$20
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaFunction5;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$26(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "putIfAbsent", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$21
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$27(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "replace", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$22
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$28(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "replace", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$23
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$29(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "replaceAll", null, new kotlin.jvm.functions.Function1(strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$24
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$30(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "compute", null, new kotlin.jvm.functions.Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$25
            private final java.lang.String arg$0;
            private final java.lang.String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$31(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "computeIfAbsent", null, new kotlin.jvm.functions.Function1(strJavaLang, strJavaFunction2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$26
            private final java.lang.String arg$0;
            private final java.lang.String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction2;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$32(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "computeIfPresent", null, new kotlin.jvm.functions.Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$27
            private final java.lang.String arg$0;
            private final java.lang.String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$33(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "merge", null, new kotlin.jvm.functions.Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$28
            private final java.lang.String arg$0;
            private final java.lang.String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$34(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder6 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("LinkedHashMap"));
        classEnhancementBuilder6.function("putFirst", "2.2", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$29
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$38$lambda$36(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder6.function("putLast", "2.2", new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$30
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$38$lambda$37(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaUtil2);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder7, "empty", null, new kotlin.jvm.functions.Function1(strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$31
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$39(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder7, "of", null, new kotlin.jvm.functions.Function1(strJavaLang, strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$32
            private final java.lang.String arg$0;
            private final java.lang.String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$40(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder7, "ofNullable", null, new kotlin.jvm.functions.Function1(strJavaLang, strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$33
            private final java.lang.String arg$0;
            private final java.lang.String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$41(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder7, "get", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$34
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$42(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder7, "ifPresent", null, new kotlin.jvm.functions.Function1(strJavaFunction3) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$35
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaFunction3;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$43(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("ref/Reference")), "get", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$36
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$46$lambda$45(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction), "test", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$37
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$48$lambda$47(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("BiPredicate")), "test", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$38
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$50$lambda$49(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction3), "accept", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$39
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$52$lambda$51(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction5), "accept", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$40
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$54$lambda$53(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction2), "apply", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$41
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$56$lambda$55(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction4), "apply", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$42
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$58$lambda$57(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("Supplier")), "get", null, new kotlin.jvm.functions.Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$43
            private final java.lang.String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$60$lambda$59(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    public static final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$1$lambda$0(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$3$lambda$2(kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        java.lang.String strJavaUtil = signatureBuildingComponents.javaUtil("Spliterator");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(strJavaUtil, javaTypeQualifiers, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$4(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers);
        function.returns(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$5(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(str, javaTypeQualifiers, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$6(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(str, javaTypeQualifiers, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$8(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$9(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$10(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$11(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$12(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$14(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$15(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$16(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$17(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$19(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$20(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$21(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$22(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$23(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$24(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$26(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$27(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$28(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$29(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$30(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$31(java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers2 = NULLABLE;
        function.parameter(str2, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers2);
        function.returns(str, javaTypeQualifiers2);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$32(java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str2, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        function.returns(str, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$33(java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers2 = NULLABLE;
        function.parameter(str2, javaTypeQualifiers, javaTypeQualifiers, NOT_NULLABLE, javaTypeQualifiers2);
        function.returns(str, javaTypeQualifiers2);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$34(java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers2 = NOT_NULLABLE;
        function.parameter(str, javaTypeQualifiers2);
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers3 = NULLABLE;
        function.parameter(str2, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers2, javaTypeQualifiers3);
        function.returns(str, javaTypeQualifiers3);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$38$lambda$36(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$38$lambda$37(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$39(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM, NOT_NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$40(java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_NULLABLE;
        function.parameter(str, javaTypeQualifiers);
        function.returns(str2, NOT_PLATFORM, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$41(java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NULLABLE);
        function.returns(str2, NOT_PLATFORM, NOT_NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$42(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$43(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM, NOT_NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$46$lambda$45(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NULLABLE);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$48$lambda$47(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        function.returns(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$50$lambda$49(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$52$lambda$51(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$54$lambda$53(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$56$lambda$55(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$58$lambda$57(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, javaTypeQualifiers);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$60$lambda$59(java.lang.String str, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return kotlin.Unit.INSTANCE;
    }
}
