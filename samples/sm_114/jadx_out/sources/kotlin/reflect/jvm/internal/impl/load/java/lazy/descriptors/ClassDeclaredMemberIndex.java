package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ClassDeclaredMemberIndex implements kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex {
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent> components;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField> fields;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass;
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> memberFilter;
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod, java.lang.Boolean> methodFilter;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod>> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> memberFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jClass, "jClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(memberFilter, "memberFilter");
        this.jClass = jClass;
        this.memberFilter = memberFilter;
        kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod, java.lang.Boolean> function1 = new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex.methodFilter$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) obj));
            }
        };
        this.methodFilter = function1;
        kotlin.sequences.Sequence sequenceFilter = kotlin.sequences.SequencesKt.filter(kotlin.collections.CollectionsKt.asSequence(jClass.getMethods()), function1);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.lang.Object obj : sequenceFilter) {
            kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) obj).getName();
            java.lang.Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = (java.util.List) new java.util.ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((java.util.List) obj2).add(obj);
        }
        this.methods = linkedHashMap;
        kotlin.sequences.Sequence sequenceFilter2 = kotlin.sequences.SequencesKt.filter(kotlin.collections.CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap();
        for (java.lang.Object obj3 : sequenceFilter2) {
            linkedHashMap2.put(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField) obj3).getName(), obj3);
        }
        this.fields = linkedHashMap2;
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> function2 = this.memberFilter;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj4 : recordComponents) {
            if (function2.invoke2((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember) obj4).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.LinkedHashMap linkedHashMap3 = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (java.lang.Object obj5 : arrayList2) {
            linkedHashMap3.put(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent) obj5).getName(), obj5);
        }
        this.components = linkedHashMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean methodFilter$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex classDeclaredMemberIndex, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod m) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(m, "m");
        return classDeclaredMemberIndex.memberFilter.invoke2(m).booleanValue() && !kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt.isObjectMethodInInterface(m);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod> findMethodsByName(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod> list = this.methods.get(name);
        return list != null ? list : kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getMethodNames() {
        kotlin.sequences.Sequence sequenceFilter = kotlin.sequences.SequencesKt.filter(kotlin.collections.CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField findFieldByName(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return this.fields.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFieldNames() {
        kotlin.sequences.Sequence sequenceFilter = kotlin.sequences.SequencesKt.filter(kotlin.collections.CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getRecordComponentNames() {
        return this.components.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent findRecordComponentByName(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return this.components.get(name);
    }
}
