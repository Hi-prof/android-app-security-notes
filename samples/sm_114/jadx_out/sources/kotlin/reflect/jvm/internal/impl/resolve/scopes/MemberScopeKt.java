package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberScopeKt {
    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> flatMapClassifierNamesOrNull(java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> it = iterable.iterator();
        while (it.hasNext()) {
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> classifierNames = it.next().getClassifierNames();
            if (classifierNames == null) {
                hashSet = null;
                break;
            }
            kotlin.collections.CollectionsKt.addAll(hashSet, classifierNames);
        }
        return hashSet;
    }
}
