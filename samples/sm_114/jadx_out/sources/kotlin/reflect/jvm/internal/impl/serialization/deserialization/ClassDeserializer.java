package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassDeserializer {
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> classes;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents components;
    public static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.Companion Companion = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.Companion(null);
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> BLACK_LIST = kotlin.collections.SetsKt.setOf(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.cloneable.toSafe()));

    public ClassDeserializer(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents components) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(components, "components");
        this.components = components;
        this.classes = components.getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.classes$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classes$lambda$0(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer classDeserializer, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return classDeserializer.createClass(key);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor deserializeClass$default(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer classDeserializer, kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData classData, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor deserializeClass(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData classData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        return this.classes.invoke2(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey(classId, classData));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor createClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey classKey) {
        java.lang.Object next;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext deserializationContextCreateContext;
        kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptor;
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = classKey.getClassId();
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> it = this.components.getFictitiousClassDescriptorFactories().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorCreateClass = it.next().createClass(classId);
            if (classDescriptorCreateClass != null) {
                return classDescriptorCreateClass;
            }
        }
        if (BLACK_LIST.contains(classId)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData classData = classKey.getClassData();
        if (classData == null && (classData = this.components.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolverComponent1 = classData.component1();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class classComponent2 = classData.component2();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion binaryVersionComponent3 = classData.component3();
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElementComponent4 = classData.component4();
        kotlin.reflect.jvm.internal.impl.name.ClassId outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorDeserializeClass$default = deserializeClass$default(this, outerClassId, null, 2, null);
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor = classDescriptorDeserializeClass$default instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) classDescriptorDeserializeClass$default : null;
            if (deserializedClassDescriptor == null || !deserializedClassDescriptor.hasNestedClass$deserialization(classId.getShortClassName())) {
                return null;
            }
            deserializationContextCreateContext = deserializedClassDescriptor.getC();
        } else {
            java.util.Iterator<T> it2 = kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt.packageFragments(this.components.getPackageFragmentProvider(), classId.getPackageFqName()).iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                packageFragmentDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) next;
                if (!(packageFragmentDescriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment)) {
                    break;
                }
            } while (!((kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment) packageFragmentDescriptor).hasTopLevelClass(classId.getShortClassName()));
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) next;
            if (packageFragmentDescriptor2 == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents deserializationComponents = this.components;
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable typeTable = classComponent2.getTypeTable();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable2 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable(typeTable);
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion companion = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion;
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable versionRequirementTable = classComponent2.getVersionRequirementTable();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
            deserializationContextCreateContext = deserializationComponents.createContext(packageFragmentDescriptor2, nameResolverComponent1, typeTable2, companion.create(versionRequirementTable), binaryVersionComponent3, null);
            binaryVersionComponent3 = binaryVersionComponent3;
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor(deserializationContextCreateContext, classComponent2, nameResolverComponent1, binaryVersionComponent3, sourceElementComponent4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    static final class ClassKey {
        private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData classData;
        private final kotlin.reflect.jvm.internal.impl.name.ClassId classId;

        public ClassKey(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData classData) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
            this.classId = classId;
            this.classData = classData;
        }

        public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData getClassData() {
            return this.classData;
        }

        public final kotlin.reflect.jvm.internal.impl.name.ClassId getClassId() {
            return this.classId;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey) && kotlin.jvm.internal.Intrinsics.areEqual(this.classId, ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey) obj).classId);
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> getBLACK_LIST() {
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.BLACK_LIST;
        }
    }
}
