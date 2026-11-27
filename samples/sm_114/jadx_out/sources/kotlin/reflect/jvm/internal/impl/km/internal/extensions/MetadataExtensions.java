package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

/* JADX INFO: compiled from: MetadataExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface MetadataExtensions {
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion Companion = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.$$INSTANCE;

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension createClassExtension();

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension createConstructorExtension();

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension createEnumEntryExtension();

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension createFunctionExtension();

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension createPropertyExtension();

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension createTypeAliasExtension();

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension createTypeExtension();

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension createTypeParameterExtension();

    kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension createValueParameterExtension();

    void readClassExtensions(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class r2, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void readConstructorExtensions(kotlin.reflect.jvm.internal.impl.km.KmConstructor kmConstructor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor constructor, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void readEnumEntryExtensions(kotlin.reflect.jvm.internal.impl.km.KmEnumEntry kmEnumEntry, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry enumEntry, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void readFunctionExtensions(kotlin.reflect.jvm.internal.impl.km.KmFunction kmFunction, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function function, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void readPropertyExtensions(kotlin.reflect.jvm.internal.impl.km.KmProperty kmProperty, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void readTypeAliasExtensions(kotlin.reflect.jvm.internal.impl.km.KmTypeAlias kmTypeAlias, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias typeAlias, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void readTypeExtensions(kotlin.reflect.jvm.internal.impl.km.KmType kmType, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void readTypeParameterExtensions(kotlin.reflect.jvm.internal.impl.km.KmTypeParameter kmTypeParameter, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void readValueParameterExtensions(kotlin.reflect.jvm.internal.impl.km.KmValueParameter kmValueParameter, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter valueParameter, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext);

    void writePropertyExtensions(kotlin.reflect.jvm.internal.impl.km.KmProperty kmProperty, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.Builder builder, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext);

    void writeTypeExtensions(kotlin.reflect.jvm.internal.impl.km.KmType kmType, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Builder builder, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext);

    void writeTypeParameterExtensions(kotlin.reflect.jvm.internal.impl.km.KmTypeParameter kmTypeParameter, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Builder builder, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext);

    void writeValueParameterExtensions(kotlin.reflect.jvm.internal.impl.km.KmValueParameter kmValueParameter, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.Builder builder, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext);

    /* JADX INFO: compiled from: MetadataExtensions.kt */
    public static final class Companion {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion $$INSTANCE = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion();
        private static final kotlin.Lazy<java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions>> INSTANCES$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions$Companion$$Lambda$0
            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.INSTANCES_delegate$lambda$1();
            }
        });

        private Companion() {
        }

        public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> getINSTANCES$kotlin_metadata() {
            return INSTANCES$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List INSTANCES_delegate$lambda$1() {
            java.util.ServiceLoader serviceLoaderLoad = java.util.ServiceLoader.load(kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.class, kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.class.getClassLoader());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(serviceLoaderLoad, "load(...)");
            java.util.List list = kotlin.collections.CollectionsKt.toList(serviceLoaderLoad);
            if (list.isEmpty()) {
                throw new java.lang.IllegalStateException("No MetadataExtensions instances found in the classpath. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager".toString());
            }
            return list;
        }
    }
}
