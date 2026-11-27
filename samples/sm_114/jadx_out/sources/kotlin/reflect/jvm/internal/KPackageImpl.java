package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001)B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020(H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015¨\u0006*"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "data", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "methodOwner", "getMethodOwner", com.taobao.weex.common.Constants.Name.SCOPE, "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "equals", "", "other", "", "hashCode", "toString", "", "Data", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KPackageImpl extends kotlin.reflect.jvm.internal.KDeclarationContainerImpl {
    private final kotlin.Lazy<kotlin.reflect.jvm.internal.KPackageImpl.Data> data;
    private final java.lang.Class<?> jClass;

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public java.lang.Class<?> getJClass() {
        return this.jClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: KPackageImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR!\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR%\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", com.taobao.weex.common.Constants.Name.SCOPE, "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope$delegate", "multifileFacade", "Ljava/lang/Class;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade$delegate", "Lkotlin/Lazy;", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/MetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    final class Data extends kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data {
        static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KPackageImpl.Data.class, "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KPackageImpl.Data.class, com.taobao.weex.common.Constants.Name.SCOPE, "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KPackageImpl.Data.class, "members", "getMembers()Ljava/util/Collection;", 0))};

        /* JADX INFO: renamed from: kotlinClass$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal kotlinClass;

        /* JADX INFO: renamed from: members$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal members;

        /* JADX INFO: renamed from: metadata$delegate, reason: from kotlin metadata */
        private final kotlin.Lazy metadata;

        /* JADX INFO: renamed from: multifileFacade$delegate, reason: from kotlin metadata */
        private final kotlin.Lazy multifileFacade;

        /* JADX INFO: renamed from: scope$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal scope;

        public Data() {
            super();
            this.kotlinClass = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KPackageImpl.this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$0
                private final kotlin.reflect.jvm.internal.KPackageImpl arg$0;

                {
                    this.arg$0 = kPackageImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KPackageImpl.Data.kotlinClass_delegate$lambda$0(this.arg$0);
                }
            });
            this.scope = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$1
                private final kotlin.reflect.jvm.internal.KPackageImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KPackageImpl.Data.scope_delegate$lambda$1(this.arg$0);
                }
            });
            this.multifileFacade = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this, kotlin.reflect.jvm.internal.KPackageImpl.this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$2
                private final kotlin.reflect.jvm.internal.KPackageImpl.Data arg$0;
                private final kotlin.reflect.jvm.internal.KPackageImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kPackageImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KPackageImpl.Data.multifileFacade_delegate$lambda$2(this.arg$0, this.arg$1);
                }
            });
            this.metadata = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$3
                private final kotlin.reflect.jvm.internal.KPackageImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KPackageImpl.Data.metadata_delegate$lambda$4(this.arg$0);
                }
            });
            this.members = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KPackageImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$4
                private final kotlin.reflect.jvm.internal.KPackageImpl arg$0;
                private final kotlin.reflect.jvm.internal.KPackageImpl.Data arg$1;

                {
                    this.arg$0 = kPackageImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KPackageImpl.Data.members_delegate$lambda$5(this.arg$0, this.arg$1);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass getKotlinClass() {
            return (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass) this.kotlinClass.getValue(this, $$delegatedProperties[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass kotlinClass_delegate$lambda$0(kotlin.reflect.jvm.internal.KPackageImpl kPackageImpl) {
            return kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory.create(kPackageImpl.getJClass());
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getScope() {
            T value = this.scope.getValue(this, $$delegatedProperties[1]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope scope_delegate$lambda$1(kotlin.reflect.jvm.internal.KPackageImpl.Data data) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass kotlinClass = data.getKotlinClass();
            if (kotlinClass != null) {
                return data.getModuleData().getPackagePartScopeCache().getPackagePartScope(kotlinClass);
            }
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
        }

        public final java.lang.Class<?> getMultifileFacade() {
            return (java.lang.Class) this.multifileFacade.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.lang.Class multifileFacade_delegate$lambda$2(kotlin.reflect.jvm.internal.KPackageImpl.Data data, kotlin.reflect.jvm.internal.KPackageImpl kPackageImpl) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader classHeader;
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass kotlinClass = data.getKotlinClass();
            java.lang.String multifileClassName = (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
            if (multifileClassName == null || multifileClassName.length() <= 0) {
                return null;
            }
            return kPackageImpl.getJClass().getClassLoader().loadClass(kotlin.text.StringsKt.replace$default(multifileClassName, '/', com.taobao.weex.el.parse.Operators.DOT, false, 4, (java.lang.Object) null));
        }

        public final kotlin.Triple<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion> getMetadata() {
            return (kotlin.Triple) this.metadata.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Triple metadata_delegate$lambda$4(kotlin.reflect.jvm.internal.KPackageImpl.Data data) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader classHeader;
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass kotlinClass = data.getKotlinClass();
            if (kotlinClass != null && (classHeader = kotlinClass.getClassHeader()) != null) {
                java.lang.String[] data2 = classHeader.getData();
                java.lang.String[] strings = classHeader.getStrings();
                if (data2 != null && strings != null) {
                    kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package> packageDataFrom = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.readPackageDataFrom(data2, strings);
                    return new kotlin.Triple(packageDataFrom.component1(), packageDataFrom.component2(), classHeader.getMetadataVersion());
                }
            }
            return null;
        }

        public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getMembers() {
            T value = this.members.getValue(this, $$delegatedProperties[2]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection members_delegate$lambda$5(kotlin.reflect.jvm.internal.KPackageImpl kPackageImpl, kotlin.reflect.jvm.internal.KPackageImpl.Data data) {
            return kPackageImpl.getMembers(data.getScope(), kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }
    }

    public KPackageImpl(java.lang.Class<?> jClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        this.data = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KPackageImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KPackageImpl.data$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.KPackageImpl.Data data$lambda$0(kotlin.reflect.jvm.internal.KPackageImpl kPackageImpl) {
        return kPackageImpl.new Data();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    protected java.lang.Class<?> getMethodOwner() {
        java.lang.Class<?> multifileFacade = this.data.getValue().getMultifileFacade();
        return multifileFacade == null ? getJClass() : multifileFacade;
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getScope() {
        return this.data.getValue().getScope();
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public java.util.Collection<kotlin.reflect.KCallable<?>> getMembers() {
        return this.data.getValue().getMembers();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor> getConstructorDescriptors() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getProperties(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return getScope().getContributedVariables(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> getFunctions(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return getScope().getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getLocalProperty(int index) {
        kotlin.Triple<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion> metadata = this.data.getValue().getMetadata();
        if (metadata != null) {
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver jvmNameResolverComponent1 = metadata.component1();
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package packageComponent2 = metadata.component2();
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersionComponent3 = metadata.component3();
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property>> packageLocalVariable = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.packageLocalVariable;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(packageLocalVariable, "packageLocalVariable");
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(packageComponent2, packageLocalVariable, index);
            if (property != null) {
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable typeTable = packageComponent2.getTypeTable();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
                return (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) kotlin.reflect.jvm.internal.UtilKt.deserializeToDescriptor(getJClass(), property, jvmNameResolverComponent1, new kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable(typeTable), metadataVersionComponent3, new kotlin.jvm.functions.Function2() { // from class: kotlin.reflect.jvm.internal.KPackageImpl$$Lambda$1
                    @Override // kotlin.jvm.functions.Function2
                    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                        return kotlin.reflect.jvm.internal.KPackageImpl.getLocalProperty$lambda$3$lambda$2$lambda$1((kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer) obj, (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) obj2);
                    }
                });
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getLocalProperty$lambda$3$lambda$2$lambda$1(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer deserializeToDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deserializeToDescriptor, "$this$deserializeToDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        return deserializeToDescriptor.loadProperty(proto, true);
    }

    public boolean equals(java.lang.Object other) {
        return (other instanceof kotlin.reflect.jvm.internal.KPackageImpl) && kotlin.jvm.internal.Intrinsics.areEqual(getJClass(), ((kotlin.reflect.jvm.internal.KPackageImpl) other).getJClass());
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public java.lang.String toString() {
        return "file class " + kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName();
    }
}
