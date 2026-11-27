package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmBuiltIns extends kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.class, "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue customizer$delegate;
    private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind kind;
    private kotlin.jvm.functions.Function0<kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings> settingsComputation;

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    }

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.FALLBACK.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind kind) {
        super(storageManager);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        this.kind = kind;
        this.customizer$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this, storageManager) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns arg$0;
            private final kotlin.reflect.jvm.internal.impl.storage.StorageManager arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = storageManager;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.customizer_delegate$lambda$5(this.arg$0, this.arg$1);
            }
        });
        int i = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i != 1) {
            if (i == 2) {
                createBuiltInsModule(false);
            } else {
                if (i != 3) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                createBuiltInsModule(true);
            }
        }
    }

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class Settings {
        private final boolean isAdditionalBuiltInsFeatureSupported;
        private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor ownerModuleDescriptor;

        public Settings(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor ownerModuleDescriptor, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = ownerModuleDescriptor;
            this.isAdditionalBuiltInsFeatureSupported = z;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getOwnerModuleDescriptor() {
            return this.ownerModuleDescriptor;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.isAdditionalBuiltInsFeatureSupported;
        }
    }

    public final void setPostponedSettingsComputation(kotlin.jvm.functions.Function0<kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings> computation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(computation, "computation");
        this.settingsComputation = computation;
    }

    public final void initialize(final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, final boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        setPostponedSettingsComputation(new kotlin.jvm.functions.Function0(moduleDescriptor, z) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor arg$0;
            private final boolean arg$1;

            {
                this.arg$0 = moduleDescriptor;
                this.arg$1 = z;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.initialize$lambda$1(this.arg$0, this.arg$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings initialize$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, boolean z) {
        return new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings(moduleDescriptor, z);
    }

    public final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer getCustomizer() {
        return (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.customizer$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer customizer_delegate$lambda$5(final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns jvmBuiltIns, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl builtInsModule = jvmBuiltIns.getBuiltInsModule();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtInsModule, "getBuiltInsModule(...)");
        return new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer(builtInsModule, storageManager, new kotlin.jvm.functions.Function0(jvmBuiltIns) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns arg$0;

            {
                this.arg$0 = jvmBuiltIns;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.customizer_delegate$lambda$5$lambda$4(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings customizer_delegate$lambda$5$lambda$4(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns jvmBuiltIns) {
        kotlin.jvm.functions.Function0<kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings> function0 = jvmBuiltIns.settingsComputation;
        if (function0 != null) {
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings settingsInvoke = function0.invoke();
            jvmBuiltIns.settingsComputation = null;
            return settingsInvoke;
        }
        throw new java.lang.AssertionError("JvmBuiltins instance has not been initialized properly");
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> getClassDescriptorFactories() {
        java.lang.Iterable<kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> classDescriptorFactories = super.getClassDescriptorFactories();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(classDescriptorFactories, "getClassDescriptorFactories(...)");
        kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = getStorageManager();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(storageManager, "getStorageManager(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl builtInsModule = getBuiltInsModule();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtInsModule, "getBuiltInsModule(...)");
        return kotlin.collections.CollectionsKt.plus(classDescriptorFactories, new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory(storageManager, builtInsModule, null, 4, null));
    }
}
