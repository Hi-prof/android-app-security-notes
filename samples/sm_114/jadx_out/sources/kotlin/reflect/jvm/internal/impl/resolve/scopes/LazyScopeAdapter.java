package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: LazyScopeAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyScopeAdapter extends kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter {
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> lazyScope;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter(kotlin.jvm.functions.Function0<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> getScope) {
        this(null, getScope, 1, 0 == true ? 1 : 0);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getScope, "getScope");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LazyScopeAdapter(kotlin.reflect.jvm.internal.impl.storage.StorageManager NO_LOCKS, kotlin.jvm.functions.Function0 function0, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            NO_LOCKS = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NO_LOCKS;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_LOCKS, "NO_LOCKS");
        }
        this(NO_LOCKS, function0);
    }

    public LazyScopeAdapter(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, final kotlin.jvm.functions.Function0<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> getScope) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getScope, "getScope");
        this.lazyScope = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(getScope) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter$$Lambda$0
            private final kotlin.jvm.functions.Function0 arg$0;

            {
                this.arg$0 = getScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter.lazyScope$lambda$1(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope lazyScope$lambda$1(kotlin.jvm.functions.Function0 function0) {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) function0.invoke();
        return memberScope instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter ? ((kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter) memberScope).getActualScope() : memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getWorkerScope() {
        return this.lazyScope.invoke();
    }
}
