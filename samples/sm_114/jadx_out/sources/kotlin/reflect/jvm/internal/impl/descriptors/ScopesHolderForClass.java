package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: ScopesHolderForClass.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScopesHolderForClass<T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.class, "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion Companion = new kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion(null);
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor;
    private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, T> scopeFactory;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue scopeForOwnerModule$delegate;

    public /* synthetic */ ScopesHolderForClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.jvm.functions.Function1 function1, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, storageManager, function1, kotlinTypeRefiner);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends T> function1, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        this.classDescriptor = classDescriptor;
        this.scopeFactory = function1;
        this.kotlinTypeRefinerForOwnerModule = kotlinTypeRefiner;
        this.scopeForOwnerModule$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.scopeForOwnerModule_delegate$lambda$0(this.arg$0);
            }
        });
    }

    private final T getScopeForOwnerModule() {
        return (T) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.scopeForOwnerModule$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope scopeForOwnerModule_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass scopesHolderForClass) {
        return scopesHolderForClass.scopeFactory.invoke2(scopesHolderForClass.kotlinTypeRefinerForOwnerModule);
    }

    public final T getScope(final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getModule(this.classDescriptor))) {
            return (T) getScopeForOwnerModule();
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = this.classDescriptor.getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return !kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor) ? (T) getScopeForOwnerModule() : (T) kotlinTypeRefiner.getOrPutScopeForClass(this.classDescriptor, new kotlin.jvm.functions.Function0(this, kotlinTypeRefiner) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass arg$0;
            private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = kotlinTypeRefiner;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.getScope$lambda$1(this.arg$0, this.arg$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getScope$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass scopesHolderForClass, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        return scopesHolderForClass.scopeFactory.invoke2(kotlinTypeRefiner);
    }

    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass<T> create(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefinerForOwnerModule, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends T> scopeFactory) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scopeFactory, "scopeFactory");
            return new kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass<>(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }
    }
}
