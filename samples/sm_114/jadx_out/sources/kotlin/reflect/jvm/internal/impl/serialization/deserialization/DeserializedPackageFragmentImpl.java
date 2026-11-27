package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DeserializedPackageFragmentImpl extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment {
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope _memberScope;
    private kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment _proto;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoBasedClassDataFinder classDataFinder;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource containerSource;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion metadataVersion;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl nameResolver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion metadataVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource deserializedContainerSource) {
        super(fqName, storageManager, module);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        this.metadataVersion = metadataVersion;
        this.containerSource = deserializedContainerSource;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable strings = proto.getStrings();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strings, "getStrings(...)");
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable qualifiedNames = proto.getQualifiedNames();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(qualifiedNames, "getQualifiedNames(...)");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl nameResolverImpl = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl(strings, qualifiedNames);
        this.nameResolver = nameResolverImpl;
        this.classDataFinder = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoBasedClassDataFinder(proto, nameResolverImpl, metadataVersion, new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl.classDataFinder$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.ClassId) obj);
            }
        });
        this._proto = proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.SourceElement classDataFinder$lambda$0(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl deserializedPackageFragmentImpl, kotlin.reflect.jvm.internal.impl.name.ClassId it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource deserializedContainerSource = deserializedPackageFragmentImpl.containerSource;
        if (deserializedContainerSource != null) {
            return deserializedContainerSource;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents components) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(components, "components");
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment packageFragment = this._proto;
        if (packageFragment == null) {
            throw new java.lang.IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this._proto = null;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r4 = packageFragment.getPackage();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "getPackage(...)");
        this._memberScope = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope(this, r4, this.nameResolver, this.metadataVersion, this.containerSource, components, "scope of " + this, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl.initialize$lambda$3(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection initialize$lambda$3(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.name.ClassId> allClassIds = deserializedPackageFragmentImpl.getClassDataFinder().getAllClassIds();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : allClassIds) {
            kotlin.reflect.jvm.internal.impl.name.ClassId classId = (kotlin.reflect.jvm.internal.impl.name.ClassId) obj;
            if (!classId.isNestedClass() && !kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.Companion.getBLACK_LIST().contains(classId)) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        java.util.Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((kotlin.reflect.jvm.internal.impl.name.ClassId) it.next()).getShortClassName());
        }
        return arrayList3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = this._memberScope;
        if (memberScope != null) {
            return memberScope;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        return null;
    }
}
