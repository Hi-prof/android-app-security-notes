package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: PackagePartScopeCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackagePartScopeCache {
    private final java.util.concurrent.ConcurrentHashMap<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> cache;
    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinder kotlinClassFinder;
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver resolver, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinder kotlinClassFinder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resolver, "resolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.resolver = resolver;
        this.kotlinClassFinder = kotlinClassFinder;
        this.cache = new java.util.concurrent.ConcurrentHashMap<>();
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getPackagePartScope(kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass fileClass) {
        java.util.ArrayList arrayListListOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fileClass, "fileClass");
        java.util.concurrent.ConcurrentHashMap<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> concurrentHashMap = this.cache;
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = fileClass.getClassId();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = concurrentHashMap.get(classId);
        if (memberScope == null) {
            kotlin.reflect.jvm.internal.impl.name.FqName packageFqName = fileClass.getClassId().getPackageFqName();
            if (fileClass.getClassHeader().getKind() == kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                java.util.List<java.lang.String> multifilePartNames = fileClass.getClassHeader().getMultifilePartNames();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.lang.String str : multifilePartNames) {
                    kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
                    kotlin.reflect.jvm.internal.impl.name.FqName fqNameForTopLevelClassMaybeWithDollars = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(fqNameForTopLevelClassMaybeWithDollars, "getFqNameForTopLevelClassMaybeWithDollars(...)");
                    kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, companion.topLevel(fqNameForTopLevelClassMaybeWithDollars), this.resolver.getComponents().getConfiguration().getMetadataVersion());
                    if (kotlinJvmBinaryClassFindKotlinClass != null) {
                        arrayList.add(kotlinJvmBinaryClassFindKotlinClass);
                    }
                }
                arrayListListOf = arrayList;
            } else {
                arrayListListOf = kotlin.collections.CollectionsKt.listOf(fileClass);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), packageFqName);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Iterator it = arrayListListOf.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScopeCreateKotlinPackagePartScope = this.resolver.createKotlinPackagePartScope(emptyPackageFragmentDescriptor, (kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass) it.next());
                if (memberScopeCreateKotlinPackagePartScope != null) {
                    arrayList2.add(memberScopeCreateKotlinPackagePartScope);
                }
            }
            java.util.List list = kotlin.collections.CollectionsKt.toList(arrayList2);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScopeCreate = kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope.Companion.create("package " + packageFqName + " (" + fileClass + com.taobao.weex.el.parse.Operators.BRACKET_END, list);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScopePutIfAbsent = concurrentHashMap.putIfAbsent(classId, memberScopeCreate);
            memberScope = memberScopePutIfAbsent == null ? memberScopeCreate : memberScopePutIfAbsent;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(memberScope, "getOrPut(...)");
        return memberScope;
    }
}
